import java.util.Random;

public class Compare 
{

	public static void main(String[] args) 
	{
		// Here we create a random array
		int size = 20;
		int[] unsorted = new int[size];
		for(int i=0;i<20;i++)
			{
			Random x = new Random();
			unsorted[i] = x.nextInt(100);
			}
		System.out.println("This is an unsorted array:");
		for(int j : unsorted)
			System.out.print(j + " ");
		
		System.out.println("\nLet's sort it.");
		
		// here starts Insertion Sort
		int[] sortedIS = unsorted;
		for (int i=1;i<size;i++)
		{
			int key = sortedIS[i];
			int j = i-1;
			while(j>=0 && sortedIS[j]>key)
			{
				sortedIS[j+1]=sortedIS[j];
				j--;
			}
			sortedIS[j+1]=key;
		}
		System.out.println("Here is the result after using Insertion Sort:");
		for(int k : sortedIS)
			System.out.print(k + " ");
		
		// here starts Selection Sort
		int[] sortedSS = unsorted;
		for (int j=size-1;j>=1;j--)
		{
			int max = j;
			for (int i=j-1;i>=0;i--)
			{
				if (sortedSS[i]>sortedSS[max])
					max = i;
			}
			int help = sortedSS[j];
			sortedSS[j]=sortedSS[max];
			sortedSS[max]=help;
		}
		System.out.println("\nHere is the result after using Selection Sort:");
		for(int k : sortedSS)
			System.out.print(k + " ");
		
		// here starts ... Sort
	}
