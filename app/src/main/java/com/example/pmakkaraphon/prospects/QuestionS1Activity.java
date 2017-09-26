package com.example.pmakkaraphon.prospects;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class QuestionS1Activity extends AppCompatActivity {

    RadioGroup rg1;
    RadioGroup rg2;
    RadioGroup rg3;
    RadioButton rOcItem5;
    TextView txtOcetc;
    boolean isChecking = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_s1);
        rg1=(RadioGroup)findViewById(R.id.txtOcg1);
        rg2=(RadioGroup)findViewById(R.id.txtOcg2);
        rg3=(RadioGroup)findViewById(R.id.txtOcg3);
        rOcItem5 = (RadioButton)findViewById(R.id.ROc5);
        txtOcetc = (TextView)findViewById(R.id.txtOcEtc);

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




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_slide_in_right,R.anim.anim_slide_out_right);
    }
}
