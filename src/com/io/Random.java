/**
 * UNIVERSIDAD DE COSTA RICA
 * ESCUELA DE CIENCIAS DE LA COMPUTACIÓN E INFORMÁTICA
 * INVESTIGACIÓN DE OPERACIONES
 * SOLUCIÓN A LA PRÁCTICA #2
 * @author CARLOS A. DELGADO ROJAS (B52368)
 */

package com.io;

/**
 * Class that provides the random generation of time
 */
public class Random {
    /**
     * Allows to get the next arrival time in clock
     * @param clock the current time in clock
     * @return the time in clock for the next arrive
     */
    public static int generateArrivalTime(int clock){
        double probability = Math.random();
        if (probability<= 0.40){
            return clock + 1;
        } else if (probability>0.75){
            return clock + 3;
        } else {
            return clock + 2;
        }
    }

    /**
     * Allows to get the next departure time in clock
     * @param clock the current time in clock
     * @return the time in clock for the next departure
     */
    public static int generateDepartureTime(int clock){
        double probability = Math.random();
        if(probability<=0.10){
            return clock + 2;
        } else if(probability <= 0.35){
            return clock + 3;
        } else if(probability <= 0.75){
            return clock + 4;
        } else if(probability <= 0.95){
            return clock + 7;
        } else {
            return clock + 10;
        }
    }
}
