package com.example.pmakkaraphon.prospects;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pmakkaraphon.prospects.API.ConnectionManager;
import com.example.pmakkaraphon.prospects.API.PreNameCallbackListener;
import com.example.pmakkaraphon.prospects.Adapter.CustomSpinner;
import com.example.pmakkaraphon.prospects.Model.DistictModel;
import com.example.pmakkaraphon.prospects.Model.PrenameModel;
import com.example.pmakkaraphon.prospects.Model.ProvinceModel;
import com.example.pmakkaraphon.prospects.Model.User;
import com.example.pmakkaraphon.prospects.Tool.ShareResult;
import com.squareup.okhttp.ResponseBody;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit.Retrofit;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class ProfileS1Activity extends AppCompatActivity {
    String TAG = "Step 1 :";
    Button mSubmit;
    TextView txtdate_save,txtdate_come;
    EditText edtName,edtLastname,edtBirth,edtIDcard,edtExpID,edtTel,edtMobile,edtEmail;
    RadioButton rd1,rd2;
    Spinner spPrename;
    ConnectionManager connect = new ConnectionManager();
    PreNameCallbackListener networkCallbackListener;
    ShareResult res = new ShareResult().getInstance();

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
        mSubmit = (Button) findViewById(R.id.btnNextS1);
        txtdate_come = (TextView)findViewById(R.id.txtDatecome);
        txtdate_save = (TextView) findViewById(R.id.txtDatesave);

        edtName = (EditText) findViewById(R.id.txtName);
        edtLastname = (EditText)findViewById(R.id.txtLastname);
        edtBirth = (EditText) findViewById(R.id.txtBirth);
        edtIDcard = (EditText) findViewById(R.id.txtIDCard);
        edtExpID = (EditText) findViewById(R.id.txtExpID);
        edtTel = (EditText) findViewById(R.id.txtTel);
        edtMobile = (EditText) findViewById(R.id.txtMobile);
        edtEmail = (EditText) findViewById(R.id.txtEmail);

        rd1 = (RadioButton) findViewById(R.id.Rsms1);
        rd2 = (RadioButton) findViewById(R.id.Rsms2);

        Date date = Calendar.getInstance().getTime();

        txtdate_come.setText(date.toString());

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res.name = edtName.getText().toString();
                res.lastname = edtLastname.getText().toString();
                res.birthday = edtBirth.getText().toString();
                res.idCard = edtIDcard.getText().toString();
                res.exp = edtExpID.getText().toString();
                res.tel = edtTel.getText().toString();
                res.mobile = edtMobile.getText().toString();
                res.email = edtEmail.getText().toString();

                Intent intent = new Intent(ProfileS1Activity.this, ProfileS2Activity.class);
                Log.d(TAG,res.name+" "+res.lastname+" "+res.birthday+" "+res.idCard+" "+res.exp+" "+res.tel+" "+res.mobile+" "+res.email);
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
