public abstract class Sorter 
{
	public String sorterName = new String();
	private long start, stop, time;
	public int[] unsorted;
	public int size;
	
	public Sorter(int[] givenArray, int givenSize)
	{
		unsorted = givenArray;
		size = givenSize;
	}
	
	private void startTime()
	{
		start = System.nanoTime();
	}
	
	private void printStartTime()
	{
		System.out.println("Start time is " + start);
	}
	
	private void stopTime()
	{
		stop = System.nanoTime();
		time = stop - start;
	}
	
	private void printStopTime()
	{
		System.out.println("Stop time is " + stop);
	}
	
	public abstract void sort();
	
	public void swap(int number1, int number2)
	{
		int help = unsorted[number1];
		unsorted[number1] = unsorted[number2];
		unsorted[number2] = help;
	}
	
	private void print()
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
		startTime();
		sort(); //sort given array		
		stopTime();	
		
		printStartTime();
		printStopTime();
		print(); //print sorted array + time
	}
}