import java.awt.*;
import java.util.*;
public class Runner
{
    public static void main (String args[])
    {
        StringMethods test= new StringMethods();
        test.unusualHello("Ron");
        System.out.println(test.stringRipper("something"));
        System.out.println(test.concatenate("computer", "science", true));
        System.out.println(test.hasSub("Computer science", "sci"));
        System.out.println(test.evenFooBar("foofoobarbarfoo"));
        System.out.println(test.evenFooBar("foobarbarfoo"));
        System.out.println(test.microwaveTime("12") );
        System.out.println(test.microwaveTime("123") );
        System.out.println(test.microwaveTime("4500") );
        System.out.println(test.reverseWords("hello world"));
        System.out.println(test.reverseWords("the sky is blue"));
        System.out.println(test.sumString("Hi 90 there are 20 or 13 numbers in this String"));
    }
}

class StringMethods
{

    public void unusualHello(String name)
    {
        System.out.println("Hello "+name+", you dummy");
    }

    public String stringRipper(String str)
    {
        String first=str.substring(0,1);
        String last=str.substring(str.length()-1,str.length());
        return first+last;

    }

    public String concatenate(String a, String b, boolean space)
    {
        if (space==true){
            return a+" "+b;
        }
        else{
            return a+b;
        }
    }

    public boolean hasSub(String str, String sub)
    {
        int t=sub.length();
        for (int i=0; i<(str.length()-sub.length()); i++){
            if (str.substring(i,t).equals(sub)){
                return true;

            }
            t++;
        }
        return false;

    }

    public boolean evenFooBar(String str)
    {
        int noFoo=0;
        int t=3;
        for (int i=0; i<(str.length()-2); i++){
            if (str.substring(i,t).equals("foo")){
                noFoo++;

            }
            t++;
        }
        int noBar=0;
        t=3;
        for (int i=0; i<(str.length()-2); i++){
            if (str.substring(i,t).equals("bar")){
                noBar++;

            }
            t++;
        }

        if(noFoo==noBar){return true;}
        else {return false;}

    }

    public String microwaveTime(String str)
    {
        if((str.length()>4)||(str.length()<1)){
            return "Invalid output";
        }
        else if (str.length()<=2){
            return "00:"+str;
        }
        else if (str.length()==3){
            return "0"+str.charAt(0)+":"+str.substring(1,3);

        }
        else{
            return str.substring(0,2) +":"+str.substring(2,4);
        }

    }

    public String reverseWords(String str)
    {
        String[] parts = str.split(" ");
        String reverse="";
        for (int i = parts.length-1 ; i >=0 ; i -- )
        {
            reverse+=(parts[i]+" ");
        }
        return reverse;
    }

    public int sumString(String str)
    {
        int sum=0;
        Scanner chopper= new Scanner(str);
        while (chopper.hasNext()){
            if (chopper.hasNextInt())
            {
                sum+=chopper.nextInt();
            }
            else{
                chopper.next();
            }
        }
        return sum;
    }
}