import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ogrenci_isleri extends JFrame {
    private JTextField txt_ogrisleriadi;
    private JTextField txt_ogrislerisifre;
    private JButton btnNewButton;
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel lblifre;

    static String ad;
    static String sifre;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ogrenci_isleri frame1 = new ogrenci_isleri();
                    frame1.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public ogrenci_isleri() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        txt_ogrisleriadi = new JTextField();
        txt_ogrisleriadi.setBounds(202, 65, 96, 19);
        contentPane.add(txt_ogrisleriadi);
        txt_ogrisleriadi.setColumns(10);

        JLabel lblNewLabel = new JLabel("Kullanıcı Adı :");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(59, 59, 116, 27);
        contentPane.add(lblNewLabel);

        JLabel lblifre = new JLabel("Şifre :");
        lblifre.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblifre.setBounds(59, 123, 116, 27);
        contentPane.add(lblifre);

        JButton btnNewButton = new JButton("Giriş");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ad = txt_ogrisleriadi.getText();
                sifre = txt_ogrislerisifre.getText();

                String sql_sorgu = "SELECT COUNT(ogrenciisleri_id) AS ogrenci_isleri FROM mazeret.ogrenciisleri WHERE ogrenciisleri_kullaniciadi='"+ad+"' AND ogrenciisleri_sifre='"+sifre+"'";
                ResultSet myRs = Main.yap();
                myRs = Main.sorgula(sql_sorgu);

                try {
                    while(myRs.next()){
                        if(myRs.getInt("ogrenci_isleri")==1) {
                            ekran ekr = new ekran();
                            ekr.setVisible(true);
                            setVisible(false);
                        } else { btnNewButton.setText("hatalı giriş yaptınız"); }
                    }
                }
                catch (SQLException e1) {

                    e1.printStackTrace();
                }

            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.setBounds(116, 208, 250, 32);
        contentPane.add(btnNewButton);

        txt_ogrislerisifre= new JTextField();
        txt_ogrislerisifre.setBounds(202, 129, 96, 19);
        contentPane.add(txt_ogrislerisifre);
        txt_ogrislerisifre.setColumns(10);
    }
}
