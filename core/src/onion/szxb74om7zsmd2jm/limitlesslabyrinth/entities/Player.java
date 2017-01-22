package onion.szxb74om7zsmd2jm.limitlesslabyrinth.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

/**
 * Created by chris on 1/19/2017.
 */
public class Player implements InputProcessor{
    public Sprite getSprite() {
        return sprite;
    }

    private Sprite sprite;
    private long time = 0;
    private long timeUP = 0;
    private long timeDOWN = 0;
    private long timeLEFT = 0;
    private long timeRIGHT = 0;
    private float speed = 4f;


    private TiledMapTileLayer collisionLayer;

    public Player(Sprite sprite, TiledMapTileLayer collisionLayer){
        this.sprite = sprite;
        this.collisionLayer = collisionLayer;
        sprite.setPosition(32 * 5, 32 * 5);
    }

    public void draw(Batch batch) {
        sprite.draw(batch);
        move();
    }


    public boolean checkCollision(float width, float height, float speed){
        return (!collisionLayer.getCell((int) ((sprite.getX() + sprite.getWidth()/2 + width/2 + speed) / collisionLayer.getTileWidth()), (int) ((sprite.getY() + sprite.getHeight()/2 + height/2 + speed) / collisionLayer.getTileHeight())).getTile().getProperties().containsKey("blocked")
            && !collisionLayer.getCell((int) ((sprite.getX() + sprite.getWidth()/2 + width/2 + speed) / collisionLayer.getTileWidth()), (int) ((sprite.getY() + sprite.getHeight()/2 + height/2 + speed) / collisionLayer.getTileHeight())).getTile().getProperties().containsKey("blocked")
        );
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public void move(){
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            if (checkCollision(0f, sprite.getHeight(), speed)) {
                sprite.setY(sprite.getY() + speed);
                timeUP = System.currentTimeMillis() + 1;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            if (checkCollision(0f, -sprite.getHeight(), speed)) {
                sprite.setY(sprite.getY() + -speed);
                timeDOWN = System.currentTimeMillis() + 1;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            if (checkCollision(-sprite.getWidth(), 0f, speed)) {
                sprite.setX(sprite.getX() + -speed);
                timeLEFT = System.currentTimeMillis() + 1;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            if (checkCollision(sprite.getWidth(), 0f, speed)) {
                sprite.setX(sprite.getX() + speed);
                timeRIGHT = System.currentTimeMillis() + 1;
            }
        }
    }
}

