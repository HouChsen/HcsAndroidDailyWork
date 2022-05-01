package com.he.weekeight;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by 86186 on 2022/4/24.
 */


public class LibraryDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "library.db";//自己起的名字
    private static final String READERS = "readers";//自己建立的表的名字
    private static final String BOOKS = "books";//自己建立的表的名字
   // private static final String BORROWS = "borrows";//自己建立的表的名字
    public LibraryDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_READERS =//自己建立的表
                "create table readers(" +
                        "reader_id integer primary key," +
                        "reader_number text," +
                        "reader_name text," +
                        "reader_type text," +
                        "reader_phone text," +
                        "reader_password text ," +
                        "reader_createtime text)";
        sqLiteDatabase.execSQL(CREATE_READERS);
        String CREATE_BOOK =//自己建立的表
                "create table books(" +
                        "book_id integer primary key," +
                        "book_name text," +
                        "book_author text, " +
                        "book_publisher text," +
                        "book_intime text," +
                        "book_counts integer)";
        sqLiteDatabase.execSQL(CREATE_BOOK);
    }
    public void insert_reader(Reader reader){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        Log.d("文件位置",sqLiteDatabase.getPath());
        ContentValues values = new ContentValues();
        values.put("reader_number", reader.getReader_number());
        values.put("reader_name", reader.getReader_name());
        values.put("reader_type", reader.getReader_type());
        values.put("reader_phone", reader.getReader_phone());
        values.put("reader_createtime", reader.getReader_createtime());
        values.put("reader_password", reader.getReader_password());
        sqLiteDatabase.insert("readers", null, values);
        sqLiteDatabase.close();
    }
    public int delete_reader(String reader_num){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        int result = sqLiteDatabase.delete("readers",
                "reader_number = ?",
                new String[]{reader_num});
        sqLiteDatabase.close();
        return result;
    }
    public int update_reader(Reader reader){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String reader_num = reader.getReader_number();
        ContentValues values = new ContentValues();
        values.put("reader_name", reader.getReader_name());
        values.put("reader_type", reader.getReader_type());
        values.put("reader_phone", reader.getReader_phone());
        values.put("reader_createtime", reader.getReader_createtime());
        values.put("reader_password", reader.getReader_password());
        int result = sqLiteDatabase.update("readers",
                values,
                "reader_number = ?",
                new String[]{reader_num});
        sqLiteDatabase.close();
        return result;
    }
    @SuppressLint("Range")
    public Cursor query_reader(String reader_num){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query("readers",null,
                "reader_number LIKE ?", new String[]{"%" + reader_num + "%"},
                null, null, null, null);
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
