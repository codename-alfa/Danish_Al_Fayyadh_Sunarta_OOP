package com.danish.frontend;

public class ShapeFactory {
    private ShapePool pool;

    public ShapeFactory(ShapePool pool){
        this.pool = pool;
    }
    public Shape create(String type) {
        Shape shape = pool.obtain(type);
        if (shape == null){
            if (type.equals("Circle")){
                shape = new Circle();
            } else if(type.equals("Square")){
                shape = new Square();
            }
        }
        return shape;
    }
}
