package me.niv.ants.colony.model;

import java.util.Objects;

public class Location {

    private double x;
    private double y;

    public Location(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(Location to){
        double xDiff = Math.pow(to.getX() - this.x, 2);
        double yDiff = Math.pow(to.getY() - this.y, 2);
        return Math.sqrt(xDiff + yDiff);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Double.compare(location.x, x) == 0 && Double.compare(location.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
