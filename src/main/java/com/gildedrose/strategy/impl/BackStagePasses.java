package com.gildedrose.strategy.impl;

import static com.gildedrose.constants.AppConstants.BASE_QUALITY_UNIT;
import static com.gildedrose.constants.AppConstants.ELEVEN_DAYS_TO_SELL;
import static com.gildedrose.constants.AppConstants.MIN_QUALITY;
import static com.gildedrose.constants.AppConstants.SIX_DAYS_TO_SELL;
import static com.gildedrose.constants.AppConstants.UPGRADE_QUALITY_BY_THREE;
import static com.gildedrose.constants.AppConstants.UPGRADE_QUALITY_BY_TWO;

import com.gildedrose.adapter.ItemAdapter;
import com.gildedrose.strategy.ItemQuality;

public class BackStagePasses implements ItemQuality {

    @Override
    public void updateQualityBeforeSellInByDate(ItemAdapter backStagePassesItem) {
        backStagePassesItem.increaseQuality(getQualityIncrement(backStagePassesItem.getSellIn()));
    }

    private int getQualityIncrement(int sellInByDays) {
        return isExpiryWithInTenDays(sellInByDays) ? getExtraQualityIncrement(sellInByDays) : BASE_QUALITY_UNIT;
    }

    private boolean isExpiryWithInTenDays(int sellInByDays) {
        return sellInByDays < ELEVEN_DAYS_TO_SELL;
    }

    private int getExtraQualityIncrement(int sellInByDays) {
        return isExpiryWithInFiveDays(sellInByDays) ? UPGRADE_QUALITY_BY_THREE : UPGRADE_QUALITY_BY_TWO;
    }

    private boolean isExpiryWithInFiveDays(int sellInByDays) {
        return sellInByDays < SIX_DAYS_TO_SELL;
    }


    @Override
    public void decrementSellInDays(ItemAdapter backStagePassesItem) {
        backStagePassesItem.decrementSellIn();
    }

    @Override
    public void updateQualityAfterSellInByDate(ItemAdapter backStagePassesItem) {
        if(backStagePassesItem.isItemExpired()) {
            backStagePassesItem.setQuality(MIN_QUALITY);
        }
    }
}
