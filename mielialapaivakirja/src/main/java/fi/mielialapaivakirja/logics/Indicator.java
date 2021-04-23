
package fi.mielialapaivakirja.logics;


public class Indicator {
    private String nameOfIndicator;
    private int minValue;
    private int maxValue;
    private int criticalValue;
    private int lowerOrHigher;
    
    public Indicator(String name, int min, int max, int criticalValue, int lowerOrHigher) {
        this.nameOfIndicator = name;
        this.minValue = min;
        this.maxValue = max;
        this.criticalValue = criticalValue;
        this.lowerOrHigher = lowerOrHigher;
        
        
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
    
    public int getCriticalValue() {
        return criticalValue;
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

    public void setCriticalValue(int criticalValue) {
        this.criticalValue = criticalValue;
    }

   
    

   

    @Override
    public String toString() {
        return  nameOfIndicator + "(" + minValue + "-" + maxValue + ")";
    }
    
    

    
}
