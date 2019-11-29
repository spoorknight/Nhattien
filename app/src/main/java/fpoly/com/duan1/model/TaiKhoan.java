package fpoly.com.duan1.model;

public class TaiKhoan {
    public String username;
    public String iduser;
    public String password;
    public String player;

    public TaiKhoan(String username, String iduser, String password, String player) {
        this.username = username;
        this.iduser = iduser;
        this.password = password;
        this.player = player;
    }

    public TaiKhoan(String username, String password, String player) {
        this.username = username;
        this.password = password;
        this.player = player;
    }

    public TaiKhoan() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }
}

