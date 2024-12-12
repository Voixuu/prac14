import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Second {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Информация");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 180);
        String[] countries = {"Австралия", "Китай", "Англия", "Россия"};
        JComboBox<String> countryBox = new JComboBox<>(countries);
        JLabel infoLabel = new JLabel("Выбор страны");

        countryBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCountry = (String) countryBox.getSelectedItem();
                if (selectedCountry != null) {
                    switch (selectedCountry) {
                        case "Австралия":
                            infoLabel.setText("Австралия: страна из Океании");
                            break;
                        case "Китай":
                            infoLabel.setText("Китай: самая населённая страна мира");
                            break;
                        case "Англия":
                            infoLabel.setText("Англия: Часть Соединенного Королевства(UK).");
                            break;
                        case "Россия":
                            infoLabel.setText("Россия: Самая большая страна");
                            break;
                    }
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(countryBox);
        panel.add(infoLabel);

        frame.add(panel);
        frame.setVisible(true);
    }
}
