package practice7;
import java.util.ArrayList;

public class StarbucksReserve extends Starbucks {
	
	protected static int StarbucksReverveCount;
	private ArrayList<String> coffeeBeanList = new ArrayList<String>();
	private ArrayList<String> coffeeMachineList = new ArrayList<String>();
	
	public	StarbucksReserve () {
		super("Ecuador Loja", "Clover");
		System.out.println("Reserve!");
		StarbucksCount--;
		StarbucksReverveCount++;
		storeNumber = StarbucksReverveCount;
		addBasicList();
	}
	
	private void addBasicList() {
		coffeeMachineList.add("Clover");
		coffeeMachineList.add("Black Eagle");
		coffeeMachineList.add("Poc");
		coffeeMachineList.add("Siphon");
		coffeeMachineList.add("Chemex");
		coffeeMachineList.add("Cold Brew");
		coffeeBeanList.add("Ecuador Loja");
		coffeeBeanList.add("Aged Sumatra Vintage");
		coffeeBeanList.add("Costa Rica Bella Vista");
		coffeeBeanList.add("Panama Carmen Estate");
		coffeeBeanList.add("Costa Rica Naranjo");
		coffeeBeanList.add("Rwanda Hingakawa");
		coffeeBeanList.add("Kenya Ukambani");
	}
	
	private boolean isValidOrder(String coffeeBean, String coffeeMachine) {
		if (coffeeBeanList.contains(coffeeBean) == false ||
				coffeeMachineList.contains(coffeeMachine) == false) {
			if (coffeeBeanList.contains(coffeeBean) == false)
				System.out.println("저희 매장에는 없는 커피 원두 입니다.");
			if (coffeeMachineList.contains(coffeeMachine) == false)
				System.out.println("저희 매장에는 없는 커피 머신 입니다.");
			return false;
		}
		return true;
	}
	
	public void	makeCoffee(String coffeeBean, String coffeeMachine) {
		if (isValidOrder(coffeeBean, coffeeMachine) == false)
			return;
		orderNumber++;
		Coffee coffee = new Coffee(this, coffeeBean, coffeeMachine);
		System.out.println("주문하신 커피가 제조되었습니다.");
		coffee.showCoffeeInfo();
	}
	
	public void setBasicCoffeeBean(String coffeeBean) {
		if (coffeeBeanList.contains(coffeeBean) == false)
			coffeeBeanList.add(coffeeBean);
		basicCoffeeBean = coffeeBean;
	}
	
	public void setBasicCoffeeMachine(String coffeeMachine) {
		if (coffeeMachineList.contains(coffeeMachine) == false)
			coffeeMachineList.add(coffeeMachine);
		basicCoffeeMachine = coffeeMachine;
	}
	
	public void addCoffeeBean(String coffeeBean) {
		if (coffeeBeanList.contains(coffeeBean) == false)
			coffeeBeanList.add(coffeeBean);
	}
	
	public void addCoffeeMachine(String coffeeMachine) {
		if (coffeeMachineList.contains(coffeeMachine) == false)
			coffeeMachineList.add(coffeeMachine);
	}
	
	public void removeCoffeeBean(String coffeeBean) {
		coffeeBeanList.remove(coffeeBean);
	}
	
	public void removeCoffeeMachine(String coffeeMachine) {
		coffeeMachineList.remove(coffeeMachine);
	}
	
	public int getCoffeeBeanNumber() {
		return coffeeBeanList.size();
	}
	
	public int getCoffeeMachineNumber() {
		return coffeeMachineList.size();
	}
	
	public void showCafeInfo() {
		System.out.println("스타벅스 reserve " + storeNumber + "호점 입니다.");
		System.out.println("사용하는 기본 커피 원두 : " + basicCoffeeBean);
		System.out.println("사용하는 기본 커피 머신 : " + basicCoffeeMachine);
		System.out.print("커피 원두 리스트 : " + coffeeBeanList.get(0));
		for (int i = 1; i < coffeeBeanList.size(); i++)
			System.out.print(", " + coffeeBeanList.get(i));
		System.out.println();
		System.out.print("커피 머신 리스트 : " + coffeeMachineList.get(0));
		for (int i = 1; i < coffeeMachineList.size(); i++)
			System.out.print(", " + coffeeMachineList.get(i));
		System.out.println();
		System.out.println("현재 주문은 " + orderNumber + "번 들어왔습니다.");
	}
}
