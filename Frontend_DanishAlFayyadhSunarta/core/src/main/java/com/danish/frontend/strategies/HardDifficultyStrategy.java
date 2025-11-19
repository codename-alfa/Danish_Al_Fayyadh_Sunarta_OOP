package com.danish.frontend.strategies;

import java.util.HashMap;
import java.util.Map;

public class HardDifficultyStrategy implements DifficultyStrategy{
    @Override
    public Map<String, Integer> getObstacleWeights() {
        Map<String, Integer> weights = new HashMap<>();
        weights.put("VerticalLaser", 3);
        weights.put("HomingMissile", 3);
        weights.put("HomingMissile", 2);
        return weights;
    }

    @Override
    public float getSpawnInterval() {
        return 1.0f;
    }

    @Override
    public int getDensity() {
        return 3;
    }

    @Override
    public float getMinGap() {
        return 100f;
    }
}
