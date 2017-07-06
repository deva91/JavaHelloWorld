public class HeapSorter extends Sorter
{
	public HeapSorter(int[] unsortedHS, int sizeHS)
	{
		super(unsortedHS,sizeHS);
		sorterName = "Heap ";
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
