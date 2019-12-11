package com.sreeyainfotech.sampelcontentprovider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.j256.ormlite.dao.Dao;
import com.sreeyainfotech.sampelcontentprovider.database.DatabaseHelper;
import com.sreeyainfotech.sampelcontentprovider.model.AddContacts;

import java.sql.SQLException;

public class CreateContact extends AppCompatActivity implements View.OnClickListener {

    private EditText name_edttxt, mobile_number_edttxt, email_edttxt, address_edttxt;
    private Button save_button;
    private String Name_str, Mobile_Number_str, Email_str, Address_str,password_str;

    private DatabaseHelper helper;
    Dao<AddContacts, Integer> contactDao = null;
    private EditText password_edttxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setNavigationIcon(R.drawable.ic_left_arrow);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });

        //intilizing the Database
        helper = new DatabaseHelper(CreateContact.this);

        findViewes();
    }

    private void findViewes() {
        name_edttxt = (EditText) findViewById(R.id.name_edttxt);
        mobile_number_edttxt = (EditText) findViewById(R.id.mobile_number_edttxt);
        email_edttxt = (EditText) findViewById(R.id.email_edttxt);
        address_edttxt = (EditText) findViewById(R.id.address_edttxt);
        save_button = (Button) findViewById(R.id.save_button);
        save_button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.save_button:
                savedOnDatabase();
                break;
        }
    }

    private void savedOnDatabase() {
        Name_str = name_edttxt.getText().toString();
        Mobile_Number_str = mobile_number_edttxt.getText().toString();
        Email_str = email_edttxt.getText().toString();
        Address_str = address_edttxt.getText().toString();

        AddContacts contact = new AddContacts();
        contact.setName(Name_str);
        contact.setNumber(Mobile_Number_str);
        contact.setEmail(Email_str);
        contact.setAddress(Address_str);

        try {
            contactDao = helper.getContactDao();
            contactDao.createOrUpdate(contact);
            Toast.makeText(getApplicationContext(),"Saved successfuly", Toast.LENGTH_LONG).show();

            name_edttxt.setText("");
            mobile_number_edttxt.setText("");
            email_edttxt.setText("");
            address_edttxt.setText("");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
