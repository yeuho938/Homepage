package com.example.myapplicationr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class SignUp extends AppCompatActivity {
    private Button signup;
    static Database db;
    private EditText eName;
    private EditText ePassword;
    private EditText editusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        db= new Database(this);
        eName =findViewById(R.id.editName);
        ePassword=findViewById(R.id.editPass);
        editusername=findViewById(R.id.editusername);
//        bChangeScreen=findViewById(R.id.loginaccount);

        signup = (Button) findViewById(R.id.buttonAcount);
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String inputName= eName.getText().toString();
                String inputPassword= ePassword.getText().toString();
                String inputEmail= editusername.getText().toString();
                Boolean checkusername = db.ckUserName(inputName);

                if (checkusername==true){
                    Boolean insert= db.insert(inputName,inputPassword);
                    if (insert==true){
                        Toast.makeText(SignUp.this,"Register successful!",Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(SignUp.this,LogIn.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(SignUp.this,"Error!",Toast.LENGTH_SHORT).show();

                    }
                }else{
                    Toast.makeText(SignUp.this,"Username exists!",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}


