
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
        }else if(card >= 17 && card <= 19) {
            if(whoPlay == 0){
                players[1].setHoles(players[1].getHoles() + (int)((Math.random()*100)%2));
                players[2].setHoles(players[2].getHoles() + (int)((Math.random()*100)%2));
                players[3].setHoles(players[3].getHoles() + (int)((Math.random()*100)%2));
            }else{
                System.out.println("先讓我知道你進來了");
                // players[0].setHoles(players[0].getHoles() + 1);
            }
        }else if(card == 20 || card == 21) {
            if(whoPlay == 0){
                players[1].setHoles(players[1].getHoles() + (int)((Math.random()*100)%2));
                players[2].setHoles(players[2].getHoles() + (int)((Math.random()*100)%2));
                players[3].setHoles(players[3].getHoles() + (int)((Math.random()*100)%2));
            }else{
                System.out.println("先讓我知道你進來了");
                // players[0].setHoles(players[0].getHoles() + 1);
            }
        }else if(card >= 22 && card <= 26) {
            if(whoPlay == 0){
                players[1].setHoles(players[1].getHoles() + (int)((Math.random()*100)%2));
                players[2].setHoles(players[2].getHoles() + (int)((Math.random()*100)%2));
                players[3].setHoles(players[3].getHoles() + (int)((Math.random()*100)%2));
            }else{
                System.out.println("先讓我知道你進來了");
                // players[0].setHoles(players[0].getHoles() + 1);
            }
        }else if(card >= 27 && card <= 31) {
            if(whoPlay == 0){
                players[1].setHoles(players[1].getHoles() + (int)((Math.random()*100)%2));
                players[2].setHoles(players[2].getHoles() + (int)((Math.random()*100)%2));
                players[3].setHoles(players[3].getHoles() + (int)((Math.random()*100)%2));
            }else{
                System.out.println("先讓我知道你進來了");
                // players[0].setHoles(players[0].getHoles() + 1);
            }
        }else if(card == 32 || card == 33) {

        }else if(card >= 34 && card <= 36) {

        }else if(card >= 37 && card <= 42) {

        }else if(card == 43 || card == 44) {

        }else if(card == 45 || card == 46) {

        }else if(card == 47) {

        }else if(card == 48) {

        }else if(card == 49) {

        }else if(card == 50) {

        }else {
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
