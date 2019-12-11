package fpoly.com.duan1.model;

public class DiemCao {
    private int soDiem;
    private String idUser;

    public DiemCao(int soDiem, String idUser) {
        this.soDiem = soDiem;
        this.idUser = idUser;
    }

    public int getSoDiem() {
        return soDiem;
    }

    public void setSoDiem(int soDiem) {
        this.soDiem = soDiem;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}
