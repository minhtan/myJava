public class Console{  
  private MineMap mineMap;
  private VisibleMap visibleMap;
  private PrintMap printMap;
  private Play play;

  public Console(){
    this.printMap = new PrintMap();
    this.mineMap = new MineMap();
    this.visibleMap = new VisibleMap();
    this.play = new Play();
  }

  public static void main(String [] args) {
    Console csl = new Console();
    int choice = -1;
    while(choice != 3){
      System.out.println("Welcome to mine sweeper:");
      System.out.println("1. Demo");
      System.out.println("2. Play");
      System.out.println("3. Quit");
      choice = Validator.validateChoice(1, 3);
      switch(choice){
        case 1:
          choice = csl.demo();
          break;
        case 2:
          choice = csl.play();
          break;
        case 3:
          break;
        default:
          System.out.print("Error 101: Invalid choice");
          break;
      }
    }
    return;
  }

  private int demo(){
    this.initMap();
    this.mineOption();

    System.out.println("Mine field:");
    this.printMap.setMap(this.mineMap);
    this.printMap.print(this.mineMap.getBombValue(), true);

    System.out.println("Mine field with bomb's indicators:");
    this.printMap.setMap(this.visibleMap);
    this.printMap.print(this.visibleMap.getBombValue(), true);

    return -1;
  }

  private int play(){
    this.initMap();
    this.mineOption();
    int row = 0;
    int col = 0; 

    System.out.println("Mine field with bomb's indicators:");
	  this.printMap.setMap(this.visibleMap);
    this.printMap.print(this.visibleMap.getBombValue(), false);
	
	  boolean checkBomb=true;
    while(checkBomb){
	    boolean checkMark=true;
      while(checkMark){
        System.out.print("Choose a row: ");
        row = Validator.validateInt(1, this.visibleMap.getRow());
        System.out.print("And a column: ");
        col = Validator.validateInt(1, this.visibleMap.getColumn());
        checkMark = this.play.checkMark(row-1, col-1);
        if(checkMark)
          System.out.print("That combination of row and column is already choosen, choose another combination please.");
      }
	  
      checkBomb = this.play.checkNotBomb(row-1, col-1);
	  
      System.out.println("Play field:");
	    this.printMap.print(this.visibleMap.getBombValue(), false);
	  
      if(checkBomb == false){
        System.out.println("Too bad, that was a bomb :)");
        break;
      }

    }
    return -1;
  }

  private void initMap(){ 
      System.out.print("Enter the number of the field's row: ");
      int row = Validator.validateInt();
      System.out.print("Enter the number of the field's column: ");
      int column = Validator.validateInt();
      System.out.print("\n");
      this.mineMap.setMap(row, column);
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
        int maxBomb = Validator.validateInt(1, this.mineMap.getRow()*this.mineMap.getColumn());
        this.mineMap.randomBase(maxBomb);
        break;
      default:
        System.out.print("Error 101: Invalid choice");
        break;
    }
    this.visibleMap.setMap(this.mineMap);
    this.visibleMap.convertMap();
    this.play.setPlay(this.visibleMap);
    this.printMap.setPlayMap(this.play.getPlayMap());
  }

}
