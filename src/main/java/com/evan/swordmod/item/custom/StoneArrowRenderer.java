package com.evan.swordmod.item.custom;

import com.evan.swordmod.SwordMod;
import com.evan.swordmod.item.ModItems;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.ItemModelShaper;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class StoneArrowRenderer extends ArrowRenderer<StoneArrow> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(SwordMod.MODID, "textures/item/cobblestone.png");

    public StoneArrowRenderer(EntityRendererProvider.Context manager) {
        super(manager);

    }

    public ResourceLocation getTextureLocation(StoneArrow arrow) {
        return TEXTURE;
    }


}
