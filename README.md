# Discount-Calculator

As part of a tutorial I created a tip calculator. I decided to take what I learnt from creating the tip calculator and add more to it, such as: Changing the colour of the background, font &amp; buttons. Adding in a seekbar for the percentage. Adding a border around some of the layouts. Hide the on screen keyboard when the buttons are pressed. Removed the toolbar at the top of the screen so the app takes up the full screen.

<div>
  <img src="/Screenshot 1.png" height="300"/> &nbsp
  <img src="/Screenshot 2.png" height="300"/> &nbsp
</div>


<b><u>Hide Title Bar and Enable Full Screen</b></u>
<br>
```java
super.onCreate(savedInstanceState);
requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
getSupportActionBar().hide(); // hide the title bar
this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
setContentView(R.layout.activity_main);
```

<b><u>Hide Virtual Keyboard</b></u>
<br>
```java
InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
```

<b><u>Seek Bar</b></u>
<br>
```java
        percentSeekBar.setProgress(0);
        percentSeekBar.setMax(100);

        percentSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentTextView.setText(String.valueOf(progress));
                //percentTextView.setSelection(percentTextView.getText().length());
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            //    Toast.makeText(MainActivity.this, "Seek bar progress is :" + progressChangedValue,
            //            Toast.LENGTH_SHORT).show();
            }
        });
```
