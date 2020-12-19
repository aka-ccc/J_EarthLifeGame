import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameFrame extends JFrame {
    private CheckExit checkExit;
    private ScencePanel scencePanel;
    public GameFrame() {
        super("J-GAME");
        setSize(1280, 770);
        //set window in the center of the screen
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new CheckOnExit());
        setLayout(new BorderLayout());
        scencePanel = new ScencePanel();
        add(scencePanel, BorderLayout.CENTER);
    }

    private class CheckOnExit implements WindowListener {
        public void windowOpened(WindowEvent e){}
        public void windowClosing(WindowEvent e){
            checkExit = new CheckExit();
            checkExit.setVisible(true);
        }
        public void windowClosed(WindowEvent e){}
        public void windowIconified(WindowEvent e){}
        public void windowDeiconified(WindowEvent e){}
        public void windowActivated(WindowEvent e){}
        public void windowDeactivated(WindowEvent e){}
    }
}
