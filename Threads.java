package App;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Threads {
    private String title;
    private List<Post> posts; // The posts.
    private List<Post> stickiedPosts; // A seperate list of posts that is filled with the important ones.
    private double amountOfPosts; // How many posts have been created. Mainly used to give an ID to posts.
    private int amountOfStickies; // How many stickies have been created.

    Threads(String title){
    this.title = title;
    posts  = new ArrayList<Post>();
    stickiedPosts = new ArrayList<Post>();
    amountOfPosts = 0;

}

    public void newPost(String content, int userHashCode){
        Post newPost = new Post(content, userHashCode, amountOfPosts); // what is in it. Who created it. Its ID.
        posts.add(newPost);
        amountOfPosts += 1;
    } // Used to create a new post.

    public void deletePost(int postLocation, int userHashCode) {
        if (userHashCode == posts.get(postLocation).getWhoPostedIt()) { // Can only be removed by the same person who created it.
        posts.remove(postLocation);
    }
    return;
} // Used to remove posts.

    public void editPost(int postLocation, int userHashCode, String content) {
        if (userHashCode == posts.get(postLocation).getWhoPostedIt()) {
            posts.get(postLocation).editContent(content);
        }
        return;
    } // used to edit the text in the post.

    public void stickyPost(int postLocation){ //
       stickiedPosts.set(amountOfStickies, posts.get(postLocation));
       posts.remove(postLocation);
       amountOfStickies +=1;
    } // Used to denote a post of extra importance.

    public int getPostLocation(int postNumber){
        for (int i = 0; i<posts.size(); i++){
            if(postNumber == posts.get(i).getPostNumber()){
                return i;
            }
        }
        return -1; // didn't find anything
    } // get the location in the thread. Intended to let people link to it.

    public List searchPosts(String search){
        List<Post> foundPosts = new ArrayList<Post>();
        for (int i = 0; i<amountOfPosts; i++){
            if(posts.get(i).getContent().contains(search)){
                foundPosts.add(posts.get(i));
            }
        }
        return foundPosts;
    } // Search all posts in a thread for certain words or sentences.
    
    

    public List getPosts(){
    return posts;
    }
    public int getSize(){
        return posts.size();
    }

    public List<Post> getStickiedPosts() {
        return stickiedPosts;
    }

    public double getAmountOfPosts() {
        return amountOfPosts;
    }

    public int getAmountOfStickies() {
        return amountOfStickies;
    }

    public String getTitle() {
        return title;
    }
}

