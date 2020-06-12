package UsacoLeeland;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class MyCowAteMyHowework 
{
	public static double calcGrade(int[] list, int start)
	{
		int pos=0;
		int low=list[0];
		double calc=0;
		for(int i=start; i<list.length; i++)
		{
			if(list[i]<low)
			{
				low=list[i];
				pos=i;
			}
		}
		for(int i=start; i<list.length;i++)
		{
			if(i==pos)
				continue;
			calc+=list[i];
		}
		return calc/(list.length-start-1);
	}
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tem=br.readLine();
		double best=0;
		int[] scores=new int[Integer.parseInt(tem)];
		ArrayList<Integer> answer=new ArrayList<Integer>();
		String[] temp=br.readLine().split("\\s+");
		for(int i=0; i<scores.length; i++)
		{
			scores[i]=Integer.parseInt(temp[i]);
		}
		for(int i=1; i<scores.length-1; i++)
		{
			if(best<calcGrade(scores, i))
				best=calcGrade(scores,i);
		}
		for(int i=1; i<scores.length-1; i++)
		{
			if(calcGrade(scores, i)==best)
			{
				Integer obj=new Integer(i);
				answer.add(obj);
			}
		}
		for(int i=0; i<answer.size(); i++)
		{
			System.out.println(answer.get(i));
		}
	}
}
