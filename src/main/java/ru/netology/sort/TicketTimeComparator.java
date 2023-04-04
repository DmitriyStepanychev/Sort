package ru.netology.sort;

import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
//    public int compare(Ticket t1, Ticket t2) {
//        if ((t1.getTimeTo() - t1.getTimeFrom()) < (t2.getTimeTo() - t2.getTimeFrom())) {
//            return -1;
//        } else if ((t1.getTimeTo() - t1.getTimeFrom()) > (t2.getTimeTo() - t2.getTimeFrom())) {
//            return 1;
//        } else return 0;

    public int compare(Ticket t1, Ticket t2) {
        int timeFlight1 = t1.getTimeTo() - t1.getTimeFrom();
        int timeFlight2 = t2.getTimeTo() - t2.getTimeFrom();
        if (timeFlight1 < timeFlight2) {
            return -1;
        } else if (timeFlight1 > timeFlight2) {
            return 1;
        } else return 0;
    }
}
