package com.example.pmakkaraphon.prospects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pmakkaraphon.prospects.API.ConnectionManager;
import com.example.pmakkaraphon.prospects.API.OnNetworkCallbackListener;
import com.example.pmakkaraphon.prospects.Model.User;

import org.w3c.dom.Text;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class ProfileS1Activity extends AppCompatActivity {
    OnNetworkCallbackListener networkCallbackListener;
    Button mSubmit;
    TextView name;
    TextView lastname;
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
                new ConnectionManager().callServer(networkCallbackListener,name.getText().toString(),lastname.getText().toString());
            }
        });
        networkCallbackListener = new OnNetworkCallbackListener() {
            @Override
            public void onResponse(User user, Retrofit retrofit) {
                Log.d("Poon",user.getName()+" "+user.getLastname());
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
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_slide_in_right,R.anim.anim_slide_out_right);
    }
}
