import java.sql.*;

public class Main {

    static Connection c;
    static Statement st;
    static ResultSet rs;
    static Connection c1;
    static Statement st1;
    static ResultSet rs1;

    public static void main(String[] args) throws SQLException {
        try{
            c = DriverManager.getConnection("jdbc:mariadb://localhost:3325/mazeret?user=root&password=2068");
            st = c.createStatement();
            rs = st.executeQuery("SELECT * FROM ogrenci");

            while (rs.next()) {
                System.out.println(rs.getInt("ogrenci_tc"));
                System.out.println(rs.getString("ogrenci_adi"));
                System.out.println(rs.getString("ogrenci_soyad"));
                System.out.println(rs.getInt("ogrenci_no"));
                System.out.println(rs.getString("ogrenci_fakulte"));
                System.out.println(rs.getString("ogrenci_bolum"));
                System.out.println(rs.getInt("ogrenci_sinif"));


            }
            PreparedStatement preparedStatement = c.prepareStatement(
                    "INSERT INTO ogrenci (ogrenci_tc,ogrenci_adi,ogrenci_no,ogrenci_bolum,ogrenci_fakulte,ogrenci_sinif,ogrenci_soyad)" +
                            "VALUES(?,?,?,?,?,?,?)"
            );
            preparedStatement.setInt(1,1);

        }catch (Exception e){
            System.out.println("Error");
        }

        try{
            c1 = DriverManager.getConnection("jdbc:mariadb://localhost:3325/mazeret?user=root&password=2068");
            st1 = c1.createStatement();
            rs1 = st1.executeQuery("SELECT * FROM ders");

            while (rs1.next()) {

                System.out.println(rs1.getInt("ogrenci_no"));
                System.out.println(rs1.getString("sinav_adi"));
                System.out.println(rs1.getString("ogretim_gorevlisi"));
                System.out.println(rs1.getInt("ders_kodu"));



            }
            PreparedStatement preparedStatement1 = c1.prepareStatement(
                    "INSERT INTO ders (sinav_adi,ogretim_gorevlisi,ogrenci_no,ders_kodu)" +
                            "VALUES(?,?,?)" //1yıldız ekledim
            );
            preparedStatement1.setInt(1,1);

        }catch (Exception e){
            System.out.println("Error");
        }

        hosgeldiniz_ekrani h = new hosgeldiniz_ekrani();
        h.setVisible(true);
    }

    static Connection myConn;
    static Statement myStat;
    static Connection myConn1;
    static Statement myStat1;

    static ResultSet yap() {
        ResultSet myRs = null;
        try {
            myConn = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3325/mazeret","root","2068");
            myStat = (Statement) myConn.createStatement();
            myRs = myStat.executeQuery("SELECT * FROM ogrenci INNER JOIN ders ON ogrenci.ogrenci_no = ders.ogrenci_no");


        }

        catch (Exception e) {

            e.printStackTrace();
        }

        return myRs;

    }
    static ResultSet yap1() {
        ResultSet myRs1 = null;
        try {
            myConn1 = (Connection) DriverManager.getConnection("jdbc:mariadb://localhost:3325/mazeret","root","2068");
            myStat1 = (Statement) myConn1.createStatement();
            myRs1 = myStat1.executeQuery("SELECT * FROM VIEW1");

        }

        catch (Exception e) {

            e.printStackTrace();
        }

        return myRs1;

    }

    static ResultSet sorgula(String sql_sorgu) {

        ResultSet myRs = null;

        try {

            myRs = myStat.executeQuery(sql_sorgu);
        }
        catch (SQLException e) {

            e.printStackTrace();
        }

        return myRs;
    }

}
