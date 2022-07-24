package me.niv.ants.colony.model;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.ScreenUtils;
import me.niv.ants.colony.game.UI.Window;
import me.niv.ants.colony.game.entities.Ant;
import me.niv.ants.colony.game.entities.Town;
import me.niv.ants.colony.game.handler.TracesHandler;
import me.niv.ants.colony.model.entity.Entity;
import me.niv.ants.colony.model.entity.LivingEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class World {

    private ShapeRenderer renderer;

    private List<Entity> entities;
    private List<Town> towns;
    private List<Ant> ants;

    private TracesHandler tracesHandler;

    public World(){
        this.tracesHandler = new TracesHandler();
        entities = new ArrayList<>();
        towns = new ArrayList<>();
        ants = new ArrayList<>();
        this.renderer = new ShapeRenderer();
        Window window = new Window();
    }

    public void render(){
        ScreenUtils.clear(0.2f, 0.25f, 0.3f, 1);
        tracesHandler.drawTraces(renderer);
        entities.stream().filter(entity -> entity.getClass() == Town.class).forEach(entity -> entity.render(renderer));
        entities.stream().filter(entity -> entity.getClass() == Ant.class).forEach(entity -> entity.render(renderer));
    }

    public void update(){
        ants.stream().forEach(ant -> ant.tick());
    }

    public List<? extends Entity> getEntities() {
        return entities;
    }

    public List<Ant> getAnts() {
        return ants;
    }

    public List<Town> getTowns() {
        return towns;
    }

    public void registerTown(Town town){
        if(!towns.contains(town)) towns.add(town);
        registerEntity(town);
    }

    public void registerAnt(Ant ant){
        if(!ants.contains(ant)) ants.add(ant);
        registerEntity(ant);
    }

    public void registerEntities(Entity... entities){
        Arrays.stream(entities).forEach(entity -> this.registerEntity(entity));
    }

    public void removeEntity(Entity entity){
        if(entity instanceof Ant && ants.contains(entity)) ants.remove(entity);
        if(entity instanceof Town && towns.contains(entity)) towns.remove(entity);
        if(entities.contains(entity)) entities.remove(entity);
    }

    public void registerEntity(Entity entity){
        if(entity instanceof Ant && !ants.contains(entity)) ants.add((Ant) entity);
        if(entity instanceof Town && !towns.contains(entity)) towns.add((Town) entity);
        if(!entities.contains(entity)) entities.add(entity);
    }

    public TracesHandler getTracesHandler(){
        return this.tracesHandler;
    }

}
