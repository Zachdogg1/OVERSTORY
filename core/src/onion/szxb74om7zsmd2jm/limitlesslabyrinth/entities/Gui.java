package onion.szxb74om7zsmd2jm.limitlesslabyrinth.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import onion.szxb74om7zsmd2jm.limitlesslabyrinth.entities.items.Item;
import onion.szxb74om7zsmd2jm.limitlesslabyrinth.entities.items.weapons.Bow;
import onion.szxb74om7zsmd2jm.limitlesslabyrinth.entities.items.weapons.Fists;
import onion.szxb74om7zsmd2jm.limitlesslabyrinth.entities.items.weapons.NullWeapon;
import onion.szxb74om7zsmd2jm.limitlesslabyrinth.entities.items.Weapon;
import onion.szxb74om7zsmd2jm.limitlesslabyrinth.entities.items.weapons.WizardStaff;
import onion.szxb74om7zsmd2jm.limitlesslabyrinth.screens.Play;

/**
 * Created by 226812 on 1/27/2017.
 */
public class Gui {
    public int getSelected() {
        return selected;
    }
    private static int selected = 0;
    private long time1 = 0;
    private long time2 = 0;
    private long time3 = 0;
    private long time4 = 0;
    private Sprite playerHealthBar;
    private Sprite playerLostHealthBar;
    private Sprite itemBox1;
    private Sprite itemBox2;
    private Sprite itemBox3;
    private Sprite itemBox4;
    private static Sprite[] refreshItem = new Sprite[4];
    private static Item item1;
    private static Item item2;
    private static Item item3;
    private static Item item4;
    private static Item Equipped;
    private Texture HealthBar = new Texture("playerhealthbar.png");
    private Texture LostHealthBar = new Texture("playerredbar.png");
    private Texture ItemBox = new Texture("itemBox.png");
    private Texture SelectedBox = new Texture("selectedBox.png");
    private Backpack backpack = new Backpack();
    private static float healthBarX = 0;
    private static boolean isBackpackOpen = false;
    private static boolean[] isRefreshing = new boolean[4];
    private static Play pl = new Play();
    public Item getEquipped() {
        return Equipped;
    }
    public void setEquipped(Item equipped) {
        Equipped = equipped;
    }
    public boolean getIsBackpackOpen() {
        return isBackpackOpen;
    }
    public void setIsBackpackOpen(boolean isBackpackOpen) {
        this.isBackpackOpen = isBackpackOpen;
    }
    public Item getItem1() {
        return item1;
    }
    public void setItem1(Item item1) {
        Gui.item1 = item1;
    }
    public Item getItem2() {
        return item2;
    }
    public void setItem2(Item item2) {
        Gui.item2 = item2;
    }
    public Item getItem3() {
        return item3;
    }
    public void setItem3(Item item3) {
        Gui.item3 = item3;
    }
    public Item getItem4() {
        return item4;
    }
    public void setItem4(Item item4) {
        Gui.item4 = item4;
    }
    public boolean[] getIsRefreshing() {
        return isRefreshing;
    }
    public void setIsRefreshing(boolean isRefreshing, int sel) {
        this.isRefreshing[sel] = isRefreshing;
    }
    public Sprite[] getRefreshItem() {
        return refreshItem;
    }

    public Gui(){
        playerHealthBar = new Sprite(HealthBar);
        playerLostHealthBar = new Sprite(LostHealthBar);
        itemBox1 = new Sprite(SelectedBox);
        itemBox2 = new Sprite(ItemBox);
        itemBox3 = new Sprite(ItemBox);
        itemBox4 = new Sprite(ItemBox);
        item1 = new Fists();
        item2 = new Bow();
        item3 = new WizardStaff();
        item4 = new NullWeapon();
        refreshItem[0] = new Sprite(new Texture("refreshBox.png"));
        refreshItem[1] = new Sprite(new Texture("refreshBox.png"));
        refreshItem[2] = new Sprite(new Texture("refreshBox.png"));
        refreshItem[3] = new Sprite(new Texture("refreshBox.png"));
        refreshItem[0].setScale(0);
        refreshItem[1].setScale(0);
        refreshItem[2].setScale(0);
        refreshItem[3].setScale(0);
        isRefreshing[0] = false;
        isRefreshing[1] = false;
        isRefreshing[2] = false;
        isRefreshing[3] = false;
        Equipped = item1;
    }

