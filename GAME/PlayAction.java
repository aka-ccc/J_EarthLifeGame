import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//NO USE NOW
public class PlayAction {
    private Integer card;
    public PlayAction() {
        this.card = 0;
    }
    public void setCard(Integer cardNum) {
        this.card = cardNum;
    }
    public Integer getCard() {
        return this.card;
    }
}
