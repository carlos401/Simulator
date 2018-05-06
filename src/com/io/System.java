/**
 * UNIVERSIDAD DE COSTA RICA
 * ESCUELA DE CIENCIAS DE LA COMPUTACIÓN E INFORMÁTICA
 * INVESTIGACIÓN DE OPERACIONES
 * SOLUCIÓN A LA PRÁCTICA #2
 * @author CARLOS A. DELGADO ROJAS (B52368)
 */

package com.io;

import java.util.Iterator;
import java.util.PriorityQueue;

public class System {
    /**
     * This queue manages all the events that the system supports
     */
    private PriorityQueue<Event> listOfEvents;

    /**
     * The number of servers defined via constructor
     */
    private int numberOfServers;

    /**
     * The number of clients being attended
     */
    private int clientsBeingAttended;

    /**
     * The number of clients in the waiting queue
     */
    private int clientsWaiting;

    /**
     * The system clock
     */
    private int clock;

    /**
     * Constructor
     * @param servers the number of servers for this system
     */
    public System(int servers){
        this.clientsWaiting = 0;
        this.clientsBeingAttended = 0;
        this.numberOfServers = servers;
        this.listOfEvents = new PriorityQueue<>();
        this.clock = 0;
    }

    /**
     * Allows to add an event to the list of events
     * @param e the event to add
     */
     public void addEvent(Event e){
        this.listOfEvents.add(e);
     }

    /**
     * Allows to get an event from the list of events
     * @return the next event using priority time and FIFO
     */
     public Event getEvent(){
        return this.listOfEvents.poll();
     }

    /**
     * Allows to know if the system is full (in terms of servers used)
     * @return true if all servers are being used, otherwise false
     */
    public boolean isFull(){
         return this.clientsBeingAttended == this.numberOfServers;
     }

    /**
     * Allows to know the number of clients in queue
     * @return the number of clients waiting in queue
     */
    public int getClientsWaiting() {
        return clientsWaiting;
    }

    /**
     * Allows to know the number of clients that are being attended
     * @return the number of clients being serve
     */
    public int getClientsBeingAttended() {
        return clientsBeingAttended;
    }

    /**
     * Allows to know if there are clients waiting in queue
     * @return true if there are at least 1 client waiting, otherwise false
     */
    public boolean areClientsWaiting(){
        return this.clientsWaiting > 0;
     }

    /**
     * Add a new client to the waiting queue
     */
    public void increaseClientsWaiting(){
        ++this.clientsWaiting;
     }

    /**
     * Serve a new client
     */
    public void increaseClientsBeingAttended(){
        ++this.clientsBeingAttended;
     }

    /**
     * Remove a client from the waiting queue
     */
    public void decreaseClientsWaiting(){
        --this.clientsWaiting;
     }

    /**
     * Remove a client from the attention phase
     */
    public void decreaseClientsBeingAttended(){
        --this.clientsBeingAttended;
    }

    /**
     * Allows to change the system clock
     * @param clock
     */
    public void setClock(int clock) {
        this.clock = clock;
    }

    /**
     * Allows to get the current system clock time
     * @return the current time in clock
     */
    public int getClock() {
        return clock;
    }

    /**
     * Prints the list of events
     */
    public void printListOfEvents(){
        Iterator<Event> ite = this.listOfEvents.iterator();
        Event e;
        java.lang.System.out.println("PRINTING LIST OF EVENTS");
        while(ite.hasNext()){
            e = ite.next();
            java.lang.System.out.println("kind: " + e.getKind() + " Time: " + e.getTime());
        }
        java.lang.System.out.println("END OF LIST OF EVENTS");
    }
}