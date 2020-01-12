import javax.swing.*;
import java.awt.event.ActionListener;

public class PasswordGenMenu extends JMenuBar {
    private JMenu fileMenu;
    private JMenuItem saveItem;
    private JMenuItem openItem;
    private JMenuItem exitItem;

    public PasswordGenMenu() {
        fileMenu = new JMenu("File");
        saveItem = new JMenuItem("Save");
        openItem = new JMenuItem("Open");
        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(event -> System.exit(0));

        fileMenu.add(saveItem);
        fileMenu.add(openItem);
        fileMenu.add(exitItem);

        add(fileMenu);
    }

    public void setSaveListener(ActionListener listener) {
        saveItem.addActionListener(listener);
    }

    public void setOpenListener(ActionListener listener) {
        openItem.addActionListener(listener);
    }
}
