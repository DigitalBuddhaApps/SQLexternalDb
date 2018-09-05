package com.bigkidsapps.databaseapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText name;
    public Button query_button;
    public TextView result_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        query_button = findViewById(R.id.query_button);
        result_address = findViewById(R.id.result);

        query_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();

                String n = name.getText().toString();
                String address = databaseAccess.getAddress(n);

                result_address.setText(address);
                databaseAccess.close();


            }
        });
    }
}
