package com.example.narender.myapplication;
public class Contact {

    //private variables
    private int _id;
    private String _name;
    private String _username;
    private String _collageid;
    private String _department;
    private String _year;
    private String _batch;
    private String _password;
    private byte[] _image;
    private int _int;
    // Empty constructor
    Contact(){

    }
    // constructor
    Contact(int id, String name, String username, String password,String collageid,String department,String year,String batch,byte[] image){
        this._id = id;
        this._name = name;
        this._username=username;
        this._password=password;
        this._collageid=collageid;
        this._department=department;
        this._year=year;
        this._batch=batch;
        this._image=image;

    }

    // constructor
    Contact( String name, String username, String password,String collageid,String department,String year,String batch,byte[] image,int counter){
        this._name = name;
        this._username=username;
        this._password=password;
        this._collageid=collageid;
        this._department=department;
        this._year=year;
        this._batch=batch;
        this._image=image;
        this._int=counter;
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

    // setting phone number
    void setPassword(String password){
        this._password = password;
    }
    String getcollageid(){return  this._collageid;}
    void  setcollageid(String collageid){this._collageid=collageid;}

    String getdepartment(){return  this._department;}
    void  setdepartment(String department){this._department=department;}

    String getyear(){return  this._year;}
    void  setyear(String year){this._year=year;}

    String getbatch(){return  this._batch;}
    void  setbatch(String batch){this._batch=batch;}

    public byte[]  getimage(){return  this._image;}
    void  setimage(byte[] image){this._image=image;}
    int getINT(){
        return this._int;
    }

    // setting id
    void setINT(int id){
        this._id = _int;
    }


}