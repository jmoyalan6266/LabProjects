
import java.util.*;
import java.awt.*;
public class SecretCoderunner
{
    public static void main (String args[])
    {
        String keyPhrase = "six perfect quality black jewels amazed the governor";
        String code = "35 10 10 33 9 24 3 17 41 8 3 20 51 16 38 44 47 32 33 10 19 38 35 28 49";
        SecretCode test = new SecretCode(keyPhrase,code);
        System.out.println(test.decode());
    }
}

class SecretCode
{
    private String key;
    private String code;
    public SecretCode(String k, String c)
    {
        key=k;
        code=c;
    }
    
    public String decode() {
        String newWord="";
        Scanner chopper = new Scanner(code);
        while(chopper.hasNext()){
         
            if (chopper.hasNextInt()){
            newWord+=key.charAt(chopper.nextInt());
            }
            else{
            chopper.next();    
            }
        }
        return newWord;
    
    }

}

