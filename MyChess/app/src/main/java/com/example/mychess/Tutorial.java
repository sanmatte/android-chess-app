package com.example.mychess;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;

public class Tutorial extends AppCompatActivity {
    public static final int STARTUP_DELAY = 300;
    public static final int ANIM_ITEM_DURATION = 1250;
    public static final int ITEM_DELAY = 800;
    public final boolean animationStarted = false;
    public String color=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            color = null;
        } else {
            color= extras.getString("color");
        }
        if (color != null) {
            switch (color) {
                case "red": {
                    Window window = this.getWindow();
                    window.setStatusBarColor(this.getResources().getColor(R.color.statusBarRed));
                    findViewById(R.id.activity_tutorial).setBackgroundResource(R.color.backGroundRed);
                    break;
                }
                case "water": {
                    Window window = this.getWindow();
                    window.setStatusBarColor(this.getResources().getColor(R.color.statusBarWater));
                    findViewById(R.id.activity_tutorial).setBackgroundResource(R.color.backGroundWater);
                    break;
                }
                case "classic": {
                    Window window = this.getWindow();
                    window.setStatusBarColor(this.getResources().getColor(R.color.statusBarClassic));
                    findViewById(R.id.activity_tutorial).setBackgroundResource(R.color.backGroundClassic);
                    break;
                }
            }
        }
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Ending Tutorial...")
                .setMessage("Are you sure you want to END the tutorial?")

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton("Yes", (dialog, which) -> {
                    Intent i = new Intent(Tutorial.this , GameSelection.class);
                    i.putExtra("color" , color);
                    startActivity(i);
                    overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                    finish();
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton("No", null)
                .show();
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        if (!hasFocus || animationStarted) {
            return;
        }

        animate();

        super.onWindowFocusChanged(hasFocus);
    }
    private void animate() {
        ViewGroup welcome = findViewById(R.id.welcomeLayout);
        ViewGroup second = findViewById(R.id.secondLayout);
        ViewGroup third = findViewById(R.id.thirdLayout);
        ViewGroup last = findViewById(R.id.lastLayout);
        ViewCompat.animate(welcome)
                .scaleY(1).scaleX(1)
                .setStartDelay(0)
                .setDuration(ITEM_DELAY)
                .setInterpolator(new DecelerateInterpolator(0.8f))
                .start();
        ViewCompat.animate(second)
                .scaleY(1).scaleX(1)
                .setStartDelay(STARTUP_DELAY)
                .setDuration(ITEM_DELAY)
                .setInterpolator(new DecelerateInterpolator(0.8f))
                .start();
        ViewCompat.animate(third)
                .scaleY(1).scaleX(1)
                .setStartDelay(STARTUP_DELAY+(STARTUP_DELAY/2))
                .setDuration(ANIM_ITEM_DURATION)
                .setInterpolator(new DecelerateInterpolator(0.8f))
                .start();
        ViewCompat.animate(last)
                .scaleY(1).scaleX(1)
                .setStartDelay(STARTUP_DELAY*2)
                .setDuration(ITEM_DELAY)
                .setInterpolator(new DecelerateInterpolator(0.8f))
                .start();
    }
}
