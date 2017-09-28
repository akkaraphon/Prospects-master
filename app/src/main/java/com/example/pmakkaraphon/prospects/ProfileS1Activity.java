package com.example.pmakkaraphon.prospects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmakkaraphon.prospects.API.ConnectionManager;
import com.example.pmakkaraphon.prospects.API.OnNetworkCallbackListener;
import com.example.pmakkaraphon.prospects.Model.PrenameModel;
import com.example.pmakkaraphon.prospects.Model.User;
import com.squareup.okhttp.ResponseBody;


import java.util.List;

import retrofit.Retrofit;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class ProfileS1Activity extends AppCompatActivity {
    String TAG = "POON TEST";
    Button mSubmit;
    TextView name;
    TextView lastname;
    ConnectionManager connect = new ConnectionManager();
    OnNetworkCallbackListener networkCallbackListener = new OnNetworkCallbackListener() {
        @Override
        public void onResponse(List<PrenameModel> model, Retrofit retrofit){
            for (int i = 0;i<model.size();i++){
                Log.d(TAG,model.get(i).getPN_NAME().toString()+" "+model.get(i).getPN_CODE().toString());
            }

        }
        @Override
        public void onResponse(User user, Retrofit retrofit) {

                Log.d(TAG,user.getName()+" "+user.getLastname().toString());

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/LayijiMahaniyom-Bao-1.2.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());
        setContentView(R.layout.profile_step1);

        name = (TextView)findViewById(R.id.txtName);
        lastname = (TextView)findViewById(R.id.txtLastname);

        mSubmit = (Button) findViewById(R.id.btnNextS1);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(ProfileS1Activity.this, ProfileS2Activity.class);
//                startActivity(intent);
//                overridePendingTransition(R.anim.anim_slide_in_left,R.anim.anim_slide_out_left);
                Log.d(TAG,"Press Button");
//               connect.callServer(networkCallbackListener);
                connect.postName(networkCallbackListener,"Witchapon","Pimrat");
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_slide_in_right,R.anim.anim_slide_out_right);
    }
}
