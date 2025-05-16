package src.view;

import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.*;

public class MainView extends View {

    public MainView() {
        super("Know Your Shit");
        initComponents(); // Important: call to initialize the GUI
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Fullscreen
        setVisible(true); // Show the frame
    }

    @Override
    public void initComponents() {
        // Use BorderLayout for overall structure
        setLayout(new BorderLayout());

        // Top: Title + Toolbar
        JPanel topPanel = new JPanel(new BorderLayout());

        //JLabel titleLabel = new JLabel("Know Your Shit", SwingConstants.CENTER);
        //titleLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
        //topPanel.add(titleLabel, BorderLayout.NORTH);

        // Toolbar
        JPanel toolbarPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        String[] dummyOptions = {"Option 1", "Option 2", "Option 3"};

        JButton fileBtn = new JButton("File");
        JButton homeBtn = new JButton("Home");
        JButton insertBtn = new JButton("Insert");

        toolbarPanel.add(fileBtn);
        toolbarPanel.add(homeBtn);
        toolbarPanel.add(insertBtn);

        JPopupMenu fileMenu = createMenu(dummyOptions);
        JPopupMenu homeMenu = createMenu(dummyOptions);
        JPopupMenu insertMenu = createMenu(dummyOptions);

        fileBtn.addActionListener(e -> fileMenu.show(fileBtn, 0, fileBtn.getHeight()));
        homeBtn.addActionListener(e -> homeMenu.show(homeBtn, 0, homeBtn.getHeight()));
        insertBtn.addActionListener(e -> insertMenu.show(insertBtn, 0, insertBtn.getHeight()));

        topPanel.add(toolbarPanel, BorderLayout.SOUTH);
        add(topPanel, BorderLayout.NORTH);

        // Main canvas layout (2x2 with bottom full width)
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        // Top left
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        mainPanel.add(createBox(""), gbc);

        // Top right
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(createBox(""), gbc);

        // Bottom full width
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        mainPanel.add(createBox(""), gbc);

        add(mainPanel, BorderLayout.CENTER);
    }

    private JPopupMenu createMenu(String[] items) {
        JPopupMenu menu = new JPopupMenu();
        for (String item : items) {
            menu.add(new JMenuItem(item));
        }
        return menu;
    }

    private JPanel createBox(String label) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        panel.add(new JLabel(label));
        return panel;
    }

    // Main launcher (can be placed in a separate file)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainView::new);
    }
}
