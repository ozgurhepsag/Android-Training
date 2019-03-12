package com.example.sqliteexample;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddContactFragment extends Fragment {

    private Button bnSave;
    private EditText edtContactID, edtName, edtEmail;

    public AddContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_contact, container, false);

        bnSave = view.findViewById(R.id.bn_save);
        edtContactID = view.findViewById(R.id.txt_contact_id);
        edtName = view.findViewById(R.id.txt_contact_name);
        edtEmail = view.findViewById(R.id.txt_contact_email);

        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edtContactID.getText().toString();
                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();

                ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());

                // Do not put the database write or read operations in here (main thread) on the real applications.
                // This causes the application pause.
                SQLiteDatabase database = contactDBHelper.getWritableDatabase();

                contactDBHelper.addContact(Integer.parseInt(id), name, email, database);
                contactDBHelper.close();
                setTextEmpty();
                Toast.makeText(getActivity(), "Contact Added Succesfully...", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    // Set all texts od the edit texts to empty
    private void setTextEmpty(){
        edtContactID.setText("");
        edtEmail.setText("");
        edtName.setText("");
    }

}
