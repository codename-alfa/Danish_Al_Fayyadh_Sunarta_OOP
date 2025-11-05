package com.danish.frontend;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import java.util.ArrayList;
import java.util.Random;

public class Main extends ApplicationAdapter {
    // TODO: Deklarasikan Attribute untuk menyimpan ShapeRenderer, Factory untuk Shape, Pool untuk Shape, dan ArrayList untuk menyimpan Shape yang sedang aktif
    private Random random;
    private ShapeRenderer shapeRenderer;
    private ShapeFactory shapeFactory;
    private ShapePool shapePool;
    private ArrayList<Shape> activeShapes;

    @Override
    public void create() {
    // TODO: Inisialisasi shapeRenderer, shapePool, shapeFactory, activeShapes, dan random.
        System.out.println("Press 1=Circle, 2=Square, R=Release");
        shapeRenderer = new ShapeRenderer();
        shapePool = new ShapePool();
        shapeFactory = new ShapeFactory(shapePool);
        activeShapes = new ArrayList<>();
        random = new Random();
    }
    @Override
    public void render() {
        // TODO: Cek input: Jika tombol “1” baru ditekan, maka akan membuat sebuah Shape dengan tipe “Circle”
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)){
            createShape("Circle");
        }

        // TODO: Cek input: Jika tombol “2” baru ditekan, maka akan membuat sebuah Shape dengan tipe “Square”
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)){
            createShape("Square");
        }

        // TODO: Cek input: Jika tombol “R” baru ditekan, maka akan me-release semua Shape
        if(Gdx.input.isKeyJustPressed(Input.Keys.R)){
            releaseAllShapes();
        }
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        // TODO: Mulai sesi ShapeRenderer dengan tipe Filled
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // TODO: Melakukan render untuk semua Shape yang aktif
        for (Shape shape : activeShapes) {
            shape.render(shapeRenderer);
        }

        // TODO: Akhiri sesi ShapeRenderer
        shapeRenderer.end();
    }

    private void createShape(String type) {
        if (activeShapes.size() >= 3) {
            System.out.println("Maximum 3 shapes active!");
            return;
        }

        // Panggil shapeFactory untuk membuat Shape sesuadengan type
        Shape shape = shapeFactory.create(type);
        if (shape != null) {
            shape.setPosition(
                random.nextFloat() * (Gdx.graphics.getWidth() - 100) + 50,
                random.nextFloat() * (Gdx.graphics.getHeight() - 100) + 50
            );
            activeShapes.add(shape);
        }
    }
    private void releaseAllShapes() {
        // TODO: Me-release semua pool pada activeShapes
        for (Shape shape : activeShapes) {
            shapePool.release(shape);
        }

        // TOOO: Membersihkan activeShapes.
        activeShapes.clear();
        System.out.println("All shapes returned to pool");
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }

}
