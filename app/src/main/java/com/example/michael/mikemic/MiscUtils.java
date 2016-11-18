package com.example.michael.mikemic;

import android.view.View;
import android.widget.TextView;

/**
 * Created by Michael on 11/16/2016.
 */

// TODO - What is Java's equivalent of a static class?
    // I'm using final, with a private ctor
public final class MiscUtils
{
    private MiscUtils() // Exception?
    {}

    public static void setTextViewContents(View parentView, int viewId, String textValue)
    {
        TextView textView = (TextView) parentView.findViewById(viewId);
        textView.setText(textValue);
    }
}
