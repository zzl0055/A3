package com.example.a3;


import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.util.Log;
import android.widget.EditText;
import android.content.SharedPreferences;
import android.view.View;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button btnSave;
    int listNumber = 0;
    EditText txtContent, txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        txtTitle = findViewById(R.id.txtTitle);
        txtContent = findViewById(R.id.txtContent);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listNumber++;
                NoteModel note = new NoteModel();


                note.title = txtTitle.getText().toString();
                note.content = note.title;

                SharedPreferences pre = getPreferences(0);

                SharedPreferences.Editor editor = pre.edit();
                String json = note.toJson();
                Log.i("json", json);
                note.fromJson(json);
                editor.putString(note.title, json);
                editor.commit();
                txtTitle.setText(note.title);

                txtContent.setText(txtContent.getText().toString() + "list" + "  _"
                        + listNumber +":  " + note.content +"\n");
            }
        });

    }
}