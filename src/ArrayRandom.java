import java.util.Random;

class ArrayRandom implements ArrayGenerator
{
	public int size;
	public int range = 100;
	public int[] unsorted;
	
	public ArrayRandom(int size)
	{
		this.size = size;
		unsorted = new int[size];
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
		
	public void printArray()
	{	
		System.out.println("\nWe have an unsorted array of " + size + " random elements of value between 0 and " + range);
	
		// display unsorted array if not more than 50 elements
		if(size<=50)
		{
			for(int j : unsorted)
				System.out.print(j + " ");
			System.out.println("\n");
		}
	}
}
