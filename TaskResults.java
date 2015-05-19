import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/*
 * This class represents a container of TaskResult objects.  The
 * methods are static as only one container is assumed.  However,
 * depending on the context of the use of this code, these might
 * be made non-static so that separate containers of TaskResult objects
 * could be used for Tasks grouped according to separate functions, etc.  
 */
public class TaskResults {

	
	private static Map<Integer, TaskResult> taskResultsMap =
	    new HashMap<Integer, TaskResult>();
	
	public static TaskResult result( int guid ) {
		
		return taskResultsMap.get( guid );
	}
	
	public static List<TaskResult> results( List<Integer> guid_list ) {
		
		List<TaskResult> retVal = new LinkedList<TaskResult>();
		
		for ( int i = 0; i < guid_list.size(); ++i ) {
			
			retVal.add( taskResultsMap.get( guid_list.get( i ) ) );
			
		}
		
		return retVal;
		
	}
	
	public static void addTaskResult( int guid, TaskResult aResult ) {
		
		taskResultsMap.put( guid, aResult );
		
	}
	
}
