package me.niv.ants.colony.game.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import me.niv.ants.colony.model.Location;
import me.niv.ants.colony.model.World;
import me.niv.ants.colony.model.entity.Entity;

public class Town extends Entity {

    public Town(World world, Location location){
        super(world, location);
    }

    @Override
    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.circle((float) getLocation().getX(), (float) getLocation().getY(), 15f);
        shapeRenderer.end();
    }

}
