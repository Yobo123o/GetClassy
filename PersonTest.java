import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person testPerson;

    @BeforeEach
    void setup() {
        testPerson = new Person("John", "Doe", "12345", "Mr.", 1985);
    }

    @Test
    void testConstructorInitialization() {
        assertEquals("John", testPerson.getFirstName());
        assertEquals("Doe", testPerson.getLastName());
        assertEquals("12345", testPerson.getID());
        assertEquals("Mr.", testPerson.getTitle());
        assertEquals(1985, testPerson.getYOB());
    }

    @Test
    void testSetFirstName() {
        testPerson.setFirstName("Jane");
        assertEquals("Jane", testPerson.getFirstName());
    }

    @Test
    void testSetLastName() {
        testPerson.setLastName("Smith");
        assertEquals("Smith", testPerson.getLastName());
    }

    @Test
    void testSetTitle() {
        testPerson.setTitle("Dr.");
        assertEquals("Dr.", testPerson.getTitle());
    }

    @Test
    void testSetYOBValid() {
        testPerson.setYOB(1970);
        assertEquals(1970, testPerson.getYOB());
    }

    @Test
    void testSetYOBInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> testPerson.setYOB(1930));
        assertEquals("Year of Birth must be between 1940 and 2010.", exception.getMessage());
    }

    @Test
    void testFullName() {
        assertEquals("John Doe", testPerson.fullName());
    }

    @Test
    void testFormalName() {
        assertEquals("Mr. John Doe", testPerson.formalName());
    }

    @Test
    void testGetAge() {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        assertEquals(currentYear - 1985, testPerson.getAge());
    }

    @Test
    void testGetAgeForSpecificYear() {
        assertEquals(15, testPerson.getAge(2000));
    }

    @Test
    void testToCSV() {
        assertEquals("12345,John,Doe,Mr.,1985", testPerson.toCSV());
    }

    @Test
    void testToJSON() {
        assertEquals("{\"ID\":\"12345\", \"FirstName\":\"John\", \"LastName\":\"Doe\", \"Title\":\"Mr.\", \"YOB\":1985}", testPerson.toJSON());
    }

    @Test
    void testToXML() {
        assertEquals("<Person><ID>12345</ID><FirstName>John</FirstName><LastName>Doe</LastName><Title>Mr.</Title><YOB>1985</YOB></Person>", testPerson.toXML());
    }

    @Test
    void testEqualsAndHashCode() {
        Person samePerson = new Person("John", "Doe", "12345", "Mr.", 1985);
        assertEquals(testPerson, samePerson);
        assertEquals(testPerson.hashCode(), samePerson.hashCode());
    }

    @Test
    void testNotEqualsDifferentID() {
        Person differentPerson = new Person("John", "Doe", "54321", "Mr.", 1985);
        assertNotEquals(testPerson, differentPerson);
    }
}
