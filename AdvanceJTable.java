import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class AdvanceJTable {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Advanced JTable Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        String[] columns = {"Name", "Age", "Department"};
        Object[][] data = {
                {"Alice", 30, "HR"},
                {"Bob", 25, "Engineering"},
                {"Charlie", 35, "Finance"},
                {"David", 40, "Marketing"}
        };

        // Create a DefaultTableModel
        DefaultTableModel model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Make 'Name' column to be not editable
                return column != 0;
            }
        };

        JTable table = new JTable(model);

        // Enable sorting
        TableRowSorter<DefaultTableModel> sorter =
                new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        // Center align Age column
        DefaultTableCellRenderer centerRenderer =
                new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(1)
                .setCellRenderer(centerRenderer);

        // Search field
        JTextField searchField = new JTextField();
        searchField.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void insertUpdate(DocumentEvent e) {
                        filter();
                    }

                    public void removeUpdate(DocumentEvent e) {
                        filter();
                    }

                    public void changedUpdate(DocumentEvent e) {
                        filter();
                    }

                    private void filter() {
                        String text = searchField.getText();
                        if (text.trim().length() == 0) {
                            sorter.setRowFilter(null);
                        } else {
                            sorter.setRowFilter(
                                    RowFilter.regexFilter("(?i)" + text)
                            );
                        }
                    }
                });

        frame.add(searchField, BorderLayout.NORTH);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}