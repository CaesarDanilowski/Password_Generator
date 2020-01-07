import java.lang.*;
import java.util.Random;

public class PasswordGenModel {
    private static char[][] chars = { { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'Z', 'X', 'Y' },
        { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'z', 'x', 'y' },
            { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' },
            { '!', '@', '#', '$', '%', '^', '&', '*', '(', ')' }
    };

    private int lengthOfPassword;
    private boolean lowerCases;
    private boolean upperCases;
    private boolean digits;
    private boolean specialChars;

    private StringBuilder passwordBuilder;
    private String password;

    public PasswordGenModel() {
        this.passwordBuilder = new StringBuilder();
    }

    public void generatePassword() {
        passwordBuilder.delete(0, passwordBuilder.length());

        while (passwordBuilder.length() < lengthOfPassword) {
            int iIndex = new Random().nextInt(4);

            if ((iIndex == 0 && upperCases) || (iIndex == 1 && lowerCases)) {
                int jIndex = new Random().nextInt(26);
                char currentChar = chars[iIndex][jIndex];
                passwordBuilder.append(currentChar);
            } else if ((iIndex == 2 && digits) || (iIndex == 3 && specialChars)) {
                int jIndex = new Random().nextInt(10);
                char currentChar = chars[iIndex][jIndex];
                passwordBuilder.append(currentChar);
            }
        }

        password = passwordBuilder.toString();
    }

    public String getPassword() {
        return password;
    }

    public void setLengthOfPassword(int length) { lengthOfPassword = length; }
    public void setUpperCases(boolean value) { upperCases = value; }
    public void setLowerCases(boolean value) { lowerCases = value; }
    public void setDigits(boolean value) { digits = value; }
    public void setSpecialChars(boolean value) { specialChars = value; }
}