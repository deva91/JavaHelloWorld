import java.util.Random;

public class Compare 
{

	public static void main(String[] args) 
	{
		// create a random array
		int size = 200;
		int[] unsorted = new int[size];
		for(int i=0;i<size;i++)
			{
			Random x = new Random();
			unsorted[i] = x.nextInt(1000);
			}
		System.out.println("We have an unsorted array of " + size + " random elements of value between 0 and 1000");
		/* display unsorted array
		for(int j : unsorted)
			System.out.print(j + " ");
		System.out.println();
		*/
		System.out.println("Let's sort it.\n");
		
		//create object that will be sorted with Insertion Sort
		InsertionSortTimeMeasure sortIS = new InsertionSortTimeMeasure(unsorted,size);
		
		sortIS.startTime();
		sortIS.sort(); //sort given array		
		sortIS.stopTime();	
		
		sortIS.printStartTime();
		sortIS.printStopTime();
		sortIS.print(); //print sorted array + time
	
		//create object that will be sorted with Selection Sort
		SelectionSortTimeMeasure sortSS = new SelectionSortTimeMeasure(unsorted,size);
		
		sortSS.startTime();
		sortSS.sort(); //sort given array
		sortSS.stopTime();
		
		sortSS.printStartTime();
		sortSS.printStopTime();
		sortSS.print();  //print sorted array + time
		
		//create object that will be sorted with Heap Sort
		HeapSortTimeMeasure sortHS = new HeapSortTimeMeasure(unsorted,size);
		
		sortHS.startTime();
		sortHS.sort(); //sort given array
		sortHS.stopTime();
		
		sortHS.printStartTime();
		sortHS.printStopTime();
		sortHS.print();  //print sorted array + time		
				
	}
}



public class TimeMeasure {
	
	public long start;
	public long stop;
	public long time;
	public int[] unsorted;
	public int size;
	
	public TimeMeasure(int[] givenArray, int givenSize)
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

}

public class InsertionSortTimeMeasure extends TimeMeasure
{
	
	public InsertionSortTimeMeasure(int[] unsortedIS, int sizeIS)
	{
		super(unsortedIS,sizeIS);
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
	
	public int[] getSorted() //returns sorted array
	{
		sort();
		return unsorted;
	}
	
	public void print() //prints sorted array and sorting time
	{
		/*
		System.out.println("Here is the result after using Insertion Sort:");
		for(int k : unsorted)
			System.out.print(k + " ");
		System.out.println();
		*/
		System.out.println("Sorting time with Insertion Sort algorithm in nanoseconds: "+time+"\n");
		
	}

}


public class SelectionSortTimeMeasure extends TimeMeasure
{
	
	public SelectionSortTimeMeasure(int[] unsortedSS, int sizeSS)
	{
		super(unsortedSS,sizeSS);
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
	
	private void swap(int element1, int element2)
	{
		int help = unsorted[element1];
		unsorted[element1]=unsorted[element2];
		unsorted[element2]=help;
	}
	
	public int[] getSorted() //returns sorted array
	{
		sort();
		return unsorted;
	}
	
	public void print() //prints sorted array and sorting time
	{
		/*
		System.out.println("Here is the result after using Selection Sort:");
		for(int k : unsorted)
			System.out.print(k + " ");
		System.out.println();
		*/
		System.out.println("Sorting time with Selection Sort algorithm in nanoseconds: "+time+"\n");
		
	}


}


public class HeapSortTimeMeasure extends TimeMeasure
{

	public HeapSortTimeMeasure(int[] unsortedHS, int sizeHS)
	{
		super(unsortedHS,sizeHS);
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
	
	private void swap(int number1, int number2)
	{
		int help = unsorted[number1];
		unsorted[number1] = unsorted[number2];
		unsorted[number2] = help;
	}
	
	
	public int[] getSorted()
	{
		sort();
		return unsorted;
	}
	
	public void print()
	{
		/*
		System.out.println("Here is the result after using Heap Sort:");
		for(int k:unsorted)
			System.out.print(k + " ");
		System.out.println();
		*/
		System.out.println("Sorting time with Heap Sort algorithm in nanoseconds: " + time);
	}
	
}
