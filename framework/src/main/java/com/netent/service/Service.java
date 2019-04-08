package com.netent.service;

import com.netent.service.symbol.Symbol;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Random;

public class Service {

    private Random randomGenerator = new Random();
    private Symbol[] spinnerWheel = new Symbol[3];
    private  static Random rnadomeGeneratorFoSimulation = new Random();

    /**
     * Creating an enumMap for adding all the symbols to it.
     */
    private static final EnumMap<Symbol, Integer> ZERO_COUNT;


    /**
     * Initializes all the count of the Symbols to zero
     */
    static {
        ZERO_COUNT = new EnumMap<>(Symbol.class);
        for (int i = 0; i < Symbol.values().length; i++) {
            ZERO_COUNT.put(Symbol.values()[i], 0);
        }
    }


    /**
     * to spin the wheels and to generate the differnet symbols on the view
     */
    public int spin() {
        EnumMap<Symbol, Integer> symCounts = new EnumMap<>(ZERO_COUNT);
        for (int i = 0; i < spinnerWheel.length; i++) {
            int randInt = randomGenerator.nextInt(Symbol.values().length);
            this.spinnerWheel[i] = Symbol.values()[randInt];
            symCounts.put(this.spinnerWheel[i], 1 + symCounts.get(this.spinnerWheel[i]));
        }
        return payout(symCounts);
    }


    /**
     * Assumption made on the coins given base on the percentage given in the req doc
     * that is 30% winning of 20 ooins in a normal game
     */

    public int payout(EnumMap<Symbol, Integer> enumSymbol) {
        if (enumSymbol.get(Symbol.BAR) == 3) {

            return 70;
        } else if (enumSymbol.get(Symbol.BELL) == 3 ||
                enumSymbol.get(Symbol.BELL) == 2 && enumSymbol.get(Symbol.BAR) == 1) {

            return 20;
        } else if (enumSymbol.get(Symbol.PLUM) == 3 ||
                enumSymbol.get(Symbol.PLUM) == 2 && enumSymbol.get(Symbol.BAR) == 1) {

            return 20;
        } else if (enumSymbol.get(Symbol.ORANGE) == 3 ||
                enumSymbol.get(Symbol.ORANGE) == 2 && enumSymbol.get(Symbol.BAR) == 1) {

            return 20;

        }
        else if (enumSymbol.get(Symbol.LEMON) == 3 ||
                enumSymbol.get(Symbol.LEMON) == 2 && enumSymbol.get(Symbol.BAR) == 1) {

            return 20;}
        else switch (enumSymbol.get(Symbol.CHERRY)) {

            case 3:  return 20;
            case 2:  return 20;
            case 1:  return 0;
            default: return 0;
        }
    }

    /**
     * Returns the symbol on wheel 0, 1, or 2.
     */
    public Symbol spinwheel(int wheel) {
        if (wheel < 0 || wheel >= 3) {
            throw new IllegalArgumentException();
        }
        return this.spinnerWheel[wheel];
    }



    /**
     * Returns the random yes or no.
     */
    public String checkYesorNoforSImulation(){
        String input="";
        if(getRandomNumberInRange(1,10)>=5) {
            return input="Y";
        }
        else{
            return input="N";
        }

    }

    /**
     * Returns the random ynumbers between a specified range.
     */

    public int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }



    /**
     * Returns a string of the symbols on the wheels.
     */
    public String toString() {
        return this.spinwheel(0) + " " + this.spinwheel(1) + " " + this.spinwheel(2);
    }

}
