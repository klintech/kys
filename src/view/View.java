package src.view;

import javax.swing.*;

public abstract class View extends JFrame {
    public View(String title) {
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
    }

    public abstract void initComponents();
}
