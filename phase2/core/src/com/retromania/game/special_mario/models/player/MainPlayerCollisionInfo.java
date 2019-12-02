package com.retromania.game.special_mario.models.player;

/**
 *
 * A wrapper for the information given about the main player in collisions
 *
 * **/
public class MainPlayerCollisionInfo {
    private MainPlayer mainPlayer;
    private BodyPart bodyPart;

    public MainPlayerCollisionInfo(MainPlayer mainPlayer, BodyPart bodyPart){
        this.mainPlayer = mainPlayer;
        this.bodyPart = bodyPart;
    }


    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public MainPlayer getMainPlayer() {
        return mainPlayer;
    }
}
