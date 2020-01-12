import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class PasswordGenController {
    private PasswordGenModel model;
    private PasswordGenMenu menu;
    private PasswordGenView view;

    private FileNameExtensionFilter fileExtension = new FileNameExtensionFilter("Password file", "pass");
    private JFileChooser fileChooser = new JFileChooser();
    private String name;
    private Scanner fromFile;
    private PrintWriter toFile;
    private boolean isAlreadyCreated = false;

    public PasswordGenController(PasswordGenModel model, PasswordGenMenu menu, PasswordGenView view) {
        this.model = model;
        this.menu = menu;
        this.view = view;

        fileChooser.setFileFilter(fileExtension);

        view.setButtonListener(event -> evaluateCalculations());

        menu.setSaveListener(event -> {
            try {
                saveNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        menu.setOpenListener(event -> {
            try {
                openFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void evaluateCalculations() {
        view.clearPasswordArea();
        int length = 1;
        int passwords = 1;

        try {
            length = view.getLength();
            passwords = view.getPasswords();
        } catch (NumberFormatException e) {
            view.showErrorMessage("This field requires a number");
        }

        if (passwords < 1 || passwords > 2000) {
            view.showErrorMessage("You can generate min 1 password and max 2000 passwords");
            passwords = 1;
        }

        if (length < 1 || length > 40) {
            view.showErrorMessage("Min length of password is 1 and max is 40");
            length = 1;
        } else {
            boolean useUpperCases = view.isUpperCases();
            boolean useLowerCases = view.isLowerCases();
            boolean useDigits = view.isDigits();
            boolean useSpecialChars = view.isSpecialChars();

            model.setLengthOfPassword(length);
            model.setUpperCases(useUpperCases);
            model.setLowerCases(useLowerCases);
            model.setDigits(useDigits);
            model.setSpecialChars(useSpecialChars);

            for (int i = 0; i < passwords; i++) {
                model.generatePassword();
                view.setPasswordsArea(model.getPassword());
            }
        }
    }

    public void saveNewFile() throws IOException {
        if (!isAlreadyCreated && name == null) {
            isAlreadyCreated = true;

            fileChooser.setCurrentDirectory(new File("C:\\Users\\%username%\\My documents"));

            if (fileChooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
                name = fileChooser.getSelectedFile().getPath();
                saveFile();
            }
        } else {
            saveFile();
        }
    }

    void saveFile() throws FileNotFoundException {
        toFile = new PrintWriter(name + ".pass");
        toFile.flush();

        String passwords = view.getPasswordsArea();

        toFile.write(passwords);

        toFile.close();
    }

    public void openFile() throws IOException {
        fileChooser.setCurrentDirectory(new File("C:\\Users\\%username%\\My documents"));

        if (fileChooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION) {
            name = fileChooser.getSelectedFile().getPath();
            fromFile = new Scanner(Paths.get(name));

            while (fromFile.hasNextLine()) {
                String password = fromFile.nextLine();
                view.setPasswordsArea(password);
            }
        }

        fromFile.close();
    }
}