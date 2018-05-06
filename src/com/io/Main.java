/**
 * UNIVERSIDAD DE COSTA RICA
 * ESCUELA DE CIENCIAS DE LA COMPUTACIÓN E INFORMÁTICA
 * INVESTIGACIÓN DE OPERACIONES
 * SOLUCIÓN A LA PRÁCTICA #2
 * @author CARLOS A. DELGADO ROJAS (B52368)
 */

package com.io;

import java.util.List;

import static com.io.Kind.*;

public class Main {

    public void run(){
        // this sim use 2 servers
        System sim = new System(2);
        java.lang.System.out.println("Simulator with 2 servers has been generated!");
        java.lang.System.out.println();

        sim.addEvent(new Event(ARRIVAL, 0));// the beginning of the sim
        Event e;
        int clientsAttended = 0;
        while(clientsAttended<15) { //we will serve 15 clients / calls
            e = sim.getEvent();
            sim.setClock(e.getTime());
            java.lang.System.out.println("CLOCK TIME: " + sim.getClock());
            if (e.getKind().equals(ARRIVAL)) {
                if (sim.isFull()) {
                    sim.increaseClientsWaiting();
                    java.lang.System.out.println("Call added to the queue");
                } else {
                    sim.increaseClientsBeingAttended();
                    sim.addEvent(new Event(DEPARTURE, Random.generateDepartureTime(sim.getClock())));
                    java.lang.System.out.println("Call has been attended...");
                }
                sim.addEvent(new Event(ARRIVAL, Random.generateArrivalTime(sim.getClock())));
            } else { // case that we have departure
                if (sim.areClientsWaiting()) {
                    sim.decreaseClientsWaiting();
                    java.lang.System.out.println("Call finished");
                    clientsAttended++;
                    sim.addEvent(new Event(DEPARTURE, Random.generateDepartureTime(sim.getClock())));
                } else {
                    sim.decreaseClientsBeingAttended();
                    java.lang.System.out.println("Call finished ");
                    clientsAttended++;
                }
            }
            java.lang.System.out.println("Calls being attended: " + sim.getClientsBeingAttended());
            java.lang.System.out.println("Calls in queue: " + sim.getClientsWaiting());
            sim.printListOfEvents();
            java.lang.System.out.println();
        }
        java.lang.System.out.println("STATICS AT THE END OF SIMULATION");
        java.lang.System.out.println("Clients attended: " + clientsAttended);
        java.lang.System.out.println("Clients waiting in queue: " + sim.getClientsWaiting());
        java.lang.System.out.println("Average time in queue: " + sim.getAverageTimeInQueue());
    }

    public static void main(String[] args) {
        Main test = new Main();
        test.run();
        java.lang.System.out.println();
        java.lang.System.out.println("Carlos Delgado Rojas. Software developed for academic purposes. 2018.");
    }
}