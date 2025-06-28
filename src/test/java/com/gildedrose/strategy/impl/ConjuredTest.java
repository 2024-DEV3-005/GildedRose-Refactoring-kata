package com.gildedrose.strategy.impl;

import static com.gildedrose.constants.TestConstants.CONJURED;
import static com.gildedrose.constants.TestConstants.FIVE_DAYS_TO_SELL;
import static com.gildedrose.constants.TestConstants.QUALITY_OF_EIGHTEEN;
import static com.gildedrose.constants.TestConstants.QUALITY_OF_TWENTY;
import static com.gildedrose.constants.TestConstants.TEN_DAYS_TO_SELL;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.Item;
import com.gildedrose.adapter.ItemAdapter;
import com.gildedrose.constants.TestConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConjuredTest {

    private Conjured conjured;

    @BeforeEach
    void setUp() {
        conjured = new Conjured();
    }

    @Test
    @DisplayName("Conjured item quality should degrade by 2 before sell-in date")
    void shouldDecreaseQualityByTwoIfNotExpired() {
        Item conjuredItem = new Item(CONJURED, TEN_DAYS_TO_SELL, QUALITY_OF_TWENTY);
        ItemAdapter conjuredItemAdapter = new ItemAdapter(conjuredItem);

        conjured.updateQualityBeforeSellInByDate(conjuredItemAdapter);

        assertEquals(QUALITY_OF_EIGHTEEN, conjuredItemAdapter.getQuality(), "Conjured item quality should decrease by 2");
    }

    @Test
    @DisplayName("SellIn days should reduce by one for Conjured item")
    void shouldDecreaseSellInDaysByOneForConjured() {
        Item conjuredItem = new Item(CONJURED, FIVE_DAYS_TO_SELL, QUALITY_OF_TWENTY);
        ItemAdapter conjuredItemAdapter = new ItemAdapter(conjuredItem);

        conjured.decrementSellInDays(conjuredItemAdapter);

        assertEquals(TestConstants.FOUR_DAYS_TO_SELL, conjuredItem.sellIn, "SellIn value should reduce by one");
    }

}