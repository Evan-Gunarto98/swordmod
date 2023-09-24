package com.evan.swordmod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class PoisonSwordItem extends SwordItem{
    public PoisonSwordItem(Tier tier, int damage, float atkspeed, Item.Properties propertiesp) {
        super(tier,damage,atkspeed,propertiesp);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof Player) {
            Player player = (Player) attacker;
            target.addEffect(new MobEffectInstance(MobEffects.POISON, 1000, 3));

        }
        return super.hurtEnemy(stack, target, attacker);
    }
}
