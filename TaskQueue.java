import java.util.LinkedList;
import java.util.List;


public class TaskQueue {

	private List<Task> theTaskQueue;
	
	public TaskQueue() {
		
		theTaskQueue = new LinkedList<Task>();
		
	}
	
	public void push( Task aTask ) {
		
		theTaskQueue.add( aTask );
		
	}
	
	public Task pop() {
	
		return theTaskQueue.remove( 0 );
		
	}
	
	public List<Task> peek_all() {
		
		return theTaskQueue;
	}
	
	public Task peek_next() {
		
		Task retVal = null;
		
		if ( theTaskQueue.size() >= 0 ) {
			
			retVal = theTaskQueue.get( 0 );
		}
		
		return retVal;
		
	}
	
	public int count() {
		
		return theTaskQueue.size();
	}
	
}
