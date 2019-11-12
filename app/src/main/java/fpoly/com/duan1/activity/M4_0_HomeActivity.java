package fpoly.com.duan1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import fpoly.com.duan1.R;

public class M4_0_HomeActivity extends AppCompatActivity {
    private ImageView imgvIconM40;
    private Button btnBatDauM40;
    private Button btnThongKeM40;
    private Button btnAmThanhM40;
    private Button btnHuongDanM40;
    private Button btnChiaSeM40;
    private Button btnDangXuatM40;
    private Button btnThoatM40;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m4_0__home);


//Ánh xạ các thành phần
        imgvIconM40 = (ImageView) findViewById(R.id.imgvIconM40);
        btnBatDauM40 = (Button) findViewById(R.id.btnBatDauM40);
        btnThongKeM40 = (Button) findViewById(R.id.btnThongKeM40);
        btnAmThanhM40 = (Button) findViewById(R.id.btnAmThanhM40);
        btnHuongDanM40 = (Button) findViewById(R.id.btnHuongDanM40);
        btnChiaSeM40 = (Button) findViewById(R.id.btnChiaSeM40);
        btnDangXuatM40 = (Button) findViewById(R.id.btnDangXuatM40);
        btnThoatM40 = (Button) findViewById(R.id.btnThoatM40);

//Animation
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap);
        animation1.setInterpolator(new LinearInterpolator());
        btnBatDauM40.startAnimation(animation1);
        btnAmThanhM40.startAnimation(animation1);
        btnChiaSeM40.startAnimation(animation1);
        btnThoatM40.startAnimation(animation1);


        Animation animation = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap0);
        animation.setInterpolator(new LinearInterpolator());
        btnThongKeM40.startAnimation(animation);
        btnHuongDanM40.startAnimation(animation);
        btnDangXuatM40.startAnimation(animation);

    }

    public void btnAmThanhOnclickM40(View view) {
        String text=btnAmThanhM40.getText().toString();
        if (text.equals("Âm thanh: Bật")){
            btnAmThanhM40.setText("Âm thanh: Tắt");
        }else {

            btnAmThanhM40.setText("Âm thanh: Bật");
        }
    }
}
