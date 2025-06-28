package com.gildedrose.strategy.impl;

import static com.gildedrose.constants.AppConstants.BACKSTAGE_PASSES;
import static com.gildedrose.constants.AppConstants.BASE_QUALITY_UNIT;
import static com.gildedrose.constants.AppConstants.MAX_QUALITY;
import static com.gildedrose.constants.AppConstants.MIN_QUALITY;
import static com.gildedrose.constants.AppConstants.QUALITY_OF_ELEVEN;
import static com.gildedrose.constants.AppConstants.QUALITY_OF_SIX;

import com.gildedrose.adapter.ItemAdapter;
import com.gildedrose.strategy.ItemQuality;

public class NormalQuality implements ItemQuality {

    public void updateQualityBeforeSellInByDate(ItemAdapter item) {
        if (!item.getName().equals(BACKSTAGE_PASSES)) {
            if (item.getQuality() > MIN_QUALITY) {
                item.decreaseQuality(BASE_QUALITY_UNIT);
            }
        } else {
            if (item.getQuality() < MAX_QUALITY) {
                item.increaseQuality(BASE_QUALITY_UNIT);

                if (item.getName().equals(BACKSTAGE_PASSES)) {
                    if (item.getSellIn() < QUALITY_OF_ELEVEN && item.getQuality() < MAX_QUALITY) {
                        item.increaseQuality(BASE_QUALITY_UNIT);
                    }

                    if (item.getSellIn() < QUALITY_OF_SIX && item.getQuality() < MAX_QUALITY) {
                        item.increaseQuality(BASE_QUALITY_UNIT);
                    }
                }
            }
        }
    }

    public void decrementSellInDays(ItemAdapter item) {
        item.decrementSellIn();
    }

    public void updateQualityAfterSellInByDate(ItemAdapter item) {
        if (item.isItemExpired()) {
            if (!item.getName().equals(BACKSTAGE_PASSES)) {
                if (item.getQuality() > MIN_QUALITY) {
                    item.decreaseQuality(BASE_QUALITY_UNIT);
                }
            } else {
                item.setQuality(MIN_QUALITY);
            }
        }
    }
}

