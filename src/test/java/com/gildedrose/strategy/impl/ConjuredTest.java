package com.gildedrose.strategy.impl;

import static com.gildedrose.constants.TestConstants.CONJURED;
import static com.gildedrose.constants.TestConstants.QUALITY_OF_EIGHTEEN;
import static com.gildedrose.constants.TestConstants.QUALITY_OF_TWENTY;
import static com.gildedrose.constants.TestConstants.TEN_DAYS_TO_SELL;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.Item;
import com.gildedrose.adapter.ItemAdapter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConjuredTest {

    private Conjured conjured;

    @Test
    @DisplayName("Conjured item quality should degrade by 2 before sell-in date")
    void shouldDecreaseQualityByTwoIfNotExpired() {
        Item conjuredItem = new Item(CONJURED, TEN_DAYS_TO_SELL, QUALITY_OF_TWENTY);
        ItemAdapter conjuredItemAdapter = new ItemAdapter(conjuredItem);
        conjured = new Conjured();

        conjured.updateQualityBeforeSellInByDate(conjuredItemAdapter);

        assertEquals(QUALITY_OF_EIGHTEEN, conjuredItemAdapter.getQuality(), "Conjured item quality should decrease by 2");
    }

}