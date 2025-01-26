import java.util.Calendar;
import java.util.Objects;

/**
 * Represents a person with basic details and utility methods.
 */
public class Person {
    private String firstName;
    private String lastName;
    private String ID; // Should not change after initialization
    private String title;
    private int YOB;

    /**
     * Full constructor to initialize all fields.
     */
    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        setYOB(YOB); // Ensures validation
    }

    /**
     * Overloaded constructor for partial initialization.
     */
    public Person(String firstName, String lastName, String ID) {
        this(firstName, lastName, ID, "", 0);
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public int getYOB() {
        return YOB;
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYOB(int YOB) {
        if (YOB >= 1940 && YOB <= 2010) {
            this.YOB = YOB;
        } else {
            throw new IllegalArgumentException("Year of Birth must be between 1940 and 2010.");
        }
    }

    /**
     * Returns the full name as "FirstName LastName".
     */
    public String fullName() {
        return firstName + " " + lastName;
    }

    /**
     * Returns the formal name as "Title FullName".
     */
    public String formalName() {
        return title + " " + fullName();
    }

    /**
     * Calculates and returns the age based on the current year.
     */
    public int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return currentYear - YOB;
    }

    /**
     * Calculates and returns the age based on a specified year.
     */
    public int getAge(int year) {
        return year - YOB;
    }

    /**
     * Returns a CSV representation of the person.
     */
    public String toCSV() {
        return String.format("%s,%s,%s,%s,%d", ID, firstName, lastName, title, YOB);
    }

    /**
     * Returns a JSON representation of the person.
     */
    public String toJSON() {
        return String.format("{\"ID\":\"%s\", \"FirstName\":\"%s\", \"LastName\":\"%s\", \"Title\":\"%s\", \"YOB\":%d}",
                ID, firstName, lastName, title, YOB);
    }

    /**
     * Returns an XML representation of the person.
     */
    public String toXML() {
        return String.format("<Person><ID>%s</ID><FirstName>%s</FirstName><LastName>%s</LastName><Title>%s</Title><YOB>%d</YOB></Person>",
                ID, firstName, lastName, title, YOB);
    }

    @Override
    public String toString() {
        return formalName() + " (Born: " + YOB + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YOB == person.YOB &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(ID, person.ID) &&
                Objects.equals(title, person.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, ID, title, YOB);
    }
}
