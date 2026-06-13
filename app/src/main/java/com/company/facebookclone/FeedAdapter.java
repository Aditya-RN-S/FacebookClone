package com.company.facebookclone;

import android.media.MediaDrm;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Post> postList;

    public FeedAdapter(List<Post> postList){
        this.postList = postList;
    }

    @Override
    public int getItemViewType(int position){
        return postList.get(position).getViewType();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent , int viewType){
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_base_post,parent,false);

        FrameLayout container = view.findViewById(R.id.contentContainer);

        if (viewType == Post.TEXT_TYPE){
            LayoutInflater.from(parent.getContext()).inflate(R.layout.content_text_post,container,true);
            return new TextViewHolder(view);
        }
        else {
            LayoutInflater.from(parent.getContext()).inflate(R.layout.content_image_post, container, true);

            return new ImageViewHolder(view);
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder , int position){
        Post post = postList.get(position);

        ((FeedViewHolder)holder).bindCommondata(post);

        if (getItemViewType(position) == Post.TEXT_TYPE){
            ((TextViewHolder)holder).bindTextData(post);
        }else {
             ((ImageViewHolder)holder).bindImageData(post);
        }
    }

    @Override
    public int getItemCount(){
        return postList.size();
    }

  static class FeedViewHolder extends RecyclerView.ViewHolder{
      TextView  posttimeTextView , profileNametextView;
      ImageView profileImage;
      public FeedViewHolder(View view){
          super(view);

          posttimeTextView = view.findViewById(R.id.postTime);
          profileImage = view.findViewById(R.id.profilepic);
          profileNametextView = view.findViewById(R.id.profileName);
      }

      public void bindCommondata(Post post){
          profileNametextView.setText(post.getName());
          posttimeTextView.setText(post.getTime());
      }
  }


  public static class TextViewHolder extends FeedViewHolder{

        TextView posttextOnly;

        public TextViewHolder(@NotNull View viewItem){
            super(viewItem);
            posttextOnly = viewItem.findViewById(R.id.postTextOnly);
        }

        public void bindTextData(Post post){
            posttextOnly.setText(post.getPostText());
        }
  }



  public static class ImageViewHolder extends FeedViewHolder{

        ImageView postImageOnly;
        TextView postImageCaption;
        public ImageViewHolder(View viewItem){

            super(viewItem);

            postImageOnly =viewItem.findViewById(R.id.postImageView);
            postImageCaption = viewItem.findViewById(R.id.postImageCaption);
        }

        public void bindImageData(Post post){
            postImageCaption.setText(post.getPostText());
        }

  }

}
