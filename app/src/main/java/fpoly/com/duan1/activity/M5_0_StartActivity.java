package fpoly.com.duan1.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fpoly.com.duan1.R;
import fpoly.com.duan1.model.CauHoi;
import fpoly.com.duan1.model.CauHoi1;
import fpoly.com.duan1.model.CauHoi2;
import fpoly.com.duan1.model.CauHoi3;
import fpoly.com.duan1.sqlite.MySQL;

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
    private AlertDialog alertDialog, alertDialog1, alertDialog2;
    private LinearLayout lnlDapAnD;
    private int giayClock;
    public static boolean at;
    private CountDownTimer countDownTimer, countDownTimer1, countDownTimer2, countDownTimer3;
    private TextView tvA;
    private TextView tvAnsA;
    private TextView tvB;
    private TextView tvAnsB;
    private TextView tvC;
    private TextView tvAnsC;
    private TextView tvD;
    private TextView tvAnsD;
    private TextView tvQue;

    //Các thành phần hoạt động
    private boolean troGiup50 = false;
    private int cauSo = 1, tienThuong = 0, viTriDA, dapAnChon;
    private MySQL mySQL;
    private List<CauHoi> cauHois;
    private Random random;

    private boolean troGiup5050 = true, troGiupCall = true, troGiupHoi = true, suDung50 = false, suDungCall = false, suDungHoi = false;


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
        tvA = (TextView) findViewById(R.id.tvA);
        tvAnsA = (TextView) findViewById(R.id.tvAnsA);
        tvB = (TextView) findViewById(R.id.tvB);
        tvAnsB = (TextView) findViewById(R.id.tvAnsB);
        tvQue = (TextView) findViewById(R.id.tvQue);
        tvC = (TextView) findViewById(R.id.tvC);
        tvAnsC = (TextView) findViewById(R.id.tvAnsC);
        tvD = (TextView) findViewById(R.id.tvD);
        tvAnsD = (TextView) findViewById(R.id.tvAnsD);


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


//kích hoạt đồng hồ
        clock();


