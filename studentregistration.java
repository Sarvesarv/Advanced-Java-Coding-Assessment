import javax.swing.*;
import java.awt.event.*;

public class studentregistration extends JFrame implements ActionListener {
    // Components Declaration
    private JLabel headingLabel, nameLabel, ageLabel, branchLabel, rollNoLabel, genderLabel;
    private JTextField nameTextField, ageTextField, branchTextField, rollNoTextField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private ButtonGroup genderGroup;
    private JCheckBox termsCheckBox;
    private JButton submitButton, resetButton;

    // Constructor to build UI
    public studentregistration() {
        // Frame Settings
        setTitle("Student Registration Form");
        setBounds(300, 90, 450, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null); // Absolute positioning

        // Heading Label
        headingLabel = new JLabel("Student Registration Form");
        headingLabel.setBounds(120, 20, 220, 30);
        add(headingLabel);

        // Name
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 70, 100, 30);
        add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(160, 70, 200, 30);
        add(nameTextField);

        // Age
        ageLabel = new JLabel("Age:");
        ageLabel.setBounds(50, 110, 100, 30);
        add(ageLabel);

        ageTextField = new JTextField();
        ageTextField.setBounds(160, 110, 200, 30);
        add(ageTextField);

        // Roll No
        rollNoLabel = new JLabel("Roll No:");
        rollNoLabel.setBounds(50, 150, 100, 30);
        add(rollNoLabel);

        rollNoTextField = new JTextField();
        rollNoTextField.setBounds(160, 150, 200, 30);
        add(rollNoTextField);

        // Branch
        branchLabel = new JLabel("Branch:");
        branchLabel.setBounds(50, 190, 100, 30);
        add(branchLabel);

        branchTextField = new JTextField();
        branchTextField.setBounds(160, 190, 200, 30);
        add(branchTextField);

        // Gender (Radio Buttons)
        genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 230, 100, 30);
        add(genderLabel);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(160, 230, 70, 30);
        add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(240, 230, 80, 30);
        add(femaleRadioButton);

        // Group the radio buttons so only one can be selected[span_1](start_span)[span_1](end_span)
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        // Terms and Conditions Checkbox
        termsCheckBox = new JCheckBox("Accept Terms and Conditions");
        termsCheckBox.setBounds(100, 280, 250, 30);
        add(termsCheckBox);

        // Submit Button
        submitButton = new JButton("Submit");
        submitButton.setBounds(80, 340, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);

        // Reset Button
        resetButton = new JButton("Reset");
        resetButton.setBounds(220, 340, 100, 30);
        resetButton.addActionListener(this);
        add(resetButton);

        // Display Frame[span_2](start_span)[span_2](end_span)
        setVisible(true);
    }

    // Event Handling
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            // Reset Action
            nameTextField.setText("");
            ageTextField.setText("");
            rollNoTextField.setText("");
            branchTextField.setText("");
            genderGroup.clearSelection();
            termsCheckBox.setSelected(false);
        } else if (e.getSource() == submitButton) {
            // Validation Logic[span_3](start_span)[span_3](end_span)
            if (nameTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your Name.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (ageTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your Age.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (rollNoTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your Roll No.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (branchTextField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter your Branch.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!maleRadioButton.isSelected() && !femaleRadioButton.isSelected()) {
                JOptionPane.showMessageDialog(this, "Please select your Gender.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!termsCheckBox.isSelected()) {
                JOptionPane.showMessageDialog(this, "Please accept the Terms and Conditions.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Extract Data
            String name = nameTextField.getText().trim();
            String age = ageTextField.getText().trim();
            String rollNo = rollNoTextField.getText().trim();
            String branch = branchTextField.getText().trim();
            String gender = maleRadioButton.isSelected() ? "Male" : "Female";

            // Success Summary Dialog[span_4](start_span)[span_4](end_span)
            String details = "Registration Successful!\n\n" +
                    "Name: " + name + "\n" +
                    "Age: " + age + "\n" +
                    "Roll No: " + rollNo + "\n" +
                    "Branch: " + branch + "\n" +
                    "Gender: " + gender;

            JOptionPane.showMessageDialog(this, details, "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Launch GUI on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new studentregistration());
    }
}