import java.util.Random;

public class Compare 
{
	public static void main(String[] args) 
	{
		// create a random array
		int size = 50;
		int[] unsorted = new int[size];
		for(int i=0;i<size;i++)
			{
			Random x = new Random();
			unsorted[i] = x.nextInt(1000);
			}
		System.out.println("We have an unsorted array of " + size + " random elements of value between 0 and 1000");
		/* display unsorted array if not more than 50 elements */
		if(size<=50)
		{
			for(int j : unsorted)
				System.out.print(j + " ");
			System.out.println();
		}
		System.out.println("Let's sort it.\n");
		
		//create object that will be sorted with Insertion Sort
		InsertionSorter sortIS = new InsertionSorter(unsorted,size);
		sortIS.measureSortingTimeDisplayResults();
		
		//create object that will be sorted with Selection Sort
		SelectionSorter sortSS = new SelectionSorter(unsorted,size);
		sortSS.measureSortingTimeDisplayResults();
		
		//create object that will be sorted with Heap Sort
		HeapSorter sortHS = new HeapSorter(unsorted,size);
		sortHS.measureSortingTimeDisplayResults();		
	}
}
