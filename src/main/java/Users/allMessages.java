package Users;

import Tools.InputClass;

import java.util.ArrayList;

public class allMessages {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private ArrayList<Message> allMessages = new ArrayList<>();
    private static volatile allMessages soloAllMessages = new allMessages();
    static addedMembers AddedMembers = addedMembers.getInstance();
    static InputClass printOutput = new InputClass();

    private allMessages(){

    }
    public static allMessages getInstance(){
        if(soloAllMessages == null){
            soloAllMessages = new allMessages();
        }
        return soloAllMessages;
    }
    public ArrayList<Message> getAllMessages(){
        return allMessages;
    }
    public void sendMessage() {
        String Sender = printOutput.readLine("Please enter your username: ");
        String Receiver = printOutput.readLine("Please enter receiver username: ");
        String Status = "Unread";
        ArrayList<Member> allMembers = AddedMembers.getAllMembers();

        for (Member member : allMembers){
            if (member.getUsername() != null && member.getUsername().equals(Receiver)) {
                String Content = printOutput.readLine("Type message: ");
                Message newMessage = new Message(Sender, Receiver, Content, Status);
                allMessages.add(newMessage);
                printOutput.printLine(ANSI_GREEN+"Your message has been sent!"+ANSI_RESET);
            } else{
                printOutput.printLine(ANSI_RED+"\nReceiver not found"+ANSI_RESET);//prints even if the message is sent
                return;
            }
        }
    }
    public void readMessage(){
        String username = printOutput.readLine("Please enter your username: ");
        for(Message message: allMessages){
            if(message.getReceiver().equals(username) && message.getStatus().equals("Unread")){
                printOutput.printLine("New messages: ");
                printOutput.printLine("From " + message.getSender() + ":");
                printOutput.printLine(message.getContent());
                message.changeStatus();
            }else if (message.getReceiver().equals(username) && message.getStatus().equals("Read")){
                printOutput.printLine("Read messages: ");
                printOutput.printLine("From " + message.getSender() + ":");
                printOutput.printLine(message.getContent());
            }else{
                printOutput.printLine("No new messages");
                return;
            }
        }
    }
    public void loadFromFile(ArrayList<Message> savedMessages){
        this.allMessages = savedMessages;
    }
}
