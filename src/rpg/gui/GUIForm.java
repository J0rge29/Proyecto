package rpg.gui;

public class GUIForm {

    public MainWindow() {
        setTitle("RPG Game");
        setSize( WINDOW_SIZE );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainWindow();
    }






}


