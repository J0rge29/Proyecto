package rpg.gui;

import rpg.entities.GameCharacter;
import rpg.entities.Player;
import rpg.entities.enemies.Enemy;
import rpg.entities.enemies.undead.Skeleton;
import rpg.factory.EnemyFactory;
import rpg.gui.labels.EnemySpriteLabel;
import rpg.gui.labels.PlayerSpriteLabel;
import rpg.gui.panels.BottomPanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.Toppanel;
import rpg.gui.ui.EnemyLabelUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;

public class MainWindow extends JFrame {

    private JPanel mainpanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel topPanel;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JTextArea textDisplay;
    private JScrollPane textScroll;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JLabel EnemyLabelUI;
    private JLabel UserHoverUI;
    private Player player;
    private Enemy enemy;

    public static void main(String[] args) {
        new MainWindow();
    }

    public MainWindow() {
        setContentPane(mainpanel);
        pack();
        setVisible(true);
    }

    private void createUIComponents() {
        enemy= new Skeleton();
        //player = new Player();
        topPanel = new Toppanel();
        middlePanel = new MiddlePanel();
        bottomPanel = new BottomPanel();
        EnemyLabelUI = new EnemySpriteLabel(enemy);
        UserHoverUI = new PlayerSpriteLabel();


    }


    private void initComponents() {
        // Acciones previas en el panel
        // Definimos la forma de trabajo del ScrollPane
        // Hacemos que el ScrollPane no tenga bordes y sea transparente
        textScroll.getViewport().setOpaque(false);
        textScroll.setBorder(null);
        // Hacemos que el ScrollPane tenga solo la barra vertical
        textScroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textScroll.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // Definimos el color de fondo del display en Blanco y su fuente en 28px
        textDisplay.setFont(UIConstants.FONT.deriveFont(28f));
        textDisplay.setForeground(Color.WHITE);
        // Configuramos el scrool del textDisplay
        textDisplay.setColumns(1);
        textDisplay.setEditable(false);
        textDisplay.setLineWrap(true);
        textDisplay.setWrapStyleWord(true);
    }

    public void appendText (String text){
        // Añadimos el texto al textDisplay
        textDisplay.append(text);
        // Hacemos que el textDisplay se desplace al final del texto
        textDisplay.setCaretPosition(textDisplay.getDocument().getLength());
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public Player getPlayer() {
        return player;
    }

}
