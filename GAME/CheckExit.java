import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//this is for check if user really want to exit the game
public class CheckExit extends JFrame implements ActionListener {
    public CheckExit(){
        setSize(200 ,120);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
            
        JPanel confrimPanel = new JPanel();
        confrimPanel.setLayout(new FlowLayout());
        JLabel confirmWord = new JLabel("WANT TO EXIT THE GAME?");
        confrimPanel.add(confirmWord);
        add(confrimPanel, BorderLayout.CENTER);
            
        JPanel btnPanel = new JPanel();
        JButton yesBtn = new JButton("YES");
        JButton noBtn = new JButton("NO");
        yesBtn.addActionListener(this);
        noBtn.addActionListener(this);
        btnPanel.setLayout(new FlowLayout());
        btnPanel.add(yesBtn);
        btnPanel.add(noBtn);

        this.add(btnPanel, BorderLayout.SOUTH);
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
    
}