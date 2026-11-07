package io.github.yrs22.eatinganimation;

import io.github.yrs22.eatinganimation.mixin.RangeSelectItemModelPropertiesAccessor;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.resources.Identifier;

public class EatingAnimationClient implements ClientModInitializer {

    public static final String MOD_ID = "eating_animation_continued";

    @Override
    public void onInitializeClient() {
        RangeSelectItemModelPropertiesAccessor.getIdMapper()
                .put(Identifier.fromNamespaceAndPath(MOD_ID, "eat"), EatProgress.MAP_CODEC);
    }
}
