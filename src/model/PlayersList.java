package model;

public class PlayersList {

    private LinkedListPlayerNode head;

    //Methods

    public void add(LinkedListPlayerNode player){
        if(head == null){
            head = player;
        }else{
            add(head, player);
        }
    }
    private void add(LinkedListPlayerNode current, LinkedListPlayerNode player){
        if(current.getNext() == null){
            current.setNext(player);
            return;
        }
        add(current.getNext(), player);
    }

    public void removePlayer(LinkedListPlayerNode player){
        removePlayer(player, head);
    }
    private void removePlayer(LinkedListPlayerNode player, LinkedListPlayerNode current){
        if (current.getNext() == null) return;
        if (player == head){
            if(player.getNext() == null){
                head = null;
            } else {
                head = player.getNext();
            }
            return;
        }
        if (current.getNext() == player){
            if(player.getNext() == null){
                current.setNext(null);
            } else {
                current.setNext(player.getNext());
            }
        } else {
            removePlayer(player, current.getNext());
        }
    }


    //-----Getters and setters-----


    public LinkedListPlayerNode getHead() {
        return head;
    }
    public void setHead(LinkedListPlayerNode head) {
        this.head = head;
    }

}
