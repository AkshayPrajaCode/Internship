import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGAME {

    public static void main(String[] args) {
      int number , answer;
        do{
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter the number");
        number= scanner.nextInt();
        Random random =new Random();
        answer= random .nextInt(100-1)+1;


        if (number>answer) {
            System.out.println("too High, try again "+String.valueOf(answer));
            
        }
       else if(number<answer){
            System.out.println("Too low , please try again " + String.valueOf(answer));
        }
        if (number==answer) {
            System.out.println("Correct Answer");
            
        }

      } 
      while(number!=answer) ;
    }
}