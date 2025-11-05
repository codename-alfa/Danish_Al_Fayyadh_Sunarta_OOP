package com.danish.frontend;

import java.util.ArrayList;

public class ShapePool {
    private ArrayList<Shape> circlePool;
    private ArrayList<Shape> squarePool;

    public ShapePool(){
        circlePool = new ArrayList<>();
        squarePool = new ArrayList<>();
    }

    public Shape obtain(String type){
        if(type.equals("Circle")){
            if(circlePool.isEmpty() == false){
                Shape ambil = circlePool.get(0);
                circlePool.remove(0);
                return ambil;
            }
        } else if(type.equals("Square")){
            if(squarePool.isEmpty() == false){
                Shape ambil = squarePool.get(0);
                squarePool.remove(0);
                return ambil;
            }
        }
        return null;
    }

    public void release(Shape shape){
        if(shape.getType().equals("Circle")){
            if(circlePool.size() < 3){
                circlePool.add(shape);
            }
        } else if(shape.getType().equals("Square")){
            if(squarePool.size() < 3){
                squarePool.add(shape);
            }
        }
    }

    public ArrayList<Shape> getPool(String type){
        if(type.equals("Circle")){
            return circlePool;
        } else if(type.equals("Square")){
            return squarePool;
        }
        return null;
    }
}
