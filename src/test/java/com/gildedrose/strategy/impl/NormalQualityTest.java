package com.gildedrose.strategy.impl;

import static com.gildedrose.constants.TestConstants.EXPIRED_BY_ONE_DAY;
import static com.gildedrose.constants.TestConstants.FIVE_DAYS_TO_SELL;
import static com.gildedrose.constants.TestConstants.FOUR_DAYS_TO_SELL;
import static com.gildedrose.constants.TestConstants.ITEM_NAME_FOO;
import static com.gildedrose.constants.TestConstants.QUALITY_OF_EIGHTEEN;
import static com.gildedrose.constants.TestConstants.QUALITY_OF_SIXTEEN;
import static com.gildedrose.constants.TestConstants.QUALITY_OF_TWENTY;
import static com.gildedrose.constants.TestConstants.QUALITY_OF_TWENTY_ONE;
import static com.gildedrose.constants.TestConstants.TEN_DAYS_TO_SELL;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.Item;
import com.gildedrose.adapter.ItemAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NormalQualityTest {

    NormalQuality normalQuality;

    @BeforeEach
    void setUp() {
        normalQuality = new NormalQuality();
    }

    @Test
    @DisplayName("Normal item quality should degrade by 1 before sell-in date")
    void shouldDecreaseQualityByOneIfNotExpired() {
        Item normalItem = new Item(ITEM_NAME_FOO, TEN_DAYS_TO_SELL, QUALITY_OF_TWENTY_ONE);
        ItemAdapter itemAdapter = new ItemAdapter(normalItem);

        normalQuality.updateQualityBeforeSellInByDate(itemAdapter);

        assertEquals(QUALITY_OF_TWENTY, itemAdapter.getQuality(), "Normal item quality should decrease by 1");
    }

    @Test
    @DisplayName("SellIn days should reduce by 1 for normal item")
    void shouldDecreaseSellInDaysByOneForNormal() {
        Item normalItem = new Item(ITEM_NAME_FOO, FIVE_DAYS_TO_SELL, QUALITY_OF_TWENTY);
        ItemAdapter itemAdapter = new ItemAdapter(normalItem);

        normalQuality.decrementSellInDays(itemAdapter);

        assertEquals(FOUR_DAYS_TO_SELL, itemAdapter.getSellIn(), "SellIn value should reduce by 1");
    }

    @Test
    @DisplayName("Normal item quality should degrade by 2 after sell-in date")
    void shouldDecreaseQualityByOneIfExpired() {
        Item normalItem = new Item(ITEM_NAME_FOO, EXPIRED_BY_ONE_DAY, QUALITY_OF_EIGHTEEN);
        ItemAdapter itemAdapter = new ItemAdapter(normalItem);

        normalQuality.updateQualityBeforeSellInByDate(itemAdapter);
        normalQuality.updateQualityAfterSellInByDate(itemAdapter);

        assertEquals(QUALITY_OF_SIXTEEN, itemAdapter.getQuality(), "Normal item quality should decrease by 2 after sell-in date");
    }
}