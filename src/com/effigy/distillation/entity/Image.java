/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.effigy.distillation.entity;

/**
 *
 * @author Noxolo.Mkhungo
 */
public class Image {
    
    private int IMG_WIDTH ;
    private int IMG_HEIGHT ;

    public Image(int IMG_WIDTH, int IMG_HEIGHT) {
        this.IMG_WIDTH = IMG_WIDTH;
        this.IMG_HEIGHT = IMG_HEIGHT;
    }

   
    
    public int getIMG_WIDTH() {
        return IMG_WIDTH;
    }

    public int getIMG_HEIGHT() {
        return IMG_HEIGHT;
    }

    public void setIMG_WIDTH(int IMG_WIDTH) {
        this.IMG_WIDTH = IMG_WIDTH;
    }

    public void setIMG_HEIGHT(int IMG_HEIGHT) {
        this.IMG_HEIGHT = IMG_HEIGHT;
    }
    
    
    
    
}
