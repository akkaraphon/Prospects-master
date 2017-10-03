package com.example.pmakkaraphon.prospects;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pmakkaraphon.prospects.Tool.ShareResult;

public class ProfileS3Activity extends AppCompatActivity {
    CheckBox chk;
    Button mSubmit;
    EditText editIdhome;
    ShareResult res = new ShareResult().getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_step3);
        mSubmit = (Button) findViewById(R.id.btnNextS3);
        editIdhome = (EditText)findViewById(R.id.txtIdHomeCon);
        chk = (CheckBox)findViewById(R.id.chkAddn);

        final AlertDialog.Builder builder =
                new AlertDialog.Builder(ProfileS3Activity.this);
        builder.setMessage(R.string.dialog1);
        builder.setPositiveButton("ใช่", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
//                Intent intent = new Intent(ProfileS3Activity.this, ProfileS4Activity.class);
//                startActivity(intent);
//                overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_left);
                editIdhome.setText(res.idHome);
                chk.setEnabled(false);
            }
        });
        builder.setNegativeButton("ไม่ใช่", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                chk.setChecked(false);
            }
        });


        chk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.show();
            }
        });


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
