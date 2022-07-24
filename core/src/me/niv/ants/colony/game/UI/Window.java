package me.niv.ants.colony.game.UI;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.kotcrab.vis.ui.util.TableUtils;
import com.kotcrab.vis.ui.widget.VisWindow;

public class Window extends VisWindow {

    public Window () {
        super("tree");
        TableUtils.setSpacingDefaults(this);
        columnDefaults(0).left();

        setSize(150, 380);
        setPosition(774, 303);
    }

}