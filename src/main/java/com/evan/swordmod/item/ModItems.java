package com.evan.swordmod.item;

import com.evan.swordmod.SwordMod;
import com.evan.swordmod.item.custom.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SwordMod.MODID);


        public static DeferredRegister<EntityType<?>> ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SwordMod.MODID);

    public static final RegistryObject<EntityType<StoneArrow>> STONE_ARROW = ENTITY_TYPE.register("stone_arrow",
            () -> EntityType.Builder.of((EntityType.EntityFactory<StoneArrow>) StoneArrow::new,
                    MobCategory.MISC).sized(1F, 1F).build("stone_arrow"));

    public static final RegistryObject<Item> ALPHA_SWORD = ITEMS.register("alpha_sword",
            () -> new SwordItem(Tiers.DIAMOND,10,5.0f,
                    new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1)));


    public static final RegistryObject<Item> BLOOD_SWORD = ITEMS.register("blood_sword",
            () -> new BloodSwordItem(Tiers.DIAMOND,1,3.0f,
                    new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1)));


    public static final RegistryObject<Item> POISON_SWORD = ITEMS.register("poison_sword",
            () -> new PoisonSwordItem(Tiers.DIAMOND,1,7.0f,
                    new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1)));

    public static final RegistryObject<Item> FALLEN_GRACE = ITEMS.register("fallen_grace",
            () -> new FallenGraceItem(Tiers.DIAMOND,1,7.0f,
                    new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1)));

    public static final RegistryObject<Item> BLAZE_WRATH = ITEMS.register("blaze_wrath",
            () -> new BlazeWrathItem(Tiers.DIAMOND,1,7.0f,
                    new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1)));


    public static final RegistryObject<Item> GHAST_WRATH = ITEMS.register("ghast_wrath",
            () -> new GhastWrathItem(Tiers.DIAMOND,1,7.0f,
                    new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1)));


    public static final RegistryObject<Item> DRAGON_WRATH = ITEMS.register("dragon_wrath",
            () -> new DragonWrathItem(Tiers.DIAMOND,1,7.0f,
                    new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1)));

    public static final RegistryObject<Item> EARTH_FALL = ITEMS.register("earth_fall",
            () -> new EarthFallItem(Tiers.DIAMOND,1,7.0f,
                    new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1)));

    public static final RegistryObject<Item> WINTER_TEARS = ITEMS.register("winter_tears",
            () -> new WinterTearsItem(Tiers.DIAMOND,1,9.0f,
                    new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1)));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
