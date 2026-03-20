import javax.swing.*;
import java.awt.*;

public class GridLayoutFrame {
    JFrame frame;
    JPanel JPanel1,JPanel2,JPanel3;

    public GridLayoutFrame() {
        mainFrame();
    }

    public JFrame mainFrame() {
        frame = new JFrame();

        frame.setLayout(new GridLayout(1,3));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanelComponent1();
        JPanelComponent2();
        JPanelComponent3();

        frame.setVisible(true);

        return frame;
    }

    public JPanel JPanelComponent1() {
        JPanel1 = new JPanel();
        JPanel1.setBackground(Color.GRAY);
        frame.add(JPanel1);
        return JPanel1;
    }

    public JPanel JPanelComponent2() {
        JPanel2 = new JPanel();
        JPanel2.setBackground(Color.RED);
        frame.add(JPanel2);
        return JPanel2;
    }

    public JPanel JPanelComponent3() {
        JPanel3 = new JPanel();
        JPanel3.setBackground(Color.ORANGE);
        frame.add(JPanel3);
        return JPanel3;
    }
}