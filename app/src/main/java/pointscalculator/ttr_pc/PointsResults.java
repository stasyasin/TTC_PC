package pointscalculator.ttr_pc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PointsResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_results);


        // take data from Intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Create text field
        TextView resultYellowName = (TextView) findViewById(R.id.resultYellowName);
        resultYellowName.setTextSize(10);
        resultYellowName.setText(message);

        // Set this field in text of activity
//        setContentView(resultYellowName);
    }
}
