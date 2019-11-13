package fpoly.com.duan1.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
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
    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayer0;
    private LinearLayout lnlDapAnA;
    private LinearLayout lnlDapAnB;
    private LinearLayout lnlDapAnC;
    private AlertDialog alertDialog;
    private LinearLayout lnlDapAnD;
    private int giayClock;
    public static boolean at;
    private CountDownTimer countDownTimer;

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

//Âm thanh lúc vào
        if (M4_0_HomeActivity.at) {
            at = true;
        }
        if (at) {
            musicTinhHuong(R.raw.ques01);
            mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    backMusic(R.raw.moc1);
                }
            });
        }

//kích hoạt đồng hồ
        clock();

    }

    //Đồng hồ
    public void clock() {
        giayClock = 32;
          countDownTimer = new CountDownTimer(giayClock*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                giayClock--;
                tvClock.setText(giayClock + "");
            }

            @Override
            public void onFinish() {
                //hết giờ chơi
                stopBackMusic();
                musicTinhHuong(R.raw.out_of_time);
                AlertDialog.Builder builder = new AlertDialog.Builder(M5_0_StartActivity.this, R.style.DialogCustomTheme);
                View view1 = LayoutInflater.from(M5_0_StartActivity.this).inflate(R.layout.dialog_hetgio, null);
                builder.setView(view1);
                Button btnNoDialog;
                Button btnYesDialog;

                btnNoDialog = (Button) view1.findViewById(R.id.btnNoDialog);
                btnYesDialog = (Button) view1.findViewById(R.id.btnYesDialog);

                //Bắt sự kiện chơi lại
                btnNoDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                        clock();
                        if (at) {
                            stopMTH();
                            musicTinhHuong(R.raw.ques01);
                            mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {

                                    backMusic(R.raw.moc1);
                                }
                            });
                        }

                    }
                });

                //Bắt sự kiện nút nhận thưởng
                btnYesDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stopMTH();
                        musicTinhHuong(R.raw.lose);
                        AlertDialog.Builder builder = new AlertDialog.Builder(M5_0_StartActivity.this, R.style.DialogCustomTheme);
                        View view1 = LayoutInflater.from(M5_0_StartActivity.this).inflate(R.layout.dialog_nhanhthuong, null);
                        builder.setView(view1);
                        Button btnOkNhanThuong;

                        btnOkNhanThuong = (Button) view1.findViewById(R.id.btnOkNhanThuong);

                        btnOkNhanThuong.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (at) {
                                    M4_0_HomeActivity.at = true;
                                }
                                Intent intent = new Intent(M5_0_StartActivity.this, M4_0_HomeActivity.class);
                                if (at) {
                                    intent.putExtra("at", true);
                                } else {

                                    intent.putExtra("at", false);
                                }
                                startActivity(intent);

                            }
                        });


                        builder.create();
                        alertDialog = builder.show();
                        builder.setCancelable(false);

                    }
                });

                builder.create();
                alertDialog = builder.show();
                builder.setCancelable(false);
            }
        };
        countDownTimer.start();
    }


    //Load nhạc nền
    public void backMusic(int music) {
        if (at) {
            mediaPlayer = MediaPlayer.create(this, music);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.start();
                }
            });
        }

    }

    //Dừng nhạc nền
    public void stopBackMusic() {
        if (at) {

            mediaPlayer.release();
        }
    }

    //chạy nhạc tình huống
    public void musicTinhHuong(int music) {
        if (at) {

            mediaPlayer0 = MediaPlayer.create(this, music);
            mediaPlayer0.start();
        }
    }

    //dừng nhạc tình huống
    public void stopMTH() {
        if (at) {

            mediaPlayer0.stop();
        }
    }

    //sự kiện dừng cuộc chơi
    public void imgDungChoi(View view) {
        musicTinhHuong(R.raw.touch_sound);
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogCustomTheme);
        View view1 = LayoutInflater.from(this).inflate(R.layout.dialog_dungchoi, null);
        builder.setView(view1);
        Button btnNoDialog;
        Button btnYesDialog;

        btnNoDialog = (Button) view1.findViewById(R.id.btnNoDialog);
        btnYesDialog = (Button) view1.findViewById(R.id.btnYesDialog);

        //hủy quyền trợ giúp
        btnNoDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        //chấp nhận
        btnYesDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                stopBackMusic();
                musicTinhHuong(R.raw.lose);
                AlertDialog.Builder builder = new AlertDialog.Builder(M5_0_StartActivity.this, R.style.DialogCustomTheme);
                View view1 = LayoutInflater.from(M5_0_StartActivity.this).inflate(R.layout.dialog_nhanhthuong, null);
                builder.setView(view1);
                Button btnOkNhanThuong;

                btnOkNhanThuong = (Button) view1.findViewById(R.id.btnOkNhanThuong);

                btnOkNhanThuong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (at) {
                            M4_0_HomeActivity.at = true;
                        }
                        Intent intent = new Intent(M5_0_StartActivity.this, M4_0_HomeActivity.class);
                        if (at) {
                            intent.putExtra("at", true);
                        } else {

                            intent.putExtra("at", false);
                        }
                        startActivity(intent);

                    }
                });


                builder.create();
                alertDialog = builder.show();
                builder.setCancelable(false);


            }
        });


        builder.create();
        alertDialog = builder.show();
        builder.setCancelable(false);
    }
}
