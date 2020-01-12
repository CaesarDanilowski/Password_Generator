public class Main {
    public static void main(String[] args) {
        PasswordGenModel model = new PasswordGenModel();
        PasswordGenMenu menu = new PasswordGenMenu();
        PasswordGenView view = new PasswordGenView(menu);
        new PasswordGenController(model, menu, view);
        view.setVisible(true);
    }
}