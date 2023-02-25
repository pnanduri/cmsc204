
public class QueueUnderflowException extends Exception {

	public QueueUnderflowException() {
		super("You cannot Dequeue onto a empty queue");
	}
}
