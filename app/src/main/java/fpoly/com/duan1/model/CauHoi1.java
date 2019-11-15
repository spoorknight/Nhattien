package fpoly.com.duan1.model;

import java.io.Serializable;

public class CauHoi1 implements Serializable {

    private String id,cauHoi,dapAnDung,dapAnSai1,dapAnSai2,dapAnSai3;

    public CauHoi1(String id, String cauHoi, String dapAnDung, String dapAnSai1, String dapAnSai2, String dapAnSai3) {
        this.id = id;
        this.cauHoi = cauHoi;
        this.dapAnDung = dapAnDung;
        this.dapAnSai1 = dapAnSai1;
        this.dapAnSai2 = dapAnSai2;
        this.dapAnSai3 = dapAnSai3;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String getDapAnDung() {
        return dapAnDung;
    }

    public void setDapAnDung(String dapAnDung) {
        this.dapAnDung = dapAnDung;
    }

    public String getDapAnSai1() {
        return dapAnSai1;
    }

    public void setDapAnSai1(String dapAnSai1) {
        this.dapAnSai1 = dapAnSai1;
    }

    public String getDapAnSai2() {
        return dapAnSai2;
    }

    public void setDapAnSai2(String dapAnSai2) {
        this.dapAnSai2 = dapAnSai2;
    }

    public String getDapAnSai3() {
        return dapAnSai3;
    }

    public void setDapAnSai3(String dapAnSai3) {
        this.dapAnSai3 = dapAnSai3;
    }
}
