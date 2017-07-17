public class MainClass 
{
	public static void main(String[] args) 
	{
		// generate an array
		int size = 25;
		int[] unsorted = new int[size];
		
		ArrayGenerator helpArray = new ArrayRandom(size);
		int arrayType = 1; //default - random, otherwise 2-6 chosen type

		
		switch(arrayType) 
		{
		case 1: break;
		case 2: helpArray = new ArrayIncreasing(size); 
				break;
		case 3: helpArray = new ArrayDecreasing(size); 
				break;
		case 4: helpArray = new ArrayAShape(size); 
				break;
		case 5: helpArray = new ArrayVShape(size); 
				break;
		case 6: helpArray = new ArrayConstant(size); 
				break;
		}
		
		unsorted = helpArray.getAndPrintArray();
		
		boolean all = false;
		int sortingType = 0; // 0 - all, 1-4 - chosen method
		if (sortingType==0) 
		{
			sortingType = 1; 
			all = true;
		}
		
		switch(sortingType)
		{
		case 1:		SorterInsertion sortIS = new SorterInsertion(unsorted,size);
					sortIS.measureSortingTimeDisplayResults();
					if(!all) break;
		case 2:		SorterSelection sortSS = new SorterSelection(unsorted,size);
					sortSS.measureSortingTimeDisplayResults();
					if(!all) break;
		case 3:		SorterHeap sortHS = new SorterHeap(unsorted,size);
					sortHS.measureSortingTimeDisplayResults();	
					if(!all) break;
		case 4:		SorterMerge sortMS = new SorterMerge(unsorted,size);
					sortMS.measureSortingTimeDisplayResults();
					if(!all) break;
		}


	}
}
