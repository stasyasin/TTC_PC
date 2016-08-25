package pointscalculator.ttr_pc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public final static String YELLOW_TEAM_NAME = "app.java.pointsCalculator.ttr_pc.MainActivity.YELLOW_TEAM_NAME";
    public final static String YELLOW_TEAM_RESULTS = "app.java.pointsCalculator.ttr_pc.MainActivity.YELLOW_TEAM_RESULTS";
    public final static String BLUE_TEAM_NAME = "app.java.pointsCalculator.ttr_pc.MainActivity.BLUE_TEAM_NAME";
    public final static String BLUE_TEAM_RESULTS = "app.java.pointsCalculator.ttr_pc.MainActivity.BLUE_TEAM_RESULTS";
    public final static String BLACK_TEAM_NAME = "app.java.pointsCalculator.ttr_pc.MainActivity.BLACK_TEAM_NAME";
    public final static String BLACK_TEAM_RESULTS = "app.java.pointsCalculator.ttr_pc.MainActivity.BLACK_TEAM_RESULTS";
    public final static String RED_TEAM_NAME = "app.java.pointsCalculator.ttr_pc.MainActivity.RED_TEAM_NAME";
    public final static String RED_TEAM_RESULTS = "app.java.pointsCalculator.ttr_pc.MainActivity.RED_TEAM_RESULTS";
    public final static String GREEN_TEAM_NAME = "app.java.pointsCalculator.ttr_pc.MainActivity.GREEN_TEAM_NAME";
    public final static String GREEN_TEAM_RESULTS = "app.java.pointsCalculator.ttr_pc.MainActivity.GREEN_TEAM_RESULTS";
    public final static String TEAMS_OBJECTS = "app.java.pointsCalculator.ttr_pc.MainActivity.TEAMS_OBJECTS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Method to click on CalculatePoints button
     */
    public void calculatePoints(View view) {
        // TODO actions here
        Intent intent = new Intent(this, PointsResults.class);

        List<String> yellowInputData = getInputData(1);
        List<String> blueInputData = getInputData(2);
        List<String> blackInputData = getInputData(3);
        List<String> redInputData = getInputData(4);
        List<String> greenInputData = getInputData(5);
        List<TeamPointsCounter> allTeamsData = new ArrayList<TeamPointsCounter>();

        TeamPointsCounter yellowTeam = new TeamPointsCounter(yellowInputData);
        TeamPointsCounter blueTeam = new TeamPointsCounter(blueInputData);
        TeamPointsCounter blackTeam = new TeamPointsCounter(blackInputData);
        TeamPointsCounter redTeam = new TeamPointsCounter(redInputData);
        TeamPointsCounter greenTeam = new TeamPointsCounter(greenInputData);
        allTeamsData.add(yellowTeam);//refactor to call in new method
        allTeamsData.add(blueTeam);
        allTeamsData.add(blackTeam);
        allTeamsData.add(redTeam);
        allTeamsData.add(greenTeam);

        intent.putExtra(YELLOW_TEAM_NAME, yellowTeam.name);
        intent.putExtra(YELLOW_TEAM_RESULTS, yellowTeam.teamPointsResult.toString());
        intent.putExtra(BLUE_TEAM_NAME, blueTeam.name);
        intent.putExtra(BLUE_TEAM_RESULTS, blueTeam.teamPointsResult.toString());
        intent.putExtra(BLACK_TEAM_NAME, blackTeam.name);
        intent.putExtra(BLACK_TEAM_RESULTS, blackTeam.teamPointsResult.toString());
        intent.putExtra(RED_TEAM_NAME, redTeam.name);
        intent.putExtra(RED_TEAM_RESULTS, redTeam.teamPointsResult.toString());
        intent.putExtra(GREEN_TEAM_NAME, greenTeam.name);
        intent.putExtra(GREEN_TEAM_RESULTS, greenTeam.teamPointsResult.toString());

        intent.putExtra(MainActivity.TEAMS_OBJECTS, (Serializable) allTeamsData);

        startActivity(intent);
    }

    public void countClick(View view) {
        Integer idButton = view.getId();
        Button button = (Button) findViewById(idButton);
        Integer value = Integer.parseInt(button.getText().toString());
        switch (idButton) {
            case R.id.button17:
            case R.id.button27:
            case R.id.button37:
            case R.id.button47:
            case R.id.button57:
                if (value == 3) {
                    value = 0;
                } else {
                    value++;
                }
                break;
            default:
                if (value == 10) {
                    value = 0;
                } else {
                    value++;
                }
                break;
        }

        button.setText(value.toString());
    }

    private List<String> getInputData(int columnInd) {
        List<String> inputData = new ArrayList<String>();
        EditText editText = (EditText) findViewById(getResources().getIdentifier("teamName" + columnInd, "id", this.getPackageName()));
        if (editText.getText().toString().equals("")) {
            inputData.add("Team" + columnInd);
        } else {
            inputData.add(editText.getText().toString());
        }
        for (int i = 1; i <= 7; i++) {
            Button button = (Button) findViewById(getResources().getIdentifier("button" + columnInd + i, "id", this.getPackageName()));
            inputData.add(button.getText().toString());
        }
        editText = (EditText) findViewById(getResources().getIdentifier("quest" + columnInd, "id", this.getPackageName()));
        if (!editText.getText().toString().equals("")) {
            inputData.add(editText.getText().toString());
        } else {
            inputData.add("0");
        }
        RadioButton radioButton = (RadioButton) findViewById(getResources().getIdentifier("radioButton" + columnInd, "id", this.getPackageName()));
        if (radioButton.isChecked()) {
            inputData.add("true");
        } else {
            inputData.add("false");
        }
        return inputData;
    }

    public void refreshPage(View view) {
        for (int i = 1; i <= 5; i++) {
            EditText editText = (EditText) findViewById(getResources().getIdentifier("teamName" + i, "id", this.getPackageName()));
            editText.setText(getResources().getIdentifier("teamName" + i, "string", this.getPackageName()));
            for (int j = 1; j <= 7; j++) {
                Button button = (Button) findViewById(getResources().getIdentifier("button" + i + j, "id", this.getPackageName()));
                button.setText("0");
            }
            editText = (EditText) findViewById(getResources().getIdentifier("quest" + i, "id", this.getPackageName()));
            editText.setText("0");
            RadioButton radioButton = (RadioButton) findViewById(getResources().getIdentifier("radioButton" + i, "id", this.getPackageName()));
            radioButton.setChecked(false);
        }

    }
}
