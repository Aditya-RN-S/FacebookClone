package com.company.facebookclone;

public class Post {
    public static final int TEXT_TYPE =0;
    public static final int TEXT_IMAGE =1;


    private int viewType;
    private String name , time ,postText,imageUrl;


    public Post() {
    }

    public Post(int viewType , String name , String time , String postText){
        this.postText=postText;
        this.name=name;
        this.viewType= viewType;
        this.time=time;
    }
    public Post(int viewType , String name , String time , String postText, String imageUrl){
        this.postText=postText;
        this.imageUrl=imageUrl;
        this.name=name;
        this.viewType= viewType;
        this.time=time;
    }

    public String getTime() {
        return time;
    }

    public String getPostText() {
        return postText;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName(){
        return name;
    }
    public int getViewType(){
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
