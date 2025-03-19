package com.example.view.room;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class RoomManagementForm extends JFrame {
    private JTable roomTable;
    private DefaultTableModel tableModel;
    private JButton btnAdd, btnEdit, btnDelete;
    private JTextField txtSearch;
    private JButton btnSearch;

    public RoomManagementForm() {
        setTitle("Hotel Room Management");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(240, 240, 240));

        // Search Panel
        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(new Color(220, 220, 220));
        txtSearch = new JTextField(20);
        btnSearch = new JButton("Search");
        btnSearch.setBackground(new Color(0, 120, 200));
        btnSearch.setForeground(Color.WHITE);
        searchPanel.add(new JLabel("Search: "));
        searchPanel.add(txtSearch);
        searchPanel.add(btnSearch);

        // Table setup
        String[] columns = { "Room ID", "Room Name", "Type", "Price", "Status" };
        tableModel = new DefaultTableModel(columns, 0);
        roomTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(roomTable);

        // Buttons
        btnAdd = new JButton("Add Room");
        btnEdit = new JButton("Edit Room");
        btnDelete = new JButton("Delete Room");

        btnAdd.setBackground(new Color(0, 150, 0));
        btnAdd.setForeground(Color.WHITE);
        btnEdit.setBackground(new Color(0, 120, 200));
        btnEdit.setForeground(Color.WHITE);
        btnDelete.setBackground(new Color(200, 0, 0));
        btnDelete.setForeground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(220, 220, 220));
        panel.add(btnAdd);
        panel.add(btnEdit);
        panel.add(btnDelete);

        add(searchPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        // Button actions
        btnAdd.addActionListener(this::onAddRoom);
        btnEdit.addActionListener(this::onEditRoom);
        btnDelete.addActionListener(this::onDeleteRoom);
        btnSearch.addActionListener(this::onSearchRoom);
    }

    private void onAddRoom(ActionEvent e) {
        RoomForm form = new RoomForm(this);
        form.setVisible(true);
    }

    private void onEditRoom(ActionEvent e) {
        int selectedRow = roomTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a room to edit!");
            return;
        }

        String id = tableModel.getValueAt(selectedRow, 0).toString();
        String name = tableModel.getValueAt(selectedRow, 1).toString();
        String type = tableModel.getValueAt(selectedRow, 2).toString();
        String price = tableModel.getValueAt(selectedRow, 3).toString();
        String status = tableModel.getValueAt(selectedRow, 4).toString();

        RoomForm form = new RoomForm(this, selectedRow, id, name, type, price, status);
        form.setVisible(true);
    }

    private void onDeleteRoom(ActionEvent e) {
        int selectedRow = roomTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a room to delete!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this room?", "Confirm",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            tableModel.removeRow(selectedRow);
        }
    }

    private void onSearchRoom(ActionEvent e) {
        String keyword = txtSearch.getText().toLowerCase();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            boolean match = false;
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                String value = tableModel.getValueAt(i, j).toString().toLowerCase();
                if (value.contains(keyword)) {
                    match = true;
                    break;
                }
            }
            roomTable.setRowSelectionAllowed(match);
            roomTable.setRowSelectionInterval(i, i);
        }
    }

    public void addRoom(String id, String name, String type, String price, String status) {
        tableModel.addRow(new Object[] { id, name, type, price, status });
    }

    public void updateRoom(int rowIndex, String name, String type, String price, String status) {
        tableModel.setValueAt(name, rowIndex, 1);
        tableModel.setValueAt(type, rowIndex, 2);
        tableModel.setValueAt(price, rowIndex, 3);
        tableModel.setValueAt(status, rowIndex, 4);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RoomManagementForm().setVisible(true));
    }
}
