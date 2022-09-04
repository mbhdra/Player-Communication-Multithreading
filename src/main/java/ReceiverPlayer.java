// class for receiver player

public class ReceiverPlayer extends Player implements Runnable {

	public ReceiverPlayer(MessageBuffer messageBuffer) {
		super(messageBuffer);
	}

	@Override
	public void run() {
		
		System.out.println("Receiver thread started.");
		
		while(true) {
			
			// receive message from initiator
			message = messageBuffer.getFromInitiator();
			
			// terminate if FINISH message comes from initiator
			if(message.equals("FINISH")) {
				
				System.out.println("Receiver has received \"FINISH\" message from initiator. Receiver thread is terminating...");
				break;	
			}
			
			System.out.println("Receiver received message from initiator: " + message);
			
			// send message to initiator
			// attach sent message count to end of the received message
			// exclude the message being sent in this cycle from the sent message count
			messageBuffer.sendToReceiver(message + " " + String.valueOf(sentMessageCount));
			sentMessageCount++;	
		}
	}
}