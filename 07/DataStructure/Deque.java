package stackqueue;

public class Deque extends LinearList {

	@Override
	public void pop() {
		if (data.isEmpty())
			return;
		data.remove(data.size() - 1);
	}
	
	public void popFront() {
		if (data.isEmpty())
			return;
		data.remove(0);
	}
	
	public void pushFront(int num) {
		data.add(0, num);
	}
	
	@Override
	public void showDataInfo() {
		System.out.print("This is Deque, ");
		if (data.isEmpty())	{
			System.out.println("Empty Deque");
			return;
		}
		else {
			System.out.println("Deque size : " + size());
		}
		System.out.print("bottom -> [ ");
		for (int factor : data) {
			System.out.print(factor + " ");
		}
		System.out.println("] <- top");
	}

}