    public void input(){
        /** Switching between item boxes */
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)){
            itemBox1 = new Sprite(SelectedBox);
            itemBox2 = new Sprite(ItemBox);
            itemBox3 = new Sprite(ItemBox);
            itemBox4 = new Sprite(ItemBox);
            selected = 0;
            Equipped = item1;
            pl.getPlayer().setDmg(Equipped.getDmg());
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)){
            itemBox2 = new Sprite(SelectedBox);
            itemBox1 = new Sprite(ItemBox);
            itemBox3 = new Sprite(ItemBox);
            itemBox4 = new Sprite(ItemBox);
            selected = 1;
            Equipped = item2;
            pl.getPlayer().setDmg(Equipped.getDmg());
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)){
            itemBox3 = new Sprite(SelectedBox);
            itemBox2 = new Sprite(ItemBox);
            itemBox1 = new Sprite(ItemBox);
            itemBox4 = new Sprite(ItemBox);
            selected = 2;
            Equipped = item3;
            pl.getPlayer().setDmg(Equipped.getDmg());
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)){
            itemBox4 = new Sprite(SelectedBox);
            itemBox2 = new Sprite(ItemBox);
            itemBox3 = new Sprite(ItemBox);
            itemBox1 = new Sprite(ItemBox);
            selected = 3;
            Equipped = item4;
            pl.getPlayer().setDmg(Equipped.getDmg());
        }

        /** Backpack open / close */
        if(Gdx.input.isKeyJustPressed(Input.Keys.TAB)){
            if(isBackpackOpen) {
                isBackpackOpen = false;
            }
            else {
                isBackpackOpen = true;
            }
        }


        /** Refer here to know how to remove health from player properly */
        /*if(Gdx.input.isKeyJustPressed(Input.Keys.N)){
            pl.getPlayer().setHealth(pl.getPlayer().getHealth() - 10f);
            healthBarX += ((10f / pl.getPlayer().getFullHealth()) * playerHealthBar.getWidth()) / 2;
            playerHealthBar.setScale(playerHealthBar.getScaleX() - 10f / pl.getPlayer().getFullHealth(), playerHealthBar.getScaleY());
        }*/
    }

    public void update(){

        /** Health Bar Update */
        playerHealthBar.setPosition(pl.getCamera().position.x - pl.getCamera().viewportWidth/2 + 10 - healthBarX, pl.getCamera().position.y + pl.getCamera().viewportHeight/2 - 28);
        playerLostHealthBar.setPosition(pl.getCamera().position.x - pl.getCamera().viewportWidth/2 + 10, pl.getCamera().position.y + pl.getCamera().viewportHeight/2 - 28);
        playerLostHealthBar.draw(pl.getRenderer().getBatch());
        playerHealthBar.draw(pl.getRenderer().getBatch());

        /** itemBox update */
        itemBox1.setPosition(pl.getCamera().position.x - 150, pl.getCamera().position.y - pl.getCamera().viewportHeight/2 + 70);
        itemBox2.setPosition(pl.getCamera().position.x - 50, pl.getCamera().position.y - pl.getCamera().viewportHeight/2 + 70);
        itemBox3.setPosition(pl.getCamera().position.x + 50, pl.getCamera().position.y - pl.getCamera().viewportHeight/2 + 70);
        itemBox4.setPosition(pl.getCamera().position.x + 150, pl.getCamera().position.y - pl.getCamera().viewportHeight/2 + 70);
        itemBox1.draw(pl.getRenderer().getBatch());
        itemBox2.draw(pl.getRenderer().getBatch());
        itemBox3.draw(pl.getRenderer().getBatch());
        itemBox4.draw(pl.getRenderer().getBatch());

        /** Items Update */
        item1.getSprite().setPosition(itemBox1.getX(), itemBox1.getY());
        item2.getSprite().setPosition(itemBox2.getX(), itemBox2.getY());
        item3.getSprite().setPosition(itemBox3.getX(), itemBox3.getY());
        item4.getSprite().setPosition(itemBox4.getX(), itemBox4.getY());
        item1.getSprite().draw(pl.getRenderer().getBatch());
        item2.getSprite().draw(pl.getRenderer().getBatch());
        item3.getSprite().draw(pl.getRenderer().getBatch());
        item4.getSprite().draw(pl.getRenderer().getBatch());

        /** Handle the refresh of items */
        refreshItem[0].setPosition(itemBox1.getX(), itemBox1.getY());
        refreshItem[1].setPosition(itemBox2.getX(), itemBox2.getY());
        refreshItem[2].setPosition(itemBox3.getX(), itemBox3.getY());
        refreshItem[3].setPosition(itemBox4.getX(), itemBox4.getY());
        refreshItem[0].draw(pl.getRenderer().getBatch());
        refreshItem[1].draw(pl.getRenderer().getBatch());
        refreshItem[2].draw(pl.getRenderer().getBatch());
        refreshItem[3].draw(pl.getRenderer().getBatch());
        if(isRefreshing[0] && System.currentTimeMillis() > time1){
            refreshItem[0].setScale(refreshItem[0].getScaleX() - .1f, refreshItem[0].getScaleY() - .1f);
            time1 = System.currentTimeMillis() + 10;
            if (refreshItem[0].getScaleX() <= 0) isRefreshing[0] = false;
        }
        if(isRefreshing[1] && System.currentTimeMillis() > time2){
            refreshItem[1].setScale(refreshItem[1].getScaleX() - .1f, refreshItem[1].getScaleY() - .1f);
            time2 = System.currentTimeMillis() + 10;
            if (refreshItem[1].getScaleX() <= 0) isRefreshing[1] = false;
        }
        if(isRefreshing[2] && System.currentTimeMillis() > time3){
            refreshItem[2].setScale(refreshItem[2].getScaleX() - .1f, refreshItem[2].getScaleY() - .1f);
            time3 = System.currentTimeMillis() + 10;
            if (refreshItem[2].getScaleX() <= 0) isRefreshing[2] = false;
        }
        if(isRefreshing[3] && System.currentTimeMillis() > time4){
            refreshItem[3].setScale(refreshItem[3].getScaleX() - .1f, refreshItem[3].getScaleY() - .1f);
            time4 = System.currentTimeMillis() + 10;
            if (refreshItem[3].getScaleX() <= 0) isRefreshing[3] = false;
        }



        /** Backpack draw */
        if(isBackpackOpen){
            backpack.input();
            backpack.draw();
        }

    }
}
