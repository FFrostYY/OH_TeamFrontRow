package App;

import java.util.List;

public class Inbox { // Meant to be connected with a profile.

    private int unseenMessages; // how many messages are currently unseen

    private List<Integer> personalMessages; // Stores the locations of the posts that the user has been notified of

    Inbox(){

        unseenMessages = 0;

    }

    public void sawMessages(){// Meant to be activated when the user sees the notifications.

        unseenMessages = 0;

    }

    public void newMessage(int postLocation){// send in the postNumber of the post that notified this person

        personalMessages.set(unseenMessages, postLocation);

        unseenMessages +=1;

    }

    public void clearMessages(){ // removes all the notification locations.

        for(int i = personalMessages.size()-1; i>0; i--){

            personalMessages.set(i, 0);

        }

    }

    public List<Integer> getPersonalMessages() {

        return personalMessages;

    }

    public int getUnseenMessages() {

        return unseenMessages;

    }

}