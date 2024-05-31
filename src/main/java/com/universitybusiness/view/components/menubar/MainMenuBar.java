package com.universitybusiness.view.components.menubar;

import com.universitybusiness.view.WindowManager;
import com.universitybusiness.view.actions.mainMenu.LoadDBMenuItemListener;
import com.universitybusiness.view.actions.mainMenu.LoadMenuItemListener;
import com.universitybusiness.view.actions.mainMenu.SaveDBMenuItemListener;
import com.universitybusiness.view.actions.mainMenu.SaveMenuItemListener;
import com.universitybusiness.view.util.Style;

import javax.swing.*;

public class MainMenuBar extends CustomMenuBar {
    public MainMenuBar(WindowManager context) {
        super(context);
        this.add(createFileMenu());
        this.add(createDBMenu());
    }

    private JMenu createFileMenu() {
        JMenu file = new JMenu("File");
        file.setForeground(Style.getPrimaryLightColor());

        JMenuItem load = new JMenuItem("Load");
        JMenuItem save = new JMenuItem("Save");

        load.addActionListener(new LoadMenuItemListener(context));
        save.addActionListener(new SaveMenuItemListener(context));

        file.add(load);
        file.add(save);

        return file;
    }

    private JMenu createDBMenu() {
        JMenu db = new JMenu("Database");
        db.setForeground(Style.getPrimaryLightColor());

        JMenuItem load = new JMenuItem("Load");
        JMenuItem save = new JMenuItem("Save");

        load.addActionListener(new LoadDBMenuItemListener(context));
        save.addActionListener(new SaveDBMenuItemListener(context));

        db.add(load);
        db.add(save);

        return db;
    }
}
