package pl.edu.pg.eti.ksg.po.lab1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Mage implements Comparable<Mage>{
    private String name;
    private int level;
    private double power;
    private Set<Mage> apprentices;

    public Mage(String name, int level, double power, String method){
        this.name = name;
        this.level = level;
        this.power = power;

        initializeApprentices(method);
    }

    public void initializeApprentices (String method) {
        if (method == "brak"){
            apprentices = new HashSet<>();
        }else
        if (method == "natural"){
            apprentices = new TreeSet<>();
        }else
        if (method == "alternatywa"){
            apprentices = new TreeSet<>(new MageComparator());
        }
    }

    public void addApprentice(Mage mage){
        apprentices.add(mage);
    }

    public int apprenticeCounter(){
        int ret = 0;
        for(Mage mage : apprentices){
            ret += mage.apprenticeCounter() + 1;
        }
        return ret;
    }

    public String getName() {
        return name;
    }

    public double getPower() {
        return power;
    }

    public int getLevel() {
        return level;
    }

    public void print(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }

        System.out.println(this);

        for (Mage mage : apprentices){
            mage.print(level + 1);
        }

    }

    @Override
    public boolean equals(Object other){
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }

        Mage mage = (Mage) other;
        return level == mage.level
                && power == mage.power
                && Objects.equals(name, mage.name);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + level + Double.hashCode(power);
        return result;
    }

    @Override
    public int compareTo(Mage other) {
        int ret = name.compareTo(other.name);
        if ( ret != 0 ) {
            return ret;
        }
        ret = Integer.compare(level,other.level);
        if ( ret != 0 ) {
            return ret;
        }
        return Double.compare(power,other.power);
    }

    @Override
    public String toString(){
        return "Mage{ name = '" + name + "', level = " + level + ", power = " + power + " }";
    }


}