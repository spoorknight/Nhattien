package fpoly.com.duan1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import fpoly.com.duan1.R;
import fpoly.com.duan1.base.BaseActivity;
import fpoly.com.duan1.model.TaiKhoan;
import fpoly.com.duan1.presenter.M3_0_Presenter;
import fpoly.com.duan1.sqlite.MySQL;
import fpoly.com.duan1.view.M3_0_DangKyView;

public class M3_0_DangKyActivity extends BaseActivity implements M3_0_DangKyView {

    private ImageView imgvIconM30;
    private LinearLayout lnlM30;
    private LinearLayout lnlM31;
    private TextInputLayout tvlUsername;
    private EditText edtUsernameRegister;
    private TextInputLayout tvlPassword1;
    private EditText edtPasswordRegister1;
    private TextInputLayout tvlPassword2;
    private EditText edtPasswordRegister2;
    private M3_0_Presenter m30Presenter;
    private TaiKhoan taiKhoan;
    private MySQL mySQL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m3_0__dang_ky);
//Ánh xạ các thành phần giao diện
        imgvIconM30 = (ImageView) findViewById(R.id.imgvIconM30);
        lnlM30 = (LinearLayout) findViewById(R.id.lnlM30);
        lnlM31 = (LinearLayout) findViewById(R.id.lnlM31);
        tvlUsername = (TextInputLayout) findViewById(R.id.tvl_username);
        edtUsernameRegister = (EditText) findViewById(R.id.edtUsername_register);
        tvlPassword1 = (TextInputLayout) findViewById(R.id.tvl_password1);
        edtPasswordRegister1 = (EditText) findViewById(R.id.edtPassword_register1);
        tvlPassword2 = (TextInputLayout) findViewById(R.id.tvl_password2);
        edtPasswordRegister2 = (EditText) findViewById(R.id.edtPassword_register2);

        m30Presenter = new M3_0_Presenter(this);
//Animation
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap);
        animation1.setInterpolator(new LinearInterpolator());
        lnlM30.startAnimation(animation1);

        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap0);
        animation2.setInterpolator(new LinearInterpolator());


        lnlM31.startAnimation(animation2);
        taiKhoan = (TaiKhoan) getIntent().getSerializableExtra("user");
        if (taiKhoan != null) {
            edtUsernameRegister.setText(taiKhoan.getUsername());
            edtPasswordRegister1.setText(taiKhoan.getPassword());
            edtPasswordRegister2.setText(taiKhoan.getPassword());
        }
        mySQL = new MySQL(this);
        mySQL.createDataBase();

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
        m30Presenter.checkTaiKhoan(edtUsernameRegister.getText().toString(), edtPasswordRegister1.getText().toString(), edtPasswordRegister2.getText().toString());
    }


    @Override
    public void taiKhoanKHongHopLe() {
        tvlUsername.setError("Tài khoản chứa ít nhất 10 ký tự");
    }

    @Override
    public void matKhauKhongHopLe() {
        tvlPassword1.setError("Mật khẩu chứa ít nhất 8 ký tự");
    }

    @Override
    public void dangKyThanhCong() {
        tvlUsername.setErrorEnabled(false);
        tvlPassword2.setErrorEnabled(false);
        tvlPassword1.setErrorEnabled(false);
        //Animation cho các View ra
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap_out);
        animation1.setInterpolator(new LinearInterpolator());
        lnlM30.startAnimation(animation1);

        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap0_out);
        animation2.setInterpolator(new LinearInterpolator());
        lnlM31.startAnimation(animation2);

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Intent intent = new Intent(M3_0_DangKyActivity.this, M3_1_DangKyInGameActivity.class);
                    sleep(1000);
                    overridePendingTransition(0, 0);
                    intent.putExtra("user", new TaiKhoan("", edtUsernameRegister.getText().toString(), edtPasswordRegister1.getText().toString(), ""));
                    startActivity(intent);
                    overridePendingTransition(0, 0);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };
        thread.start();

    }

    @Override
    public void matKhauKhongHopLe1() {
        tvlPassword2.setError("Mật khẩu chứa ít nhất 8 ký tự");
    }

    @Override
    public void taiKhoanHopLe() {
        tvlUsername.setErrorEnabled(false);
    }

    @Override
    public void matKhauHopLe() {

        tvlPassword1.setErrorEnabled(false);
    }

    @Override
    public void matKhauHopLe1() {

        tvlPassword2.setErrorEnabled(false);
    }

    @Override
    public void matKhauChuaTrung() {
        tvlPassword2.setError("Hai mật khẩu chưa khớp nhau!!!");
    }

    @Override
    public boolean checkUsser() {
        String taiKhoan = edtUsernameRegister.getText().toString();
        List<TaiKhoan> taiKhoans = mySQL.getAllTaiKhoan();
        boolean a=true;
        for (int i = 0; i < taiKhoans.size(); i++) {
            if (taiKhoan.equals(taiKhoans.get(i).getUsername())) {
                a = false;
                break;
            } else {
                a = true;
            }
        }
        return a;
    }

    @Override
    public void taiKhoanDaTonTai() {
        tvlUsername.setError("Tài khoản đã tồn tại");
    }
}