//Khởi tạo database và khởi tạo các list

        random = new Random();
        mySQL = new MySQL(this);
        mySQL.createDataBase();
        List<CauHoi1> cauHoi1s = mySQL.getAllCauHoi1();
        List<CauHoi2> cauHoi2s = mySQL.getAllCauHoi2();
        List<CauHoi3> cauHoi3s = mySQL.getAllCauHoi3();
        cauHois = new ArrayList<>();
        // gán các câu hỏi sau khi random vào list câu hỏi


        int rd = random.nextInt(5);
        int rd1 = random.nextInt(5) + 4;
        int rd2 = random.nextInt(5) + 8;
        int rd3 = random.nextInt(5) + 12;
        int rd4 = random.nextInt(5) + 15;

        cauHois.add(new CauHoi(cauHoi1s.get(rd).getId(), cauHoi1s.get(rd).getCauHoi(), cauHoi1s.get(rd).getDapAnDung(), cauHoi1s.get(rd).getDapAnSai1(), cauHoi1s.get(rd).getDapAnSai2(), cauHoi1s.get(rd).getDapAnSai3()));
        cauHois.add(new CauHoi(cauHoi1s.get(rd1).getId(), cauHoi1s.get(rd1).getCauHoi(), cauHoi1s.get(rd1).getDapAnDung(), cauHoi1s.get(rd1).getDapAnSai1(), cauHoi1s.get(rd1).getDapAnSai2(), cauHoi1s.get(rd1).getDapAnSai3()));
        cauHois.add(new CauHoi(cauHoi1s.get(rd2).getId(), cauHoi1s.get(rd2).getCauHoi(), cauHoi1s.get(rd2).getDapAnDung(), cauHoi1s.get(rd2).getDapAnSai1(), cauHoi1s.get(rd2).getDapAnSai2(), cauHoi1s.get(rd2).getDapAnSai3()));
        cauHois.add(new CauHoi(cauHoi1s.get(rd3).getId(), cauHoi1s.get(rd3).getCauHoi(), cauHoi1s.get(rd3).getDapAnDung(), cauHoi1s.get(rd3).getDapAnSai1(), cauHoi1s.get(rd3).getDapAnSai2(), cauHoi1s.get(rd3).getDapAnSai3()));
        cauHois.add(new CauHoi(cauHoi1s.get(rd4).getId(), cauHoi1s.get(rd4).getCauHoi(), cauHoi1s.get(rd4).getDapAnDung(), cauHoi1s.get(rd4).getDapAnSai1(), cauHoi1s.get(rd4).getDapAnSai2(), cauHoi1s.get(rd4).getDapAnSai3()));


        cauHois.add(new CauHoi(cauHoi2s.get(rd).getId(), cauHoi2s.get(rd).getCauHoi(), cauHoi2s.get(rd).getDapAnDung(), cauHoi2s.get(rd).getDapAnSai1(), cauHoi2s.get(rd).getDapAnSai2(), cauHoi2s.get(rd).getDapAnSai3()));
        cauHois.add(new CauHoi(cauHoi2s.get(rd1).getId(), cauHoi2s.get(rd1).getCauHoi(), cauHoi2s.get(rd1).getDapAnDung(), cauHoi2s.get(rd1).getDapAnSai1(), cauHoi2s.get(rd1).getDapAnSai2(), cauHoi2s.get(rd1).getDapAnSai3()));
        cauHois.add(new CauHoi(cauHoi2s.get(rd2).getId(), cauHoi2s.get(rd2).getCauHoi(), cauHoi2s.get(rd2).getDapAnDung(), cauHoi2s.get(rd2).getDapAnSai1(), cauHoi2s.get(rd2).getDapAnSai2(), cauHoi2s.get(rd2).getDapAnSai3()));
        cauHois.add(new CauHoi(cauHoi2s.get(rd3).getId(), cauHoi2s.get(rd3).getCauHoi(), cauHoi2s.get(rd3).getDapAnDung(), cauHoi2s.get(rd3).getDapAnSai1(), cauHoi2s.get(rd3).getDapAnSai2(), cauHoi2s.get(rd3).getDapAnSai3()));
        cauHois.add(new CauHoi(cauHoi2s.get(rd4).getId(), cauHoi2s.get(rd4).getCauHoi(), cauHoi2s.get(rd4).getDapAnDung(), cauHoi2s.get(rd4).getDapAnSai1(), cauHoi2s.get(rd4).getDapAnSai2(), cauHoi2s.get(rd4).getDapAnSai3()));


        cauHois.add(new CauHoi(cauHoi3s.get(rd).getId(), cauHoi3s.get(rd).getCauHoi(), cauHoi3s.get(rd).getDapAnDung(), cauHoi3s.get(rd).getDapAnSai1(), cauHoi3s.get(rd).getDapAnSai2(), cauHoi3s.get(rd).getDapAnSai3()));
        cauHois.add(new CauHoi(cauHoi3s.get(rd1).getId(), cauHoi3s.get(rd1).getCauHoi(), cauHoi3s.get(rd1).getDapAnDung(), cauHoi3s.get(rd1).getDapAnSai1(), cauHoi3s.get(rd1).getDapAnSai2(), cauHoi3s.get(rd1).getDapAnSai3()));
        cauHois.add(new CauHoi(cauHoi3s.get(rd2).getId(), cauHoi3s.get(rd2).getCauHoi(), cauHoi3s.get(rd2).getDapAnDung(), cauHoi3s.get(rd2).getDapAnSai1(), cauHoi3s.get(rd2).getDapAnSai2(), cauHoi3s.get(rd2).getDapAnSai3()));
        cauHois.add(new CauHoi(cauHoi3s.get(rd3).getId(), cauHoi3s.get(rd3).getCauHoi(), cauHoi3s.get(rd3).getDapAnDung(), cauHoi3s.get(rd3).getDapAnSai1(), cauHoi3s.get(rd3).getDapAnSai2(), cauHoi3s.get(rd3).getDapAnSai3()));
        cauHois.add(new CauHoi(cauHoi3s.get(rd4).getId(), cauHoi3s.get(rd4).getCauHoi(), cauHoi3s.get(rd4).getDapAnDung(), cauHoi3s.get(rd4).getDapAnSai1(), cauHoi3s.get(rd4).getDapAnSai2(), cauHoi3s.get(rd4).getDapAnSai3()));


