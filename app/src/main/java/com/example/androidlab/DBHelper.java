package com.example.androidlab;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATA_VERSION = 1;

    public DBHelper(Context context){ //이거 생성자다
        super(context, "memodb", null, DATA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){  //DB table짜기
        String memoSQL = "create table tb_memo (" +
                "_id integer primary key autoincrement, "+
                "title, "+
                "content)";
        db.execSQL(memoSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        if(newVersion == DATA_VERSION){
            db.execSQL("drop table tb_memo");
            onCreate(db);
        }
    }

}
