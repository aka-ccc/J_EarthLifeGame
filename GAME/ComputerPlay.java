import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComputerPlay implements Runnable {
    private ScencePanel panel;
    private Player[] players;
    private int who;
    //load a lot of images
    private ImageIcon player1Card = new ImageIcon("Resource/main/card_right.png");
    private ImageIcon player2Card = new ImageIcon("Resource/main/card.png");
    private ImageIcon player3Card = new ImageIcon("Resource/main/card_left.png");

    public ComputerPlay(ScencePanel scPanel, Player[] status){
        this.panel = scPanel;
        this.players = status;
        this.who = 1;
    }
    @Override
    public void run() {
        for(who = 1 ; who < 4 ; who++) {
            //if player lose, break
            while(players[who].checkLose()) {
                if(who == 3) {
                    break;
                }else {
                    who++;
                }
            }
            if(players[who].checkLose() && who == 3){
                break;
            }
            //PLAYER's CARDs
            ArrayList<Integer> cards = players[who].getCards();
            //STILL 16 CARDs  <<< NEED TO CHANGE
            cards.add((int)((Math.random()*100)%16+1));
            cards.set(0, cards.get(0) + 1);
            players[who].setCards(cards);
            //HOW MANY CARDs THE PLAYER HAVE
            int amount = cards.get(0);
            doNothing(1800);
            JLabel p1 = new JLabel(player1Card), p2 = new JLabel(player2Card), p3 = new JLabel(player3Card);
            if(who == 1){
                p1.setBounds(940 + (amount-1)*10, 180 + (amount-1)*61, 78, 79);
                panel.add(p1);
            }else if(who == 2){
                p2.setBounds(510 + (amount-1)*75, 150, 59, 78);
                panel.add(p2);
            }else{
                p3.setBounds(210 + (amount-1)*10, 440 - (amount-1)*61, 78, 79);
                panel.add(p3);
            }
            panel.repaint();
            int hit = (int)((Math.random()*100)%amount)+1;
            Thread play = new Thread(new PlayAction(players, hit, who));
            play.start();
            cards.remove(hit);
            cards.set(0, cards.get(0) - 1);
            players[who].setCards(cards);
            doNothing(1000);

            if(who == 1){
                panel.remove(p1);
            }else if(who == 2){
                panel.remove(p2);
            }else{
                panel.remove(p3);
            }
            panel.repaint();
        }
        panel.setDraw(panel.getDraw() + 1);
        panel.resetUserAction(true);
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
