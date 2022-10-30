package com.example.mychess;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameSelection extends AppCompatActivity {
    public static final int STARTUP_DELAY = 300;
    public static final int ANIM_ITEM_DURATION = 1250;
    public static final int ITEM_DELAY = 800;
    public final boolean animationStarted = false;
    String color=null;
    public ViewGroup container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_selection);
        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            color = null;
        } else {
            color= extras.getString("color");
        }

        Window window;
        window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.colorBoardDark));
        changeColor();
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Closing App...")
                .setMessage("Are you sure you want to CLOSE the app?")

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton("Yes", (dialog, which) -> finishAndRemoveTask())

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
        ImageView logo= findViewById(R.id.logo2);
        TextView name= findViewById(R.id.nameC2);
        Button buttonS= findViewById(R.id.playFriendsButton);
        Button buttonT= findViewById(R.id.tutorialButton);
        container = findViewById(R.id.colorChoice);

        ViewCompat.animate(logo)
                .translationY(-440)
                .setStartDelay(STARTUP_DELAY)
                .setDuration(ANIM_ITEM_DURATION)
                .setInterpolator(new DecelerateInterpolator(0.8f))
                .start();
        ViewCompat.animate(name)
                .translationY(-440)
                .setStartDelay(STARTUP_DELAY+90)
                .setDuration(ANIM_ITEM_DURATION)
                .setInterpolator(new DecelerateInterpolator(0.8f))
                .start();
        ViewCompat.animate(buttonS)
                .scaleY(1).scaleX(1)
                .setStartDelay(STARTUP_DELAY+(STARTUP_DELAY/2))
                .setDuration(ITEM_DELAY)
                .setInterpolator(new DecelerateInterpolator(0.8f))
                .start();
        ViewCompat.animate(buttonT)
                .scaleY(1).scaleX(1)
                .setStartDelay(STARTUP_DELAY*2)
                .setDuration(ITEM_DELAY)
                .setInterpolator(new DecelerateInterpolator(0.8f))
                .start();
        int delay=200;
        for(int i=0; i<container.getChildCount();i++){
            ViewCompat.animate(container.getChildAt(i))
                    .scaleY(1).scaleX(1)
                    .setStartDelay(STARTUP_DELAY+delay)
                    .setDuration(ITEM_DELAY)
                    .setInterpolator(new DecelerateInterpolator(0.8f))
                    .start();
            delay+=150;
        }

        container.getChildAt(0).setOnClickListener(v -> {
            color="water";
            Intent i = new Intent(GameSelection.this , StartPage.class);
            i.putExtra("color", color);
            startActivity(i);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            finish();
        });
        container.getChildAt(1).setOnClickListener(v -> {
            color="classic";
            Intent i = new Intent(GameSelection.this , StartPage.class);
            i.putExtra("color", color);
            startActivity(i);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            finish();
        });
        container.getChildAt(2).setOnClickListener(v -> {
            color="red";
            Intent i = new Intent(GameSelection.this , StartPage.class);
            i.putExtra("color", color);
            startActivity(i);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            finish();
        });

        logo.setOnClickListener(v -> {
            if(color!=null){
                color=null;
                Intent i = new Intent(GameSelection.this , StartPage.class);
                i.putExtra("color", color);
                startActivity(i);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                finish();
            }
        });

        buttonS.setOnClickListener(v -> {
            Intent i = new Intent(GameSelection.this , MainActivity.class);
            i.putExtra("color", color);
            startActivity(i);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            finish();
        });

        buttonT.setOnClickListener(v -> {
            Intent i = new Intent(GameSelection.this , Tutorial.class);
            i.putExtra("color", color);
            startActivity(i);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            finish();
        });
    }
    public void changeColor(){
        if (color != null) {
            switch (color) {
                case "red": {
                    Window window = this.getWindow();
                    window.setStatusBarColor(this.getResources().getColor(R.color.statusBarRed));
                    findViewById(R.id.activity_game_selection).setBackgroundResource(R.color.backGroundRed);
                    break;
                }
                case "water": {
                    Window window = this.getWindow();
                    window.setStatusBarColor(this.getResources().getColor(R.color.statusBarWater));
                    findViewById(R.id.activity_game_selection).setBackgroundResource(R.color.backGroundWater);
                    break;
                }
                case "classic": {
                    Window window = this.getWindow();
                    window.setStatusBarColor(this.getResources().getColor(R.color.statusBarClassic));
                    findViewById(R.id.activity_game_selection).setBackgroundResource(R.color.backGroundClassic);
                    break;
                }
            }
        }
    }
}