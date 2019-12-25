package com.app.fifth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    RecyclerView list;

    PostAdapter p = new PostAdapter();

    ArrayList<Post> posts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //   FakeData();
        list = findViewById(R.id.list);

        p.setPosts(posts);

        list.setAdapter(p);

        LinearLayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        list.setLayoutManager(lm);

    }

    @Override
    protected void onResume() {
        super.onResume();
        DBhelper d = new DBhelper(this);
        posts = d.allPosts();
        p.setPosts(posts);
        p.notifyDataSetChanged();
    }

    void FakeData() {
        for (int i = 0; i < 30; i++) {

            Post p = new Post();
            p.setName("Ahmed" + i);
            p.setTime(new Date().toString());
            p.setPostDes("yjhhl;kasdasdasaaaaaaaaaa" +
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "aaaaaaaaaaaaaaa");
            posts.add(p);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.add) {
            Intent n = new Intent(this, AddPostActivity.class);
            startActivity(n);
        }

        return true;
    }
}
