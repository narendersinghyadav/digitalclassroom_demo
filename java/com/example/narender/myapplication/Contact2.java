package com.example.narender.myapplication;

/**
 * Created by narender on 16/1/18.
 */

public class Contact2 {
    //private variables
    private int _id;
    private String _name;
    private String _username;
    private String _collageid;
    private String _password;
    private byte[] _image;
    // Empty constructor
    Contact2(){

    }
    // constructor
    Contact2(int id, String name, String username, String password,String collageid,byte[] image){
        this._id = id;
        this._name = name;
        this._username=username;
        this._password=password;
        this._collageid=collageid;
        this._image=image;
    }

    // constructor
    Contact2(String name, String username, String password, String collageid, byte[] image){
        this._name = name;
        this._username=username;
        this._password=password;
        this._collageid=collageid;
        this._image=image;
    }
    // getting ID
    int getID(){
        return this._id;
    }

    // setting id
    void setID(int id){
        this._id = id;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting username
    String getUsername(){
        return this._username;
    }

    // setting username
    void setUsername(String username){
        this._username = username;
    }
    // getting password
    String getPassword(){
        return this._password;
    }
    void setPassword(String password){this._password=password;}

    // setting phone number
    void setPassword1(String password){
        this._password = password;
    }
    String getcollageid(){return  this._collageid;}
    void  setcollageid(String collageid){this._collageid=collageid;}

    public byte[]  getimage(){return  this._image;}
    void  setimage(byte[] image){this._image=image;}


}
