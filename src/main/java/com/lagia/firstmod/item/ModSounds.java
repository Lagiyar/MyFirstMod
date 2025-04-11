package com.lagia.firstmod.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.lagia.firstmod.FirstMod;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, FirstMod.MOD_ID);

    public static final RegistryObject<SoundEvent> METAL_PIPE_BONK =
            SOUND_EVENTS.register("item.metal_pipe.bonk",
                    () -> SoundEvent.createVariableRangeEvent(
                            new ResourceLocation(FirstMod.MOD_ID, "item.metal_pipe.bonk")
                    )
            );
}