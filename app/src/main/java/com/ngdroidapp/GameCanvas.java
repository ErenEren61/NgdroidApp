package com.ngdroidapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import istanbul.gamelab.ngdroid.base.BaseCanvas;
import istanbul.gamelab.ngdroid.util.Log;
import istanbul.gamelab.ngdroid.util.Utils;


/**
 * Created by noyan on 24.06.2016.
 * Nitra Games Ltd.
 */


public class GameCanvas extends BaseCanvas {

    private Bitmap tileset, spritesheet;
    private int kareno;
    private int spritex, spritey ,hiz;
    private Rect tilesrc, tiledst, spritesrc, spritedst;

    public GameCanvas(NgApp ngApp) {
        super(ngApp);
    }

    public void setup() {
        tileset = Utils.loadImage(root, "images/tilea2.png");
        tilesrc = new Rect();
        tiledst = new Rect();

        spritesheet = Utils.loadImage(root, "images/cowboy.png");
        spritesrc = new Rect();
        spritedst = new Rect();

        kareno = 0;

        spritex = 0;
        spritey = 0;
        hiz = 16;
    }

    public void update() {



    }

    public void draw(Canvas canvas) {

        tilesrc.set(0,0,64,64);

        for (int i=0;i<getWidth();i+=128){
            for(int j=0;j<getHeight();j+=128){
                tiledst.set(i, j, i+128, j+128);
                canvas.drawBitmap(tileset,tilesrc,tiledst,null);
            }
        }
        spritex+=hiz;

        if(spritex+256 > getWidth()){
            spritex = getWidth()-256;
        }

        kareno++; //Kareyi arttırmak için

        if(kareno>8){
            kareno=1;
        }

        spritesrc.set(kareno*128, 0, (kareno+1)*128, 128); //Resimden aldığımız koordinatlar
        spritedst.set(spritex, spritey, spritex+256, spritey+256); //Ekrana çizeleceği koordinatlar
        canvas.drawBitmap(spritesheet, spritesrc, spritedst, null);


    }

    public void keyPressed(int key) {

    }

    public void keyReleased(int key) {

    }

    public boolean backPressed() {
        return true;
    }

    public void surfaceChanged(int width, int height) {

    }

    public void surfaceCreated() {

    }

    public void surfaceDestroyed() {

    }

    public void touchDown(int x, int y) {
    }

    public void touchMove(int x, int y) {
    }

    public void touchUp(int x, int y) {
    }


    public void pause() {

    }


    public void resume() {

    }


    public void reloadTextures() {

    }


    public void showNotify() {
    }

    public void hideNotify() {
    }

}
