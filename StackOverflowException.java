
public class StackOverflowException extends Exception {

	public StackOverflowException() {
		super("You cannot push onto a full stack.");
	}
}
