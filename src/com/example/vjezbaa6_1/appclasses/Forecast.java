package com.example.vjezbaa6_1.appclasses;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.format.DateFormat;

public class Forecast {
	String dayInWeek, hourInDay;
	String day, min, max, night, eve, morn, pressure, humidity, main, description, icon, speed, deg, clouds, rain, snow;
	Drawable drawable;
	Date dt, sunrise, sunset;
	
	public Forecast(){
		
	}

	public Forecast(String dayInWeek, String day, String min, String max, String night, String eve,
			String morn, String pressure, String humidity, String main,
			String description, String icon, Drawable drawable, String speed, String deg,
			String clouds, String rain, String snow, Date dt, Date sunrise, Date sunset) {
		super();

		this.dayInWeek = dayInWeek;
		this.dt = dt;
		this.sunrise = sunrise;
		this.sunset = sunset;
		this.day = day;
		this.min = min;
		this.max = max;
		this.night = night;
		this.eve = eve;
		this.morn = morn;
		this.pressure = pressure;
		this.humidity = humidity;
		this.main = main;
		this.description = description;
		this.icon = icon;
		this.drawable = drawable;
		this.speed = speed;
		this.deg = deg;
		this.clouds = clouds;
		this.rain = rain;
		this.snow = snow;
	}


	public String getDayInWeek() {
		return dayInWeek;
	}

	public void setDayInWeek(Timestamp ts) {
		//String diw = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z").format(ts);
		String diw = new SimpleDateFormat("EEE").format(ts);
		
		if(diw.equals("Mon"))diw="Monday";
		if(diw.equals("Tue"))diw="Tuesday";
		if(diw.equals("Wed"))diw="Wednesday";
		if(diw.equals("Thu"))diw="Thursday";
		if(diw.equals("Fri"))diw="Friday";
		if(diw.equals("Sat"))diw="Saturday";
		if(diw.equals("Sun"))diw="Sunday";
		
		
		this.dayInWeek = diw;
	}
	
	public String getHourInDay() {
		return hourInDay;
	}

	public void setHourInDay(Timestamp ts) {
		//String diw = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z").format(ts);
		String diw = new SimpleDateFormat("HH:mm").format(ts);
		this.hourInDay = diw;
	}
	
	
	
	public String getDtc() {
		String month = null;
		String dts = new SimpleDateFormat("MM").format(dt);

		if(dts.equals("01"))month="January";
		if(dts.equals("02"))month="February";
		if(dts.equals("03"))month="March";
		if(dts.equals("04"))month="April";
		if(dts.equals("05"))month="May";
		if(dts.equals("06"))month="June";
		if(dts.equals("07"))month="July";
		if(dts.equals("08"))month="August";
		if(dts.equals("09"))month="September";
		if(dts.equals("10"))month="October";
		if(dts.equals("11"))month="November";
		if(dts.equals("12"))month="December";
		
		dts = new SimpleDateFormat("dd.yyyy").format(dt);
		dts=month+" "+dts+".";
		return dts;
	}

	
	public String getDt() {
		String month = null;
		String dts = new SimpleDateFormat("MM").format(dt);
		
		if(dts.equals("01"))month="January";
		if(dts.equals("02"))month="February";
		if(dts.equals("03"))month="March";
		if(dts.equals("04"))month="April";
		if(dts.equals("05"))month="May";
		if(dts.equals("06"))month="June";
		if(dts.equals("07"))month="July";
		if(dts.equals("08"))month="August";
		if(dts.equals("09"))month="September";
		if(dts.equals("10"))month="October";
		if(dts.equals("11"))month="November";
		if(dts.equals("12"))month="December";
		
		dts = new SimpleDateFormat("dd.").format(dt);
		dts=month+" "+dts;
		return dts;	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

	public void setDt(Timestamp ts) {
		Date date = new Date(ts.getTime());
		this.dt = date;
	}
	
	public String getSunrise() {
		String sunrises = new SimpleDateFormat("HH:mm").format(sunrise);
		return sunrises;
	}

	public void setSunrise(Timestamp sunrise) {
		this.sunrise = sunrise;
	}

	public String getSunset() {
		String sunsets = new SimpleDateFormat("HH:mm").format(sunset);
		return sunsets;
	}

	public void setSunset(Timestamp sunset) {
		this.sunset = sunset;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getNight() {
		return night;
	}

	public void setNight(String night) {
		this.night = night;
	}

	public String getEve() {
		return eve;
	}

	public void setEve(String eve) {
		this.eve = eve;
	}

	public String getMorn() {
		return morn;
	}

	public void setMorn(String morn) {
		this.morn = morn;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		//this.icon = "http://openweathermap.org/img/w/"+icon+".png";
		this.icon=icon;
	}


	public Drawable getDrawable() {
		return drawable;
	}

	public void setDrawable(Drawable b) {
		this.drawable = b;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getDeg() {
		return deg;
	}

	public void setDeg(String deg) {
		
		if(deg!="NA"){
			int i = (int) Math.round(Double.parseDouble(deg));
			if((i>337 && i<=360) || (i>=0 && i<=22))deg="N - "+i+"°";		
			if(i>22 && i<=67)deg="NE - "+i+"°";		
			if(i>67 && i<=112)deg="E - "+i+"°";		
			if(i>112 && i<=157)deg="SE - "+i+"°";		
			if(i>157 && i<=202)deg="S - "+i+"°";		
			if(i>202 && i<=247)deg="SW - "+i+"°";		
			if(i>247 && i<=292)deg="W - "+i+"°";		
			if(i>292 && i<=337)deg="NW - "+i+"°";
		}		
		this.deg = deg;
	}

	public String getClouds() {
		return clouds;
	}

	public void setClouds(String clouds) {
		this.clouds = clouds;
	}

	public String getRain() {
		return rain;
	}

	public void setRain(String rain) {
		this.rain = rain;
	}

	public String getSnow() {
		return snow;
	}

	public void setSnow(String snow) {
		this.snow = snow;
	}
	
	
}
