package fpoly.com.duan1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fpoly.com.duan1.R;

public class M6_0_XepHangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m6_0__xep_hang);
    }


    public void Back_Home_Activity(View view) {
        startActivity(new Intent(M6_0_XepHangActivity.this, M4_0_HomeActivity.class));
    }
}
