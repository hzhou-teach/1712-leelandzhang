//Took me one hour
//My initial score was 2
//Difficulty for me was a 5, but in reality after reading solutions, probably a 2
//Again, I feel really stupid after reading the solutions, I just missed the
//small realization that every item out of place is how many swaps needed. 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
//--------------------------------------------------------------------------
public class outofplace_bronze
{
	private static int[] arr;
//-----------------------------------------------------
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("outofplace.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("outofplace.out"));
		int N=sc.nextInt();
		arr=new int[N];
		for(int i=0; i<N; i++)
		{
			arr[i]=sc.nextInt();
		}
//--------------------------------------------------------------------------
		int pos=0;
		for(int i=1; i<N-1; i++)
		{
			if(arr[i]>arr[i+1]&&arr[i]<arr[i-1])
			{
				pos=i;
				break;
			}
		}
		if(arr[N-1]<arr[N-2])
			pos=N-1;
//--------------------------------------------------------------------------
		int pos1=0;
		boolean x=true;
		for(int i=1; i<N-1; i++)
		{
			if(pos-i>0)
			{
				if(arr[pos-i]>=arr[pos]&&arr[pos-i-1]<=arr[pos])
				{
					pos1=pos-i;
					x=false;
					break;
				}
			}
			if(pos+i<N-1)
			{
				if(arr[pos+i]<=arr[pos]&&arr[pos+i+1]>=arr[pos])
				{
					pos1=pos+i;
					x=false;
					break;
				}
			}
		}
		if(x)
		{
			if(arr[pos]>arr[pos-1])
				pos1=N-1;
			else
				pos1=0;
		}
		
//--------------------------------------------------------------------------
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int count=0;
		if(pos>pos1)
		{
			for(int i=pos; i>=pos1; i--)
			{
				boolean y=true;
				for(int j=0; j<temp.size(); j++)
				{
					if(temp.get(j)==arr[i])
					{
						count++;
						y=false;
					}
				}
				if(y)
					temp.add(arr[i]);
			}
		}
		else
		{
			for(int i=pos; i<=pos1; i++)
			{
				boolean y=true;
				for(int j=0; j<temp.size(); j++)
				{
					if(temp.get(j)==arr[i])
					{
						count++;
						y=false;
					}
				}
				if(y)
					temp.add(arr[i]);

			}
		}
		pr.println(Math.abs(pos1-pos)-count);
		sc.close();
		pr.close();
	}
}
