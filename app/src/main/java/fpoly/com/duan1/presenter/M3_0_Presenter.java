package fpoly.com.duan1.presenter;

import fpoly.com.duan1.view.M3_0_DangKyView;

public class M3_0_Presenter {
    private M3_0_DangKyView dangKyView;

    public M3_0_Presenter(M3_0_DangKyView m30DangKyView){this.dangKyView = m30DangKyView;}

    public void dangky(String username, String password, String password1){
        if (username.isEmpty()){
            dangKyView.seterrorUsernameRegister();
        }
        else if (password.isEmpty()){
            dangKyView.seterrorPasswordRegister();
        }
        else if (password1.isEmpty() && password1.equals(password)){
            dangKyView.navigate();
        }

    }
}
