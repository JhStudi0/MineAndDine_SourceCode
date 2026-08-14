package net.jhstudios.mineanddine.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.jhstudios.mineanddine.MineAndDine;
import net.jhstudios.mineanddine.screen.custom.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<CookingPotScreenHandler> COOKING_POT_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MineAndDine.MOD_ID, "cooking_pot_screen_handler"),
            new ExtendedScreenHandlerType<>(CookingPotScreenHandler::new, BlockPos.PACKET_CODEC));

    public static final ScreenHandlerType<CornGrinderScreenHandler> CORN_GRINDER_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MineAndDine.MOD_ID, "corn_grinder_screen_handler"),
            new ExtendedScreenHandlerType<>(CornGrinderScreenHandler::new, BlockPos.PACKET_CODEC));

    public static final ScreenHandlerType<PanScreenHandler> PAN_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MineAndDine.MOD_ID, "pan_screen_handler"),
            new ExtendedScreenHandlerType<>(PanScreenHandler::new, BlockPos.PACKET_CODEC));

    public static final ScreenHandlerType<MixerScreenHandler> MIXER_SCREEN_HANLDER = Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MineAndDine.MOD_ID, "mixer_screen_handler"),
            new ExtendedScreenHandlerType<>(MixerScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers(){
        MineAndDine.LOGGER.info("Registering Screen Handlers for " + MineAndDine.MOD_ID);
    }
}
