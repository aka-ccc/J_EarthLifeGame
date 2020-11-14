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
        JLabel confirmWord = new JLabel("確定要關閉遊戲嗎?");
        confrimPanel.add(confirmWord);
        add(confrimPanel, BorderLayout.CENTER);
            
        JPanel btnPanel = new JPanel();
        JButton yesBtn = new JButton("是");
        JButton noBtn = new JButton("否");
        yesBtn.addActionListener(this);
        noBtn.addActionListener(this);
        btnPanel.setLayout(new FlowLayout());
        btnPanel.add(yesBtn);
        btnPanel.add(noBtn);

        this.add(btnPanel, BorderLayout.SOUTH);
    }
    public void actionPerformed(ActionEvent e)  {
        String winAct = e.getActionCommand();
        if(winAct.equals("是")){
            System.exit(0);
        }else if(winAct.equals("否")){
            dispose();
        }else{
            System.out.println("Unexepcted Error in Confirm Window.");
        }
    }
    
}