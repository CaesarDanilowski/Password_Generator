public class Main {
    public static void main(String[] args) {
        PasswordGenModel model = new PasswordGenModel();
        PasswordGenView view = new PasswordGenView();
        new PasswordGenController(model, view);
        view.setVisible(true);
    }
}