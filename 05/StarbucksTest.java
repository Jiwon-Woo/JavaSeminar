package practice5;

public class StarbucksTest {
	
	public static void main(String[] args) {
		
		Starbucks starbucks = new Starbucks();
		StarbucksReserve reserve = new StarbucksReserve();
		Starbucks starbucks2 = new Starbucks();
		
		starbucks.showStarbucksInfo();
		System.out.println();
		reserve.showStarbucksInfo();
		System.out.println();
		starbucks2.showStarbucksInfo();
		System.out.println();
		
		starbucks.makeCoffee();
		System.out.println();
		reserve.makeCoffee();
		System.out.println();
		reserve.makeCoffee("Costa Rica Naranjo", "Cold Brew");
		System.out.println();
		reserve.makeCoffee("Espresso Roast", "Mastrena");
		System.out.println();
		reserve.setBasicCoffeeMachine("Mastrena");
		reserve.makeCoffee();
		System.out.println();
		starbucks2.makeCoffee();
		System.out.println();
		
		starbucks.showStarbucksInfo();
		System.out.println();
		reserve.showStarbucksInfo();
		System.out.println();
		starbucks2.showStarbucksInfo();
		System.out.println();
		
	}
}
