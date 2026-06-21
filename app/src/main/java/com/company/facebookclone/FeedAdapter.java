package com.company.facebookclone;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private OnPostClickListner listner;

    public void setOnPostClickListner(OnPostClickListner listner){
        this.listner =listner;
    }

    public void addPost(Post post){
        postList.add(0,post);
        notifyItemInserted(0);
    }
    public boolean deletePost(int postion){
        if (postList.get(postion)==null){
            return false;
        }
        postList.remove(postion);
        notifyItemRemoved(postion);
        return true;
    }

    public void update(int position ,String updateName,String updatetext ){
        Post post = postList.get(position);
        post.setName(updateName);
        post.setPostText(updatetext);
        notifyItemChanged(position);

    }

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


        holder.itemView.setOnClickListener(v->{
            if (listner !=null){
                listner.onPostClick(holder.getAbsoluteAdapterPosition(),post);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(holder.itemView.getContext())
                        .setTitle(R.string.delete_post_title)
                        .setIcon(R.drawable.outline_delete_24)
                        .setMessage(R.string.delete_post_massage)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                return;
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                deletePost(holder.getAbsoluteAdapterPosition());
                            }
                        });

                builder.show();

                return true;


            }
        });
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
