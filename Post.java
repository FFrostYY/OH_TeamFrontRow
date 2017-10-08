package App;
import java.util.List;
import java.util.Scanner;

public class Post {
    private int whoPostedIt; // The hashcode of the user who posted the post.
    private String content; // The actual text in the post.
    private int upvoteDownvote; // how many people have upvoted something.
    private double postNumber; // Something akin to an ID.


    Post(String content, int userHashCode, double postNumber){
        this.content = content;
        whoPostedIt = userHashCode;
        upvoteDownvote = 0;
        this.postNumber = postNumber;
    }

    public void upvote(){ // not an actual upvote but it is instead intended to be used to show how many people have seen a message.
        upvoteDownvote += 1;
    }

    public void notification(Inbox notifiedPerson, int postLocation){ // Notify another user.
        notifiedPerson.newMessage(postLocation);
    }

    public int getWhoPostedIt() {
        return whoPostedIt;
    }

    public int getUpvoteDownvote() {
        return upvoteDownvote;
    }

    public void editContent(String content){ // This changes the content.
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public double getPostNumber() {
        return postNumber;
    }
}
