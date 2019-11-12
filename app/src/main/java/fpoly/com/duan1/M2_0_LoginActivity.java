package fpoly.com.duan1;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class M2_0_LoginActivity extends AppCompatActivity {

    private ImageView imgvIconM20;
    private LinearLayout lnlM20;
    private LinearLayout lnlM201;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m2_0__login);

        imgvIconM20 = (ImageView) findViewById(R.id.imgvIconM20);
        lnlM20 = (LinearLayout) findViewById(R.id.lnlM20);
        lnlM201 = (LinearLayout) findViewById(R.id.lnlM201);

//Xét các hiệu ứng animation khi vào màn hình
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.m20_icon);
        animation.setInterpolator(new LinearInterpolator());
        imgvIconM20.startAnimation(animation);


        Animation animation1= AnimationUtils.loadAnimation(this,R.anim.m20_dangnhap);
        animation1.setInterpolator(new LinearInterpolator());
        lnlM20.startAnimation(animation1);

        Animation animation2= AnimationUtils.loadAnimation(this,R.anim.m20_dangnhap0);
        animation2.setInterpolator(new LinearInterpolator());
        lnlM201.startAnimation(animation2);

    }
}
