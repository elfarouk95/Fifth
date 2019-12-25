package com.app.fifth;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBhelper extends SQLiteOpenHelper {
    DBhelper(Context c) {
        super(c, "posts.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE \"Post\" (\n" +
                "\t\"ID\"\tINTEGER,\n" +
                "\t\"Name\"\tTEXT,\n" +
                "\t\"TimeD\"\tTEXT,\n" +
                "\t\"PostDes\"\tTEXT,\n" +
                "\t\"ImgUrl\"\tTEXT,\n" +
                "\tPRIMARY KEY(\"ID\")\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void InsertPost(Post p) {
        String q = String.format("INSERT INTO \"main\".\"Post\"\n" +
                "(\"Name\", \"TimeD\", \"PostDes\", \"ImgUrl\")\n" +
                "VALUES ('%s', '%s', '%s', '%s');", p.getName(), p.getTime(), p.getPostDes(), p.getImgUrl());

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(q);
    }

    public ArrayList<Post> allPosts() {
        SQLiteDatabase db = this.getReadableDatabase();

        ArrayList<Post> posts = new ArrayList<>();
        Cursor c = db.rawQuery("select * from Post ", null);

        c.moveToFirst();

        while (!c.isAfterLast()) {

            Post p = new Post();
            p.setName(c.getString(1));
            p.setTime(c.getString(2));
            p.setPostDes(c.getString(3));

            posts.add(p);
            c.moveToNext();
        }

        return posts;
    }
}
