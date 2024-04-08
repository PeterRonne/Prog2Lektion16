package opgave01.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EaaaLinkedListTest {

    private EaaaLinkedList<String> animalGroups;

    @BeforeEach
    void setup() {
        animalGroups = new EaaaLinkedList<>();
        animalGroups.add("Invertebrates");
        animalGroups.add("Fish");
        animalGroups.add("Amphibians");
        animalGroups.add("Reptiles");
        animalGroups.add("Birds");

    }

    @Test
    void add() {
        // Arrange
        int expectedSize = 6;
        String mammels = "Mammels";

        // Act
        animalGroups.add(mammels);
        int actualSize = animalGroups.size();

        //Assert
        assertEquals(expectedSize, actualSize);
        assertEquals(mammels, animalGroups.get(expectedSize - 1));
    }

    @Test
    void remove() {
        // Arrange
        int expextedSize = 4;
        String elementToRemove = "Fish";

        // Act
        boolean removed = animalGroups.remove(elementToRemove);
        int actualSize = animalGroups.size();

        //Assert
        assertEquals(expextedSize, actualSize);
        assertTrue(removed);
    }

    @Test
    void addFirst() {
        int expectedSize = 6;
        String mammels = "Mammels";

        // Act
        animalGroups.addFirst(mammels);
        int actualSize = animalGroups.size();

        //Assert
        assertEquals(expectedSize, actualSize);
        assertEquals(mammels, animalGroups.get(0));
    }

    @Test
    void getFirst() {
        // Arrange
        String expected = "Invertebrates";

        // Act
        String actual = animalGroups.getFirst();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void getFirst_Throws_NoSuchElementException() {
        animalGroups = new EaaaLinkedList<>();
        assertThrows(NoSuchElementException.class, () -> animalGroups.getFirst());
    }

    @Test
    void removeFirst() {
        // Arrange
        int expextedSize = 4;
        String expectedFirst = "Fish";

        // Act
        animalGroups.removeFirst();
        int actualSize = animalGroups.size();

        //Assert
        assertEquals(expextedSize, actualSize);
        assertEquals(expectedFirst, animalGroups.getFirst());
    }

    @Test
    void removeFirst_Throws_NoSuchElementException() {
        animalGroups = new EaaaLinkedList<>();
        assertThrows(NoSuchElementException.class, () -> animalGroups.removeFirst());
    }

    @Test
    void containsTestTrue() {
        // Arrange
        String reptiles = "Reptiles";

        // Act
        boolean contains = animalGroups.contains(reptiles);

        //Assert
        assertTrue(contains);
    }

    @Test
    void containsTestFalse() {
        String unknownSpecies = "unknown species";

        // Act
        boolean contains = animalGroups.contains(unknownSpecies);

        //Assert
        assertFalse(contains);
    }

    @Test
    void clear() {
        // Arrange
        int expectedSize = 0;

        // Act
        animalGroups.clear();
        int actualSize = animalGroups.size();

        //Assert
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void size() {
        // Arrange
        int expected = 5;

        // Act
        int actual = animalGroups.size();

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void isEmpty() {
        // Act
        boolean isEmpty = animalGroups.isEmpty();

        //Assert
        assertFalse(isEmpty);
    }


    @Test
    void get() {
        // Arrange
        String expected = "Amphibians";

        // Act
        String actual = animalGroups.get(2);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void get_Throws_Index_Out_Of_Bounds_Exception() {
        assertThrows(IndexOutOfBoundsException.class, () -> animalGroups.get(100));
    }

    @Test
    void add_With_Index() {
        // Arrange
        String mammals = "Mammals";
        int expectedSize = 6;

        // Act
        animalGroups.add(4, mammals);
        int actualSize = animalGroups.size();

        //Assert
        assertEquals(mammals, animalGroups.get(4));
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void add_Throws_Index_Out_Of_Bounds_Exception() {
        assertThrows(IndexOutOfBoundsException.class, () -> animalGroups.add(100, "Mammels"));
    }

    @Test
    void add_With_Index_When_Index_Equals_Current_Size() {
        // Arrange
        String mammals = "Mammals";
        int expectedSize = 6;

        // Act
        animalGroups.add(5, mammals);
        int actualSize = animalGroups.size();

        //Assert
        assertEquals(mammals, animalGroups.get(5));
        assertEquals(expectedSize, actualSize);
    }


    @Test
    void remove_With_Index() {
        // Arrange
        String s = "Reptiles";
        int expectedSize = 4;

        // Act
        animalGroups.remove(2);
        int actualSize = animalGroups.size();

        //Assert
        assertEquals(s, animalGroups.get(2));
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void remove_First_With_Index() {
        // Arrange
        String s = "Fish";
        int expectedSize = 4;

        // Act
        animalGroups.remove(0);
        int actualSize = animalGroups.size();

        //Assert
        assertEquals(s, animalGroups.get(0));
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void remove_Last_With_Index() {
        // Arrange
        String s = "Reptiles";
        int expectedSize = 4;

        // Act
        animalGroups.remove(4);
        int actualSize = animalGroups.size();

        //Assert
        assertEquals(s, animalGroups.get(3));
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void remove_All_Elements_With_Index() {
        // Arrange
        animalGroups = new EaaaLinkedList<>();
        animalGroups.add("Mammels");

        int expectedSize = 0;

        // Act
        animalGroups.remove(0);
        int actualSize = animalGroups.size();

        //Assert
        assertNull(animalGroups.getHead());
        assertNull(animalGroups.getTail());
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void remove_Throws_Index_Out_Of_Bounds_Exception() {
        assertThrows(IndexOutOfBoundsException.class, () -> animalGroups.remove(100));
    }

    @Test
    void indexOf() {
        // Arrange
        int expected = 2;

        // Act
        int actual = animalGroups.indexOf("Amphibians");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void indexOf_Element_Does_Not_Exist() {
        // Arrange
        int expected = -1;

        // Act
        int actual = animalGroups.indexOf("unknown species");

        //Assert
        assertEquals(expected, actual);
    }
}