import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T> {

	int size;
	int index=-1;
	ArrayList<T> s;
	
	public MyStack() {
		s = new ArrayList<T>(size);
	}
	
	public MyStack(int size) {
	this.size=size;
	s = new ArrayList<T>(this.size);
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
	public T pop() throws StackUnderflowException{
		
		if (!isEmpty()) {
			index=index-1;
			return(s.set(index+1, null));
		}
		throw new StackUnderflowException();
	}
	
	public T top() throws StackUnderflowException {
		
		if (!isEmpty()) {
			return(s.get(index));
		}
		
		throw new StackUnderflowException();
	}
	
	
	public int size() {
		int size2=index+1;
		
		return size2;
	}
	
	public boolean push(T e) throws StackOverflowException{
		if(isFull()) {
			throw new StackOverflowException();
		}
		index=index+1;
		if(index>=s.size()) {
			s.add(e);
		}
		else {
			s.set(index, e);
		}
		return true;
	}
	
	public String toString() {
		String rep = "";
		for (int count = 0; count <s.size(); count++) {
			T x = s.get(count);
			if (x!=null) {
				rep= rep + x;
			}
		}
		return rep;
	}
	
	public String toString(String delimiter) {
		String rep = "";
		for (int count = 0; count< s.size(); count++) {
			T x = s.get(count);
			if(x!=null) {
				rep = rep+ x + delimiter;
			}
		}
		rep = rep.substring(0, rep.length()-1);
		return rep;
	}
	
	public void fill(ArrayList<T> rep) {
		ArrayList<T> s2 = new ArrayList<>();
		for (int count =0; count<rep.size(); count++) {
			T d = rep.get(count);
			s2.add(d);
		}
		for (int count =0; count<s2.size(); count++) {
			T d = s2.get(count);
			try {
				push(d);
			}
			catch(StackOverflowException e ){
				e.printStackTrace();
			}
		}
	}
}
