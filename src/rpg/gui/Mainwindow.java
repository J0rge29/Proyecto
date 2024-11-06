package rpg.gui;


import javax.swing.*;

import rpg.gui.buttons.BaseButton;
import rpg.gui.internalFrames.CristalFrame;
import rpg.gui.internalFrames.StatusFrame;
import rpg.gui.panels.BottomPanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.TopPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Mainwindow extends JFrame {


    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JButton button1;
    private JButton b2;
    private JButton b3;
    private JLabel exampleLabel;
    private JDesktopPane desktopPane;


    public MainWindow() {
        initComponents();
    }

    private void initComponents() {

        desktopPane = new JDesktopPane();

        desktopPane.setPreferredSize(mainPanel != null ?
                mainPanel.getPreferredSize() : null);

        mainPanel.setBounds(0, 0, mainPanel.getPreferredSize().width,
                mainPanel.getPreferredSize().height);

        desktopPane.add(mainPanel, JLayeredPane.DEFAULT_LAYER);

        setContentPane(desktopPane);

        setTitle("RPG Game");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();

        setLocationRelativeTo(null);

        setVisible(true);

        setResizable(false);
    }

    public static void main(String[] args) {
        new MainWindow();

    private void createUIComponents() {

    };
}

    private void createUIComponents() {
        topPanel = new TopPanel();
        middlePanel = new MiddlePanel();
        bottomPanel = new BottomPanel();
        button1 = new BaseButton("Button 1");
        b2 = new BaseButton("Tiendas");
        b3 = new BaseButton("Inventario");
        atacarButton = new AttackButton();
        habilidadesButton = new SkillPanelButton();
        huirButton = new FleeButton();
        exampleLabel = new PortraitLabel();
    }
    private void createUIComponents() {

        // Otros componentes de la interfaz
        lifeLabel = new BarLabel(100, 100, BarType.LIFE);
        magicLabel = new BarLabel(30, 100, BarType.MAGIC);
        expLabel = new BarLabel(0, 350, BarType.EXPERIENCE);
    }

}
