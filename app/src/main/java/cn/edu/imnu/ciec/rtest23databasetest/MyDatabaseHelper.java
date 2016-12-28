package cn.edu.imnu.ciec.rtest23databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by HP301 on 2016/12/28.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String CREATE_BOOK="creat table Book(" +
            "id integer primary key autoincrement," +
            "author text,price real,pages integer,name text)";


    private static final String CREATE_CATEGORY="create table ategory(" +
            "id integer primary key autoincrement," +
            "categoty_name text," +
            "categoty_code integer)";


    private Context mContext;





    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, name, factory, version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        Toast.makeText(mContext,"Creat Database",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {//根据版本号自动触发
        db.execSQL("drop table if exits Book");
        db.execSQL("drop table if exists Category");
        onCreate(db);


    }
}
