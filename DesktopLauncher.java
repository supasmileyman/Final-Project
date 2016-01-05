package com.egs.eddiegolfsim.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.egs.eddiegolfsim.Golf;

public class DesktopLauncher {

    public static void main(String[] arg) {
        //gotten from kilobolt
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Eddie's Golf Simulator";
        config.width = 272;
        config.height = 408;
        new LwjglApplication(new Golf(), config);
    }
}
