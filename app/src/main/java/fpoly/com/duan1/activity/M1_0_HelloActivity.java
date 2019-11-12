package fpoly.com.duan1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import fpoly.com.duan1.R;
import fpoly.com.duan1.base.BaseActivity;

public class M1_0_HelloActivity extends BaseActivity {

    private ImageView imgvIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m10_activity);

        imgvIcon = (ImageView) findViewById(R.id.imgvIcon);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.icon_xoay);
        animation.setInterpolator(new LinearInterpolator());
        imgvIcon.startAnimation(animation);

         startActivityAnimation(this,3000,M2_0_LoginActivity.class);

    }
}
