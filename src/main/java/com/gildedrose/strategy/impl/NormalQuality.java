package com.gildedrose.strategy.impl;

import static com.gildedrose.constants.AppConstants.AGED_BRIE;
import static com.gildedrose.constants.AppConstants.BACKSTAGE_PASSES;
import static com.gildedrose.constants.AppConstants.BASE_QUALITY_UNIT;
import static com.gildedrose.constants.AppConstants.DAY_OF_EXPIERY;
import static com.gildedrose.constants.AppConstants.MAX_QUALITY;
import static com.gildedrose.constants.AppConstants.MIN_QUALITY;
import static com.gildedrose.constants.AppConstants.QUALITY_OF_ELEVEN;
import static com.gildedrose.constants.AppConstants.QUALITY_OF_SIX;
import static com.gildedrose.constants.AppConstants.SULFURAS;

import com.gildedrose.Item;
import com.gildedrose.strategy.ItemQuality;

public class NormalQuality implements ItemQuality {

    public void updateQualityBeforeSellInByDate(Item item) {
        if (!item.name.equals(AGED_BRIE)
                && !item.name.equals(BACKSTAGE_PASSES)) {
            if (item.quality > MIN_QUALITY && !item.name.equals(SULFURAS)) {
                decreaseQuality(item);
            }
        } else {
            if (item.quality < MAX_QUALITY) {
                increaseQuality(item);

                if (item.name.equals(BACKSTAGE_PASSES)) {
                    if (item.sellIn < QUALITY_OF_ELEVEN && item.quality < MAX_QUALITY) {
                        increaseQuality(item);
                    }

                    if (item.sellIn < QUALITY_OF_SIX && item.quality < MAX_QUALITY) {
                        increaseQuality(item);
                    }
                }
            }
        }
    }

    public void decrementSellInDays(Item item) {
        if (!item.name.equals(SULFURAS)) {
            decrementSellIn(item);
        }
    }

    private void decrementSellIn(Item item) {
        item.sellIn--;
    }

    public void updateQualityAfterSellInByDate(Item item) {
        if (isItemExpired(item)) {
            if (!item.name.equals(AGED_BRIE)) {
                if (!item.name.equals(BACKSTAGE_PASSES)) {
                    if (item.quality > MIN_QUALITY && !item.name.equals(SULFURAS)) {
                        decreaseQuality(item);
                    }
                } else {
                    setQuality(item);
                }
            } else {
                if (item.quality < MAX_QUALITY) {
                    increaseQuality(item);
                }
            }
        }
    }

    private void decreaseQuality(Item item) {
        item.quality = Math.max(0,item.quality - BASE_QUALITY_UNIT);
    }

    private void increaseQuality(Item item) {
        item.quality = Math.min(50,item.quality + BASE_QUALITY_UNIT);
    }

    private boolean isItemExpired(Item item) {
        return item.sellIn < DAY_OF_EXPIERY;
    }

    public void setQuality(Item item) {
        item.quality = Math.max(0, Math.min(50, MIN_QUALITY));
    }
}
