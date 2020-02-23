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


public class LoginActivity extends AppCompatActivity {
    private String TAG = "LoginActivity";
    private TextView tv_signup;
    private Button btn_submit;
    private EditText et_username, et_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.login_activity );

        initComponent( );
    }

    private void initComponent() {

        tv_signup = findViewById( R.id.tv_signup );
        btn_submit = findViewById( R.id.btn_login );
        et_username = findViewById( R.id.text1 );
        et_password = findViewById( R.id.text2 );

        tv_signup.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( LoginActivity.this, SignupActivity.class );
                startActivity( intent );


            }
        } );

        btn_submit.setOnClickListener( new View.OnClickListener( ) {
            private boolean Admin;

            @Override
            public void onClick(View v) {

                String uname = et_username.getText( ).toString( ).trim( );
                String password = et_password.getText( ).toString( ).trim( );

                if (uname.length( ) <= 0) {
                    et_username.setError( "Enter Valid Username" );
                    Toast.makeText( LoginActivity.this, "Enter valid username", Toast.LENGTH_SHORT ).show( );
                    return;
                }
                if (password.length( ) <= 4) {
                    et_password.setError( "Enter Valid  6 digit password" );
                    Toast.makeText( LoginActivity.this, "Enter valid Password", Toast.LENGTH_SHORT ).show( );
                    return;
                }

                if (uname.equalsIgnoreCase( "admin" ) && password.equalsIgnoreCase( "admin" )) {
                    Intent intent = new Intent( LoginActivity.this, ActivityNavigationAdmin.class );
                    startActivity( intent );
                }else {
                    Intent intent = new Intent( LoginActivity.this, NavigationUser.class );
                    startActivity( intent );
                }


            }

        } );
//            btn_submit.setOnClickListener( new View.OnClickListener( ) {
//                @Override
//                public void onClick(View v) {
//
//                    Intent intent = new Intent( LoginActivity.this, NavigationUser.class );
//                    startActivity( intent );
//                }
//            } );
    }
}