package com.gildedrose.strategy;

import com.gildedrose.Item;

public interface ItemQuality {

    void updateQualityBeforeSellInByDate(Item item);

    void decrementSellInDays(Item item);

    void updateQualityAfterSellInByDate(Item item);
}
