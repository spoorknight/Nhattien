package fpoly.com.duan1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

import fpoly.com.duan1.R;
import fpoly.com.duan1.base.BaseActivity;
import fpoly.com.duan1.model.TaiKhoan;
import fpoly.com.duan1.presenter.M2_0_LoginPresenter;
import fpoly.com.duan1.sqlite.MySQL;
import fpoly.com.duan1.view.M2_0_LoginView;

public class M2_0_LoginActivity extends BaseActivity implements M2_0_LoginView {
    public static String in = "true";
    private ImageView imgvIconM20;
    private LinearLayout lnlM20;
    private LinearLayout lnlM201;
    private M2_0_LoginPresenter m2_0_loginPresenter;
    private MySQL mySQL;
    private List<TaiKhoan> taiKhoans;
    private TextInputLayout tipTK;
    private EditText edtTaiKhoan;
    private TextInputLayout tipMK;
    private EditText edtMatKhau;
    private CheckBox ckb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m2_0__login);

        mySQL = new MySQL(this);
        mySQL.createDataBase();
        taiKhoans = mySQL.getAllTaiKhoan();


        ckb = (CheckBox) findViewById(R.id.ckb);

        tipTK = (TextInputLayout) findViewById(R.id.tipTK);
        edtTaiKhoan = (EditText) findViewById(R.id.edtTaiKhoan);
        tipMK = (TextInputLayout) findViewById(R.id.tipMK);
        edtMatKhau = (EditText) findViewById(R.id.edtMatKhau);

        imgvIconM20 = (ImageView) findViewById(R.id.imgvIconM20);
        lnlM20 = (LinearLayout) findViewById(R.id.lnlM20);
        lnlM201 = (LinearLayout) findViewById(R.id.lnlM201);
        m2_0_loginPresenter = new M2_0_LoginPresenter(this);

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

        checkRemember();
    }


    public void btnDangKyClick(View view) {

        outActivity();
//chuyển màn hình
        startActivityAnimation(this, 1000, M3_0_DangKyActivity.class);
    }

    public void btnDangNhapM20(View view) {

        m2_0_loginPresenter.checkLogin();

    }

    public void outActivity() {
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap_out);
        animation1.setInterpolator(new LinearInterpolator());
        lnlM20.startAnimation(animation1);

        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap0_out);
        animation2.setInterpolator(new LinearInterpolator());
        lnlM201.startAnimation(animation2);
    }

    @Override
    public boolean checkND() {
        String taiKhoan = edtTaiKhoan.getText().toString();
        String matKhau = edtMatKhau.getText().toString();
        boolean a = false;
        for (int i = 0; i < taiKhoans.size(); i++) {
            if (taiKhoan.equals(taiKhoans.get(i).getUsername()) && matKhau.equals(taiKhoans.get(i).getPassword())) {
                a = true;
                break;
            } else {
                a = false;
            }
        }
        return a;
    }

    @Override
    public void loginThanhCong() {
        M5_0_StartActivity.idUser = mySQL.getTaiKhoan(edtTaiKhoan.getText().toString());
//Animation
        outActivity();
        if (ckb.isChecked()) {
            mySQL.updateUser();
            mySQL.updateUser(edtTaiKhoan.getText().toString());
        } else {
            mySQL.updateUser();
        }
//chuyển màn hình
        startActivityAnimation(this, 1000, M4_0_HomeActivity.class);


    }

    @Override
    public void saiTenDN() {
        Toast.makeText(this, "Sai tên đăng nhập hoặc mật khẩu!!!", Toast.LENGTH_SHORT).show();
    }

    public void checkRemember() {
        boolean b = false;
        TaiKhoan taiKhoan = new TaiKhoan("", "", "", "", "");
        for (int i = 0; i < taiKhoans.size(); i++) {
            if (taiKhoans.get(i).getRemember() != null) {
                if (taiKhoans.get(i).getRemember().equals("y")) {
                    b = true;
                    taiKhoan = taiKhoans.get(i);
                }
            }

        }
        edtTaiKhoan.setText(taiKhoan.getUsername());
        edtMatKhau.setText(taiKhoan.getPassword());
        ckb.setChecked(b);

    }
}
