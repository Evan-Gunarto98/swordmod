package com.evan.swordmod.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class GhastWrathItem extends SwordItem {
    public GhastWrathItem(Tier tier, int damage, float atkspeed, Properties propertiesp) {
        super(tier,damage,atkspeed,propertiesp);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand){
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){
            shoot(player,level);
            player.getCooldowns().addCooldown(this,20);
        }
        return super.use(level,player,hand);
    }

    private void shoot(Player player,Level level){
        Vec3 lookVec = player.getLookAngle();
        double x = player.getX()  + lookVec.x * 5;
        double y = player.getEyeY()  + lookVec.y * 5;
        double z = player.getZ()  + lookVec.z * 5;

        // create and spawn the fireball entity
       LargeFireball fireball = new LargeFireball(level, player, x - player.getX(), y - player.getEyeY(), z - player.getZ(),1);
        fireball.setPos(player.getX() + lookVec.x * 2, player.getEyeY() + lookVec.y * 2, player.getZ() + lookVec.z * 2);
        level.addFreshEntity(fireball);


    }



    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof Player) {
//            Player player = (Player) attacker;
//
//            // Increase the player's health by 4 health points
//            float newHealth = player.getHealth() + 4.0f;
//            player.setHealth(Math.min(newHealth, player.getMaxHealth()));
//           target.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 200, 1));
//
//            Level level = player.level;
//            LightningBolt lightningBolt = EntityType.LIGHTNING_BOLT.create(level);
//            if (lightningBolt != null) {
//                lightningBolt.moveTo(target.getX(), target.getY(), target.getZ());
//                level.addFreshEntity(lightningBolt);
//            }

        }
        return super.hurtEnemy(stack, target, attacker);
    }

}
