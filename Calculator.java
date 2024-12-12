import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JFrame frame;
    private JTextField textField;
    private StringBuilder currentInput;
    private double result;
    private String operator;

    public Calculator() {
        frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.BOLD, 24));

        currentInput = new StringBuilder();
        operator = "";
        result = 0;

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        frame.setLayout(new BorderLayout());
        frame.add(textField, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = ((JButton) e.getSource()).getText();

            if (command.matches("[0-9\\.]") || command.equals("0")) {
                currentInput.append(command);
                textField.setText(currentInput.toString());
            } else if (command.equals("=")) {
                if (!operator.isEmpty() && currentInput.length() > 0) {
                    double secondOperand = Double.parseDouble(currentInput.toString());
                    switch (operator) {
                        case "+":
                            result += secondOperand;
                            break;
                        case "-":
                            result -= secondOperand;
                            break;
                        case "*":
                            result *= secondOperand;
                            break;
                        case "/":
                            if (secondOperand != 0) {
                                result /= secondOperand;
                            } else {
                                textField.setText("Нельзя делить на 0");
                                currentInput.setLength(0);
                                return;
                            }
                            break;
                    }
                    textField.setText(String.valueOf(result));
                    currentInput.setLength(0);
                }
            } else {
                if (currentInput.length() > 0) {
                    if (operator.isEmpty()) {
                        result = Double.parseDouble(currentInput.toString());
                    } else {
                        double secondOperand = Double.parseDouble(currentInput.toString());
                        switch (operator) {
                            case "+":
                                result += secondOperand;
                                break;
                            case "-":
                                result -= secondOperand;
                                break;
                            case "*":
                                result *= secondOperand;
                                break;
                            case "/":
                                if (secondOperand != 0) {
                                    result /= secondOperand;
                                } else {
                                    textField.setText("Нельзя делить на 0");
                                    currentInput.setLength(0);
                                    return;
                                }
                                break;
                        }
                    }
                    operator = command;
                    currentInput.setLength(0);
                    textField.setText(String.valueOf(result));
                }
            }
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
