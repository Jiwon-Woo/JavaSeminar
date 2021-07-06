package practice7;

public abstract class Cafe {

	protected static int totalCafeCount;
	protected int	storeNumber;
	protected int	orderNumber;
	protected String basicCoffeeBean;
	protected String basicCoffeeMachine;
	
	
	public abstract void showCafeInfo();
	public abstract void setBasicCoffeeBean(String coffeeBean);
	public abstract void setBasicCoffeeMachine(String coffeeMachine);
	
	static public int gettotalCafeCount() {
		return totalCafeCount;
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

	public String getBasicCoffeeMachine() {
		return basicCoffeeMachine;
	}

	public void	makeCoffee() {
		orderNumber++;
		Coffee coffee = new Coffee(this, basicCoffeeBean, basicCoffeeMachine);
		System.out.println("주문하신 커피가 제조되었습니다.");
		coffee.showCoffeeInfo();
	}
	
}
