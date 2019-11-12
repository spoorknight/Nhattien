package fpoly.com.duan1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import fpoly.com.duan1.R;
import fpoly.com.duan1.base.BaseActivity;

public class M3_1_DangKyInGameActivity extends BaseActivity {

    private ImageView imgvIconM31;
    private LinearLayout lnlM31;
    private LinearLayout lnlM312;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m3_1__dang_ky_in_game);
//Ánh xạ
        imgvIconM31 = (ImageView) findViewById(R.id.imgvIconM31);
        lnlM31 = (LinearLayout) findViewById(R.id.lnlM31);
        lnlM312 = (LinearLayout) findViewById(R.id.lnlM312);

//Animation
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.m31_dangkytengame_in);
        animation1.setInterpolator(new LinearInterpolator());
        lnlM31.startAnimation(animation1);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.m31_dangkytengame_in);
        animation.setInterpolator(new LinearInterpolator());
        lnlM312.startAnimation(animation);


    }

    public void btnQuayLaiM31(View view) {

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.m31_dangkytengame_out);
        animation.setInterpolator(new LinearInterpolator());
        lnlM312.startAnimation(animation);
        lnlM31.startAnimation(animation);
//chuyển màn hình
      startActivityAnimation(this,2000,M3_0_DangKyActivity.class);
    }

    public void btnVaoGameOnclickM31(View view) {
//Animation
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap_out);
        animation.setInterpolator(new LinearInterpolator());
        lnlM312.startAnimation(animation);
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap0_out);
        animation1.setInterpolator(new LinearInterpolator());
        lnlM31.startAnimation(animation1);
//chuyển màn hình
        startActivityAnimation(this,1500,M4_0_HomeActivity.class);

    }
}
