import java.util.*;

//FOR CREATING PLAYER OBJ, INITIALIZE THE PLAYER'S STATUS
public class Player {
    private int holes;
    private int footsteps;
    private ArrayList<Integer> cards;
    private Boolean win, lose;
    public Player(){
        //holes,footsteps,cards
        this.holes = 0;
        this.footsteps = 0;
        this.cards = new ArrayList<Integer>();
        this.cards.add(2);
        this.cards.add((int)((Math.random()*100)%16+1));
        this.cards.add((int)((Math.random()*100)%16+1));
        this.win = false;
        this.lose = false;
    }
    public void setHoles(int HolesNum) {
        this.holes = HolesNum;
        if(this.holes >= 3) {
            this.holes = 3;
            this.setLose(true);
        }
    }
    public void setFootsteps(int FootstepsNum) {
        this.footsteps = FootstepsNum;
        if(this.footsteps >= 15) {
            this.footsteps = 15;
            this.setWin(true);
        }
    }
    public void setCards(ArrayList<Integer> CardsInfo) {
        this.cards = CardsInfo;
    }
    public int getHoles() {
        return this.holes;
    }
    public int getFootsteps() {
        return this.footsteps;
    }
    public ArrayList<Integer> getCards() {
        return this.cards;
    }
    public void setWin(boolean winner) {
        this.win = winner;
    }
    public void setLose(boolean loser) {
        this.lose= loser;
    }
    public boolean checkLose() {
        return this.lose;
    }
    public boolean checkWin() {
        return this.win;
    }
}
