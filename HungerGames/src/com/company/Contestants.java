package com.company;

import java.util.ArrayList;

public class Contestants {

    private String name;
    char gender;
    private String type;
    private double attack_level;
    private double defense_level;
    private double health_level;
    private double chance;
    private double bonus;

    public Contestants(String name, char gender, double attack_level, double defense_level, double health_level, double chance, double bonus) {
        this.name = name;
        this.gender = gender;
        this.attack_level = attack_level;
        this.defense_level = defense_level;
        this.health_level = health_level;
        this.chance = chance;
        this.bonus = bonus;
    }

    public Contestants(String type){this.type = type;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public double getAttack_level() {return attack_level;}

    public void setAttack_level(double attack_level) {this.attack_level = attack_level;}

    public double getDefense_level() {return defense_level;}

    public void setDefense_level(double defense_level) {this.defense_level = defense_level;}

    public double getHeath_level() {return health_level;}

    public void setHeath_level(double heath_level) {this.health_level = heath_level;}

    public double getChance() {return chance;}

    public void setChance(double chance) {this.chance = chance;}

    public double getHealth_level() {return health_level;}

    public void setHealth_level(double health_level) {this.health_level = health_level;}

    public String getType() {return type;}

    public void setType(String type) {this.type = type;}

    public double getBonus() {return bonus;}

    public void setBonus(double bonus) {this.bonus = bonus;}

    @Override
    public String toString() {
        return "contestants{" +
                "name='" + name + '\'' +
                '}';
    }
}
