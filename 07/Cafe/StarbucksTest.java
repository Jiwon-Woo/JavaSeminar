package practice7;

public class StarbucksTest {
	
	public static void main(String[] args) {
		
		Cafe connected = new Connected();
		Cafe starbucks = new Starbucks();
		Cafe starbucks2 = new Starbucks();
		
		starbucks.showCafeInfo();
		System.out.println();
		connected.showCafeInfo();
		System.out.println();
		starbucks2.showCafeInfo();
		System.out.println();
		
		starbucks.makeCoffee();
		System.out.println();
		connected.makeCoffee();
		System.out.println();
		connected.makeCoffee();
		System.out.println();
		connected.makeCoffee();
		System.out.println();
		connected.setBasicCoffeeMachine("Mastrena");
		connected.makeCoffee();
		System.out.println();
		starbucks2.makeCoffee();
		System.out.println();
		
		starbucks.showCafeInfo();
		System.out.println();
		connected.showCafeInfo();
		System.out.println();
		starbucks2.showCafeInfo();
		System.out.println();
		
	}
}
