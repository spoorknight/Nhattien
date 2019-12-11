package fpoly.com.duan1.model;

import java.io.Serializable;

public class TaiKhoan implements Serializable {
    private String username;
    private String iduser;
    private String password;
    private String player;
    private String remember;

    public String getRemember() {
        return remember;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }

    public TaiKhoan(String username, String iduser, String password, String player, String remember) {
        this.username = username;
        this.iduser = iduser;
        this.password = password;
        this.player = player;
        this.remember = remember;
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

