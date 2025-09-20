package Lab_2;

import java.util.Scanner;

public class Task1 {
    public static String distance(int A, int B, int fuel, int volume) {
        int remainingFuel = volume - A * fuel;

        if (remainingFuel < 0)
            return "Топлива не хватит до пункта B!";

        int requiredFuel = (B * fuel) - remainingFuel;

        if (requiredFuel > volume)
            return "Емкости бака недостаточно для дозаправки!";
        else if (requiredFuel <= 0)
            return "Дозаправка не требуется!";
        else
            return String.format("Требуемый объем топлива %s литров!", requiredFuel);
    }

    public static void main(String[] args) {
        final int VOLUME = 300;

        final int FUEL_PER_KM_IF_CARGO_LESS_500 = 1;
        final int FUEL_PER_KM_IF_CARGO_LESS_1000 = 4;
        final int FUEL_PER_KM_IF_CARGO_LESS_1500 = 7;
        final int FUEL_PER_KM_IF_CARGO_LESS_2000 = 9;

        int distance1, distance2, cargoWeight;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Расстояние от пункта A до пункта B (в километрах): ");
        distance1 = scanner.nextInt();
        System.out.print("Расстояние от пункта B до пункта C (в километрах): ");
        distance2 = scanner.nextInt();
        System.out.print("Вес груза (в килограммах): ");
        cargoWeight = scanner.nextInt();

        if (cargoWeight > 2000)
            System.out.println("ERROR");
        else if (cargoWeight <= 500)
            System.out.println(distance(distance1, distance2, FUEL_PER_KM_IF_CARGO_LESS_500, VOLUME));
        else if (cargoWeight > 500 && cargoWeight <= 1000)
            System.out.println(distance(distance1, distance2, FUEL_PER_KM_IF_CARGO_LESS_1000, VOLUME));
        else if (cargoWeight > 1000 && cargoWeight <= 1500)
            System.out.println(distance(distance1, distance2, FUEL_PER_KM_IF_CARGO_LESS_1500, VOLUME));
        else
            System.out.println(distance(distance1, distance2, FUEL_PER_KM_IF_CARGO_LESS_2000, VOLUME));
    }
}
