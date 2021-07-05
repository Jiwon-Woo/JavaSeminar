package stackqueue;
import java.util.ArrayList;

public abstract class LinearList {

	protected ArrayList<Integer> data = new ArrayList<Integer>();
	
//	public abstract void push(int num);
	public abstract void pop();
	public abstract void showDataInfo();
	
	public void push(int num) {
		data.add(num);
	}
	
	public int size() {
		return(data.size());
	}
	
	public int top() {
		return(data.get(data.size() - 1));
	}
	
	public int bottom() {
		return(data.get(0));
	}
	
	public boolean isEmpty() {
		return(data.isEmpty());
	}
	
}
