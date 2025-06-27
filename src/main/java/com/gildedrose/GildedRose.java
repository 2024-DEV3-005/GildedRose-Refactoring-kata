package com.gildedrose;

import com.gildedrose.adapter.ItemAdapter;
import com.gildedrose.strategy.ItemQuality;
import com.gildedrose.strategy.impl.NormalQuality;

import java.util.List;

class GildedRose {

    List<Item> items;

    public GildedRose(List<Item> items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemQuality qualityStrategy = new NormalQuality();

            ItemAdapter itemAdapter = new ItemAdapter(item);

            qualityStrategy.updateQualityBeforeSellInByDate(itemAdapter);

            qualityStrategy.decrementSellInDays(itemAdapter);

            qualityStrategy.updateQualityAfterSellInByDate(itemAdapter);
        }
    }
}