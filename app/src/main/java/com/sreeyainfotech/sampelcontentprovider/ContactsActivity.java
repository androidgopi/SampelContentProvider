package com.sreeyainfotech.sampelcontentprovider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.j256.ormlite.dao.Dao;
import com.sreeyainfotech.sampelcontentprovider.adapter.ContactsAdapter;
import com.sreeyainfotech.sampelcontentprovider.database.DatabaseHelper;
import com.sreeyainfotech.sampelcontentprovider.model.AddContacts;

import java.sql.SQLException;
import java.util.List;

public class ContactsActivity extends AppCompatActivity {

    ContactsAdapter contactsAdapter;
    private RecyclerView contact_recyclerview;
    private SearchView search_view;
    private DatabaseHelper helper;
    Dao<AddContacts, Integer> contactsDao = null;
    private List<AddContacts> contactdbList;
    // private List<Contact> contactdbList = new ArrayList<Contact>();
    private EditText search_parent;
    private CardView card_view;
    private int screen_Width, screen_height;
    private ImageView cancel_popup;
    private Button update_button, delete_button;
    private EditText name_editext;
    private EditText mobile_number, mail, password;
    private Dao<AddContacts, Integer> contactDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setNavigationIcon(R.drawable.ic_left_arrow);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });

        helper = new DatabaseHelper(ContactsActivity.this);
        try {
            contactsDao = helper.getContactDao();
            contactdbList = contactsDao.queryForAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        findViewes();
    }

    private void findViewes() {

        contact_recyclerview = (RecyclerView) findViewById(R.id.contact_recyclerview);

        contacts_list();
    }

    private void contacts_list() {
        contactsAdapter = new ContactsAdapter(ContactsActivity.this, contactdbList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ContactsActivity.this);
        contact_recyclerview.setLayoutManager(layoutManager);
        contact_recyclerview.setNestedScrollingEnabled(false);
        contact_recyclerview.setAdapter(contactsAdapter);
        contactsAdapter.notifyDataSetChanged();
    }


}
