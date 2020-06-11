package UsacoLeeland;
//Leeland Zhang
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BovineShuffle 
{
		public static void main(String args[]) throws IOException
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String a=br.readLine();
			int numcows=Integer.parseInt(a);
			int[][] pos=new int[numcows][2];
			int[] fpos=new int[numcows];
			String[] temp=br.readLine().split("\\s+");
			String[] tp=br.readLine().split("\\s+");
			for(int i=0; i<numcows; i++)
			{
				pos[i][0]=Integer.parseInt(temp[i]);
				pos[i][1]=Integer.parseInt(tp[i]);
			}
			for(int i=0; i<numcows; i++)
			{
				fpos[pos[i][0]-1]=pos[i][1];
			}
			for(int i=0; i<numcows; i++)
			{
				System.out.println(fpos[i]);
			}
		}
}
