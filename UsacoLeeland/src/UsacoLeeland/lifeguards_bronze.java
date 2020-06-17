//Took me maybe 45 minutes
//My score was 9/10
//I think this is a difficulty 5
//I obviously searched up how to quicksort, but I think I understand how
//it works now, does this count as cheating?
//I also don't know how I got one test wrong, I looked at the solutions and their
//method is different from mine, also the test case was super long,
//something like 174 integers were passed in so I didn't really want to run through it
//manually by myself.
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class lifeguards_bronze 
{
	static int partition(int arr[][], int low, int high) 
	{ 
		int pivot = arr[high][0];  
		int i = (low-1);
		for (int j=low; j<high; j++) 
		{ 
			if (arr[j][0] < pivot) 
			{ 
				i++; 
				int temp = arr[i][0]; 
            	arr[i][0] = arr[j][0]; 
            	arr[j][0] = temp;
            	temp = arr[i][1]; 
            	arr[i][1] = arr[j][1]; 
            	arr[j][1] = temp;
			} 
		} 
		int temp = arr[i+1][0]; 
		arr[i+1][0] = arr[high][0]; 
		arr[high][0] = temp; 
		temp = arr[i+1][1]; 
		arr[i+1][1] = arr[high][1]; 
		arr[high][1] = temp; 
		return i+1; 
	} 
	static void sort(int arr[][], int low, int high) 
	{ 
		if (low < high) 
		{ 
			int pi = partition(arr, low, high); 
			sort(arr, low, pi-1); 
			sort(arr, pi+1, high); 
		} 
	} 
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("lifeguards.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("lifeguards.out"));
		short n=sc.nextShort();
		int[][] time=new int[n][2];
		for(int i=0; i<n; i++)
		{
			time[i][0]=sc.nextShort();
			time[i][1]=sc.nextShort();
		}
		sort(time,0,n-1);
//----------------------------------------------------------------------------
		int max=0; 
		for(int i=0; i<n;i++)
		{
			int count=0;
			for(int j=0; j<n; j++)
			{
				if(j==i)
					continue;
				count=count+time[j][1]-time[j][0];
				if(j!=0&&j-1!=i)
					if(time[j][0]<time[j-1][1])
						count-=(time[j-1][1]-time[j][0]);
			}
			if(count>max)
				max=count;
		}
		pr.println(max);
		sc.close();
		pr.close();
	}
}
