package com.example.michael.mikemic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    // TODO - I want to import the rss library in the correct way.  Is there a way to do that from git?
    // https://android-arsenal.com/details/1/2490
    // https://github.com/einmalfel/Earl

    // TODO - When I figure out how to get an activity's parent, I should remove this
    public static MainActivity instance;

    public PodcastFeedCollection myFeeds;

    // Current playlist?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // TODO - we will want to load from a file if it exists
        myFeeds = new PodcastFeedCollection();

        instance = this;

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    //Intent intent = new Intent(this, ActivityClassName.class);
    // Collect and put extras as necessary
    //startActivity(intent);

    // TODO - View Subscriptions Activity
    /** Called when the user clicks the View Subscriptions button */
    public void onViewSubscriptionsButtonPress(View view) {
        Intent intent = new Intent(this, ViewSubscriptionsSimpleActivity.class);
        startActivity(intent);
    }

    // TODO - Add Subscription Activity
    /** Called when the user clicks the Add Subscription button */
    public void onAddSubscriptionButtonPress(View view) {
        Intent intent = new Intent(this, AddSubscriptionActivity.class);
        startActivity(intent);
    }

    // TODO - Now Playing Activity
    /** Called when the user clicks the Now Playing button */
    public void onNowPlayingButtonPress(View view) {
        Intent intent = new Intent(this, NowPlayingActivity.class);
        startActivity(intent);
    }
}
