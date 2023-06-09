package com.universitybullshit.model;

import lombok.Getter;

import java.util.*;

public class Habitat {
    private final int width;
    private final int height;
    private long time;
    private long lastWoodenBuildingSpawnTime;
    private long lastCapitalBuildingSpawnTime;
    @Getter
    private Vector<Building> buildings;
    @Getter
    private HashSet<Long> ids;
    @Getter
    private TreeMap<Long, Long> spawnTimeMap;
    @Getter
    private int woodenBuildingsCount;
    @Getter
    private int capitalBuildingsCount;
    public Habitat(int width, int height) {
        this.width = width;
        this.height = height;
        reset();
    }
    public void update(long time) {
        this.time = time;
        removeExpiredObjects(findExpiredObjects());
        spawnCapitalBuilding();
        spawnWoodenBuilding();
    }
    public void reset() {
        this.time = 0;
        this.lastWoodenBuildingSpawnTime = 0;
        this.lastCapitalBuildingSpawnTime = 0;
        this.buildings = new Vector<>();
        this.ids = new HashSet<>();
        this.spawnTimeMap = new TreeMap<>();
        this.woodenBuildingsCount = 0;
        this.capitalBuildingsCount = 0;
    }
    private void spawnWoodenBuilding() {
        Random generator = new Random();

        double chance = generator.nextDouble();
        if (chance > WoodenBuilding.getProbability()) {
            if (this.time - this.lastWoodenBuildingSpawnTime >= WoodenBuilding.getInterval()) {
                int x = generator.nextInt(this.width);
                int y = generator.nextInt(this.height);

                WoodenBuilding woodenBuilding = new WoodenBuilding(x, y, this.time);

                this.buildings.add(woodenBuilding);
                this.ids.add(woodenBuilding.getId());
                this.spawnTimeMap.put(woodenBuilding.getId(), this.time);
                this.woodenBuildingsCount++;
                this.lastWoodenBuildingSpawnTime = this.time;
            }
        }
    }
    private void spawnCapitalBuilding() {
        Random generator = new Random();

        double chance = generator.nextDouble();
        if (chance > CapitalBuilding.getProbability()) {
            if (this.time - this.lastCapitalBuildingSpawnTime >= CapitalBuilding.getInterval()) {
                int x = generator.nextInt(this.width);
                int y = generator.nextInt(this.height);

                CapitalBuilding capitalBuilding = new CapitalBuilding(x, y, this.time);

                this.buildings.add(capitalBuilding);
                this.ids.add(capitalBuilding.getId());
                this.spawnTimeMap.put(capitalBuilding.getId(), this.time);
                this.capitalBuildingsCount++;
                this.lastCapitalBuildingSpawnTime = this.time;
            }
        }
    }
    private Vector<Building> findExpiredObjects() {
        Vector<Building> expired = new Vector<>();

        for (Building building : buildings) {
            if (building instanceof WoodenBuilding) {
                if (time - building.getSpawnTime() >= WoodenBuilding.getLifeTime()) {
                    expired.add(building);
                }
            } else {
                if (time - building.getSpawnTime() >= CapitalBuilding.getLifeTime()) {
                    expired.add(building);
                }
            }
        }

        return expired;
    }
    private void removeExpiredObjects(Vector<Building> expired) {
        for (Building building : expired) {
            this.ids.remove(building.getId());
            this.spawnTimeMap.remove(building.getId());
            this.buildings.remove(building);
        }
    }
}
