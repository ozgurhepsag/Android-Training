package com.example.roomdatabaseexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button btnAdd, btnDelete, btnUpdate, btnView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btnAdd = view.findViewById(R.id.btn_add_user);
        btnView = view.findViewById(R.id.btn_view_users);
        btnUpdate = view.findViewById(R.id.btn_update_user);
        btnDelete = view.findViewById(R.id.btn_delete_user);
        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnView.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_add_user:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container ,new AddUserFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.btn_view_users:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container ,new ReadUserFragment())
                        .addToBackStack(null).commit();
                break;
            case R.id.btn_delete_user:
                //dbOperationListener.dbOperationsPerformed(2);
                break;
            case R.id.btn_update_user:
                //dbOperationListener.dbOperationsPerformed(3);
                break;
        }

    }
}
