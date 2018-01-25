package com.example.narender.myapplication;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper2 extends SQLiteOpenHelper{

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contactsManager";

    // Contacts table name
    private static final String TABLE_CONTACTS = "contacts";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASS = "password";
    private static final String KEY_COLL = "collageid";
    private static final String KEY_IMG="image";
    private static final String KEY_FAL="faktu";

    SQLiteDatabase db1;

    DBHelper2(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db1) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_USERNAME + " TEXT," + KEY_PASS + " TEXT," + KEY_COLL + " TEXT," + KEY_IMG + " BLOB,"+KEY_FAL+" TEXT)";
        db1.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    void addContact(Contact2 contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName()); // com.example.narender.myapplication.Contact Name
        values.put(KEY_USERNAME, contact.getUsername()); // com.example.narender.myapplication.Contact Username
        values.put(KEY_PASS, contact.getPassword());// com.exampe.narender.myapplication.Contact Password
        values.put(KEY_COLL, contact.getcollageid());
        values.put(KEY_IMG, contact.getimage());
        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }

    // Getting All Contacts
    List<Contact2> getAllContacts() {
        List<Contact2> contactList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contact2 contact = new Contact2();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setUsername(cursor.getString(2));
                contact.setPassword(cursor.getString(3));
                contact.setcollageid(cursor.getString(4));
                contact.setimage(cursor.getBlob(8));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    //search username and password
    String searchname(String uname) {
        db1 = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_CONTACTS;
        Cursor cursor = db1.rawQuery(query, null);
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
    String searchid(String uname) {
        db1 = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_CONTACTS;
        Cursor cursor = db1.rawQuery(query, null);
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
    String searchPass(String uname) {
        db1 = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_CONTACTS;
        Cursor cursor = db1.rawQuery(query, null);
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
}
