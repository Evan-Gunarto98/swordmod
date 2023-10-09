package com.evan.swordmod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class WinterTearsItem extends SwordItem {

    public WinterTearsItem(Tier tier, int damage, float atkspeed, Item.Properties propertiesp) {
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

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        BlockPos playerPos = player.blockPosition();
        player.getCooldowns().addCooldown(this,20);

//        // Get the player's rotation
//        float rotationYaw = player.getYRot();
//        float rotationPitch = player.getXRot();
//
//        // Calculate the direction the player is facing
//        double directionX = -Math.sin(Math.toRadians(rotationYaw));
//        double directionZ = Math.cos(Math.toRadians(rotationYaw));
//
//        // Spawn ice only in the direction the player is facing
//
//

        Vec3 lookVec = player.getLookAngle();
        double x = player.getX() + lookVec.x * 5;
        double y = player.getEyeY() + lookVec.y * 5;
        double z = player.getZ() + lookVec.z * 5;
        double eyeHeight = player.getEyeHeight();
        BlockPos spawnPos = new BlockPos(player.getX() + lookVec.x * 3, player.getEyeY() + lookVec.y * 3 , player.getZ() + lookVec.z * 3);

        // Iterate over a 3x3 area around the player
        for (int xOffset = -1; xOffset <= 1; xOffset++) {
            for (int yOffset = -1; yOffset <= 1; yOffset++) {
                for(int zOffset = -1; zOffset <=1; zOffset++){
                    BlockPos blockPos = spawnPos.offset(xOffset, zOffset, yOffset);

                    // Check if the block can be replaced (air or a replaceable block)
                    if (world.isEmptyBlock(blockPos) || world.getBlockState(blockPos).getMaterial().isReplaceable()) {
                        // Set the block to ice
                        world.setBlockAndUpdate(blockPos, Blocks.ICE.defaultBlockState());
                    }
                }

            }
        }

//        if (world instanceof ServerLevel serverWorld) {
//            serverWorld.getBlockTicks().hasScheduledTick(spawnPos, Blocks.AIR);
//        }
        // Schedule a block update event to remove the ice blocks after 5 seconds (100 ticks per second)


        return InteractionResultHolder.success(itemstack);
    }




}
