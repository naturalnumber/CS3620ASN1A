import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class CruiseLinePanel extends JPanel {
    // Default heights & widths, in pixels
    public static final  int DEFAULT_DISPLAY_PANEL_HEIGHT  = 200;
    public static final  int DEFAULT_ROOM_PANEL_HEIGHT     = 100;
    public static final  int DEFAULT_ADDON_PANEL_HEIGHT    = 200;
    public static final  int DEFAULT_SELECTION_PANEL_WIDTH = 200;
    public static final  int DEFAULT_DISPLAY_PANEL_WIDTH   = 300;
    public static final  int INSET                         = 3;
    public static final  int SPCR                          = 10;

    // Default colours
    private static final Color COLOUR_BG                   = Color.WHITE;
    private static final Color COLOUR_BTNTXT               = Color.BLACK;

    // Option lists
    private ArrayList<RoomAction> rooms;
    private ArrayList<AddonAction> addons;

    private Room room;

    private JLabel subtotal;
    private JLabel taxes;
    private JLabel gratuity;
    private JLabel total;
    private JTextArea description;

    public static void main (String[] args)
    {
        // Construct and initialize the frame.
        JFrame frame = new JFrame("Assignment 1 A");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Layout the frame.
        Container c = frame.getContentPane();
        c.add(new CruiseLinePanel());

        // Display the frame.
        frame.pack();
        frame.setVisible(true);
    }

    public CruiseLinePanel() {
        this.room = new InteriorRoom();

        // Initialize the panels.
        JPanel roomPanel = new JPanel();
        roomPanel.setPreferredSize(new Dimension(DEFAULT_SELECTION_PANEL_WIDTH, DEFAULT_ROOM_PANEL_HEIGHT));
        roomPanel.setLayout(new BoxLayout(roomPanel, BoxLayout.Y_AXIS));
        roomPanel.setBackground(COLOUR_BG);

        JPanel addonPanel = new JPanel();
        addonPanel.setPreferredSize(new Dimension(DEFAULT_SELECTION_PANEL_WIDTH, DEFAULT_ADDON_PANEL_HEIGHT));
        addonPanel.setLayout(new BoxLayout(addonPanel, BoxLayout.Y_AXIS));
        addonPanel.setBackground(COLOUR_BG);

        JPanel displayPanel = new JPanel();
        displayPanel.setPreferredSize(new Dimension(DEFAULT_DISPLAY_PANEL_WIDTH, DEFAULT_DISPLAY_PANEL_HEIGHT));
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        displayPanel.setBackground(COLOUR_BG);

        // Room options
        ArrayList<JRadioButton> radioButtons = new ArrayList<>(this.getRooms().size());

        for (RoomAction r : this.getRooms()) {
            radioButtons.add(new JRadioButton(r));
        }

        // Group the radio buttons
        ButtonGroup group = new ButtonGroup();

        for (JRadioButton r : radioButtons) {
            group.add(r);
            roomPanel.add(r);
        }

        // Set a default room
        radioButtons.get(0).setSelected(true);

        // Addon options
        ArrayList<JCheckBox> checkBoxes = new ArrayList<>(this.getAddons().size());

        for (AddonAction a : this.getAddons()) {
            checkBoxes.add(new JCheckBox(a));
        }

        for (JCheckBox a : checkBoxes) {
            addonPanel.add(a);
        }

        // Display
        this.subtotal = new JLabel();
        this.taxes = new JLabel();
        this.gratuity = new JLabel();
        this.total = new JLabel();
        this.description = new JTextArea(20, 100); // Todo: constants

        this.description.setLineWrap(true);
        this.description.setEditable(false);

        displayPanel.add(subtotal);
        displayPanel.add(taxes);
        displayPanel.add(gratuity);
        displayPanel.add(total);
        displayPanel.add(new JScrollPane(description,
                                         JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                         JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));

        // Selection panel
        JPanel selectionPanel = new JPanel();
        selectionPanel.setPreferredSize(new Dimension(DEFAULT_SELECTION_PANEL_WIDTH,
                                                      DEFAULT_ROOM_PANEL_HEIGHT + DEFAULT_ADDON_PANEL_HEIGHT));
        selectionPanel.setLayout(new BoxLayout(selectionPanel, BoxLayout.Y_AXIS));
        selectionPanel.setBackground(COLOUR_BG);
        selectionPanel.add(roomPanel);
        selectionPanel.add(addonPanel);

        // Format this panel
        Dimension preferred = new Dimension(DEFAULT_SELECTION_PANEL_WIDTH + DEFAULT_DISPLAY_PANEL_WIDTH,
                                            Math.max(DEFAULT_DISPLAY_PANEL_HEIGHT,
                                                     DEFAULT_ROOM_PANEL_HEIGHT + DEFAULT_ADDON_PANEL_HEIGHT));
        this.setBackground(COLOUR_BG);
        this.setPreferredSize(preferred);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(selectionPanel);
        this.add(displayPanel);
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        this.setFocusable(true);

        update();
    }

    private void update() {
        double subtotal = this.room.getPrice();
        double taxes = this.room.getTax();
        double gratuity = subtotal*Room.GRATUITY_RATE_ROOM;

        this.subtotal.setText("Subtotal: $"+subtotal);
        this.taxes.   setText("Taxes:    $"+taxes);
        this.gratuity.setText("Gratuity: $"+gratuity);
        this.total.   setText("Total:    $"+(subtotal+taxes+gratuity));

        this.description.setText(this.room.getDescription());
    }

    /**
     * Interior room - $1000
     • Ocean view room - $1500
     • Balcony room - $2000
     • SuiteRoom - $3000
     */
    private ArrayList<RoomAction> getRooms() {
        if (rooms == null) {
            rooms = new ArrayList<>();

            rooms.add(new RoomAction<>(InteriorRoom.name, InteriorRoom.class));
            rooms.add(new RoomAction<>(OceanViewRoom.name, OceanViewRoom.class));
            rooms.add(new RoomAction<>(BalconyRoom.name, BalconyRoom.class));
            rooms.add(new RoomAction<>(SuiteRoom.name, SuiteRoom.class));
        }

        return rooms;
    }

    private class RoomAction<R extends Room> extends AbstractAction {
        Class<R> type;

        public RoomAction(String name, Class<R> type) {
            super(name);

            this.type = type;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                room = room.replaceRoom(type.newInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

            update();
        }
    }

    /**
     * Beverage package ($700)
     • Klondike trail guided horseback tour ($50)
     • Helicopter glacier tour ($200)
     • Rock climbing lessons ($60)
     • Admission to a lumberjack competition ($15)
     • Scientology enlightenment tour ($500)
     */
    private ArrayList<AddonAction> getAddons() {
        if (addons == null) {
            addons = new ArrayList<>();

            addons.add(new AddonAction<>(BeveragePackage.name, BeveragePackage.class));
            addons.add(new AddonAction<>(KlondikePackage.name, KlondikePackage.class));
            addons.add(new AddonAction<>(HelicopterPackage.name, HelicopterPackage.class));
            addons.add(new AddonAction<>(RockClimbingPackage.name, RockClimbingPackage.class));
            addons.add(new AddonAction<>(LumberjackPackage.name, LumberjackPackage.class));
            addons.add(new AddonAction<>(EnlightenmentPackage.name, EnlightenmentPackage.class));
        }

        return addons;
    }

    private class AddonAction<R extends RoomAddon> extends AbstractAction {
        Class<R> type;

        public AddonAction(String name, Class<R> type) {
            super(name);

            this.type = type;
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                JCheckBox cb = (JCheckBox) actionEvent.getSource();

                // Determine status
                if (cb.isSelected()) {
                    room = type.newInstance().initializeDecorated(room);
                } else {
                    room = room.removeAddon(type);
                }
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

            update();
        }
    }
}
