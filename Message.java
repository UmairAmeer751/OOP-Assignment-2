package OOPAssignment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {

    private String receiverNo;
    private String msgMaterial;
    private String messageId;
    private boolean status;
    private LocalDateTime dateTime;
    static int count = 0;

    // Parametrized Constructor
    Message( String receiverNo, String msgMaterial,boolean status) {
        this.receiverNo = receiverNo;
        this.msgMaterial = msgMaterial;
        this.status = status;
        this.messageId = String.format("%03d",++count);
        this.dateTime = LocalDateTime.now();

    }

    // Getters and Setters
    public void setStatus(boolean status){
        this.status = status;
    }

    public boolean getStatus(){
        return status;
    }

    public String getReceiverNo() {
        return receiverNo;
    }

    public String getMsgMaterial() {
        return msgMaterial;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getFormattedDateTime() {
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return dateTime.format(myFormat);
    }

    // Display Method
    public String toString() {
        return "Id: " + messageId +
                ", Receiver: " + receiverNo +
                ", Message: " + msgMaterial +
                ", Status: " + status +
                ", Time: " + getFormattedDateTime();
    }


}