package by.teachmeskills.lapeiko.homework28;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void shouldWorkIfArrayIsBlank() {
        char[] chars = new char[0];
        assertTrue(StringUtils.isBlank(chars));
    }

    @Test
    void shouldThrowIfArrayNotBlank() {
        char[] chars = {' ', ',', '\n'};
        assertFalse(StringUtils.isBlank(chars));
    }

    @Test
    void isArrayContainOnlyRussian() {
        char[] chars = {'а', 'д', 'с', 'ё'};
        assertTrue(StringUtils.isRussian(chars));
    }

    @Test
    void isArrayContainOnlyRussianUpperCase() {
        char[] chars = {'А', 'Д', 'С', 'Ё'};
        assertTrue(StringUtils.isRussian(chars));
    }

    @Test
    void shouldThrowIfArrayContainNotOnlyRussian() {
        char[] chars = {'а', 'д', 'с', 'b', 'f', 'r'};
        assertFalse(StringUtils.isRussian(chars));
    }

    @Test
    void shouldThrowIfArrayContainNotOnlyRussianUpperCase() {
        char[] chars = {'З', 'Д', 'С', 'U', 'F', 'R'};
        assertFalse(StringUtils.isRussian(chars));
    }

    @Test
    void shouldThrowIfTwoArraysAreBlank() {
        char[] main = {};
        char[] sub = {};
        assertThrows(IllegalArgumentException.class, () -> StringUtils.contains(main, sub));
    }

    @Test
    void shouldThrowIfSubArrayLongerThanMainArray() {
        char[] main = {'a', 'b'};
        char[] sub = {'a', 'b', 'c'};
        assertFalse(() -> StringUtils.contains(main, sub));
    }

    @Test
    void isSubArrayContainMainArray() {
        char[] main = {'a', 'b', 'c', 'd', 'e', 'f'};
        char[] sub = {'b', 'c', 'd'};
        assertTrue(StringUtils.contains(main, sub));
    }

    @Test
    void shouldThrowIfSubArrayDoNotContainMainArray() {
        char[] main = {'a', 'b', 'c', 'd', 'e', 'f'};
        char[] sub = {'b', 'd', 'c'};
        assertFalse(StringUtils.contains(main, sub));
    }

    @Test
    void shouldThrowIfArrayContainLetters() {
        char[] chars = {'b', 'd', 'c'};
        assertThrows(IllegalArgumentException.class, () -> StringUtils.parseInt(chars));
    }

    @Test
    void shouldThrowIfArrayContainNotOnlyNumbers() {
        char[] chars = {'6', 'b', '5', 'a'};
        assertThrows(IllegalArgumentException.class, () -> StringUtils.parseInt(chars));
    }

    @Test
    void isArrayContainSymbolsToParseInt() {
        char[] chars = {'1', '2', '3'};
        int actual = StringUtils.parseInt(chars);
        int expected = 123;
        assertEquals(expected, actual);
    }
}