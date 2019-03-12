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
public class UpdateContactFragment extends Fragment {

    private EditText edtID, edtName, edtEmail;
    Button bnUpdate;

    public UpdateContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update, container, false);

        edtEmail = view.findViewById(R.id.txt_update_email);
        edtID = view.findViewById(R.id.txt_update_id);
        edtName = view.findViewById(R.id.txt_update_name);
        bnUpdate = view.findViewById(R.id.bn_update);

        bnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateContact();
            }
        });

        return view;
    }

    private void updateContact(){
        int id = Integer.parseInt(edtID.getText().toString());
        String email = edtEmail.getText().toString();
        String name = edtName.getText().toString();

        ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());

        // Do not put the database write or read operations in here (main thread) on the real applications.
        // This causes the application pause.
        SQLiteDatabase db = contactDBHelper.getWritableDatabase();

        contactDBHelper.updateContact(id, name, email, db);
        contactDBHelper.close();
        Toast.makeText(getActivity(), "Contact Updated Succesfully...", Toast.LENGTH_SHORT).show();

        setTextEmpty();
    }

    // Set all texts od the edit texts to empty
    private void setTextEmpty(){
        edtID.setText("");
        edtEmail.setText("");
        edtName.setText("");
    }

}
