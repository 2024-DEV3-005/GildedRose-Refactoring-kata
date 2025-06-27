package com.gildedrose.adapter;

import static com.gildedrose.constants.AppConstants.DAY_OF_EXPIERY;
import static com.gildedrose.constants.AppConstants.MAX_QUALITY;
import static com.gildedrose.constants.AppConstants.MIN_QUALITY;

import com.gildedrose.Item;

public class ItemAdapter {

    private final Item item;

    public ItemAdapter(Item item) {
        this.item = item;
    }

    public String getName() {
        return item.name;
    }

    public int getSellIn() {
        return item.sellIn;
    }

    public int getQuality() {
        return item.quality;
    }

    public void setQuality(int newQuality) {
        item.quality = Math.max(MIN_QUALITY, Math.min(MAX_QUALITY, newQuality));
    }

    public void increaseQuality(int qualityUnit) {
        item.quality = Math.min(MAX_QUALITY, item.quality + qualityUnit);
    }

    public void decreaseQuality(int qualityUnit) {
        item.quality = Math.max(MIN_QUALITY, item.quality - qualityUnit);
    }

    public void decrementSellIn() {
        item.sellIn--;
    }

    public boolean isItemExpired() {
        return item.sellIn < DAY_OF_EXPIERY;
    }

    public Item getItem() {
        return item;
    }
}
