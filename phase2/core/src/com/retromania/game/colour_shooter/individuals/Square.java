package com.retromania.game.colour_shooter.individuals;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.retromania.game.shared_abstractions.Character;

public class Square extends Character {
  BodyDef bDef;
  private FixtureDef fixtureDef;

  private float getRadius() {
    return 16;
  }

  public Square(World given_world, TextureRegion textureRegion, int x, int y, int radius) {
    super(
        textureRegion,
        0,
        0,
        textureRegion.getRegionWidth(),
        textureRegion.getRegionHeight(),
        1f,
        given_world,
        x,
        y);
  }

  @Override
  protected Object getUserData() {
    return this;
  }

  @Override
  protected BodyDef setUpBodyDef() {
    bDef = new BodyDef();
    bDef.position.set(getInitialXInTheWorld(), getInitialYInTheWorld());
    bDef.fixedRotation = true;
    bDef.type = BodyDef.BodyType.KinematicBody;
    return bDef;
  }

  @Override
  protected Body setUpBody(BodyDef bDef) {
    this.body = getWorld().createBody(bDef);
    return body;
  }

  @Override
  protected void setUpFixture() {
    PolygonShape shape = new PolygonShape();
    shape.setAsBox(getRadius() * 2, getRadius() * 2);

    fixtureDef = new FixtureDef();
    fixtureDef.shape = shape;
    body.createFixture(fixtureDef);
  }

  @Override
  public FixtureDef getFixtureDef() {
    return fixtureDef;
  }

  @Override
  public short getDefaultMask() {
    return 0;
  }

  @Override
  public short getDefaultTarget() {
    return 0;
  }

  public void rotateSquare(){
    this.body.setAngularVelocity(1.5f);
    float curr = this.body.getAngle();
//    float curr = getRotation();
//    curr  = curr >= 360 ? 0 : curr + 90/60f;
    setRotation(curr*(180f/(float) Math.PI));
    setOriginCenter();
//    rotateBody(curr);
  }
  private void rotateBody(float currentRotation) {
  }

  public void increaseWeight(float num) {
    this.body.setLinearDamping(num);
  }
}
