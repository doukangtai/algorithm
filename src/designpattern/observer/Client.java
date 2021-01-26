package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/01/26
 */
public class Client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        weatherData.setMeasurements(1, 2, 3);
        weatherData.setMeasurements(3, 2, 1);
    }
}

class StatisticsDisplay implements Observer {
    public StatisticsDisplay(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("StatisticsDisplay -> temperature: " + temperature + " humidity: " + humidity + "pressure: " + pressure);
    }
}

class CurrentConditionsDisplay implements Observer {
    public CurrentConditionsDisplay(Subject subject) {
        subject.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        System.out.println("CurrentConditionsDisplay -> temperature: " + temperature + "humidity: " + humidity + "pressure: " + pressure);
    }
}

class WeatherData implements Subject {
    private List<Observer> observerList = new ArrayList<>();
    private float temperature;
    private float humidity;
    private float pressure;

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observerList.indexOf(observer);
        if (i >= 0) {
            observerList.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        observerList.forEach(observer -> observer.update(temperature, humidity, pressure));
    }
}

interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}

interface Observer {
    void update(float temperature, float humidity, float pressure);
}
