import java.util.*;

public class MyStrings
{
    /** Square 2D array of MyString objects */
    private MyString[][] theStrings;
    
    /** constructor, instantiates the array */
    public MyStrings(int rows, int cols)
    {
        theStrings = new MyString[rows][cols];
    }
    
    /** adds a MyString object to the array at [r][c] */
    public void addMyString(MyString s, int r, int c)
    {
        theStrings[r][c] = s;
    }
    
    /** returns a reference to the MyString object at [r][c] in words */
    public MyString getMyStringAt(int r, int c)
    {
        return theStrings[r][c];
    }
    
    /** set the MyString's String value to the value of the parameter */
    public void setMyStringAt(String newValue, int r, int c)
    {
        theStrings[r][c].setTheString(newValue);
    }
    
    
    /** returns the number of rows in theStrings */
    public int getNumRows() 
    { 
        return theStrings.length; 
    }
    
    /** returns the number of columns in theStrings */
    public int getNumCols() 
    { 
        return theStrings[0].length; 
    }
    
    /** prints element in theStrings in row-major order */
    public void print()
    {
        for (MyString[] row : theStrings) 
        {
            for (MyString m : row) System.out.print(m.getTheString() + " ");
            
            System.out.println();
        }
    }
}
