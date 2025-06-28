package com.gildedrose.strategy.impl;

import static com.gildedrose.constants.TestConstants.BACKSTAGE_PASSES;
import static com.gildedrose.constants.TestConstants.FIVE_DAYS_TO_SELL;
import static com.gildedrose.constants.TestConstants.QUALITY_OF_EIGHTEEN;
import static com.gildedrose.constants.TestConstants.QUALITY_OF_SIXTEEN;
import static com.gildedrose.constants.TestConstants.QUALITY_OF_TWENTY_ONE;
import static com.gildedrose.constants.TestConstants.TEN_DAYS_TO_SELL;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.Item;
import com.gildedrose.adapter.ItemAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BackStagePassesTest {

    private BackStagePasses backstagePasses;

    @BeforeEach
    void setUp() {
        backstagePasses = new BackStagePasses();
    }


    @Test
    @DisplayName("Backstage passes quality should increase by 2 if sell-in date is under 10")
    void updateQualityBeforeSellInDateGreaterThan10() {
        Item backstagePassesItem = new Item(BACKSTAGE_PASSES, TEN_DAYS_TO_SELL, QUALITY_OF_SIXTEEN);
        ItemAdapter backstagePassesItemAdapter = new ItemAdapter(backstagePassesItem);

        backstagePasses.updateQualityBeforeSellInByDate(backstagePassesItemAdapter);

        assertEquals(QUALITY_OF_EIGHTEEN, backstagePassesItemAdapter.getQuality(), "Backstage passes quality should increase by 2");
    }

    @Test
    @DisplayName("Backstage passes quality should increase by 3 if sell-in date is under 5")
    void shouldIncreaseQualityByThreeWhenSellInIsLessThan6() {
        Item backstagePassesItem = new Item(BACKSTAGE_PASSES, FIVE_DAYS_TO_SELL, QUALITY_OF_EIGHTEEN);
        ItemAdapter backstagePassesItemAdapter = new ItemAdapter(backstagePassesItem);

        backstagePasses.updateQualityBeforeSellInByDate(backstagePassesItemAdapter);

        assertEquals(QUALITY_OF_TWENTY_ONE, backstagePassesItemAdapter.getQuality(), "Backstage passes quality should increase by 3");
    }

}
