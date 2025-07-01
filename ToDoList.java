import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoList extends JFrame implements ActionListener {
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField taskField;
    private Button addButton, removeButton;

    public ToDoList() {
        setTitle("To-Do List");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Top panel for input
        Panel inputPanel = new Panel();
        inputPanel.setLayout(new BorderLayout());

        taskField = new JTextField();
        inputPanel.add(taskField, BorderLayout.CENTER);

        addButton = new Button("Add");
        addButton.addActionListener(this);
        inputPanel.add(addButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.NORTH);

        // List for tasks
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom panel for remove button
        Panel bottomPanel = new Panel();
        removeButton = new Button("Remove Selected");
        removeButton.addActionListener(this);
        bottomPanel.add(removeButton);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskField.setText("");
            }
        } else if (e.getSource() == removeButton) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ToDoList().setVisible(true);
        });
    }
}