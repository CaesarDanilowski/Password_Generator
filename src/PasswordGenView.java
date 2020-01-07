import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class PasswordGenView extends JFrame {
    private final int WIDTH = 640;
    private final int HEIGHT = 480;
    private final String TITLE = "Password Generator";

    private JPanel panel = new JPanel(new GridLayout(1, 2));
    private JPanel leftPanel = new JPanel(new GridLayout(7, 2));
    private JPanel rightPanel = new JPanel(new GridLayout(1, 1));

    private JTextField howManyPasswords = new JTextField("1");
    private JTextField lengthOfPassword = new JTextField("1");
    private JCheckBox useUpperCase = new JCheckBox();
    private JCheckBox useLowerCase = new JCheckBox();
    private JCheckBox useDigits = new JCheckBox();
    private JCheckBox useSpecialChars = new JCheckBox();

    private JButton evaluate = new JButton("Generate");
    private JTextArea passwordsArea = new JTextArea();

    public PasswordGenView() {
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        leftPanel.add(new JLabel("Passwords"));
        leftPanel.add(howManyPasswords);

        leftPanel.add(new JLabel("Length"));
        leftPanel.add(lengthOfPassword);

        leftPanel.add(new JLabel("A-Z"));
        leftPanel.add(useUpperCase);

        leftPanel.add(new JLabel("a-z"));
        leftPanel.add(useLowerCase);

        leftPanel.add(new Label("0-9"));
        leftPanel.add(useDigits);

        leftPanel.add(new Label("!-)"));
        leftPanel.add(useSpecialChars);

        leftPanel.add(evaluate);
        rightPanel.add(new JScrollPane(passwordsArea));

        Border etched = BorderFactory.createEtchedBorder();
        Border titledLeft = BorderFactory.createTitledBorder(etched, "Options");
        leftPanel.setBorder(titledLeft);

        Border titledRigth = BorderFactory.createTitledBorder(etched, "Passwords");
        rightPanel.setBorder(titledRigth);

        panel.add(leftPanel);
        panel.add(rightPanel);

        add(panel);
    }

    public int getPasswords() {
        return Integer.valueOf(howManyPasswords.getText());
    }

    public int getLength() {
        return Integer.valueOf(lengthOfPassword.getText());
    }

    public boolean isUpperCases() {
        return useUpperCase.isSelected();
    }

    public boolean isLowerCases() {
        return useLowerCase.isSelected();
    }

    public boolean isDigits() {
        return useDigits.isSelected();
    }

    public boolean isSpecialChars() {
        return useSpecialChars.isSelected();
    }

    public void setPasswordsArea(String password) {
        passwordsArea.append(password + "\n");
    }

    public void clearPasswordArea() {
        passwordsArea.setText("");
    }

    public void setButtonListener(ActionListener listener) {
        evaluate.addActionListener(listener);
    }

    public void showErrorMessage(String text) {
        JOptionPane.showMessageDialog(null, text, "Error", JOptionPane.ERROR_MESSAGE);
    }
}