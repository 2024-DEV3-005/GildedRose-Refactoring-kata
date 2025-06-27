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
        items.stream().forEach(item -> createStrategyAndUpdateQuality(item));
    }

    private void createStrategyAndUpdateQuality(Item item) {
        updateQualityWithStrategy(createStrategyForItems(item), item);
    }

    private void updateQualityWithStrategy(ItemQuality strategy, Item item) {
        ItemAdapter itemAdapter = new ItemAdapter(item);
        updateQualityOfItem(strategy, itemAdapter);
    }


    private void updateQualityOfItem(ItemQuality strategy, ItemAdapter itemAdapter) {
        strategy.updateQualityBeforeSellInByDate(itemAdapter);
        strategy.decrementSellInDays(itemAdapter);
        strategy.updateQualityAfterSellInByDate(itemAdapter);
    }

    private ItemQuality createStrategyForItems(Item item) {
        return new NormalQuality();
    }
}