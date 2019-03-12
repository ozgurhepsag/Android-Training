package com.example.roomdatabaseexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadUserFragment extends Fragment {
    private TextView txtView;

    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_read_user, container, false);

        txtView = view.findViewById(R.id.txt_diplay);

        List<User> users = MainActivity.database.userDAO().readUsers();

        String info = "";

        for (User user: users) {
            int id = user.getId();
            String name = user.getName();
            String email = user.getEmail();

            info = info + "\n\n id: " + id + "\n name: " + name + "\n email: " + email;
        }

        txtView.setText(info);
        return view;
    }

}
