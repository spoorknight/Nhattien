package fpoly.com.duan1.model;

public class XepHang {
    private String diem,player;

    public XepHang(String diem, String player) {
        this.diem = diem;
        this.player = player;
    }

    public String getDiem() {
        return diem;
    }

    public void setDiem(String diem) {
        this.diem = diem;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }
}
