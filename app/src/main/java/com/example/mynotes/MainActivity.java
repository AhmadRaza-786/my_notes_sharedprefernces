package com.example.mynotes;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private MyNote myNote;
    private EditText editNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNote = findViewById(R.id.editNote);

        myNote = new MyNote(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String textRecover = editNote.getText().toString();
                if (textRecover.equals("")) {
                    Snackbar.make(view, "Fill in the note!", Snackbar.LENGTH_LONG).show();
                } else {
                    myNote.saveNotes(textRecover);
                    Snackbar.make(view, "Note save successfully!", Snackbar.LENGTH_LONG).show();
                }


            }
        });

      String notes  =  myNote.receiveNotes();
      if (!notes.equals("")) {
          editNote.setText(notes);
      }
    }

}