
public class ArraySum {

	public int sumOfArray(Integer[] a, int index) {
		int newIndex=index-1;
		
		if (index<0) {
			return 0;
		}
		
		else {
			return a[index] + sumOfArray(a, newIndex);
		}
		
	}
	
	
}
