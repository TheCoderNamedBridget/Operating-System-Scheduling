/**
 * SJF preemptive scheduling algorithm.
 */
 
import java.util.*;

//Your code here
class SJF implements Algorithm
{
	List<Task> list = new ArrayList<Task>();
	int endIndex = 0;
	SJF ( List<Task> q )
	{
		list = q;
		endIndex = list.size();
	}

	@Override
	public void schedule() 
	{
		for ( int i = 0; i < list.size(); i++ )
		{
			System.out.println(pickNextTask().toString());
		}
	}

	@Override
	public Task pickNextTask() 
	{
		int shortestBurstIndex = 0;
		for ( int i = 0; i < endIndex; i++ )
		{
			if ( list.get(i).getBurst() <= list.get(shortestBurstIndex).getBurst() )
			{
				shortestBurstIndex = i;
			}
		}
		Task temp = list.get(shortestBurstIndex);
		list.set(shortestBurstIndex, list.get(endIndex- 1));
		list.set(endIndex- 1, temp);
		endIndex--;
		return list.get(endIndex);
	}
}