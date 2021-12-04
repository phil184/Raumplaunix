package com.example.raumplaner;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonScan,buttonEdit;
    EditText RoomID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RoomID = findViewById(R.id.RoomIDFirst);

        buttonEdit = findViewById(R.id.buttonEdit);

        buttonScan = findViewById(R.id.buttonScan);

        RoomID.addTextChangedListener(raumEingabe);

        buttonScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Scanner_Activity.class));

            }
        });

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String raumnummer = RoomID.getText().toString();

                Intent intent = new Intent(MainActivity.this, Editor.class);
                intent.putExtra("keyname", raumnummer);
                startActivity(intent);

            }
        });

    }

    private TextWatcher raumEingabe = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String eingabe = RoomID.getText().toString();
            buttonEdit.setEnabled(!eingabe.isEmpty());


        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


}


