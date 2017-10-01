package com.example.pmakkaraphon.prospects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.pmakkaraphon.prospects.API.ConnectionManager;
import com.example.pmakkaraphon.prospects.API.OnNetworkCallbackListener;
import com.example.pmakkaraphon.prospects.Model.DistictModel;
import com.example.pmakkaraphon.prospects.Model.PrenameModel;
import com.example.pmakkaraphon.prospects.Model.ProvinceModel;
import com.example.pmakkaraphon.prospects.Model.User;
import com.squareup.okhttp.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import retrofit.Retrofit;

public class ProfileS2Activity extends AppCompatActivity {
    Spinner spProname;
    String TAG = "POON S2";
    List<String> proName = new ArrayList<String>();
    ConnectionManager connect = new ConnectionManager();
    Button mSubmit;
    OnNetworkCallbackListener networkCallbackListener = new OnNetworkCallbackListener() {
        @Override
        public void onResponsePre(List<PrenameModel> model, Retrofit retrofit){

        }

        @Override
        public void onResponsePro(List<ProvinceModel> provinceModels, Retrofit retrofit) {
            for (int i = 0;i<provinceModels.size();i++){
                if (i==0){
                    proName.add("--กรุณาเลือก--");
                }
                proName.add(provinceModels.get(i).getPV_TNAME().toString());
                Log.d(TAG,provinceModels.get(i).getPV_TNAME().toString()+" "+provinceModels.get(i).getPV_CODE().toString());
            }
        }

        @Override
        public void onResponse(User user, Retrofit retrofit) {



        }

        @Override
        public void onResponseDis(List<DistictModel> user, Retrofit retrofit) {

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_step2);

        connect.callProvince(networkCallbackListener);

        spProname = (Spinner)findViewById(R.id.spCity);

        ArrayAdapter<String > adapter =
                new ArrayAdapter<String>(this,R.layout.spinner_dropdown_item, proName);
        spProname.setAdapter(adapter);

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
