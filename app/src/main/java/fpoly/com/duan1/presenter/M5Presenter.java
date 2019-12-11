package fpoly.com.duan1.presenter;

import android.media.MediaPlayer;

import fpoly.com.duan1.R;
import fpoly.com.duan1.view.M5View;

public class M5Presenter {
    private M5View m5View;

    public M5Presenter(M5View m5View) {
        this.m5View = m5View;
    }



    public void dungCuocChoiHelp() {
        m5View.imgDungChoi();
    }

    public void troGiup5050() {
        m5View.troGiup5050();
    }

    public void clickDapAnA() {
        m5View.clickDAA();
    }

    public void clickDapAnB() {
        m5View.clickDAB();
    }

    public void clickDapAnC() {
        m5View.clickDAC();
    }

    public void clickDapAnD() {
        m5View.clickDAD();
    }

    public void ganTienThuong(int cauSo) {

        switch (cauSo) {
            case 1:
                m5View.cauSo1();

                break;

            case 2:
                m5View.cauSo2();

                break;

            case 3:
                m5View.cauSo3();

                break;

            case 4:
                m5View.cauSo4();

                break;

            case 5:
                m5View.cauSo5();

                break;

            case 6:
                m5View.cauSo6();

                break;

            case 7:
                m5View.cauSo7();

                break;

            case 8:
                m5View.cauSo8();

                break;

            case 9:
                m5View.cauSo9();

                break;

            case 10:
                m5View.cauSo10();

                break;

            case 11:
                m5View.cauSo11();

                break;

            case 12:
                m5View.cauSo12();

                break;

            case 13:
                m5View.cauSo13();

                break;

            case 14:
                m5View.cauSo14();

                break;

            case 15:
                m5View.cauSo15();

                break;
        }
    }
}
