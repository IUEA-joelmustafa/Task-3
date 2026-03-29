import javax.swing.*;
import java.awt.*;

public class GridLayoutFrame {
    JFrame frame;
    JPanel jPanel1, jPanel2, jPanel3;

    public GridLayoutFrame() {
        mainFrame();
    }

    public JFrame mainFrame() {
        frame = new JFrame();

        frame.setLayout(new GridLayout(1, 3));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanelComponent1();
        JPanelComponent2();
        JPanelComponent3();

        frame.setVisible(true);

        return frame;
    }

    public JPanel JPanelComponent1() {
        jPanel1 = new JPanel();
        jPanel1.setBackground(Color.GRAY);
        frame.add(jPanel1);
        return jPanel1;
    }

    public JPanel JPanelComponent2() {
        jPanel2 = new JPanel();
        jPanel2.setBackground(Color.RED);
        frame.add(jPanel2);
        return jPanel2;
    }

    public JPanel JPanelComponent3() {
        jPanel3 = new JPanel();
        jPanel3.setBackground(Color.ORANGE);
        frame.add(jPanel3);
        return jPanel3;
    }
}
