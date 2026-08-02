package net.jhstudios.mineanddine.entity;

import net.jhstudios.mineanddine.MineAndDine;
import net.jhstudios.mineanddine.entity.custom.RockProjectileEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<RockProjectileEntity> ROCK = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MineAndDine.MOD_ID, "tomahawk"),
            EntityType.Builder.<RockProjectileEntity>create(RockProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 1.15f).build());


    public static void registerModEntities() {
        MineAndDine.LOGGER.info("Registering Mod Entities for " + MineAndDine.MOD_ID);
    }
}
