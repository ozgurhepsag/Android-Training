package com.example.roomdatabaseexample;


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
public class AddUserFragment extends Fragment {

    private EditText edtId, edtName, edtEmail;
    private Button btnAdd;

    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        edtId = view.findViewById(R.id.txt_user_id);
        edtEmail = view.findViewById(R.id.txt_user_email);
        edtName = view.findViewById(R.id.txt_user_name);
        btnAdd = view.findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(edtId.getText().toString());
                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();

                User user = new User(id, name, email);

                MainActivity.database.userDAO().addUser(user);
                Toast.makeText(getActivity(), "User Added Successfully",Toast.LENGTH_SHORT).show();

                edtId.setText("");
                edtName.setText("");
                edtEmail.setText("");
            }
        });

        return view;
    }

}
