package com.example.narender.myapplication;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION1 = 1;

    // Database Name
    private static final String DATABASE_NAME1 = "contactsManager";

    // Contacts table name
    private static final String TABLE_CONTACTS1 = "contacts";

    // Contacts Table Columns names
    private static final String KEY_ID1 = "id";
    private static final String KEY_NAME1 = "name";
    private static final String KEY_USERNAME1 = "username";
    private static final String KEY_PASS1 = "password";
    private static final String KEY_COLL1 = "collageid";
    private static final String KEY_DEP1 = "department";
    private static final String KEY_YR1 = "year";
    private static final String KEY_BATCH1 = "batch";
    private static final String KEY_IMG1="image";
    private static final String KEY_CON1="counter";
    private static final String KEY_FAL1="faktu";

    SQLiteDatabase db;

    DBHelper(Context context) {
        super(context, DATABASE_NAME1, null, DATABASE_VERSION1);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS1 + "("
                + KEY_ID1 + " INTEGER PRIMARY KEY," + KEY_NAME1 + " TEXT,"
                + KEY_USERNAME1 + " TEXT," + KEY_PASS1 + " TEXT," + KEY_COLL1 + " TEXT," + KEY_DEP1 + " TEXT," + KEY_YR1 + " TEXT," + KEY_BATCH1 + " TEXT,"+ KEY_IMG1 + " BLOB,"+KEY_CON1+" INTEGER,"+KEY_FAL1+" TEXT)";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS1);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    void addContact(Contact contact) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME1, contact.getName()); // com.example.narender.myapplication.Contact Name
        values.put(KEY_USERNAME1, contact.getUsername()); // com.example.narender.myapplication.Contact Username
        values.put(KEY_PASS1, contact.getPassword());// com.exampe.narender.myapplication.Contact Password
        values.put(KEY_COLL1, contact.getcollageid());
        values.put(KEY_DEP1, contact.getdepartment());
        values.put(KEY_YR1, contact.getyear());
        values.put(KEY_BATCH1, contact.getbatch());
        values.put(KEY_IMG1, contact.getimage());
        values.put(KEY_CON1,contact.getINT());
        // Inserting Row
        db.insert(TABLE_CONTACTS1, null, values);
        db.close(); // Closing database connection
    }

    // Getting All Contacts
    List<Contact> getAllContacts() {
        List<Contact> contactList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS1;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setUsername(cursor.getString(2));
                contact.setPassword(cursor.getString(3));
                contact.setcollageid(cursor.getString(4));
                contact.setdepartment(cursor.getString(5));
                contact.setbatch(cursor.getString(6));
                contact.setyear(cursor.getString(7));
                contact.setimage(cursor.getBlob(8));
                contact.setINT(cursor.getInt(9));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    //search username and password
    String searchPass(String uname) {
        db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_CONTACTS1;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(2);
                b = cursor.getString(3);
                if (a.equals(uname)) {
                    b = cursor.getString(3);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }
    //search name using email id
    String searchname(String uname) {
        db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_CONTACTS1;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(2);
                b = cursor.getString(1);
                if (a.equals(uname)) {
                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }
    //search collage id by email id
    String searchcollageid(String uname) {
        db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_CONTACTS1;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(2);
                b = cursor.getString(4);
                if (a.equals(uname)) {
                    b = cursor.getString(4);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }
    //search department by email id
    String searchDepartment(String uname) {
        db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_CONTACTS1;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(2);
                b = cursor.getString(5);
                if (a.equals(uname)) {
                    b = cursor.getString(5);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }
    //search year by email id
    String searchYear(String uname) {
        db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_CONTACTS1;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(2);
                b = cursor.getString(7);
                if (a.equals(uname)) {
                    b = cursor.getString(7);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }
    //search batch by email id
    String searchbatch(String uname) {
        db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_CONTACTS1;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(2);
                b = cursor.getString(6);
                if (a.equals(uname)) {
                    b = cursor.getString(6);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }
    //search name by serial number
    String searchnamebyid(int count) {
        db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_CONTACTS1;
        Cursor cursor = db.rawQuery(query, null);
        String  b;
        int a;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getInt(9);
                b = cursor.getString(6);
                if (a==count) {
                    b = cursor.getString(6);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }
    //search email by serial number
    String searchemailbyid(int count) {
        db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_CONTACTS1;
        Cursor cursor = db.rawQuery(query, null);
        String  b;
        int a;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getInt(9);
                b = cursor.getString(6);
                if (a==count) {
                    b = cursor.getString(6);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }

//count number of rows
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS1;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }

}