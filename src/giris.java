import javax.swing.*;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

    public class giris extends JFrame {

        private JPanel contentPane;
        private JTextField txt_ad;
        private JTextField txt_sifre;
        private JLabel lblNewLabel;
        private JLabel lblifre;
        private JButton btnNewButton;

        static String ad;
        static String sifre;

        /**
         * Launch the application.
         */
        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        giris frame = new giris();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        /**
         * Create the frame.
         */
        public giris() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 450, 400);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            txt_ad = new JTextField();
            txt_ad.setBounds(202, 65, 96, 19);
            contentPane.add(txt_ad);
            txt_ad.setColumns(10);

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

                    ad = txt_ad.getText();
                    sifre = txt_sifre.getText();

                    String sql_sorgu = "SELECT COUNT(kullanici_id) AS giris FROM mazeret.admin WHERE kullanici_adi='"+ad+"' AND sifre='"+sifre+"'";
                    ResultSet myRs = Main.yap();
                    myRs = Main.sorgula(sql_sorgu);

                    try {
                        while(myRs.next()){
                            if(myRs.getInt("giris")==1) {
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

            txt_sifre = new JTextField();
            txt_sifre.setBounds(202, 129, 96, 19);
            contentPane.add(txt_sifre);
            txt_sifre.setColumns(10);
        }
    }
