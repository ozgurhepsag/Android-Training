package com.example.sqliteexample;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadContactsFragment extends Fragment {

    private TextView txt_display;

    public ReadContactsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_contacts, container, false);

        txt_display = view.findViewById(R.id.txt_diplay);
        readContacts();;
        return view;
    }

    // Do not put the read operation here in the real projects.
    private void readContacts(){
        ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());
        SQLiteDatabase db = contactDBHelper.getReadableDatabase();

        Cursor cursor = contactDBHelper.readContacts(db);
        String info = "";

        while (cursor.moveToNext()){
            String id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContract.ContactEntry.CONTACT_ID)));
            String name = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.NAME));
            String email = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.EMAIL));

            info = info + "\n\n id: " + id + "\n name:" + name + "\n email: " + email;
        }

        txt_display.setText(info);
        contactDBHelper.close();
    }

}
