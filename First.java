import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class First {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 180);
        JPanel panel = new JPanel();
        JTextField num1Field = new JTextField(10);
        JTextField num2Field = new JTextField(10);
        JLabel resultLabel = new JLabel("Результат: ");
        JButton addButton = new JButton("Сложение");
        JButton subtractButton = new JButton("Вычитание");
        JButton multiplyButton = new JButton("Умножение");
        JButton divideButton = new JButton("Деление");

        panel.add(new JLabel("Первое число"));
        panel.add(num1Field);
        panel.add(new JLabel("Второе число"));
        panel.add(num2Field);
        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(divideButton);
        panel.add(resultLabel);
        frame.add(panel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    resultLabel.setText("Результат: " + (num1 + num2));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Неправильные данные");
                }
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    resultLabel.setText("Результат: " + (num1 - num2));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Неправильные данные");
                }
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    resultLabel.setText("Результат: " + (num1 * num2));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Неправильные данные");
                }
            }
        });

        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    if (num2 != 0) {
                        resultLabel.setText("Результат: " + (num1 / num2));
                    } else {
                        resultLabel.setText("Нельзя делить на 0");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Неправильные данные");
                }
            }
        });

        frame.setVisible(true);
    }
}
