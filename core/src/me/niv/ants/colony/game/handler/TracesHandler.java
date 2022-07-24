package me.niv.ants.colony.game.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import me.niv.ants.colony.game.entities.Line;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TracesHandler {

    HashMap<Line, Integer> lines;

    public TracesHandler() {
        this.lines = new HashMap<>();
    }

    public HashMap<Line, Integer> getTraces() {
        return lines;
    }

    public void drawTraces(ShapeRenderer shapeRenderer){
        shapeRenderer.begin(ShapeType.Filled);
        shapeRenderer.setColor(Color.GRAY);

        for(Line line : lines.keySet()){
            if(lines.get(line) > 0){
                shapeRenderer.rectLine(new Vector2(line.getFirstX(), line.getFirstY()), new Vector2(line.getSecondX(), line.getSecondY()), lines.get(line));
            }
        }
        shapeRenderer.end();
    }

    public void addLine(Line line){
        if(lines.containsKey(line)){
            lines.replace(line, lines.get(line) + 1);
        }else{
            lines.put(line, 1);
        }
    }

}
