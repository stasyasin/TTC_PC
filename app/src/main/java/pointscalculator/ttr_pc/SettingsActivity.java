package pointscalculator.ttr_pc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.ads.*;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
//        AdRequest adRequest = new com.google.android.gms.ads.AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .addTestDevice("A2FAD940C1B8A8B03605604D735E629E").build();// testMode
        mAdView.loadAd(adRequest);

        EditText teamResults;
        teamResults = (EditText) findViewById(R.id.trainPoints1);
        teamResults.setText(String.valueOf(TeamPointsCounter.coef1));
        teamResults = (EditText) findViewById(R.id.trainPoints2);
        teamResults.setText(String.valueOf(TeamPointsCounter.coef2));
        teamResults = (EditText) findViewById(R.id.trainPoints3);
        teamResults.setText(String.valueOf(TeamPointsCounter.coef3));
        teamResults = (EditText) findViewById(R.id.trainPoints4);
        teamResults.setText(String.valueOf(TeamPointsCounter.coef4));
        teamResults = (EditText) findViewById(R.id.trainPoints5);
        teamResults.setText(String.valueOf(TeamPointsCounter.coef5));
        teamResults = (EditText) findViewById(R.id.trainPoints6);
        teamResults.setText(String.valueOf(TeamPointsCounter.coef6));
    }

    public void saveSettings(View view) {
        EditText editText;
        editText = (EditText) findViewById(R.id.trainPoints1);
        if (!editText.getText().toString().equals("")) {
            TeamPointsCounter.coef1 = Integer.parseInt(editText.getText().toString());
        } else {
            editText.setText(String.valueOf(TeamPointsCounter.coef1));
        }
        editText = (EditText) findViewById(R.id.trainPoints2);
        if (!editText.getText().toString().equals("")) {
            TeamPointsCounter.coef2 = Integer.parseInt(editText.getText().toString());
        } else {
            editText.setText(String.valueOf(TeamPointsCounter.coef2));
        }
        editText = (EditText) findViewById(R.id.trainPoints3);
        if (!editText.getText().toString().equals("")) {
            TeamPointsCounter.coef3 = Integer.parseInt(editText.getText().toString());
        } else {
            editText.setText(String.valueOf(TeamPointsCounter.coef3));
        }
        editText = (EditText) findViewById(R.id.trainPoints4);
        if (!editText.getText().toString().equals("")) {
            TeamPointsCounter.coef4 = Integer.parseInt(editText.getText().toString());
        } else {
            editText.setText(String.valueOf(TeamPointsCounter.coef4));
        }
        editText = (EditText) findViewById(R.id.trainPoints5);
        if (!editText.getText().toString().equals("")) {
            TeamPointsCounter.coef5 = Integer.parseInt(editText.getText().toString());
        } else {
            editText.setText(String.valueOf(TeamPointsCounter.coef5));
        }
        editText = (EditText) findViewById(R.id.trainPoints6);
        if (!editText.getText().toString().equals("")) {
            TeamPointsCounter.coef6 = Integer.parseInt(editText.getText().toString());
        } else {
            editText.setText(String.valueOf(TeamPointsCounter.coef6));
        }
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
        editText.setText(String.valueOf(TeamPointsCounter.coef1));
        editText = (EditText) findViewById(R.id.trainPoints2);
        editText.setText(String.valueOf(TeamPointsCounter.coef2));
        editText = (EditText) findViewById(R.id.trainPoints3);
        editText.setText(String.valueOf(TeamPointsCounter.coef3));
        editText = (EditText) findViewById(R.id.trainPoints4);
        editText.setText(String.valueOf(TeamPointsCounter.coef4));
        editText = (EditText) findViewById(R.id.trainPoints5);
        editText.setText(String.valueOf(TeamPointsCounter.coef5));
        editText = (EditText) findViewById(R.id.trainPoints6);
        editText.setText(String.valueOf(TeamPointsCounter.coef6));
    }
}
