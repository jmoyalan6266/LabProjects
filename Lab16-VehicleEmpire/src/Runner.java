import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
 
public class Runner
{
    public static void main(String[] args)
    {
        List<Vehicle> list = new ArrayList<>();
         
        list.add(new Car("Honda Civic", 2000, 9000, 32));
        list.add(new Truck("Chevy Silverado", 2013, 17000, 2500));
        list.add(new Airplane("Cessna 206", 1997, 400000, 6, true));
         
        Helicopter helicopter = new Helicopter("Bell 206L", 1986, 660000, 7, false);
         
        list.add(helicopter);
 
        for (Vehicle v : list)
            out.println(v.getInfo() + "\n");
             
        System.out.println("Helicopter monthly payment >>> $" + helicopter.getMonthlyPayment());
    }
}
