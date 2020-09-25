import java.util.*;
import static java.lang.System.out;

public class MyString
{
    private String theString;
    
    /** 
     * constructs a new MyString object, using the value of the
     * String parameter to initialize the instance variable
     */
    public MyString(String s)
    {
        theString = s;
    }
    
    /**
     * theString getter method, returns the value of the private
     * instance variable for this object
     */
    public String getTheString()
    {
        return theString;
    }
    
    /** theString setter method */
    public void setTheString(String newValue)
    {
        theString = newValue;
    }
}
