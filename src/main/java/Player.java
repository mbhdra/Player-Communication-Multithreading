// base class of players
// MessageBuffer object is here because it is used by both players
// sent message count is common for both players

public abstract class Player {
	
	protected int sentMessageCount;
	protected String message;
	protected MessageBuffer messageBuffer;
	
	public Player(MessageBuffer messageBuffer) {
		this.messageBuffer = messageBuffer;
		this.sentMessageCount = 0;
		this.message = "";
	}
	
	public int getSentMessageCount() {
		return sentMessageCount;
	}
	
	public void setSentMessageCount(int sentMessageCount) {
		this.sentMessageCount = sentMessageCount;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public MessageBuffer getMessageBuffer() {
		return messageBuffer;
	}
	
	public void setMessageBuffer(MessageBuffer messageBuffer) {
		this.messageBuffer = messageBuffer;
	}
}