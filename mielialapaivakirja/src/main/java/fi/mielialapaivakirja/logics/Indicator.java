
package fi.mielialapaivakirja.logics;


public class Indicator {
    private String nameOfIndicator;
    private int minValue;
    private int maxValue;
    
    
    public Indicator(String name, int min, int max) {
        this.nameOfIndicator = name;
        this.minValue = min;
        this.maxValue = max;
        
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

    
    public void setNameOfIndicator(String nameOfIndicator) {
        this.nameOfIndicator = nameOfIndicator;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

   

    @Override
    public String toString() {
        return  nameOfIndicator + "(" + minValue + "-" + maxValue + ")";
    }
    
    

    
}
