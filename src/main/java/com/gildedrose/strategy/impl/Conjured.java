package com.gildedrose.strategy.impl;

import com.gildedrose.adapter.ItemAdapter;
import com.gildedrose.constants.AppConstants;
import com.gildedrose.strategy.ItemQuality;

public class Conjured implements ItemQuality {

    @Override
    public void updateQualityBeforeSellInByDate(ItemAdapter conjuredItem) {
        if (!conjuredItem.isItemExpired()) {
            conjuredItem.decreaseQuality(AppConstants.DEGRADE_QUALITY_BY_TWO);
        }
    }

    @Override
    public void decrementSellInDays(ItemAdapter conjuredItem) {
        conjuredItem.decrementSellIn();
    }

    @Override
    public void updateQualityAfterSellInByDate(ItemAdapter conjuredItem) {

    }

}
