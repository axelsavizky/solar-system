package com.axelsavizky.model;

import java.util.EnumMap;

public class ForecastOutput {
    private int maxRainyDay;
    private EnumMap<Forecast, Integer> forecasts;

    public ForecastOutput() {
        this.forecasts = new EnumMap<>(Forecast.class);
        this.maxRainyDay = -1;
    }


    public void addForecast(Forecast forecast) {
        Integer count = this.forecasts.getOrDefault(forecast, 0);

        this.forecasts.put(forecast, count + 1);
    }

    public int getMaxRainyDay() {
        return maxRainyDay;
    }

    public void setMaxRainyDay(int maxRainyDay) {
        this.maxRainyDay = maxRainyDay;
    }

    public EnumMap<Forecast, Integer> getForecasts() {
        return forecasts;
    }

    public void setForecasts(EnumMap<Forecast, Integer> forecasts) {
        this.forecasts = forecasts;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("In the following 10 years there will be: \n");

        this.forecasts.keySet().forEach(forecast -> {
            int quantityForecastPeriods = forecasts.getOrDefault(forecast, 0);
            String periodWord = quantityForecastPeriods == 1 ? "period" : "periods";

            stringBuilder.append(quantityForecastPeriods).append(" ").append(periodWord).append(" of ").append(forecast.name())
                    .append(".\n");
        });

        if (this.maxRainyDay >= 0) {
            stringBuilder.append("And the maximum peak of rain will be ").append(this.maxRainyDay).append(".");
        }

        return stringBuilder.toString();
    }
}
