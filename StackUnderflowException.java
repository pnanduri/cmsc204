
public class StackUnderflowException extends Exception {

	public StackUnderflowException() {
		super("You cannot pop or top on an empty stack.");
	}
}
