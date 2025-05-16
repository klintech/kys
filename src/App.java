package src;
import javax.swing.SwingUtilities;

import src.controller.MainController;
import src.controller.TransactionController;


public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TransactionController transactionController = new TransactionController();

            transactionController.deleteTransaction(2);

            MainController controller = new MainController();
            controller.init();
        });
    }
}
