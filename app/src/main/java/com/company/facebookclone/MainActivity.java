package com.company.facebookclone;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView feedRecyclerView;
    private FeedAdapter feedAdapter;
    private List<Post> samplePosts;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        feedRecyclerView = findViewById(R.id.feedRecyclerView);
        LinearLayoutManager feedLinearLayoutManager = new LinearLayoutManager(this);
        feedRecyclerView.setLayoutManager(feedLinearLayoutManager);

        createMockFeedData();


         feedAdapter = new FeedAdapter(samplePosts);
        feedRecyclerView.setAdapter(feedAdapter);

    }
     private void createMockFeedData(){
        samplePosts = new ArrayList<>();


         // Post 1: Text Only
         Post post1 = new Post();
         post1.setViewType(Post.TEXT_TYPE);
         post1.setName("Mark Zuckerberg");
         post1.setTime("2 hrs ago");
         post1.setPostText("Working on some massive updates for the metaverse today. Stay tuned! #coding");
         samplePosts.add(post1);

         // Post 2: Image Post
         Post post2 = new Post();
         post2.setViewType(Post.TEXT_IMAGE); // Will automatically trigger layout inflation for image layout
         post2.setName("Android Dev Community");
         post2.setTime("4 hrs ago");
         post2.setPostText("Check out this beautiful design setup for our new workspace!");
         samplePosts.add(post2);

         // Post 3: Another Text Only Post
         Post post3 = new Post();
         post3.setViewType(Post.TEXT_TYPE);
         post3.setName("John Doe");
         post3.setTime("Yesterday");
         post3.setPostText("Just finished implementing multiple view types in an Android RecyclerView. Feels amazing!");
         samplePosts.add(post3);
         // Post 1: Text Only
         Post post4 = new Post();
         post1.setViewType(Post.TEXT_TYPE);
         post1.setName("Mark Zuckerberg");
         post1.setTime("2 hrs ago");
         post1.setPostText("Working on some massive updates for the metaverse today. Stay tuned! #coding");
         samplePosts.add(post1);

         // Post 2: Image Post
         Post post5 = new Post();
         post2.setViewType(Post.TEXT_IMAGE); // Will automatically trigger layout inflation for image layout
         post2.setName("Android Dev Community");
         post2.setTime("4 hrs ago");
         post2.setPostText("Check out this beautiful design setup for our new workspace!");
         samplePosts.add(post2);

         // Post 3: Another Text Only Post
         Post post6 = new Post();
         post3.setViewType(Post.TEXT_TYPE);
         post3.setName("John Doe");
         post3.setTime("Yesterday");
         post3.setPostText("Just finished implementing multiple view types in an Android RecyclerView. Feels amazing!");
         samplePosts.add(post3);
         // Post 1: Text Only
         Post post7 = new Post();
         post1.setViewType(Post.TEXT_TYPE);
         post1.setName("Mark Zuckerberg");
         post1.setTime("2 hrs ago");
         post1.setPostText("Working on some massive updates for the metaverse today. Stay tuned! #coding");
         samplePosts.add(post1);

         // Post 2: Image Post
         Post post8 = new Post();
         post2.setViewType(Post.TEXT_IMAGE); // Will automatically trigger layout inflation for image layout
         post2.setName("Android Dev Community");
         post2.setTime("4 hrs ago");
         post2.setPostText("Check out this beautiful design setup for our new workspace!");
         samplePosts.add(post2);

         // Post 3: Another Text Only Post
         Post post9 = new Post();
         post3.setViewType(Post.TEXT_TYPE);
         post3.setName("John Doe");
         post3.setTime("Yesterday");
         post3.setPostText("Just finished implementing multiple view types in an Android RecyclerView. Feels amazing!");
         samplePosts.add(post3);
     }
}