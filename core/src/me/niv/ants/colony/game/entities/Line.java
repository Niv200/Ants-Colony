package me.niv.ants.colony.game.entities;

import java.util.Objects;

public class Line {

    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public Line(int x1, int x2, int y1, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public Line(Town from, Town to){
        this.x1 = (int)Math.round(from.getLocation().getX());
        this.x2 = (int)Math.round(to.getLocation().getX());
        this.y1 = (int)Math.round(from.getLocation().getY());
        this.y2 = (int)Math.round(to.getLocation().getY());
    }
    public int getFirstX() {
        return x1;
    }

    public int getSecondX() {
        return x2;
    }

    public int getFirstY() {
        return y1;
    }

    public int getSecondY() {
        return y2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return x1 == line.x1 && x2 == line.x2 && y1 == line.y1 && y2 == line.y2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, x2, y1, y2);
    }
}
