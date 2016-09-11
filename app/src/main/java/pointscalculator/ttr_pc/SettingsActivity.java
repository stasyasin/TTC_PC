package pointscalculator.ttr_pc;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.ads.*;

public class SettingsActivity extends AppCompatActivity {
    private AdView adView;
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_COEF1 = "coef1";
    private SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        AdView mAdView = (AdView) findViewById(R.id.adView);
//        mAdView.setAdSize(AdSize.SMART_BANNER);//Размер баннера
        AdRequest adRequest = new AdRequest.Builder().build();//todo for production
//        AdRequest adRequest = new com.google.android.gms.ads.AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .addTestDevice("A2FAD940C1B8A8B03605604D735E629E").build();// testmode
        mAdView.loadAd(adRequest);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        EditText teamResults;
        teamResults = (EditText) findViewById(R.id.trainPoints1);
        teamResults.setText(TeamPointsCounter.coef1.toString());
        teamResults = (EditText) findViewById(R.id.trainPoints2);
        teamResults.setText(TeamPointsCounter.coef2.toString());
        teamResults = (EditText) findViewById(R.id.trainPoints3);
        teamResults.setText(TeamPointsCounter.coef3.toString());
        teamResults = (EditText) findViewById(R.id.trainPoints4);
        teamResults.setText(TeamPointsCounter.coef4.toString());
        teamResults = (EditText) findViewById(R.id.trainPoints5);
        teamResults.setText(TeamPointsCounter.coef5.toString());
        teamResults = (EditText) findViewById(R.id.trainPoints6);
        teamResults.setText(TeamPointsCounter.coef6.toString());
    }

    public void saveSettings(View view) {
        EditText editText;
        editText = (EditText) findViewById(R.id.trainPoints1);
        TeamPointsCounter.coef1 = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.trainPoints2);
        TeamPointsCounter.coef2 = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.trainPoints3);
        TeamPointsCounter.coef3 = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.trainPoints4);
        TeamPointsCounter.coef4 = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.trainPoints5);
        TeamPointsCounter.coef5 = Integer.parseInt(editText.getText().toString());
        editText = (EditText) findViewById(R.id.trainPoints6);
        TeamPointsCounter.coef6 = Integer.parseInt(editText.getText().toString());
    }

    public void defaultSettings(View view) {
        EditText editText;
        TeamPointsCounter.coef1 = 1;
        TeamPointsCounter.coef2 = 2;
        TeamPointsCounter.coef3 = 4;
        TeamPointsCounter.coef4 = 7;
        TeamPointsCounter.coef5 = 15;
        TeamPointsCounter.coef6 = 21;
        editText = (EditText) findViewById(R.id.trainPoints1);
        editText.setText(TeamPointsCounter.coef1.toString());
        editText = (EditText) findViewById(R.id.trainPoints2);
        editText.setText(TeamPointsCounter.coef2.toString());
        editText = (EditText) findViewById(R.id.trainPoints3);
        editText.setText(TeamPointsCounter.coef3.toString());
        editText = (EditText) findViewById(R.id.trainPoints4);
        editText.setText(TeamPointsCounter.coef4.toString());
        editText = (EditText) findViewById(R.id.trainPoints5);
        editText.setText(TeamPointsCounter.coef5.toString());
        editText = (EditText) findViewById(R.id.trainPoints6);
        editText.setText(TeamPointsCounter.coef6.toString());
    }
}
