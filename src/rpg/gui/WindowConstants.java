package rpg.gui;

import javax.swing.border.EmptyBorder;
import java.awt.*;

public interface WindowConstants {


    int WINDOW_WIDTH = 1500;

    int TOP_HEIGHT = 150;

    int MIDDLE_HEIGHT = 320;

    int BOTTOM_HEIGHT = 350;

    int SIMPLE_MARGIN = 18;

    Dimension TOP_DIMENSION = new Dimension(WINDOW_WIDTH, TOP_HEIGHT);

    Dimension MIDDLE_DIMENSION = new Dimension(WINDOW_WIDTH, MIDDLE_HEIGHT);

    Dimension BOTTOM_DIMENSION = new Dimension(WINDOW_WIDTH, BOTTOM_HEIGHT);

    EmptyBorder EMPTY_BORDER = new EmptyBorder(SIMPLE_MARGIN, SIMPLE_MARGIN,
            SIMPLE_MARGIN, SIMPLE_MARGIN);

    Font FONT = new Font(new Font("Arial", Font.PLAIN, 14).getAttributes());

}
