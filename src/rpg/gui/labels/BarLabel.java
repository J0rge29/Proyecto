package rpg.gui.labels;

import javax.swing.*;

import rpg.enums.BarType;

public class BarLabel extends JLabel {

    private int barValue;
    private int maxValue;
    private final BarType type;

    public BarLabel(int value, int maxValue, BarType type) {

        this.barValue = value;
        this.maxValue = maxValue;
        this.type = type;
        initComponents();
    }

    public void initComponents() {

        setBarValue(barValue);
        setUI(new BarLabelUI(type));
    }

    public void setBarValue(int value) {

        this.barValue = value;
        setText(String.format("%d / %d", value, maxValue));
    }

    public int getBarValue(){

        return barValue;
    }

    public int getMaxValue() {
        return maxValue;
    }
}
