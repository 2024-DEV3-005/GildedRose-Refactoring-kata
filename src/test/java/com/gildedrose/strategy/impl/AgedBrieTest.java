package com.gildedrose.strategy.impl;

import static com.gildedrose.constants.TestConstants.AGED_BRIE;
import static com.gildedrose.constants.TestConstants.FIVE_DAYS_TO_SELL;
import static com.gildedrose.constants.TestConstants.FOUR_DAYS_TO_SELL;
import static com.gildedrose.constants.TestConstants.QUALITY_OF_TWENTY;
import static com.gildedrose.constants.TestConstants.QUALITY_OF_TWENTY_ONE;
import static com.gildedrose.constants.TestConstants.TEN_DAYS_TO_SELL;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.Item;
import com.gildedrose.adapter.ItemAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AgedBrieTest {

    private AgedBrie agedBrie;

    @BeforeEach
    void setUp() {
        agedBrie = new AgedBrie();
    }

    @Test
    @DisplayName("Aged Brie quality should increase by 1 before sell-in date")
    void shouldIncreaseQualityByOneBeforeSellIn() {
        Item agedBrieItem = new Item(AGED_BRIE, TEN_DAYS_TO_SELL, QUALITY_OF_TWENTY);
        ItemAdapter agedBrieItemAdapter = new ItemAdapter(agedBrieItem);

        agedBrie.updateQualityBeforeSellInByDate(agedBrieItemAdapter);

        assertEquals(QUALITY_OF_TWENTY_ONE, agedBrieItemAdapter.getQuality(), "Aged Brie quality should increase by 1");
    }

    @Test
    @DisplayName("SellIn value reduces by one for Aged Brie item")
    void shouldDecreaseSellInDaysForAgedBrie() {
        Item agedBrieItem = new Item(AGED_BRIE, FIVE_DAYS_TO_SELL, QUALITY_OF_TWENTY);
        ItemAdapter agedBrieItemAdapter = new ItemAdapter(agedBrieItem);

        agedBrie.decrementSellInDays(agedBrieItemAdapter);

        assertEquals(FOUR_DAYS_TO_SELL, agedBrieItem.sellIn, "SellIn value should reduce by one");
    }

}
