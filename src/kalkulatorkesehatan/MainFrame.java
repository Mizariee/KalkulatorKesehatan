package kalkulatorkesehatan;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() {
       
        setTitle("Aplikasi Java Swing");
        setSize(400, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel header dengan label
        JPanel headerPanel = new JPanel();
        ImageIcon originalImage = new ImageIcon("C:\\Materi Kuliah\\semester 3\\Pemrograman Berbasis Object\\Projek PBO\\KalkulatorKesehatan\\asset\\image\\image.png"); // Ganti dengan path ke gambar Anda
        Image OriginalImage = originalImage.getImage();
        Image modifiedImage = OriginalImage.getScaledInstance(400, 120, java.awt.Image.SCALE_SMOOTH);
        ImageIcon resizeImage = new ImageIcon(modifiedImage);
        JLabel headerLabel = new JLabel(resizeImage);
        headerPanel.add(headerLabel);
        // Judul Fitur
        JLabel titleLabel = new JLabel("Kalkulator Kesehatan");
        JLabel pilih = new JLabel("Pilih Fitur : ");
        titleLabel.setFont(new Font("Montserrat", Font.BOLD, 20));
        pilih.setFont(new Font("Montserrat", Font.BOLD, 15));
       // Tombol untuk Fitur 1
JButton button1 = new JButton("Kalkulator BMI");
button1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      
            new Fitur1Frame().setVisible(true);
        }
        // ketika fitur1Frame ditutup, set isFiturAktif menjadi false
    
    });

// Tombol untuk Fitur 2
JButton button2 = new JButton("Kalkulator Kalori");
button2.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      
            new Fitur2Frame().setVisible(true);
         // ketika fitur2Frame ditutup, set isFiturAktif menjadi false
    }
});

// Tombol untuk Fitur 3
JButton button3 = new JButton("Usia Kehamilan");
button3.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
      
            new Fitur3Frame().setVisible(true);
        
    }
});



        // Pallete
        Color buttonColor = new java.awt.Color(31, 65, 114); // Ganti warna sesuai keinginan
        Color fontColorWhite = new java.awt.Color(255, 255, 255); // Ganti warna sesuai keinginan

        // STYLE HEADER //
        headerPanel.setBackground(new java.awt.Color(19, 32, 67));
        titleLabel.setForeground(fontColorWhite);
        pilih.setForeground(fontColorWhite);
      // STYLE BUTTON // 
        button1.setBackground(buttonColor);
        button2.setBackground(buttonColor);
        button3.setBackground(buttonColor);
        button1.setForeground(fontColorWhite);
        button2.setForeground(fontColorWhite);
        button3.setForeground(fontColorWhite);
        // Menambahkan border ke tombol
        Border buttonBorder = new LineBorder(new java.awt.Color(241, 180, 187), 2); // Ganti warna dan ketebalan sesuai keinginan
        button1.setBorder(buttonBorder);
        button2.setBorder(buttonBorder);
        button3.setBorder(buttonBorder);
        // Mengatur font dan ukuran tombol
        Font buttonFont = new Font("Montserrat", Font.BOLD, 12);
        button1.setFont(buttonFont);
        button2.setFont(buttonFont);
        button3.setFont(buttonFont);
        // Mengatur padding tombol dengan text
        Insets buttonInsets = new Insets(20, 20, 20, 20); // Ganti sesuai keinginan
        button1.setMargin(buttonInsets);
        button2.setMargin(buttonInsets);
        button3.setMargin(buttonInsets);
        
        
        // Panel untuk tombol
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        buttonPanel.setPreferredSize(new Dimension(400, 290));
        buttonPanel.setBackground(new java.awt.Color(19, 32, 67));

        gbc.fill = GridBagConstraints.HORIZONTAL; 
        gbc.insets = new Insets(10, 10, 10, 10); // Padding
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(titleLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        buttonPanel.add(pilih, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        buttonPanel.add(button1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        buttonPanel.add(button2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        buttonPanel.add(button3, gbc);

        // Footer
        JPanel footerPanel = new JPanel();
        footerPanel.setPreferredSize(new Dimension(400, 30));
        footerPanel.setBackground(new java.awt.Color(241, 180, 187));
        JLabel footerLabel = new JLabel("Created by : Kelompok Galih, Bertha, Gilang, Hasna");
        footerLabel.setFont(new Font("Montserrat", Font.BOLD, 10));
        footerPanel.add(footerLabel);
        // Mengatur tata letak utama
        JPanel mainPanel = new JPanel(null); // Mengatur layout menjadi null
        mainPanel.setSize(getSize());
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(headerPanel);
       // headerPanel.setBounds(0, 0, 400, 120); // Menempatkan headerPanel secara tepat
        mainPanel.add(buttonPanel);
        //buttonPanel.setBounds(0, 90, 400, 280); // Menempatkan buttonPanel secara tepat
        mainPanel.add(footerPanel);

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}