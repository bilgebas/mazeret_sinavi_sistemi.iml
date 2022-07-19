import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ekran1 extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JButton btnListele1;
   private JTextField txt_ogrislerikullaniciadi;
    private JTextField txt_ogrislerisifre;

    DefaultTableModel modelim1 = new DefaultTableModel();

    Object[] kolonlar1 = {"ogrenci_tc","ogrenci_adi","ogrenci_soyad","ogrenci_no","ogrenci_fakulte","ogrenci_bolum","ogrenci_sinif","sinav_adi","ogretim_gorevlisi","ders_kodu"};
    Object[] satirlar1 = new Object [500];
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
    public ekran1() {
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
        modelim1.setColumnIdentifiers(kolonlar1);
        table.setBounds(158, 219, 256, 123);
        scrollPane.setViewportView(table);

        JButton btnListele1 = new JButton("Listele");
        btnListele1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    ResultSet myRs1 = Main.yap1();
                    while(myRs1.next()) {
                        satirlar1[0] = myRs1.getString("ogrenci_tc");
                        satirlar1[1] = myRs1.getString("ogrenci_adi");
                        satirlar1[2] = myRs1.getString("ogrenci_soyad");
                        satirlar1[3] = myRs1.getString("ogrenci_no");
                        satirlar1[4] = myRs1.getString("ogrenci_fakulte");
                        satirlar1[5] = myRs1.getString("ogrenci_bolum");
                        satirlar1[6] = myRs1.getString("ogrenci_sinif");
                        satirlar1[7] = myRs1.getString("sinav_adi");
                        satirlar1[8] = myRs1.getString("ogretim_gorevlisi");
                        satirlar1[9]=myRs1.getString("ders_kodu");
                        modelim1.addRow(satirlar1);}}
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                table.setModel(modelim1);
            }
        });
        this.btnListele1.setBounds(107, 509, 178, 21);
        contentPane.add(this.btnListele1);



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
