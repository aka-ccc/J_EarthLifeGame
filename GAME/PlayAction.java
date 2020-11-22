
//NO USE NOW
public class PlayAction {
    private Integer card;
    private Player[] players;
    public PlayAction() {
        this.card = 0;
        this.players = new Player[4];
    }
    public void setCard(Integer cardNum) {
        this.card = cardNum;
        if(cardNum <= 16) {
            //LET PLAYERS CHOOSE RANDOM AND MAKE HOLES++
            players[1].setHoles(players[1].getHoles()+(int)((Math.random()*100)%2));
            players[2].setHoles(players[2].getHoles()+(int)((Math.random()*100)%2));
            players[3].setHoles(players[3].getHoles()+(int)((Math.random()*100)%2));
        }else{
            System.out.println("Unexepcted Error!!");
        }
    }
    public void setPlayers(Player[] status){
        this.players = status;
    }
    public Player[] getPlayers() {
        return this.players;
    }
}
