package fpoly.com.duan1;

import androidx.appcompat.app.AppCompatActivity;

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
        setContentView(R.layout.activity_main);

        imgvIcon = (ImageView) findViewById(R.id.imgvIcon);

        Animation animation= AnimationUtils.loadAnimation(this,R.anim.icon_xoay);
        animation.setInterpolator(new LinearInterpolator());
        imgvIcon.startAnimation(animation);

    }
}
