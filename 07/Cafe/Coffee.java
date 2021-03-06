package practice7;

public class Coffee {
	
	private String	orderNumber;
	private String	coffeeBean;
	private String	coffeeMachine;
	
	public Coffee(Cafe cafe, String coffeeBean, String coffeeMachine) {
		orderNumber = Integer.toString(cafe.getStoreNumber()) + "-"
					+ Integer.toString(cafe.getOrderNumber());
		this.coffeeBean = coffeeBean;
		this.coffeeMachine = coffeeMachine;
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}
	
	public String getCoffeeBean() {
		return coffeeBean;
	}
	public void setCoffeeBean(String coffeeBean) {
		this.coffeeBean = coffeeBean;
	}
	public String getCoffeeMachine() {
		return coffeeMachine;
	}
	public void setCoffeeMachine(String coffeeMachine) {
		this.coffeeMachine = coffeeMachine;
	}
	
	public void showCoffeeInfo() {
		System.out.println("주문번호 : " + getOrderNumber());
		System.out.println("커피 원두 : " + getCoffeeBean());
		System.out.println("커피 추출방식 : " + getCoffeeMachine());
	}

}
