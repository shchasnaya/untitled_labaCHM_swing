package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGui {
    public JFrame frame;
    private JPanel MainPanel;
    private JComboBox comboBoxMethod;
    private JTextField textFieldEps;
    private JButton resultButton;
    private JTable table1;
    private JTextArea textArea1;
    private JSpinner spinner1;
    private JButton updateButton;

    public MainGui() {
        initialize();
    }


    private void initialize() {
        frame = new JFrame();
        //resultButton.setOpaque(false);
        //resultButton.setBackground(Color.magenta);
        frame.setBounds(200, 200, 600, 450);
        frame.setMinimumSize(new Dimension(600, 450));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Laboratory work №2");
        frame.setContentPane(MainPanel);
        SpinnerModel numbers = new SpinnerNumberModel(3, 2, 10, 1);
        spinner1.setModel(numbers);
        final DefaultTableModel tableModel = new DefaultTableModel();
        table1.setModel(tableModel);
        int rowCount = Integer.parseInt(spinner1.getValue().toString());
        int columnCount = rowCount + rowCount +2;
        tableModel.setColumnCount(columnCount);
        tableModel.setRowCount(rowCount);
        String textIn;
        for (int i = 0; i < rowCount; i++) {
            for(int j = 0, c = 1; j < rowCount; j++, c=c+2) {
                textIn = "x" + (j+1);
                tableModel.setValueAt(textIn,i,c);
            }
            tableModel.setValueAt("=",i,columnCount-2);
        }
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < tableModel.getColumnCount(); i++) {
                    for( int j = 0; j < tableModel.getRowCount(); j++){
                        tableModel.setValueAt("",j,i);
                    }
                }
                int rowCount = Integer.parseInt(spinner1.getValue().toString());
                int columnCount = rowCount + rowCount +2;
                tableModel.setColumnCount(columnCount);
                tableModel.setRowCount(rowCount);
                String textIn;
                for (int i = 0; i < rowCount; i++) {
                    int c, j;
                    for(j = 0, c = 1; j < rowCount; j++, c=c+2) {
                        textIn = "x" + (j+1);
                        tableModel.setValueAt(textIn,i,c);
                    }
                    tableModel.setValueAt("=",i, columnCount - 2);

                }
            }
        });
    }

}
