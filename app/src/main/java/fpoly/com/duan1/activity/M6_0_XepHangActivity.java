package fpoly.com.duan1.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import fpoly.com.duan1.R;
import fpoly.com.duan1.adapter.BangrXepHangAdapter;
import fpoly.com.duan1.model.XepHang;
import fpoly.com.duan1.sqlite.MySQL;

public class M6_0_XepHangActivity extends AppCompatActivity {
    private RecyclerView recy;
    private BangrXepHangAdapter bangrXepHangAdapter;
    private List<XepHang> xepHangs;
    private MySQL mySQL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m6_0__xep_hang);

        recy = (RecyclerView) findViewById(R.id.recy);
        mySQL=new MySQL(this);
        mySQL.createDataBase();
        xepHangs=mySQL.getAllDiemCao();
        bangrXepHangAdapter=new BangrXepHangAdapter(xepHangs,M6_0_XepHangActivity.this);
        recy.setAdapter(bangrXepHangAdapter);
        recy.setLayoutManager(new LinearLayoutManager(this));
    }


    public void Back_Home_Activity(View view) {
        startActivity(new Intent(M6_0_XepHangActivity.this, M4_0_HomeActivity.class));
    }
}
