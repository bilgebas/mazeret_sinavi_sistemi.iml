import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class hosgeldiniz_ekrani extends JFrame {
    private JButton adminButton;
    private JButton öğrenciBaşvuruSistemiButton;
    private JPanel panel1;
    private JButton adminPaneliButton;
    private JButton ogrenciisleriButton;

    public hosgeldiniz_ekrani() {
        add(panel1);
        setSize(500,400);
        setTitle("Hoşgeldiniz Ekranı");

        öğrenciBaşvuruSistemiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ogrenci_basvuru_sistemi o = new ogrenci_basvuru_sistemi();
                o.setVisible(true);

            }
        });
        adminPaneliButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                giris g = new giris();
                g.setVisible(true);

            }
        });
        ogrenciisleriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ogrenci_isleri ogr = new ogrenci_isleri();
                ogr.setVisible(true);
            }
        });
    }
}
