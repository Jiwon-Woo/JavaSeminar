package stackqueue;

public class DataStructureTest {

	public static void main(String[] args) {
		
		LinearList stack = new Stack();
		LinearList queue = new Queue();
		
		System.out.println("===== Before push pop =====");
		stack.showDataInfo();
		queue.showDataInfo();
		System.out.println();
		
		stack.push(1);
		stack.push(11);
		stack.push(22);
		stack.push(33);
		stack.pop();
		
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.pop();
		
		System.out.println("\n===== After push pop =====");
		stack.showDataInfo();
		System.out.println();
		queue.showDataInfo();
		System.out.println();
		
		System.out.println("\n===== Top bottom size =====");
		System.out.println("stack top : " + stack.top());
		System.out.println("stack bottom : " + stack.bottom());
		System.out.println("stack size : " + stack.size());
		System.out.println();
		System.out.println("deque top : " + queue.top());
		System.out.println("deque bottom : " + queue.bottom());
		System.out.println("deque size : " + queue.size());
	}

}
