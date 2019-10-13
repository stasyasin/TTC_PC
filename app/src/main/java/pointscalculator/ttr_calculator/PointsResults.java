package pointscalculator.ttr_calculator;

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

        Intent intent = getIntent();
        List<TeamPointsCounter> allTeamsData = (List<TeamPointsCounter>) intent.getExtras().getSerializable(MainActivity.TEAMS_OBJECTS);

        if (allTeamsData != null) {
            for (int i = 1; i <= allTeamsData.size(); i++) {
                TextView teamName = (TextView) findViewById(getResources().getIdentifier("teamName" + i, "id", this.getPackageName()));
                teamName.setText(allTeamsData.get(i - 1).name);
                teamName.setTextColor(allTeamsData.get(i - 1).textColor);
                TextView teamResults = (TextView) findViewById(getResources().getIdentifier("teamResult" + i, "id", this.getPackageName()));
                teamResults.setText(String.valueOf(allTeamsData.get(i - 1).teamPointsResult));
            }
        }
    }
}
