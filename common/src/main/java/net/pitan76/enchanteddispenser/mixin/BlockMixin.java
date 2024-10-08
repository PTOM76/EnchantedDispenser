package net.pitan76.enchanteddispenser.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pitan76.enchanteddispenser.mixinimpl.BlockMixinImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public abstract class BlockMixin {
    @Inject(method = "onPlaced", at = @At("TAIL"))
    private void enchanteddispenser$onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack, CallbackInfo ci) {
        if (state.getBlock() instanceof DispenserBlock)
            BlockMixinImpl.onPlaced(world, pos, state, placer, itemStack, ci);
    }
}
