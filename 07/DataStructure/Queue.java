package stackqueue;

public class Queue extends LinearList {

	@Override
	public void pop() {
		if (data.isEmpty())
			return;
		data.remove(0);
	}
	
	@Override
	public void showDataInfo() {
		System.out.print("This is Queue, ");
		if (data.isEmpty()) {
			System.out.println("Empty Queue");
			return;
		}
		else {
			System.out.println("Queue size : " + size());
		}
		System.out.print("bottom -> [ ");
		for (int factor : data) {
			System.out.print(factor + " ");
		}
		System.out.println("] <- top");
	}

}
