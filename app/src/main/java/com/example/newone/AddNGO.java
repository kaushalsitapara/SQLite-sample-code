package com.example.newone;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newone.SQLiteDemo.SQLDataSourceHelper;
import com.example.newone.ui.home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

public class AddNGO extends AppCompatActivity {
    String SQLiteDataBaseQueryHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    private String TAB = "AddNGO";
    private Button btn_submit, btn_view;
    private EditText et_NGOName, et_EmailId, et_MobileNo, et_Address, et_City, et_State, et_PinCode, et_NGOType, et_Description;
    List<NGONameModel> NGONameModelArrayList=new ArrayList<>();
    SQLDataSourceHelper gcmMessageDataSource;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_ngo);
        gcmMessageDataSource = new SQLDataSourceHelper(this);
        gcmMessageDataSource.open();

        initComponent();

    }


    private void initComponent() {

        btn_submit = findViewById(R.id.btn_submit);
        et_NGOName = findViewById(R.id.et_ngoname);
        et_EmailId = findViewById(R.id.et_email);
        et_MobileNo = findViewById(R.id.et_mobileno);
        et_Address = findViewById(R.id.et_add);
        et_City = findViewById(R.id.et_city);
        et_State = findViewById(R.id.et_state);
        et_PinCode = findViewById(R.id.et_pincode);
        et_NGOType = findViewById(R.id.et_ngotype);
        //et_NeededAmount = findViewById(R.id.et_amount);
        et_Description = findViewById(R.id.et_description);
        btn_view =findViewById(R.id.btn_view);



      //  btn_submit.setOnClickListener(new View.OnClickListener() {
        //    @Override
          //  public void onClick(View v) {
//
  //              Intent intent = new Intent(AddNGO.this, HomeActivity.class);
    //            startActivity(intent);



      //      }
        //});

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String NGOName = et_NGOName.getText().toString().trim();
                String EmailId = et_EmailId.getText().toString().trim();
                String MobileNo = et_MobileNo.getText().toString().trim();
                et_Address.getText( ).toString( ).trim( );
                et_City.getText( ).toString( ).trim( );
                et_State.getText( ).toString( ).trim( );
                String PinCode = et_PinCode.getText().toString().trim();
                et_NGOType.getText( ).toString( ).trim( );
                //et_NeededAmount.getText( ).toString( ).trim( );
                String Description = et_Description.getText().toString().trim();


                if (NGOName.length() < 3) {
                    et_NGOName.setError("Enter Valid NGOName");
                    Toast.makeText(AddNGO.this, "Enter valid FirstName ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (EmailId.length() < 3) {
                    et_EmailId.setError("Enter Valid EmailId");
                    Toast.makeText(AddNGO.this, "Enter valid EmailId", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (MobileNo.length() != 10) {
                    et_MobileNo.setError("Enter Valid MobileNumber");
                    Toast.makeText(AddNGO.this, "Enter valid MobileNumber", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (PinCode.length() <= 3) {
                    et_PinCode.setError("Enter Valid Pincode");
                    Toast.makeText(AddNGO.this, "Enter valid Pincode", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (Description.length() <= 0) {
                    et_Description.setError("Enter Valid Emailid");
                    Toast.makeText(AddNGO.this, "Enter valid Emailid", Toast.LENGTH_SHORT).show();
                    return;
                }
                sqLiteDatabaseObj = openOrCreateDatabase("ngolist.db", Context.MODE_PRIVATE, null);
                SQLiteDataBaseQueryHolder = "INSERT INTO ngo_demo (name,email,mobile,address,city,state,pincode,ngotype,description) " + "VALUES('"+et_NGOName.getText().toString()+"', '"+et_EmailId.getText().toString()+"','"+et_MobileNo.getText().toString()+"','"+et_Address.getText().toString()+"','"+et_City.getText().toString()+"','"+et_State.getText().toString()+"','"+et_PinCode.getText().toString()+"','"+et_NGOType.getText().toString()+"','"+et_Description.getText().toString()+"');";

                sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);
                Toast.makeText(getBaseContext(), "You have registered successfully" , Toast.LENGTH_SHORT ).show();


                btn_view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(AddNGO.this, NavigationUser.class));


                    }
                });






            }
        });
    }
}






