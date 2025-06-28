package com.gildedrose.strategy.impl;

import com.gildedrose.adapter.ItemAdapter;
import com.gildedrose.strategy.ItemQuality;

public class Sulfuras implements ItemQuality {
    @Override
    public void updateQualityBeforeSellInByDate(ItemAdapter item) {

    }

    @Override
    public void decrementSellInDays(ItemAdapter item) {

    }

    @Override
    public void updateQualityAfterSellInByDate(ItemAdapter item) {

    }
}
