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
import android.widget.Toast;

import fpoly.com.duan1.R;
import fpoly.com.duan1.base.BaseActivity;
import fpoly.com.duan1.model.TaiKhoan;
import fpoly.com.duan1.presenter.M3_1_Presenter;
import fpoly.com.duan1.sqlite.MySQL;
import fpoly.com.duan1.view.M3_1_View;

public class M3_1_DangKyInGameActivity extends BaseActivity implements M3_1_View {

    private ImageView imgvIconM31;
    private LinearLayout lnlM31;
    private LinearLayout lnlM312;
    private M3_1_Presenter m3_1_presenter;
    private TaiKhoan taiKhoan;
    private MySQL mySQL;
    private EditText edtIdGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m3_1__dang_ky_in_game);
//Ánh xạ
        imgvIconM31 = (ImageView) findViewById(R.id.imgvIconM31);
        lnlM31 = (LinearLayout) findViewById(R.id.lnlM31);
        lnlM312 = (LinearLayout) findViewById(R.id.lnlM312);
        edtIdGame = (EditText) findViewById(R.id.edtIdGame);


//Animation
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.m31_dangkytengame_in);
        animation1.setInterpolator(new LinearInterpolator());
        lnlM31.startAnimation(animation1);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.m31_dangkytengame_in);
        animation.setInterpolator(new LinearInterpolator());
        lnlM312.startAnimation(animation);

        m3_1_presenter = new M3_1_Presenter(this);
        taiKhoan = (TaiKhoan) getIntent().getSerializableExtra("user");
        mySQL = new MySQL(this);
        mySQL.createDataBase();
    }

    public void btnQuayLaiM31(View view) {

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.m31_dangkytengame_out);
        animation.setInterpolator(new LinearInterpolator());
        lnlM312.startAnimation(animation);
        lnlM31.startAnimation(animation);
//chuyển màn hình
        //chuyển màn hình
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Intent intent = new Intent(M3_1_DangKyInGameActivity.this, M3_0_DangKyActivity.class);
                    sleep(2000);
                    overridePendingTransition(0, 0);
                    intent.putExtra("user", taiKhoan);
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

    public void btnVaoGameOnclickM31(View view) {


        m3_1_presenter.checkIDGame(edtIdGame.getText().toString());

    }

    @Override
    public void idGameKhongHopLe() {
        Toast.makeText(this, "ID Game có ít nhất 4 ký tự!!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void idHopLe() {

        //Animation
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap_out);
        animation.setInterpolator(new LinearInterpolator());
        lnlM312.startAnimation(animation);
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap0_out);
        animation1.setInterpolator(new LinearInterpolator());
        lnlM31.startAnimation(animation1);
//chuyển màn hình
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    Intent intent = new Intent(M3_1_DangKyInGameActivity.this, M4_0_HomeActivity.class);
                    sleep(1000);
                    overridePendingTransition(0, 0);
                    taiKhoan.setPlayer(edtIdGame.getText().toString());
                    mySQL.insertUser(taiKhoan);
                    M5_0_StartActivity.idUser=mySQL.getTaiKhoan(taiKhoan.getUsername());
                    intent.putExtra("id",taiKhoan.getIduser());
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
}
