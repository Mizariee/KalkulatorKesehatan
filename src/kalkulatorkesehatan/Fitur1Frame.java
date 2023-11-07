package kalkulatorkesehatan;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fitur1Frame extends JFrame {
    public Fitur1Frame() {
        
        setTitle("Kalkulator BMI");
        setSize(400, 400);
        setLocationRelativeTo(this);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panel header dengan label
        JPanel headerPanel = new JPanel();
        headerPanel.setPreferredSize(new Dimension(400, 50));
        JLabel titleLabel = new JLabel("Kalkulator BMI");
        titleLabel.setFont(new Font("Montserrat", Font.BOLD, 20));
        headerPanel.add(titleLabel);


        // Panel untuk tombol
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        formPanel.setSize(new Dimension(400, 350));
        formPanel.setBackground(new java.awt.Color(19, 32, 67));
           // Label dan teks field untuk berat
        JLabel beratLabel = new JLabel("Berat (kg):");
        JTextField beratTextField = new JTextField(10);

        // Label dan teks field untuk tinggi
        JLabel tinggiLabel = new JLabel("Tinggi (m):");
        JTextField tinggiTextField = new JTextField(10);

        // Tombol untuk menghitung BMI
        JButton hitungButton = new JButton("Hitung BMI");

        // Mengatur tata letak dengan GridBagLayout
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(beratLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(beratTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(tinggiLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(tinggiTextField, gbc);
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        formPanel.add(hitungButton, gbc);

        // Event listener untuk tombol hitung BMI
       hitungButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            double berat = Double.parseDouble(beratTextField.getText());
            double tinggi = Double.parseDouble(tinggiTextField.getText());
            double bmi = berat / (tinggi * tinggi);

            String message;
            Color backgroundColor;
            Color textColor;

            if (bmi < 18.5) {
                message = "BMI anda : " + bmi + " Berat badan kurang";
                backgroundColor = Color.RED; // Ganti warna latar belakang sesuai kekurangan
                textColor = Color.WHITE; // Ganti warna teks sesuai kekurangan
            } else if (bmi >= 18.5 && bmi < 25) {
                message = "BMI anda : " + bmi + " Berat badan ideal";
                backgroundColor = Color.GREEN; // Ganti warna latar belakang sesuai normal
                textColor = Color.BLACK; // Ganti warna teks sesuai normal
            } else if (bmi >= 25 && bmi <30) {
                message = "BMI anda : " + bmi + " Berat badan berlebih";
                backgroundColor = Color.ORANGE; // Ganti warna latar belakang sesuai berlebih
                textColor = Color.BLACK; // Ganti warna teks sesuai berlebih
            } else if (bmi >= 30 && bmi <= 39.9) {
                message = "BMI anda : " + bmi + " Berat badan sangat berlebih";
                backgroundColor = Color.ORANGE; // Ganti warna latar belakang sesuai berlebih
                textColor = Color.BLACK; // Ganti warna teks sesuai berlebih
            } else {
                message = "BMI anda : " + bmi + " Obesitas Lanjut";
                backgroundColor = Color.RED; // Ganti warna latar belakang sesuai obesitas
                textColor = Color.WHITE; // Ganti warna teks sesuai obesitas
            }

            UIManager.put("OptionPane.background", backgroundColor);
            UIManager.put("Panel.background", backgroundColor);
            UIManager.put("Button.background", Color.WHITE); // Mengubah warna latar belakang tombol
            UIManager.put("Button.foreground", Color.BLACK); // Mengubah warna teks tombol
            JOptionPane.showMessageDialog(null, message, "Hasil BMI", JOptionPane.INFORMATION_MESSAGE);

            // Mengembalikan warna latar belakang dan teks ke nilai default
            UIManager.put("OptionPane.background", UIManager.get("OptionPane.background"));
            UIManager.put("Panel.background", UIManager.get("Panel.background"));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Input harus berupa angka!");
        }
    }
});


        
        // STYLE HEADER //
        headerPanel.setBackground(new java.awt.Color(241, 180, 187));

        // Style text field
        Border textFieldBorder = new LineBorder(new java.awt.Color(241, 180, 187), 2); // Ganti warna dan ketebalan sesuai keinginan
        beratTextField.setBorder(textFieldBorder);
        tinggiTextField.setBorder(textFieldBorder);
        
        // Style text field font
        Font textFieldFont = new Font("Montserrat", Font.PLAIN, 12);
        beratTextField.setFont(textFieldFont);
        tinggiTextField.setFont(textFieldFont);
       
        
        // Style label
        Color labelColor = new java.awt.Color(241, 180, 187); // Ganti warna sesuai keinginan
        beratLabel.setForeground(labelColor);
        tinggiLabel.setForeground(labelColor);
        // Style label font
        Font labelFont = new Font("Montserrat", Font.BOLD, 12);
        beratLabel.setFont(labelFont);
        tinggiLabel.setFont(labelFont);

        // Style tombol
        hitungButton.setBackground(new java.awt.Color(241, 180, 187));
        hitungButton.setForeground(Color.BLACK);
        // Menambahkan border ke tombol
        Border buttonBorder = new LineBorder(new java.awt.Color(241, 180, 187), 2); // Ganti warna dan ketebalan sesuai keinginan
        hitungButton.setBorder(buttonBorder);
        // Mengatur font dan ukuran tombol
        Font buttonFont = new Font("Montserrat", Font.BOLD, 12);
        hitungButton.setFont(buttonFont);

        // Mengatur tata letak utama
        
        JPanel mainPanel = new JPanel(null); // Mengatur layout menjadi null
        mainPanel.setSize(getSize());
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // Mengatur layout utama menjadi BoxLayout dengan sumbu Y
        mainPanel.add(headerPanel);
        mainPanel.add(formPanel);
        add(mainPanel);
}
// Menjalankan closeFrame() ketika tombol close di klik





}
