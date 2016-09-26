package com.example.user.databaseloginsdp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivityDB extends AppCompatActivity implements View.OnClickListener{
    private Button registerButton;
    private TextView tvLogin;
    private EditText etEmail, etPass;
    private DataBaseHelp db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_db);

        db = new DataBaseHelp(this);
        registerButton = (Button)findViewById(R.id.btnReg);
        tvLogin = (TextView)findViewById(R.id.tvLogin);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPass = (EditText)findViewById(R.id.etPass);
        registerButton.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
    }

    private void register(){
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();
        if(email.isEmpty() && pass.isEmpty()){
            displayToast("Username/password field empty");
        }else{
            db.addUser(email,pass);
            displayToast("User registered");
            finish();
        }
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnReg:
                register();
                break;
            case R.id.tvLogin:
                startActivity(new Intent(RegisterActivityDB.this,LoginActivityDB.class));
                finish();
                break;
            default:

        }
    }

    private void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}