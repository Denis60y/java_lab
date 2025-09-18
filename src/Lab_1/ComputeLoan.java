package Lab_1;

import java.util.Scanner;

public class ComputeLoan {
    public static void main(String[] args) {
        final int MONTHS_PER_YEAR = 12; // 1 год содержит 12 месяцев

        double annualInterestRate; // ежегодная ставка в %
        int numberOfYears; // срок кредита в годах
        double loanAmount; // сумма кредита в рублях

        double monthlyInterestRate; // ежемесячная ставка в долях единицы

        double monthlyPayment; // ежемесячный платеж в рублях
        double totalPayment; // стоимость кредита в рублях

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ежегодную ставку по кредиту в %, например, 8,25: ");
        annualInterestRate = scanner.nextDouble();

        System.out.print("Введите срок кредита в годах, например, 5: ");
        numberOfYears = scanner.nextInt();

        System.out.print("Введите сумму кредита в рублях, например, 120000.95: ");
        loanAmount = scanner.nextDouble();

        monthlyInterestRate = annualInterestRate / 12 / 100;
        monthlyPayment = loanAmount * monthlyInterestRate /
                (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * MONTHS_PER_YEAR));
        totalPayment = monthlyPayment * numberOfYears * MONTHS_PER_YEAR;

        System.out.println("Ежемесячный платеж равен " + (int)(monthlyPayment * 100) / 100.0 + " руб ");
        System.out.println("Ежемесячный кредита равна " + (int)(totalPayment * 100) / 100.0 + " руб ");
    }
}
