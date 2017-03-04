package org.clayman.hollow.datamodel;

import java.time.ZonedDateTime;

public class Event {

    private String title;
    private String description;
    private ZonedDateTime eventDateTime;
    private Long ticketPrice;
    private Long ticketsLeft;

    public Event() {}

    public Event(String title, String description, ZonedDateTime eventDateTime, Long ticketPrice, Long ticketsLeft) {
        this.title = title;
        this.description = description;
        this.eventDateTime = eventDateTime;
        this.ticketPrice = ticketPrice;
        this.ticketsLeft = ticketsLeft;
    }

    public String getTitle() {
        return title;
    }

    public Event setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Event setDescription(String description) {
        this.description = description;
        return this;
    }

    public ZonedDateTime getEventDateTime() {
        return eventDateTime;
    }

    public Event setEventDateTime(ZonedDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
        return this;
    }

    public Long getTicketPrice() {
        return ticketPrice;
    }

    public Event setTicketPrice(Long ticketPrice) {
        this.ticketPrice = ticketPrice;
        return this;
    }

    public Long getTicketsLeft() {
        return ticketsLeft;
    }

    public Event setTicketsLeft(Long ticketsLeft) {
        this.ticketsLeft = ticketsLeft;
        return this;
    }
}
