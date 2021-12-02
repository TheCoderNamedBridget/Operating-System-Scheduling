/**
 * preemptive priority scheduling algorithm.
 */
 
import java.util.*;

// Your code here
class PriorityRR implements Algorithm
{
	private final int timeSlot = 3;
	List<Task> list = new ArrayList<Task>();
	int jobsCompleted = 0;
	int curJobIndex = 0;
	PriorityRR ( List<Task> q)
	{
		list = q;
	}
	
	public void badSort()
	{
		boolean swapped = true;
		while ( swapped )
		{
			swapped = false;
			for ( int i = 0; i < list.size() -1; i++ )
			{
				if ( list.get(i).getPriority() > list.get(i + 1).getPriority() )
				{
					swapped = true;
					Task temp = list.get(i);
					list.set(i, list.get(i+1));
					list.set(i+1, temp);
				}
			}
		}
	}

	@Override
	public void schedule() {
		badSort();
//		for ( int i = 0; i < list.size(); i++ )
//		{
//			System.out.println(list.get(i).toString());
//		}
//		System.out.println("STARTS REAL HERE");
		while ( jobsCompleted != list.size() - 1 )
		{
			for ( int i = 0; i < list.size(); i++ )
			{
				int burstTime = list.get(i).getBurst();
				curJobIndex = i;
				if ( burstTime > 0 )
				{
					System.out.println(pickNextTask().toString());
				}
			}
		}
		
	}

	@Override
	public Task pickNextTask() {
		list.get(curJobIndex).setBurst(list.get(curJobIndex).getBurst() - timeSlot);

		return list.get(curJobIndex);
	}
}