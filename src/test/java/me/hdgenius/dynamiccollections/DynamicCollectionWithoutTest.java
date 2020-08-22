package me.hdgenius.dynamiccollections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("DynamicCollection.without")
public class DynamicCollectionWithoutTest {

    @Test
    @DisplayName("Should return a Set that does not contain any of the excluded values")
    public void testThatTheWithoutMethodReturnsASetThatDoesNotContainAnyOfTheSpecifiedValues() {
        final Collection<Integer> excludedValues = Arrays.asList(1, 3, 5, 6);
        final Set<Integer> collectionWithoutValues = DynamicCollection.without(excludedValues);

        for (final Integer valueToBeExcluded: excludedValues) {
            assertThat(collectionWithoutValues.contains(valueToBeExcluded), is(false));
        }
    }

    @Test
    @DisplayName("Should return a Set that contains every value that is not excluded")
    public void testThatTheWithoutMethodReturnsASetThatContainsEveryValueThatIsNotExcluded() {
        final Collection<Integer> excludedValues = Arrays.asList(1, 3, 5, 6);
        final Set<Integer> collectionWithoutValues = DynamicCollection.without(excludedValues);

        for (final Integer valueToBeExcluded: excludedValues) {
            assertThat(collectionWithoutValues.contains(valueToBeExcluded), is(false));
        }
    }

    @Test
    @DisplayName("Should return a Set that correctly removes a requested value from the collection")
    public void testThatTheWithoutMethodReturnsASetThatCorrectlyRemovesValues() {
        final Collection<Integer> excludedValues = new ArrayList<>();
        final Set<Integer> collectionWithoutValues = DynamicCollection.without(excludedValues);
        final int removedValue = 3;
        collectionWithoutValues.remove(removedValue);

        assertThat(collectionWithoutValues.contains(removedValue), is(false));
    }

}