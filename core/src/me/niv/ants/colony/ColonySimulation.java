package me.niv.ants.colony;

import com.badlogic.gdx.ApplicationAdapter;
import me.niv.ants.colony.game.GameHandler;
import me.niv.ants.colony.game.entities.Ant;
import me.niv.ants.colony.game.entities.Town;
import me.niv.ants.colony.game.generator.AntGenerator;
import me.niv.ants.colony.game.generator.TownGenerator;
import me.niv.ants.colony.model.Location;
import me.niv.ants.colony.model.World;
import me.niv.ants.colony.model.entity.Entity;

public class ColonySimulation extends ApplicationAdapter {


    GameHandler gameHandler;

    private World world;

    @Override
    public void create () {
        gameHandler = new GameHandler();
        world = gameHandler.getWorld();

        TownGenerator townGenerator = new TownGenerator(world).withTowns(20).withMinimumDistance(200);
        gameHandler.registerManyTowns(townGenerator.generate());

        AntGenerator antGenerator = new AntGenerator(world).withAnts(30);
        gameHandler.registerManyAnts(antGenerator.generate());
    }

    @Override
    public void render () {
        gameHandler.update();
    }

    @Override
    public void dispose () {
    }

}

