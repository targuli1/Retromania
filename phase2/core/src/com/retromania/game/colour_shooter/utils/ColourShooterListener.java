package com.retromania.game.colour_shooter.utils;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.retromania.game.colour_shooter.individuals.BulletCharacter;
import com.retromania.game.colour_shooter.individuals.Square;

public class ColourShooterListener implements ContactListener {

    @Override
    public void beginContact(Contact contact) {
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();
        System.out.println("Contact detected");

        if (fa == null || fb == null ) return;
        if (fa.getFilterData() == null || fb.getFilterData() == null) return;

        if (fa.getUserData() instanceof BulletCharacter & fb.getUserData() instanceof Square) {
            contact.getFixtureB().getBody().destroyFixture(fa);
            System.out.println("ADASDASDASDASD");
        }
        else if (fa.getUserData() instanceof Square & fb.getUserData() instanceof BulletCharacter) {
            contact.getFixtureB().getBody().destroyFixture(fb);
            System.out.println("BDASDASDASDASD");
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
