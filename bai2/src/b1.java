import java.util.Scanner;

public class b1{
    private String soTaiKhoan;
    private double soDu;
    private double giaoDich;

    public String getSoTaiKhoan(){
        return soTaiKhoan;
    }
    public void setSoTaiKhoan(String soTaiKhoan){
        this.soTaiKhoan = soTaiKhoan;
    }
    public Double getSoDu(){
        return soDu;
    }
    public void setSoDu(double soDu){
        this.soDu = soDu;
    }
    public double getGiaoDich(){
        return giaoDich;
    }
    public void setGiaoDich(double giaoDich){
        this.giaoDich = giaoDich;
    }
    public void nhap(){
        Scanner cs = new Scanner(System.in);
        System.out.print("nhap so tai khoan: ");
        setSoTaiKhoan(cs.nextLine());

        System.out.print("nhap so du: ");
        setSoDu(cs.nextDouble()); cs.nextLine();

        System.out.print("nhap giao dich: ");
        setGiaoDich(cs.nextDouble()); cs.nextLine();
    }
    public void xuat(){
        System.out.println("so tai khoan: " + getSoTaiKhoan());
        System.out.println("so du: " +getSoDu());
        System.out.println("giao dich: " +getGiaoDich());
    }

}