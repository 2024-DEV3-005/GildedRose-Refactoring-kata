package com.gildedrose.strategy.impl;

import static com.gildedrose.constants.AppConstants.BASE_QUALITY_UNIT;
import static com.gildedrose.constants.AppConstants.ELEVEN_DAYS_TO_SELL;
import static com.gildedrose.constants.AppConstants.MAX_QUALITY;
import static com.gildedrose.constants.AppConstants.QUALITY_OF_ELEVEN;
import static com.gildedrose.constants.AppConstants.QUALITY_OF_SIX;

import com.gildedrose.adapter.ItemAdapter;
import com.gildedrose.strategy.ItemQuality;

public class BackStagePasses implements ItemQuality {
    @Override
    public void updateQualityBeforeSellInByDate(ItemAdapter backStagePassesItem) {
        backStagePassesItem.increaseQuality(1);
        if (backStagePassesItem.getSellIn() < ELEVEN_DAYS_TO_SELL) {
            backStagePassesItem.increaseQuality(BASE_QUALITY_UNIT);
        }
    }

    @Override
    public void decrementSellInDays(ItemAdapter backStagePassesItem) {

    }

    @Override
    public void updateQualityAfterSellInByDate(ItemAdapter backStagePassesItem) {

    }
}
