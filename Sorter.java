public abstract class Sorter 
{
	public String sorterName = new String();
	public long start;
	public long stop;
	public long time;
	public int[] unsorted;
	public int size;
	
	public Sorter(int[] givenArray, int givenSize)
	{
		start = 0;
		stop = 0;
		time = 0;
		unsorted = givenArray;
		size = givenSize;
	}
	
	public void startTime()
	{
		start = System.nanoTime();
	}
	
	public void printStartTime()
	{
		System.out.println("Start time is " + start);
	}
	
	public void stopTime()
	{
		stop = System.nanoTime();
		time = stop - start;
	}
	
	public void printStopTime()
	{
		System.out.println("Stop time is " + stop);
	}
	
	public long getTime()
	{
		return time;
	}
	
	public abstract void sort();
	
	public int[] getSorted() //returns sorted array
	{
		sort();
		return unsorted;
	}
	
	public void swap(int number1, int number2)
	{
		int help = unsorted[number1];
		unsorted[number1] = unsorted[number2];
		unsorted[number2] = help;
	}
	
	public void print()
	{
		System.out.println("Sorting time in nanoseconds: " + time);
		/* display sorted array only if not more than 50 elements */
		if (size<=50)
		{
			System.out.println("Here is the sorted array:");
			for(int k:unsorted)
				System.out.print(k + " ");
			System.out.println("\n");
		}
	}
	
	public void measureSortingTimeDisplayResults()
	{
		System.out.println("This is the result of " + sorterName + "Sorter:");
		
		this.startTime();
		this.sort(); //sort given array		
		this.stopTime();	
		
		this.printStartTime();
		this.printStopTime();
		this.print(); //print sorted array + time
	}
}
