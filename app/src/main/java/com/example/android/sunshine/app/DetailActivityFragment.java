package com.example.android.sunshine.app;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        Intent intent = getActivity().getIntent();
        String forecast = intent.getStringExtra(Intent.EXTRA_TEXT);

        TextView dayView = (TextView) rootView.findViewById(R.id.textDay);
        TextView dateView = (TextView) rootView.findViewById(R.id.textDate);
        TextView highView = (TextView) rootView.findViewById(R.id.textHigh);
        TextView lowView = (TextView) rootView.findViewById(R.id.textLow);
        TextView weatherView = (TextView) rootView.findViewById(R.id.textWeather);

        dayView.setText(getDay(forecast));
        dateView.setText(getDate(forecast));

        /*parsing forecast for weather*/
        String[] forecastSplit = forecast.split("-");
        weatherView.setText(forecastSplit[1].trim());

        /*parsing for high and low temps*/
        String[] temps = forecastSplit[2].split("/");
        highView.setText(temps[0]);
        lowView.setText(temps[1]);

        return rootView;
    }

    private String getDay(String forecast) {
        String day = forecast.substring(0, 3);

        switch(day) {
            case "Mon":
                day = "Monday";
                break;
            case "Tue":
                day = "Tuesday";
                break;
            case "Wed":
                day = "Wednesday";
                break;
            case "Thu":
                day = "Thursday";
                break;
            case "Fri":
                day = "Friday";
                break;
            case "Sat":
                day = "Saturday";
                break;
            case "Sun":
                day = "Sunday";
                break;
            default:
                day = "error";
                break;
        }

        return day;
    }

    private StringBuffer getDate(String forecast) {
        String month = forecast.substring(4, 7);
        StringBuffer date = new StringBuffer();

        switch(month) {
            case "Jan":
                date.append("January");
                break;
            case "Feb":
                date.append("February");
                break;
            case "Mar":
                date.append("March");
                break;
            case "Apr":
                date.append("April");
                break;
            case "May":
                date.append("May");
                break;
            case "Jun":
                date.append("June");
                break;
            case "Jul":
                date.append("July");
                break;
            case "Aug":
                date.append("August");
                break;
            case "Sep":
                date.append("September");
                break;
            case "Oct":
                date.append("October");
                break;
            case "Nov":
                date.append("November");
                break;
            case "Dec":
                date.append("December");
                break;
            default:
                return null;
        }

        date.append(" ");
        date.append(forecast.substring(8, 10));
        return date;
    }
}
