public class Compare 
{
	public static void main(String[] args) 
	{
		// generate a random array
		int size = 25;
		int[] unsorted = new int[size];
		
		ArrayGenerator randomArray = new ArrayGenerator(size);
		unsorted = randomArray.getAndPrintArray();
		
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
