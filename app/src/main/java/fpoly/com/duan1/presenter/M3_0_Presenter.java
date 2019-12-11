package fpoly.com.duan1.presenter;

import fpoly.com.duan1.view.M3_0_DangKyView;

public class M3_0_Presenter {
    private M3_0_DangKyView dangKyView;

    public M3_0_Presenter(M3_0_DangKyView m30DangKyView) {
        this.dangKyView = m30DangKyView;
    }

    public void checkTaiKhoan(String taiKhoan, String matKhau, String matKhau1) {
        if (dangKyView.checkUsser()){
            dangKyView.taiKhoanHopLe();
        }else {
            dangKyView.taiKhoanDaTonTai();
        }
        if (taiKhoan.trim().length() < 10) {
            dangKyView.taiKhoanKHongHopLe();
        }else {
            dangKyView.taiKhoanHopLe();
        }
        if (matKhau.trim().length() < 8) {
            dangKyView.matKhauKhongHopLe();
        }else {
            dangKyView.matKhauHopLe();
        }
        if (matKhau1.trim().length() < 8) {
            dangKyView.matKhauKhongHopLe1();
        }else {
            dangKyView.matKhauHopLe1();
        }
        if (!matKhau.trim().equals(matKhau1.trim())){
            dangKyView.matKhauChuaTrung();
        }else {
            dangKyView.matKhauHopLe();
            dangKyView.matKhauHopLe1();
        }
        if (matKhau1.trim().equals(matKhau.trim()) && taiKhoan.trim().length() >= 10&&matKhau.trim().length()>=8&&matKhau.trim().equals(matKhau1.trim())&& dangKyView.checkUsser() ) {
            dangKyView.dangKyThanhCong();
        } else {
            if (dangKyView.checkUsser()){
                dangKyView.taiKhoanHopLe();
            }else {
                dangKyView.taiKhoanDaTonTai();
            }
            if (taiKhoan.trim().length() < 10) {
                dangKyView.taiKhoanKHongHopLe();
            }else {
                dangKyView.taiKhoanHopLe();
            }
            if (matKhau.trim().length() < 8) {
                dangKyView.matKhauKhongHopLe();
            }else {
                dangKyView.matKhauHopLe();
            }
            if (matKhau1.trim().length() < 8) {
                dangKyView.matKhauKhongHopLe1();
            }else {
                dangKyView.matKhauHopLe1();
            }
            if (!matKhau.trim().equals(matKhau1.trim())){
                dangKyView.matKhauChuaTrung();
            }else {
                dangKyView.matKhauHopLe();
                dangKyView.matKhauHopLe1();
            }
        }
    }
}
