package love.iloveworld.continent.capability;

import net.minecraft.nbt.CompoundTag;

public class PlayerProperties {

    private float moisture;
    private float spirit;
    private float immunity;

    public PlayerProperties() {
        this.moisture = 100;
        this.spirit = 100;
        this.immunity = 100;
    }

    public float getMoisture() {
        return moisture;
    }

    public void setMoisture(float moisture) {
        this.moisture = moisture;
    }

    public float getSpirit() {
        return spirit;
    }

    public void setSpirit(float spirit) {
        this.spirit = spirit;
    }

    public float getImmunity() {
        return immunity;
    }

    public void setImmunity(float immunity) {
        this.immunity = immunity;
    }

    public void grow(float immunity) {
        this.immunity += immunity;
    }

    public void shrink(float immunity) {
        this.grow(-immunity);
    }
    public void add(float immunity){
        this.grow(immunity);
    }

    //存储数据
    public void saveData(CompoundTag tag){
        tag.putFloat("moisture", moisture);
        tag.putFloat("spirit", spirit);
        tag.putFloat("immunity", immunity);
    }

    //加载数据
    public void loadData(CompoundTag tag){
        moisture = tag.getFloat("moisture");
        spirit = tag.getFloat("spirit");
        immunity = tag.getFloat("immunity");
    }
}
