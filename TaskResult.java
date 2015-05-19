
public class TaskResult {

	private int task_guid;
	
	/*
	 * There are 3 states which a TaskResult may have:
	 * - READY - the corresponding Task has been created, but has not
	 *           begun yet
	 * - PENDING - the corresponding Task is currently executing, so
	 *             its result is not known yet
	 * - COMPLETED - the corresponding Task is finished; it may or may
	 *               not have succeeded
	 */
	private String task_status;
	
	private boolean succeeded;
	
	private int return_code;
	
	private String output;
	
	private String exception;
	
	private long execution_duration;
	
	public TaskResult( int theGuid, String taskStatus, boolean success, 
	    int ret_code, String theOutput, String theException, long exec_duration ) {
		
		task_guid = theGuid;
		
		task_status = taskStatus;
		
		succeeded = success;
		
		return_code = ret_code;
		
		output = theOutput;
		
		exception = theException;
		
		execution_duration = exec_duration;
		
	}
	
	public boolean succeeded() {
		
		return succeeded;
	}
	
}
