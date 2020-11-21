import java.util.*;

//FOR CREATING PLAYER OBJ, INITIALIZE THE PLAYER'S STATUS
public class Player {
    private int holes;
    private int footsteps;
    private ArrayList<Integer> cards;
    public Player(){
        //holes,footsteps,cards
        this.holes = 0;
        this.footsteps = 0;
        this.cards = new ArrayList<Integer>();
        this.cards.add(2);
        this.cards.add((int)((Math.random()*100)%16+1));
        this.cards.add((int)((Math.random()*100)%16+1));
    }
    public void setHoles(int HolesNum) {
        this.holes = HolesNum;
    }
    public void setFootsteps(int FootstepsNum) {
        this.footsteps = FootstepsNum;
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
}