package fpoly.com.duan1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class M1_0_HelloActivity extends AppCompatActivity {

    private ImageView imgvIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m10_activity);

        imgvIcon = (ImageView) findViewById(R.id.imgvIcon);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.icon_xoay);
        animation.setInterpolator(new LinearInterpolator());
        imgvIcon.startAnimation(animation);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    startActivity(new Intent(M1_0_HelloActivity.this, M2_0_LoginActivity.class));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };
        thread.start();
    }
}
