package Lab_2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Task1 {
    public static String distance(int A, int B, int fuel, int volume) {

        int pipa = A * fuel;

        //остатки топлива после первого перлёта
        int remainingFuel = volume - pipa;

        if (remainingFuel < 0)
            return "Топлива не хватит до пункта B!";

        //сколько топлива потребуется для второго перелёта
        int requiredFuel = B * fuel;

        int popa = requiredFuel - remainingFuel;

        if (requiredFuel > volume)
            return "Емкости бака недостаточно для дозаправки!";
        else if (requiredFuel + pipa <= volume)
            return "Дозаправка не требуется!";
        else
            return String.format("Требуемый объем топлива %s литров!", popa);
    }

    public static void main(String[] args) {
        SimpleGUI app = new SimpleGUI();
        app.setVisible(true);
    }
}

class SimpleGUI extends JFrame {
    private JButton     button = new JButton("Расчёт");
    private JTextField  input1 = new JTextField("", 10);
    private JTextField  input2 = new JTextField("", 10);
    private JTextField  input3 = new JTextField("", 10);
    private JLabel      label1 = new JLabel("Расстояние от пункта A до пункта B (в километрах):");
    private JLabel      label2 = new JLabel("Расстояние от пункта B до пункта C (в километрах):");
    private JLabel      label3 = new JLabel("Вес груза (в килограммах):");

    private final int   VOLUME = 300;
    private final int[] FUEL_RATES = {1, 4, 7, 9};
    private final int[] WEIGHT_LIMITS = {0, 500, 1000, 1500, 2000};

    public SimpleGUI() {
        super("Доставка груза");
        this.setBounds(700, 400, 500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(5, 2, 10, 10));
        container.add(label1);
        container.add(input1);
        container.add(label2);
        container.add(input2);
        container.add(label3);
        container.add(input3);

        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String popa1 = input1.getText();
            String popa2 = input2.getText();
            String popa3 = input3.getText();
            String message = "";
            int fuel = 0;

            try {
                int distance1 = Integer.parseInt(popa1);
                int distance2 = Integer.parseInt(popa2);
                int cargoWeight = Integer.parseInt(popa3);

                if (cargoWeight > 2000 || cargoWeight < 0 || distance1 < 0 || distance2 < 0) {
                    message = "ERROR";
                } else {
                    for (int i = 1; i < WEIGHT_LIMITS.length; i++) {
                        if (cargoWeight <= WEIGHT_LIMITS[i] && cargoWeight > WEIGHT_LIMITS[i - 1]) {
                            fuel = FUEL_RATES[i - 1];
                        }
                    }
                    System.out.println(fuel);
                    message = Task1.distance(distance1, distance2, fuel, VOLUME);
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                message = "ERROR";
            }
            JOptionPane.showMessageDialog(null, message, "output", JOptionPane.PLAIN_MESSAGE);
        }
    }
}