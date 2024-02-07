
    import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TravelPlanner {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Travel Itinerary Planner");
            frame.setSize(800, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            frame.add(panel);
            placeComponents(panel);

            frame.setVisible(true);
        });
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel destinationLabel = new JLabel("Destination:");
        destinationLabel.setBounds(10, 20, 80, 25);
        panel.add(destinationLabel);

        JTextField destinationText = new JTextField(20);
        destinationText.setBounds(100, 20, 165, 25);
        panel.add(destinationText);

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(10, 50, 80, 25);
        panel.add(dateLabel);

        JTextField dateText = new JTextField(20);
        dateText.setBounds(100, 50, 165, 25);
        panel.add(dateText);

        JButton generateButton = new JButton("Generate Itinerary");
        generateButton.setBounds(10, 80, 150, 25);
        panel.add(generateButton);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                String destination = destinationText.getText();
                String date = dateText.getText();

            
                
                System.out.println("Generating itinerary for:");
                System.out.println("Destination: " + destination);
                System.out.println("Date: " + date);
            }
        });
    }
}

