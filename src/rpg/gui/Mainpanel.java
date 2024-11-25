package rpg.gui;

import rpg.gui.panels.Toppanel;

import javax.swing.*;

public class Mainpanel extends JFrame {
    private JPanel mainpanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel topPanel;

    public static void main(String[] args) {
        new Mainpanel();
    }

    public Mainpanel(){
        setContentPane(mainpanel);
    }

    private void createUIComponents() {
        topPanel=new Toppanel();
    }
}
