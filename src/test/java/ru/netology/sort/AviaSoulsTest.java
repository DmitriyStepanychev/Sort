package ru.netology.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.TooManyListenersException;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {

    AviaSouls tickets = new AviaSouls();
    TicketTimeComparator timeComparator = new TicketTimeComparator();

    Ticket ticket1 = new Ticket("LED", "VVO", 41_000, 14, 23); //price: 41_000 time: 9
    Ticket ticket2 = new Ticket("LED", "VKO", 5_000, 13, 14);
    Ticket ticket3 = new Ticket("LED", "KHV", 40_000, 10, 17);
    Ticket ticket4 = new Ticket("LED", "VVO", 39_500, 6, 17);  //price: 39_500 time: 11
    Ticket ticket5 = new Ticket("LED", "MXP", 16_000, 13, 17);
    Ticket ticket6 = new Ticket("LED", "VVO", 41_000, 10, 18);  //price: 41_000 time: 8
    Ticket ticket7 = new Ticket("LED", "VVO", 91_000, 10, 17);  //price: 91_000 time: 7
    Ticket ticket8 = new Ticket("LED", "VVO", 20_000, 4, 14);  //price: 20_000 time: 10
    Ticket ticket9 = new Ticket("LED", "VVO", 50_000, 5, 14);  //price: 50_000 time: 9
    Ticket ticket10 = new Ticket("VVO", "LED", 41_000, 5, 13);


    @BeforeEach
    public void setup() {

        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);
        tickets.add(ticket9);
        tickets.add(ticket10);

    }

    @Test
    public void sortTicketByPriceOneTicket() {

        Ticket[] expected = {ticket5};
        Ticket[] actual = tickets.search("LED", "MXP");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTicketByPriceSeveralTickets() {

        Ticket[] expected = {ticket8, ticket4, ticket1, ticket6, ticket9, ticket7};
        Ticket[] actual = tickets.search("LED", "VVO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTicketByPriceNoTickets() {

        Ticket[] expected = {};
        Ticket[] actual = tickets.search("LED", "SVO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTicketsByPriceAndTimeSeveralTickets() {
        Ticket[] expected = {ticket7, ticket6, ticket1, ticket9, ticket8, ticket4};
        Ticket[] actual = tickets.searchAndSortBy("LED", "VVO", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTicketsByPriceAndTimeOneTicket() {
        Ticket[] expected = {ticket10};
        Ticket[] actual = tickets.searchAndSortBy("VVO", "LED", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTicketsByPriceAndTimeNoTicket() {
        Ticket[] expected = {};
        Ticket[] actual = tickets.searchAndSortBy("AER", "LED", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}