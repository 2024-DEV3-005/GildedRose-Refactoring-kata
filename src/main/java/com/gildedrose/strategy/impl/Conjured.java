package com.gildedrose.strategy.impl;

import static com.gildedrose.constants.AppConstants.DEGRADE_QUALITY_BY_TWO;

import com.gildedrose.adapter.ItemAdapter;
import com.gildedrose.strategy.ItemQuality;

public class Conjured implements ItemQuality {

    @Override
    public void updateQualityBeforeSellInByDate(ItemAdapter conjuredItem) {
        conjuredItem.decreaseQuality(DEGRADE_QUALITY_BY_TWO);
    }

    @Override
    public void decrementSellInDays(ItemAdapter conjuredItem) {
        conjuredItem.decrementSellIn();
    }

    @Override
    public void updateQualityAfterSellInByDate(ItemAdapter conjuredItem) {
        if (conjuredItem.isItemExpired()) {
            conjuredItem.decreaseQuality(DEGRADE_QUALITY_BY_TWO);
        }
    }
}
