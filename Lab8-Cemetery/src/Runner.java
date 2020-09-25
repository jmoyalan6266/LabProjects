import java.io.File;
import java.text.DecimalFormat;
import java.io.IOException;

public class Runner {
	public static void main (String args[]) throws IOException 
	{
		DecimalFormat df = new DecimalFormat("#.#");
		
		Cemetery a = new Cemetery("cemetary.txt");
		double age = 0;
		for (int  i = 0 ; i < a.numTombs(); i++)
		{
			System.out.println(a.getTomb(i).getAge());
			age += a.getTomb(i).getAge();
		}
		double  avgAge =  (age / a.numTombs())/365  ;
		System.out.println(df.format(avgAge));
		
	}
}
