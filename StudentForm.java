import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentForm extends JFrame {
    private JTextField nameField, rollField, deptField, yearField, emailField;
    private JButton saveButton;

    public StudentForm() {
        setTitle("Add New Student");
        setLayout(new GridLayout(6, 2, 5, 5));
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Roll No:"));
        rollField = new JTextField();
        add(rollField);

        add(new JLabel("Department:"));
        deptField = new JTextField();
        add(deptField);

        add(new JLabel("Year:"));
        yearField = new JTextField();
        add(yearField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        saveButton = new JButton("Save");
        add(saveButton);

        JButton cancelButton = new JButton("Cancel");
        add(cancelButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = new Student();
                student.setName(nameField.getText());
                student.setRollNo(rollField.getText());
                student.setDepartment(deptField.getText());
                student.setYear(Integer.parseInt(yearField.getText()));
                student.setEmail(emailField.getText());

                new StudentDAO().addStudent(student);
                JOptionPane.showMessageDialog(null, "Student added successfully!");
                dispose();
            }
        });

        cancelButton.addActionListener(e -> dispose());

        setVisible(true);
    }
}