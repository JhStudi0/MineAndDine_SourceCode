package net.jhstudios.mineanddine.entity.custom;

import net.jhstudios.mineanddine.entity.ModEntities;
import net.jhstudios.mineanddine.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class RockProjectileEntity extends ThrownItemEntity {


    public RockProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public RockProjectileEntity(World world, LivingEntity owner) {
        super(ModEntities.ROCK, owner, world);
    }

    public RockProjectileEntity(World world, double x, double y, double z) {
        super(ModEntities.ROCK, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.ROCK;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if (!this.getWorld().isClient) {
            entityHitResult.getEntity().damage(
                    this.getDamageSources().thrown(this, this.getOwner()),
                    1F
            );
            this.discard();
        }
    }

    // Called when the projectile hits a block or ground
    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.discard(); // remove projectile
        }
    }
}
