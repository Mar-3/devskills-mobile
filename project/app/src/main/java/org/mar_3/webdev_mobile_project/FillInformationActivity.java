package org.mar_3.webdev_mobile_project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FillInformationActivity extends AppCompatActivity {

    ArrayList<Participant> participants;
    ParticipantsViewAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_information);
        Button addParticipantBtn = (Button) findViewById(R.id.addParticipantBtn);

        participants = new ArrayList<>();
        participants.add(new Participant("ss", "ss", "sad"));
        participants.add(new Participant("ss", "ss", "sad"));

        recyclerView = findViewById(R.id.participantsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ParticipantsViewAdapter(this, participants);
        recyclerView.setAdapter(adapter);



        addParticipantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nameEditText = findViewById(R.id.nameEditText);
                EditText avecEditText = findViewById(R.id.avecEditText);
                EditText friendEditText = findViewById(R.id.friendEditText);

                String name = nameEditText.getText().toString();
                String avec = avecEditText.getText().toString();
                String friend = friendEditText.getText().toString();

                Participant newParticipant = new Participant(name, avec, friend);
                nameEditText.setText("");
                avecEditText.setText("");
                friendEditText.setText("");

                participants.add(newParticipant);
                adapter.notifyItemInserted(participants.size()-1);
            }
        });
    }
}