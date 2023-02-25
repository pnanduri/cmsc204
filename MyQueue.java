import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T> {

	int size;
	int index=-1;
	ArrayList<T> q = new ArrayList<T>();
	
	public MyQueue(int size) {
		this.size = size;
		
	}
	
	public MyQueue() {
		
	}
	
	public boolean isEmpty() {
		if (index==-1) {
			return true;
		}
		
		else {
			return false;
		}
		
		
	}
	
	public boolean isFull() {
		
		if (index+1==size) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public T dequeue() throws QueueUnderflowException{
		if(!isEmpty()) {
			index=index-1;
			
			
			return(q.remove(0));
		}
		
		throw new QueueUnderflowException();
		
	}
	
	public int size() {
		int newSize = index+1;
		
		return newSize;
	}
	
	public boolean enqueue(T e) throws QueueOverflowException{
		
		if (!isFull()) {
			
			index=index+1;
			q.add(e);
			return true;
		}
		
		throw new QueueOverflowException();
	}
	
	public String toString() {
		
		String rep = "";
		
		for (int count =0; count < q.size(); count++) {
			T x = q.get(count);
			if(x == null) {
				
			}
			else {
				rep = rep + x;
			}
		}
		return rep;
	}
	
	public String toString(String delimiter) {
		String rep = "";
		for (int count = 0; count<q.size();count++) {
			T x = q.get(count);
			if (x == null) {
			}
			else {
				rep = rep + x + delimiter;
			}
		}
		
		rep = rep.substring(0, rep.length()-1);
		
		return rep;
		
	}
	
	public void fill(ArrayList<T> rep) {
		ArrayList<T> q2 = new ArrayList<T>();
		for (int count = 0; count< rep.size(); count++) {
			T x = rep.get(count);
			q2.add(x);
		}
		
		for (int count = 0; count < q2.size(); count++) {
			T x = q2.get(count);
			try {
				enqueue(x);
			}
			
			catch(QueueOverflowException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}
