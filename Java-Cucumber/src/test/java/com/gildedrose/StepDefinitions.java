package com.gildedrose;

import static org.junit.Assert.*;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StepDefinitions {
    private GildedRose gildedRose;

    /*@Given("The item as {string}")
    public void initial_sellin_is_and_quality_is(String name) {
        items[0] = new Item(name, 0, 0);
        app = new GildedRose(items);
    }*/



    @When("I update the quality")
    public void i_update_the_quality() {
        gildedRose.updateQuality();
    }

    @Then("I should get item as {string}")
    public void i_should_get_sellin_as_and_quality_as(String expected) {
        assertEquals(expected, gildedRose.items[0].name);
    }

    @Given("The items as:")
    public void theItemsAs(DataTable itemTable) {

        Item[] items = itemTable.asMaps().stream()
                .map(row -> new Item(row.get("name"),
                        Integer.parseInt(row.get("sellIn")),
                        Integer.parseInt(row.get("quality"))))
                .collect(Collectors.toList()).toArray(new Item[0]);
        System.out.println(items[1]);

        gildedRose = new GildedRose(items);

    }

    @Then("I should get items updated to:")
    public void iShouldGetItemsUpdatedTo(DataTable itemTable) {
        Item[] updatedItems = itemTable.asMaps().stream()
                .map(row -> new Item(row.get("name"),
                        Integer.parseInt(row.get("sellIn")),
                        Integer.parseInt(row.get("quality"))))
                .collect(Collectors.toList()).toArray(new Item[0]);

        assertArrayEquals(updatedItems, gildedRose.items);
    }
}

