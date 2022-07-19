import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ogrenci_basvuru_sistemi extends JFrame{
    private JTextField txt_tc;
    private JTextField txt_ad;
    private JTextField txt_soyad;
    private JTextField txt_no;
    private JTextField txt_fakulte;
    private JTextField txt_bolum;
    private JTextField txt_sınıf;
    private JTextField txt_ders;
    private JPanel panel2;
    private JButton gönderButton;
    private JTextField txt_sinavadi;
    private JTextField txt_gorevli;

    public ogrenci_basvuru_sistemi() {

        add(panel2);
        setTitle("Başvuru Ekranı");
        setSize(500,500);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        gönderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection c = null;

                try {
                    c = DriverManager.getConnection("jdbc:mariadb://localhost:3325/mazeret?user=root&password=2068");
                    PreparedStatement preparedStatement = c.prepareStatement(
                            "INSERT INTO ogrenci (ogrenci_tc,ogrenci_adi,ogrenci_no,ogrenci_bolum,ogrenci_fakulte,ogrenci_sinif,ogrenci_soyad)" +
                                    "VALUES(?,?,?,?,?,?,?)");
                    preparedStatement.setInt(1, Integer.parseInt(txt_tc.getText()));
                    preparedStatement.setString(2, txt_ad.getText());
                    preparedStatement.setInt(3, Integer.parseInt(txt_no.getText()));
                    preparedStatement.setString(4, txt_bolum.getText());
                    preparedStatement.setString(5, txt_fakulte.getText());
                    preparedStatement.setInt(6, Integer.parseInt(txt_sınıf.getText()));
                    preparedStatement.setString(7, txt_soyad.getText());
                    preparedStatement.executeQuery();
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                try{
                    c = DriverManager.getConnection("jdbc:mariadb://localhost:3325/mazeret?user=root&password=2068");
                    PreparedStatement preparedStatement1 = c.prepareStatement("INSERT INTO ders(sinav_adi,ogretim_gorevlisi,ogrenci_no,ders_kodu)"+"VALUES(?,?,?,?)");
                    preparedStatement1.setInt(3, Integer.parseInt(txt_no.getText()));
                    preparedStatement1.setString(1, txt_sinavadi.getText());
                    preparedStatement1.setString(2, txt_gorevli.getText());
                    preparedStatement1.setString(4, txt_ders.getText());
                    preparedStatement1.executeQuery();
                    preparedStatement1.close();

                }catch(SQLException ex){
                    ex.printStackTrace();

                }
            }
});
    }}
