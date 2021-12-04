/**
 * Non-preemptive priority scheduling algorithm.
 */
 
import java.util.*;

// Your code here
class Priority implements Algorithm
{
	List<Task> list = new ArrayList<Task>();
	int endIndex = 0;
	Priority ( List<Task> q )
	{
		list = q;
		endIndex = list.size();
	}

	@Override
	public void schedule() 
	{
		for ( int i = 0; i < list.size(); i++ )
		{
			Task t = pickNextTask();
			CPU.run(t, t.getBurst());
		}
	}

	@Override
	public Task pickNextTask() 
	{
		int highestPriorityIndex = 0;
		for ( int i = 0; i < endIndex; i++ )
		{
			if ( list.get(i).getPriority() <= list.get(highestPriorityIndex).getPriority() )
			{
				highestPriorityIndex = i;
			}
		}
		Task temp = list.get(highestPriorityIndex);
		list.set(highestPriorityIndex, list.get(endIndex- 1));
		list.set(endIndex- 1, temp);
		endIndex--;
		return list.get(endIndex);
	}
}