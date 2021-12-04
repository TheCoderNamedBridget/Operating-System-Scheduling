/**
 * Non-preemptive priority scheduling algorithm using RR.
 *
 * This algorithm will run tasks according to round-robin scheduling.
 */
 
import java.util.*;

// Your code here
class RR implements Algorithm
{
	private final int timeSlot = 3;
	List<Task> list = new ArrayList<Task>();
	int jobsCompleted = 0;
	int curJobIndex = 0;
	RR ( List<Task> q)
	{
		list = q;
	}

	@Override
	public void schedule() 
	{
		while ( jobsCompleted != list.size() - 1 )
		{
			for ( int i = 0; i < list.size(); i++ )
			{
				int burstTime = list.get(i).getBurst();
				curJobIndex = i;
				if ( burstTime > 0 )
				{
					Task t = pickNextTask();
					CPU.run(t, timeSlot);
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