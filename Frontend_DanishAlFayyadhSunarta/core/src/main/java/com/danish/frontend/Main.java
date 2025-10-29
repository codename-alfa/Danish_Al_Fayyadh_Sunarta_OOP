package com.danish.frontend;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Main extends ApplicationAdapter{

    private OrthographicCamera camera;
    private Viewport viewport;
    private ShapeRenderer shapeRenderer;

    private final float WORLD_WIDTH = 1920;
    private final float WORLD_HEIGHT = 1000; // ga 1080 karna kepotong takbar (biar ga ada gap)

    private Rectangle square;
    private Color squareColor;
    private int colorState = 1;
    private final float MOVE_SPEED = 1000;

    @Override
    public void create(){
        camera = new OrthographicCamera();

        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        shapeRenderer = new ShapeRenderer();

        square = new Rectangle();
        square.width = 50;
        square.height = 50;
        square.x = (WORLD_WIDTH / 2) - (square.width / 2);
        square.y = (WORLD_HEIGHT / 2) - (square.height / 2);
        squareColor = Color.RED;
    }

    @Override
    public void render(){
        handleInput();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        shapeRenderer.setProjectionMatrix(camera.combined);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(squareColor);
        shapeRenderer.rect(square.x, square.y, square.width, square.height);
        shapeRenderer.end();
    }

    private void handleInput(){
        float deltaTime = Gdx.graphics.getDeltaTime();

        if(Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)){
            square.y += MOVE_SPEED * deltaTime;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            square.y -= MOVE_SPEED * deltaTime;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            square.x += MOVE_SPEED * deltaTime;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            square.x -= MOVE_SPEED * deltaTime;
        }

        if(square.x < 0){
            square.x = 0;
        }
        if(square.x + square.width > WORLD_WIDTH){
            square.x = WORLD_WIDTH - square.width;
        }
        if(square.y < 0){
            square.y = 0;
        }
        if(square.y + square.height > WORLD_HEIGHT){
            square.y = WORLD_HEIGHT - square.height;
        }

        boolean colorChange = false;
        if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT) || Gdx.input.isKeyJustPressed(Input.Keys.Q)){ //loop maju (klik kiri/Q)
            if(colorState == 3){
                colorState = 1;
            } else{
                colorState++;
            }
            colorChange = true;
        }
        if(Gdx.input.isButtonJustPressed(Input.Buttons.RIGHT) || Gdx.input.isKeyJustPressed(Input.Keys.E)){ //loop mundur (klik kanan/E)
            if(colorState == 1){
                colorState = 3;
            } else{
                colorState--;
            }
            colorChange = true;
        }
        if(colorChange){
            switch(colorState){
                case 1:
                    squareColor = Color.RED;
                    Gdx.app.log("colorChange", "red");
                    break;
                case 2:
                    squareColor = Color.YELLOW;
                    Gdx.app.log("colorChange", "yellow");
                    break;
                case 3:
                    squareColor = Color.BLUE;
                    Gdx.app.log("colorChange", "blue");
                    break;
            }
        }
    }
    @Override
    public void resize(int width, int height){
        viewport.update(width, height, true);
    }

    @Override
    public void dispose(){
        shapeRenderer.dispose();
    }
}
