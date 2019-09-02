package com.example.instadroid.Controller;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.instadroid.model.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("select * from User")
    List<User> getAll();

    @Query("select * from User")
    LiveData<List<User>> getAllUsers();

    @Query("select * from User where id = :id")
    User get(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(User... Users);

    @Insert
    void insert(List<User> Users);

    @Update
    void update(User User);

    @Delete
    void delete(User User);

    @Query("Delete From User")
    void deleteAllUsers();
}

