import java.util.*;
import java.io.*;

public class MyStringsRunner {
	public static void main(String[] args) throws IOException
    {
    	File file = new File("input01.txt");
    	Scanner in = new Scanner(file);
    	MyStrings m = new MyStrings(in.nextInt(), in.nextInt());
    	for (int r = 0; r < m.getNumRows() ; r++ )
    	{
    		for (int c = 0; c < m.getNumCols() ; c++ )
    		{
    			MyString h = new MyString(in.next());
    			m.addMyString(h, r,c);
    		}
    		
    	}
    	
    	for (int r = 0; r < m.getNumRows() ; r++ )
    	{
    		for (int c = 0; c < m.getNumCols() ; c++ )
    		{
    			String s = m.getMyStringAt(r, c).getTheString();
    			s = s.replaceAll("e","!");
    			m.setMyStringAt(s, r, c);
    		}
    		
    	}
    	m.print();
    	int counter = 0;
    	for (int i = 3; i < 9 ; i++)
    	{
    		for (int r = 0; r < m.getNumRows() ; r++ )
        	{
        		for (int c = 0; c < m.getNumCols() ; c++ )
        		{
        			if (m.getMyStringAt(r, c).getTheString().length() == i)
        			{
        				counter ++;
        			}
        		}
        		
    	}
    		System.out.println("Length of "+i+" >>> "+counter+" times" );
    		counter = 0;
    	}
    	File file1 = new File("input02.txt");
    	in = new Scanner(file1);
    	m = new MyStrings(in.nextInt(), in.nextInt());
    	for (int r = 0; r < m.getNumRows() ; r++ )
    	{
    		for (int c = 0; c < m.getNumCols() ; c++ )
    		{
    			MyString h = new MyString(in.next());
    			m.addMyString(h, r,c);
    		}
    		
    	}
    	
    	for (int r = 0; r < m.getNumRows() ; r++ )
    	{
    		for (int c = 0; c < m.getNumCols() ; c++ )
    		{
    			if (m.getMyStringAt(r, c).getTheString().endsWith("e"))
    			{
    				String s = m.getMyStringAt(r, c).getTheString();
        			s = s+" !";
        			m.setMyStringAt(s, r, c);
    			}
    		}
    		
    	}
    	m.print();
    }
}
