//Took me like 2 hours
//I got 4/10
//Difficulty 6
//I just found a mediocre solution after a long time, kinda dissapointing
//but I guess its better than alternative outcomes. I think my approach
//was correct but my code execution was a little off. 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class rental_silver 
{
	static int partition(int arr[][], int low, int high) 
	{ 
		int pivot = arr[high][1];  
		int i = (low-1);
		for (int j=low; j<high; j++) 
		{ 
			if (arr[j][1] < pivot) 
			{ 
				i++; 
				int temp = arr[i][1]; 
            	arr[i][1] = arr[j][1]; 
            	arr[j][1] = temp;
            	temp = arr[i][0]; 
            	arr[i][0] = arr[j][0]; 
            	arr[j][0] = temp;
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
	static int partition1(int arr[], int low, int high) 
	{ 
		int pivot = arr[high];  
		int i = (low-1);
		for (int j=low; j<high; j++) 
		{ 
			if (arr[j]< pivot) 
			{ 
				i++; 
				int temp = arr[i]; 
            	arr[i] = arr[j]; 
            	arr[j] = temp;
			} 
		} 
		int temp = arr[i+1]; 
		arr[i+1] = arr[high]; 
		arr[high] = temp; 
		return i+1; 
	} 
	static void sort1(int arr[], int low, int high) 
	{ 
		if (low < high) 
		{ 
			int pi = partition1(arr, low, high); 
			sort1(arr, low, pi-1); 
			sort1(arr, pi+1, high); 
		} 
	} 
	static long calc(int[] rent,int[]produce,int[][] store, int nm, int r, int m, int n)
	{
		long mid=0;
		long milk=0;
		if(nm==0)
		{
			for(int i=0;i<nm; i++)
			{
				mid+=rent[r-1-i];
			}
			for(int i=0;i<n-nm; i++)
			{
				milk+=produce[n-i-1];
			}
			for(int i=m-1;i>=0; i--)
			{
				if(milk>=store[i][0])
				{
					mid+=store[i][0]*store[i][1];
					milk-=store[i][0];
				}
				else
				{
					mid+=store[i][1]*milk;
					break;
				}
			}
			return mid;
		}
		if(nm==n)
		{
			for(int i=0;i<nm; i++)
			{
				mid+=rent[r-1-i];
			}
			return mid;
		}
		for(int i=0;i<nm; i++)
		{
			mid+=rent[r-1-i];
		}
		for(int i=0;i<n-nm; i++)
		{
			milk+=produce[n-i-1];
		}
		for(int i=m-1;i>=0; i--)
		{
			if(milk>=store[i][0])
			{
				mid+=store[i][0]*store[i][1];
				milk-=store[i][0];
			}
			else
			{
				mid+=store[i][1]*milk;
				break;
			}
		}
		return mid;
	}
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("rental.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("rental.out"));
//---------------------------------------------------------------------
		int n=sc.nextInt();
		int m=sc.nextInt();
		int r=sc.nextInt();
		
		int[] produce=new int[n];
		for(int i=0;i<n; i++)
		{
			produce[i]=sc.nextInt();
		}
		
		int[][] store=new int[m][2];
		for(int i=0;i<m; i++)
		{
			store[i][0]=sc.nextInt();
			store[i][1]=sc.nextInt();
		}
		
		int[] rent=new int[r];
		for(int i=0;i<r; i++)
		{
			rent[i]=sc.nextInt();
		}
//------------------------------------------------------------------------
		sort(store,0,m-1);
		sort1(produce,0,n-1);
		sort1(rent,0,r-1);
//--------------------------------------------------------------------
		long max=calc(rent, produce, store, n/2, r, m, n);
		if(calc(rent, produce, store, (n/2)+1, r, m, n)>max)
		{
			for(int i=(n/2)+1; i<n; i++)
			{
				if(calc(rent, produce, store, i-1, r, m, n)<calc(rent, produce, store, i, r, m, n))
					max=calc(rent, produce, store, i, r, m, n);
				else
					break;
			}
		}
		else if(calc(rent, produce, store, (n/2)-1, r, m, n)>max)
		{
			for(int i=(n/2)-1; i>=0; i--)
			{
				if(calc(rent, produce, store, i, r, m, n)<calc(rent, produce, store, i-1, r, m, n))
					max=calc(rent, produce, store, i, r, m, n);
				else
					break;
			}
		}
		pr.println(max);
		sc.close();
		pr.close();
	}
}