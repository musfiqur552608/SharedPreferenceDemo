package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private EditText userName, password;
    private Button save, load;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.detailsId);
        userName = findViewById(R.id.userNameId);
        password = findViewById(R.id.userPassId);
        save = findViewById(R.id.saveId);
        load = findViewById(R.id.loadId);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = userName.getText().toString();
                String uPass = password.getText().toString();
                if (Name.equals("") && uPass.equals("")){
                    Toast.makeText(getApplicationContext(), "Please Enter Some Data", Toast.LENGTH_SHORT).show();
                }
                else{
                    SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username",Name);
                    editor.putString("password",uPass);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Data is stored successfully...", Toast.LENGTH_SHORT).show();
                }
            }
        });
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                if(sharedPreferences.contains("username") && sharedPreferences.contains("password")){
                    String Name = sharedPreferences.getString("username","Data Not Found");
                    String uPass = sharedPreferences.getString("password","Data Not Found");

                    textView.setText(Name+"\n"+uPass);
                }
            }
        });


    }

    /*@Override
    public void onClick(View v) {
        if(v.getId()==R.id.saveId){
            String Name = userName.getText().toString();
            String uPass = password.getText().toString();
            if (Name.equals("") && uPass.equals("")){
                Toast.makeText(getApplicationContext(), "Please Enter Some Data", Toast.LENGTH_SHORT).show();
            }
            else{
                SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username",Name);
                editor.putString("password",uPass);
                editor.commit();
                Toast.makeText(getApplicationContext(), "Data is stored successfully...", Toast.LENGTH_SHORT).show();
            }

        }
        else if(v.getId()==R.id.loadId){
            SharedPreferences sharedPreferences = getSharedPreferences("userDetails", Context.MODE_PRIVATE);
            if(sharedPreferences.contains("username") && sharedPreferences.contains("password")){
                String Name = sharedPreferences.getString("username","Data Not Found");
                String uPass = sharedPreferences.getString("password","Data Not Found");

                textView.setText(Name+"\n"+uPass);
            }
        }
    }*/
}