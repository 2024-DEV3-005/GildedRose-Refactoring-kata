package com.gildedrose.strategy.impl;

import static com.gildedrose.constants.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.Item;
import com.gildedrose.adapter.ItemAdapter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AgedBrieTest {

    @Test
    @DisplayName("Aged Brie quality should increase by 1 before sell-in date")
    void shouldIncreaseQualityByOneBeforeSellIn() {
        Item agedBrieItem = new Item(AGED_BRIE, TEN_DAYS_TO_SELL, QUALITY_OF_TWENTY);
        ItemAdapter agedBrieItemAdapter = new ItemAdapter(agedBrieItem);
        AgedBrie agedBrie = new AgedBrie();

        agedBrie.updateQualityBeforeSellInByDate(agedBrieItemAdapter);

        assertEquals(QUALITY_OF_TWENTY_ONE, agedBrieItemAdapter.getQuality(), "Aged Brie quality should increase by 1");
    }

}
