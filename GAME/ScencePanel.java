import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ScencePanel extends JPanel implements ActionListener {
    private CheckExit checkExit;
    //load images
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
    private Integer ScenceX;
    private Integer ScenceY;
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
            this.ScenceY = 770;
            removeAll();
            JButton playBtn = new JButton(playIcon);
            playBtn.setActionCommand("PLAY");
            playBtn.setBounds(904, 600, 234, 100);
            playBtn.setOpaque(false);
            playBtn.setBorder(null);
            playBtn.setContentAreaFilled(false);
            playBtn.addActionListener(this);
            add(playBtn);
            //player's card
            //use variable to raplace the number 3
            JLabel player[] = new JLabel[3];
            for(int x = 0 ; x < 3 ; x++){
                player[x] = new JLabel(playerCard);
                player[x].setBounds(470 + x*120, 450, 111, 144);
                player[x].setOpaque(false);
                player[x].addMouseListener(new MouseAdapter(){
                    private ImageIcon cardIcon = new ImageIcon("Resource/originalcard/originalgame1.png");
                    private JLabel cardView = new JLabel(cardIcon);
                    @Override
                    public void mouseEntered(MouseEvent e){
                        super.mouseEntered(e);
                        cardView.setBounds(490, 230, 285, 376);
                        add(cardView);
                    }
                    public void mouseExited(MouseEvent e){
                        super.mouseExited(e);
                        remove(cardView);
                        revalidate();
                        repaint();
                    }
                });
                add(player[x]);
            }
            //right player's card
            //use variable to replace the number 3
            JLabel player1[] = new JLabel[3];
            for(int x = 0 ; x < 3 ; x++){
                player1[x] = new JLabel(player1Card);
                player1[x].setBounds(940 + x*10, 160 + x*61, 78, 79);
                add(player1[x]);
            }
            //up player's card
            //use variable to replace the number 3
            JLabel player2[] = new JLabel[3];
            for(int x = 0 ; x < 3 ; x++){
                player2[x] = new JLabel(player2Card);
                player2[x].setBounds(510 + x*75, 135, 59, 78);
                add(player2[x]);
            }
            //left player's card
            //use variable to replace the number 3
            JLabel player3[] = new JLabel[3];
            for(int x = 0 ; x < 3 ; x++){
                player3[x] = new JLabel(player3Card);
                player3[x].setBounds(193 + x*10, 401 - x*61, 78, 79);
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
