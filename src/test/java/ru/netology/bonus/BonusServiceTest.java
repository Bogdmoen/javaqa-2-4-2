package ru.netology.bonus;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;


class BonusServiceTest {
    BonusService service = new BonusService();


    @ParameterizedTest
    @CsvSource(
            value = {
                    "registered user, bonus under limit/ 100060/ true/ 30",
                    "registered user, bonus over limit/ 100000060/ true/ 500"
            },
            delimiter = '/'
    )
    void shouldCalculateRegistered(String test, long amount, boolean registered, long expected) {

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);

    }


    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", delimiter = '/', lineSeparator = ";")
    void shouldCalculateUnregistered(String test, long amount, boolean registered, long expected) {

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }


}