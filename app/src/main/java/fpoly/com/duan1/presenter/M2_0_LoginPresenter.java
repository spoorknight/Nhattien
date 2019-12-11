package fpoly.com.duan1.presenter;

import fpoly.com.duan1.view.M2_0_LoginView;

public class M2_0_LoginPresenter {
    private M2_0_LoginView m2_0_loginView;

    public M2_0_LoginPresenter(M2_0_LoginView m2_0_loginView) {
        this.m2_0_loginView = m2_0_loginView;
    }

    public void checkLogin() {
        if (m2_0_loginView.checkND()) {
            m2_0_loginView.loginThanhCong();
        } else {
            m2_0_loginView.saiTenDN();
        }
    }
}
