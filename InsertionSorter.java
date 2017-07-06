public class InsertionSorter extends Sorter
{
	public InsertionSorter(int[] unsortedIS, int sizeIS)
	{
		super(unsortedIS,sizeIS);
		sorterName = "Insertion ";
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
