package me.niv.ants.colony.model.entity;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import me.niv.ants.colony.model.Location;
import me.niv.ants.colony.model.World;

public abstract class Entity implements IEntity{

    Location location;
    World world;

    public Entity(World world, Location location){
        this.world = world;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void updateLocation(double x, double y){
        this.location.setX(x);
        this.location.setY(y);
    }

    public World getWorld() {
        return world;
    }

    @Override
    public abstract void render(ShapeRenderer shapeRenderer);
}
