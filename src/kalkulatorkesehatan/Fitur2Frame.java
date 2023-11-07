package kalkulatorkesehatan;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fitur2Frame extends JFrame {
    public Fitur2Frame() {
        setTitle("Kalkulator Kalori Harian");
        setSize(400, 400);
        setLocationRelativeTo(this);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panel header dengan label
        JPanel headerPanel = new JPanel();
        headerPanel.setPreferredSize(new Dimension(400, 50));
        JLabel titleLabel = new JLabel("Kalkulator Kalori Harian");
        titleLabel.setFont(new Font("Montserrat", Font.BOLD, 20));
        headerPanel.add(titleLabel);

        // Panel untuk perhitungan kalori harian
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setSize(new Dimension(400, 350));
        formPanel.setBackground(new java.awt.Color(19, 32, 67));

        // Label dan teks field untuk berat badan
        JLabel beratLabel = new JLabel("Berat Badan (kg) :");
        JTextField beratTextField = new JTextField(10);

        // Label dan teks field untuk tinggi
        JLabel tinggiLabel = new JLabel("Tinggi (cm) :");
        JTextField tinggiTextField = new JTextField(10);

        // Label dan teks field untuk usia
        JLabel usiaLabel = new JLabel("Usia :");
        JTextField usiaTextField = new JTextField(10);

        // Label dan combobox untuk jenis kelamin
        JLabel jenisKelaminLabel = new JLabel("Jenis Kelamin :");
        String[] jenisKelaminOptions = {"Pria", "Wanita"};
        JComboBox<String> jenisKelaminComboBox = new JComboBox<>(jenisKelaminOptions);

        // Label dan combobox untuk tingkat aktivitas
        JLabel aktivitasLabel = new JLabel("Tingkat Aktivitas :");
        String[] aktivitasOptions = {"Sangat Ringan", "Ringan", "Sedang", "Berat", "Sangat Berat"};
        JComboBox<String> aktivitasComboBox = new JComboBox<>(aktivitasOptions);

        // Tombol untuk menghitung kalori harian
        JButton hitungButton = new JButton("Hitung Kalori Harian");

        // Mengatur tata letak dengan GridBagLayout
         GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

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
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(usiaLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(usiaTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(jenisKelaminLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(jenisKelaminComboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(aktivitasLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(aktivitasComboBox, gbc);
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        formPanel.add(hitungButton, gbc);

        // Event listener untuk tombol hitung kalori harian
        hitungButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double berat = Double.parseDouble(beratTextField.getText());
                    double tinggi = Double.parseDouble(tinggiTextField.getText());
                    int usia = Integer.parseInt(usiaTextField.getText());
                    String jenisKelamin = (String) jenisKelaminComboBox.getSelectedItem();
                    String tingkatAktivitas = (String) aktivitasComboBox.getSelectedItem();

                    // Hitung kalori harian berdasarkan rumus yang sesuai
                    double kaloriHarian = 0.0;

                    if (jenisKelamin.equals("Pria")) {
                        // Rumus kalori harian untuk pria
                        kaloriHarian = 88.362 + (13.397 * berat) + (4.799 * tinggi) - (5.677 * usia);
                    } else if (jenisKelamin.equals("Wanita")) {
                        // Rumus kalori harian untuk wanita
                        kaloriHarian = 447.593 + (9.247 * berat) + (3.098 * tinggi) - (4.330 * usia);
                    }

                    // Menyesuaikan kalori berdasarkan tingkat aktivitas
                    if (tingkatAktivitas.equals("Sangat Ringan")) {
                        kaloriHarian *= 1.2;
                    } else if (tingkatAktivitas.equals("Ringan")) {
                        kaloriHarian *= 1.375;
                    } else if (tingkatAktivitas.equals("Sedang")) {
                        kaloriHarian *= 1.55;
                    } else if (tingkatAktivitas.equals("Berat")) {
                        kaloriHarian *= 1.725;
                    } else if (tingkatAktivitas.equals("Sangat Berat")) {
                        kaloriHarian *= 1.9;
                    }
                    //Style Message Box
                    UIManager.put("OptionPane.background", new java.awt.Color(19, 32, 67));
                    UIManager.put("Panel.background", new java.awt.Color(19, 32, 67));
                    UIManager.put("OptionPane.messageForeground", new java.awt.Color(255, 255, 255));
                    UIManager.put("Button.background", new java.awt.Color(241, 180, 187));
                    UIManager.put("Button.foreground", new java.awt.Color(0, 0, 0));

                    // Massege box untuk menampilkan hasil
                    JOptionPane.showMessageDialog(null, "Kalori harian anda : " + kaloriHarian+"/Kkal");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input harus berupa angka!");
                }
            }
        });

        // Pallete
        Color buttonColor = new java.awt.Color(31, 65, 114); // Ganti warna sesuai keinginan
        Color fontColorWhite = new java.awt.Color(255, 255, 255); // Ganti warna sesuai keinginan

        // Sesuaikan warna dan gaya sesuai keinginan
        headerPanel.setBackground(new java.awt.Color(241, 180, 187));
        titleLabel.setForeground(Color.BLACK);
        // STYLE label
        beratLabel.setForeground(fontColorWhite);
        tinggiLabel.setForeground(fontColorWhite);
        usiaLabel.setForeground(fontColorWhite);
        jenisKelaminLabel.setForeground(fontColorWhite);
        aktivitasLabel.setForeground(fontColorWhite);
        // Label font
        Font labelFont = new Font("Montserrat", Font.BOLD, 12);
        beratLabel.setFont(labelFont);
        tinggiLabel.setFont(labelFont);
        usiaLabel.setFont(labelFont);
        jenisKelaminLabel.setFont(labelFont);
        aktivitasLabel.setFont(labelFont);
        // STYLE text field
        Border textFieldBorder = new LineBorder(new java.awt.Color(241, 180, 187), 2); // Ganti warna dan ketebalan sesuai keinginan
        beratTextField.setBorder(textFieldBorder);
        tinggiTextField.setBorder(textFieldBorder);
        usiaTextField.setBorder(textFieldBorder);
        // Text field font
        Font textFieldFont = new Font("Montserrat", Font.PLAIN, 12);
        beratTextField.setFont(textFieldFont);
        tinggiTextField.setFont(textFieldFont);
        usiaTextField.setFont(textFieldFont);
        // STYLE combobox
        jenisKelaminComboBox.setBackground(buttonColor);
        jenisKelaminComboBox.setForeground(fontColorWhite);
        aktivitasComboBox.setBackground(buttonColor);
        aktivitasComboBox.setForeground(fontColorWhite);
        // Combobox font
        Font comboBoxFont = new Font("Montserrat", Font.PLAIN, 12);
        jenisKelaminComboBox.setFont(comboBoxFont);
        aktivitasComboBox.setFont(comboBoxFont);
        // STYLE tombol
        hitungButton.setBackground(new java.awt.Color(241, 180, 187));
        hitungButton.setForeground(Color.BLACK);
        // Mengatur tata letak utama
        JPanel mainPanel = new JPanel(null);
        mainPanel.setSize(getSize());
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(headerPanel);
        mainPanel.add(formPanel);
        add(mainPanel);
    }
}
