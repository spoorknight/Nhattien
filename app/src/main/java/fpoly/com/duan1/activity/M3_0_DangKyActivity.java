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

public class M3_0_DangKyActivity extends BaseActivity {

    private ImageView imgvIconM30;
    private LinearLayout lnlM30;
    private LinearLayout lnlM31;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m3_0__dang_ky);
//Ánh xạ các thành phần giao diện
        imgvIconM30 = (ImageView) findViewById(R.id.imgvIconM30);
        lnlM30 = (LinearLayout) findViewById(R.id.lnlM30);
        lnlM31 = (LinearLayout) findViewById(R.id.lnlM31);


//Animation
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap);
        animation1.setInterpolator(new LinearInterpolator());
        lnlM30.startAnimation(animation1);

        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap0);
        animation2.setInterpolator(new LinearInterpolator());


        lnlM31.startAnimation(animation2);
    }

    public void btnQuayLaiM30(View view) {

        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap_out);
        animation1.setInterpolator(new LinearInterpolator());
        lnlM30.startAnimation(animation1);

        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap0_out);
        animation2.setInterpolator(new LinearInterpolator());
        lnlM31.startAnimation(animation2);
        M2_0_LoginActivity.in = "fal";
//chuyển màn hình
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                    overridePendingTransition(0, 0);
                    startActivity(new Intent(M3_0_DangKyActivity.this, M2_0_LoginActivity.class));

                    overridePendingTransition(0, 0);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };
        thread.start();
    }

    public void btnTiepTucM30(View view) {
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap_out);
        animation1.setInterpolator(new LinearInterpolator());
        lnlM30.startAnimation(animation1);

        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap0_out);
        animation2.setInterpolator(new LinearInterpolator());
        lnlM31.startAnimation(animation2);
//chuyển màn hình
        startActivityAnimation(this,1000,M3_1_DangKyInGameActivity.class);
    }
}
