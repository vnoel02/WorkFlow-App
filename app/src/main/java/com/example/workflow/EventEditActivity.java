package com.example.workflow;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

public class EventEditActivity extends AppCompatActivity
{
    private EditText eventNameET;
    private TextView eventDateTV, eventTimeTV;

   // private Button deleteButton;
    private Event selectedEvent;
    private LocalTime time;

    Button timeButton;
    int hour, minute;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_edit);
        initWidgets();
        time = LocalTime.now();
        eventDateTV.setText("Date: " + CalendarUtils.formattedDate(CalendarUtils.selectedDate));
        eventTimeTV.setText("Time: " + CalendarUtils.formattedTime(time));
        timeButton = findViewById(R.id.eventTimeTV);
        checkForEditNote();
    }

    private void checkForEditNote() {
        Intent previousintent = getIntent();

        int passedEventID = previousintent.getIntExtra(Event.Event_Edit_Extra, -1);
        selectedEvent = Event.getEventForID(passedEventID);

        if(selectedEvent != null){
            eventNameET.setText(selectedEvent.getName());
            eventDateTV.setText("Date: " +  CalendarUtils.formattedDate(selectedEvent.getDate()));
            eventTimeTV.setText("Time: " +  CalendarUtils.formattedTime(time));
        }
//        else {
//            deleteButton.setVisibility(View.INVISIBLE);
//        }
    }

    public void popTimePicker(View view){
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                hour = selectedHour;
                minute = selectedMinute;
                timeButton.setText(String.format(Locale.getDefault(), "%02d:%02d",hour, minute));
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, /*style,*/ onTimeSetListener, hour, minute, false);

        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }
    private void initWidgets()
    {
        eventNameET = findViewById(R.id.eventNameET);
        eventDateTV = findViewById(R.id.eventDateTV);
        eventTimeTV = findViewById(R.id.eventTimeTV);
       // deleteButton = findViewById(R.id.deleteNoteButton);
    }

    public void saveEventAction(View view)
    {

        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
        String eventName = eventNameET.getText().toString();
        time = LocalTime.parse(timeButton.getText().toString());
        if(selectedEvent == null) {
            int id = Event.eventsList.size();
            Event newEvent = new Event(id, eventName, CalendarUtils.selectedDate, time);
            Event.eventsList.add(newEvent);
            sqLiteManager.addEventToDatabase(newEvent);
        } else {
            selectedEvent.setName(eventName);
            selectedEvent.setDate(CalendarUtils.selectedDate);
            selectedEvent.setTime(time);
            sqLiteManager.updateEventInDB(selectedEvent);
        }
            finish();
    }

//    public void deleteEventAction(View view){
//        LocalDate date = LocalDate.now();
//      //  selectedEvent.setDeleted(date);
//        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
//        sqLiteManager.updateEventInDB(selectedEvent);
//        finish();
//    }
}