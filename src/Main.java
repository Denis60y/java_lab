//
//██████╗ ██╗████████╗████████╗ ██████╗ ███╗   ██╗
//██╔══██╗██║╚══██╔══╝╚══██╔══╝██╔═══██╗████╗  ██║
//██████╔╝██║   ██║      ██║   ██║   ██║██╔██╗ ██║
//██╔═══╝ ██║   ██║      ██║   ██║   ██║██║╚██╗██║
//██║     ██║   ██║      ██║   ╚██████╔╝██║ ╚████║
//╚═╝     ╚═╝   ╚═╝      ╚═╝    ╚═════╝ ╚═╝  ╚═══╝
//        [ codded by @Pitt0n ]
//


import java.util.Scanner;


public class Main {
    public static int[] sort(int[] masiv, int size){
        for(int i = 0; i < size;i++){
            int min = i;
            for(int j = i; j < size;j++){
                if(masiv[j] < masiv[min]){
                    min = j;
                }
            }
            int p = masiv[i];
            masiv[i] = masiv[min];
            masiv[min] = p;
        }
        return masiv;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        final int SIZE = scanner.nextInt();

        int[] masiv = new int[SIZE];

        for(int i = 0; i < SIZE; i++){
            System.out.print("Введите число в массив: ");
            masiv[i] = scanner.nextInt();
        }

        sort(masiv, SIZE);

        System.out.print("Отсортированный массив: ");
        for(int i = 0; i < SIZE;i++){
            System.out.print(masiv[i] + " ");
        }
    }
}