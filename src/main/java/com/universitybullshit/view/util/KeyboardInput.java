package com.universitybullshit.view.util;

import com.universitybullshit.controller.HabitatController;
import com.universitybullshit.view.Area;
import com.universitybullshit.view.actions.StartKeyAction;
import com.universitybullshit.view.actions.StopKeyAction;

import javax.swing.*;

public class KeyboardInput {

    public static void createKeyBindings(JComponent component, HabitatController controller, Area area) {
        InputMap im = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = component.getActionMap();

        Action startAction = new StartKeyAction(controller, area);
        Action stopAction = new StopKeyAction(controller, area);

        im.put(KeyStroke.getKeyStroke("B"), "start");
        im.put(KeyStroke.getKeyStroke("E"), "stop");
        am.put("start", startAction);
        am.put("stop", stopAction);
    }
}
