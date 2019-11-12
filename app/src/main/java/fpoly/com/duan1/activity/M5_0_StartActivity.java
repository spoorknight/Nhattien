package fpoly.com.duan1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import fpoly.com.duan1.R;

public class M5_0_StartActivity extends AppCompatActivity {

    private ImageButton imgDungChoi;
    private ImageButton img50;
    private ImageButton imgCall;
    private ImageButton imgHoiNhom;
    private TextView tvCau;
    private TextView tvClock;
    private TextView tvTienThuong;
    private LinearLayout lnlQuesstion;
    private LinearLayout lnlDapAnA;
    private LinearLayout lnlDapAnB;
    private LinearLayout lnlDapAnC;
    private LinearLayout lnlDapAnD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m5_0__start);

//Ánh xạ thành phần
        imgDungChoi = (ImageButton) findViewById(R.id.imgDungChoi);
        img50 = (ImageButton) findViewById(R.id.img50);
        imgCall = (ImageButton) findViewById(R.id.imgCall);
        imgHoiNhom = (ImageButton) findViewById(R.id.imgHoiNhom);
        tvCau = (TextView) findViewById(R.id.tvCau);
        tvClock = (TextView) findViewById(R.id.tvClock);
        tvTienThuong = (TextView) findViewById(R.id.tvTienThuong);
        lnlQuesstion = (LinearLayout) findViewById(R.id.lnlQuesstion);
        lnlDapAnA = (LinearLayout) findViewById(R.id.lnlDapAnA);
        lnlDapAnB = (LinearLayout) findViewById(R.id.lnlDapAnB);
        lnlDapAnC = (LinearLayout) findViewById(R.id.lnlDapAnC);
        lnlDapAnD = (LinearLayout) findViewById(R.id.lnlDapAnD);

//Animation
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.m50_clock);
        animation1.setInterpolator(new LinearInterpolator());
        tvClock.startAnimation(animation1);


        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.m50_left);
        animation2.setInterpolator(new LinearInterpolator());
        tvCau.startAnimation(animation2);

        Animation animation3 = AnimationUtils.loadAnimation(this, R.anim.m50_right);
        animation3.setInterpolator(new LinearInterpolator());
        tvTienThuong.startAnimation(animation3);


        Animation animation = AnimationUtils.loadAnimation(this, R.anim.m50_alpha);
        animation.setInterpolator(new LinearInterpolator());
        lnlDapAnA.startAnimation(animation);
        lnlDapAnB.startAnimation(animation);
        lnlDapAnC.startAnimation(animation);
        lnlDapAnD.startAnimation(animation);
        lnlQuesstion.startAnimation(animation);


        Animation animation4 = AnimationUtils.loadAnimation(this, R.anim.m50_start_phong);
        animation4.setInterpolator(new LinearInterpolator());
        img50.startAnimation(animation4);
        imgCall.startAnimation(animation4);
        imgDungChoi.startAnimation(animation4);
        imgHoiNhom.startAnimation(animation4);

    }
}
