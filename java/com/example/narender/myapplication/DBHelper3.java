package com.example.narender.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by narender on 16/1/18.
 */

public class DBHelper3 extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuiz";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    private static final String KEY_CON="counter";
    private static final String KEY_FAL="faltu";

     SQLiteDatabase db;
    public DBHelper3(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT,"+KEY_CON+" INTEGER,"+KEY_FAL+" TEXT)";
        db.execSQL(sql);
//db.close();
    }
    public void addQuestions(String question,String choice1,String choice2,String choice3,String answer,int count)
    {
        Question q1=new Question(question,choice1,choice2,choice3,answer,count);
        this.addQuestion(q1);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
// Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Question quest) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_CON,quest.getINT());
// Inserting Row
        db.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
// Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setID(cursor.getInt(6));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
// return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
    String getquestion(int count) {
        db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_QUEST;
        Cursor cursor = db.rawQuery(query, null);
        String  b;
        int a;
        b = "not found";
        if (cursor.moveToFirst()) {

            do {

                a = cursor.getInt(6);
                b = cursor.getString(1);
                if (a==count) {
                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }
    String getop1(int count) {
        db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_QUEST;
        Cursor cursor = db.rawQuery(query, null);
        String  b;
        int a;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getInt(6);
                b = cursor.getString(3);
                if (a==count) {
                    b = cursor.getString(3);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }String getop2(int count) {
        db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_QUEST;
        Cursor cursor = db.rawQuery(query, null);
        String  b;
        int a;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getInt(6);
                b = cursor.getString(4);
                if (a==count) {
                    b = cursor.getString(4);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }
    String getop3(int count) {
        db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_QUEST;
        Cursor cursor = db.rawQuery(query, null);
        String  b;
        int a;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getInt(6);
                b = cursor.getString(5);
                if (a==count) {
                    b = cursor.getString(5);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }
    String getans(int count) {
        db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_QUEST;
        Cursor cursor = db.rawQuery(query, null);
        String  b;
        int a;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getInt(6);
                b = cursor.getString(2);
                if (a==count) {
                    b = cursor.getString(2);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }



}
