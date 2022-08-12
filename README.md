# Scheduler_Android

Work schedule Android app

##### Helpful links and Log:

1. View-getView(): Explanations
   by [English](https://stackoverflow.com/questions/10120119/how-does-the-getview-method-work-when-creating-your-own-custom-adapter)
   and [Chinese](https://blog.csdn.net/l799069596/article/details/47301711).
2. [mipmap and drawable folders differences](https://blog.csdn.net/wq6ylg08/article/details/114543624)
3. [Java Bean](https://stackoverflow.com/questions/2489642/place-the-business-logic-in-java-beans) /
   [Wikipedia](https://en.m.wikipedia.org/wiki/JavaBeans)
4. Debug Toolbar error: When I call initUI() function and added toolbar then setSupportActionBar(toolbar), it shows
   "Caused by: java.lang.IllegalStateException: This Activity already has an action bar supplied by the window decor. 
   Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.", fixed by 
   [this](https://www.examtray.com/android/how-solve-android-exception-activity-action-bar-supplied-window-decor) and
   [video](https://www.youtube.com/watch?v=YJR8njVHRA4), I added "<item name="windowActionBar">false</item>
   <item name="windowNoTitle">true</item>" into style/theme.xml then changed "<activity> android:name" to:
   " *android:name="com.example.scheduler.presentation.MainActivity" android:label="Activity Title" android:theme="@style/Theme.Scheduler.NoActionBar"* "
5. [GridView](https://www.runoob.com/w3cnote/android-tutorial-gridview.html) 
   with outpatient_pattern.xml a single unit pattern and then combined all the units into activity_schedule.xml' s gridview.
   