package com.example.myapplicationr;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
public class LogIn extends AppCompatActivity {
    private Button btnLogin,btnSignup, profile;
    private TextView createnewac;
    Database db;
    private EditText inputUsername;
    private EditText inputPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        createnewac=(TextView) findViewById(R.id.createnewac);
        createnewac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this,SignUp.class);
                startActivity(intent);
            }
        });
        db= SignUp.db;
        btnLogin = findViewById(R.id.btnlogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
            @Override
            public void onClick(View view) {
                inputUsername=findViewById(R.id.editusername);
                inputPassword=findViewById(R.id.mypass);
                String eUsername = inputUsername.getText().toString();
                String ePassword= inputPassword.getText().toString();
                if (eUsername.isEmpty()||ePassword.isEmpty()){


                    Toast.makeText(LogIn.this,"Please fill out all brach",Toast.LENGTH_SHORT).show();

                }else {

                    boolean isValid= db.ckLUserName(eUsername);
                    if(!isValid){
                        Toast.makeText(LogIn.this,"Accout is not exists!",Toast.LENGTH_SHORT).show();

                    }else{
                        Boolean ckLogin=db.ckLogin(eUsername,ePassword);
                        if(ckLogin){
                            Toast.makeText(LogIn.this,"ok!",Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent( LogIn.this, MainActivity.class);
                            startActivityForResult( intent, 0);

                        }
                        else{
                            String u = db.ckusername(eUsername,ePassword);
                            Toast.makeText(LogIn.this,"error!"+u,Toast.LENGTH_SHORT).show();

                        }
                    }}


            }
        });
    }

    }


