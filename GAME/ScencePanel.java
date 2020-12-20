import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.border.LineBorder;

public class ScencePanel extends JPanel implements ActionListener {
    //check if you really want to exit the game
    private CheckExit checkExit;
    //LOAD A LOT OF IMGS
    private Image Scence = new ImageIcon("Resource/all.png").getImage();
    //Other Btns
    private ImageIcon startIcon = new ImageIcon("Resource/home/start_button.png"), ruleIcon = new ImageIcon("Resource/home/rule_button.png"), exitIcon = new ImageIcon("Resource/home/end_button.png"), backIcon = new ImageIcon("Resource/rule/return_button.png"), playIcon = new ImageIcon("Resource/main/play.png");
    //PLAYER's CARDs
    private ImageIcon playerCard = new ImageIcon("Resource/main/card2_big.png"), player1Card = new ImageIcon("Resource/main/card_right.png"), player2Card = new ImageIcon("Resource/main/card.png"), player3Card = new ImageIcon("Resource/main/card_left.png");
    //NUMBERs
    private ImageIcon number[] = new ImageIcon[]{new ImageIcon("Resource/number/0.png"),new ImageIcon("Resource/number/1.png"),new ImageIcon("Resource/number/2.png"),new ImageIcon("Resource/number/3.png"),new ImageIcon("Resource/number/4.png"),new ImageIcon("Resource/number/5.png"),new ImageIcon("Resource/number/6.png"),new ImageIcon("Resource/number/7.png"),new ImageIcon("Resource/number/8.png"),new ImageIcon("Resource/number/9.png"),new ImageIcon("Resource/number/10.png"),new ImageIcon("Resource/number/11.png"),new ImageIcon("Resource/number/12.png"),new ImageIcon("Resource/number/13.png"),new ImageIcon("Resource/number/14.png"),new ImageIcon("Resource/number/15.png")};
    private ImageIcon userEarth[] = new ImageIcon[]{new ImageIcon("Resource/main/eth_button_ori.png"),new ImageIcon("Resource/main/eth_button_h1.png"),new ImageIcon("Resource/main/eth_button_h2.png"),new ImageIcon("Resource/main/eth_button_h3.png")};
    //EARTH
    private ImageIcon playerEarth[] = new ImageIcon[]{new ImageIcon("Resource/main/eth_ori.png"),new ImageIcon("Resource/main/eth_h1.png"),new ImageIcon("Resource/main/eth_h2.png"),new ImageIcon("Resource/main/eth_h3.png")};
    private ImageIcon cardStack = new ImageIcon("Resource/main/deck.png");
    private ImageIcon chooseFrame = new ImageIcon("Resource/chooseframe/chooseframe1.png");
    private ImageIcon whoturn[] = new ImageIcon[]{new ImageIcon("Resource/main/your_turn.png"), new ImageIcon("Resource/main/thinking.png")};
    private ImageIcon quest = new ImageIcon("Resource/main/quest.png");
    //RULE_FRAME
    private ImageIcon ruleFrame = new ImageIcon("Resource/main/rule_frame.png"), closeImg = new ImageIcon("Resource/main/close_button.png");
    //GAME_SCENCE_OTHERs
    private ImageIcon hint = new ImageIcon("Resource/main/deck_note.png");
    private ImageIcon restartImg = new ImageIcon("Resource/main/afresh.png");
    //WIN or LOSE
    private ImageIcon winPanel = new ImageIcon("Resource/main/win.png"), losePanel = new ImageIcon("Resource/main/lost.png");
    //decide the scence user see
    private Integer ScenceX, ScenceY;
    //init_Scence_Btns
    private JButton startBtn = new JButton(startIcon), ruleBtn = new JButton(ruleIcon), exitBtn = new JButton(exitIcon);
    //rule_Scence_Btns
    private JButton backBtn = new JButton(backIcon);
    //game_Scence_Objs
    private Player status[] = new Player[]{new Player(), new Player(), new Player(), new Player()};
    private JButton user[] = new JButton[]{new JButton(playerCard), new JButton(playerCard), new JButton(playerCard), new JButton(playerCard), new JButton(playerCard)};
    private ArrayList<Integer> cards, P1cards, P2cards, P3cards;
    private JLabel player1[] = new JLabel[]{new JLabel(player1Card), new JLabel(player1Card), new JLabel(player1Card), new JLabel(player1Card), new JLabel(player1Card)}, player2[] = new JLabel[]{new JLabel(player2Card), new JLabel(player2Card), new JLabel(player2Card), new JLabel(player2Card), new JLabel(player2Card)}, player3[] = new JLabel[]{new JLabel(player3Card), new JLabel(player3Card), new JLabel(player3Card), new JLabel(player3Card), new JLabel(player3Card)};
    private JLabel holes = new JLabel(), P1holes = new JLabel(), P2holes = new JLabel(), P3holes = new JLabel();
    private JLabel footsteps = new JLabel(), P1footsteps = new JLabel(), P2footsteps = new JLabel(), P3footsteps = new JLabel();
    private JLabel earth = new JLabel(), P1earth = new JLabel(), P2earth = new JLabel(), P3earth = new JLabel();
    private JLabel whoTurn[] = new JLabel[]{new JLabel(whoturn[0]), new JLabel(whoturn[1]), new JLabel(whoturn[1]), new JLabel(whoturn[1])};
    //get_card_imgs
    private Deck cardDeck = new Deck();
    //set_user_hover(user's_cards)
    private JLabel showCard = new JLabel();
    //record_user's_cards_and_use_it_to_get_imgs
    private Integer[] cardNum = new Integer[5];
    //record_the_card_user_choose
    private int record;
    //set_how_many_card_user_can_draw
    private int userDraw = 1;
    //game_Scence_Objs
    private boolean userAction = true;
    private JLabel playerHit = new JLabel(), choose = new JLabel(chooseFrame), ruleLabel = new JLabel(ruleFrame), hintLabel = new JLabel(hint), winLabel = new JLabel(winPanel), loseLabel = new JLabel(losePanel);
    private JButton closeBtn = new JButton(closeImg), restartBtn = new JButton(restartImg), playBtn = new JButton(playIcon), stack = new JButton(cardStack), questBtn = new JButton(quest);

