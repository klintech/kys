import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class DashboardView extends JFrame {
    private JTable transactionTable;
    private DefaultTableModel tableModel;
    private JTextField filterStartDate;
    private JTextField filterEndDate;
    private JPanel chartPanel;
    private JTextArea goalTextArea;

    public DashboardView() {
        setTitle("Financial Dashboard");
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Panel for filtering by date
        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(new FlowLayout());
        filterPanel.add(new JLabel("Start Date:"));
        filterStartDate = new JTextField(10);
        filterPanel.add(filterStartDate);
        filterPanel.add(new JLabel("End Date:"));
        filterEndDate = new JTextField(10);
        filterPanel.add(filterEndDate);
        JButton filterButton = new JButton("Filter by Date");
        filterPanel.add(filterButton);

        // Panel for transactions table
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());

        // Table for transactions
        String[] columnNames = {"ID", "Description", "Date", "Amount"};
        tableModel = new DefaultTableModel(columnNames, 0);
        transactionTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(transactionTable);
        tablePanel.add(tableScrollPane, BorderLayout.CENTER);

        // Panel for chart/graph display
        chartPanel = new JPanel();
        chartPanel.setLayout(new BorderLayout());
        chartPanel.setBorder(BorderFactory.createTitledBorder("Monthly Expenses Chart"));

        // Panel for goals section
        JPanel goalsPanel = new JPanel();
        goalsPanel.setLayout(new BorderLayout());
        goalTextArea = new JTextArea(5, 30);
        goalTextArea.setText("Enter your goals here...");
        goalsPanel.add(new JScrollPane(goalTextArea), BorderLayout.CENTER);

        // Add components to the main window
        add(filterPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);
        add(chartPanel, BorderLayout.EAST);
        add(goalsPanel, BorderLayout.SOUTH);

        // Action listener for filter button
        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String startDate = filterStartDate.getText();
                String endDate = filterEndDate.getText();
                // Call backend function to filter transactions by date
                filterTransactions(startDate, endDate);
            }
        });

        // Mock data for transactions
        loadTransactions();
    }

    // Function to filter transactions based on date range
    private void filterTransactions(String startDate, String endDate) {
        // Implement logic to filter transactions based on the input date range
        // For now, just print the filter values to the console
        System.out.println("Filtering transactions from " + startDate + " to " + endDate);
    }

    // Function to load sample transaction data
    private void loadTransactions() {
        Object[][] data = {
                {"1", "Groceries", "2025-05-01", "150.00"},
                {"2", "Entertainment", "2025-05-02", "200.00"},
                {"3", "Salary", "2025-05-05", "3000.00"},
                {"4", "Transport", "2025-05-07", "50.00"}
        };

        for (Object[] transaction : data) {
            tableModel.addRow(transaction);
        }
    }

}
