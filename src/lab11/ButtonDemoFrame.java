package lab11;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonDemoFrame extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private static final String YELLOW_ICON = "src/lab11/smileYellow.png";
    private static final String PINK_ICON = "src/lab11/smilePink.png";
    private static final String YELLOW_PRESSED_ICON = "src/lab11/smileYellowPressed.png";
    private static final String PINK_PRESSED_ICON = "src/lab11/smilePinkPressed.png";

    private JButton button;
    private int clickCount = 0;
    private boolean isYellow = true;

    public ButtonDemoFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Button Demo");

        JPanel panel = new JPanel();

        button = new JButton(new ImageIcon(YELLOW_ICON));
        button.setPreferredSize(new Dimension(400, 200));
        button.setText("Clicked " + clickCount + " times.");

        // Set the initial pressed icon in the constructor before any clicks occur
        button.setPressedIcon(new ImageIcon(YELLOW_PRESSED_ICON));

        button.addActionListener(this);

        panel.add(button);
        this.setContentPane(panel);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        clickCount++;
        button.setText("Clicks: " + clickCount);

        if (isYellow) {
            button.setIcon(new ImageIcon(PINK_ICON));
            button.setPressedIcon(new ImageIcon(PINK_PRESSED_ICON));
            isYellow = false;
        } else {
            button.setIcon(new ImageIcon(YELLOW_ICON));
            button.setPressedIcon(new ImageIcon(YELLOW_PRESSED_ICON));
            isYellow = true;
        }
    }
}