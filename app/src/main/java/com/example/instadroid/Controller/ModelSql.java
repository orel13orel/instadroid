package com.example.instadroid.Controller;

import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.instadroid.MyApplication;
import com.example.instadroid.model.Post;
import com.example.instadroid.model.User;

@Database(entities = {Post.class, User.class}, version = 2)
// , exportSchema = false
public abstract class ModelSql extends RoomDatabase{

    public abstract PostDao postDao();
    public abstract UserDao userDao();


    private static ModelSql instance;
    public static synchronized ModelSql getInstance() {
        if (instance==null){
            instance = Room.databaseBuilder(MyApplication.getContext(),
                    ModelSql.class,
                    "database.db")
                    .fallbackToDestructiveMigration()
                    .addCallback(callback)
                    .build();
        }
        return instance;
    }



    private static RoomDatabase.Callback callback=new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsync().execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }

}