package edu.vcu.patelas23;

import javafx.scene.Group;
import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

//Displays realtime information about the running state of the CPU
//Allows user to create and load programs
public class GUI extends JFrame {
    public GUI() {

        initUI();
    }

    //initialize objects to be rendered
    private void initUI() {
        JButton enterButton;
        JTextField commandIn;
        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());

        //instantiate quit button (for testing)
        enterButton  = new JButton("Enter");
        enterButton.addActionListener((event) -> System.exit(0));
        enterButton.setMnemonic(KeyEvent.VK_ESCAPE);

        panel.add(enterButton, BorderLayout.EAST);

        //Dummy Process table
        String[] headers = {"Name", "Memory", "ID", "State"};
        Object[][] data = new Object[][] {
                {"Browser", 200, 1, "NEW"},
                {"Explorer", 100, 2, "READY"}
        };
        JTable table = new JTable(data, headers);
        JScrollPane viewPane = new JScrollPane(table);

        panel.add(viewPane, BorderLayout.CENTER);

        //text input field
        commandIn = new JTextField(30);
        panel.add(commandIn, BorderLayout.SOUTH);

        //create process table

        add(panel);

        setTitle("Simulated Java Operating System");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GUI gui = new GUI();
            gui.setVisible(true);
        });
    }
}
