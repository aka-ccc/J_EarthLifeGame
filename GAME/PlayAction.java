
//NO USE NOW
public class PlayAction implements Runnable {
    private Integer card;
    private Player[] players;
    private int whoPlay;
    public PlayAction(Player[] status, Integer cardNum, int who) {
        this.card = cardNum;
        this.players = new Player[4];
        this.players = status;
        this.whoPlay = who;
    }
    @Override
    public void run() {
        // doNothing(2000);
        if(card <= 16) {                             //CHOOSE CARD (YOUR DECISION WILL DECIDE THE HOLES YOU ARE)
            //NEED TO JUDGE IF THE HOLES >= 3(LOSE THE GAME)
            //LET PLAYERS CHOOSE RANDOM AND MAKE HOLES++
            if(whoPlay == 0){
                players[1].setHoles(players[1].getHoles() + (int)((Math.random()*100)%2));
                players[2].setHoles(players[2].getHoles() + (int)((Math.random()*100)%2));
                players[3].setHoles(players[3].getHoles() + (int)((Math.random()*100)%2));
            }else{
                System.out.println("先讓我知道你進來了");
                // players[0].setHoles(players[0].getHoles() + 1);
            }
            
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
