package com.danish.frontend;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Coin{
    private Vector2 position;
    private Rectangle collider;
    private float radius;
    private boolean active;
    private float bobOffset;
    private float bobSpeed;

    public Coin(Vector2 startPosition){
        this.collider = new Rectangle();
    }

    public void update(float delta){

    }
    public void renderShape(ShapeRenderer shapeRenderer){
        if(!active){
            return;
        }
        float drawY = position.y + (float)(Math.sin(bobOffset) * 5f);
        shapeRenderer.circle();
        shapeRenderer.setColor(1f, 1f, 0f, 1f);
    }

    public boolean isColliding(Rectangle playerCollider){
        if(active && collider.overlaps(playerCollider)){
            return true;
        } else{
            return false;
        }
    }
}
