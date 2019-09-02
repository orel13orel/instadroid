package com.example.instadroid.Controller;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.instadroid.model.Post;

import java.util.List;

@Dao
public interface PostDao {
    @Query("select * from Post")
    List<Post> getAll();

    @Query("select * from Post")
    LiveData<List<Post>> getAllPosts();

    @Query("select * from Post where postid = :id")
    Post get(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Post... Posts);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Post Post);

    @Update
    void update(Post Post);

    @Delete
    void delete(Post Post);

    @Query("Delete From Post")
    void deleteAllPosts();
}

