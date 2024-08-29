package net.pitan76.enchanteddispenser.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.DispenserBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(DispenserBlock.class)
public abstract class DispenserBlockMixin extends BlockWithEntity {

    public DispenserBlockMixin(Settings settings) {
        super(settings);
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        super.onStateReplaced(state, world, pos, newState, moved);
    }
}
