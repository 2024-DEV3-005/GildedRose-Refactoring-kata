package com.gildedrose.strategy.impl;

import static com.gildedrose.constants.AppConstants.BASE_QUALITY_UNIT;

import com.gildedrose.adapter.ItemAdapter;
import com.gildedrose.strategy.ItemQuality;

public class NormalQuality implements ItemQuality {

    public void updateQualityBeforeSellInByDate(ItemAdapter item) {
        item.decreaseQuality(BASE_QUALITY_UNIT);
    }

    public void decrementSellInDays(ItemAdapter item) {
        item.decrementSellIn();
    }

    public void updateQualityAfterSellInByDate(ItemAdapter item) {
        if (item.isItemExpired()) {
            item.decreaseQuality(BASE_QUALITY_UNIT);
        }
    }
}

