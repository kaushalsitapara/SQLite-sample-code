package com.example.newone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddEvent extends AppCompatActivity {
    private String TAB = "AddEvent";
    private Button btn_submit;
    private EditText et_EventName, et_EventDateTime, et_EventPlace, et_EventDescription, et_EventPurpose, et_EventbyNGO;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_event);

        initComponent();
    }


    private void initComponent() {

        btn_submit = findViewById(R.id.btn_submit);
        et_EventName = findViewById(R.id.et_eventname);
        et_EventDateTime = findViewById(R.id.et_datetime);
        et_EventPlace = findViewById(R.id.et_eventplace);
        et_EventDescription = findViewById(R.id.et_description);
        et_EventPurpose = findViewById( R.id.et_purpose );
        et_EventbyNGO = findViewById(R.id.et_eventbyngo );


       // link_homefragment.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View v) {
//
  //              Intent intent = new Intent(AddEvent.this, NavigationUser.class);
    //            startActivity(intent);



      //      }
        //});

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String EventName = et_EventName.getText().toString().trim();
                et_EventDateTime.getText( ).toString( ).trim( );
                String EventPlace = et_EventPlace.getText().toString().trim();
                String EventDescription = et_EventDescription.getText().toString().trim();
                String EventPurpose = et_EventPurpose.getText().toString().trim();
                et_EventbyNGO.getText( ).toString( ).trim( );

                if (EventName.length() < 3) {
                    et_EventName.setError("Enter Valid Firstname");
                    Toast.makeText(AddEvent.this, "Enter valid EventName ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (EventPlace.length() < 3) {
                    et_EventPlace.setError("Enter Valid  Eventplace");
                    Toast.makeText(AddEvent.this, "Enter valid EventPlace", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (EventDescription.length() <10) {
                    et_EventDescription.setError("Enter Valid Description");
                    Toast.makeText(AddEvent.this, "Enter valid Description", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (EventPurpose.length() <= 3) {
                    et_EventPurpose.setError("Enter Valid Purpose");
                    Toast.makeText(AddEvent.this, "Enter valid purpose", Toast.LENGTH_SHORT).show();
                    return;
                }



                Toast.makeText(getBaseContext(), "You have registered successfully" , Toast.LENGTH_SHORT ).show();




                Intent intent = new Intent(AddEvent.this, NavigationUser.class);
                startActivity(intent);




            }
        });
    }
}





