package com.sreeyainfotech.sampelcontentprovider.model;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = AddContacts.FIELD_TABLE_NAME)
public class AddContacts {

    public  static  final  String FIELD_TABLE_NAME="AddContacts";

    public static final String FIELD_NAME = "Name";
    public static final String FIELD_NUMBER = "Number";
    public static final String FIELD_EMAIL = "Email";
    public  static  final  String FIELD_ADDRESS="Address";


    @DatabaseField(columnName = FIELD_NAME)
    @SerializedName("Name")
    String Name;

    @DatabaseField(columnName = FIELD_NUMBER, id=true)
    @SerializedName("Number")
    String Number;


    @DatabaseField(columnName = FIELD_EMAIL)
    @SerializedName("Email")
    String Email;

    @DatabaseField(columnName = FIELD_ADDRESS)
    @SerializedName("Address")
    String Address;


    public static String getFieldName() {
        return FIELD_NAME;
    }

    public static String getFieldNumber() {
        return FIELD_NUMBER;
    }

    public static String getFieldEmail() {
        return FIELD_EMAIL;
    }

    public static String getFieldAddress() {
        return FIELD_ADDRESS;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
