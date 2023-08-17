package org.mar_3.webdev_mobile_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fillInformationBtn = (Button) findViewById(R.id.fillInformationBtn);
        fillInformationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fillInformationActivity();
            }
        });

    }

    private void fillInformationActivity() {
        Intent switchActivityIntent = new Intent(this, FillInformationActivity.class);
        startActivity(switchActivityIntent);
    }
}