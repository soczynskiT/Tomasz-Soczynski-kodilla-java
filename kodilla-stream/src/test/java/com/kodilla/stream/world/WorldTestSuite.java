package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        final Country poland = new Country("Poland", new BigInteger("400"));
        final Country germany = new Country("Germany", new BigInteger("3000"));
        final Country slovakia = new Country("Slovakia", new BigInteger("50"));
        final Continent europe = new Continent("Europe");
        europe.addCountry(poland);
        europe.addCountry(germany);
        europe.addCountry(slovakia);

        final Country nepal = new Country("Nepal", new BigInteger("6"));
        final Country russia = new Country("Russia", new BigInteger("20000"));
        final Continent asia = new Continent("Asia");
        asia.addCountry(nepal);
        asia.addCountry(russia);

        final Country iraq = new Country("Iraq", new BigInteger("100000"));
        final Continent africa = new Continent("Africa");
        africa.addCountry(iraq);

        //When
        final World earth = new World();
        earth.addContinent(europe);
        earth.addContinent(asia);
        earth.addContinent(africa);
        final BigInteger result = earth.getPeopleQuantity();

        //Then
        Assert.assertEquals(new BigInteger("123456"), result);
    }
}
