package UsacoLeeland;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class SilverBovineShuffle 
{
			public static void main(String args[]) throws IOException
			{
				int count=0;
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String a=br.readLine();
				int numcows=Integer.parseInt(a);
				String[] temp=new String[numcows];
				int[] pos=new int[numcows];
				temp=br.readLine().split("\\s+");
				for(int i=0; i<numcows; i++)
				{
					pos[i]=Integer.parseInt(temp[i]);
				}
				int[] unique=new int[numcows];
				boolean w=false;
				for(int i=0; i<numcows; i++)
				{
					for(int j=0; j<numcows; j++)
					{
						if(unique[j]==pos[i])
						{
							count++;
							break;
						}
						if(j==numcows-1)
							w=true;
					}
					if(w)
						unique[i]=pos[i];
				}
				System.out.println(numcows-count);
			}
}
