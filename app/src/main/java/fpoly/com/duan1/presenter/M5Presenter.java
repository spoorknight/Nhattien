package fpoly.com.duan1.presenter;

import fpoly.com.duan1.view.M5View;

public class M5Presenter {
private M5View m5View;

    public M5Presenter(M5View m5View) {
        this.m5View = m5View;
    }

    public void clock(){
        m5View.clock();
    }
}
