package com.gildedrose;

public enum SpecialItem {
    AGED_BRIE ("Aged Brie", (sellIn, quality) -> {
        if(sellIn > 0)
    }),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert", Backstage.class),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    CONJURED_CAKE("Conjured Mana Cake");

    final private String name;

    SpecialItem(String name) {
        this.name = name;
    }

    public static Boolean contains(String name){
        for (SpecialItem specialItem : SpecialItem.values()){
            if (specialItem.name.equals(name)){
                return true;
            }
        }
        return false;
    }
}
