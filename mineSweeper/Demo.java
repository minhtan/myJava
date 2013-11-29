public class Demo{   
  private MineMap mineMap;
  private VisibleMap visibleMap;
  private PrintMap printMap;

  public int demo(){
    int choice = -1;
    while(choice != 0){
      this.initMap();
      this.mineOption();

      this.visibleMap = new VisibleMap(this.mineMap);
      this.visibleMap.convertMap();

      System.out.println("Mine field:");
      printMap = new PrintMap(mineMap);
      printMap.print(MineMap.bombValue);

      System.out.println("Mine field with bomb's indicators:");
      printMap = new PrintMap(visibleMap);
      printMap.print(VisibleMap.bombValue);

      System.out.print("Input any number to continue, 0 to quit: ");
      choice = Validator.validateInt();
    }
    return -1;
  }

  public void initMap(){ 
      System.out.print("Enter the number of the field's row: ");
      int row = Validator.validateInt();
      System.out.print("Enter the number of the field's column: ");
      int column = Validator.validateInt();
      System.out.print("\n");
      this.mineMap = new MineMap(row, column);
  }

  private void mineOption(){
    System.out.println("How many mines do you want in the field?");
    System.out.println("1. I dont care");
    System.out.println("2. I will input the number");
    int mineChoice = Validator.validateChoice(1, 2);
    switch(mineChoice){
      case 1:
        this.mineMap.randomBase();
        break;
      case 2:
        System.out.print("How many? ");
        int totalBomb = Validator.validateInt(1, this.mineMap.getRow()*this.mineMap.getColumn());
        this.mineMap.randomBase(totalBomb);
        break;
      default:
        System.out.print("Error 101: Invalid choice");
        break;
    }
  }


}