import java.util.Random;

public class ArrayConstant implements ArrayGenerator
{
	public int size = 25;
	public int[] unsorted = new int[size];
	private Random rand = new Random();
	private int x = rand.nextInt(size);
	
	public ArrayConstant(int size)
	{
		this.size = size;
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
		System.out.println("We have an unsorted array of " + size + " equal elements of value " + x);
	
		// display unsorted array if not more than 50 elements
		if(size<=50)
		{
			for(int j : unsorted)
				System.out.print(j + " ");
			System.out.println("\n");
		}
	}
}