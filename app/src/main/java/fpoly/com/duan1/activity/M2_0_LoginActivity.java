package fpoly.com.duan1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import fpoly.com.duan1.R;
import fpoly.com.duan1.base.BaseActivity;

public class M2_0_LoginActivity extends BaseActivity {
    public static String in = "true";
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
        if (in.equals("true")) {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.m20_icon);
            animation.setInterpolator(new LinearInterpolator());
            imgvIconM20.startAnimation(animation);

        }


        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap);
        animation1.setInterpolator(new LinearInterpolator());
        lnlM20.startAnimation(animation1);

        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap0);
        animation2.setInterpolator(new LinearInterpolator());
        lnlM201.startAnimation(animation2);
    }

    public void btnDangKyClick(View view) {

        outActivity();
//chuyển màn hình
        startActivityAnimation(this, 1000, M3_0_DangKyActivity.class);
    }

    public void btnDangNhapM20(View view) {

//Animation
        outActivity();
//chuyển màn hình
        startActivityAnimation(this, 1000, M4_0_HomeActivity.class);

    }

    public void outActivity() {
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap_out);
        animation1.setInterpolator(new LinearInterpolator());
        lnlM20.startAnimation(animation1);

        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap0_out);
        animation2.setInterpolator(new LinearInterpolator());
        lnlM201.startAnimation(animation2);
    }
}
