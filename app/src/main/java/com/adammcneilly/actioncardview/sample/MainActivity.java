package com.adammcneilly.actioncardview.sample;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.adammcneilly.ActionButton;
import com.adammcneilly.ActionCardView;

public class MainActivity extends AppCompatActivity {
    private ActionCardView actionCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get view
        actionCardView = (ActionCardView) findViewById(R.id.action_card);

        addActionToExistingButton();
        addNewActionButton();
    }

    /**
     * Demonstrates how to add a click listener to a button that was added in the XML.
     */
    private void addActionToExistingButton() {
        // Apply click listener to button one. Shows how to do this for a button that was created
        // using XML.
        actionCardView.addActionClickListener(R.id.button_one, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Clicked button one!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Demonstrates how to add a brand new action button.
     */
    private void addNewActionButton() {
        // Never set text color, should default to black.
        ActionButton button = new ActionButton.Builder(this)
                .setText("Two")
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(), "Clicked button two!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setTextColor(ContextCompat.getColor(this, R.color.colorAccent))
                .create();

        // Add a button that was created programmatically.
        actionCardView.addActionButton(button);
    }
}
