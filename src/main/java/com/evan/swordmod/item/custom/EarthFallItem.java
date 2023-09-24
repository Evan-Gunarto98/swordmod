package com.evan.swordmod.item.custom;

import com.evan.swordmod.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.moddiscovery.MinecraftLocator;
import org.checkerframework.checker.signature.qual.Identifier;

public class EarthFallItem extends SwordItem {
    public EarthFallItem(Tier tier, int damage, float atkspeed, Properties propertiesp) {
        super(tier,damage,atkspeed,propertiesp);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand){
        if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND){
            shoot(player,level);
            player.getCooldowns().addCooldown(this,10);
        }
        return super.use(level,player,hand);
    }

    private void shoot(Player player,Level level){
        Vec3 lookVec = player.getLookAngle();
        double x = player.getX() + lookVec.x * 5;
        double y = player.getEyeY() + lookVec.y * 5;
        double z = player.getZ() + lookVec.z * 5;

        // create and spawn the fireball entity
        StoneArrow arrow = new StoneArrow(ModItems.STONE_ARROW.get(), player, player.level);
//        EntityType<StoneArrow> stoneArrowEntityType = (EntityType<StoneArrow>) Registry.ENTITY_TYPE.get(new ResourceLocation("MODID","stone_arrow"));
//       StoneArrow fireball = new StoneArrow(arrow, x - player.getX(), y - player.getEyeY(), z - player.getZ(),level );
        arrow.setPos(player.getX() + lookVec.x , player.getEyeY() + lookVec.y , player.getZ() + lookVec.z );
        arrow.setDeltaMovement(lookVec.x * 3, lookVec.y * 3, lookVec.z * 3);
        level.addFreshEntity(arrow);


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
