package com.gildedrose.strategy;

import com.gildedrose.adapter.ItemAdapter;

public interface ItemQuality {

    void updateQualityBeforeSellInByDate(ItemAdapter item);

    void decrementSellInDays(ItemAdapter item);

    void updateQualityAfterSellInByDate(ItemAdapter item);
}
