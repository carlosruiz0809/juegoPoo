/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enemigothread;

import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JLabel;

/**
 *
 * @author Carlos Ruiz
 */
public class EnemigoThread extends Thread{
    
    private int x, y, limitex, limitey, step;
    private JLabel enemigo;

    public EnemigoThread() {}

    public void EnemigoThread(int x, int y, int limitex, int limitey, int step, JLabel enemigo) {
        this.x = x;
        this.y = y;
        this.limitex = limitex;
        this.limitey = limitey;
        this.step = step;
        this.enemigo = enemigo;
    }

    @Override
    public void run() {
        
        switch(getNumRandom(1,8))
        {
            case 1:
                this.enemigo.setLocation(x, y-=step);
                break;
            case 2:
                this.enemigo.setLocation(x+=step,y-=step);
                break;
            case 3:
                this.enemigo.setLocation(x+=step, y);
                break;
            case 4:
                this.enemigo.setLocation(x+=step, y+=step);
                break;
            case 5:
                this.enemigo.setLocation(x, y+=step);
                break;
            case 6:
                this.enemigo.setLocation(x-=step, y+=step);
                break;
            case 7:
                this.enemigo.setLocation(x-=step, y);
                break;
            case 8:
                this.enemigo.setLocation(x-=step, y-=step);
                break;
        }
        yield();
    }
       
    private int getNumRandom(int min,int max){
        return ThreadLocalRandom.current().nextInt(min, max);
    }
    
}