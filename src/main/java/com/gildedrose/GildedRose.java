package com.gildedrose;

import static com.gildedrose.constants.AppConstants.AGED_BRIE;
import static com.gildedrose.constants.AppConstants.BACKSTAGE_PASSES;
import static com.gildedrose.constants.AppConstants.BASE_QUALITY_UNIT;
import static com.gildedrose.constants.AppConstants.DAY_OF_EXPIERY;
import static com.gildedrose.constants.AppConstants.MAX_QUALITY;
import static com.gildedrose.constants.AppConstants.MIN_QUALITY;
import static com.gildedrose.constants.AppConstants.QUALITY_OF_ELEVEN;
import static com.gildedrose.constants.AppConstants.QUALITY_OF_SIX;
import static com.gildedrose.constants.AppConstants.SULFURAS;

import com.gildedrose.strategy.ItemQuality;
import com.gildedrose.strategy.impl.NormalQuality;

import java.util.List;

class GildedRose {

    List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemQuality qualityStrategy = new NormalQuality();
            qualityStrategy.updateQualityBeforeSellInByDate(item);

            qualityStrategy.decrementSellInDays(item);

            qualityStrategy.updateQualityAfterSellInByDate(item);
        }
    }
}