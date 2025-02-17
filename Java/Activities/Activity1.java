package Activities;

public class Activity1 {
	public static void main(String[] args) {
		Car carobj = new Car("Red","Manual",2020);
		System.out.println();
		carobj.displaycharacteristics();
		carobj.accelerate();
		carobj.brake();
		
	}

}
