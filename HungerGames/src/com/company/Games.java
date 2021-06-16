package com.company;

import java.util.ArrayList;

public class Games {
    int no_contestants = 24;
    ArrayList<Contestants> contestants = new ArrayList<>(24);

    public void getWinner (Contestants c1, Contestants c2){
        double attack = c1.getAttack_level() - c2.getAttack_level();
        if (healthLevelCheck(c1,c2)) {
            if (attack > 0) {
                c2.setHealth_level(c2.getHealth_level()-3);
                c1.setHealth_level(c1.getHealth_level()-3);
                if(c1.getHealth_level()>0)
                    {System.out.println("The winner is: " + c1.toString()); }
                else if (c2.getHealth_level()>0 && c1.getHealth_level()<0){
                    System.out.println("The winner is: " + c2.toString());
                } else System.out.println("Both contestants died in this round.");
            }
            else if (attack < 0) {
                c2.setHealth_level(c2.getHealth_level() - 3);
                c1.setHealth_level(c1.getHealth_level() - 3);
                if (c2.getHealth_level() > 0) {
                    System.out.println("The winner is: " + c2.toString());
                } else if (c1.getHealth_level() > 0 && c2.getHealth_level() < 0) {
                    System.out.println("The winner is: " + c1.toString());
                } else System.out.println("Both contestants died in this round.");
            }
            else System.out.println("The competition is tight.");
        } else System.out.println("Error in getting winner.");
        System.out.println("After the fight, the health level of two contestants are: " + c1.getHealth_level() + " ; " + c2.getHealth_level());
    }

//    public String getWinner(Contestants contestant1, Contestants contestant2) {
//        double attack = contestant1.getAttack_level() - contestant2.getAttack_level();
//        double defense = contestant1.getDefense_level() - contestant2.getDefense_level();
//
//        if ((attack >= 0) && (defense >= 0) && healthLevelCheck(contestant1, contestant2)) {
//            contestant1.setHealth_level(contestant1.getHealth_level()-contestant2.getAttack_level());
//            contestant2.setHealth_level(contestant2.getHealth_level()-contestant1.getAttack_level());
//            if (contestant2.getHealth_level()<=0) kills(contestant2);
//            return contestant1.toString();
//        } else if ((attack <= 0) && (defense <= 0) && healthLevelCheck(contestant1, contestant2)) {
//            contestant1.setHealth_level(contestant1.getHealth_level() - contestant2.getAttack_level());
//            contestant2.setHealth_level(contestant2.getHealth_level() - contestant1.getAttack_level());
//            if (contestant2.getHealth_level()<=0) kills(contestant1);
//            return contestant2.toString();
//        } else if ((attack >= 0) && (defense <= 0) && healthLevelCheck(contestant1, contestant2)){
//            contestant1.setHealth_level(contestant1.getHealth_level() - contestant2.getAttack_level());
//            contestant2.setHealth_level(contestant2.getHealth_level() - contestant1.getAttack_level());
//            contestant1.setChance(contestant1.getChance()-0.1);   //Less chance to get bonus due to low defense level
//            if (contestant2.getHealth_level()<=0) kills(contestant2);
//            return contestant1.toString();
//        } else if ((attack <= 0) && (defense >= 0) && healthLevelCheck(contestant1, contestant2)){
//            contestant1.setHealth_level(contestant1.getHealth_level() - contestant2.getAttack_level());
//            contestant2.setHealth_level(contestant2.getHealth_level() - contestant1.getAttack_level());
//            contestant2.setChance(contestant1.getChance()-0.1);   //Less chance to get bonus due to low defense level
//            if (contestant2.getHealth_level()<=0) kills(contestant1);
//            return contestant2.toString();
//        } else if ((attack == 0) && (defense == 0)) {
//            if (contestant1.getHealth_level()<=0) kills(contestant1);
//            if (contestant2.getHealth_level()<=0) kills(contestant2);
//            return "The competition is tight!";
//
//        }
//        else if (!healthLevelCheck(contestant1, contestant2)) {
//            if (contestant1.getHealth_level()<=0) kills(contestant1);
//            if (contestant2.getHealth_level()<=0) kills(contestant2);
//            return "The competition can not continue!";

//        }
//        else {
//            return "Error in getting winner";
//
//        }
//    }

        public boolean healthLevelCheck(Contestants c1, Contestants c2) {
            if ((c1.getHealth_level() > 0) || (c2.getHealth_level() > 0)) {
                return true;
            } else if ((c1.getHealth_level() <= 0) && (c2.getHealth_level() <= 0)) {
                return false;
            } else return true;
        }

        public boolean kills(Contestants contestant){
            if (contestant.getHealth_level() <= 0) {
                contestants.remove(contestant);
                no_contestants -=1;
                return true;
            }else return false;
    }


    public Contestants getBonus(Contestants contestant){
            if((contestant.getType() == "Careers")&&Chance(contestant)) {
                contestant.setAttack_level(contestant.getAttack_level()+contestant.getBonus());
                return contestant;
            }else if ((contestant.getType() == "District")&&Chance(contestant)){
                contestant.setDefense_level(contestant.getDefense_level()+contestant.getBonus());
                return contestant;
            } else {
                return null;
            }
    }

    public boolean Chance(Contestants contestant){
        if (contestant.getChance() > 0.5) {
            return true;
        } else return false;
    }

    public boolean lastFighter(){
        if (no_contestants == 1) {
            return false;
        } else return true;
    }



}
