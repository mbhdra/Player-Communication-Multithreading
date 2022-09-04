// message buffer class to maintain communication between players
// it has two string fields
// one maintains the stream from initiator to receiver, other one maintains the stream from receiver to initiator

public class MessageBuffer {

	private String initiatorString;
	private String receiverString;
	private boolean initiatorStringStatus;
	private boolean receiverStringStatus;		

	public MessageBuffer() {
		this.initiatorString = "";
		this.receiverString = "";
		this.initiatorStringStatus = true;
		this.receiverStringStatus = true;
	}

	// data insertion to initiator stream
	// initiator player uses it
	public synchronized void sendToInitiator(String s) {
		
		while(initiatorStringStatus == false) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		initiatorString = s;
		initiatorStringStatus = false;
		notify();
	}
	
	// data acquisition from initiator stream
	// receiver player uses it
	public synchronized String getFromInitiator() {
		
		while(initiatorStringStatus == true) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String message = initiatorString;
		initiatorStringStatus = true;
		notify();
		return message;
	}
	
	// data insertion to receiver stream
	// receiver player uses it
	public synchronized void sendToReceiver(String s) {
		
		while(receiverStringStatus == false) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		receiverString = s;
		receiverStringStatus = false;
		notify();
	}
	
	// data acquisition from receiver stream
	// initiator player uses it
	public synchronized String getFromReceiver() {
		
		while(receiverStringStatus == true) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String message = receiverString;
		receiverStringStatus = true;
		notify();
		return message;
	}
}