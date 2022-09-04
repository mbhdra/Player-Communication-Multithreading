// class for initiator player
// holds counts for received messages additionally because it determines end of communication after 10 message sent and received

public class InitiatorPlayer extends Player implements Runnable {
	
	private int receivedMessageCount;
	
	public InitiatorPlayer(MessageBuffer messageBuffer) {
		super(messageBuffer);
		this.receivedMessageCount = 0;
	}

	@Override
	public void run() {
		
		System.out.println("Initiator thread started.");
		
		// initiator sends first message
		message = "Hello " + String.valueOf(sentMessageCount);
		messageBuffer.sendToInitiator(message);
		sentMessageCount++;
		
		while(true) {
			
			// receive message from receiver
			message = messageBuffer.getFromReceiver();
			System.out.println("Initiator received message from receiver: " + message);
			receivedMessageCount++;
			
			// terminate if 10 messages are sent and received
			// send FINISH message to receiver so it can also terminate
			if(receivedMessageCount == 10) {
				
				message = "FINISH";
				messageBuffer.sendToInitiator(message);
				System.out.println("Initiator sent and received 10 messages. Initiator thread is terminating...");
				break;	
			}
			
			// send message to receiver
			// attach sent message count to end of the received message
			// exclude the message being sent in this cycle from the sent message count
			messageBuffer.sendToInitiator(message + " " + String.valueOf(sentMessageCount));
			sentMessageCount++;
		}
	}
}