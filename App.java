import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class App {
    public static void main(String[] args) {
        //creating the frame
        JFrame frame = new JFrame("Sorting Application");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);

        //create input label
        JLabel inputLabel = new JLabel("Enter Number (Comma Seperated) :");
        inputLabel.setBounds(10, 10, 200, 25);
        frame.add(inputLabel);

        // create input text field for user
        JTextField inputField = new JTextField();
        inputField.setBounds(10, 40, 360, 28);
        frame.add(inputField);

        //create Sort button
        JButton sortButton = new JButton("Sort");
        sortButton.setBounds(10, 80, 80, 28);
        frame.add(sortButton);

        // Create output section
        JTextField outputField = new JTextField();
        outputField.setBounds(10, 150, 360, 25);
        outputField.setEditable(false);
        frame.add(outputField);

    }
}
