package fpoly.com.duan1.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import fpoly.com.duan1.activity.M3_0_DangKyActivity;
import fpoly.com.duan1.activity.M3_1_DangKyInGameActivity;

public class BaseActivity extends AppCompatActivity {
    public void startActivityAnimation(final Context context, final long mili, final Class mhChuyen){
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(mili);
                     overridePendingTransition(0, 0);
                    context.startActivity(new Intent(context ,mhChuyen));
                     overridePendingTransition(0, 0);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };
        thread.start();
    }

    public void chuyenManHinh(Class mhChuyen,String idUser){
        Intent intent=new Intent(this,mhChuyen);
        intent.putExtra("idUser",idUser);
        startActivity(intent);
    }
}
