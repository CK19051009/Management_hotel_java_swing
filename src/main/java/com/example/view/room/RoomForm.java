package com.example.view.room;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RoomForm extends JDialog {
    private JTextField txtId, txtName, txtType, txtPrice, txtStatus;
    private JButton btnSave, btnCancel;
    private RoomManagementForm parent;
    private int editIndex = -1;

    public RoomForm(RoomManagementForm parent) {
        this.parent = parent;
        initUI();
    }

    public RoomForm(RoomManagementForm parent, int index, String id, String name, String type, String price,
            String status) {
        this.parent = parent;
        this.editIndex = index;
        initUI();
        txtId.setText(id);
        txtName.setText(name);
        txtType.setText(type);
        txtPrice.setText(price);
        txtStatus.setText(status);
    }

    private void initUI() {
        setTitle("Room Details");
        setSize(300, 300);
        setLayout(new GridLayout(6, 2, 5, 5));
        setModal(true);
        setLocationRelativeTo(parent);

        add(new JLabel("Room ID:"));
        txtId = new JTextField();
        add(txtId);

        add(new JLabel("Room Name:"));
        txtName = new JTextField();
        add(txtName);

        add(new JLabel("Type:"));
        txtType = new JTextField();
        add(txtType);

        add(new JLabel("Price:"));
        txtPrice = new JTextField();
        add(txtPrice);

        add(new JLabel("Status:"));
        txtStatus = new JTextField();
        add(txtStatus);

        btnSave = new JButton("Save");
        btnCancel = new JButton("Cancel");
        add(btnSave);
        add(btnCancel);

        btnSave.addActionListener(this::onSave);
        btnCancel.addActionListener(e -> dispose());
    }

    private void onSave(ActionEvent e) {
        String id = txtId.getText();
        String name = txtName.getText();
        String type = txtType.getText();
        String price = txtPrice.getText();
        String status = txtStatus.getText();

        if (editIndex == -1) {
            parent.addRoom(id, name, type, price, status);
        } else {
            parent.updateRoom(editIndex, name, type, price, status);
        }

        dispose();
    }
}