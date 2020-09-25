import java.io.IOException;

public class WordCloudRunner 
{

	public static void main(String args[]) throws IOException{
		WordCloud g = new WordCloud("dream.txt");
		g.printInfo();
	}

}
