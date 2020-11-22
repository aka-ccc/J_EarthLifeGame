
//NO USE NOW
public class PlayAction implements Runnable {
    private Integer card;
    private Player[] players;
    public PlayAction(Player[] status, Integer cardNum) {
        this.card = cardNum;
        this.players = new Player[4];
        this.players = status;
    }
    @Override
    public void run() {
        if(card <= 16) {                             //CHOOSE CARD (YOUR DECISION WILL DECIDE THE HOLES YOU ARE)
            //NEED TO JUDGE IF THE HOLES >= 3(LOSE THE GAME)
            //LET PLAYERS CHOOSE RANDOM AND MAKE HOLES++
            players[1].setHoles(players[1].getHoles() + (int)((Math.random()*100)%2));
            players[2].setHoles(players[2].getHoles() + (int)((Math.random()*100)%2));
            players[3].setHoles(players[3].getHoles() + (int)((Math.random()*100)%2));
        }else{
            System.out.println("Unexepcted Error!!");
        }
    }
    private static void doNothing(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Unexpected interruption");
            System.exit(0);
        }
    }
}
