package UsacoLeeland;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class SilverMilkMeasurement 
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a=br.readLine();
		String[] b=a.split("\\s+");
		int best=0;
		int min=0;
		int days=0;
		int[][] input=new int[1000000][2];
		int[] cows=new int[1000000];
		for(int i=0; i<Integer.parseInt(b[0]); i++)
		{
			String[] c=br.readLine().split("\\s+");
			input[Integer.parseInt(c[0])][0]=Integer.parseInt(c[1]);
			input[Integer.parseInt(c[0])][1]=Integer.parseInt(c[2]);
		}
		int p=0;
		while(min==0)
		{
			
			if(input[p][0]!=0)
			{
				min=p;
			}
			p++;
		}
		for(int i=min; i<=1000000; i++)
		{
			boolean x=true;
			if(cows[input[i][0]]==best)
			{
				days++;
				x=false;
			}
			cows[input[i][0]]+=input[i][1];
			if(x&&cows[input[i][0]]>=best)
			{
				days++;
			}
			best=cows[input[i][0]];
			for(int j=0; j<1000000; j++)
			{
				if(cows[j]>best)
					best=cows[j];
			}
		}
		System.out.println(days);
	}
}
