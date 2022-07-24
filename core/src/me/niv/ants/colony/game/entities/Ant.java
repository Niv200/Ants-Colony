package me.niv.ants.colony.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import me.niv.ants.colony.model.Location;
import me.niv.ants.colony.model.World;
import me.niv.ants.colony.model.entity.ILivingEntity;
import me.niv.ants.colony.model.entity.LivingEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Ant extends LivingEntity {

    private List<Town> towns;
    private List<Town> visitedTowns;
    private double totalDistance;
    private Town currentTown;
    private Town nextTown;
    private int id;

    private boolean done = false;
    private int speed = 5;

    public Ant(World world, Town town) {
        super(world, new Location(town.getLocation().getX(), town.getLocation().getY()));
        towns = new ArrayList<>(getWorld().getTowns());
        totalDistance = 0;
        visitedTowns = new ArrayList<>();
        currentTown = town;
        //init nextTown
        towns.remove(town);
        this.nextTown = towns.get(new Random().nextInt(towns.size()));
        towns.remove(nextTown);
        drawTrace();
    }

    @Override
    public void tick() {

        if(nextTown != null){
            if(nextTown.getLocation().distance(getLocation()) < 5){
                this.getLocation().setX(nextTown.getLocation().getX());
                this.getLocation().setY(nextTown.getLocation().getY());
                currentTown = nextTown;
                nextTown = null;
                if(!towns.isEmpty()){
                    this.nextTown = towns.get(new Random().nextInt(towns.size()));
                    towns.remove(nextTown);
                    drawTrace();
                }
                stateTime = 0.0f;
            }
        }
        if(towns.size() >= 1 && nextTown != null){
            moveTowardsNextTown();
        }
        if(towns.isEmpty()){
            nextTown = null;
            printDistance();
            done = true;
        }
    }

    public void setId(Integer id){
        this.id = id;
    }

    @Override
    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.circle((float) getLocation().getX(), (float) getLocation().getY(), 10f);
        shapeRenderer.end();
    }

    private float stateTime = 0.0f;

    public void moveTowardsNextTown(){
        Vector2 from = new Vector2((float) getLocation().getX(), (float) getLocation().getY());
        Vector2 to = new Vector2((float) nextTown.getLocation().getX(), (float) nextTown.getLocation().getY());

        stateTime =+Gdx.graphics.getDeltaTime();

        if(stateTime >= 1){
            stateTime = 0;
        }
        Vector2 newVec = from.lerp(to, 0.1f * stateTime * speed * speed * speed);

        getLocation().setX(newVec.x);
        getLocation().setY(newVec.y);
    }

    public void drawTrace(){
        Line line = new Line(currentTown, nextTown);
        getWorld().getTracesHandler().addLine(line);
        totalDistance = totalDistance + currentTown.getLocation().distance(nextTown.getLocation());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ant ant = (Ant) o;
        return Double.compare(ant.totalDistance, totalDistance) == 0 && speed == ant.speed
                && Float.compare(ant.stateTime, stateTime) == 0
                && Objects.equals(towns, ant.towns) && Objects.equals(visitedTowns, ant.visitedTowns)
                && Objects.equals(currentTown, ant.currentTown) && Objects.equals(nextTown, ant.nextTown);
    }

    @Override
    public int hashCode() {
        return Objects.hash(towns, visitedTowns, totalDistance, currentTown, nextTown, speed, stateTime);
    }

    public void printDistance(){
        if(this.nextTown == null && done == false){
            System.out.println("Total distance: " + totalDistance);
        }
    }
}
