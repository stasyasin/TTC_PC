package pointscalculator.ttr_pc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.ads.*;

import java.util.List;

public class PointsResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_results);

        AdView mAdView = (AdView) findViewById(R.id.adView);
//        mAdView.setAdSize(AdSize.SMART_BANNER);//Размер баннера
        AdRequest adRequest = new AdRequest.Builder().build();//todo Prod
//        AdRequest adRequest = new com.google.android.gms.ads.AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .addTestDevice("A2FAD940C1B8A8B03605604D735E629E").build();// testmode
        mAdView.loadAd(adRequest);

        Intent intent = getIntent();
        List<TeamPointsCounter> allTeamsData = (List<TeamPointsCounter>) intent.getExtras().getSerializable(MainActivity.TEAMS_OBJECTS);

        for (int i = 1; i <= allTeamsData.size(); i++) {
            TextView teamName = (TextView) findViewById(getResources().getIdentifier("teamName" + i, "id", this.getPackageName()));
            teamName.setText(allTeamsData.get(i - 1).name);
            teamName.setTextColor(allTeamsData.get(i - 1).textColor);
            TextView teamResults = (TextView) findViewById(getResources().getIdentifier("teamResult" + i, "id", this.getPackageName()));
            teamResults.setText(allTeamsData.get(i - 1).teamPointsResult.toString());
        }
    }
}
