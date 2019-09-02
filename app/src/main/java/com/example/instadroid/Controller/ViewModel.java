package com.example.instadroid.Controller;


import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.instadroid.model.Post;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class ViewModel extends androidx.lifecycle.ViewModel {

    final private static ViewModel instance = new ViewModel();

    public static ViewModel getInstance() {
        return instance;
    }
    private ViewModel() { }

    public LiveData<List<Post>> getPosts() { return new PostListData(); }


    public static void getAllPostsFromAllUsers(final Consumer<List<Post>> onComplete, final Consumer<Optional<Exception>> onFailed){
        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference PostsRef = databaseRef.child("Posts");
        PostsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Post> posts=new ArrayList<>();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Post post = snapshot.getValue(Post.class);
                    posts.add(post);
                }
                onComplete.accept(posts);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                onFailed.accept(Optional.ofNullable(databaseError.toException()));
            }
        });
    }
    class PostListData extends MutableLiveData<List<Post>> {
        @Override
        protected void onActive() {
            super.onActive();

            getAllPostsFromAllUsers(posts -> {
                Post[] array = posts.toArray(new Post[0]);

                //TODO check doubles in local db when insert the same agrs
                for (Post post : posts) {
                    Local.Database.addPosts(aVoid -> {},post);
                }

            }, e -> {});
            Local.Database.getLiveAllPosts(listLiveData -> {
                List<Post> value = listLiveData.getValue();

                if (value!=null)
                    setValue(value);
            });
        }
        @Override
        protected void onInactive() {
            super.onInactive();
        }
        public PostListData() {
            super();
            setValue(new LinkedList<>());
            Local.Database.getAllPosts(posts -> setValue(posts));
        }
    }
}

