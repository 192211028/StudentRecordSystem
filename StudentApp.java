import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentApp extends JFrame {

    private JTextArea displayArea;

    public StudentApp() {
        setTitle("Student Record System");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Add Student");
        JButton viewButton = new JButton("View Students");
        JButton exitButton = new JButton("Exit");

        panel.add(addButton);
        panel.add(viewButton);
        panel.add(exitButton);

        displayArea = new JTextArea(15, 50);
        displayArea.setEditable(false);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentForm();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText("");
                List<Student> students = new StudentDAO().getAllStudents();
                for (Student s : students) {
                    displayArea.append(s.getId() + " - " + s.getName() + ", " + s.getRollNo() + ", "
                            + s.getDepartment() + ", Year " + s.getYear() + ", " + s.getEmail() + "\n");
                }
            }
        });

        exitButton.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentApp();
    }
}