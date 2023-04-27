package com.universitybullshit.view.actions;

import com.universitybullshit.view.components.Area;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ShowTimeAction extends AbstractAction {
    private final Area area;
    public ShowTimeAction(Area area) {
        this.area = area;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.area.setShowTime(!this.area.isShowTime());
    }
}
