package App;

import java.util.List;
import java.util.Scanner;

public class ProtoMain {
    List<Threads> allThreads;

    public void programCommunicator() {
        Scanner scan = new Scanner(System.in);
        boolean x = false;
        int input;
        Threads currentThread = new Threads("First");
        User currentUser = new User("Guest");
        List<Post> temp;
        UserSystem willBeCombinedInTheFuture = new UserSystem();

        System.out.println("Press 1 to login as a user\n Press 2 to create a thread \n press 3 to enter a thread \n press 4 to post in a thread you've entered. \n press 5 to upvote a post \n press 6 to sticky a post. \n");
        System.out.println("Press 7 to delete a post \n Press 8 to edit a post. \n Press 9 to search this thread. \n enter 10 to quit.");

        input = scan.nextInt();
        scan.nextLine();

        while (x == false) {
            switch (input) {
                case 1: // Login as a user.
                    System.out.println("Please enter your username.");
                    currentUser = willBeCombinedInTheFuture.retrieveUser(scan.nextLine());

                case 2:   //Create a thread;
                    System.out.println("Enter title of thread.");
                    String title = scan.nextLine();
                    createThread(title);
                case 3:  // Enter a thread by pushing on it in the app.
                    System.out.println("Enter title of app you are going to enter"); // In the app this is going to be connected to a icon with the title of the thread.
                    title = scan.nextLine();
                    currentThread = enteringThread(title);
                case 4:   // Post in a thread.
                    System.out.println("Enter what you want to write.");
                    String content = scan.nextLine();
                    postInThread(currentThread, content, currentUser );
                case 5:   // upvote
                    System.out.println("What post do you upvote in the thread?");
                    int whatPost = scan.nextInt();
                    temp = currentThread.getPosts();
                    temp.get(whatPost).getUpvoteDownvote();
                case 6: // Sticky
                    System.out.println("What post are you going to sticky?");
                    int stickiedPost = scan.nextInt();
                    currentThread.stickyPost(stickiedPost);
                case 7: // Delete post
                    System.out.println("What post do you want to sticky?");
                    int postBegone = scan.nextInt();
                    currentThread.deletePost(postBegone, currentUser.hashCode());
                case 8: // Edit post
                    System.out.println("What post do you want to edit?");
                    int grammarError = scan.nextInt();
                    scan.nextLine();
                    System.out.println("What is the new content going to be?");
                    String editedPost = scan.nextLine();
                    currentThread.editPost(grammarError, currentUser.hashCode(),editedPost);
                case 9: // Search posts.
                    System.out.println("What are you searching for?");
                    String search = scan.nextLine();
                    temp = currentThread.searchPosts(search);
                    for (Post S: temp){
                        System.out.println(S.getContent());
                    }
                case 10: // quit
                x = true;
            }

        }
    }

    public void printAllThread(){ // This is the method intended to show the user all threads available. Will be improved.
        for (int i = 0; i<allThreads.size(); i++){
            System.out.println(allThreads.get(i).getTitle());
        }
    }

    public void createThread(String title){ // This is the method that creates threads.
        Threads newThread = new Threads(title);
        allThreads.add(newThread);
        System.out.println( title+ " has now been created as a thread.");
    }

    public void upvotePost(Post post){
        post.upvote();
    }

    public Threads enteringThread(String title){
        Threads currentThread = accessingThread(getThreadLocation(title));
        for (int i = 0; i<currentThread.getSize(); i++){
         System.out.println(currentThread.getPosts().get(i));
         return currentThread;
     }
     return null;
    }

    public int getThreadLocation(String title){
        for (int i = 0; i<allThreads.size(); i++){
            if(allThreads.get(i).getTitle().equals(title)){
                return i;
            }
        }
        return -1;
    }


    public Threads accessingThread(int location){ // puts you into the thread and shows you all the messages.
        if(location <0){
            System.out.println("No Thread at that location.");
        }
        return allThreads.get(location);
    }

    public void postInThread(Threads currentThread, String content, User poster){ // you are going to have to create a variable that stores the thread you are currently in,
        int locationOfPost = currentThread.getPosts().size();
        currentThread.newPost(content, poster.hashCode());
        List<Post> temp =currentThread.getPosts();
        System.out.println(temp.get(locationOfPost).getContent());



    }
}
