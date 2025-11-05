package com.danish.frontend;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public abstract class Shape{
    public Vector2 position;
    public float size = 50f;
    public String type;

    public Shape() {
        this.position = new Vector2();
    }
    public void setPosition(float x, float y){
        this.position.set(x, y);
    }
    public String getType(){
        return type;
    }
    public abstract void render(ShapeRenderer shapeRenderer);
}
