public class App {
    public static void main(String[] args) throws InterruptedException {
       
    	System.out.println("Communication is starting between initiator and receiver...");
    	Thread.sleep(2000);
    	
    	// common buffer object shared through player objects
    	MessageBuffer mb = new MessageBuffer();
    	
    	// two player objects that communicate 
    	// initiator starts and finishes the program while receiver only sends and receives messages
    	// base class of them is abstract player class holding common attributes
    	InitiatorPlayer initiatorPlayer = new InitiatorPlayer(mb);
    	ReceiverPlayer receiverPlayer = new ReceiverPlayer(mb);

    	// instantiation of initiator and receiver thread objects 
		Thread initiatorThread = new Thread(initiatorPlayer);
		Thread receiverThread = new Thread(receiverPlayer);
		
		// threads are starting
		initiatorThread.start();
		Thread.sleep(2000);
		receiverThread.start();
		
		// main thread waits them to terminate
		initiatorThread.join();
		receiverThread.join();
		
		Thread.sleep(2000);
		System.out.println("Initiator and receiver threads terminated.");
		Thread.sleep(2000);
		System.out.println("Main thread is terminating...");
		Thread.sleep(2000);
		System.out.println("Main thread terminated.");
    }
}