package io.github.yrs22.eatinganimation;

import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.RemotePlayer;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public record EatProgress() implements RangeSelectItemModelProperty {

    public static final MapCodec<EatProgress> MAP_CODEC = MapCodec.unit(new EatProgress());

    @Override
    public float get(ItemStack stack, ClientLevel level, LivingEntity entity, int seed) {
        if (entity == null || entity.getUseItem() != stack) {
            return 0.0F;
        }
        int duration = stack.getUseDuration(entity);
        if (entity instanceof RemotePlayer) {
            float used = entity.getTicksUsingItem();
            return duration > 16 ? (used / duration) % 1.0F : (used / 32.0F) % 0.5F;
        }
        return (duration - entity.getUseItemRemainingTicks()) / 30.0F;
    }

    @Override
    public MapCodec<EatProgress> type() {
        return MAP_CODEC;
    }
}
