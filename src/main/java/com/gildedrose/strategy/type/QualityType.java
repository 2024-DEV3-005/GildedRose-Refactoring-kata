package com.gildedrose.strategy.type;

import static com.gildedrose.constants.AppConstants.AGED_BRIE;
import static com.gildedrose.constants.AppConstants.CONJURED_QUALITY;
import static com.gildedrose.constants.AppConstants.NORMAL_QUALITY;
import static com.gildedrose.constants.AppConstants.SULFURAS;

import com.gildedrose.strategy.ItemQuality;
import com.gildedrose.strategy.impl.AgedBrie;
import com.gildedrose.strategy.impl.Conjured;
import com.gildedrose.strategy.impl.NormalQuality;
import com.gildedrose.strategy.impl.Sulfuras;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum QualityType {

    CONJURED(CONJURED_QUALITY) {
        @Override
        public ItemQuality createStrategy() {
            return new Conjured();
        }
    },
    NORMAL(NORMAL_QUALITY) {
        @Override
        public ItemQuality createStrategy() {
            return new NormalQuality();
        }
    },
    AGEDBRIE(AGED_BRIE) {
        @Override
        public ItemQuality createStrategy() { return new AgedBrie(); }
    },
    SULFURAS_LEGEND(SULFURAS) {;
        @Override
        public ItemQuality createStrategy() { return new Sulfuras(); }
    };

    private static final Map<String, ItemQuality> behaviourMap = Stream.of(values()).
            collect(Collectors.toUnmodifiableMap(itemType -> itemType.getQualityTypeName().toLowerCase(),
                    QualityType::createStrategy));

    private final String qualityTypeName;

    QualityType(String qualityTypeName) {
        this.qualityTypeName = qualityTypeName;
    }

    public String getQualityTypeName() {
        return qualityTypeName;
    }

    public abstract ItemQuality createStrategy();

    public static ItemQuality getStrategy(String itemTypeName) {
        return behaviourMap.getOrDefault(itemTypeName.toLowerCase(), NORMAL.createStrategy());
    }

}
