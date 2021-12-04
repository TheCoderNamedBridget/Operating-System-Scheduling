/**
 * FCFS scheduling algorithm.
 */
 
import java.util.*;

//Your code here
class FCFS implements Algorithm
{
	List<Task> list = new ArrayList<Task>();
	int indexCur = 0; 
	FCFS ( List<Task> q )
	{
		list = q;
	}

	@Override
	public void schedule()
	{
		for ( int i = 0; i < list.size(); i ++ )
		{
			indexCur = i;
			Task t = pickNextTask();
			CPU.run(t, t.getBurst());
			
		}
	}

	@Override
	public Task pickNextTask() 
	{
		
		return list.get(indexCur);
	}
}