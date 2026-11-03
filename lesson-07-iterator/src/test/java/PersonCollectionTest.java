import opgave1.Person;
import opgave1.PersonCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class PersonCollectionTest {

    private PersonCollection collection;
    private Person p1;
    private Person p2;

    @BeforeEach
    void setUp() {
        collection = new PersonCollection();

        p1 = new Person("Rasmus");
        p2 = new Person("Lars");
    }

    @Test
    void hasNextReturnsFalseWhenEmpty() {

        // Arrange
        Iterator<Person> iterator = collection.iterator();

        // Act
        boolean result = iterator.hasNext();

        // Assert
        assertFalse(result);
    }

    @Test
    void hasNextReturnsTrueWhenNotEmpty() {

        // Arrange
        collection.add(p1);
        Iterator<Person> iterator = collection.iterator();

        // Act
        boolean result = iterator.hasNext();


        // Assert
        assertTrue(result);
    }

    @Test
    void hasNextReturnsFalseWhenEndOfCollection() {

        // Arrange
        collection.add(p1);
        Iterator<Person> iterator = collection.iterator();
        iterator.next();

        // Act
        boolean result = iterator.hasNext();

        // Assert
        assertFalse(result);
    }


    @Test
    void nextReturnsThePerson() {

        // Arrange
        collection.add(p1);
        Iterator<Person> iterator = collection.iterator();

        // Act
        Person actual = iterator.next();
        Person expected = p1;

        // Assert
        assertEquals(actual, expected);
    }

    @Test
    void nextReturnsAllPersons() {

        // Arrange
        collection.add(p1);
        collection.add(p2);
        Iterator<Person> iterator = collection.iterator();

        // Act

        // Assert
        assertEquals(p1, iterator.next());
        assertEquals(p2, iterator.next());
    }


    @Test
    void nextThrowsExceptionWhenReachingEnd() {
        // Arrange
        collection.add(p1);
        Iterator<Person> iterator = collection.iterator();
        iterator.next();

        assertThrows(NoSuchElementException.class, () -> iterator.next());
    }
}
