import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ScencePanel extends JPanel implements ActionListener {
    //check if you really want to exit the game
    private CheckExit checkExit;
    //load a lot of images
    private Image Scence = new ImageIcon("Resource/all.png").getImage();
    private ImageIcon startIcon = new ImageIcon("Resource/home/start_button.png");
    private ImageIcon ruleIcon = new ImageIcon("Resource/home/rule_button.png");
    private ImageIcon exitIcon = new ImageIcon("Resource/home/end_button.png");
    private ImageIcon backIcon = new ImageIcon("Resource/rule/return_button.png");
    private ImageIcon playIcon = new ImageIcon("Resource/main/play.png");
    private ImageIcon playerCard = new ImageIcon("Resource/main/card2_big.png");
    private ImageIcon player1Card = new ImageIcon("Resource/main/card_right.png");
    private ImageIcon player2Card = new ImageIcon("Resource/main/card.png");
    private ImageIcon player3Card = new ImageIcon("Resource/main/card_left.png");
    private ImageIcon number[] = new ImageIcon[]{new ImageIcon("Resource/number/0.png"),new ImageIcon("Resource/number/1.png"),new ImageIcon("Resource/number/2.png"),new ImageIcon("Resource/number/3.png"),new ImageIcon("Resource/number/4.png"),new ImageIcon("Resource/number/5.png"),new ImageIcon("Resource/number/6.png"),new ImageIcon("Resource/number/7.png"),new ImageIcon("Resource/number/8.png"),new ImageIcon("Resource/number/9.png"),new ImageIcon("Resource/number/10.png"),new ImageIcon("Resource/number/11.png"),new ImageIcon("Resource/number/12.png"),new ImageIcon("Resource/number/13.png"),new ImageIcon("Resource/number/14.png"),new ImageIcon("Resource/number/15.png")};
    private ImageIcon userEarth[] = new ImageIcon[]{new ImageIcon("Resource/main/eth_button_ori.png"),new ImageIcon("Resource/main/eth_button_h1.png"),new ImageIcon("Resource/main/eth_button_h2.png"),new ImageIcon("Resource/main/eth_button_h3.png")};
    private ImageIcon playerEarth[] = new ImageIcon[]{new ImageIcon("Resource/main/eth_ori.png"),new ImageIcon("Resource/main/eth_h1.png"),new ImageIcon("Resource/main/eth_h2.png"),new ImageIcon("Resource/main/eth_h3.png")};
    private ImageIcon cardStack = new ImageIcon("Resource/main/deck.png");
    //decide the scence user see
    private Integer ScenceX;
    private Integer ScenceY;
    //player status >> cards, holes, footsteps(score) and earthimg
    private Player status[] = new Player[]{new Player(), new Player(), new Player(), new Player()};
    private JButton user[] = new JButton[5];
    private JLabel player1[] = new JLabel[5], player2[] = new JLabel[5], player3[] = new JLabel[5];
    private ArrayList<Integer> cards, P1cards, P2cards, P3cards;
    private JLabel holes, P1holes, P2holes, P3holes;
    private JLabel footsteps, P1footsteps, P2footsteps, P3footsteps;
    private JLabel earth, P1earth, P2earth, P3earth;
    //show cards and play
    private Deck cardDeck;
    private JLabel showCard = new JLabel();
    private Integer[] cardNum = new Integer[5];
    private int record;
    private PlayAction playAction = new PlayAction();
    private int userDraw = 1;

    public ScencePanel(){
        this.ScenceX = 0;
        this.ScenceY = 0;
        
        setLayout(null);
        
        JButton startBtn = new JButton(startIcon);
        startBtn.setActionCommand("START");
        startBtn.setBounds(494, 500, 293, 50);
        startBtn.setOpaque(false);
        startBtn.setBorder(null);
        startBtn.setContentAreaFilled(false);
        startBtn.addActionListener(this);
        add(startBtn);
        JButton ruleBtn = new JButton(ruleIcon);
        ruleBtn.setActionCommand("RULE");
        ruleBtn.setBounds(494, 560, 293, 50);
        ruleBtn.setOpaque(false);
        ruleBtn.setBorder(null);
        ruleBtn.setContentAreaFilled(false);
        ruleBtn.addActionListener(this);
        add(ruleBtn);
        JButton exitBtn = new JButton(exitIcon);
        exitBtn.setActionCommand("EXIT");
        exitBtn.setBounds(494, 620, 293, 50);
        exitBtn.setOpaque(false);
        exitBtn.setBorder(null);
        exitBtn.setContentAreaFilled(false);
        exitBtn.addActionListener(this);
        add(exitBtn);
    }

    public void actionPerformed(ActionEvent e){
        String btnStr = e.getActionCommand();
        if(btnStr.equals("START")){
            this.ScenceX = 0;
            this.ScenceY = 740;
            removeAll();

            //DECK CLASS
            cardDeck = new Deck();

            showCard.setBounds(511, 190, 244, 321);
            add(showCard);
            showCard.setVisible(false);
            //PLAY BUTTON
            JButton playBtn = new JButton(playIcon);
            playBtn.setActionCommand("PLAY");
            playBtn.setBounds(905, 625, 234, 100);
            playBtn.setOpaque(false);
            playBtn.setBorder(null);
            playBtn.setContentAreaFilled(false);
            playBtn.addActionListener(this);
            add(playBtn);

            //DECK BUTTON
            JButton stack = new JButton(cardStack);
            stack.setActionCommand("DRAW");
            stack.setBounds(590, 310, 96, 82);
            stack.setOpaque(false);
            stack.setBorder(null);
            stack.setContentAreaFilled(false);
            stack.addActionListener(this);
            add(stack);

            //USER's card
            // userStatus = new Player();
            cards = status[0].getCards();
            
            holes = new JLabel(number[status[0].getHoles()]);
            holes.setBounds(620 ,670 , 50, 50);
            add(holes);
            footsteps = new JLabel(number[status[0].getFootsteps()]);
            footsteps.setBounds(390 ,670 , 50, 50);
            add(footsteps);
            earth = new JLabel(userEarth[status[0].getHoles()]);
            earth.setBounds(0 ,442 , 390, 298);
            add(earth);

            //RECORD CARD NUMBER
            for(int num = 1 ; num <= 5 ; num++){
                if(num < cards.size()){
                    cardNum[num-1] = cards.get(num);
                }else{
                    cardNum[num-1] = 0;
                }
            }
            for(int x = 0 ; x < cards.get(0) ; x++){
                user[x] = new JButton(playerCard);
                user[x].setActionCommand("CARD" + String.valueOf(x));
                user[x].setBounds(380 + x*120, 450, 111, 144);
                user[x].setOpaque(false);
                user[x].setBorder(null);
                user[x].setContentAreaFilled(false);
                user[x].addActionListener(this);
                //FOR MOUSE HOVER TO SEE THE CARD INFO
                user[x].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        Object btn;
                        btn = e.getSource();
                        Integer count = 0;
                        //CHECK WHICH CARD HOVER
                        for(JButton check: user){
                            if(check == btn){
                                showCard.setIcon(cardDeck.getCardImg(cardNum[count]));
                            }
                            count++;
                        }
                        showCard.setVisible(true);
                        
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        showCard.setVisible(false);
                    }
                });
                add(user[x]);
            }

            //PLAYER1's card
            // P1Status = new Player();
            P1cards = status[1].getCards();

            P1holes = new JLabel(number[status[1].getHoles()]);
            P1holes.setBounds(1170 ,450 , 50, 50);
            add(P1holes);
            P1footsteps = new JLabel(number[status[1].getFootsteps()]);
            P1footsteps.setBounds(1170 ,375 , 50, 50);
            add(P1footsteps);
            P1earth = new JLabel(playerEarth[status[1].getHoles()]);
            P1earth.setBounds(1060 ,125 , 207, 203);
            add(P1earth);

            for(int x = 0 ; x < P1cards.get(0) ; x++){
                player1[x] = new JLabel(player1Card);
                player1[x].setBounds(940 + x*10, 180 + x*61, 78, 79);
                add(player1[x]);
            }

            //PLAYER2's card
            // P2Status = new Player();
            P2cards = status[2].getCards();

            P2holes = new JLabel(number[status[2].getHoles()]);
            P2holes.setBounds(805 ,75 , 50, 50);
            add(P2holes);
            P2footsteps = new JLabel(number[status[2].getFootsteps()]);
            P2footsteps.setBounds(585 ,75 , 50, 50);
            add(P2footsteps);
            P2earth = new JLabel(playerEarth[status[2].getHoles()]);
            P2earth.setBounds(295 ,0 , 207, 203);
            add(P2earth);

            for(int x = 0 ; x < P2cards.get(0) ; x++){
                player2[x] = new JLabel(player2Card);
                player2[x].setBounds(510 + x*75, 150, 59, 78);
                add(player2[x]);
            }

            //PLAYER3's card
            // P3Status = new Player();
            P3cards = status[3].getCards();

            P3holes = new JLabel(number[status[3].getHoles()]);
            P3holes.setBounds(100 ,450 , 50, 50);
            add(P3holes);
            P3footsteps = new JLabel(number[status[3].getFootsteps()]);
            P3footsteps.setBounds(100 ,375 , 50, 50);
            add(P3footsteps);
            P3earth = new JLabel(playerEarth[status[3].getHoles()]);
            P3earth.setBounds(0 ,120 , 207, 203);
            add(P3earth);

            for(int x = 0 ; x < P3cards.get(0) ; x++){
                player3[x] = new JLabel(player3Card);
                player3[x].setBounds(210 + x*10, 440 - x*61, 78, 79);
                add(player3[x]);
            }
            repaint();
        }else if(btnStr.equals("RULE")){
            this.ScenceX = 0;
            this.ScenceY = 1480;
            removeAll();
            JButton backBtn = new JButton(backIcon);
            backBtn.setActionCommand("BACK");
            backBtn.setBounds(494, 600, 293, 50);
            backBtn.setOpaque(false);
            backBtn.setBorder(null);
            backBtn.setContentAreaFilled(false);
            backBtn.addActionListener(this);
            add(backBtn);
            repaint();
        }else if(btnStr.equals("EXIT")){
            checkExit = new CheckExit();
            checkExit.setVisible(true);
        }else if(btnStr.equals("BACK")){
            this.ScenceX = 0;
            this.ScenceY = 0;
            repaint();
            removeAll();
            JButton startBtn = new JButton(startIcon);
            startBtn.setActionCommand("START");
            startBtn.setBounds(494, 500, 293, 50);
            startBtn.setOpaque(false);
            startBtn.setBorder(null);
            startBtn.setContentAreaFilled(false);
            startBtn.addActionListener(this);
            add(startBtn);
            JButton ruleBtn = new JButton(ruleIcon);
            ruleBtn.setActionCommand("RULE");
            ruleBtn.setBounds(494, 560, 293, 50);
            ruleBtn.setOpaque(false);
            ruleBtn.setBorder(null);
            ruleBtn.setContentAreaFilled(false);
            ruleBtn.addActionListener(this);
            add(ruleBtn);
            JButton exitBtn = new JButton(exitIcon);
            exitBtn.setActionCommand("EXIT");
            exitBtn.setBounds(494, 620, 293, 50);
            exitBtn.setOpaque(false);
            exitBtn.setBorder(null);
            exitBtn.setContentAreaFilled(false);
            exitBtn.addActionListener(this);
            add(exitBtn);
        }else if(btnStr.equals("PLAY")){
            //NOT YET DEAL WITH THAT USER CAN ONLY PLAY AT HIS/HER TURN
            playAction.setPlayers(status);
            playAction.setCard(cardNum[record]);
            
            cards.remove(record + 1);
            status[0].setCards(cards);
            this.ScenceX = 0;
            this.ScenceY = 740;
            removeAll();

            //DECK CLASS
            cardDeck = new Deck();

            showCard.setBounds(511, 190, 244, 321);
            add(showCard);
            showCard.setVisible(false);
            //PLAY BUTTON
            JButton playBtn = new JButton(playIcon);
            playBtn.setActionCommand("PLAY");
            playBtn.setBounds(905, 625, 234, 100);
            playBtn.setOpaque(false);
            playBtn.setBorder(null);
            playBtn.setContentAreaFilled(false);
            playBtn.addActionListener(this);
            add(playBtn);

            //DECK BUTTON
            JButton stack = new JButton(cardStack);
            stack.setActionCommand("DRAW");
            stack.setBounds(590, 310, 96, 82);
            stack.setOpaque(false);
            stack.setBorder(null);
            stack.setContentAreaFilled(false);
            stack.addActionListener(this);
            add(stack);

            //FOR TEST!!!!!!
            userDraw++;

            //USER's card
            cards = status[0].getCards();
            
            holes = new JLabel(number[status[0].getHoles()]);
            holes.setBounds(620 ,670 , 50, 50);
            add(holes);
            footsteps = new JLabel(number[status[0].getFootsteps()]);
            footsteps.setBounds(390 ,670 , 50, 50);
            add(footsteps);
            earth = new JLabel(userEarth[status[0].getHoles()]);
            earth.setBounds(0 ,442 , 390, 298);
            add(earth);

            //RECORD CARD NUMBER
            for(int num = 1 ; num <= 5 ; num++){
                if(num < cards.size()){
                    cardNum[num-1] = cards.get(num);
                }else{
                    cardNum[num-1] = 0;
                }
            }
            for(int x = 0 ; x < cards.get(0) ; x++){
                user[x] = new JButton(playerCard);
                user[x].setActionCommand("CARD" + String.valueOf(x));
                user[x].setBounds(380 + x*120, 450, 111, 144);
                user[x].setOpaque(false);
                user[x].setBorder(null);
                user[x].setContentAreaFilled(false);
                user[x].addActionListener(this);
                //FOR MOUSE HOVER TO SEE THE CARD INFO
                user[x].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        Object btn;
                        btn = e.getSource();
                        Integer count = 0;
                        //CHECK WHICH CARD HOVER
                        for(JButton check: user){
                            if(check == btn){
                                showCard.setIcon(cardDeck.getCardImg(cardNum[count]));
                            }
                            count++;
                        }
                        showCard.setVisible(true);
                        
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        showCard.setVisible(false);
                    }
                });
                add(user[x]);
            }

            //PLAYER1's card
            P1cards = status[1].getCards();

            P1holes = new JLabel(number[status[1].getHoles()]);
            P1holes.setBounds(1170 ,450 , 50, 50);
            add(P1holes);
            P1footsteps = new JLabel(number[status[1].getFootsteps()]);
            P1footsteps.setBounds(1170 ,375 , 50, 50);
            add(P1footsteps);
            P1earth = new JLabel(playerEarth[status[1].getHoles()]);
            P1earth.setBounds(1060 ,125 , 207, 203);
            add(P1earth);

            for(int x = 0 ; x < P1cards.get(0) ; x++){
                player1[x] = new JLabel(player1Card);
                player1[x].setBounds(940 + x*10, 180 + x*61, 78, 79);
                add(player1[x]);
            }

            //PLAYER2's card
            P2cards = status[2].getCards();

            P2holes = new JLabel(number[status[2].getHoles()]);
            P2holes.setBounds(805 ,75 , 50, 50);
            add(P2holes);
            P2footsteps = new JLabel(number[status[2].getFootsteps()]);
            P2footsteps.setBounds(585 ,75 , 50, 50);
            add(P2footsteps);
            P2earth = new JLabel(playerEarth[status[2].getHoles()]);
            P2earth.setBounds(295 ,0 , 207, 203);
            add(P2earth);

            for(int x = 0 ; x < P2cards.get(0) ; x++){
                player2[x] = new JLabel(player2Card);
                player2[x].setBounds(510 + x*75, 150, 59, 78);
                add(player2[x]);
            }

            //PLAYER3's card
            P3cards = status[3].getCards();

            P3holes = new JLabel(number[status[3].getHoles()]);
            P3holes.setBounds(100 ,450 , 50, 50);
            add(P3holes);
            P3footsteps = new JLabel(number[status[3].getFootsteps()]);
            P3footsteps.setBounds(100 ,375 , 50, 50);
            add(P3footsteps);
            P3earth = new JLabel(playerEarth[status[3].getHoles()]);
            P3earth.setBounds(0 ,120 , 207, 203);
            add(P3earth);

            for(int x = 0 ; x < P3cards.get(0) ; x++){
                player3[x] = new JLabel(player3Card);
                player3[x].setBounds(210 + x*10, 440 - x*61, 78, 79);
                add(player3[x]);
            }
            repaint();

        }else if(btnStr.equals("CARD0")){           
            this.record = 0;                        //RECORD THE CARD YOU CHOOSE
        }else if(btnStr.equals("CARD1")){
            this.record = 1;                        //RECORD THE CARD YOU CHOOSE
        }else if(btnStr.equals("CARD2")){
            this.record = 2;                        //RECORD THE CARD YOU CHOOSE
        }else if(btnStr.equals("CARD3")){
            this.record = 3;                        //RECORD THE CARD YOU CHOOSE
        }else if(btnStr.equals("CARD4")){
            this.record = 4;                        //RECORD THE CARD YOU CHOOSE
        }else if(btnStr.equals("DRAW")){
            while(userDraw > 0){                    //IF USER CAN DRAW A CARD,
                int x = cards.size() - 1;           //LET USER DRAW
                cards.add((int)((Math.random()*100)%16+1));
                status[0].setCards(cards);
                cardNum[x] = cards.get(x+1);
                user[x] = new JButton(playerCard);
                user[x].setActionCommand("CARD" + String.valueOf(x));
                user[x].setBounds(380 + x*120, 450, 111, 144);
                user[x].setOpaque(false);
                user[x].setBorder(null);
                user[x].setContentAreaFilled(false);
                user[x].addActionListener(this);
                //FOR MOUSE HOVER TO SEE THE CARD INFO
                user[x].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        Object btn;
                        btn = e.getSource();
                        Integer count = 0;
                        //CHECK WHICH CARD HOVER
                        for(JButton check: user){
                            if(check == btn){
                                showCard.setIcon(cardDeck.getCardImg(cardNum[count]));
                            }
                            count++;
                        }
                        showCard.setVisible(true);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        showCard.setVisible(false);
                    }
                });
                add(user[x]);
                repaint();
                userDraw--;
            }
        }else{
            System.out.println("Unexepcted Error!!");
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.Scence, -ScenceX, -ScenceY, this.Scence.getWidth(null), this.Scence.getHeight(null), null);
    }
}
