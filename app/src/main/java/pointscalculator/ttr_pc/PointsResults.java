package pointscalculator.ttr_pc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class PointsResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_results);

        Intent intent = getIntent();
        List<TeamPointsCounter> allTeamsData = (List<TeamPointsCounter>) intent.getExtras().getSerializable(MainActivity.TEAMS_OBJECTS);

        for (int i = 1; i <= allTeamsData.size(); i++) {
            TextView teamName = (TextView) findViewById(getResources().getIdentifier("teamName" + i, "id", this.getPackageName()));
            teamName.setText(allTeamsData.get(i - 1).name);
            TextView teamResults = (TextView) findViewById(getResources().getIdentifier("teamResult" + i, "id", this.getPackageName()));
            teamResults.setText(allTeamsData.get(i - 1).teamPointsResult.toString());
        }
    }
}
