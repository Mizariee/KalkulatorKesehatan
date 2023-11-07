package kalkulatorkesehatan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Fitur3Frame extends JFrame {
    public Fitur3Frame() {
        setTitle("Kalkulator Usia Kehamilan Ibu");
        setSize(400, 400);
        setLocationRelativeTo(this);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panel header dengan label
        JPanel headerPanel = new JPanel();
        headerPanel.setPreferredSize(new Dimension(400, 50));
        JLabel titleLabel = new JLabel("Kalkulator Usia Kehamilan Ibu");
        titleLabel.setFont(new Font("Montserrat", Font.BOLD, 20));
        headerPanel.add(titleLabel);

        // Panel untuk perhitungan usia kehamilan
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        formPanel.setSize(new Dimension(400, 350));
        formPanel.setBackground(new java.awt.Color(19, 32, 67));
        // Keterangan
        JLabel keterangan = new JLabel("Format dd/MM/yyyy");
        keterangan.setFont(new Font("Montserrat", Font.BOLD, 10));
        keterangan.setForeground(new java.awt.Color(255, 255, 255));
        // Label dan teks field untuk HPHT (Tanggal Terakhir Menstruasi)
        JLabel hphtLabel = new JLabel("HPHT (Tanggal Terakhir Menstruasi) : ");
        JTextField hphtTextField = new JTextField(10);

        // Label untuk tanggal sekarang
        JLabel sekarangLabel = new JLabel("Tanggal Sekarang :");

        // Teks field untuk tanggal sekarang
        JTextField currentDateTextField = new JTextField(10);
        currentDateTextField.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        // Tombol untuk menghitung usia kehamilan
        JButton hitungButton = new JButton("Hitung Usia Kehamilan");

        // Mengatur tata letak dengan GridBagLayout
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;  
        formPanel.add(keterangan, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(hphtLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(hphtTextField, gbc);
        gbc.gridy = 3;
        formPanel.add(sekarangLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(currentDateTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        formPanel.add(hitungButton, gbc);

        // Event listener untuk tombol hitung usia kehamilan
        hitungButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String hphtText = hphtTextField.getText();
                    String currentDateText = currentDateTextField.getText();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate hphtDate = LocalDate.parse(hphtText, formatter);
                    LocalDate currentDate = LocalDate.parse(currentDateText, formatter);

                    // Hitung selisih antara tanggal HPHT dan tanggal sekarang
                    Period pregnancyAge = Period.between(hphtDate, currentDate);

                    // Tampilkan usia kehamilan dalam hari, bulan, dan tahun
                    String message = "Usia kehamilan: " + pregnancyAge.getYears() + " tahun, " +
                                    pregnancyAge.getMonths() + " bulan, " +
                                    pregnancyAge.getDays() + " hari";
                    // Style message
                    UIManager.put("OptionPane.background", new java.awt.Color(241, 180, 187));
                    UIManager.put("Panel.background", new java.awt.Color(241, 180, 187));
                    UIManager.put("OptionPane.messageFont", new Font("Montserrat", Font.BOLD, 12));
                    UIManager.put("OptionPane.messageForeground", new java.awt.Color(31, 65, 114));

                    JOptionPane.showMessageDialog(null, message, "Usia Kehamilan", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Terjadi kesalahan. Pastikan tanggal HPHT dan tanggal sekarang sudah diisi dengan format dd/MM/yyyy.");
                }
            }
        });
        // Pallete
        Color buttonColor = new java.awt.Color(31, 65, 114); // Ganti warna sesuai keinginan
        Color fontColorWhite = new java.awt.Color(255, 255, 255); // Ganti warna sesuai keinginan
        Font headerFont = new Font("Montserrat", Font.BOLD, 20);
        Color headerColor = new java.awt.Color(241, 180, 187);
        Font labelFont = new Font("Montserrat", Font.BOLD, 12);
        // STYLE HEADER //
        headerPanel.setBackground(headerColor);
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setFont(headerFont);
        // STYLE BUTTON //
        hitungButton.setBackground(buttonColor);
        hitungButton.setForeground(fontColorWhite);
        hitungButton.setFont(labelFont);
        // label
        hphtLabel.setForeground(fontColorWhite);
        sekarangLabel.setForeground(fontColorWhite);

        // Teks field
        hphtTextField.setBackground(fontColorWhite);
        hphtTextField.setForeground(buttonColor);
        hphtTextField.setFont(labelFont);
        currentDateTextField.setBackground(fontColorWhite);
        currentDateTextField.setForeground(buttonColor);
        currentDateTextField.setFont(labelFont);
        // Border teks field
        Border textFieldBorder = new LineBorder(headerColor, 2); // Ganti warna dan ketebalan sesuai keinginan
        hphtTextField.setBorder(textFieldBorder);
        currentDateTextField.setBorder(textFieldBorder);
        // Menambahkan border ke tombol
        Border buttonBorder = new LineBorder(headerColor, 2); // Ganti warna dan ketebalan sesuai keinginan
        hitungButton.setBorder(buttonBorder);



        // Mengatur tata letak utama
        JPanel mainPanel = new JPanel(null);
        mainPanel.setSize(getSize());
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(headerPanel);
        mainPanel.add(formPanel);
        add(mainPanel);
    }
}
