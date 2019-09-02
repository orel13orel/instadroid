package com.example.instadroid.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;

@Entity
    public class Post implements Serializable {
        @NonNull
        @PrimaryKey
        private String postid;
        private String postimage;
        private String description;
        private String publisher;

    @Ignore
        public Post(@NonNull String postid,@NonNull String postimage,@NonNull String description,@NonNull String publisher) {
            this.postid = postid;
            this.postimage = postimage;
            this.description = ""+description;
            this.publisher = publisher;
        }

        public Post() {}

        public String getPostid() {
            return postid;
        }

        public void setPostid(String postid) {
            this.postid = postid;
        }

        public String getPostimage() {
            return postimage;
        }

        public void setPostimage(String postimage) {
            this.postimage = postimage;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(postid, post.postid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postid);
    }

    @Override
    public String toString() {
        return "Post{" +
                "postid='" + postid + '\'' +
                ", postimage='" + postimage + '\'' +
                ", description='" + description + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
    }
