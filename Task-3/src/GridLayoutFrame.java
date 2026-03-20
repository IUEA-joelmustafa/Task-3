import javax.swing.*;
import java.awt.*;

public class GridLayoutFrame {
    JFrame frame;
    JPanel JPanel1;

    public GridLayoutFrame() {
        mainFrame();
    }

    public JFrame mainFrame() {
        //  frame creation
        frame = new JFrame();

        frame.setLayout(new GridLayout(1,3));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanelComponent1();

        frame.setVisible(true);

        return frame;
    }
    public JPanel JPanelComponent1() {
        //  JPanel creation
        JPanel1 = new JPanel();
        JPanel1.setBackground(Color.GRAY);
        frame.add(JPanel1);
        return JPanel1;
    }
}
