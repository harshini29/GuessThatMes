package com.example.guessthatmess;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity
{

    private EditText mUsername_Edit,mEmail_Edit,mPassword_Edit,mConfirm_Password;
    private Button mSignUp;

    private String mpasswordInput;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mUsername_Edit = findViewById(R.id.UserName);
        mEmail_Edit = findViewById(R.id.Email);
        mPassword_Edit = findViewById(R.id.Password);
        mSignUp = findViewById(R.id.btn);
        mConfirm_Password = findViewById(R.id.Confirm_Password);


        mSignUp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                if (!checkvalidUsername() | !checkvalidPassword() | !checkvalidEmail() | !checkvalidConfirmPassword())
                {
                    Toast.makeText(getApplication(),"The sign up data is not valid",Toast.LENGTH_LONG).show();
                }
                else
                {
                    String input =  "Email: " + mEmail_Edit.getText().toString();
                    input += "\n";
                    input += "Username: " + mUsername_Edit.getText().toString();
                    input += "\n";
                    input += "Password: " + mPassword_Edit.getText().toString();
                    input += "\n";
                    input += "Confirm Password: " + mConfirm_Password.getText().toString();
                    input += "\n";


                    Toast.makeText(getApplication(),input,Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private boolean checkvalidUsername() {
        String usernameInput = mUsername_Edit.getText().toString().trim();

        if (usernameInput.isEmpty()) {
            mUsername_Edit.setError("Username can't be blank");
            return false;
        } else if (usernameInput.length() > 20) {
            mUsername_Edit.setError("Username is long");
            return false;
        } else {
            mUsername_Edit.setError(null);
            return true;
        }
    }

    private boolean checkvalidPassword() {
        mpasswordInput = mPassword_Edit.getText().toString().trim();

        if (mpasswordInput.isEmpty()) {
            mPassword_Edit.setError("Password can't be blank");
            return false;
        }else if (mpasswordInput.length() < 3 || mpasswordInput.length() > 10){
            mPassword_Edit.setError("Password should be between 4 and 10 alphanumeric characters");
            return false;
        }else {
            mPassword_Edit.setError(null);
            return true;
        }
    }

    private boolean checkvalidEmail() {
        String emailInput = mEmail_Edit.getText().toString().trim();

        if (emailInput.isEmpty()) {
            mEmail_Edit.setError("Email can't be blank");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            mEmail_Edit.setError("Please enter a valid email");
            return false;
        } else {
            mEmail_Edit.setError(null);
            return true;
        }
    }
    private boolean checkvalidConfirmPassword() {
        String confirm_passwordInput = mConfirm_Password.getText().toString().trim();

        if (confirm_passwordInput.isEmpty()) {
            mConfirm_Password.setError("Confirm Password can't be blank!");
            return false;
        }else if (confirm_passwordInput.length() < 3 || confirm_passwordInput.length() > 10){
            mConfirm_Password.setError("Confirm Password should be between 4 and 10 alphanumeric characters");
            return false;
        }else if (!confirm_passwordInput.equals(mpasswordInput)){
            mConfirm_Password.setError("Passowrd does not match!");
            return false;
        } else {
            mConfirm_Password.setError(null);
            return true;
        }
    }

}