//gán câu hỏi

        ganCauHoi();

    }

    //Đồng hồ
    public void clock() {
        giayClock = 32;
        countDownTimer = new CountDownTimer(giayClock * 1000, 1000) {
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
                        troGiup5050 = true;
                        troGiupCall = true;
                        troGiupHoi = true;
                        cauSo = 1;
                        ganCauHoi();
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

                        img50.setImageResource(R.drawable.button_image_help_5050);
                        imgCall.setImageResource(R.drawable.button_image_help_call);
                        imgHoiNhom.setImageResource(R.drawable.button_image_help_audience);

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
                        TextView tvSoTienThuong;

                        tvSoTienThuong = view1.findViewById(R.id.tvSoTienThuong);

                        tvSoTienThuong.setText(convertTien());
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
        } else {
            mediaPlayer = MediaPlayer.create(this, music);
            mediaPlayer.setVolume(0, 0);
            mediaPlayer.start();
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
        } else {
            mediaPlayer0 = MediaPlayer.create(this, music);
            mediaPlayer0.setVolume(0, 0);
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
                TextView tvSoTienThuong;
                final Button btnOkNhanThuong;

                tvSoTienThuong = (TextView) view1.findViewById(R.id.tvSoTienThuong);
                btnOkNhanThuong = (Button) view1.findViewById(R.id.btnOkNhanThuong);

                tvSoTienThuong.setText(convertTien());


                btnOkNhanThuong.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stopMTH();
                        btnOkNhanThuong.setClickable(false);
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


    //Sự kiện click vào trợ giúp 50:50
    public void btn50(View view) {
        //Mở nhạc tình huống
        musicTinhHuong(R.raw.touch_sound);
        //Hiện dialog 'Có chắc chắn sử dụng quyền trợ giúp'
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

        //Chấp nhận sử dụng quyền trợ giúp 50
        btnYesDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                dungDongHo();
                suDung50 = true;
                troGiup5050 = false;
                alertDialog.dismiss();
                stopBackMusic();
                musicTinhHuong(R.raw.sound5050);
                mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        img50.setImageResource(R.drawable.button_image_helpx_5050_x);
                        musicTinhHuong(R.raw.s50);
                        mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                backMusic(R.raw.moc1);
                            }
                        });
                        pasueClock();

                        if (viTriDA == 1) {
                            tvAnsB.setText("");
                            lnlDapAnB.setClickable(false);
                            tvAnsC.setText("");
                            lnlDapAnC.setClickable(false);
                        } else if (viTriDA == 2) {
                            tvAnsA.setText("");
                            lnlDapAnA.setClickable(false);
                            tvAnsC.setText("");
                            lnlDapAnC.setClickable(false);
                        } else if (viTriDA == 3) {
                            tvAnsB.setText("");
                            lnlDapAnB.setClickable(false);
                            tvAnsD.setText("");
                            lnlDapAnD.setClickable(false);
                        } else {

                            tvAnsB.setText("");
                            lnlDapAnB.setClickable(false);
                            tvAnsC.setText("");
                            lnlDapAnC.setClickable(false);

                        }
                    }
                });
            }
        });
        builder.create();
        alertDialog = builder.show();
        builder.setCancelable(false);
    }

    //Sự kiện clcik vào câu trả lời A
    public void ansA(View view) {
        dungDongHo();
        dapAnChon = 1;
        tvA.setTextColor(Color.BLUE);
        tvAnsA.setTextColor(Color.BLUE);
        vhhClick();
        lnlDapAnA.setBackgroundResource(R.drawable.chose);
        countDownTimer.cancel();
        stopBackMusic();
        musicTinhHuong(R.raw.ans_a);
        mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                musicTinhHuong(R.raw.ans_now1);
                mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        //Kiểm tra câu trả lời
                        checkCauTL();
                    }
                });
            }
        });
    }

    //Sự kiện clcik vào câu trả lời B
    public void ansB(View view) {
        dungDongHo();
        dapAnChon = 2;
        tvB.setTextColor(Color.BLUE);
        tvAnsB.setTextColor(Color.BLUE);
        vhhClick();
        lnlDapAnB.setBackgroundResource(R.drawable.chose);
        countDownTimer.cancel();
        stopBackMusic();
        musicTinhHuong(R.raw.ans_b);
        mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                musicTinhHuong(R.raw.ans_now1);
                mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        //Kiểm tra câu trả lời
                        checkCauTL();
                    }
                });
            }
        });
    }

    //Sự kiện clcik vào câu trả lời C
    public void ansC(View view) {
        dungDongHo();
        dapAnChon = 3;
        tvC.setTextColor(Color.BLUE);
        tvAnsC.setTextColor(Color.BLUE);
        vhhClick();
        lnlDapAnC.setBackgroundResource(R.drawable.chose);
        countDownTimer.cancel();
        stopBackMusic();
        musicTinhHuong(R.raw.ans_c);
        mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                musicTinhHuong(R.raw.ans_now1);
                mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        //Kiểm tra câu trả lời
                        checkCauTL();
                    }
                });
            }
        });
    }

    //Sự kiện clcik vào câu trả lời D
    public void ansD(View view) {
        dungDongHo();
        dapAnChon = 4;
        tvD.setTextColor(Color.BLUE);
        tvAnsD.setTextColor(Color.BLUE);
        vhhClick();
        lnlDapAnD.setBackgroundResource(R.drawable.chose);
        countDownTimer.cancel();
        stopBackMusic();
        musicTinhHuong(R.raw.ans_d);
        mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                musicTinhHuong(R.raw.ans_now1);
                mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        //Kiểm tra câu trả lời
                        checkCauTL();
                    }
                });
            }
        });
    }

    //Test nhấp nháy đáp án
    public void nhayAns(final LinearLayout linearLayout) {
        final int[] i = {10};
        CountDownTimer countDownTimer = new CountDownTimer(2000, 200) {
            @Override
            public void onTick(long millisUntilFinished) {
                i[0]--;
                if (i[0] % 2 == 0) {
                    linearLayout.setBackgroundResource(R.drawable.ans);
                } else {
                    linearLayout.setBackgroundResource(R.drawable.chose);
                }

            }

            @Override
            public void onFinish() {
                colorText();
                linearLayout.setBackgroundResource(R.drawable.ans);

            }
        };
        countDownTimer.start();
    }

    //Xác định ví trí đặt đáp án đúng
    public int setViTriDA() {
        viTriDA = random.nextInt(4) + 1;
        return viTriDA;
    }

    public void ganTien() {
        switch (cauSo) {
            case 1:
                if (at) {
                    musicTinhHuong(R.raw.ques01);
                    mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            backMusic(R.raw.moc1);
                        }
                    });
                }
                khClick();
                img50.setImageResource(R.drawable.button_image_help_5050);
                imgCall.setImageResource(R.drawable.button_image_help_call);
                imgHoiNhom.setImageResource(R.drawable.button_image_help_audience);

                tienThuong = 0;
                tvTienThuong.setText("200");
                break;

            case 2:
                if (at) {
                    musicTinhHuong(R.raw.ques02);
                    mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            backMusic(R.raw.moc1);
                        }
                    });
                }
                tienThuong = 200000;
                tvTienThuong.setText("400");
                break;

            case 3:
                if (at) {
                    musicTinhHuong(R.raw.ques03);
                    mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            backMusic(R.raw.moc1);
                        }
                    });
                }
                tienThuong = 400000;
                tvTienThuong.setText("600");
                break;

            case 4:
                if (at) {
                    musicTinhHuong(R.raw.ques04);
                    mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            backMusic(R.raw.moc1);
                        }
                    });
                }
                tienThuong = 600000;
                tvTienThuong.setText("1.000");
                break;

            case 5:
                if (at) {
                    musicTinhHuong(R.raw.ques05);
                    mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            backMusic(R.raw.moc1);
                        }
                    });
                }
                tienThuong = 1000000;
                tvTienThuong.setText("2.000");
                break;

            case 6:
                if (at) {
                    musicTinhHuong(R.raw.ques06);
                    mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            backMusic(R.raw.moc2);
                        }
                    });
                }
                tienThuong = 2000000;
                tvTienThuong.setText("3.000");
                break;

            case 7:
                if (at) {
                    musicTinhHuong(R.raw.ques07);
                    mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            backMusic(R.raw.moc2);
                        }
                    });
                }
                tienThuong = 3000000;
                tvTienThuong.setText("6.000");
                break;

            case 8:
                if (at) {
                    musicTinhHuong(R.raw.ques08);
                    mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            backMusic(R.raw.moc2);
                        }
                    });
                }
                tienThuong = 6000000;
                tvTienThuong.setText("10.000");
                break;

            case 9:
                if (at) {
                    musicTinhHuong(R.raw.ques09);
                    mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            backMusic(R.raw.moc2);
                        }
                    });
                }
                tienThuong = 10000000;
                tvTienThuong.setText("14.000");
                break;

            case 10:
                if (at) {
                    musicTinhHuong(R.raw.ques10);
                    mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            backMusic(R.raw.moc2);
                        }
                    });
                }
                tienThuong = 14000000;
                tvTienThuong.setText("22.000");
                break;

            case 11:
                if (at) {
                    musicTinhHuong(R.raw.ques11);
                    mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            backMusic(R.raw.moc3);
                        }
                    });
                }
                tienThuong = 22000000;
                tvTienThuong.setText("30.000");
                break;

            case 12:
                if (at) {
                    musicTinhHuong(R.raw.ques12);
                    mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            backMusic(R.raw.moc3);
                        }
                    });
                }
                tienThuong = 30000000;
                tvTienThuong.setText("40.000");
                break;

            case 13:
                if (at) {
                    musicTinhHuong(R.raw.ques13);
                    mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            backMusic(R.raw.moc3);
                        }
                    });
                }
                tienThuong = 40000000;
                tvTienThuong.setText("60.000");
                break;

            case 14:
                if (at) {
                    musicTinhHuong(R.raw.ques14);
                    mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            backMusic(R.raw.moc3);
                        }
                    });
                }
                tienThuong = 60000000;
                tvTienThuong.setText("85.000");
                break;

            case 15:
                if (at) {
                    musicTinhHuong(R.raw.ques15);
                    mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            backMusic(R.raw.moc3);
                        }
                    });
                }
                tienThuong = 85000000;
                tvTienThuong.setText("150.000");
                break;
        }
    }


    //Xây dựng phương thức gán câu hỏi vào các view
    public void ganCauHoi() {
        khClick();
        suDung50 = false;
        lnlDapAnC.setClickable(true);
        lnlDapAnA.setClickable(true);
        lnlDapAnB.setClickable(true);
        lnlDapAnD.setClickable(true);
        tvA.setTextColor(Color.WHITE);
        tvAnsA.setTextColor(Color.WHITE);
        tvB.setTextColor(Color.WHITE);
        tvAnsB.setTextColor(Color.WHITE);
        tvC.setTextColor(Color.WHITE);
        tvAnsC.setTextColor(Color.WHITE);
        tvD.setTextColor(Color.WHITE);
        tvAnsD.setTextColor(Color.WHITE);
        lnlDapAnD.setBackgroundResource(R.drawable.dapan);
        lnlDapAnA.setBackgroundResource(R.drawable.dapan);
        lnlDapAnB.setBackgroundResource(R.drawable.dapan);
        lnlDapAnC.setBackgroundResource(R.drawable.dapan);
        lnlDapAnC.setBackgroundResource(R.drawable.dapan);
        troGiup50 = false;
        ganTien();
        tvCau.setText("Câu " + cauSo);
        tvQue.setText(cauHois.get(cauSo - 1).getCauHoi());
        switch (setViTriDA()) {
            case 1:
                tvAnsA.setText(cauHois.get(cauSo - 1).getDapAnDung());
                tvAnsB.setText(cauHois.get(cauSo - 1).getDapAnSai1());
                tvAnsC.setText(cauHois.get(cauSo - 1).getDapAnSai2());
                tvAnsD.setText(cauHois.get(cauSo - 1).getDapAnSai3());
                break;
            case 2:
                tvAnsA.setText(cauHois.get(cauSo - 1).getDapAnSai1());
                tvAnsB.setText(cauHois.get(cauSo - 1).getDapAnDung());
                tvAnsC.setText(cauHois.get(cauSo - 1).getDapAnSai2());
                tvAnsD.setText(cauHois.get(cauSo - 1).getDapAnSai3());
                break;
            case 3:
                tvAnsA.setText(cauHois.get(cauSo - 1).getDapAnSai1());
                tvAnsB.setText(cauHois.get(cauSo - 1).getDapAnSai2());
                tvAnsC.setText(cauHois.get(cauSo - 1).getDapAnDung());
                tvAnsD.setText(cauHois.get(cauSo - 1).getDapAnSai3());
                break;
            case 4:
                tvAnsA.setText(cauHois.get(cauSo - 1).getDapAnSai3());
                tvAnsB.setText(cauHois.get(cauSo - 1).getDapAnSai1());
                tvAnsC.setText(cauHois.get(cauSo - 1).getDapAnSai2());
                tvAnsD.setText(cauHois.get(cauSo - 1).getDapAnDung());
                break;
        }
    }

    //Kiểm tra câu trả lời
    public void checkCauTL() {

        if (viTriDA == 1) {
            nhayAns(lnlDapAnA);
        } else if (viTriDA == 2) {
            nhayAns(lnlDapAnB);
        } else if (viTriDA == 3) {
            nhayAns(lnlDapAnC);
        } else {
            nhayAns(lnlDapAnD);
        }

        if (dapAnChon == viTriDA) {

            //Trả lời đúng

            if (dapAnChon == 1) {
                musicTinhHuong(R.raw.true_a);
            } else if (dapAnChon == 2) {
                musicTinhHuong(R.raw.true_b);
            } else if (dapAnChon == 3) {
                musicTinhHuong(R.raw.true_c);
            } else if (dapAnChon == 4) {
                musicTinhHuong(R.raw.true_d);
            }
            if (cauSo == 15) {

                tienThuong = 150000000;
                mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        musicTinhHuong(R.raw.bestplayer);
                        AlertDialog.Builder builder = new AlertDialog.Builder(M5_0_StartActivity.this, R.style.DialogCustomTheme);
                        View view1 = LayoutInflater.from(M5_0_StartActivity.this).inflate(R.layout.dialog_chucmungv, null);
                        builder.setView(view1);
                        builder.create();
                        alertDialog = builder.show();
                        builder.setCancelable(false);
                        mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                musicTinhHuong(R.raw.lose);
                                AlertDialog.Builder builder = new AlertDialog.Builder(M5_0_StartActivity.this, R.style.DialogCustomTheme);
                                View view1 = LayoutInflater.from(M5_0_StartActivity.this).inflate(R.layout.dialog_nhanhthuong, null);
                                builder.setView(view1);
                                TextView tvSoTienThuong;
                                Button btnOkNhanThuong;

                                tvSoTienThuong = (TextView) view1.findViewById(R.id.tvSoTienThuong);
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
                    }
                });


            } else {


                cauSo++;
                AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogCustomTheme);
                View view1 = LayoutInflater.from(this).inflate(R.layout.dialog_chucmung, null);
                builder.setView(view1);
                builder.create();
                alertDialog = builder.show();
                builder.setCancelable(false);

                mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        alertDialog.dismiss();
                        ganCauHoi();
                        clock();
                    }
                });

            }

        } else {
            //Trả lời sai

            if (viTriDA == 1) {
                musicTinhHuong(R.raw.lose_a);
            } else if (viTriDA == 2) {
                musicTinhHuong(R.raw.lose_b);
            } else if (viTriDA == 3) {
                musicTinhHuong(R.raw.lose_c);
            } else if (viTriDA == 4) {
                musicTinhHuong(R.raw.lose_d);
            }

            mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    musicTinhHuong(R.raw.lose);

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

                            troGiup5050 = true;
                            troGiupCall = true;
                            troGiupHoi = true;
                            alertDialog.dismiss();
                            cauSo = 1;
                            clock();
                            ganCauHoi();

                            img50.setImageResource(R.drawable.button_image_help_5050);
                            imgCall.setImageResource(R.drawable.button_image_help_call);
                            imgHoiNhom.setImageResource(R.drawable.button_image_help_audience);
                            img50.setImageResource(R.drawable.button_image_help_5050);
                            imgCall.setImageResource(R.drawable.button_image_help_call);
                            imgHoiNhom.setImageResource(R.drawable.button_image_help_audience);
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
                            TextView tvSoTienThuong;
                            Button btnOkNhanThuong;

                            tvSoTienThuong = (TextView) view1.findViewById(R.id.tvSoTienThuong);
                            btnOkNhanThuong = (Button) view1.findViewById(R.id.btnOkNhanThuong);


                            tvSoTienThuong.setText(convertTien());


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
            });


        }


    }


    //Hàm convert tiền thưởng
    public String convertTien() {
        if (tienThuong == 0) {
            return "0 VNĐ";
        } else if (tienThuong < 1000000) {
            return tienThuong / 1000 + "." + "000" + " VNĐ";
        } else {
            return tienThuong / 1000000 + "." + "000.000" + " VNĐ";
        }
    }

    //Không cho click
    public void vhhClick() {
        imgHoiNhom.setClickable(false);
        imgDungChoi.setClickable(false);
        imgCall.setClickable(false);
        img50.setClickable(false);
        lnlDapAnC.setClickable(false);
        lnlDapAnB.setClickable(false);
        lnlDapAnD.setClickable(false);
        lnlDapAnA.setClickable(false);
    }

    //kich hoạt click
    public void khClick() {
        imgHoiNhom.setClickable(troGiupHoi);
        imgDungChoi.setClickable(true);
        imgCall.setClickable(troGiupCall);
        img50.setClickable(troGiup5050);
        lnlDapAnC.setClickable(true);
        lnlDapAnB.setClickable(true);
        lnlDapAnD.setClickable(true);
        lnlDapAnA.setClickable(true);
    }

    //set màu chữ
    public void colorText() {
        switch (viTriDA) {
            case 1:
                tvA.setTextColor(Color.BLUE);
                tvAnsA.setTextColor(Color.BLUE);
                break;
            case 2:
                tvB.setTextColor(Color.BLUE);
                tvAnsB.setTextColor(Color.BLUE);
                break;
            case 3:
                tvC.setTextColor(Color.BLUE);
                tvAnsC.setTextColor(Color.BLUE);
                break;
            case 4:
                tvD.setTextColor(Color.BLUE);
                tvAnsD.setTextColor(Color.BLUE);
                break;
        }
    }

    //Trợ giúp gọi điện thoại

    public void imgCall(View view) {
        //Mở nhạc tình huống
        musicTinhHuong(R.raw.touch_sound);
        //Hiện dialog 'Có chắc chắn sử dụng quyền trợ giúp'
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
                alertDialog2.dismiss();
            }
        });

        //Chấp nhận sử dụng quyền trợ giúp 50
        btnYesDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                troGiupCall = false;
                imgCall.setClickable(false);
                countDownTimer.cancel();
                dungDongHo();
                suDungCall=true;



                AlertDialog.Builder builder = new AlertDialog.Builder(M5_0_StartActivity.this, R.style.DialogCustomTheme);
                View view1 = LayoutInflater.from(M5_0_StartActivity.this).inflate(R.layout.dialog_call, null);
                builder.setView(view1);
                LinearLayout lnlGate;
                LinearLayout lnlObama;
                LinearLayout lnlSteave;

                lnlGate = (LinearLayout) view1.findViewById(R.id.lnlGate);
                lnlObama = (LinearLayout) view1.findViewById(R.id.lnlObama);
                lnlSteave = (LinearLayout) view1.findViewById(R.id.lnlSteave);

                lnlGate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stopBackMusic();
                        musicTinhHuong(R.raw.call);
                        mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {

                                dialogCall("Bill Gate");
                            }
                        });

                    }
                });
                lnlObama.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stopBackMusic();
                        musicTinhHuong(R.raw.call);
                        mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {

                                dialogCall("Obama");
                            }
                        });
                    }
                });
                lnlSteave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        stopBackMusic();
                        musicTinhHuong(R.raw.call);
                        mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {

                                dialogCall("Steave");
                            }
                        });
                    }
                });


                builder.create();
                alertDialog = builder.show();
                builder.setCancelable(false);


            }
        });
        builder.create();
        alertDialog2 = builder.show();
        builder.setCancelable(false);
    }

    //Dừng đồng hồ khi chọn sự trợ giúp
    public void pasueClock() {
        final int[] giay = {Integer.parseInt(tvClock.getText().toString())};
        countDownTimer1 = new CountDownTimer(giay[0] * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                tvClock.setText(giay[0]-- + "");
            }

            @Override
            public void onFinish() {
                tvClock.setText(0 + "");

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
                        troGiup5050 = true;
                        troGiupCall = true;
                        troGiupHoi = true;
                        cauSo = 1;
                        ganCauHoi();
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

                        img50.setImageResource(R.drawable.button_image_help_5050);
                        imgCall.setImageResource(R.drawable.button_image_help_call);
                        imgHoiNhom.setImageResource(R.drawable.button_image_help_audience);

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
                        TextView tvSoTienThuong;

                        tvSoTienThuong = view1.findViewById(R.id.tvSoTienThuong);

                        btnOkNhanThuong = (Button) view1.findViewById(R.id.btnOkNhanThuong);

                        tvSoTienThuong.setText(convertTien());
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
        countDownTimer1.start();

    }



    //Dialog call
    public void dialogCall(String tenNV) {
        backMusic(R.raw.background_music);
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogCustomTheme);
        View view1 = LayoutInflater.from(this).inflate(R.layout.dilog, null);
        builder.setView(view1);
        TextView tvTenTitle;
        TextView tvTenNV0;
        TextView tvTenNV1;
        TextView tvCauHoi;
        TextView tvTenNV2;
        TextView tvDA;
        TextView tvTenNV3;
        TextView imgOK;
        LinearLayout lnlDialogCall0;
        LinearLayout lnlDialogCall1;
        LinearLayout lnlDialogCall2;
        LinearLayout lnlDialogCall3;
        LinearLayout lnlDialogCall4;
        LinearLayout lnlDialogCall5;
        LinearLayout lnlDialogCall6;

        lnlDialogCall0 = (LinearLayout) view1.findViewById(R.id.lnlDialogCall0);
        lnlDialogCall1 = (LinearLayout) view1.findViewById(R.id.lnlDialogCall1);
        lnlDialogCall2 = (LinearLayout) view1.findViewById(R.id.lnlDialogCall2);
        lnlDialogCall3 = (LinearLayout) view1.findViewById(R.id.lnlDialogCall3);
        lnlDialogCall4 = (LinearLayout) view1.findViewById(R.id.lnlDialogCall4);
        lnlDialogCall5 = (LinearLayout) view1.findViewById(R.id.lnlDialogCall5);
        lnlDialogCall6 = (LinearLayout) view1.findViewById(R.id.lnlDialogCall6);


        tvTenTitle = (TextView) view1.findViewById(R.id.tvTenTitle);
        tvTenNV0 = (TextView) view1.findViewById(R.id.tvTenNV0);
        tvTenNV1 = (TextView) view1.findViewById(R.id.tvTenNV1);
        tvCauHoi = (TextView) view1.findViewById(R.id.tvCauHoi);
        tvTenNV2 = (TextView) view1.findViewById(R.id.tvTenNV2);
        tvDA = (TextView) view1.findViewById(R.id.tvDA);
        tvTenNV3 = (TextView) view1.findViewById(R.id.tvTenNV3);
        imgOK = (TextView) view1.findViewById(R.id.imgOK);

        tvTenTitle.setText(tenNV + ":");
        tvTenNV0.setText(tenNV + ":");
        tvTenNV1.setText(tenNV + ":");
        tvTenNV2.setText(tenNV + ":");
        tvTenNV3.setText(tenNV + ":");

        tvCauHoi.setText(cauHois.get(cauSo - 1).getCauHoi());

        String da = "";
        switch (viTriDA) {
            case 1:
                da = "A";
                break;
            case 2:
                da = "B";
                break;
            case 3:
                da = "C";
                break;
            case 4:
                da = "D";
                break;
        }

        tvDA.setText(da + ". " + cauHois.get(cauSo - 1).getDapAnDung());

        imgOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgCall.setImageResource(R.drawable.button_image_helpx_call_x);
                alertDialog1.dismiss();
                alertDialog.dismiss();
                alertDialog2.dismiss();
                pasueClock();
            }
        });

        Animation animation = AnimationUtils.loadAnimation(M5_0_StartActivity.this, R.anim.dialog_call0);
        animation.setInterpolator(new LinearInterpolator());
        lnlDialogCall0.startAnimation(animation);

        Animation animation1 = AnimationUtils.loadAnimation(M5_0_StartActivity.this, R.anim.dialog_call1);
        animation1.setInterpolator(new LinearInterpolator());
        lnlDialogCall1.startAnimation(animation1);

        Animation animation2 = AnimationUtils.loadAnimation(M5_0_StartActivity.this, R.anim.dialog_call2);
        animation2.setInterpolator(new LinearInterpolator());
        lnlDialogCall2.startAnimation(animation2);

        Animation animation3 = AnimationUtils.loadAnimation(M5_0_StartActivity.this, R.anim.dialog_call3);
        animation3.setInterpolator(new LinearInterpolator());
        lnlDialogCall3.startAnimation(animation3);

        Animation animation4 = AnimationUtils.loadAnimation(M5_0_StartActivity.this, R.anim.dialog_call4);
        animation4.setInterpolator(new LinearInterpolator());
        lnlDialogCall4.startAnimation(animation4);

        Animation animation5 = AnimationUtils.loadAnimation(M5_0_StartActivity.this, R.anim.dialog_call5);
        animation5.setInterpolator(new LinearInterpolator());
        lnlDialogCall5.startAnimation(animation5);

        Animation animation6 = AnimationUtils.loadAnimation(M5_0_StartActivity.this, R.anim.dialog_call6);
        animation6.setInterpolator(new LinearInterpolator());
        lnlDialogCall6.startAnimation(animation6);
        Animation animation7 = AnimationUtils.loadAnimation(M5_0_StartActivity.this, R.anim.dialog_call7);
        animation7.setInterpolator(new LinearInterpolator());
        imgOK.startAnimation(animation7);


        builder.create();
        alertDialog1 = builder.show();
        builder.setCancelable(false);

    }

    //trợ giúp hỏi ý kiến khán giả

    public void yKienKhanGia(View view) {


        musicTinhHuong(R.raw.touch_sound);
        troGiupHoi = false;
        //Hiện dialog 'Có chắc chắn sử dụng quyền trợ giúp'
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

        btnYesDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnYesDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgHoiNhom.setClickable(false);
                dungDongHo();
                suDungHoi=true;
                musicTinhHuong(R.raw.bg_audience);
                imgHoiNhom.setImageResource(R.drawable.button_image_helpx_audience_x);
                countDownTimer.cancel();
                dialogYKienKhanGia();
            }
        });
        builder.create();
        alertDialog = builder.show();
        builder.setCancelable(false);

    }

    public void dialogYKienKhanGia() {
        mediaPlayer0.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                AlertDialog.Builder builder = new AlertDialog.Builder(M5_0_StartActivity.this, R.style.DialogCustomTheme);
                View view1 = LayoutInflater.from(M5_0_StartActivity.this).inflate(R.layout.dialog_ykien, null);
                builder.setView(view1);

                ImageButton imgClose;
                TextView tvPTA;
                TextView tvPTB;
                TextView tvPTC;
                TextView tvPTD;
                TextView tvCotA;
                TextView tvCotB;
                TextView tvCotC;
                TextView tvCotD;

                imgClose = (ImageButton) view1.findViewById(R.id.imgClose);
                tvPTA = (TextView) view1.findViewById(R.id.tvPTA);
                tvPTB = (TextView) view1.findViewById(R.id.tvPTB);
                tvPTC = (TextView) view1.findViewById(R.id.tvPTC);
                tvPTD = (TextView) view1.findViewById(R.id.tvPTD);
                tvCotA = (TextView) view1.findViewById(R.id.tvCotA);
                tvCotB = (TextView) view1.findViewById(R.id.tvCotB);
                tvCotC = (TextView) view1.findViewById(R.id.tvCotC);
                tvCotD = (TextView) view1.findViewById(R.id.tvCotD);

                imgClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog1.dismiss();
                        alertDialog.dismiss();
                        pasueClock();
                    }
                });

                String a = null, b = null, c = null, d = null;

                if (suDung50) {
                    switch (viTriDA) {
                        case 1:
                            tvCotA.setHeight(280);
                            tvCotB.setHeight(0);
                            tvCotC.setHeight(0);
                            tvCotD.setHeight(120);
                            a = "70%";
                            b = "0%";
                            c = "0%";
                            d = "30%";
                            break;
                        case 2:
                            tvCotB.setHeight(280);
                            tvCotA.setHeight(0);
                            tvCotC.setHeight(0);
                            tvCotD.setHeight(120);
                            a = "0%";
                            b = "70%";
                            c = "0%";
                            d = "30%";
                            break;
                        case 3:
                            tvCotA.setHeight(120);
                            tvCotB.setHeight(0);
                            tvCotC.setHeight(280);
                            tvCotD.setHeight(0);
                            a = "30%";
                            b = "0%";
                            c = "70%";
                            d = "0%";
                            break;
                        case 4:
                            tvCotA.setHeight(120);
                            tvCotB.setHeight(0);
                            tvCotC.setHeight(0);
                            tvCotD.setHeight(280);
                            a = "30%";
                            b = "0%";
                            c = "0%";
                            d = "70%";
                            break;

                    }
                } else {
                    switch (viTriDA) {
                        case 1:
                            tvCotA.setHeight(200);
                            tvCotB.setHeight(100);
                            tvCotC.setHeight(40);
                            tvCotD.setHeight(60);
                            a = "50%";
                            b = "25%";
                            c = "10%";
                            d = "15%";
                            break;
                        case 2:
                            tvCotB.setHeight(100);
                            tvCotA.setHeight(200);
                            tvCotC.setHeight(0);
                            tvCotD.setHeight(100);
                            a = "25%";
                            b = "50%";
                            c = "0%";
                            d = "25%";
                            break;
                        case 3:
                            tvCotA.setHeight(100);
                            tvCotB.setHeight(60);
                            tvCotC.setHeight(240);
                            tvCotD.setHeight(0);
                            a = "25%";
                            b = "15%";
                            c = "60%";
                            d = "0%";
                            break;
                        case 4:
                            tvCotA.setHeight(60);
                            tvCotB.setHeight(0);
                            tvCotC.setHeight(120);
                            tvCotD.setHeight(220);
                            a = "15%";
                            b = "0%";
                            c = "30%";
                            d = "55%";
                            break;

                    }
                }

                tvPTA.setText(a);
                tvPTB.setText(b);
                tvPTC.setText(c);
                tvPTD.setText(d);


                builder.create();
                alertDialog1 = builder.show();
                builder.setCancelable(false);
            }
        });

    }

    //dừng đồng hồ
    public void dungDongHo() {
        if (suDung50||suDungHoi||suDungCall) {
            countDownTimer1.cancel();
        }

    }
}
