package com.app.fifth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

public class AddPostActivity extends AppCompatActivity {

    EditText edName;
    EditText edPostDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        edName = findViewById(R.id.edName);
        edPostDes = findViewById(R.id.edPostDes);
    }

    public void Post(View view) {

        Post p = new Post();

        p.setName(edName.getText().toString());
        p.setPostDes(edPostDes.getText().toString());

        p.setTime(new Date().toString());

        DBhelper d = new DBhelper(this);

        d.InsertPost(p);

        finish();
    }
}
