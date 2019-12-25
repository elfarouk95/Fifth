package com.app.fifth;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostHodler> {

    ArrayList<Post> posts = new ArrayList<>();

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    Context context;

    @NonNull
    @Override
    public PostHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.postitem, viewGroup, false);
        PostHodler p = new PostHodler(v);
        return p;
    }

    @Override
    public void onBindViewHolder(@NonNull PostHodler postHodler, int i) {

        postHodler.PostDes.setText(posts.get(i).getPostDes());
        postHodler.Name.setText(posts.get(i).getName());
        postHodler.TimeD.setText(posts.get(i).getTime());

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
}
