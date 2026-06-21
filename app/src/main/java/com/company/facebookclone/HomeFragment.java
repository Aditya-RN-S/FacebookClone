package com.company.facebookclone;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private RecyclerView feedRecycleView;
    private FeedAdapter feedAdapter;
    private FloatingActionButton btnOpen;
    private List<Post> samplePosts;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.from(container.getContext()).inflate(R.layout.fragment_home, container, false);

        feedRecycleView= view.findViewById(R.id.feedRecyclerView);
        feedRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));

        btnOpen = view.findViewById(R.id.btnFloat);

        createMockFeedData();

        feedAdapter = new FeedAdapter(samplePosts);
        feedRecycleView.setAdapter(feedAdapter);

        if (btnOpen!=null){
            btnOpen.setOnClickListener(v-> showMasterPostdialog(-1,null));
        }

        feedAdapter.setOnPostClickListner((position,post)->{ showMasterPostdialog(position,post);});
        return view;
    }

    private void showMasterPostdialog(final int position, @Nullable Post activePost){

        View dialogView = getLayoutInflater().inflate(R.layout.layout_post_input,null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext(),R.style.FbDialogTheme).setView(dialogView);

        final AlertDialog dialog = builder.create();

        TextView dialogTitle = dialogView.findViewById(R.id.dialogTitle);
        EditText etname = dialogView.findViewById(R.id.etName);
        EditText etcontent = dialogView.findViewById(R.id.etContent);
        Button btncancel = dialogView.findViewById(R.id.btnCancel);
        Button btnsave = dialogView.findViewById(R.id.btnSave);

        final Boolean isEditMode = (activePost!=null);

        if (isEditMode){
            dialogTitle.setText("edit post data");
            etname.setText(activePost.getName());
            etcontent.setText(activePost.getPostText());
            btnsave.setText("Save Changes");
        }

        btncancel.setOnClickListener(v->{dialog.dismiss();});

        btnsave.setOnClickListener(v->{
            String nameInput = etname.getText().toString().trim();
            String contentInput = etcontent.getText().toString().trim();
            if(nameInput.isEmpty()|| contentInput.isEmpty())return;

            if (isEditMode){
                feedAdapter.update(position,nameInput,contentInput);
            }
            else {
                Post freshPost = new Post();
                freshPost.setViewType(Post.TEXT_TYPE);
                freshPost.setName(nameInput);
                freshPost.setTime("Just Now");
                freshPost.setPostText(contentInput);

                feedAdapter.addPost(freshPost);
                feedRecycleView.scrollToPosition(0);
            }
            dialog.dismiss();
        });
        dialog.show();
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