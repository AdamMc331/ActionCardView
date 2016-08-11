package com.adammcneilly;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Action button to be displayed on an action card.
 *
 * Created by adam.mcneilly on 8/10/16.
 */
public class ActionButton extends Button {
    //region Constructors
    public ActionButton(Context context) {
        this(context, null);
    }

    public ActionButton(Context context, AttributeSet attrs) {
        super(context, attrs, android.R.attr.borderlessButtonStyle);
    }
    //endregion

    /**
     * Builder class to create an ActionButton one piece at a time. Similar to the alert dialog.
     */
    public static class Builder {
        /**
         * The Context the button will be displayed in.
         */
        private Context context;

        /**
         * The text of the button.
         */
        private CharSequence text;

        /**
         * Click listener that is called when the action button is tapped.
         */
        private OnClickListener onClickListener;

        /**
         * The TextColor of this action button.
         */
        private int textColor;

        /**
         * Default constructor.
         */
        public Builder(Context context) {
            this.context = context;
        }

        /**
         * Sets the text of the button and returns a new builder to keep working with, or create.
         */
        public Builder setText(CharSequence text) {
            this.text = text;
            return this;
        }

        /**
         * Sets the click listener of the button and returns a new builder to keep working with, or create.
         */
        public Builder setOnClickListener(OnClickListener onClickListener) {
            this.onClickListener = onClickListener;
            return this;
        }

        /**
         * Sets the text color of the button and returns a new builder to keep working with, or create.
         */
        public Builder setTextColor(int color) {
            this.textColor = color;
            return this;
        }

        /** A bug was discovered that if textColor was never set it wouldn't appear,
         *  so default to black.
         */
        private int getTextColor() {
            return (textColor == 0)
                    ? ContextCompat.getColor(context, android.R.color.black)
                    : textColor;
        }

        /**
         * Creates the ActionButton from the builder's input and returns it.
         */
        public ActionButton create() {
            ActionButton actionButton = new ActionButton(context);
            actionButton.setText(text);
            actionButton.setOnClickListener(onClickListener);
            actionButton.setTextColor(getTextColor());

            return actionButton;
        }
    }
}
