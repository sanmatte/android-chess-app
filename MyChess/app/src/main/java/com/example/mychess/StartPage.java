package com.example.mychess;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class StartPage extends AppCompatActivity {
    //public static final int STARTUP_DELAY = 0;
    public static final int ANIM_ITEM_DURATION = 1200;
    //public static final int ITEM_DELAY = 300;

    public final boolean animationStarted = false;
    public String color=null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.Theme_MyChess);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
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
                    findViewById(R.id.activity_start_page).setBackgroundResource(R.color.backGroundRed);
                    break;
                }
                case "water": {
                    Window window = this.getWindow();
                    window.setStatusBarColor(this.getResources().getColor(R.color.statusBarWater));
                    findViewById(R.id.activity_start_page).setBackgroundResource(R.color.backGroundWater);
                    break;
                }
                case "classic": {
                    Window window = this.getWindow();
                    window.setStatusBarColor(this.getResources().getColor(R.color.statusBarClassic));
                    findViewById(R.id.activity_start_page).setBackgroundResource(R.color.backGroundClassic);
                    break;
                }
            }
        }
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
        ImageView logoImageView = findViewById(R.id.logo);
        TextView name= findViewById(R.id.nameC);

        ViewCompat.animate(logoImageView)
                .translationY(+350)
                .setStartDelay(0)
                .setDuration(ANIM_ITEM_DURATION)
                .setInterpolator(new DecelerateInterpolator(0.8f))
                .start();
        ViewCompat.animate(name)
                .translationY(-300)
                .setStartDelay(0)
                .setDuration(ANIM_ITEM_DURATION)
                .setInterpolator(new DecelerateInterpolator(0.8f))
                .start();
        new Handler().postDelayed(() -> {
            Intent i = new Intent(StartPage.this, GameSelection.class);
            i.putExtra("color" , color);
            startActivity(i);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            finish();

        }, 1300);
    }
}