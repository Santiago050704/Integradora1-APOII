package ui;
import java.util.Scanner;


import model.LinkedListPlayerNode;
import model.Player;
import model.PlayersList;
import model.SnakesAndLadders;

public class Main {
    private Scanner reader;
    private SnakesAndLadders game;

    public Main() {
		game = new SnakesAndLadders();
        reader = new Scanner(System.in);
	}
    public static void main(String[] args) {
        
		Main main = new Main(); 
        main.cleanConsole();
		int option = 0; 
        
        main.menuController(-1);

		main.getReader().close();
    
    }

    public void menuController(int option){
        if(option != 0){
            option = getOptionShowMenu(); 
            cleanConsole();
			executeOption(option);
   
            cleanConsole();
            menuController(option);
        }
        return;
    }

    public int getOptionShowMenu(){
        int option = 0; 
        System.out.println("<<<<< Snakes And Ladders >>>>>");
        System.out.println(
                "1. Jugar\n" +
                "0. Exit. ");
        option =  validateIntegerInput();
        return option; 
    }

    public void executeOption(int option){;
        switch(option) {
            case 1 :
                game.setPlayerList(new PlayersList());
                uiChoosePlayers(1);
                uiInitializeBoard();
                break;
            case 0: 
                
                break; 
            default: 
                System.out.println("Invalid Option");
                break; 
        }
    }
    
    public Scanner getReader(){
        return reader; 
    }

    public int validateIntegerInput(){
        int option = 0; 

        if(reader.hasNextInt()){
            option = reader.nextInt(); 
        }
        else{
            // clear reader. 
            reader.nextLine(); 
            option = -1; 
        }

        return option; 
    }

    public void uiInitializeBoard(){
        System.out.print("Rows: ");
        int rows = reader.nextInt();
        System.out.print("Columns: ");
        int columns = reader.nextInt();
        System.out.print("Snakes: ");
        int numSnakes = reader.nextInt();
        System.out.print("Ladders: ");
        int numLadders = reader.nextInt();
        game.initializeBoard(rows, columns, numSnakes, numLadders);
    }

    public void uiChoosePlayers(int countPlayer){
        if(countPlayer <= game.NUMBER_OF_PLAYERS) {
            System.out.println("Choose the player " + countPlayer + " : * ! O X % $ # + &");
            String name = reader.next();

            game.getPlayerList().add(new LinkedListPlayerNode(new Player(name)));
            uiChoosePlayers(countPlayer += 1);
        }else{
            return;
        }
    }

    public void cleanConsole(){
        System.out.print("\033[H\033[2J");
    }

}