package com.sonait.facultyadvisor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        /*ImageView img = (ImageView) findViewById(R.id.student_click);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your code here
                Intent i = new Intent(dashboard.this, Student.class);
                startActivity(i);
            }
        });*/
    }
    public void attendance_click(View view) {
        Intent i = new Intent(this, Attendance.class);
        startActivity(i);
    }
    public void student_click(View view) {
        Intent i = new Intent(this, Student.class);
        startActivity(i);
    }
    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("finish", true);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK); // To clean up all activities
        startActivity(intent);
        Toast.makeText(dashboard.this, "Logout Successful", Toast.LENGTH_SHORT).show();
        finish();
    }
}