package UsacoLeeland;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BlockedBillboard 
{
	public static void sort(int z,int[][]x, String[]y)
	{
		for(int i=0; i<4; i++)
		{
			x[z][i]=Integer.parseInt(y[i]);
		}
	}
	public static void main(String args[]) throws IOException
	{
		int dif=0;
		int[][] cord=new int [3][4];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp=br.readLine();
		sort(0,cord,temp.split("\\s+"));
		temp=br.readLine();
		sort(1,cord,temp.split("\\s+"));
		temp=br.readLine();
		sort(2,cord,temp.split("\\s+"));
		for(int j=0; j<2; j++)
		{
			boolean[] res=new boolean[4];
			int count=0;
			if(cord[j][0]>cord[2][0]&&cord[j][0]<cord[2][2]&&cord[j][1]>cord[2][1]&&cord[j][1]<cord[2][3])
				res[0]=true;
			if(cord[j][2]>cord[2][0]&&cord[j][2]<cord[2][2]&&cord[j][3]>cord[2][1]&&cord[j][3]<cord[2][3])
				res[1]=true;
			if(cord[j][0]>cord[2][0]&&cord[j][0]<cord[2][2]&&cord[j][3]>cord[2][1]&&cord[j][3]<cord[2][3])
				res[2]=true;
			if(cord[j][2]>cord[2][0]&&cord[j][2]<cord[2][2]&&cord[j][1]>cord[2][1]&&cord[j][1]<cord[2][3])
				res[3]=true;
			for(int i=0; i<4; i++)
				{
					if(res[i])
						count++;
				}
			int[] tem=new int[2];
			int count1=0;
			if(count==0)
			{
				if(cord[2][0]>cord[j][0]&&cord[2][0]<cord[j][2]&&cord[2][1]>cord[j][1]&&cord[2][1]<cord[j][3])
					res[0]=true;
				if(cord[2][2]>cord[j][0]&&cord[2][2]<cord[j][2]&&cord[2][3]>cord[j][1]&&cord[2][3]<cord[j][3])
					res[1]=true;
				if(cord[2][0]>cord[j][0]&&cord[2][0]<cord[j][2]&&cord[2][3]>cord[j][1]&&cord[2][3]<cord[j][3])
					res[2]=true;
				if(cord[2][2]>cord[j][0]&&cord[2][2]<cord[j][2]&&cord[2][1]>cord[j][1]&&cord[2][1]<cord[j][3])
					res[3]=true;
				for(int i=0; i<4; i++)
				{
					if(res[i])
					{
						tem[count1]=i;
						count1++;
					}
				}
				if(tem[0]==0&&tem[1]==2)
					dif+=(cord[j][2]-cord[2][0])*(cord[2][3]-cord[2][1]);
				if(tem[0]==0&&tem[1]==3)
					dif+=(cord[j][3]-cord[2][1])*(cord[2][2]-cord[2][0]);
				if(tem[0]==1&&tem[1]==2)
					dif+=(cord[2][1]-cord[j][3])*(cord[2][2]-cord[2][0]);
				if(tem[0]==1&&tem[1]==3)
					dif+=(cord[2][2]-cord[j][0])*(cord[2][3]-cord[2][1]);
			}
			if(count==1)
			{
				for(int i=0; i<4; i++)
				{
					if(res[i])
					{
						if(i==0)
							dif+=(cord[2][2]-cord[j][0])*(cord[2][3]-cord[j][1]);
						if(i==1)
							dif+=(cord[j][2]-cord[2][0])*(cord[j][3]-cord[2][1]);
						if(i==2)
							dif+=(cord[2][2]-cord[j][0])*(cord[j][3]-cord[2][1]);
						if(i==3)
							dif+=(cord[j][2]-cord[2][0])*(cord[2][3]-cord[j][1]);
					}
			
				}
			}
			if(count==2)
			{
				for(int i=0; i<4; i++)
				{
					if(res[i])
					{
						tem[count1]=i;
						count1++;
					}
				}
				if(tem[0]==0&&tem[1]==2)
					dif+=(cord[2][2]-cord[j][0])*(cord[j][3]-cord[j][1]);
				if(tem[0]==0&&tem[1]==3)
					dif+=(cord[2][3]-cord[j][1])*(cord[j][2]-cord[j][0]);
				if(tem[0]==1&&tem[1]==2)
					dif+=(cord[j][1]-cord[2][3])*(cord[j][2]-cord[j][0]);
				if(tem[0]==1&&tem[1]==3)
					dif+=(cord[j][0]-cord[2][2])*(cord[j][3]-cord[j][1]);
			}
			if(count==4)
				dif+=(cord[j][2]-cord[j][0])*(cord[j][3]-cord[j][1]);
		}
		System.out.println((cord[0][2]-cord[0][0])*(cord[0][3]-cord[0][1])+(cord[1][2]-cord[1][0])*(cord[1][3]-cord[1][1])-dif);
		System.out.println(dif);
	}
}
