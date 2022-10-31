package com.example.lab8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    /**
     * create a mocklist for my citylist
     * @return the customized list
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }


    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    /**
     * Test for the hasCity method
     */
    @Test
    public void testHasCity(){
        list = MockCityList();
        City c1 = new City("Estevan", "SK");
        City c2 = new City("city1", "p1");
        assertFalse(list.hasCity(c1));
        assertFalse(list.hasCity(c2));
        list.addCity(c1);
        assertTrue(list.hasCity(c1));
        list.addCity(c2);
        assertTrue(list.hasCity(c2));
    }

    /**
     * Test for the delete method
     */
    @Test
    public void testDelete(){
        list = MockCityList();
        City c1 = new City("Estevan", "SK");
        City c2 = new City("city1", "p1");
        City c3 = new City("city12", "p2");
        list.addCity(c1);
        list.addCity(c2);

        assertTrue(list.hasCity(c1));
        list.delete(c1);
        assertFalse(list.hasCity(c1));

        assertTrue(list.hasCity(c2));
        list.delete(c2);
        assertFalse(list.hasCity(c2));

        assertThrows(RuntimeException.class, ()-> {
            list.delete(c3);
        });
    }


}
