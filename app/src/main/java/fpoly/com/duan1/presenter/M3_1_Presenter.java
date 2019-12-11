package fpoly.com.duan1.presenter;

import fpoly.com.duan1.view.M3_1_View;

public class M3_1_Presenter {
    private M3_1_View m3_1_view;

    public M3_1_Presenter(M3_1_View m3_1_view) {
        this.m3_1_view = m3_1_view;
    }
    public void checkIDGame(String id){
        if (id.trim().length()<4){
            m3_1_view.idGameKhongHopLe();
        }else {
            m3_1_view.idHopLe();
        }
    }
}
