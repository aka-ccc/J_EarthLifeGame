import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//NO USE NOW
public class PlayAction implements Runnable {
    private Integer card;
    private Player[] players;
    private int whoPlay;
    private ImageIcon chooseString[] = new ImageIcon[]{new ImageIcon("Resource/chooseframe/choosebutton1.png"), new ImageIcon("Resource/chooseframe/choosebutton2.png"), new ImageIcon("Resource/chooseframe/choosebutton3.png"), new ImageIcon("Resource/chooseframe/choosebutton4.png"), new ImageIcon("Resource/chooseframe/choosebutton5.png"), new ImageIcon("Resource/chooseframe/choosebutton6.png"), new ImageIcon("Resource/chooseframe/choosebutton7.png"), new ImageIcon("Resource/chooseframe/choosebutton8.png"), new ImageIcon("Resource/chooseframe/choosebutton9.png"), new ImageIcon("Resource/chooseframe/choosebutton10.png"), new ImageIcon("Resource/chooseframe/choosebutton11.png"), new ImageIcon("Resource/chooseframe/choosebutton12.png"), new ImageIcon("Resource/chooseframe/choosebutton13.png"), new ImageIcon("Resource/chooseframe/choosebutton14.png"), new ImageIcon("Resource/chooseframe/choosebutton15.png"), new ImageIcon("Resource/chooseframe/choosebutton16.png"), new ImageIcon("Resource/chooseframe/choosebutton20.png"), new ImageIcon("Resource/chooseframe/choosebutton21.png")};
    private ImageIcon paperScissorsStone[] = new ImageIcon[]{new ImageIcon("Resource/chooseframe/stone.png"), new ImageIcon("Resource/chooseframe/scissors.png"), new ImageIcon("Resource/chooseframe/paper.png")};
    private ImageIcon playerIcon[] = new ImageIcon[]{new ImageIcon("Resource/chooseframe/player1_button.png"), new ImageIcon("Resource/chooseframe/player2_button.png"), new ImageIcon("Resource/chooseframe/player3_button.png")};
    private JLabel chooseFrame;
    private JButton option1 = new JButton(), option2 = new JButton(), option3 = new JButton();
    private ScencePanel panel;
    private boolean click = false;
    private int option[] = new int[2];
    private int OPT = 0;
    public PlayAction(ScencePanel scpanel, Player[] status, Integer cardNum, int who) {
        this.card = cardNum;
        this.players = new Player[4];
        this.players = status;
        this.whoPlay = who;
        this.chooseFrame = scpanel.setChoose();
        this.panel = scpanel;
        option1.setOpaque(false);
        option1.setBorder(null);
        option1.setContentAreaFilled(false);
        option2.setOpaque(false);
        option2.setBorder(null);
        option2.setContentAreaFilled(false);
        option3.setOpaque(false);
        option3.setBorder(null);
        option3.setContentAreaFilled(false);
    }
    @Override
    public void run() {
        //clear the chooseFrame for setting new button
        chooseFrame.removeAll();
        if(card <= 16) {                             //CHOOSE CARD (YOUR DECISION WILL DECIDE THE HOLES YOU ARE)
            //NEED TO JUDGE IF THE HOLES >= 3(LOSE THE GAME)
            //LET PLAYERS CHOOSE RANDOM AND MAKE HOLES++
            if(whoPlay == 0){
                players[1].setHoles(players[1].getHoles() + (int)((Math.random()*100)%2));
                players[2].setHoles(players[2].getHoles() + (int)((Math.random()*100)%2));
                players[3].setHoles(players[3].getHoles() + (int)((Math.random()*100)%2));
            }else{
                for(int num = 0 ; num < 4 ; num++){
                    if(num == 0){
                        click = false;
                        if(card <= 2){
                            option1.setIcon(chooseString[0]);
                            option2.setIcon(chooseString[1]);
                        }else if(card%2 == 0){
                            option1.setIcon(chooseString[card - 2]);
                            option2.setIcon(chooseString[card - 1]);
                        }else{
                            option1.setIcon(chooseString[card - 1]);
                            option2.setIcon(chooseString[card]);
                        }
                        option1.setBounds(40, 215, 205, 58);
                        option1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if(card%2 == 0) {
                                    players[0].setHoles(players[0].getHoles());
                                }else {
                                    players[0].setHoles(players[0].getHoles() + 1);
                                }
                                chooseFrame.setVisible(false);
                                click = true;
                            }
                        });

                        option2.setBounds(315, 215, 205, 58);
                        option2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if(card%2 == 0) {
                                    players[0].setHoles(players[0].getHoles() + 1);
                                }else {
                                    players[0].setHoles(players[0].getHoles());
                                }
                                chooseFrame.setVisible(false);
                                click = true;
                            }
                        });
                        chooseFrame.add(option1);
                        chooseFrame.add(option2);
                        chooseFrame.setVisible(true);
                        while(!click){
                            if(click){
                                break;
                            }
                        }
                        if(click){
                            panel.repaint();
                            break;
                        }
                    }else if(num != whoPlay) {
                        players[num].setHoles(players[num].getHoles() + (int)((Math.random()*100)%2));
                    }
                    panel.repaint();
                }
                
            }
        }else if(card >= 17 && card <= 19) {        //PAPER, SCISSORS, STONE
            if(whoPlay == 0){
                players[1].setHoles(players[1].getHoles() + (int)((Math.random()*100)%2));
                players[2].setHoles(players[2].getHoles() + (int)((Math.random()*100)%2));
                players[3].setHoles(players[3].getHoles() + (int)((Math.random()*100)%2));
            }else{
                for(int num = 0 ; num < 4 ; num++){
                    if(num == 0){
                        click = false;
                        
                        option1.setIcon(paperScissorsStone[0]);
                        option1.setBounds(50, 200, 89, 112);
                        option1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if(card == 18) {
                                    players[0].setHoles(players[0].getHoles() + 1);
                                }else {
                                }
                                chooseFrame.setVisible(false);
                                click = true;
                            }
                        });
                        option2.setIcon(paperScissorsStone[1]);
                        option2.setBounds(235, 180, 74, 132);
                        option2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if(card == 17) {
                                    players[0].setHoles(players[0].getHoles() + 1);
                                }else {
                                }
                                chooseFrame.setVisible(false);
                                click = true;
                            }
                        });

                        option3.setIcon(paperScissorsStone[2]);
                        option3.setBounds(405, 182, 91, 124);
                        option3.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if(card == 19) {
                                    players[0].setHoles(players[0].getHoles() + 1);
                                }else {
                                }
                                chooseFrame.setVisible(false);
                                click = true;
                            }
                        });

                        chooseFrame.add(option1);
                        chooseFrame.add(option2);
                        chooseFrame.add(option3);
                        chooseFrame.setVisible(true);
                        while(!click){
                            if(click){
                                break;
                            }
                        }
                        if(click){
                            panel.repaint();
                            break;
                        }
                    }else if(num != whoPlay) {
                        players[num].setHoles(players[num].getHoles() + (int)((Math.random()*100)%2));
                    }
                    panel.repaint();
                }
            }
        }else if(card == 20 || card == 21) {        //CATS or DOGs
            if(whoPlay == 0){
                players[1].setHoles(players[1].getHoles() + (int)((Math.random()*100)%2));
                players[2].setHoles(players[2].getHoles() + (int)((Math.random()*100)%2));
                players[3].setHoles(players[3].getHoles() + (int)((Math.random()*100)%2));
            }else{
                for(int num = 0 ; num < 4 ; num++){
                    if(num == 0){
                        click = false;
                        
                        option1.setIcon(chooseString[16]);
                        option2.setIcon(chooseString[17]);
                        
                        option1.setBounds(40, 215, 205, 58);
                        option1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                players[0].setHoles(players[0].getHoles() + (int)((Math.random()*100)%2));
                                chooseFrame.setVisible(false);
                                click = true;
                            }
                        });

                        option2.setBounds(315, 215, 205, 58);
                        option2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                players[0].setHoles(players[0].getHoles() + (int)((Math.random()*100)%2));
                                chooseFrame.setVisible(false);
                                click = true;
                            }
                        });
                        chooseFrame.add(option1);
                        chooseFrame.add(option2);
                        chooseFrame.setVisible(true);
                        while(!click){
                            if(click){
                                break;
                            }
                        }
                        if(click){
                            panel.repaint();
                            break;
                        }
                    }else if(num != whoPlay) {
                        players[num].setHoles(players[num].getHoles() + (int)((Math.random()*100)%2));
                    }
                    panel.repaint();
                }
            }
        }else if(card >= 22 && card <= 26) {        //ATTACK
            if(whoPlay == 0){
                ///////////////////////////////////////////////////////<<<<SHOULD MAKE PLAYER TO CHOOSE!!
                //record how many player alived
                int count = 0;
                for(Player p:players){
                    if(p == players[0]){
                        //DO NOTHING
                    }else{
                        if(!p.checkLose()){
                            count++;
                        }
                    }
                }
                if(count == 3) {
                    click = false;

                    option1.setIcon(playerIcon[0]);
                    option1.setBounds(28, 232, 149, 58);
                    option1.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            players[1].setHoles(players[1].getHoles() + 1);
                            chooseFrame.setVisible(false);
                            click = true;
                        }
                    });

                    option2.setIcon(playerIcon[1]);
                    option2.setBounds(205, 232, 149, 58);
                    option2.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            players[2].setHoles(players[2].getHoles() + 1);
                            chooseFrame.setVisible(false);
                            click = true;
                        }
                    });

                    option3.setIcon(playerIcon[2]);
                    option3.setBounds(382, 232, 149, 58);
                    option3.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            players[3].setHoles(players[3].getHoles() + 1);
                            chooseFrame.setVisible(false);
                            click = true;
                        }
                    });

                    chooseFrame.add(option1);
                    chooseFrame.add(option2);
                    chooseFrame.add(option3);
                    chooseFrame.setVisible(true);
                    while(!click){
                        if(click){
                            break;
                        }
                    }
                }else if(count == 2) {
                    click = false;

                    int who = 0;
                    int idx = 0;
                    for(Player p:players) {
                        if(p == players[0]) {
                            who++;
                        }else if(!p.checkLose()){
                            option[idx] = who;
                            idx++;
                        }
                        who++;
                    }
                    option1.setIcon(playerIcon[option[0]]);
                    option1.setBounds(87, 232, 149, 58);
                    option1.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            players[option[0]+1].setHoles(players[option[0]+1].getHoles() + 1);
                            chooseFrame.setVisible(false);
                            click = true;
                        }
                    });

                    option2.setIcon(playerIcon[option[1]]);
                    option2.setBounds(323, 232, 149, 58);
                    option2.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            players[option[1]+1].setHoles(players[option[1]+1].getHoles() + 1);
                            chooseFrame.setVisible(false);
                            click = true;
                        }
                    });

                    chooseFrame.add(option1);
                    chooseFrame.add(option2);
                    chooseFrame.setVisible(true);
                    while(!click){
                        if(click){
                            break;
                        }
                    }
                }else {
                    click = false;

                    OPT = 0;
                    for(Player p:players) {
                        if(p == players[0]) {
                            //DO NOTHING
                            OPT++;
                        }else if(p.checkLose()) {
                            OPT++;
                        }else{
                            break;
                        }
                    }
                    option1.setIcon(playerIcon[OPT]);
                    option1.setBounds(205, 232, 149, 58);
                    option1.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            players[OPT+1].setHoles(players[OPT+1].getHoles() + 1);
                            chooseFrame.setVisible(false);
                            click = true;
                        }
                    });

                    chooseFrame.add(option1);
                    chooseFrame.setVisible(true);
                    while(!click){
                        if(click){
                            break;
                        }
                    }
                }
                panel.repaint();
            }else{                                  //RANDOM CHOOSE A PLAYER BE A VICTIM(HOLE + 1)
                int count = 0;
                while(count == 0) {
                    for(Player victim: players) {
                        if(victim != players[whoPlay] && (!victim.checkLose())) {
                            int attack = (int)((Math.random()*100)%2);
                            if(attack == 1) {
                                victim.setHoles(victim.getHoles() + 1);
                                count++;
                                break;
                            }
                        }
                    }
                }
                
            }
        }else if(card >= 33 && card <= 38) {    //WIN or LOSE
            
            if(card == 33) {                //HIT THIS AND WIN THE GAME
                players[whoPlay].setWin(true);
            }else if(card == 34) {          //HIT THIS AND LOSE THE GAME
                players[whoPlay].setLose(true);
            }else if(card == 37){
                for(Player p:players){      //ALL PLAYER WIN
                    if(!p.checkLose()){
                        p.setWin(true);
                    }
                }
            }else if(card == 38){
                for(Player p:players){      //ALL PLAYER LOSE
                    p.setLose(true);
                }
            }else if(card == 35){           //CHOOSE A PLAYER TO WIN THE GAME
                if(whoPlay == 0){
                    //record how many player alived
                    int count = 0;
                    for(Player p:players){
                        if(p == players[0]){
                            //DO NOTHING
                        }else{
                            if(!p.checkLose()){
                                count++;
                            }
                        }
                    }
                    if(count == 3) {
                        click = false;

                        option1.setIcon(playerIcon[0]);
                        option1.setBounds(28, 232, 149, 58);
                        option1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                players[1].setWin(true);
                                chooseFrame.setVisible(false);
                                click = true;
                            }
                        });

                        option2.setIcon(playerIcon[1]);
                        option2.setBounds(205, 232, 149, 58);
                        option2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                players[2].setWin(true);
                                chooseFrame.setVisible(false);
                                click = true;
                            }
                        });

                        option3.setIcon(playerIcon[2]);
                        option3.setBounds(382, 232, 149, 58);
                        option3.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                players[3].setWin(true);
                                chooseFrame.setVisible(false);
                                click = true;
                            }
                        });

                        chooseFrame.add(option1);
                        chooseFrame.add(option2);
                        chooseFrame.add(option3);
                        chooseFrame.setVisible(true);
                        while(!click){
                            if(click){
                                break;
                            }
                        }
                    }else if(count == 2) {
                        click = false;

                        int who = 0;
                        int idx = 0;
                        for(Player p:players) {
                            if(p == players[0]) {
                                who++;
                            }else if(!p.checkLose()){
                                option[idx] = who;
                                idx++;
                            }
                            who++;
                        }
                        option1.setIcon(playerIcon[option[0]]);
                        option1.setBounds(87, 232, 149, 58);
                        option1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                players[option[0]+1].setWin(true);
                                chooseFrame.setVisible(false);
                                click = true;
                            }
                        });

                        option2.setIcon(playerIcon[option[1]]);
                        option2.setBounds(323, 232, 149, 58);
                        option2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                players[option[1]+1].setWin(true);
                                chooseFrame.setVisible(false);
                                click = true;
                            }
                        });

                        chooseFrame.add(option1);
                        chooseFrame.add(option2);
                        chooseFrame.setVisible(true);
                        while(!click){
                            if(click){
                                break;
                            }
                        }
                    }else {
                        click = false;

                        OPT = 0;
                        for(Player p:players) {
                            if(p == players[0]) {
                                //DO NOTHING
                                OPT++;
                            }else if(p.checkLose()) {
                                OPT++;
                            }else{
                                break;
                            }
                        }
                        option1.setIcon(playerIcon[OPT]);
                        option1.setBounds(205, 232, 149, 58);
                        option1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                players[OPT+1].setWin(true);
                                chooseFrame.setVisible(false);
                                click = true;
                            }
                        });

                        chooseFrame.add(option1);
                        chooseFrame.setVisible(true);
                        while(!click){
                            if(click){
                                break;
                            }
                        }
                    }
                    panel.repaint();
                }else{                      //RANDOM CHOOSE A PLAYER TO WIN(EXCEPT THE HITTER)
                    int count = 0;
                    while(count == 0) {
                        for(Player p:players){
                            if(p.checkLose() || p == players[whoPlay]){
                                //DO NOTHING
                            }else{
                                boolean WIN = Math.random() < 0.5;
                                if(WIN == true){
                                    p.setWin(WIN);
                                    count++;
                                    break;
                                }
                            }
                        }
                    }
                }
            }else if(card == 36){           //CHOOSE A PLAYER TO LOSE THE GAME
                if(whoPlay == 0){
                    int count = 0;
                    for(Player p:players){
                        if(p == players[0]){
                            //DO NOTHING
                        }else{
                            if(!p.checkLose()){
                                count++;
                            }
                        }
                    }
                    if(count == 3) {
                        click = false;

                        option1.setIcon(playerIcon[0]);
                        option1.setBounds(28, 232, 149, 58);
                        option1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                players[1].setLose(true);
                                chooseFrame.setVisible(false);
                                click = true;
                            }
                        });

                        option2.setIcon(playerIcon[1]);
                        option2.setBounds(205, 232, 149, 58);
                        option2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                players[2].setLose(true);
                                chooseFrame.setVisible(false);
                                click = true;
                            }
                        });

                        option3.setIcon(playerIcon[2]);
                        option3.setBounds(382, 232, 149, 58);
                        option3.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                players[3].setLose(true);
                                chooseFrame.setVisible(false);
                                click = true;
                            }
                        });

                        chooseFrame.add(option1);
                        chooseFrame.add(option2);
                        chooseFrame.add(option3);
                        chooseFrame.setVisible(true);
                        while(!click){
                            if(click){
                                break;
                            }
                        }
                    }else if(count == 2) {
                        click = false;

                        int who = 0;
                        int idx = 0;
                        for(Player p:players) {
                            if(p == players[0]) {
                                who++;
                            }else if(!p.checkLose()){
                                option[idx] = who;
                                idx++;
                            }
                            who++;
                        }
                        option1.setIcon(playerIcon[option[0]]);
                        option1.setBounds(87, 232, 149, 58);
                        option1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                players[option[0]+1].setLose(true);
                                chooseFrame.setVisible(false);
                                click = true;
                            }
                        });

                        option2.setIcon(playerIcon[option[1]]);
                        option2.setBounds(323, 232, 149, 58);
                        option2.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                players[option[1]+1].setLose(true);
                                chooseFrame.setVisible(false);
                                click = true;
                            }
                        });

                        chooseFrame.add(option1);
                        chooseFrame.add(option2);
                        chooseFrame.setVisible(true);
                        while(!click){
                            if(click){
                                break;
                            }
                        }
                    }else {
                        click = false;

                        OPT = 0;
                        for(Player p:players) {
                            if(p == players[0]) {
                                //DO NOTHING
                                OPT++;
                            }else if(p.checkLose()) {
                                OPT++;
                            }else{
                                break;
                            }
                        }
                        option1.setIcon(playerIcon[OPT]);
                        option1.setBounds(205, 232, 149, 58);
                        option1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                players[OPT+1].setLose(true);
                                chooseFrame.setVisible(false);
                                click = true;
                            }
                        });

                        chooseFrame.add(option1);
                        chooseFrame.setVisible(true);
                        while(!click){
                            if(click){
                                break;
                            }
                        }
                    }
                    panel.repaint();
                }else{                      //RANDOM CHOOSE A PLAYER TO LOSE(EXCEPT THE HITTER)
                    int count = 0;
                    while(count == 0) {
                        for(Player p:players){
                            if(p.checkLose() || p == players[whoPlay]){
                                //DO NOTHING
                            }else{
                                boolean LOSE = Math.random() < 0.5;
                                if(LOSE == true){
                                    p.setLose(LOSE);
                                    count++;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }else if(card == 32) {      //GET 5 POINTS
            players[whoPlay].setFootsteps(players[whoPlay].getFootsteps() + 5);
        }else if(card >= 27 && card <=31) {     //MINUS ONE HOLE
            players[whoPlay].setHoles(players[whoPlay].getHoles() - 1);
        }else {
            System.out.println("Unexepcted Error!!");
        }
        panel.gameScence();
        if(whoPlay == 0){
            
        }
    }
    // private static void checkClick(boolean click) {
    //     try {
    //         Thread checkThread = new Thread(new Runnable(){
    //             @Override
    //             public void run() {
                    
    //             }
    //         });
    //         checkThread.join();
    //     }catch(InterruptedException e) {
    //         System.out.println("Unexpected interruption");
    //         System.exit(0);
    //     }
    // }
}
