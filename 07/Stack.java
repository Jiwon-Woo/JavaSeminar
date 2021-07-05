package stackqueue;

public class Stack extends LinearList {

	@Override
	public void pop() {
		if (data.isEmpty())
			return;
		data.remove(data.size() - 1);
	}

	@Override
	public void showDataInfo() {
		System.out.print("This is Stack, ");
		if (data.isEmpty()) {
			System.out.println("Empty Stack");
			return;
		}
		else {
			System.out.println("Stack size : " + size());
		}
		System.out.print("bottom -> [ ");
		for (int factor : data) {
			System.out.print(factor + " ");
		}
		System.out.println("] <- top");
	}
}
