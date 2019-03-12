package com.example.sqliteexample;


import android.app.Activity;
import android.content.Context;
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

    private Button bnSave, bnDelete, bnUpdate, bnView;
    OnDBOperationListener dbOperationListener;

    public HomeFragment() {
        // Required empty public constructor
    }


    public interface OnDBOperationListener {
        public void dbOperationsPerformed(int method);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        bnSave = view.findViewById(R.id.btn_add_contact);
        bnView = view.findViewById(R.id.btn_view_contacts);
        bnUpdate = view.findViewById(R.id.btn_update_contact);
        bnDelete = view.findViewById(R.id.btn_delete_contact);
        bnSave.setOnClickListener(this);
        bnView.setOnClickListener(this);
        bnDelete.setOnClickListener(this);

        /*bnDelete = view.findViewById(R.id.btn_delete_contact);
        bnUpdate = view.findViewById(R.id.btn_update_contact);
        bnView = view.findViewById(R.id.btn_view_contacts);*/

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_add_contact:
                dbOperationListener.dbOperationsPerformed(0);
                break;
            case R.id.btn_view_contacts:
                dbOperationListener.dbOperationsPerformed(1);
                break;
            case R.id.btn_delete_contact:
                dbOperationListener.dbOperationsPerformed(2);
                break;
            case R.id.btn_update_contact:
                dbOperationListener.dbOperationsPerformed(3);
                break;
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;
        try {
            dbOperationListener = (OnDBOperationListener) activity;

        }
        catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement the interface method...");
        }

    }
}
