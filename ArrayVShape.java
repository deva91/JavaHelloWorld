public class ArrayVShape implements ArrayGenerator
{
	public int size = 25;
	public int[] unsorted = new int[size];
	
	public ArrayVShape(int size)
	{
		this.size = size;
	}
	
	public int[] getAndPrintArray()
	{
		for(int i=size/2;i>0;i--)
			unsorted[size/2-i] = i;
		for(int i=0;i<=size/2;i++)
			unsorted[size/2+i] = i;
		printArray();
		return unsorted;
	}	
		
	public void printArray()
	{	
		System.out.println("We have an unsorted array of " + size + " elements in V-shape order of value between 0 and " + size/2);
	
		// display unsorted array if not more than 50 elements
		if(size<=50)
		{
			for(int j : unsorted)
				System.out.print(j + " ");
			System.out.println("\n");
		}
	}
}