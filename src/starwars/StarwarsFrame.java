/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

import javax.swing.JFrame;

/**
 *
 * @author ufuk
 */
public class StarwarsFrame extends JFrame {

    public StarwarsFrame() {
        StarwarsPanel panel = new StarwarsPanel();
        this.add(panel);
        panel.setFocusable(true);
    }
}
