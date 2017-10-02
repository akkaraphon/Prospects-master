package com.example.pmakkaraphon.prospects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pmakkaraphon.prospects.API.ConnectionManager;
import com.example.pmakkaraphon.prospects.API.PreNameCallbackListener;
import com.example.pmakkaraphon.prospects.Adapter.CustomSpinner;
import com.example.pmakkaraphon.prospects.Model.DistictModel;
import com.example.pmakkaraphon.prospects.Model.PrenameModel;
import com.example.pmakkaraphon.prospects.Model.ProvinceModel;
import com.example.pmakkaraphon.prospects.Model.User;
import com.squareup.okhttp.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import retrofit.Retrofit;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class ProfileS1Activity extends AppCompatActivity {
    String TAG = "POON TEST";
    Button mSubmit;
    TextView name;
    TextView lastname;
    Spinner spPrename;
    ConnectionManager connect = new ConnectionManager();
    PreNameCallbackListener networkCallbackListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/LayijiMahaniyom-Bao-1.2.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());

        networkCallbackListener = new PreNameCallbackListener() {
            @Override
            public void onResponse(List<PrenameModel> model, Retrofit retrofit){
                CustomSpinner customSpinner = new CustomSpinner(getApplicationContext(), model);
                spPrename.setAdapter(customSpinner);
            }

            @Override
            public void onBodyError(ResponseBody responseBodyError) {
                Log.d(TAG,"ERROR"+responseBodyError.toString());

            }

            @Override
            public void onBodyErrorIsNull() {
                Log.d(TAG,"NULL!!!!!!");
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d(TAG,"Fail"+t.toString());
            }
        };
        connect.callPrename(networkCallbackListener);
        setContentView(R.layout.profile_step1);
        spPrename = (Spinner)findViewById(R.id.spPrename);
        name = (TextView)findViewById(R.id.txtName);
        lastname = (TextView)findViewById(R.id.txtLastname);
        mSubmit = (Button) findViewById(R.id.btnNextS1);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ProfileS1Activity.this, ProfileS2Activity.class);
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
