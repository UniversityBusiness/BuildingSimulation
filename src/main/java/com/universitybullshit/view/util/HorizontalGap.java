package com.universitybullshit.view.util;

import javax.swing.*;

public class HorizontalGap extends JLabel {
    public HorizontalGap(int length) {
        setText(new String(new char[length]).replace("\0", "-"));
    }
}
