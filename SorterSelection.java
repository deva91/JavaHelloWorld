public class SorterSelection extends Sorter
{
	public SorterSelection(int[] unsortedSS, int sizeSS)
	{
		super(unsortedSS,sizeSS);
		sorterName = "Selection ";
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
