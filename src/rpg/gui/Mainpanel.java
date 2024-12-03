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
private void initComponents(){
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


    public void appendText(String text) {
        // Añadimos el texto al textDisplay
        textDisplay.append(text);
        // Hacemos que el textDisplay se desplace al final del texto
        textDisplay.setCaretPosition(textDisplay.getDocument().getLength());
    }


}

public void main() {
}
