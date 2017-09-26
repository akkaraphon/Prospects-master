package com.example.pmakkaraphon.prospects;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class ProfileS3Activity extends AppCompatActivity {
    CheckBox chk;
    Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_step3);



        final AlertDialog.Builder builder =
                new AlertDialog.Builder(ProfileS3Activity.this);
        builder.setMessage("ที่อยู่ปัจจุบันอาศัยอยู่ที่เดียวกับที่อยู่ตามบัตรประชาชนหรือไม่?");
        builder.setPositiveButton("ใช่", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(ProfileS3Activity.this, ProfileS4Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_left);
            }
        });
        builder.setNegativeButton("ไม่ใช่", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                chk.setChecked(false);
            }
        });

        chk = (CheckBox)findViewById(R.id.chkAddn);
        chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.show();
            }
        });

        mSubmit = (Button) findViewById(R.id.btnNextS3);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileS3Activity.this, ProfileS4Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_left);
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_slide_in_right,R.anim.anim_slide_out_right);
    }
}
