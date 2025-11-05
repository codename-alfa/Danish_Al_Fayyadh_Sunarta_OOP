package com.danish.frontend.obstacles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class HorizontalLaser extends BaseObstacle{
    public HorizontalLaser(Vector2 startPosition, int length){
        super(startPosition, length);
    }
    @Override
    public void initialize(Vector2 startPosition, int length){
        super.initialize(startPosition, length);
    }
    @Override
    protected void updateCollider(){
        if(collider == null){
            collider = new Rectangle(position.x, position.y, length, WIDTH);
        } else{
            collider = collider.set(position.x, position.y, length, WIDTH);
        }
    }
    @Override
    protected void drawShape(ShapeRenderer shapeRenderer){
        shapeRenderer.rect(position.x, position.y, length, WIDTH);
    }
    @Override
    public float getRenderWidth(){ // error kalo data typenya protected
        return length;
    }
    @Override
    public float getRenderHeight(){ // error kalo data typenya protected
        return WIDTH;
    }
}
