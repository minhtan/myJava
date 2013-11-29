import java.util.Scanner;
public class Validator{   
  static Scanner sc = new Scanner(System.in);

  static int validateChoice(int min, int max){
    int input = -1;
    while(input<min || input>max){
      System.out.print("Your choice: ");
      input = validateInt();
    }
    return input;
  }

  static int validateInt(){
    try {
      int input = Integer.parseInt(sc.nextLine());
      return input;
    }catch (NumberFormatException e) {
      System.out.print("Error 102: Invalid data format, try input an interger :) ");
      int input = validateInt();
      return input;
    }
  }

  static int validateInt(int min, int max){
    try {
      int input = Integer.parseInt(sc.nextLine());
      while(input<min || input>max){
      	System.out.print("The input value must be between "+min+" and "+max+" ,please re-enter the input: ");
      	input = Integer.parseInt(sc.nextLine());
      }
      return input;
    }catch (NumberFormatException e) {
      System.out.print("Error 102: Invalid data format, try input an interger :) ");
      int input = validateInt(min, max);
      return input;
    }
  }
}