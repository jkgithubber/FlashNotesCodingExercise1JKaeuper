import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class Task {

	private String description;
	
	private int GUID;
	
	private String command;
	
	private static int GUID_COUNT = 0;
	
	public Task( String desc, String cmd ) {
		
		description = desc;
		
		command = cmd;
	
		GUID = ++GUID_COUNT;
		
		// the Task is newly created, so its result has a "Ready" state
		TaskResult theResult = new TaskResult( GUID, "Ready", false, 1, "", "", 0 );
		
		TaskResults.addTaskResult( GUID, theResult );
	}
	
	public void execute() {
		
		// the Task is now executing, but has not completed yet, so its result
		// is Pending
		TaskResult theResult = new TaskResult( GUID, "Pending", false, 1, "", "", 0 );
		TaskResults.addTaskResult( GUID, theResult );
		
		Process subProcess = null;
		long startTime = 0;
	    long endTime = 0;
		
		try {
			
			startTime = System.currentTimeMillis(); 
		    subProcess = Runtime.getRuntime().exec( command );
		    subProcess.waitFor();
		    endTime = System.currentTimeMillis();
		    
		} catch ( IOException | InterruptedException e ) {
			
            endTime = System.currentTimeMillis();
			
			// the Task's result status is now "Complete", even though an 
			// Exception occurred;
            // since an Exception occurred while executing the Task, we 
            // use e.getMessage() to put the Exception message into the TaskResult
			theResult = new TaskResult( GUID, "Complete", false, 1, "", e.getMessage(), 0 );
			
			
		}
		    
		// gather all lines of standard output from the Task so that they may
		// be recorded in the below "Complete"-status TaskResult
		String procOutput = "";
		try {
		    BufferedReader procReader =
		        new BufferedReader( new InputStreamReader( subProcess.getInputStream() ) );
		    String procOutputLine = "";
		    
		    while ( ( procOutputLine = procReader.readLine() ) != null ) {
		    	procOutput += procOutputLine;	
		    }
		    
		} catch ( IOException e ) {
			
			e.printStackTrace();
		}
		
		// the Task's result status is now "Complete", regardless of whether
		// it succeeded
		if ( subProcess.exitValue() == 0 ) {
		    
		    theResult = new TaskResult( GUID, "Complete", true, subProcess.exitValue(),
		        procOutput, "", endTime - startTime );
		    TaskResults.addTaskResult( GUID, theResult );
		        
		} else {
		    	
		    theResult = new TaskResult( GUID, "Complete", false, subProcess.exitValue(),
				procOutput, "", endTime - startTime );
		}
		    
		   
	}
	
	public int getGUID() {
		
		return GUID;
	}
	
}
