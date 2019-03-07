package com.example.sharedpreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferenceConfig sharedPreferenceConfig;
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferenceConfig = new SharedPreferenceConfig(getApplicationContext());

        username = findViewById(R.id.user_name);
        password = findViewById(R.id.password);

        if(sharedPreferenceConfig.readLoginStatus())
            startActivity(new Intent(this, SuccesActivity.class));

    }

    public void loginUser(View view){
        String user_name = username.getText().toString();
        String user_password = password.getText().toString();

        if(user_name.equals(getResources().getString(R.string.user_name)) && user_password.equals(getResources().getString(R.string.user_password))){

            startActivity(new Intent(this, SuccesActivity.class));
            sharedPreferenceConfig.writeLoginStatus(true);
            finish();
        }
        else{

            Toast.makeText(this, "Login failed... Try again...", Toast.LENGTH_SHORT).show();
            username.setText("");
            password.setText("");
        }


    }
}
