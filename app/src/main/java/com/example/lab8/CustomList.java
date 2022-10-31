package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * this gets size of the list
     * @return the size of the list
     */
    public int getCount(){
        return cities.size();
    }

    /**
     * this adds a city object to the list
     *for the first phase it will be empty
     * @param city the city to be added
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * When given a city, return whether or not it belongs in the list
     * @param city the city
     * @return the result
     */
    public boolean hasCity(City city){
        for(City c : cities){
            if(c.getCityName().equals(city.getCityName()) &&
                    c.getProvinceName().equals(city.getProvinceName())){
                return true;
            }
        }
        return false;
    }

    /**
     * Check if a city is present in the list. If it does then remove it from the list,
     * if not then throw an exception
     * @param city the city to be deleted
     */
    public void delete(City city){
        for(City c : cities){
            if(c.getCityName().equals(city.getCityName()) &&
                    c.getProvinceName().equals(city.getProvinceName())){
                // Remove this city
                cities.remove(c);
                return;
            }
        }
        // Throw an exception
        throw new RuntimeException("Not found the city.");
    }

    /**
     * Return how many cities are in the list
     * @return the number of cities
     */
    public int countCities(){
        return 0;
    }

}
