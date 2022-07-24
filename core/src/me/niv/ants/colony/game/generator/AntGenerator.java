package me.niv.ants.colony.game.generator;

import me.niv.ants.colony.game.entities.Ant;
import me.niv.ants.colony.game.entities.Town;
import me.niv.ants.colony.model.Location;
import me.niv.ants.colony.model.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AntGenerator {

    private int count;

    private Random random;
    private World world;

    private int id;

    public AntGenerator(World world){
        this.world = world;
        random = new Random();
        this.count = 20;
    }

    public AntGenerator withAnts(Integer count){
        this.count = count;
        return this;
    }

    public List<Ant> generate(){
        List<Ant> ants = new ArrayList<>();

        List<Town> towns = world.getTowns();
        for (int i = 0; i < count; i++) {
            Town town = towns.get(random.nextInt(towns.size()));
            Ant ant = new Ant(world, town);
            ants.add(ant);
        }
        return ants;
    }

}
