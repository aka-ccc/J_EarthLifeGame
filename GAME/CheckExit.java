import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//this is for check if user really want to exit the game
public class CheckExit extends JFrame implements ActionListener {
    private Image background = new ImageIcon("Resource/exitframe/frame.png").getImage();
    private ImageIcon noIcon = new ImageIcon("Resource/exitframe/nobutton.png");
    private ImageIcon yesIcon = new ImageIcon("Resource/exitframe/yesbutton.png");
    public CheckExit(){
        setSize(560 ,330);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        ConfrimPanel confrimPanel = new ConfrimPanel(); 
        confrimPanel.setBounds(0, 0, 560, 300);
        add(confrimPanel, BorderLayout.CENTER);
        confrimPanel.setLayout(null);

        JButton yesBtn = new JButton(yesIcon);
        yesBtn.setActionCommand("YES");
        yesBtn.setBounds(45, 200, 205, 58);
        yesBtn.setOpaque(false);
        yesBtn.setBorder(null);
        yesBtn.setContentAreaFilled(false);
        yesBtn.addActionListener(this);
        confrimPanel.add(yesBtn);

        JButton noBtn = new JButton(noIcon);
        noBtn.setActionCommand("NO");
        noBtn.setBounds(300, 200, 205, 58);
        noBtn.setOpaque(false);
        noBtn.setBorder(null);
        noBtn.setContentAreaFilled(false);
        noBtn.addActionListener(this);
        confrimPanel.add(noBtn);

        
    }
    public void actionPerformed(ActionEvent e)  {
        String winAct = e.getActionCommand();
        if(winAct.equals("YES")){
            System.exit(0);
        }else if(winAct.equals("NO")){
            dispose();
        }else{
            System.out.println("Unexepcted Error in Confirm Window.");
        }
    }
    private class ConfrimPanel extends JPanel {
        @Override 
        public void paintComponent(Graphics g){ 
            super.paintComponent(g); 
            g.drawImage(background, 0, 0, background.getWidth(null), background.getHeight(null), null); 
        }
    }
}