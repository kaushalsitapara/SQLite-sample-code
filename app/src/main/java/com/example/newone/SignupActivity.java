package com.example.newone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


    public class SignupActivity extends AppCompatActivity {
        private String TAB = "SignupActivity";
        private TextView link_signup;
        private Button btn_submit,btn_male,btn_female,btn_other;
        private EditText et_FirstName, et_LastName, et_MobileNumber,et_birthdate, et_Address, et_City, et_State, et_PinCode, et_Emailid;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.signup_activity);

            initComponent();
        }


        private void initComponent() {

            link_signup = findViewById(R.id.link_signup);
            btn_submit = findViewById(R.id.btn_submit);
            et_FirstName = findViewById(R.id.et_firstname);
            et_LastName = findViewById(R.id.et_lastname);
            et_MobileNumber = findViewById(R.id.et_mobilenumber);
            et_birthdate = findViewById(R.id.et_birthdate);
            btn_male = findViewById(R.id.btn_male);
            btn_female = findViewById(R.id.btn_female);
            btn_other = findViewById(R.id.btn_other);
            et_Address = findViewById(R.id.et_address);
            et_City = findViewById(R.id.et_city);
            et_State = findViewById(R.id.et_state);
            et_PinCode = findViewById(R.id.et_pincode);
            et_Emailid = findViewById(R.id.et_emailid);


            link_signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);



                }
            });

            btn_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    String FirstName = et_FirstName.getText().toString().trim();
                    String LastName = et_LastName.getText().toString().trim();
                    String MobileNumber = et_MobileNumber.getText().toString().trim();
                    String BirthDate = et_birthdate.getText().toString().trim();
                    String Address = et_Address.getText().toString().trim();
                    String City = et_City.getText().toString().trim();
                    String State = et_State.getText().toString().trim();
                    String PinCode = et_PinCode.getText().toString().trim();
                    String Emailid = et_Emailid.getText().toString().trim();

                    if (FirstName.length() < 3) {
                        et_FirstName.setError("Enter Valid Firstname");
                        Toast.makeText(SignupActivity.this, "Enter valid FirstName ", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (LastName.length() < 3) {
                        et_LastName.setError("Enter Valid  LastName");
                        Toast.makeText(SignupActivity.this, "Enter valid LastName", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (MobileNumber.length() != 10) {
                        et_MobileNumber.setError("Enter Valid MobileNumber");
                        Toast.makeText(SignupActivity.this, "Enter valid MobileNumber", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (PinCode.length() <= 3) {
                        et_PinCode.setError("Enter Valid Pincode");
                        Toast.makeText(SignupActivity.this, "Enter valid Pincode", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (Emailid.length() <= 0) {
                        et_Emailid.setError("Enter Valid Emailid");
                        Toast.makeText(SignupActivity.this, "Enter valid Emailid", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Toast.makeText(getBaseContext(), "You have registered successfully" , Toast.LENGTH_SHORT ).show();




                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(intent);




                }
            });
        }
    }





