package model;

public class Box {

    private int number;
    private Box next;
    private Box previous;
    private int tailSnake;
    private int headLadder;
    private char snakeIdentifier;
    private int ladderIdentifier;
    private int itemClassifier; // 0 - nothing | 1 - snake | 2-Ladder

    private PlayersList playersList;

    //Constructor
    public Box(int number){
        this.playersList = new PlayersList();
        this.number = number;
    }
    

    //----------Getters and setters----------

    public String toString()
    {
        String players = getStringPlayers(playersList.getHead());
        return "[" + this.number +  " " + players + ((itemClassifier==1)?snakeIdentifier:ladderIdentifier) + "]  ";
    }


    private String getStringPlayers(LinkedListPlayerNode player){
        if(player != null){
            return  getStringPlayers(player.getNext()) +  player.getPlayer().getName() + " ";
        }else{
            return "";
        }

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Box getNext() {
        return next;
    }

    public void setNext(Box next) {
        this.next = next;
    }

    public Box getPrevious() {
        return previous;
    }

    public void setPrevious(Box previous) {
        this.previous = previous;
    }

    public int getTailSnake() {
        return tailSnake;
    }

    public void setTailSnake(int tailSnake) {
        this.tailSnake = tailSnake;
    }

    public int getHeadLadder() {
        return headLadder;
    }

    public void setHeadLadder(int headLadder) {
        this.headLadder = headLadder;
    }

    public char getSnakeIdentifier() {
        return snakeIdentifier;
    }

    public void setSnakeIdentifier(char snakeIdentifier) {
        this.snakeIdentifier = snakeIdentifier;
    }

    public int getLadderIdentifier() {
        return ladderIdentifier;
    }

    public void setLadderIdentifier(int ladderIdentifier) {
        this.ladderIdentifier = ladderIdentifier;
    }

    public int getItemClassifier() {
        return itemClassifier;
    }

    public void setItemClassifier(int itemClassifier) {
        this.itemClassifier = itemClassifier;
    }

    public PlayersList getPlayersList() {
        return playersList;
    }

    public void setPlayersList(PlayersList playersList) {
        this.playersList = playersList;
    }
}
