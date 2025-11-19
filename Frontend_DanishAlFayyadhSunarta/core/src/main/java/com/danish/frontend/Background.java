package com.danish.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Background{
    private Texture backgroundTexture;
    private TextureRegion backgroundRegion;
    private float width;
    private float height;
    private float currentCameraX = 0f;

    public Background(){
        backgroundTexture = new Texture(Gdx.files.internal("background.png"));
        backgroundRegion = new TextureRegion(backgroundTexture);
        width = 2688f;
        height = 1536f;
    }
    public void update(float cameraX){
        currentCameraX = cameraX;
    }
    public void render(SpriteBatch batch){
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float faktorSkalaY = screenHeight / height;
        float scaledWidth = width * faktorSkalaY;
        float scaledHeight = height * faktorSkalaY;
        float startX = currentCameraX - (screenWidth / 2f);
        startX = startX - (startX % scaledWidth);
        float x = startX;
        while(x < currentCameraX + (screenWidth / 2f)){
            batch.draw(backgroundRegion, x, 0, scaledWidth, scaledHeight);
            x += scaledWidth;
        }
    }
    public void dispose(){
        if(backgroundTexture != null){
            backgroundTexture.dispose();
        }
    }
}
