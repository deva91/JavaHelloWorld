public class ArrayIncreasing implements ArrayGenerator
{
	public int size;
	public int[] unsorted;
	
	public ArrayIncreasing(int size)
	{
		this.size = size;
		unsorted = new int[size];
	}
	
	public int[] getAndPrintArray()
	{
		for(int i=0;i<size;i++)
			unsorted[i] = i;
		printArray();
		return unsorted;
	}	
		
	public void printArray()
	{	
		System.out.println("\nWe have an unsorted array of " + size + " elements in increasing order of value between 0 and " + (size-1));
	
		// display unsorted array if not more than 50 elements
		if(size<=50)
		{
			for(int j : unsorted)
				System.out.print(j + " ");
			System.out.println("\n");
		}
	}
}