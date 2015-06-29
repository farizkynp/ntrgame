package com.ntr.prototype.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ntr.prototype.NTRPrototypeMain;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
                config.width=720*4/3;
                config.height=720;
		new LwjglApplication(new NTRPrototypeMain(), config);
	}
}
            