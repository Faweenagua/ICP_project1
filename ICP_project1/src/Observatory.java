package theGalamseyArea;

import java.util.ArrayList;
import java.util.Objects;
/**
 * An Observatory class that allows the user to study the properties of an area which is being observed
 *@author Michael Dankwah AGYEMAN-PREMPEH
 *@author Alhassan ISSIFU
 *@author Francis AWEENAGUA
 *@author Eugenia AKPO
 */
public class Observatory {
    private String name,country;
    private int yearStarted;
    private double areaInSquareKilometers;
    private ArrayList<Galamsey> events=new ArrayList<Galamsey>();
    private Integer numberOfGalamseyEvents = 0;
    /**
     * Default constructor
     */
    public Observatory(){}
    /**
     * Overloaded constructor
     * @param name of observatory
     * @param country of country being observed
     * @param yearStarted is the year observing a country started
     * @param areaInSquareKilometers is the area of the observatory
     * @param events is the number of events in an observatory
     */
    public Observatory(String name, String country, int yearStarted, double areaInSquareKilometers, ArrayList<Galamsey> events) {
        this.name = name;
        this.country = country;
        this.yearStarted = yearStarted;
        this.areaInSquareKilometers = areaInSquareKilometers;
        this.events = events;
    }
    /**
     * Overloaded constructor
     * @param name of observatory
     * @param country of country being observed
     * @param yearStarted is the year observing a country started
     * @param areaInSquareKilometers is the area of the observatory
     */
    public Observatory(String name, String country, int yearStarted, double areaInSquareKilometers) {
        this.name = name;
        this.country = country;
        this.yearStarted = yearStarted;
        this.areaInSquareKilometers = areaInSquareKilometers;
    }
    
    /**
     * 
     * @return areaInSquareKilometers of the observatory
     */
    public double getAreaInSquareKilometers() {
        return areaInSquareKilometers;
    }

    /**
     * 
     * @param areaInSquareKilometers of the observatory
     */
    public void setAreaInSquareKilometers(double areaInSquareKilometers) {
        this.areaInSquareKilometers = areaInSquareKilometers;
    }

    /**
     * 
     * @return numberOfGalamseyEvents in an observatory
     */
    public Integer getNumberOfGalamseyEvents() {
        return numberOfGalamseyEvents;
    }

    /**
     * 
     * @param numberOfGalamseyEvents in an observatory
     */
    public void setNumberOfGalamseyEvents(Integer numberOfGalamseyEvents) {
        this.numberOfGalamseyEvents = numberOfGalamseyEvents;
    }
    
    /**
     * 
     * @param g allows the user to add a Galamsey event called "g" (a placeholder) to an observatory.
     */
    public void addEvent(Galamsey g){ 
        this.events.add(g);
        numberOfGalamseyEvents += 1;
    }
    
    
/**
 * 
 * @return name of observatory
 */
    public String getName() { return name; }
    /**
     * 
     * @param name of observatory
     */
    public void setName(String name) { this.name = name; }
    /**
     * 
     * @return country being observed
     */
    public String getCountry() { return country; }
    /**
     * 
     * @param country being observed
     */
    public void setCountry(String country) { this.country = country; }
    /**
     * 
     * @return yearStarted, that is when observing began.
     */
    public int getYearStarted() { return yearStarted; }
    /**
     * 
     * @param yearStarted, that is when observing began.
     */
    public void setYearStarted(int yearStarted) { this.yearStarted = yearStarted; }
    /**
     * 
     * @return areaInSquareKilometers of the observatory
     */
    public double getAreaInSquareMeters() { return areaInSquareKilometers; }
    /**
     * 
     * @param areaInSquareMeters of the observatory
     */
    public void setAreaInSquareMeters(double areaInSquareMeters) { this.areaInSquareKilometers = areaInSquareMeters; }
    /**
     * 
     * @return events in the observatory
     */
    public ArrayList<Galamsey> getEvents() { return events; }
    /**
     * 
     * @param events in the observatory
     */
    public void setEvents(ArrayList<Galamsey> events) { this.events = events; }
    /**
     * toString method that returns the details of an observatory as a string
     * @return string details of observatory
     */
    @Override
    public String toString() {
        return "Observatory{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", yearStarted=" + yearStarted +
                ", areaInSquareMeters=" + areaInSquareKilometers +
                ", events=" + events +
                '}'; }
    /**
     * equals method to compare observatories
     * @param o the object to compare with main object
     * @return boolean true if equal and false if unequal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Observatory)) return false;
        Observatory that = (Observatory) o;
        return getYearStarted() == that.getYearStarted() &&
                Double.compare(that.getAreaInSquareMeters(), getAreaInSquareMeters()) == 0 &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getCountry(), that.getCountry()) &&
                Objects.equals(getEvents(), that.getEvents());  }
    /**
     * hash function
     * @return the values of the elements in the observatory
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCountry(), getYearStarted(), getAreaInSquareMeters(), getEvents()); }
    /**
     * gets the largest galamsey colour values
     * @return the largest galamsey colour value recorded
     */
    public int largestGalamseyColourValueRecorded(){
        int green=0,yellow=0,brown=0;
        for(Galamsey i : this.getEvents()){
            if(i.getVegetationColourValue()==1){ green+=1; }
            if(i.getVegetationColourValue()==2){ yellow+=1; }
            if(i.getVegetationColourValue()==3){ brown+=1; }
        }
        if(yellow==0 && brown==0 && green==0){return 0;}
        if(brown>=yellow && brown>=green){return 3;}
        if(yellow>=green && yellow>=brown){return 2;}
        if(green>=yellow && green>=brown){return 1;}
        return -1;
    }
    /**
     * gets the average galamsey colour value recorded
     * @return average galamsey colour value recorded
     */
    public double averageGalamseyColourValueRecorded() {
        double sum = 0;
        int count = 0;
        for (Galamsey i : this.getEvents()) {
            sum += i.getVegetationColourValue();
            count += 1;
        }
        return sum / count;
    }
    /**
     * Creates a list of all galamsey recorded at the observatory with a colour value greater than a given number
     * @param number arbitrary number to compare colour values to
     * @return
     */
    public ArrayList<Galamsey> galamseysWithColourValueGreaterThan(double number) {

        ArrayList<Galamsey> list = new ArrayList<Galamsey>();
        for (Galamsey i : this.getEvents()) {
            if (i.getVegetationColourValue() > number) {
                list.add(i);
            }
        }
        return list;
    }
    
    /**
     * Creates a list of all galamsey recorded at the observatory with a colour value lesser than a given number
     * @param number arbitrary number to compare colour values to
     * @return
     */
    public ArrayList<Galamsey> galamseysWithColourValueLesserThan(double number) {

        ArrayList<Galamsey> list = new ArrayList<Galamsey>();
        for (Galamsey i : this.getEvents()) {
            if (i.getVegetationColourValue() < number) {
                list.add(i);
            }
        }
        return list;
    }
    
    /**
     * Creates a list of all galamsey recorded at the observatory with a colour value equal to a given number
     * @param number arbitrary number to compare colour values to
     * @return
     */
    public ArrayList<Galamsey> galamseysWithColourValueEqualTo(double number) {

        ArrayList<Galamsey> list = new ArrayList<Galamsey>();
        for (Galamsey i : this.getEvents()) {
            if (i.getVegetationColourValue() == number) {
                list.add(i);
            }
        }
        return list;
    }
}
