import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

    public class ekran extends JFrame {

        private JPanel contentPane;
        private JTable table;

        DefaultTableModel modelim = new DefaultTableModel();

        Object[] kolonlar = {"ogrenci_tc","ogrenci_adi","ogrenci_soyad","ogrenci_no","ogrenci_fakulte","ogrenci_bolum","ogrenci_sinif","sinav_adi","ogretim_gorevlisi","ders_kodu"};
        Object[] satirlar = new Object [500];

        /**
         * Launch the application.
         */
        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        ekran frame = new ekran();
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
        public ekran() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 1123, 651);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);


            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBounds(10, 49, 940, 424);
            contentPane.add(scrollPane);

            table = new JTable();
            //table.setModel(modelim);
            modelim.setColumnIdentifiers(kolonlar);
            table.setBounds(158, 219, 256, 123);
            scrollPane.setViewportView(table);

            JButton btnListele = new JButton("Listele");
            btnListele.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        ResultSet myRs = Main.yap();
                        while(myRs.next()) {
                            satirlar[0] = myRs.getString("ogrenci_tc");
                            satirlar[1] = myRs.getString("ogrenci_adi");
                            satirlar[2] = myRs.getString("ogrenci_soyad");
                            satirlar[3] = myRs.getString("ogrenci_no");
                            satirlar[4] = myRs.getString("ogrenci_fakulte");
                            satirlar[5] = myRs.getString("ogrenci_bolum");
                            satirlar[6] = myRs.getString("ogrenci_sinif");
                            satirlar[7] = myRs.getString("sinav_adi");
                            satirlar[8] = myRs.getString("ogretim_gorevlisi");
                            satirlar[9]=myRs.getString("ders_kodu");
                            modelim.addRow(satirlar);}}
                    catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                    table.setModel(modelim);
                }
            });
            btnListele.setBounds(107, 509, 178, 21);
            contentPane.add(btnListele);

            //JButton btnGuncelle = new JButton("Güncelle");
		    //btnGuncelle.addActionListener(new ActionListener() {
            //public void actionPerformed(ActionEvent e) {


            }
      //  });
		//btnGuncelle.setBounds(339, 509, 178, 21);
		//contentPane.add(btnGuncelle);
    //}
    private JPanel panel1;
}
