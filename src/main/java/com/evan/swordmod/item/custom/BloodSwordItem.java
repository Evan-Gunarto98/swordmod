package com.evan.swordmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class BloodSwordItem extends SwordItem {
    public BloodSwordItem(Tier tier, int damage, float atkspeed, Item.Properties propertiesp) {
        super(tier,damage,atkspeed,propertiesp);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof Player) {
            Player player = (Player) attacker;

            // Increase the player's health by 4 health points
            float newHealth = player.getHealth() + 4.0f;
            player.setHealth(Math.min(newHealth, player.getMaxHealth()));
           target.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 200, 1));

            Level level = player.level;
            LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(level);
            if (lightningBolt != null) {
                lightningBolt.moveTo(target.getX(), target.getY(), target.getZ());
                level.addFreshEntity(lightningBolt);
            }

        }
        return super.hurtEnemy(stack, target, attacker);
    }

}
