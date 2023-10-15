package lesson04;

import java.util.Scanner;

public class Lesson04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вводите положительные целые числа");
        int userInput;
        int sum=0;
        int count=0;
        int max=0;
        while (scanner.hasNextInt() && ((userInput = scanner.nextInt()) > 0)) {
            sum +=userInput;
            count++;
            if(max<userInput) {
                max=userInput;
            }

        }if (count>0 ) System.out.println((double) sum/count);
        System.out.println(count);
        System.out.println(max);

        for (int i=0; i<=6; i++) {

        }
    }


}
