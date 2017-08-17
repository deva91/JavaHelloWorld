public class SorterMerge extends Sorter 
{
	public SorterMerge(int[] unsortedMS, int sizeMS)
	{
		super(unsortedMS,sizeMS);
		sorterName = "Merge ";
	}
	
	public void sort()
	{
		int[] helpArray = unsorted;
		merge(unsorted,0,size-1,helpArray);
	}
	
	private void merge(int[] arrayA, int left, int right, int[] arrayB)
	{
		int middle = (left + right) / 2;
		if ((middle - left)>1)
			merge(arrayA, left, middle, arrayB);
		if ((right - middle)>2)
			merge(arrayA,middle+1,right,arrayB);
		int i=0;
		int j=middle+1;
		for (int k=0;k<=right;k++)
		{
			if ( (i<=middle && j>right) || (i<=middle && j<=right && arrayA[i]<=arrayA[j]) )
			{
				arrayB[k] = arrayA[i];
				i++;
			}
			else
			{
				arrayB[k] = arrayA[j];
				j++;
			}
		}
		
		for (int k=0;k<=right;k++)
			arrayB[k]=arrayA[k];
	}
}