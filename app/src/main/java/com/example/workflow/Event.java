package com.example.workflow;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Event
{
    private int id;
    private String name;
    private LocalDate date;
    private LocalTime time;

  //  private LocalDate deleted;
    public static ArrayList<Event> eventsList = new ArrayList<>();

    public static String Event_Edit_Extra = "eventEdit";
    public static ArrayList<Event> eventsForDate(LocalDate date)
    {
        ArrayList<Event> events = new ArrayList<>();

        for(Event event : eventsList)
        {
            if(event.getDate().equals(date))
                events.add(event);
        }

        return events;
    }

    public static ArrayList<Event> eventsForDateAndTime(LocalDate date, LocalTime time)
    {
        ArrayList<Event> events = new ArrayList<>();

        for(Event event : eventsList)
        {
            int eventHour = event.time.getHour();
            int cellHour = time.getHour();
            if(event.getDate().equals(date) && eventHour == cellHour)
                events.add(event);
        }

        return events;
    }

//    public static ArrayList<Event> nonDeletedEvents(){
//        ArrayList<Event> nonDeleted = new ArrayList<>();
//        for(Event event: eventsList){
//            if(event.getDeleted() == null){
//                nonDeletedEvents().add(event);
//            }
//        }
//        return nonDeleted;
//    }

    public static boolean hasEvents(LocalDate date){
        if (eventsList.isEmpty())
            return false;
        return true;
    }


    public Event(int id, String name, LocalDate date, LocalTime time)
    {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
       // deleted = null;
    }
    public Event(int id, String name, LocalDate date, LocalTime time, LocalDate deleted)
    {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
       // this.deleted = deleted;
    }

    public static Event getEventForID(int passedEventID) {
        for (Event event : eventsList){
            if(event.getId() == passedEventID)
                return event;
        }
        return null;
    }

    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public LocalTime getTime()
    {
        return time;
    }

    public void setTime(LocalTime time)
    {
        this.time = time;
    }
//    public LocalDate getDeleted()
//    {
//        return deleted;
//    }
//    public void setDeleted(LocalDate deleted)
//    {
//        this.deleted = deleted;
//    }
}

