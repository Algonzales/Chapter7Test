
/*Alexander Gonzales
 *CSC 160
 *This program is the math tutoring program, but it shows how many attempts the student did on each question and time taken for
 *the whole time they tried the 4 questions.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class Chapter7Test extends JFrame {

	public Chapter7Test() {

		setLayout(null);

		setTitle("Math Tutor");
		setSize(640, 480);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel appLabel = new JLabel("Welcome to Math Tutor");
		add(appLabel);
		appLabel.setBounds(10, 10, 200, 20); // setBounds(x, y, width, height)

		JMenuBar appMenuBar = new JMenuBar();
		setJMenuBar(appMenuBar);

		JMenu fileMenu = new JMenu("Math Tutor");// Adds File drop-down menu

		appMenuBar.add(fileMenu);
		// addition tutor button for drop-down menu
		JMenuItem addTutorMenuItem = new JMenuItem("Addition Tutor");
		// subtraction tutor button for drop-down menu
		JMenuItem subtractTutorMenuItem = new JMenuItem("Subtraction Tutor");
		// Multiplication Tutor button for drop-down menu
		JMenuItem multiplyTutorMenuItem = new JMenuItem("Multiplication Tutor");
		// Divide tutor button for drop-down menu
		JMenuItem divideTutorMenuItem = new JMenuItem("Division Tutor");
		// exit button for drop-down menu
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		fileMenu.add(addTutorMenuItem);
		fileMenu.add(subtractTutorMenuItem);
		fileMenu.add(multiplyTutorMenuItem);
		fileMenu.add(divideTutorMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);

		addTutorMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayTutor("Add");
			}

		});

		subtractTutorMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayTutor("Subtract");
			}

		});
		multiplyTutorMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayTutor("Multiply");
			}

		});
		divideTutorMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				displayTutor("Divide");
			}

		});

		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
	}

	public static void displayTutor(String tutorType) {
		long lStartTime = System.nanoTime();
		int correctAnswer = 0;
		int questionNumber = 1;
		JTextField userAnswerField = new JTextField(5);

		JPanel myPanel = new JPanel();
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int answer = 0;
		int result = 0;
		int userAnswer = 0;
		boolean questionCorrect = true;
		while (correctAnswer < 4) {
			if (questionCorrect == true) {
				num1 = (int) (Math.random() * 10 + 1);
				num2 = (int) (Math.random() * 10 + 1);
				num3 = num1 * num2;
				answer = 0;
			}
			myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
			myPanel.add(new JLabel("Question " + questionNumber));
			myPanel.add(new JLabel("Get 4 questions correct to exit"));
			myPanel.add(new JLabel("Questions correct so far " + correctAnswer));

			switch (tutorType) {
			case "Add":
				myPanel.add(new JLabel("What is " + num1 + " + " + num2 + "?"));
				break;
			case "Subtract":
				if (num1 < num2) {
					int temp = num1;
					num1 = num2;
					num2 = temp;
					myPanel.add(new JLabel("What is " + num1 + " - " + num2 + "?"));
				} else {
					myPanel.add(new JLabel("What is " + num1 + " - " + num2 + "?"));
				}
				break;
			case "Multiply":
				myPanel.add(new JLabel("What is " + num1 + " * " + num2 + "?"));
				break;
			case "Divide":
				myPanel.add(new JLabel("What is " + num3 + " / " + num1 + "?"));
				break;
			}

			myPanel.add(new JLabel("Enter your answer:"));
			myPanel.add(userAnswerField);

			switch (tutorType) {
			case "Add":
				answer = num1 + num2;
				result = JOptionPane.showConfirmDialog(null, myPanel, "Addition tutor", JOptionPane.OK_CANCEL_OPTION);
				userAnswer = Integer.parseInt(userAnswerField.getText());
				break;
			case "Subtract":
				answer = num1 - num2;
				result = JOptionPane.showConfirmDialog(null, myPanel, "Subtraction tutor",
						JOptionPane.OK_CANCEL_OPTION);
				userAnswer = Integer.parseInt(userAnswerField.getText());
				break;
			case "Multiply":
				answer = num1 * num2;
				result = JOptionPane.showConfirmDialog(null, myPanel, "Multiplication tutor",
						JOptionPane.OK_CANCEL_OPTION);
				userAnswer = Integer.parseInt(userAnswerField.getText());
				break;
			case "Divide":
				answer = num3 / num1;
				result = JOptionPane.showConfirmDialog(null, myPanel, "Division tutor", JOptionPane.OK_CANCEL_OPTION);
				userAnswer = Integer.parseInt(userAnswerField.getText());
				break;
			}
			if (result == JOptionPane.OK_OPTION) {
				if (userAnswer == answer) {
					JOptionPane.showMessageDialog(null, "Correct, the answer is  " + answer, // message
							"Answer for number " + questionNumber, // title
							JOptionPane.PLAIN_MESSAGE);
					correctAnswer += 1;
					questionNumber += 1;
					questionCorrect = true;
					// remove all components in panel.
					myPanel.removeAll();
					// refresh the panel.
					myPanel.updateUI();

				} else if (userAnswer != answer) {
					JOptionPane.showMessageDialog(null, "Incorrect Try again", // message
							"Incorrect", // title
							JOptionPane.PLAIN_MESSAGE);
					questionCorrect = false;
					// remove all components in panel.
					myPanel.removeAll();
					// refresh the panel.
					myPanel.updateUI();
				}

			} else {
				correctAnswer = 5;
			}

		}
		long lEndTime = System.nanoTime();
		long output = (lEndTime - lStartTime) / 1000000000;
		JOptionPane.showMessageDialog(null, "Time taken " + output + " Seconds", // message
				"Time taken", // title
				JOptionPane.PLAIN_MESSAGE);

	}

	public static void main(String[] args) {
		Chapter7Test myApp = new Chapter7Test();
		myApp.setVisible(true);
	}
}