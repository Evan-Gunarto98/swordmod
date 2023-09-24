package com.evan.swordmod.item.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class FallenGraceItem extends SwordItem{
    public FallenGraceItem(Tier tier, int damage, float atkspeed, Properties propertiesp) {
        super(tier,damage,atkspeed,propertiesp);
    }

    int multiplier = 1;
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if (attacker instanceof Player) {
            Player player = (Player) attacker;
            if(multiplier<=4){
                multiplier++;
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000, multiplier));
            }
            if(!player.hasEffect(MobEffects.MOVEMENT_SPEED)){
                multiplier = 1;
            }

        }
        return super.hurtEnemy(stack, target, attacker);
    }
}
