package com.lagia.firstmod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.sounds.SoundSource;
import com.lagia.firstmod.item.ModSounds;

public class MetalPipeItem extends Item {

    public MetalPipeItem(Properties pProperties) {
        super(pProperties);
    }

    // Rechtsklick in die Luft
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {

            level.playSound(
                    null,
                    player.getX(), player.getY(), player.getZ(),
                    ModSounds.METAL_PIPE_BONK.get(),
                    SoundSource.PLAYERS,
                    1.0F, 1.0F
            );
        }

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    // Rechtsklick auf Block
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();

        if (!level.isClientSide && player != null) {
            level.playSound(
                    null,
                    pos,
                    ModSounds.METAL_PIPE_BONK.get(),
                    SoundSource.PLAYERS,
                    1.0F, 1.0F
            );
        }

        return InteractionResult.SUCCESS;
    }
}