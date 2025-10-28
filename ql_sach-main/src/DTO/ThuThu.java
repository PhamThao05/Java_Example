package DTO;

public class ThuThu {
    private String ten_thu_thu;
    private String cmnd;
    private String sdt;
    private String email;
    private String password;
    private String phanQuyen; 

    public ThuThu() {
    }

    public String getTen_thu_thu() {
        return ten_thu_thu;
    }

    public void setTen_thu_thu(String ten_thu_thu) {
        this.ten_thu_thu = ten_thu_thu;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPhanQuyen() {
        return phanQuyen;
    }

    public void setPhanQuyen(String phanQuyen) {
        this.phanQuyen = phanQuyen;
    }

    public ThuThu(String ten_thu_thu, String cmnd, String sdt, String email, String password) {
        this.ten_thu_thu = ten_thu_thu;
        this.cmnd = cmnd;
        this.sdt = sdt;
        this.email = email;
        this.password = password;
    }
    
    public static class CTThuThu extends ThuThu{
        private int ma_thu_thu;

        public CTThuThu() {
        }

        public int getMa_thu_thu() {
            return ma_thu_thu;
        }

        public void setMa_thu_thu(int ma_thu_thu) {
            this.ma_thu_thu = ma_thu_thu;
        }

        public CTThuThu(int ma_thu_thu) {
            this.ma_thu_thu = ma_thu_thu;
        }

        public CTThuThu(int ma_thu_thu, String ten_thu_thu, String cmnd, String sdt, String email, String password) {
            super(ten_thu_thu, cmnd, sdt, email, password);
            this.ma_thu_thu = ma_thu_thu;
        } 
        
    }
    
}
