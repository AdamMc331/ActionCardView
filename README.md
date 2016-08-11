ActionCardView Library
=============

This library is for a specialized CardView designed to highlight a specific action that can be completed.

Usage
-----

To have access to the library, add the dependency to your build.gradle:

```java
compile 'com.adammcneilly:actioncardview:1.0.0'
```

At this time the library is not yet available in JCenter, so you must include a reference to my maven repo:
```java
repositories {
    maven {
        url  "http://dl.bintray.com/androidessence/maven"
    }
}
```

Sample
------

Below is a screenshot of what a sample ActionCardView may look like:

<img src='http://i.imgur.com/hpxpdr9.jpg' width='400' height='640' />


ActionButton
--------------

At the button of the ActionCardView is a button bar the displays the action buttons. These buttons are right justified, but will be displayed left to right in the order that they are entered. In other words, the first button you create will be the left most button on the bar.

There are two ways to implement the action button. First is via XML:

```xml
<com.adammcneilly.ActionCardView
    ...>

    <com.adammcneilly.ActionButton
        android:id="@+id/button_one"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="One"
        android:textColor="@color/colorAccent"/>

<com.adammcneilly.ActionCardView/>
```

Or programmatically using my ActionButton.Builder class:

```java
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
````

# Adding a click listener

You may have noticed that when you create a button programmatically you can easily add a click listener. To do this for one that was put in via xml, call the `addActionClickListener` method:

```java
actionCardView.addActionClickListener(R.id.button_one, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Clicked button one!", Toast.LENGTH_SHORT).show();
            }
        });
```

Just so you're aware - if an invalid resource identifier is passed or the resource is not found, the library will simply ignore it to avoid your app crashing.

ActionCardView
--------------

The bulk of this project boils down to the ActionCardView itself, which can be laid out in the XML like this:

```xml
<com.adammcneilly.ActionCardView
        android:id="@+id/action_card"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="8dp"
        app:cardTitle="Test Title"
        app:cardDescription="Test Description">

        <com.adammcneilly.ActionButton
            android:id="@+id/button_one"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="One"
            android:textColor="@color/colorAccent"/>

    </com.adammcneilly.ActionCardView>
```

Note above that there are custom attributes for the card title and description. The following attributes can be used to modify parts of the ActionCardView:

 * cardTitle
 * cardTitleTextColor
 * cardDividerColor
 * cardDescription
 * CardDescriptionTextColor

Credits & Contact
-----------------

This library was created by [Adam McNeilly](http://adammcneilly.com).

License
-------

The ActionCardView library is available under the [MIT License](https://opensource.org/licenses/MIT). You are free to modify and enhance it in any way. If you submit a pull request, please add your name into the credits section! :)
