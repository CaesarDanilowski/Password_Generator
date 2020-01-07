public class PasswordGenController {
    public PasswordGenController(PasswordGenModel model, PasswordGenView view) {
        view.setButtonListener(event -> {
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
        });
    }
}