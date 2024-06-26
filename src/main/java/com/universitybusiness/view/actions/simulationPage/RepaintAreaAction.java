package com.universitybusiness.view.actions.simulationPage;

import com.universitybusiness.view.components.simulationView.Area;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RepaintAreaAction extends AbstractAction {
    private final Area area;

    public RepaintAreaAction(
        Area area
    ) {
        this.area = area;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        area.repaint();
    }
}
