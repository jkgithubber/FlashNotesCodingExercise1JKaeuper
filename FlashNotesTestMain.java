
public class FlashNotesTestMain {

	public static void main( String[] args ) {
		
		TaskQueue simple_tasks = new TaskQueue();
		
		simple_tasks.push(
	        new Task( "My first task", 
				      "ping -c 3 google-public-dns-a.google.com" ) );
		
		simple_tasks.push(
		    new Task( "My second task", 
					  "ping -c 3 google-public-dns-a.google.com" ) );		             

		while ( simple_tasks.count() > 0 ) {
			
			Task t = simple_tasks.pop();
			System.out.println( "Running task " + t.getGUID() );
			t.execute();
			
			TaskResult tResult = TaskResults.result( t.getGUID() );
			
			System.out.println( "Task result: " + tResult.succeeded() );
		}
		
	}

}
