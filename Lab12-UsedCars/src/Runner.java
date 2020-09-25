
public class Runner {
	public static void main(String args[]) {
		Car c = new Car("Toyota Camry", 2001, 20000.0, 36);
		Car t = new Car("Toyota Camry", 2010, 10000.0, 400);
		Truck g = new Truck("Toyota Tacoma", 2001, 11215.0, 25);
		Truck h = new Truck("Toyota Tacoma", 2010, 22215.0, 50000);
		Scooter s = new Scooter("Toyota Scooty", 2010, 22215.0, 40);
		Inventory in = new Inventory();
		in.addVehicle(c);
		in.addVehicle(t);
		in.addVehicle(g);
		in.addVehicle(h);
		in.addVehicle(s);
		in.listInventory();
	}

}
