import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            {
                System.out.println("Enter the First Number");
                int inputFirstNumber = scanner.nextInt();

                System.out.println("1: Add");
                System.out.println("2: Subtract");
                System.out.println("3: Multiplication");
                System.out.println("4: Division");
                System.out.println("Choose Operation ");
                int Operation = scanner.nextInt();
                System.out.println("Enter the Second  Number");
                int inputSecondNumber = scanner.nextInt();
                int result;
                switch (Operation) {
                    case 1:
                        result = inputFirstNumber + inputSecondNumber;
                        System.out.println("Result is :" + result);
                        ;
                        break;

                    case 2:
                        result = inputFirstNumber - inputSecondNumber;
                        System.out.println("Result is :" + result);

                        break;
                    case 3:
                        result = inputFirstNumber * inputSecondNumber;
                        System.out.println("Result is :" + result);

                        break;
                    case 4:
                        result = inputFirstNumber / inputSecondNumber;
                        System.out.println("Result is :" + result);

                        break;
                }

            }
        }
    }
}