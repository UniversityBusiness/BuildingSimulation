package com.universitybusiness.view.pages;

import com.universitybusiness.view.WindowManager;

import javax.swing.*;
import java.util.HashMap;

public abstract class Page implements IPage {
    protected final JFrame frame;
    
    protected final HashMap<String, JComponent> components;

    protected final WindowManager context;

    // Needs to be initialized in inheritor class
    protected JMenuBar menuBar;
    
    public Page(JFrame frame, WindowManager context) {
        this.frame = frame;
        this.context = context;
        components = new HashMap<>();

        initializeComponents();
        setupAppearance();
    }

    @Override
    public void reset() {
        this.frame.setJMenuBar(menuBar);
    }
}