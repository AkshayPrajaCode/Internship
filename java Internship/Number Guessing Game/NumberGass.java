import java.util.Random;
import java.util.Scanner;;

public class NumberGass {
    public static void main(String[] args) {
        Game g = new Game();
        boolean b=false;

        while (!b) {
            g.takeInput();

           b = g.isCorrectNumber();
            System.out.println(b);  
        }
       
    }
}

class Game {
    private int number;
    private int noOfGuesses =0;
    private int inputNumber;

    public int getNoOfGuesses() {
        return noOfGuesses;
    }

    public void setNoOfGuesses(int noOfGuesses) {
        this.noOfGuesses = noOfGuesses;
    }

    Game() {
        Random random = new Random();
        this.number = random.nextInt(100);
    }

    public void takeInput() {
        System.out.println("Please Enter the Number");
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();
        this.inputNumber = inputNumber; // Set the instance variable with the local variable
    }

    public boolean isCorrectNumber() {
        noOfGuesses++;
        if (inputNumber == number) {
            System.out.println("NO of attempt " +noOfGuesses);
            return true;
        } else if (inputNumber > number) {
            System.out.println("Too high");
        } else if (inputNumber < number) {
            System.out.println("Too low");
        }
        return false;
    }
}
