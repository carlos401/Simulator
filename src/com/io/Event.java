/**
 * UNIVERSIDAD DE COSTA RICA
 * ESCUELA DE CIENCIAS DE LA COMPUTACIÓN E INFORMÁTICA
 * INVESTIGACIÓN DE OPERACIONES
 * SOLUCIÓN A LA PRÁCTICA #2
 * @author CARLOS A. DELGADO ROJAS (B52368)
 */

package com.io;

/**
 * This class is the generic event that could happen in the system
 */
public class Event implements Comparable<Event>{

    /**
     * Used to identify which kind of event is
     */
    private Kind kind;

    /**
     * When the event will happen?
     */
    private int time;

    /**
     * The constructor
     * @param kind defines which class of event is being creating
     * @param time defines when the event will happen
     */
    public Event(Kind kind,int time){
        this.kind = kind;
        this.time = time;
    }

    /**
     * Returns which kind of event is
     * @return the kind of event
     */
    public Kind getKind() {
        return kind;
    }

    /**
     * Returns the time clock when the event happen
     * @return the time
     */
    public int getTime() {
        return time;
    }

    @Override
    public int compareTo(Event e) {
        if (this.time<e.time){
            return -1;
        } else if (this.time==e.time){
            if (this.kind.equals(Kind.ARRIVAL)){
                return -1;
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }
}
