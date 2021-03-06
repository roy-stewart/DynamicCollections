package me.hdgenius.dynamiccollections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("DynamicCollection.without")
public class DynamicCollectionWithoutTest {

    @Test
    @DisplayName("Should return a Set that does not contain any of the excluded values")
    public void testThatTheWithoutMethodReturnsASetThatDoesNotContainAnyOfTheSpecifiedValues() {
        final Collection<Integer> excludedValues = Arrays.asList(1, 3, 5, 6);
        final Collection<Integer> originalValues = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final Set<Integer> collectionWithoutValues = DynamicCollection.of(originalValues).without(excludedValues);

        for (final Integer valueToBeExcluded: excludedValues) {
            assertThat(collectionWithoutValues.contains(valueToBeExcluded), is(false));
        }
    }

    @Test
    @DisplayName("Should return a Set that contains every value that is not excluded")
    public void testThatTheWithoutMethodReturnsASetThatContainsEveryValueThatIsNotExcluded() {
        final Collection<Integer> excludedValues = Arrays.asList(1, 3, 5, 6);
        final Collection<Integer> originalValues = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final Set<Integer> collectionWithoutValues = DynamicCollection.of(originalValues).without(excludedValues);

        for (final Integer valueToBeExcluded: excludedValues) {
            assertThat(collectionWithoutValues.contains(valueToBeExcluded), is(false));
        }
    }

    @Test
    @DisplayName("Should return a Set that correctly removes a requested value from the collection")
    public void testThatTheWithoutMethodReturnsASetThatCorrectlyRemovesValues() {
        final Collection<Integer> excludedValues = new ArrayList<>();
        final Collection<Integer> originalValues = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final Set<Integer> collectionWithoutValues = DynamicCollection.of(originalValues).without(excludedValues);
        final int removedValue = 3;
        collectionWithoutValues.remove(removedValue);

        assertThat(collectionWithoutValues.contains(removedValue), is(false));
    }

    @Test
    @DisplayName("Should return a Set that does not modify the source collection when a value is removed")
    public void testThatTheWithoutMethodReturnsASetThatDoesNotModifyTheSourceCollectionWhenAValueIsRemoved() {
        final Collection<Integer> sourceCollection = Arrays.asList(1, 2, 3);
        final Collection<Integer> valuesToExclude = Collections.singleton(3);

        final Set<Integer> collectionWithoutValues = DynamicCollection.of(sourceCollection).without(valuesToExclude);

        assertThat(sourceCollection, contains(1, 2, 3));
    }

    @Test
    @DisplayName("Should return a Set that correctly adds a requested value to the collection")
    public void testThatTheWithoutMethodReturnsASetThatCorrectlyAddsValues() {
        final int valueToAdd = 3;
        final Collection<Integer> excludedValues = new ArrayList<>();
        excludedValues.add(valueToAdd);
        final Set<Integer> collectionWithoutValues = DynamicCollection.of(new ArrayList<Integer>()).without(excludedValues);
        collectionWithoutValues.add(valueToAdd);

        assertThat(collectionWithoutValues.contains(valueToAdd), is(true));
    }

    @Test
    @DisplayName("Should return a Set that does not modify the source collection when a value is added")
    public void testThatTheWithoutMethodReturnsASetThatDoesNotModifyTheSourceCollectionWhenAValueIsAdded() {
        final Collection<Integer> sourceCollection = Arrays.asList(1, 2, 3);
        final Set<Integer> collectionWithoutValues = DynamicCollection.of(sourceCollection).without(Arrays.asList(3));

        assertThat(sourceCollection, contains(1, 2, 3));
    }

    @Test
    @DisplayName("Should return a Set that correctly clears all values")
    public void testThatTheWithoutMethodReturnsASetThatCorrectlyClearsAllValues() {
        final Collection<Integer> originalValues = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final Set<Integer> collectionWithoutValues = DynamicCollection.of(originalValues).without(new ArrayList<>());
        collectionWithoutValues.clear();

        for (int valueToCheck = 0; valueToCheck < 10; valueToCheck++) {
            assertThat(collectionWithoutValues.contains(valueToCheck), is(false));
        }
    }

}
