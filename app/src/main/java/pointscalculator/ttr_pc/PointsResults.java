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


        // take data from Intent
        Intent intent = getIntent();
        String finalYellowName = intent.getStringExtra(MainActivity.YELLOW_TEAM_NAME);
        String finalYellowPointsResult = intent.getStringExtra(MainActivity.YELLOW_TEAM_RESULTS);
        String finalBlueName = intent.getStringExtra(MainActivity.BLUE_TEAM_NAME);
        String finalBluePointsResult = intent.getStringExtra(MainActivity.BLUE_TEAM_RESULTS);
        String finalBlackName = intent.getStringExtra(MainActivity.BLACK_TEAM_NAME);
        String finalBlackPointsResult = intent.getStringExtra(MainActivity.BLACK_TEAM_RESULTS);
        String finalRedName = intent.getStringExtra(MainActivity.RED_TEAM_NAME);
        String finalRedPointsResult = intent.getStringExtra(MainActivity.RED_TEAM_RESULTS);
        String finalGreenName = intent.getStringExtra(MainActivity.GREEN_TEAM_NAME);
        String finalGreenPointsResult = intent.getStringExtra(MainActivity.GREEN_TEAM_RESULTS);

        List<TeamPointsCounter> allTeamsData= (List<TeamPointsCounter>) intent.getExtras().getSerializable(MainActivity.TEAMS_OBJECTS);

        // Create text field
        TextView resultYellowName = (TextView) findViewById(R.id.teamName1);
//        resultYellowName.setTextSize(10);
        resultYellowName.setText(finalYellowName);
        TextView resultYellowPoints = (TextView) findViewById(R.id.teamResult1);
        resultYellowPoints.setText(finalYellowPointsResult);
        TextView resultBlueName = (TextView) findViewById(R.id.teamName2);
        resultBlueName.setText(finalBlueName);
        TextView resultBluePoints = (TextView) findViewById(R.id.teamResult2);
        resultBluePoints.setText(finalBluePointsResult);
        TextView resultBlackName = (TextView) findViewById(R.id.teamName3);
        resultBlackName.setText(finalBlackName);
        TextView resultBlackPoints = (TextView) findViewById(R.id.teamResult3);
        resultBlackPoints.setText(finalBlackPointsResult);
        TextView resultRedName = (TextView) findViewById(R.id.teamName4);
        resultRedName.setText(finalRedName);
        TextView resultRedPoints = (TextView) findViewById(R.id.teamResult4);
        resultRedPoints.setText(finalRedPointsResult);
        TextView resultGreenName = (TextView) findViewById(R.id.teamName5);
        resultGreenName.setText(finalGreenName);
        TextView resultGreenPoints = (TextView) findViewById(R.id.teamResult5);
        resultGreenPoints.setText(finalGreenPointsResult);

        calculateWinner();
    }

    private void calculateWinner() {

    }
}
