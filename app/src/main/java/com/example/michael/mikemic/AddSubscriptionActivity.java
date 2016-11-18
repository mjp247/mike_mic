package com.example.michael.mikemic;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddSubscriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subscription);
    }

    // TODO - Change name so it does not collide with fcn in main activity
    public void onAddSubscriptionButtonPress(View view) {
        // get feed url from text box
        EditText editText = (EditText) findViewById(R.id.feed_url_text);
        String feedUrl = editText.getText().toString();

        // verify that it is valid
        if(!isValidFeedUrl(feedUrl))
        {
            // TODO - show error popup
            return;
        }

        // add to feed list
        MainActivity.instance.myFeeds.Add(feedUrl);

        // TODO - error handling - I think the best behavior here is to stay in this view
        // show error message on failure

        //ListActivity

        // close this activity (if successful)
        this.finish();
    }

    // TODO - Implement, either here or in a utils class
    private boolean isValidFeedUrl(String url)
    {
        return true;
    }
}
