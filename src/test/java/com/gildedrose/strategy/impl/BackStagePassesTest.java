package com.gildedrose.strategy.impl;

import static com.gildedrose.constants.TestConstants.BACKSTAGE_PASSES;
import static com.gildedrose.constants.TestConstants.FIFTEEN_DAYS_TO_SELL;
import static com.gildedrose.constants.TestConstants.QUALITY_OF_EIGHTEEN;
import static com.gildedrose.constants.TestConstants.QUALITY_OF_SIXTEEN;
import static com.gildedrose.constants.TestConstants.TEN_DAYS_TO_SELL;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gildedrose.Item;
import com.gildedrose.adapter.ItemAdapter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BackStagePassesTest {

    @Test
    @DisplayName("Backstage passes quality should increase by 2 if sell-in date is under 10")
    void updateQualityBeforeSellInDateGreaterThan10() {
        Item backstagePassesItem = new Item(BACKSTAGE_PASSES, TEN_DAYS_TO_SELL, QUALITY_OF_SIXTEEN);
        ItemAdapter backstagePassesItemAdapter = new ItemAdapter(backstagePassesItem);
        BackStagePasses backstagePasses = new BackStagePasses();

        backstagePasses.updateQualityBeforeSellInByDate(backstagePassesItemAdapter);

        assertEquals(QUALITY_OF_EIGHTEEN, backstagePassesItemAdapter.getQuality(), "Backstage passes quality should increase by 2");
    }

}
