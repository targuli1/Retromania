package com.retromania.game.tic_tac_toe.presenters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.retromania.game.shared_abstractions.Presentable;
import com.retromania.game.spaceship_shooter.individuals.Background;

public class Presenter{
    protected Viewport gamePort;
    protected OrthographicCamera gameCam;

    public Presenter(String screenType) {
        gameCam = new OrthographicCamera();
        if (screenType.equalsIgnoreCase("stretch"))
            gamePort = new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), gameCam);
        else if (screenType.equalsIgnoreCase("fill")) {
            gamePort = new FillViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), gameCam);
        } else {
            gamePort = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), gameCam);
        }
    }

    public Viewport getViewPort(){
        return gamePort;
    }

    public void update(float dt) {
        gameCam.update();
    }
}