    public ScencePanel(){

        setScence(0, 0);
        setLayout(null);
        setObjectsStatus();
        add(startBtn);
        add(ruleBtn);
        add(exitBtn);
    }

    public void actionPerformed(ActionEvent e){
        String btnStr = e.getActionCommand();
        if(btnStr.equals("START")){
            System.gc();
            //initialize the status of players
            for(int i = 0 ; i < 4 ; i++) {
                status[i] = new Player();
            }
            record = 0;
            setDraw(1);
            resetUserAction(true);
            gameScence();
            setRuleLabelVisible(true);
            setWhoturnLabelVisible(0, true);
            setHintLabelVisible(true);
            new Thread( new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        //UPDATE SCENCE
                        setWhoturnLabelVisible(0, false);
                        repaint();
                    }catch(InterruptedException e) {
                        System.out.println("Unexpected interruption");
                        System.exit(0);
                    }
                }
            }).start();
        }else if(btnStr.equals("RULE")){
            setScence(0, 1480);
            removeAll();
            add(backBtn);
            repaint();
        }else if(btnStr.equals("EXIT")){
            checkExit = new CheckExit();
            checkExit.setVisible(true);
        }else if(btnStr.equals("BACK")){
            setScence(0, 0);
            removeAll();
            add(startBtn);
            add(ruleBtn);
            add(exitBtn);
            repaint();
        }else if(btnStr.equals("PLAY")){

            if(userDraw == 0 && (userAction == true) && record >= 0){

                user[record].setBorder(null);
                resetUserAction(false);
                // Thread playAct = new Thread(new PlayAction(this, status, cardNum[record], 0));
                // playAct.start();
                // Thread playAct = new Thread(new ComputerPlay(this, status, cardDeck, cardNum[record], 0));
                // playAct.start();
                /////////////////////////////////////////////////////////////////////////////////
                
                //UPDATE THE CARDINFO OF THE USER
                cards.remove(record + 1);
                cards.set(0, cards.get(0) - 1);
                status[0].setCards(cards);
                Thread playAct = new Thread(new PlayAction(this, status, cardNum[record], 0));
                playAct.start();
                gameScence();
                setRuleLabelVisible(false);
                setWhoturnLabelVisible(0, false);
                setHintLabelVisible(false);
                
                new Thread( new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                            //UPDATE SCENCE
                            repaint();
                        }catch(InterruptedException e) {
                            System.out.println("Unexpected interruption");
                            System.exit(0);
                        }
                    }
                }).start();

                if(checkGameOver()) {

                }else{
                    Thread ComputerPlayAct = new Thread(new ComputerPlay(this, status, cardDeck));
                    ComputerPlayAct.start();
                }
                repaint();

            }else if(userDraw != 0 ) {
                System.out.println("DRAW A CARD PLEASE!");
            }else{
                System.out.println("CHOOSE A CARD PLEASE!");
            }

        }else if(btnStr.equals("CARD0")){           
            if(record >= 0) {
                user[record].setBorder(null);
            }
            this.record = 0;                        //RECORD THE CARD YOU CHOOSE
            user[record].setBorder(new LineBorder(Color.YELLOW, 5));
        }else if(btnStr.equals("CARD1")){
            if(record >= 0) {
                user[record].setBorder(null);
            }
            this.record = 1;                        //RECORD THE CARD YOU CHOOSE
            user[record].setBorder(new LineBorder(Color.YELLOW, 5));
        }else if(btnStr.equals("CARD2")){
            if(record >= 0) {
                user[record].setBorder(null);
            }
            this.record = 2;                        //RECORD THE CARD YOU CHOOSE
            user[record].setBorder(new LineBorder(Color.YELLOW, 5));
        }else if(btnStr.equals("CARD3")){
            if(record >= 0) {
                user[record].setBorder(null);
            }
            this.record = 3;                        //RECORD THE CARD YOU CHOOSE
            user[record].setBorder(new LineBorder(Color.YELLOW, 5));
        }else if(btnStr.equals("CARD4")){
            if(record >= 0) {
                user[record].setBorder(null);
            }
            this.record = 4;                        //RECORD THE CARD YOU CHOOSE
            user[record].setBorder(new LineBorder(Color.YELLOW, 5));
        }else if(btnStr.equals("DRAW")){
            while(userDraw > 0){                    //IF USER CAN DRAW A CARD,
                setHintLabelVisible(false);
                int x = cards.size() - 1;           //LET USER DRAW
                cards.add((int)((Math.random()*100)%38+1));
                cards.set(0, cards.get(0) + 1);
                status[0].setCards(cards);
                cardNum[x] = cards.get(x+1);
                //FOR MOUSE HOVER TO SEE THE CARD INFO
                user[x].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        Object btn = e.getSource();
                        Integer count = 0;
                        //CHECK WHICH CARD HOVER
                        for(JButton check: user){
                            if(check == btn){
                                showCard.setIcon(cardDeck.getCardImg(cardNum[count]));
                            }
                            count++;
                        }
                        setShowCardVisible(true);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        setShowCardVisible(false);
                    }
                });
                add(user[x]);
                repaint();
                setDraw(getDraw()-1);
                user[record].setBorder(null);
                record = -1;
            }
        }else if(btnStr.equals("QUEST")) {
            setRuleLabelVisible(true);
        }else if(btnStr.equals("CLOSE")) {
            setRuleLabelVisible(false);
        }else{
            System.out.println("Unexepcted Error!!");
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.Scence, -ScenceX, -ScenceY, this.Scence.getWidth(null), this.Scence.getHeight(null), null);
    }
    public int getDraw() {
        return this.userDraw;
    }
    public void setDraw(int draw) {
        this.userDraw = draw;
    }
    public void resetUserAction(boolean action){
        this.userAction = action;
    }
    public void setCardImg(ImageIcon img, boolean show) {
        this.playerHit.setIcon(img);
        this.playerHit.setVisible(show);
    }
    public JLabel setChoose() {
        return this.choose;
    }
    public void setChooseVisible(boolean show) {
        this.choose.setVisible(show);
    }
    public void setScence(int x, int y) {
        this.ScenceX = x;
        this.ScenceY = y;
    }
    public void setWinLabelVisible(boolean show) {
        this.winLabel.setVisible(show);
    }
    public void setLoseLabelVisible(boolean show) {
        this.loseLabel.setVisible(show);
    }
    public void setRuleLabelVisible(boolean show) {
        this.ruleLabel.setVisible(show);
    }
    public void setWhoturnLabelVisible(int who, boolean show) {
        this.whoTurn[who].setVisible(show);
    }
    public void setShowCardVisible(boolean show) {
        this.showCard.setVisible(show);
    }
    public void setHintLabelVisible(boolean show) {
        this.hintLabel.setVisible(show);
    }
    public void setPlayerHitVisible(boolean show) {
        this.playerHit.setVisible(show);
    }
    public void setObjectsStatus() {

        //INIT_SCENCE_OBJECTS
        //START_BTN
        startBtn.setActionCommand("START");
        startBtn.setBounds(494, 500, 293, 50);
        startBtn.setOpaque(false);
        startBtn.setBorder(null);
        startBtn.setContentAreaFilled(false);
        startBtn.addActionListener(this);
        //RULE_BTN
        ruleBtn.setActionCommand("RULE");
        ruleBtn.setBounds(494, 560, 293, 50);
        ruleBtn.setOpaque(false);
        ruleBtn.setBorder(null);
        ruleBtn.setContentAreaFilled(false);
        ruleBtn.addActionListener(this);
        //EXIT_BTN
        exitBtn.setActionCommand("EXIT");
        exitBtn.setBounds(494, 620, 293, 50);
        exitBtn.setOpaque(false);
        exitBtn.setBorder(null);
        exitBtn.setContentAreaFilled(false);
        exitBtn.addActionListener(this);

        //RULE_SCENCE_OBJECTS
        backBtn.setActionCommand("BACK");
        backBtn.setBounds(494, 600, 293, 50);
        backBtn.setOpaque(false);
        backBtn.setBorder(null);
        backBtn.setContentAreaFilled(false);
        backBtn.addActionListener(this);

        //MAIN(GAME)_SCENCE_OBJECTS

        //WIN, LOSE PANELs
        winLabel.setBounds(0, 0, 1280, 740);
        loseLabel.setBounds(0, 0, 1280, 740);
        //RULE FRAME
        ruleLabel.setBounds(190, 130, 900, 480);
        //RULE FRAME CLOSE_BTN
        closeBtn.setActionCommand("CLOSE");
        closeBtn.setBounds(800, 20, 74, 72);
        closeBtn.setOpaque(false);
        closeBtn.setBorder(null);
        closeBtn.setContentAreaFilled(false);
        closeBtn.addActionListener(this);
        ruleLabel.add(closeBtn);
        //WHO's TURN LABEL
        whoTurn[0].setBounds(464, 160, 352, 330);
        whoTurn[1].setBounds(1040, 152, 32, 156);
        whoTurn[2].setBounds(275, 13, 32, 156);
        whoTurn[3].setBounds(190, 152, 32, 156);
        //CHOOSE_FRAME
        choose.setBounds(360, 200, 560, 300);
        //RESTART BUTTON
        restartBtn.setBounds(1035, 15, 215, 56);
        restartBtn.setActionCommand("START");
        restartBtn.setOpaque(false);
        restartBtn.setBorder(null);
        restartBtn.setContentAreaFilled(false);
        restartBtn.addActionListener(this);
        //PLAYER_HIT
        playerHit.setBounds(100, 160, 340, 448);
        //SHOWCARD
        showCard.setBounds(470, 160, 340, 448);
        //HINT
        hintLabel.setBounds(675, 235, 83, 131);

        //PLAY_BTN
        playBtn.setActionCommand("PLAY");
        playBtn.setBounds(905, 630, 230, 94);
        playBtn.setOpaque(false);
        playBtn.setBorder(null);
        playBtn.setContentAreaFilled(false);
        playBtn.addActionListener(this);
        //DECK_BTN
        stack.setActionCommand("DRAW");
        stack.setBounds(590, 310, 96, 82);
        stack.setOpaque(false);
        stack.setBorder(null);
        stack.setContentAreaFilled(false);
        stack.addActionListener(this);
        //QUEST BUTTON
        questBtn.setActionCommand("QUEST");
        questBtn.setBounds(1155, 630, 92, 92);
        questBtn.setOpaque(false);
        questBtn.setBorder(null);
        questBtn.setContentAreaFilled(false);
        questBtn.addActionListener(this);

        //USER's STATUS
        holes.setBounds(620 ,670 , 50, 50);
        footsteps.setBounds(390 ,670 , 50, 50);
        earth.setBounds(0 ,442 , 390, 298);
        //USER's CARDs
        for(int x = 0 ; x < 5 ; x++){
            user[x].setActionCommand("CARD" + String.valueOf(x));
            user[x].setBounds(380 + x*120, 450, 111, 144);
            user[x].setOpaque(false);
            user[x].setBorder(null);
            user[x].setContentAreaFilled(false);
            user[x].addActionListener(this);
        }
        //P1's STATUS  
        P1holes.setBounds(1170 ,450 , 50, 50);
        P1footsteps.setBounds(1170 ,375 , 50, 50);
        P1earth.setBounds(1060 ,125 , 207, 203);
        //P1's CARDs
        for(int x = 0 ; x < 5 ; x++){
            player1[x].setBounds(940 + x*10, 180 + x*61, 78, 79);
        }
        //P2's STATUS
        P2holes.setBounds(805 ,75 , 50, 50);
        P2footsteps.setBounds(585 ,75 , 50, 50);
        P2earth.setBounds(295 ,0 , 207, 203);
        //P2's CARDs
        for(int x = 0 ; x < 5 ; x++){
            player2[x].setBounds(510 + x*75, 150, 59, 78);
        }
        //P3's STATUS
        P3holes.setBounds(100 ,450 , 50, 50);
        P3footsteps.setBounds(100 ,375 , 50, 50);
        P3earth.setBounds(0 ,120 , 207, 203);
        //P3's CARDs
        for(int x = 0 ; x < 5 ; x++){
            player3[x].setBounds(210 + x*10, 440 - x*61, 78, 79);
        }
    }
    public void gameScence() {

        setScence(0, 740);
        removeAll();

        add(winLabel);
        add(loseLabel);
        setWinLabelVisible(false);
        setLoseLabelVisible(false);

        //RULE FRAME
        add(ruleLabel);
        setRuleLabelVisible(false);
        //WHO TURN
        add(whoTurn[0]);
        setWhoturnLabelVisible(0, false);
        //CHOOSE_FRAME
        add(choose);
        setChooseVisible(false);
        //RESTART BUTTON
        add(restartBtn);
        //PLAYER_HIT
        add(playerHit);
        setPlayerHitVisible(false);
        //SHOWCARD
        add(showCard);
        setShowCardVisible(false);
        //HINT
        add(hintLabel);
        setHintLabelVisible(false);

        //PLAY BUTTON
        add(playBtn);
        //DECK BUTTON
        add(stack);
        //QUEST BUTTON
        add(questBtn);

        //USER's card
        cards = status[0].getCards();
            
        holes.setIcon(number[status[0].getHoles()]);
        add(holes);
        footsteps.setIcon(number[status[0].getFootsteps()]);
        add(footsteps);
        earth.setIcon(userEarth[status[0].getHoles()]);
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
            //FOR MOUSE HOVER TO SEE THE CARD INFO
            user[x].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    Object btn = e.getSource();
                    Integer count = 0;
                    //CHECK WHICH CARD HOVER
                    for(JButton check: user){
                        if(check == btn){
                            showCard.setIcon(cardDeck.getCardImg(cardNum[count]));
                        }
                        count++;
                    }
                    setShowCardVisible(true);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    setShowCardVisible(false);
                }
            });
            add(user[x]);
        }

        //PLAYER1's card
        P1cards = status[1].getCards();

        P1holes.setIcon(number[status[1].getHoles()]);
        add(P1holes);
        P1footsteps.setIcon(number[status[1].getFootsteps()]);
        add(P1footsteps);
        P1earth.setIcon(playerEarth[status[1].getHoles()]);
        add(P1earth);

        add(whoTurn[1]);
        setWhoturnLabelVisible(1, false);
        for(int x = 0 ; x < 5 ; x++){
            if(x < P1cards.get(0)){
                add(player1[x]);
            }else{
                add(player1[x]);
                setPlayerCardVisible(1, x, false);
            }
        }

        //PLAYER2's card
        P2cards = status[2].getCards();

        P2holes.setIcon(number[status[2].getHoles()]);
        add(P2holes);
        P2footsteps.setIcon(number[status[2].getFootsteps()]);
        add(P2footsteps);
        P2earth.setIcon(playerEarth[status[2].getHoles()]);
        add(P2earth);

        add(whoTurn[2]);
        setWhoturnLabelVisible(2, false);
        for(int x = 0 ; x < 5 ; x++){
            if(x < P2cards.get(0)){
                add(player2[x]);
            }else{
                add(player2[x]);
                setPlayerCardVisible(2, x, false);
            }
        }

        //PLAYER3's card
        P3cards = status[3].getCards();

        P3holes.setIcon(number[status[3].getHoles()]);
        add(P3holes);
        P3footsteps.setIcon(number[status[3].getFootsteps()]);
        add(P3footsteps);
        P3earth.setIcon(playerEarth[status[3].getHoles()]);
        add(P3earth);

        add(whoTurn[3]);
        setWhoturnLabelVisible(3, false);
        for(int x = 0 ; x < 5 ; x++){
            if(x < P3cards.get(0)){
                add(player3[x]);
            }else{
                add(player3[x]);
                setPlayerCardVisible(3, x, false);
            }
        }

        repaint();
    }
    public void setPlayerCardVisible(int player, int number, boolean show) {
        if(player == 1) {
            player1[number].setVisible(show);
        }else if(player == 2) {
            player2[number].setVisible(show);
        }else if(player == 3) {
            player3[number].setVisible(show);
        }else {
            System.out.println("Unexcepted ERROR!!");
        }
    }
    public boolean checkGameOver() {
        for(Player p:status) {
            if(p == status[0]) {
                if(p.checkLose()) {
                    setLoseLabelVisible(true);
                    return true;
                }
            }else if(p != status[3]){
                if(!p.checkLose()) {
                    return false;
                }else if(p.checkWin()) {
                    setLoseLabelVisible(true);
                    return true;
                }
            }else {
                if(!p.checkLose()) {
                    return false;
                }else if(p.checkWin()) {
                    setLoseLabelVisible(true);
                    return true;
                }
                setWinLabelVisible(true);
                status[0].setWin(true);
                return true;
            }
        }
        return false;
    }
}
