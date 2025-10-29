package com.danish.frontend;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {
    private Vector2 position;
    private Vector2 velocity;
    private float gravity = 2000f;
    private float force = 4500f;
    private float maxVerticalSpeed = 700f;
    private Rectangle collider;
    private float width = 64f;
    private float height = 64f;
    private float baseSpeed = 300f;
    private float distanceTraveled = 0f;

    public Player(Vector2 startPosition){
        this.position = startPosition;
        this.velocity = new Vector2();
        this.collider = new Rectangle();
    }
    private void update(float delta, boolean isFlying){
        updateDistanceAndSpeed(delta);
        updatePosition(float delta);
        applyGravity(float delta);
        fly(delta);
        fly(float delta);
    }
}
