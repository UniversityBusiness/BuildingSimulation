package com.universitybusiness.view.components.controls;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SwitchButton extends JComponent {
    @Getter
    @Setter
    private Color activeBackground;
    @Getter
    @Setter
    private boolean isActive;

    private final JButton actionCompleter;

    public SwitchButton() {
        this.isActive = false;
        setPreferredSize(new Dimension(50,20));
        setBackground(new Color(217,217,217));
        setForeground(Color.WHITE);
        setActiveBackground(new Color(35,184,68));

        actionCompleter = new JButton();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (isEnabled()) {
                    isActive = !isActive;

                    fireActionPerformed();

                    repaint();
                }
            }
        });
    }

    public void addActionListener(ActionListener l) {
        actionCompleter.addActionListener(l);
    }

    public void removeActionListener(ActionListener l) {
        actionCompleter.removeActionListener(l);
    }

    public void fireActionPerformed() {
        actionCompleter.doClick();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(isActive ? getActiveBackground() : getBackground());
        g2d.fillRoundRect(0,0,getWidth(), getHeight(), getHeight(), getHeight());
        g2d.setColor(getForeground());

        int pointHorizontalPosition = 3;
        if (isActive) {
            pointHorizontalPosition = getWidth() - getHeight();
        }

        g2d.fillOval(pointHorizontalPosition, 3, getHeight() - 6, getHeight() - 6);
        super.paintComponent(g);
    }
}
