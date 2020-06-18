import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class mootube_silver 
{
	static void sort(int[][] x, int[][] seen, int pos, int n)
	{
		System.out.println("y "+seen[n-1][0]);
		if(seen[n-1][0]==0)
		{
			int y=0;
			while(seen[y][0]!=0)
			{
				if(seen[y][0]==x[pos][0])
				{
					pos++;
					seen[pos][0]=x[pos-1][1];
					seen[pos][1]=Math.min(seen[y][1], x[pos-1][2]);	
					sort(x,seen,pos,n);
				}
				System.out.println("h "+seen[n-1][0]);
				if(seen[y][0]==x[pos][1])
				{	
					pos++;
					seen[pos][0]=x[pos-1][0];
					seen[pos][1]=Math.min(seen[y][1], x[pos-1][2]);
					sort(x,seen,pos,n);
				}
				y++;
			}
		}
	}
//--------------------------------------------------------------------------
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(new File("mootube.in"));
		PrintWriter pr=new PrintWriter(new FileWriter("mootube.out"));
		int n=sc.nextInt();
		int q=sc.nextInt();
//---------------------------------------------------------------------------
		int[][] vid=new int[n-1][3];
		for(int i=0; i<n-1; i++)
		{
			vid[i][0]=sc.nextInt();
			vid[i][1]=sc.nextInt();
			vid[i][2]=sc.nextInt();
		}
//-----------------------------------------------------------------------------
		int[][] que=new int[q][2];
		for(int i=0; i<q;i++)
		{
			que[i][0]=sc.nextInt();
			que[i][1]=sc.nextInt();
		}
//----------------------------------------------------------------------------
		for(int i=0; i<q;i++)
		{
			int index=0;
			int count=0;
			int[][] seen=new int[n][2];
			seen[0][0]=que[i][1];
			seen[0][1]=1000001;
			sort(vid,seen,index, n);
			for(int j=0; j<n;j++)
			{
				if(que[i][0]>seen[j][1])
					count++;
			}
			pr.println(count);
		}
		
	}
}
