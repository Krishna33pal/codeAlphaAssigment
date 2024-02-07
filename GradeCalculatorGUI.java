import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GradeCalculatorGUI extends JFrame {
  private ArrayList<Integer> grades;

  public GradeCalculatorGUI() {
    grades = new ArrayList<>();

    // Create components
    JLabel label = new JLabel("Enter grades (separate with commas):");
    JTextField inputField = new JTextField(50);
    JButton calculateButton = new JButton("Calculate");
    JTextArea resultArea = new JTextArea(20, 30);
    resultArea.setEditable(false);

    // Add components to the frame
    JPanel panel = new JPanel();
    panel.add(label);
    panel.add(inputField);
    panel.add(calculateButton);
    panel.add(resultArea);

    // Set layout
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
        .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));
    layout.setVerticalGroup(layout.createSequentialGroup()
        .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));

    // Set action for the calculate button
    calculateButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String input = inputField.getText();
        calculateGrades(input);
        displayResults(resultArea);
      }
    });

    // Set frame properties
    setTitle("Grade Calculator");
    setSize(400, 380);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void calculateGrades(String input) {
    grades.clear();

    try {
      String[] gradeStrings = input.split(",");
      for (String gradeString : gradeStrings) {
        int grade = Integer.parseInt(gradeString.trim());
        grades.add(grade);
      }
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid integer grades separated by commas.");
    }
  }

  private void displayResults(JTextArea resultArea) {
    if (!grades.isEmpty()) {
      int sum = 0;
      int highest = Integer.MIN_VALUE;
      int lowest = Integer.MAX_VALUE;

      for (int grade : grades) {
        sum += grade;

        if (grade > highest) {
          highest = grade;
        }

        if (grade < lowest) {
          lowest = grade;
        }
      }

      double average = (double) sum / grades.size();

      resultArea.setText("Results:\n"
          + "Average Grade: " + average + "\n"
          + "Highest Grade: " + highest + "\n"
          + "Lowest Grade: " + lowest);
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new GradeCalculatorGUI());
  }
}
