import java.util.*;
import javax.swing.ImageIcon;
import java.awt.*;

//FOR SHOWING CARD INFO TO USER
public class Deck {
    private HashMap<Integer, ImageIcon> cardImg;
    public Deck() {
        //FOR REPORT2, WE USE 16 CARDS FOR CHECKING
        this.cardImg = new HashMap<Integer, ImageIcon>();
        for(Integer key = 1 ; key <= 38 ; key++){
            ImageIcon tempImg;
            if(key < 10){
                tempImg = new ImageIcon("Resource/originalcard/originalgame0" + key + ".png");
            }else{
                tempImg = new ImageIcon("Resource/originalcard/originalgame" + key + ".png");
            }
            cardImg.put(key, tempImg);
        }
    }
    //ADD TYPE FOR SPECIAL CARD NEXT TIME
    public ImageIcon getCardImg(Integer cardNum) {
        return this.cardImg.get(cardNum);
    }
}
