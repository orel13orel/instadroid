package com.example.instadroid.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@Entity
public class User implements Serializable {
    @PrimaryKey
    @NonNull
    private String id;

    private String username;
    private String fullname;
    private String imageurl;
    private String bio;


    public User(String id, String username, String fullname, String imageurl, String bio) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.imageurl = imageurl;
        this.bio = bio;
    }

    public User(){

    }

    private User(User user){
        this.id = user.id;
        this.username = user.username;
        this.fullname = user.fullname;
        this.imageurl = user.imageurl;
        this.bio = user.bio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public User clone() {
        return new User(this);
    }


    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("username", username);
        result.put("fullname", fullname);
        result.put("imageurl", imageurl);
        result.put("bio", bio);

        return result;
    }
}
