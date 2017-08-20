import java.util.Random;

public class ArrayConstant implements ArrayGenerator
{
	public int size;
	public int[] unsorted;
	private Random rand = new Random();
	private int x;
	
	public ArrayConstant(int size)
	{
		this.size = size;
		unsorted = new int[size];
		x = rand.nextInt(size);
	}
	
	public int[] getAndPrintArray()
	{
		for(int i=0;i<size;i++)
			unsorted[i]=x;
		printArray();
		return unsorted;
	}	
		
	public void printArray()
	{	
		System.out.println("\nWe have an unsorted array of " + size + " equal elements of value " + x);
	
		// display unsorted array if not more than 50 elements
		if(size<=50)
		{
			for(int j : unsorted)
				System.out.print(j + " ");
			System.out.println("\n");
		}
	}
}