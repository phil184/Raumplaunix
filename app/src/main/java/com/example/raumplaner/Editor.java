package com.example.raumplaner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Editor extends AppCompatActivity {

    Button buttonHome;
    TextView RoomID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);
        buttonHome = findViewById(R.id.buttonHome);
        RoomID = findViewById(R.id.RoomID);

        String raumnummer = getIntent().getStringExtra("keyname");

        RoomID.setText(raumnummer);





        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
}