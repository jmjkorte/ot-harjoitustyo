
package fi.mielialapaivakirja.logics;

/** Represents an indicator in patient's diary.
 *
 * 
 */
public class Indicator {
    private String nameOfIndicator;
    private int minValue;
    private int maxValue;
    private int criticalValue;
    private int lowerOrHigher;
    
    /** Constructor of the class Indicator.
     *
     * @param name  Name of an indicator.
     * @param min   Min value of an indicator.
     * @param max   Max value of an indicator.
     * @param criticalValue     Critical value of an indicator, if chosen.
     * @param lowerOrHigher     Indicates if user is interested of lower or higher values than critical value. 
     */
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
    
    public int getLowerOrHigher() {
        return lowerOrHigher;
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

    /** Represents String presentation of an instance.
     *
     * @return Name of an indicator, min value and max value.
     */
    @Override
    public String toString() {
        return  nameOfIndicator + " (" + minValue + "-" + maxValue + ")";
    }
    
    

    
}
