package com.universitybullshit.view.actions;

import com.universitybullshit.view.components.Area;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ShowInfoAction extends AbstractAction {
    private final Area area;
    public ShowInfoAction(Area area) {
        this.area = area;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        area.setShowInfo(!area.isShowInfo());
    }
}
