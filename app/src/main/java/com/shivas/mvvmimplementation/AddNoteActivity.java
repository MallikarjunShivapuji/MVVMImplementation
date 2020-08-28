package com.shivas.mvvmimplementation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Node;

import java.util.UUID;

public class AddNoteActivity extends AppCompatActivity {

    TextView tv;
    Button b;

    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        tv = findViewById(R.id.textView);

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

    }

    public void addNote(View view) {
        Thread t;
        final String id = UUID.randomUUID().toString();
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                Note note = new Note(id, tv.getText().toString());
                mainActivityViewModel.insert(note);
                Log.e("mallik", "note inserted : " + note.toString());
            }
        });
        t.start();

        Toast.makeText(this, "Saved ", Toast.LENGTH_LONG).show();
    }
}