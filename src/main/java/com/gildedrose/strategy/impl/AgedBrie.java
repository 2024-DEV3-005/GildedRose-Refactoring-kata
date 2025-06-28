package com.gildedrose.strategy.impl;

import static com.gildedrose.constants.AppConstants.BASE_QUALITY_UNIT;

import com.gildedrose.adapter.ItemAdapter;
import com.gildedrose.strategy.ItemQuality;

public class AgedBrie implements ItemQuality {

    @Override
    public void updateQualityBeforeSellInByDate(ItemAdapter agedBrieItem) {
        agedBrieItem.increaseQuality(BASE_QUALITY_UNIT);
    }

    @Override
    public void decrementSellInDays(ItemAdapter agedBrieItem) {
        agedBrieItem.decrementSellIn();
    }

    @Override
    public void updateQualityAfterSellInByDate(ItemAdapter agedBrieItem) {

    }
}
