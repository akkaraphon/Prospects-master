package com.example.pmakkaraphon.prospects;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class QuestionS1Activity extends AppCompatActivity {

    RadioGroup rg1;
    RadioGroup rg2;
    RadioGroup rg3;
    RadioButton rOcItem1,rOcItem2,rOcItem3,rOcItem4,rOcItem5,rSize1,rSize2,rAge1,rAge2,rAge3,rAge4,rSt1,rSt2,rSt3;
    CheckBox chk1,chk2,chk3,chk4,chk5,chkk1,chkk2,chkk3,chkk4,chkk5,chkk6,chkk7,chkk8,chkk9,chkk10,chkk11,chkk12,chkkk1,chkkk2,chkkk3,chkkk4,chkkk5,chkkk6;
    TextView txtOcetc;
    boolean isChecking = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_s1);
        set();

        rSize1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rSize2.setChecked(false);
            }
        });

        rSize2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rSize1.setChecked(false);
            }
        });

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i != -1 && isChecking) {
                    isChecking = false;
                    rg2.clearCheck();
                    rg3.clearCheck();
                    txtOcetc.setVisibility(View.INVISIBLE);
                }
                isChecking = true;
            }
        });
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i != -1 && isChecking) {
                    isChecking = false;
                    rg1.clearCheck();
                    rg3.clearCheck();
                    txtOcetc.setVisibility(View.INVISIBLE);
                }
                isChecking = true;
            }
        });

        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (i != -1 && isChecking) {
                    isChecking = false;
                    rg1.clearCheck();
                    rg2.clearCheck();
                    txtOcetc.setVisibility(View.VISIBLE);
                }
                isChecking = true;
            }
        });

    }
    public void set(){
        txtOcetc = (TextView)findViewById(R.id.txtOcEtc);

        chk1 = (CheckBox) findViewById(R.id.Chk1);
        chk2 = (CheckBox) findViewById(R.id.Chk2);
        chk3 = (CheckBox) findViewById(R.id.Chk3);
        chk4 = (CheckBox) findViewById(R.id.Chk4);
        chk5 = (CheckBox) findViewById(R.id.Chk5);

        chkk1 = (CheckBox) findViewById(R.id.Chkk1);
        chkk2 = (CheckBox) findViewById(R.id.Chkk2);
        chkk3 = (CheckBox) findViewById(R.id.Chkk3);
        chkk4 = (CheckBox) findViewById(R.id.Chkk4);
        chkk5 = (CheckBox) findViewById(R.id.Chkk5);
        chkk6 = (CheckBox) findViewById(R.id.Chkk6);
        chkk7 = (CheckBox) findViewById(R.id.Chkk7);
        chkk8 = (CheckBox) findViewById(R.id.Chkk8);
        chkk9 = (CheckBox) findViewById(R.id.Chkk9);
        chkk10 = (CheckBox) findViewById(R.id.Chkk10);
        chkk11= (CheckBox) findViewById(R.id.Chkk11);
        chkk12= (CheckBox) findViewById(R.id.Chkk12);

        chkkk1 = (CheckBox) findViewById(R.id.Chkkk1);
        chkkk2 = (CheckBox) findViewById(R.id.Chkkk2);
        chkkk3 = (CheckBox) findViewById(R.id.Chkkk3);
        chkkk4 = (CheckBox) findViewById(R.id.Chkkk4);
        chkkk5 = (CheckBox) findViewById(R.id.Chkkk5);
        chkkk6 = (CheckBox) findViewById(R.id.Chkkk6);


        rg1 = (RadioGroup)findViewById(R.id.txtOcg1);
        rg2 = (RadioGroup)findViewById(R.id.txtOcg2);
        rg3 = (RadioGroup)findViewById(R.id.txtOcg3);

        rSize1 = (RadioButton)findViewById(R.id.Rsize1);
        rSize2 = (RadioButton)findViewById(R.id.Rsize2);
        rOcItem1 = (RadioButton)findViewById(R.id.ROc1);
        rOcItem2 = (RadioButton)findViewById(R.id.ROc2);
        rOcItem3 = (RadioButton)findViewById(R.id.ROc3);
        rOcItem4 = (RadioButton)findViewById(R.id.ROc4);
        rOcItem5 = (RadioButton)findViewById(R.id.ROc5);
        rAge1 = (RadioButton)findViewById(R.id.RAge1);
        rAge2 = (RadioButton)findViewById(R.id.RAge2);
        rAge3 = (RadioButton)findViewById(R.id.RAge3);
        rAge4 = (RadioButton)findViewById(R.id.RAge4);
        rSt1 = (RadioButton)findViewById(R.id.Rst1);
        rSt2 = (RadioButton)findViewById(R.id.Rst2);
        rSt3 = (RadioButton)findViewById(R.id.Rst3);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_slide_in_right,R.anim.anim_slide_out_right);
    }
}
