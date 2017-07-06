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

public abstract class Sorter 
{
	public String sorterName = new String();
	public long start;
	public long stop;
	public long time;
	public int[] unsorted;
	public int size;
	
	public Sorter(int[] givenArray, int givenSize)
	{
		start = 0;
		stop = 0;
		time = 0;
		unsorted = givenArray;
		size = givenSize;
	}
	
	public void startTime()
	{
		start = System.nanoTime();
	}
	
	public void printStartTime()
	{
		System.out.println("Start time is " + start);
	}
	
	public void stopTime()
	{
		stop = System.nanoTime();
		time = stop - start;
	}
	
	public void printStopTime()
	{
		System.out.println("Stop time is " + stop);
	}
	
	public long getTime()
	{
		return time;
	}
	
	public abstract void sort();
	
	public int[] getSorted() //returns sorted array
	{
		sort();
		return unsorted;
	}
	
	public void swap(int number1, int number2)
	{
		int help = unsorted[number1];
		unsorted[number1] = unsorted[number2];
		unsorted[number2] = help;
	}
	
	public void print()
	{
		System.out.println("Sorting time in nanoseconds: " + time);
		/* display sorted array only if not more than 50 elements */
		if (size<=50)
		{
			System.out.println("Here is the sorted array:");
			for(int k:unsorted)
				System.out.print(k + " ");
			System.out.println("\n");
		}
	}
	
	public void measureSortingTimeDisplayResults()
	{
		System.out.println("This is the result of " + sorterName + "Sorter:");
		
		this.startTime();
		this.sort(); //sort given array		
		this.stopTime();	
		
		this.printStartTime();
		this.printStopTime();
		this.print(); //print sorted array + time
	}
}

public class InsertionSorter extends Sorter
{
	public InsertionSorter(int[] unsortedIS, int sizeIS)
	{
		super(unsortedIS,sizeIS);
		this.sorterName = "Insertion ";
	}
	
	public void sort() //just sorts given array
	{
		for (int i=1;i<size;i++)
		{
			int key = unsorted[i];
			int j = i-1;
			while(j>=0 && unsorted[j]>key)
			{
				unsorted[j+1]=unsorted[j];
				j--;
			}
			unsorted[j+1]=key;
		}
	}
}

public class SelectionSorter extends Sorter
{
	public SelectionSorter(int[] unsortedSS, int sizeSS)
	{
		super(unsortedSS,sizeSS);
		this.sorterName = "Selection ";
	}
	
	public void sort() //just sorts given array
	{
		for (int j=size-1;j>=1;j--)
		{
			int max = j;
			for (int i=j-1;i>=0;i--)
			{
				if (unsorted[i]>unsorted[max])
					max = i;
			}
			swap(j,max);
		}
	}
}

public class HeapSorter extends Sorter
{
	public HeapSorter(int[] unsortedHS, int sizeHS)
	{
		super(unsortedHS,sizeHS);
		this.sorterName = "Heap ";
	}
	
	public void sort()
	{
		buildHeap();
		int heapsize = size-1;
		for (int i=size-1;i>=1;i--)
		{
			swap(0,i);
			heapsize--;
			heapify(0,heapsize);
		}
	}
	
	public void buildHeap()
	{
		for (int j=(size-1)/2;j>=0;j--)
			heapify(j,size-1);		
	}
	
	public void heapify(int index, int sizeH)
	{
		int max;
		int left = 2 * index;
		int right = 2 * index + 1;
		if (left<=sizeH && unsorted[left]>unsorted[index])
			max = left;
		else
			max = index;
		if(right<=sizeH && unsorted[right]>unsorted[max])
			max = right;
		if(max!=index)
		{
			swap(index,max);
			heapify(max,sizeH);
		}
	}
}
