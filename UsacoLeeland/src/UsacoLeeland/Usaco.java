package UsacoLeeland;
import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	public class Usaco {
		public static int num(String x)
		{
			if(x.equals("Bessie"))
				return 0;
			else if(x.equals("Elsie"))
				return 1;
			else return 2;
		}
		public static void main(String args[]) throws IOException
		{
			int b=7;
			int e=7;
			int m=7;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String a=br.readLine();
			int best=7;
			int days=0;
			String[] c= new String[3];
			int[][] input=new int[100][2];
			for(int i=0; i<Integer.parseInt(a); i++)
			{
				c=br.readLine().split("\\s+");
				input[Integer.parseInt(c[0])][0]=num(c[1]);
				input[Integer.parseInt(c[0])][1]=Integer.parseInt(c[2]);
			}
			for(int i=0; i<Integer.parseInt(c[0]); i++)
			{
				boolean p=true;
				if(input[i][1]!=0)
				{
					if(input[i][0]==0)
					{
						if(b==best)
						{
							days++;
							p=false;
						}
						b+=input[i][1];
					}
					if(input[i][0]==1)
					{
						if(e==best)
						{
							days++;
							p=false;
						}
						e+=input[i][1];	
					}
					if(input[i][0]==2)
					{
						if(m==best)
						{
							days++;
							p=false;
						}
						m+=input[i][1];
					}
				}
				if(best<input[i][1])
					best=input[i][1];
				if(p&&b==best)
					days++;
				if(p&&e==best)
					days++;
				if(p&&m==best)
					days++;
			}
			System.out.print(days);
		}

}
