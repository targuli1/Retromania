package com.retromania.game.special_mario.utils;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.retromania.game.special_mario.models.player.MainPlayer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class WorldManager {
    @Provides
    @Singleton
    public static World getWorld(){
        World world = new World(new Vector2(0, -10), true);
        return world;
    }
}
