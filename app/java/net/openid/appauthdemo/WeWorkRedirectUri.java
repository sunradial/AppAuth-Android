package net.openid.appauthdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import static android.util.Base64.URL_SAFE;

public class WeWorkRedirectUri extends AppCompatActivity {

    private static final String TAG = "WeWorkRedirectUri";
    @Override
    public void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        Intent intent = getIntent();
        if (intent != null) {
            String intentAction = intent.getAction();
            if (Intent.ACTION_VIEW.equals(intentAction)) {
                Uri intentData = intent.getData();
                String token = intentData.getQueryParameter("token");
                String seq = intentData.getQueryParameter("seq");
                String paramsBase64 = intentData.getQueryParameter("param");
                String params = "";
                if(null != paramsBase64){
                    params = new String(Base64.decode(paramsBase64.getBytes(), URL_SAFE));
                }
                if(params.length() > 0){
                    JSONObject jsonObject;
                    try {
                        jsonObject = new JSONObject(params);
                    }catch (JSONException e){

                    }
                }
                Log.e(TAG, "initIntentData: " + token);
                Log.e(TAG, "initIntentData: " + seq);
                Log.e(TAG, "params:" + params);
                Toast.makeText(this, "Token is:" + token, Toast.LENGTH_LONG).show();
            }
        }
    }
}
