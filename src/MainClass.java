import java.util.Scanner;

public class MainClass 
{
			
	public static void main(String[] args) 
	{
		String[] arrayTypeNames = {"All","Random","Increasing","Decreasing","A-shape","V-shape","Constant"};
		
		System.out.println("Hello. This program sorts an array and provide you time of sorting."
				+"\nIt can also compare time between different sorting methods."
				+"\nPlease provide size of the array that will be sorted. Type integer number bigger than 0.");
		
		Scanner values = new Scanner(System.in);
		int size = 0;
		
		boolean noException = false;
		while(!noException)
		{
			try
			{
				size = values.nextInt();
				
				if (size == (int)size)
				{
					if (size <= 0)
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
		
		int[] unsorted = new int[size];
		
		ArrayGenerator helpArray = new ArrayRandom(size);
		int arrayType = 1; //default - random, otherwise 2-6 chosen type
	
		System.out.println("\nPlease choose array type. Type integer number between 1 and 6."
				+ "\n1. "+arrayTypeNames[1]
				+ "\n2. "+arrayTypeNames[2]
				+ "\n3. "+arrayTypeNames[3]
				+ "\n4. "+arrayTypeNames[4]
				+ "\n5. "+arrayTypeNames[5]
				+ "\n6. "+arrayTypeNames[6]);
		
		noException = false;
		while(!noException)
		{
			try
			{
				arrayType = values.nextInt();
			
				if (arrayType == (int)arrayType)
				{
					if (arrayType <= 0 || arrayType >6)
						throw new Exception();
				}
				else
					throw new Exception();
				
				noException = true;
			}
			catch (Exception exception)
			{
				System.out.println("Wrong input. Try again.");
				values.nextLine();
				continue;
			}
		}
		
		System.out.println("You have chosen number " + arrayType + ". " + arrayTypeNames[arrayType] + " array will be created.");
		values.close();
		
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
