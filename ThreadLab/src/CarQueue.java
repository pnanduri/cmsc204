import java.util.*;
public class CarQueue {
Random rand =  new Random();
Queue<Integer> q;

	public CarQueue() {
		//new linked list
		q = new LinkedList<>();
		q.add(0);
		q.add(1);
		q.add(3);
		q.add(2);
		q.add(2);
	}
	
	public void addToQueue() {
		class Run implements Runnable{
		public void run() {
			try{
				while (true) {
					//adds to the queue
					q.add(rand.nextInt(4));
					//sleep
					Thread.sleep(100);
				}
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		}
		//create carRun from Run
		Run carRun = new Run();
		Thread carThread = new Thread(carRun);
		//Start
		carThread.start();
		
	}
	
	public int deleteQueue() {
		//removes from the queue
		return q.remove();
	}
	
	
}
