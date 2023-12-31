package com.evan.swordmod.item.custom;

import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.NetworkHooks;


public class StoneArrow extends AbstractArrow {
    public StoneArrow(EntityType<StoneArrow> entityType, Level world) {
        super(entityType, world);
    }


    public StoneArrow(EntityType<StoneArrow> entityType, double x, double y, double z, Level world) {
        super(entityType, x, y, z, world);
    }

    public StoneArrow(EntityType<StoneArrow> entityType, LivingEntity shooter, Level world) {
        super(entityType, shooter, world);
    }

//
//    @Override
//    protected void onHitEntity(EntityHitResult ray) {
//        super.onHitEntity(ray);
//        // this, x, y, z, explosionStrength, setsFires, breakMode
//
//    }
    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void tickDespawn() {
        if (this.inGroundTime > 60){

            this.discard();
        }
    }

    @Override
    protected ItemStack
    getPickupItem() {
        return ItemStack.EMPTY.EMPTY;
    }
}
