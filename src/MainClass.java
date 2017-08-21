import java.util.Scanner;

public class MainClass 
{
			
	public static void main(String[] args) 
	{
		String[] arrayTypeNames = {"All","Random","Increasing","Decreasing","A-shape","V-shape","Constant"};
		
		System.out.println("Hello. This program sorts an array and provide you time of sorting."
				+"\nIt can also compare time between different sorting methods."
				+"\nPlease provide size of the array that will be sorted. Type integer number between 1 and 500 000.");
		
		Scanner values = new Scanner(System.in);
		
		int size = scanInputWithNoExceptions(values,1,500000);
		int[] unsorted = new int[size];
	
		System.out.println("\nPlease choose array type. Type integer number between 1 and 6."
				+ "\n1. "+arrayTypeNames[1]
				+ "\n2. "+arrayTypeNames[2]
				+ "\n3. "+arrayTypeNames[3]
				+ "\n4. "+arrayTypeNames[4]
				+ "\n5. "+arrayTypeNames[5]
				+ "\n6. "+arrayTypeNames[6]);
		
		int arrayType = scanInputWithNoExceptions(values,1,6);
		
		System.out.println("You have chosen number " + arrayType + ". " + arrayTypeNames[arrayType] + " array will be created.");
		
		ArrayGenerator helpArray = new ArrayRandom(size);

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
		
		System.out.println("Please choose sorting method."
				+ "\n0. All"
				+ "\n1. Insertion Sort"
				+ "\n2. Selection Sort"
				+ "\n3. Heap Sort"
				+ "\n4. Merge Sort");
		
		boolean all = false;
		int sortingType = scanInputWithNoExceptions(values,0,4); // 0 - all, 1-4 - chosen method
		
		values.close();
		
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
	
	private static int scanInputWithNoExceptions(Scanner values, int min, int max)
	{
		boolean noException = false;
		int input=0;
		
		while(!noException)
		{
			try
			{
				input = values.nextInt();
				
				if (input == (int)input)
				{
					if (input < min || input > max)
						throw new Exception();
					noException = true;
				}
				else
				{
					throw new Exception();
				}
			}
			catch (Exception exception)
			{	
				System.out.println("Input is not correct. Try again.");
				values.nextLine();
				continue;
			}
		}

		return input;
	}
	
}

