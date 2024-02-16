package com.universitybusiness.view.actions;

import com.universitybusiness.view.components.Area;

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