package com.example.bones;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Personaje {
    @PrimaryKey(autoGenerate = true)
    int id;
    String nombre, class1, class2, damage;
    int calidad, hp, atk, def, cost, res, block, redeploy, img;
    float interval;

    public Personaje(int id, String nombre, String class1, String class2, String damage, int calidad, int hp, int atk, int def, int cost, int res, int block, int redeploy, int img, float interval) {
        this.id = id;
        this.nombre = nombre;
        this.class1 = class1;
        this.class2 = class2;
        this.damage = damage;
        this.calidad = calidad;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.cost = cost;
        this.res = res;
        this.block = block;
        this.redeploy = redeploy;
        this.img = img;
        this.interval = interval;
    }
}
