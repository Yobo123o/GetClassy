import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product testProduct;

    @BeforeEach
    void setup() {
        testProduct = new Product("Widget", "A useful widget", "WID123", 19.99);
    }

    @Test
    void testConstructorInitialization() {
        assertEquals("Widget", testProduct.getName());
        assertEquals("A useful widget", testProduct.getDescription());
        assertEquals("WID123", testProduct.getID());
        assertEquals(19.99, testProduct.getCost());
    }

    @Test
    void testSetName() {
        testProduct.setName("Gadget");
        assertEquals("Gadget", testProduct.getName());
    }

    @Test
    void testSetDescription() {
        testProduct.setDescription("An upgraded gadget");
        assertEquals("An upgraded gadget", testProduct.getDescription());
    }

    @Test
    void testSetCostValid() {
        testProduct.setCost(25.99);
        assertEquals(25.99, testProduct.getCost());
    }

    @Test
    void testSetCostInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> testProduct.setCost(-5.0));
        assertEquals("Cost must be a non-negative value.", exception.getMessage());
    }

    @Test
    void testToCSV() {
        assertEquals("WID123,Widget,A useful widget,19.99", testProduct.toCSV());
    }

    @Test
    void testToJSON() {
        assertEquals("{\"ID\":\"WID123\", \"Name\":\"Widget\", \"Description\":\"A useful widget\", \"Cost\":19.99}", testProduct.toJSON());
    }

    @Test
    void testToXML() {
        assertEquals("<Product><ID>WID123</ID><Name>Widget</Name><Description>A useful widget</Description><Cost>19.99</Cost></Product>", testProduct.toXML());
    }

    @Test
    void testEqualsAndHashCode() {
        Product sameProduct = new Product("Widget", "A useful widget", "WID123", 19.99);
        assertEquals(testProduct, sameProduct);
        assertEquals(testProduct.hashCode(), sameProduct.hashCode());
    }

    @Test
    void testNotEqualsDifferentID() {
        Product differentProduct = new Product("Widget", "A useful widget", "DIFF123", 19.99);
        assertNotEquals(testProduct, differentProduct);
    }

    @Test
    void testToString() {
        assertEquals("Widget: A useful widget (Cost: $19.99)", testProduct.toString());
    }
}

