package me.niv.ants.colony.game.generator;

import me.niv.ants.colony.game.entities.Town;
import me.niv.ants.colony.model.Location;
import me.niv.ants.colony.model.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TownGenerator {

    private int cities;
    private int retries;
    private int minimumDistance;
    private int deadzone; //Limit amount of pixels from screen sides

    private Random random;
    private World world;

    public TownGenerator(World world){
        this.cities = 10;
        this.retries = 100;
        this.minimumDistance = 100;
        this.deadzone = 300;

        this.world = world;
        random = new Random();
    }

    public TownGenerator withTowns(Integer towns){
        this.cities = towns;
        return this;
    }

    public TownGenerator withRetries(Integer retries){
        this.retries = retries;
        return this;
    }

    public TownGenerator withMinimumDistance(Integer minimumDistance){
        this.minimumDistance = minimumDistance;
        return this;
    }

    public TownGenerator withDeadzone(Integer deadzone){
        this.deadzone = deadzone;
        return this;
    }

    public List<Town> generate(){
        List<Town> towns = new ArrayList<>();

        for (int i = 0; i < retries; i++) {
            if(towns.size() < cities){
                Location loc =
                        new Location(random.nextInt(1920 - deadzone) + deadzone/2, random.nextInt(1080  - deadzone) + deadzone/2);
                Town town = new Town(world, loc);
                if(!hasNearby(town, towns)){
                    towns.add(town);
                    world.registerEntity(town);
                }
            }
        }

        return towns;
    }

    public boolean hasNearby(Town town, List<Town> towns){
        for(Town fromList : towns){
            if(town.getLocation().distance(fromList.getLocation()) < minimumDistance){
                return true;
            }
        }
        return false;
    }

}
