package pointscalculator.ttr_pc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public final static String TEAMS_OBJECTS = "app.java.pointsCalculator.ttr_pc.MainActivity.TEAMS_OBJECTS";
    public static final String APP_PREFERENCES = "mysettings";
    private SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSettings = PreferenceManager.getDefaultSharedPreferences(this);//todo delete this?

//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

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
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.information) {
            Intent intent = new Intent(this, Information.class);
            startActivity(intent);
        } else if (id == R.id.rate) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://search?q=foo"));
            PackageManager pm = getPackageManager();
            List<ResolveInfo> list = pm.queryIntentActivities(intent, 0);
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("market://details?id=" + getPackageName()));
            startActivity(i);
        }
//        else (id == R.id.nav_share) {
//            // Handle the share action
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Method to click on CalculatePoints button
     */
    public void calculatePoints(View view) {
        Intent intent = new Intent(this, PointsResults.class);

        List<String> yellowInputData = getInputData(1);
        List<String> blueInputData = getInputData(2);
        List<String> blackInputData = getInputData(3);
        List<String> redInputData = getInputData(4);
        List<String> greenInputData = getInputData(5);
        List<TeamPointsCounter> allTeamsData = new ArrayList<TeamPointsCounter>();

        allTeamsData.add(new TeamPointsCounter(yellowInputData));
        allTeamsData.add(new TeamPointsCounter(blueInputData));
        allTeamsData.add(new TeamPointsCounter(blackInputData));
        allTeamsData.add(new TeamPointsCounter(redInputData));
        allTeamsData.add(new TeamPointsCounter(greenInputData));

        allTeamsData = TeamPointsCounter.sortByPoints(allTeamsData);

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
        Integer textColor = editText.getCurrentTextColor();
        if (editText.getText().toString().equals("")) {
            String renameTeam = getResources().getString(getResources().getIdentifier("teamName" + columnInd, "string", this.getPackageName()));
            inputData.add(renameTeam);
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
        inputData.add(textColor.toString());
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
            editText.setText("");
            RadioButton radioButton = (RadioButton) findViewById(getResources().getIdentifier("radioButton" + i, "id", this.getPackageName()));
            radioButton.setChecked(false);
        }

        Button button = (Button) findViewById(R.id.refreshPage);
        AnimationSet animSet = new AnimationSet(true);
        animSet.setInterpolator(new DecelerateInterpolator());
        animSet.setFillAfter(true);
        animSet.setFillEnabled(true);
        final RotateAnimation animRotate = new RotateAnimation(0.0f, -180.0f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animRotate.setDuration(1500);
        animRotate.setFillAfter(true);
        animSet.addAnimation(animRotate);
        button.startAnimation(animSet);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            /**
             * It gets into the above IF-BLOCK if anywhere the screen is touched.
             */

            View v = getCurrentFocus();
            if (v instanceof EditText) {


                /**
                 * Now, it gets into the above IF-BLOCK if an EditText is already in focus, and you tap somewhere else
                 * to take the focus away from that particular EditText. It could have 2 cases after tapping:
                 * 1. No EditText has focus
                 * 2. Focus is just shifted to the other EditText
                 */

                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }
}
