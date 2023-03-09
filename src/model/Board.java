package model;
import java.util.Random;

public class Board {
  private final int TOTAL_SNAKES_AND_LADDERS = 26;

    private Box head;
    private Box tail;
    private int rows;
    private int columns;
    private int numSnakes;
    private int numLadders;
    private int size;
    private Random random;

    //Constructor
    public Board(int rows, int columns, int numSnakes, int numLadders) {
        this.rows = rows;
        this.columns = columns;
        this.numSnakes = numSnakes;
        this.numLadders = numLadders;
        this.size = this.rows * this.columns;
        random = new Random();
        initBoard(this.size);
        establishSnakes(0, 'A');
        establishLadders(0, 1);
    }
    
    //Method to initialize the board, is called from the constructor
    public void initBoard(int size){
        this.tail = null;
        this.head = new Box(1);
        initBoard(size, head, 2);
    }

    private void initBoard(int size, Box current, int number){
        if(number > size){
            return;
        }

        Box newBox = new Box(number);
        current.setNext(newBox);
        newBox.setPrevious(current);
        tail = newBox;
        initBoard(size, current.getNext(), number + 1);
    }

    // Print 

    public void print(){
        if(head == null){
            System.out.println("Lista vacia");
        }else{
            if(this.rows%2==0){
                print(tail,2);
            }else{
                print(tail,1);
            }
            
        }
    }

    private void print(Box current, int row){
        int rows = this.rows;
        if(this.rows%2==0){
            rows+=1;
        }
        if(row > rows){
           return;
        }else{
            Box newCurrent = printRow(current, row, 1);
            System.out.println("");
            print(newCurrent, row+=1);
        }

    }

    private Box printRow(Box current, int row, int column) {
      Box boxito;
      if (column > this.columns - 1) {
        System.out.print(current.toString());
        return current.getPrevious();

      } else {
        if (row % 2 == 0) {
          //Pair
          System.out.print(current.toString());
          boxito = printRow(current.getPrevious(), row, column += 1);

        } else {
          //Odd

          boxito = printRow(current.getPrevious(), row, column += 1);
          System.out.print(current.toString());
        }
      }
      return boxito;
    }
    
    
    private void establishSnakes(int counterSnakes, char identifier) {
      if (counterSnakes <= this.numSnakes) {
        int posHead = random.nextInt(this.size) + 1;
        Box box = searchBox(posHead, head);
        if (box.getItemClassifier() == 0 && posHead != 1) {
          fillHeadSnake(posHead, this.head, identifier);
          establishSnakes(counterSnakes+=1, identifier++);
        } else {
          establishSnakes(counterSnakes, identifier);
        }
      }

    }
    
    private void fillHeadSnake(int posHead, Box current, char identifier) {
      if(current == null){
        return;
		  }

		  if(posHead == current.getNumber()){
        current.setSnakeIdentifier(identifier);
        current.setItemClassifier(1);
        int posTail = random.nextInt(posHead - 1) + 1;
        fillTailSnake(posTail, this.head, identifier);
        return;
		  }

    }
    
    private void fillTailSnake(int posTail, Box current, char identifier) {
      if (current == null) {
        return;
      }

      if (posTail == current.getNumber()) {
        current.setSnakeIdentifier(identifier);
        current.setItemClassifier(1);
        current.setTailSnake(posTail);
        return;
      }

    }

    private void establishLadders(int counterLadders, int identifier) {
      if (counterLadders <= this.numLadders) {
        int posHead = random.nextInt(this.size) + 1;
        Box box = searchBox(posHead, head);
        if (box.getItemClassifier() == 0 && posHead != this.size) {
          fillHeadLadder(posHead, this.head, identifier);
          establishLadders(counterLadders+=1, identifier+=1); 
        } else {
          establishLadders(counterLadders, identifier);
        }
      }
    }

    private void fillHeadLadder(int posHead, Box current, int identifier) {
      if(current == null){
        return;
		  }

		  if(posHead == current.getNumber()){
        current.setLadderIdentifier(identifier);
        current.setItemClassifier(2);
        current.setHeadLadder(posHead);
        int posTail = random.nextInt(posHead - 1) + 1;
        fillTailLadder(posTail, this.head, identifier);
        return;
		  }

    }
    
    private void fillTailLadder(int posTail, Box current, int identifier) {
      if (current == null) {
        return;
      }

      if (posTail == current.getNumber()) {
        current.setLadderIdentifier(identifier);
        current.setItemClassifier(2);
        return;
      }

    }
    
    private Box searchBox(int goal, Box current){
		  if(current == null){
			  return null; 
		  }

		  if(goal == current.getNumber()){
			  return current; 
		  }

		return searchBox(goal, current.getNext());
	}


    //-----Getters and setters-----


    public Box getHead() {
        return head;
    }

    public void setHead(Box head) {
        this.head = head;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
      this.columns = columns;
    }
    
    public int getSize() {
      return this.size;
    }


}
