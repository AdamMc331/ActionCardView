package com.adammcneilly;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * CardView descendent which displays a title, description, and action buttons.
 *
 * Created by adam.mcneilly on 8/9/16.
 */
public class ActionCardView extends CardView {

    //region Properties
    /**
     * The Context this view is being displayed in.
     */
    private Context context;
    //endregion

    //region UI Elements
    /**
     * Title for the action on the card view.
     */
    private TextView title;

    /**
     * The description of the action(s) on the card view.
     */
    private TextView description;

    /**
     * The holder for the action buttons.
     */
    private LinearLayout buttonBar;

    /**
     * Divider in the card view.
     */
    private View divider;
    //endregion

    //region Constructors
    public ActionCardView(Context context) {
        this(context, null);
    }

    public ActionCardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ActionCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.context = context;

        init();
        initStyle(attrs, defStyleAttr);
    }
    //endregion

    //region Initializers
    /**
     * Initializes the view using the actioncardview layout and retrieves the relevant UI items.
     */
    private void init() {
        LayoutInflater.from(context).inflate(R.layout.actioncardview, this, true);

        this.title = (TextView) findViewById(R.id.card_title);
        this.description = (TextView) findViewById(R.id.card_description);
        this.buttonBar = (LinearLayout) findViewById(R.id.card_button_bar);
        this.divider = findViewById(R.id.card_divider);
    }

    /**
     * Initializes the custom style attributes for the view.
     */
    private void initStyle(AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ActionCardView, defStyleAttr, 0);

        if(typedArray != null) {
            int defaultColor = ContextCompat.getColor(context, android.R.color.black);
            int defaultBackground = ContextCompat.getColor(context, android.R.color.white);

            if(typedArray.hasValue(R.styleable.ActionCardView_cardTitle)) {
                setTitle(typedArray.getString(R.styleable.ActionCardView_cardTitle));
            }

            if(typedArray.hasValue(R.styleable.ActionCardView_cardTitleTextColor)) {
                setTitleTextColor(typedArray.getColor(R.styleable.ActionCardView_cardTitleTextColor, defaultColor));
            }

            if(typedArray.hasValue(R.styleable.ActionCardView_cardTitleBackgroundColor)) {
                setTitleBackgroundColor(typedArray.getColor(R.styleable.ActionCardView_cardTitleBackgroundColor, defaultBackground));
            }

            if(typedArray.hasValue(R.styleable.ActionCardView_cardDividerColor)) {
                setDividerColor(typedArray.getColor(R.styleable.ActionCardView_cardDividerColor, defaultColor));
            }

            if(typedArray.hasValue(R.styleable.ActionCardView_cardDividerHeight)) {
                setDividerHeight(typedArray.getDimensionPixelSize(R.styleable.ActionCardView_cardDividerHeight, 1));
            }

            if(typedArray.hasValue(R.styleable.ActionCardView_cardDescription)) {
                setDescription(typedArray.getString(R.styleable.ActionCardView_cardDescription));
            }

            if(typedArray.hasValue(R.styleable.ActionCardView_cardDescriptionTextColor)) {
                setDescriptionTextColor(typedArray.getColor(R.styleable.ActionCardView_cardDescriptionTextColor, defaultColor));
            }

            if(typedArray.hasValue(R.styleable.ActionCardView_cardDescriptionBackgroundColor)) {
                setDescriptionBackgroundColor(typedArray.getColor(R.styleable.ActionCardView_cardDescriptionBackgroundColor, defaultBackground));
            }

            if(typedArray.hasValue(R.styleable.ActionCardView_buttonBarBackgroundColor)) {
                setButtonBarBackgroundColor(typedArray.getColor(R.styleable.ActionCardView_buttonBarBackgroundColor, defaultBackground));
            }

            typedArray.recycle();
        }
    }
    //endregion

    //region View Methods
    /**
     * Handles adding a child view.
     *
     * Currently, we only allow adding the card_root, and action buttons.
     */
    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        // If we are adding the card root, do default.
        // Otherwise, if it is a button, add it.
        if(child.getId() == R.id.card_root) {
            super.addView(child, index, params);
        } else if(child instanceof ActionButton) {
            addActionButton((ActionButton) child);
        }
    }
    //endregion

    //region Mutators
    /**
     * Sets the title text of the card.
     */
    public void setTitle(CharSequence charSequence) {
        this.title.setText(charSequence);
    }

    /**
     * Sets the text color of the title.
     */
    public void setTitleTextColor(int color) {
        this.title.setTextColor(color);
    }

    /**
     * Sets the background color of the title.
     */
    public void setTitleBackgroundColor(int color) {
        this.title.setBackgroundColor(color);
    }

    /**
     * Sets the divider color of the card.
     */
    public void setDividerColor(int color) {
        this.divider.setBackgroundColor(color);
    }

    /**
     * Sets the divider height.
     * @param height The height (in pixels) to set the divider.
     */
    public void setDividerHeight(int height) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                height
        );

        this.divider.setLayoutParams(layoutParams);
    }

    /**
     * Sets the description text of the card.
     */
    public void setDescription(CharSequence charSequence) {
        this.description.setText(charSequence);
    }

    /**
     * Sets the text color of the description.
     */
    public void setDescriptionTextColor(int color) {
        this.description.setTextColor(color);
    }

    /**
     * Sets the background color of the description.
     */
    public void setDescriptionBackgroundColor(int color) {
        this.description.setBackgroundColor(color);
    }

    /**
     * Sets the background color of the button bar.
     */
    public void setButtonBarBackgroundColor(int color) {
        this.buttonBar.setBackgroundColor(color);
    }
    //endregion

    //region Accessors
    /**
     * Retrieves the title text of the card.
     */
    public CharSequence getTitle() {
        return title.getText();
    }

    /**
     * Retrieves the description text of the card.
     */
    public CharSequence getDescription() {
        return description.getText();
    }

    /**
     * Retrieves the title text view.
     */
    public TextView getTitleTextView() {
        return title;
    }

    /**
     * Retrieves the description text view.
     */
    public TextView getDescriptionTextView() {
        return description;
    }

    /**
     * Retrieves the divider view.
     */
    public View getDivider() {
        return divider;
    }

    /**
     * Retrieves the button bar layout.
     */
    public LinearLayout getButtonBarLayout() {
        return buttonBar;
    }
    //endregion

    //region Helper Methods
    /**
     * Adds an ActionButton to the button bar.
     */
    public void addActionButton(ActionButton actionButton) {
        buttonBar.addView(actionButton);
    }

    /**
     * Adds an OnClickListener to a specified action button.
     * @param id The resource identifier of the button to apply the click listener to.
     */
    public void addActionClickListener(int id, OnClickListener clickListener) {
        // If we can't find the id, just do nothing. No point breaking the app.
        ActionButton button = (ActionButton) buttonBar.findViewById(id);
        if(button != null) {
            button.setOnClickListener(clickListener);
        }
    }
    //endregion
}

