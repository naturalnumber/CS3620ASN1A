import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CruiseLinePanel extends JPanel {
    // Default heights & widths, in pixels
    public static final  int   DEFAULT_PANEL_HEIGHT        = 400;
    public static final  int   DEFAULT_BUTTON_PANEL_HEIGHT = 50;
    public static final  int   DEFAULT_PANEL_WIDTH         = 400;
    public static final  int   DEFAULT_BUTTON_HEIGHT       = 25;
    public static final  int   DEFAULT_BUTTON_WIDTH        = 100;
    public static final  int   INSET                       = 3;
    public static final  int   SPCR                        = 10;

    // Default colours
    private static final Color COLOUR_BG                   = Color.WHITE;
    private static final Color COLOUR_BPBG                 = Color.LIGHT_GRAY;
    private static final Color COLOUR_BTN                  = Color.GRAY;
    private static final Color COLOUR_BTNTXT               = Color.WHITE;
    private static final Color COLOUR_BTNBRD               = Color.BLACK;


    public static void main (String[] args)
    {
        // Construct and initialize the frame.
        JFrame frame = new JFrame("Assignment 1 A");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout the frame.
        Container c = frame.getContentPane();
        c.setPreferredSize(new Dimension(DEFAULT_PANEL_WIDTH * 2, (DEFAULT_PANEL_HEIGHT + DEFAULT_BUTTON_PANEL_HEIGHT) * 2));
        c.setLayout(new GridLayout(2, 2));
        c.add(new CruiseLinePanel());

        // Display the frame.
        frame.pack();
        frame.setVisible(true);
    }

    public CruiseLinePanel() {
        
    }
}
