package src;
import javax.swing.SwingUtilities;

import src.controller.MainController;
import src.controller.TransactionController;
import src.view.DashboardView;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TransactionController transactionController = new TransactionController();

            transactionController.deleteTransaction(2);

            MainController controller = new MainController();
            controller.init();

            DashboardView frame = new DashboardView();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
