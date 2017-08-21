public class ArrayAShape implements ArrayGenerator
{
	public int size;
	public int[] unsorted;
	
	public ArrayAShape(int size)
	{
		this.size = size;
		unsorted = new int[size];
	}
	
	public int[] getAndPrintArray()
	{
		for(int i=0;i<=size/2;i++)
			unsorted[i] = i;
		for(int i=size/2;i>0;i--)
			unsorted[size-i] = i;
		printArray();
		return unsorted;
	}	
		
	public void printArray()
	{	
		System.out.println("\nWe have an unsorted array of " + size + " elements in A-shape order of value between 0 and " + size/2);
	
		// display unsorted array if not more than 50 elements
		if(size<=50)
		{
			for(int j : unsorted)
				System.out.print(j + " ");
			System.out.println("\n");
		}
	}
}
