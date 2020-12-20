import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Play implements Runnable {
    private ScencePanel panel;
    private Player[] players;
    private int who;
    private Deck deck;
    private boolean showClick = false;
    private Integer hit;
    public Play(ScencePanel scPanel, Player[] status, Deck deckImg, Integer cardNum, int whoPlay) {
        this.panel = scPanel;
        this.players = status;
        this.who = whoPlay;
        this.deck = deckImg;
        this.hit = cardNum;
    }
    public Play(ScencePanel scPanel, Player[] status, Deck deckImg, int whoPlay) {
        this.panel = scPanel;
        this.players = status;
        this.who = whoPlay;
        this.deck = deckImg;
        this.hit = 0;
    }
    @Override
    public void run() {
        if(!panel.checkGameOver()) {
            if(who == 0) {
                Thread playAct = new Thread(new PlayAction(panel, players, hit, who, deck));
                playAct.start();
                try {
                    playAct.join();
                } catch (InterruptedException err) {
                    //TODO: handle exception
                    err.printStackTrace();
                }
            }else {
                if(!players[who].checkLose()){
                    //PLAYER's CARDs
                    ArrayList<Integer> cards = players[who].getCards();
                    //DRAW A CARD
                    cards.add((int)((Math.random()*100)%32+1));
                    cards.set(0, cards.get(0) + 1);
                    players[who].setCards(cards);
                    //HOW MANY CARDs THE PLAYER HAVE
                    int amount = cards.get(0);
                    doNothing(1800);
                    panel.setPlayerCardVisible(who, amount - 1, true);
                    panel.setWhoturnLabelVisible(who, true);
                    panel.repaint();
                    doNothing(1000);
                    panel.setPlayerCardVisible(who, amount - 1, false);
                    panel.setWhoturnLabelVisible(who, false);
                    panel.repaint();
                    hit = (int)((Math.random()*100)%amount)+1;
                    int show = cards.get(hit);
                    Thread play = new Thread(new PlayAction(panel, players, cards.get(hit), who));
                    play.start();
                    try {
                        play.join();
                    } catch (InterruptedException err) {
                        //TODO: handle exception
                        err.printStackTrace();
                    }
                    System.out.println("哈哈");
                    cards.remove(hit);
                    cards.set(0, cards.get(0) - 1);
                    players[who].setCards(cards);
                    //SHOW_PLAYER_HIT
                    panel.setCardImg(deck.getCardImg(show), true);
                    panel.repaint();
                    showClick = false;
                    panel.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            super.mouseClicked(e);
                            showClick = true;
                        }
                    });
                    while(!showClick){
                        if(showClick) {
                            panel.setCardImg(null, false);
                            break;
                        }
                    }
                }
            }
            //GENERATE_GAME_SCENCE
            panel.gameScence();
            panel.setRuleLabelVisible(false);
            panel.setWhoturnLabelVisible(0, false);
            panel.setHintLabelVisible(false);
        }
        
        panel.setHintLabelVisible(true);
        if(!panel.checkGameOver()) {
            panel.repaint();
            panel.setDraw(panel.getDraw() + 1);
            panel.resetUserAction(true);
            panel.setWhoturnLabelVisible(0, true);
            doNothing(1000);
            panel.setWhoturnLabelVisible(0, false);
            panel.repaint();
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
    public int getWho() {
        return this.who;
    }
}
