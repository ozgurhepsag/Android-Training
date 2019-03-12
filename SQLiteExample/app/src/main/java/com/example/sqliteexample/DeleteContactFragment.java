package com.example.sqliteexample;


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.strictmode.SqliteObjectLeakedViolation;
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
public class DeleteContactFragment extends Fragment {

    EditText edtID;
    Button bnDelete;

    public DeleteContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete, container, false);

        edtID = view.findViewById(R.id.txt_delete_id);
        bnDelete = view.findViewById(R.id.bn_delete);

        bnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteContact();
            }
        });

        return view;
    }

    private void deleteContact(){
        int id = Integer.parseInt(edtID.getText().toString());

        ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());

        // Do not put the database write or read operations in here (main thread) on the real applications.
        // This causes the application pause.
        SQLiteDatabase db = contactDBHelper.getWritableDatabase();

        contactDBHelper.deleteContact(id, db);
        contactDBHelper.close();

        Toast.makeText(getActivity(), "Contact Deleted Succesfully...", Toast.LENGTH_SHORT).show();

        edtID.setText("");
    }


}
