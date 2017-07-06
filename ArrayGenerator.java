import java.util.Random;

public class ArrayGenerator 
{
	public int size = 25;
	public int range = 1000;
	public int[] unsorted = new int[size];
	
	public ArrayGenerator(int size)
	{
		this.size = size;
	}
	
	public int[] getAndPrintArray()
	{
		for(int i=0;i<size;i++)
			{
			Random x = new Random();
			unsorted[i] = x.nextInt(range);
			}
		printArray();
		return unsorted;
	}	
		
	private void printArray()
	{	
		System.out.println("We have an unsorted array of " + size + " random elements of value between 0 and " + range);
	
		// display unsorted array if not more than 50 elements
		if(size<=50)
		{
			for(int j : unsorted)
				System.out.print(j + " ");
			System.out.println("\n");
		}
	}
}
