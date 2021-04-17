
package fi.mielialapaivakirja.logics;


public class Indicator {
    private String nameOfIndicator;
    private int minValue;
    private int maxValue;
    private int value;
    
    public Indicator(String name, int min, int max) {
        this.nameOfIndicator = name;
        this.minValue = min;
        this.maxValue = max;
        this.value = 0;
    }
    
    
    


    public String getNameOfIndicator() {
        return nameOfIndicator;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getValue() {
        return value;
    }

    public void setNameOfIndicator(String nameOfIndicator) {
        this.nameOfIndicator = nameOfIndicator;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return  nameOfIndicator + ": minValue=" + minValue + ", maxValue=" + maxValue;
    }
    
    

    
}
