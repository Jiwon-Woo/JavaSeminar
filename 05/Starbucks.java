package practice5;

public class Starbucks {
	protected static int storeCount;
	protected int	storeNumber;
	protected int	orderNumber;
	protected String basicCoffeeBean;
	protected String basicCoffeeMachine;
	
	public	Starbucks () {
		storeCount++;
		storeNumber = storeCount;
		orderNumber = 0;
		basicCoffeeBean = "Espresso Roast";
		basicCoffeeMachine = "Mastrena";
	}
	
	public	Starbucks (String coffeeBean, String coffeeMachine) {
		this();
		basicCoffeeBean = coffeeBean;
		basicCoffeeMachine = coffeeMachine;
	}
	
	public void	makeCoffee() {
		this.orderNumber++;
		Coffee coffee = new Coffee(this, basicCoffeeBean, basicCoffeeMachine);
		System.out.println("주문하신 커피가 제조되었습니다.");
		coffee.showCoffeeInfo();
	}
	
	public void showStarbucksInfo() {
		System.out.println("스타벅스 " + storeNumber + "호점 입니다.");
		System.out.println("사용하는 기본 커피 원두 : " + basicCoffeeBean);
		System.out.println("사용하는 기본 커피 머신 : " + basicCoffeeMachine);
		System.out.println("현재 주문은 " + orderNumber + "번 들어왔습니다.");
	}
	
	static public int getStoreCount() {
		return storeCount;
	}
	
	public int getStoreNumber() {
		return storeNumber;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public String getBasicCoffeeBean() {
		return basicCoffeeBean;
	}

	public void setBasicCoffeeBean(String coffeeBean) {
		this.basicCoffeeBean = coffeeBean;
	}

	public String getBasicCoffeeMachine() {
		return basicCoffeeMachine;
	}

	public void setBasicCoffeeMachine(String coffeeMachine) {
		basicCoffeeMachine = coffeeMachine;
	}
	
}
