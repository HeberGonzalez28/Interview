package com.example.interview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.interview.Controller.ActivityRecorder;

public class MainActivity extends AppCompatActivity {

    Button btnstart, btnlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnstart = (Button) findViewById(R.id.btninciar);
        btnlist = (Button) findViewById(R.id.btnlista);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityRecorder.class);
                startActivity(intent);
            }
        });
        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Aun en desarrollo", Toast.LENGTH_LONG).show();
            }
        });
    }
}