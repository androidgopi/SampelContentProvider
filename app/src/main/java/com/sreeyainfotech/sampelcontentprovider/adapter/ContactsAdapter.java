package com.sreeyainfotech.sampelcontentprovider.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.sreeyainfotech.sampelcontentprovider.ContactsActivity;
import com.sreeyainfotech.sampelcontentprovider.R;
import com.sreeyainfotech.sampelcontentprovider.model.AddContacts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KSTL on 24-04-2017.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {


    Context mContext;
    List<AddContacts> contactsList, filterList;
    ContactsActivity mCallBack;

    public ContactsAdapter(Context mContext, List<AddContacts> contactsList) {
        this.mContext = mContext;
        this.contactsList = contactsList;
        this.filterList = new ArrayList<AddContacts>();

        this.filterList.addAll(this.contactsList);
    }


    @SuppressLint("NewApi")
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        viewGroup.setClipToPadding(false);
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_list, viewGroup, false);
        view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
        view.setElevation(30);
        return new ViewHolder(view);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final AddContacts contact = filterList.get(position);
        holder.contact_name.setText(contact.getName());
        holder.contact_number.setText(contact.getNumber());
        holder.adress.setText(contact.getAddress());
        holder.email.setText(contact.getEmail());
    }



    @Override
    public int getItemCount() {
        //return eventsList.size();
        return (null != filterList ? filterList.size() : 0);
    }

    public void setCallBack(ContactsActivity contactsActivity) {
        this.mCallBack=contactsActivity;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView contact_name, contact_number,email,adress;
        CardView card_view;

        public ViewHolder(View view) {
            super(view);
            contact_name = (TextView) view.findViewById(R.id.name_text);
            contact_number = (TextView) view.findViewById(R.id.mobile_number);
            email = (TextView) view.findViewById(R.id.email);
            adress = (TextView) view.findViewById(R.id.adress);
            card_view=(CardView) view. findViewById(R.id.card_view);

        }
    }

}
