共享动画实现
===

在共享动画的两个view中添加一致的`android:transitionName`

```
	<string name="transition_name">textview_transition</string>

	<!-- activity_one -->
	<TextView
        android:id="@+id/hello_world_textview"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:padding="8dp"
        android:text="Hello World!"
        android:transitionName="@string/transition_name"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
		
	<!-- activity_two -->
	<TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        android:textSize="48sp"
        android:transitionName="@string/transition_name"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```

为Activity Theme添加`android:windowContentTransitions`属性
```
    <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>

        <item name="android:windowContentTransitions">true</item>
    </style>
```

代码跳转
```
	String transition_name = this.getResources().getString(R.string.transition_name);
	ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, 
		hellowordTextView, transition_name);

	Intent intent = new Intent();
	intent.setClass(this, SecondActivity.class);
	ActivityCompat.startActivity(this, intent, options.toBundle());
```