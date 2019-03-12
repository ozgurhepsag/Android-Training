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
public class DeleteUserFragment extends Fragment {

    private EditText edtId;
    private Button btnDelete;

    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);
        edtId = view.findViewById(R.id.txt_user_id);
        btnDelete = view.findViewById(R.id.btn_delete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(edtId.getText().toString());

                User user = new User();
                user.setId(id);

                MainActivity.database.userDAO().deleteUser(user);
                Toast.makeText(getActivity(), "User Deleted Successfully",Toast.LENGTH_SHORT).show();

                edtId.setText("");
            }
        });

        return view;
    }

}
