
public class QueueOverflowException extends Exception{

	public QueueOverflowException() {
		super("You cannot enqueue onto a full queue");
	}
}
