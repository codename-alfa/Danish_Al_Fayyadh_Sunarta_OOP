package com.danish.frontend;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Coin{
    private Vector2 position;
    private Rectangle collider;
    private float radius = 15f;
    private boolean active;
    private float bobOffset;
    private float bobSpeed = 5f;

    public Coin(Vector2 startPosition){
        this.position = new Vector2(startPosition);
        this.collider = new Rectangle(position.x - radius, position.y - radius, radius * 2, radius * 2);
        this.active = false;
    }

    public void update(float delta){
        bobOffset += bobSpeed * delta;
        collider.x = position.x - radius;
        collider.y = position.y - radius + (float)(Math.sin(bobOffset) * 5f);
    }
    public void renderShape(ShapeRenderer shapeRenderer){
        if(active == false){
            return;
        }
        float drawY = position.y + (float)(Math.sin(bobOffset) * 5f);
        shapeRenderer.circle(position.x, drawY, radius);
        shapeRenderer.setColor(1f, 1f, 0f, 1f);
    }

    public boolean isColliding(Rectangle playerCollider){
        if(active && collider.overlaps(playerCollider)){
            return true;
        } else{
            return false;
        }
    }
    public void setActive(boolean active){
        this.active = active;
        if(active == true){
            bobOffset = 0;
        }
    }
    public void setPosition(float x, float y){
        this.position.set(x, y);
        this.collider.setPosition(x - radius, y - radius);
    }
    public boolean isActive(){
        return active;
    }
    public Vector2 getPosition(){
        return position;
    }
}
