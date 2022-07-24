package me.niv.ants.colony.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.kotcrab.vis.ui.VisUI;
import me.niv.ants.colony.game.entities.Ant;
import me.niv.ants.colony.game.entities.Town;
import me.niv.ants.colony.model.World;
import me.niv.ants.colony.model.entity.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameHandler {

    private World world;

    private boolean done;

    private VisUI visUi;

    public GameHandler(){
        visUi = new VisUI();
        visUi.load();
        this.world = new World();
        this.done = false;
    }

    public void update(){
        world.update();
        world.render();
    }

    public World getWorld(){
        return this.world;
    }

    public void registerMany(Entity... entities){
        world.registerEntities(entities);
    }

    public void registerManyTowns(List<Town> towns){
        towns.forEach(town -> world.registerTown(town));
    }

    public void registerManyAnts(List<Ant> ants){
        ants.forEach(ant -> world.registerAnt(ant));
    }
}
