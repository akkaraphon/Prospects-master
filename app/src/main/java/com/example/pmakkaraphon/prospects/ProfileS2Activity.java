package com.example.pmakkaraphon.prospects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pmakkaraphon.prospects.API.ConnectionManager;
import com.example.pmakkaraphon.prospects.API.DistictCallbackListener;
import com.example.pmakkaraphon.prospects.API.PreNameCallbackListener;
import com.example.pmakkaraphon.prospects.API.ProvinceCallbackListener;
import com.example.pmakkaraphon.prospects.Adapter.CustomDistictSP;
import com.example.pmakkaraphon.prospects.Adapter.CustomProvinceSP;
import com.example.pmakkaraphon.prospects.Adapter.CustomSpinner;
import com.example.pmakkaraphon.prospects.Model.DistictModel;
import com.example.pmakkaraphon.prospects.Model.PrenameModel;
import com.example.pmakkaraphon.prospects.Model.ProvinceModel;
import com.example.pmakkaraphon.prospects.Model.User;
import com.squareup.okhttp.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import retrofit.Retrofit;

public class ProfileS2Activity extends AppCompatActivity {
    Spinner spProvince,spDistict;
    String pv_code = " ";
    String TAG = "POON S2";
    List<String> proName = new ArrayList<String>();
    ConnectionManager connect = new ConnectionManager();
    Button mSubmit;
    ProvinceCallbackListener provinceCallbackListener;
    DistictCallbackListener distictCallbackListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        provinceCallbackListener = new ProvinceCallbackListener() {
            @Override
            public void onResponse(final List<ProvinceModel> provinceModels, Retrofit retrofit) {
                CustomProvinceSP customSpinner = new CustomProvinceSP(getApplicationContext(), provinceModels);
                spProvince.setAdapter(customSpinner);
                spProvince.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        pv_code = provinceModels.get(i).getPV_CODE();
                        connect.callDis(distictCallbackListener,pv_code);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }

            @Override
            public void onBodyError(ResponseBody responseBodyError) {

            }

            @Override
            public void onBodyErrorIsNull() {

            }

            @Override
            public void onFailure(Throwable t) {

            }
        };
        distictCallbackListener = new DistictCallbackListener() {
            @Override
            public void onResponse(List<DistictModel> distictModels, Retrofit retrofit) {
                CustomDistictSP customDistictSP = new CustomDistictSP(getApplicationContext(),distictModels);
                spDistict.setAdapter(customDistictSP);
            }

            @Override
            public void onBodyError(ResponseBody responseBodyError) {

            }

            @Override
            public void onBodyErrorIsNull() {

            }

            @Override
            public void onFailure(Throwable t) {

            }
        };
        connect.callProvince(provinceCallbackListener);

//        connect.callDis(distictCallbackListener,pv_code);

        setContentView(R.layout.profile_step2);
        spProvince = (Spinner)findViewById(R.id.spCity);
        spDistict = (Spinner)findViewById(R.id.spDistrict);



        mSubmit = (Button) findViewById(R.id.btnNextS2);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileS2Activity.this, ProfileS3Activity.class);
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
