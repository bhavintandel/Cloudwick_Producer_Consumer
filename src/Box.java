import java.util.LinkedList;

/**
 * 
 * @author Bhavin Tandel
 * @since  10/03/2016; 12:41
 */
public class Box {
	private LinkedList<String> message ;
	private boolean empty;
	
	public Box(){
		empty = true;
	}
	
	public synchronized String take(){
		while(empty){
			try{
				//System.out.println("I am in take function");
				wait();
			}catch (InterruptedException e) {
				//System.out.println("I am in take function");
			}
		}
		notifyAll();
		empty = message.isEmpty();
		return message.pop();
	}
	
	public synchronized void put(String message){
		while(!empty){
			try{
				//System.out.println("I am in put function");

				wait();
			} catch (InterruptedException e) {
				//System.out.println("I am in take function");
			}
		}
		empty = message.isEmpty();
		this.message.push(message);
		notifyAll();

	}

}
