package com.example.jay.mydatabaseapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addContact extends AppCompatActivity {
    EditText contactName, contactEmail, contactNumber;
    Context context = this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        contactName = (EditText) findViewById(R.id.contactName);
        contactEmail = (EditText) findViewById(R.id.contactEmail);
        contactNumber = (EditText) findViewById(R.id.contactNumber);

    }

    public void insertContact(View view){
        String name = contactName.getText().toString();
        String email = contactEmail.getText().toString();
        String number = contactNumber.getText().toString();
        userDbHelper = new UserDbHelper(context);
        sqLiteDatabase = userDbHelper.getWritableDatabase();
        userDbHelper.addInfo(name, number, email, sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Your contact was saved", Toast.LENGTH_LONG).show();
        userDbHelper.close();

    }
}
