package me.niv.ants.colony.model.entity;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import me.niv.ants.colony.model.Location;
import me.niv.ants.colony.model.World;

public abstract class LivingEntity extends Entity implements ILivingEntity{

    public LivingEntity(World world, Location location){
        super(world, location);
    }

    @Override
    public abstract void tick();

    @Override
    public abstract void render(ShapeRenderer shapeRenderer);
}
