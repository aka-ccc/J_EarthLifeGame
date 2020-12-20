import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComputerPlay implements Runnable {
    private ScencePanel panel;
    private Player[] players;
    private int who;
    private Deck deck;
    private boolean showClick = false;
    private Integer hit;
    public ComputerPlay(ScencePanel scPanel, Player[] status, Deck deckImg){
        this.panel = scPanel;
        this.players = status;
        this.who = 1;
        this.deck = deckImg;
    }
    public ComputerPlay(ScencePanel scPanel, Player[] status, Deck deckImg, Integer cardNum) {
        this.panel = scPanel;
        this.players = status;
        this.who = 0;
        this.deck = deckImg;
        this.hit = cardNum;
        // Thread playAct = new Thread(new PlayAction(this, status, cardNum, whoPlay));
        // playAct.start();
    }
    @Override
    public void run() {
        
            for(who = 1 ; who < 4 ; who++) {
                if(players[0].checkLose() || players[0].checkWin()) {
                    for(Player p:players) {
                        if(p == players[0]) {
                            if(p.checkLose()) {
                                panel.setLoseLabelVisible(true);
                                panel.repaint();
                                break;
                            }
                        }else if(p != players[3]){
                            if(!p.checkLose()) {
                                break;
                            }else if(p.checkWin()) {
                                panel.setLoseLabelVisible(true);
                                break;
                            }
                        }else {
                            if(!p.checkLose()) {
                                break;
                            }else if(p.checkWin()) {
                                panel.setLoseLabelVisible(true);
                                break;
                            }
                            panel.setWinLabelVisible(true);
                            panel.repaint();
                            break;
                        }
                    }
                    panel.repaint();
                    break;
                }
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
                cards.add((int)((Math.random()*100)%32+1));
                cards.set(0, cards.get(0) + 1);
                players[who].setCards(cards);
                //HOW MANY CARDs THE PLAYER HAVE
                int amount = cards.get(0);
                doNothing(1800);
    
                //PLAYER DRAW CARD
                panel.setPlayerCardVisible(who, amount - 1, true);
                panel.setWhoturnLabelVisible(who, true);
                panel.repaint();
                //PLAYER HIT
                doNothing(1000);
                panel.setPlayerCardVisible(who, amount - 1, false);
                panel.setWhoturnLabelVisible(who, false);
                panel.repaint();
                
                int hit = (int)((Math.random()*100)%amount)+1;
                int show = cards.get(hit);
                Thread play = new Thread(new PlayAction(panel, players, cards.get(hit), who));
                play.start();
                try {
                    play.join();
                } catch (InterruptedException err) {
                    //TODO: handle exception
                    err.printStackTrace();
                }
                cards.remove(hit);
                cards.set(0, cards.get(0) - 1);
                players[who].setCards(cards);
                //GENERATE_GAME_SCENCE
                panel.gameScence();
                panel.setRuleLabelVisible(false);
                panel.setWhoturnLabelVisible(0, false);
                panel.setHintLabelVisible(false);
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
            panel.setHintLabelVisible(true);
            for(Player p:players) {
                if(p == players[0]) {
                    if(p.checkLose()) {
                        panel.setLoseLabelVisible(true);
                        panel.setHintLabelVisible(false);
                        break;
                    }
                }else if(p != players[3]){
                    if(!p.checkLose()) {
                        break;
                    }
                }else {
                    if(!p.checkLose()) {
                        break;
                    }
                    panel.setWinLabelVisible(true);
                    panel.setHintLabelVisible(false);
                    break;
                }
            }
            if(players[0].checkLose() || players[0].checkWin()) {
                if(players[0].checkLose()) {
                    panel.setLoseLabelVisible(true);
                }else {
                    panel.setWinLabelVisible(true);
                }
            }else{
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
}
