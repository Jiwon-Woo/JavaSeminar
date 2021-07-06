package practice7;

public class Connected extends Cafe {
	
	protected static int ConnectedCount;
	
	public	Connected () {
		ConnectedCount++;
		storeNumber = ConnectedCount;
		orderNumber = 0;
		basicCoffeeBean = "Kenya Ukambani";
		basicCoffeeMachine = "Mastrena";
	}
	
	public Connected (String coffeeBean, String coffeeMachine) {
		this();
		basicCoffeeBean = coffeeBean;
		basicCoffeeMachine = coffeeMachine;
	}

	public void showCafeInfo() {
		System.out.println("커넥티드 " + storeNumber + "호점 입니다.");
		System.out.println("사용하는 기본 커피 원두 : " + basicCoffeeBean);
		System.out.println("사용하는 기본 커피 머신 : " + basicCoffeeMachine);
		System.out.println("현재 주문은 " + orderNumber + "번 들어왔습니다.");
	}
	
	static public int getStarbucksCount() {
		return ConnectedCount;
	}
	
	public void setBasicCoffeeBean(String coffeeBean) {
		this.basicCoffeeBean = coffeeBean;
	}
	
	public void setBasicCoffeeMachine(String coffeeMachine) {
		basicCoffeeMachine = coffeeMachine;
	}
	
}
