import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

        // Add action listner to the button
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                if (inputText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,"Please enter some numbers.");
                    return;
                }

                //collect input text by commas and convert to an integer array
                String[] stringNumbers = inputText.split(",");

                int[] numbers = new int[stringNumbers.length];

                try {
                    for (int i = 0; i < stringNumbers.length; i++){
                        numbers[i] = Integer.parseInt(stringNumbers[i].trim());
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid integer");
                    return;
                }

                //Sort the array using selection sort
                selectionSort(numbers);

                // convert sorted array to string and set into th output
                StringBuilder sortedNumbers = new StringBuilder();
                for (int i = 0; i < numbers.length; i++){
                    sortedNumbers.append(numbers[i]);
                    if (i < numbers.length -1) {
                        sortedNumbers.append(", ");
                    }
                }
                outputField.setText(sortedNumbers.toString());
            }
        });

        // set visible
        frame.setVisible(true);

    }

    public static void selectionSort(int[] array){

        for (int i = 0; i < array.length - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
