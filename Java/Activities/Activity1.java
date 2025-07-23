package activities;

public class Activity1 {

	public static void main(String[] args) {
		Car carName = new Car("Black","Manual",2014,4,4);
      
        carName.displayCharacterstics();
        carName.accelerate();
        carName.brake();
    }
}
