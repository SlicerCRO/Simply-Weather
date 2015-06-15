package com.example.vjezbaa6_1.activities;

import com.example.vjezbaa6_1.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailedForecast extends Activity{
	TextView tvMain, tvDescription, tvDayTemperature, tvMax, tvMin, tvDateTime, tvSunrise, tvSunset, tvPressure, tvHumidity, tvWindSpeed, tvWindDeg, tvClouds, tvRain, tvSnow;
	ImageView ivIcon;
	String iconDrawn, main, description, temperature, max, min, datetime, sunrise, sunset, pressure, humidity, windspeed, winddeg, clouds, rain, snow, dayinweek, icon; 

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_currentforecast);
		tvMain = (TextView) this.findViewById(R.id.tvMain);
		tvDescription = (TextView) this.findViewById(R.id.tvDescription);
		tvDayTemperature = (TextView) this.findViewById(R.id.tvDayTemperature);
		tvMax = (TextView) this.findViewById(R.id.tvMax);
		tvSunrise = (TextView) this.findViewById(R.id.tvSunrise);
		tvSunset = (TextView) this.findViewById(R.id.tvSunset);
		tvPressure = (TextView) this.findViewById(R.id.tvPressure);
		tvHumidity = (TextView) this.findViewById(R.id.tvHumidity);
		tvWindSpeed = (TextView) this.findViewById(R.id.tvWindSpeed);
		tvWindDeg = (TextView) this.findViewById(R.id.tvWindDeg);
		tvClouds = (TextView) this.findViewById(R.id.tvClouds);
		tvRain = (TextView) this.findViewById(R.id.tvRain);
		tvSnow = (TextView) this.findViewById(R.id.tvSnow);
		tvDateTime = (TextView) this.findViewById(R.id.tvDateTime);
		ivIcon = (ImageView) this.findViewById(R.id.ivIcon);
		
		Intent i = getIntent();
		main=i.getStringExtra("main");
		description=i.getStringExtra("description");
		temperature=i.getStringExtra("temperature");
		max=i.getStringExtra("max");
		min=i.getStringExtra("min");
		datetime=i.getStringExtra("datetime");
		sunrise=i.getStringExtra("sunrise");
		sunset=i.getStringExtra("sunset");
		pressure=i.getStringExtra("pressure");
		humidity=i.getStringExtra("humidity");
		windspeed=i.getStringExtra("windspeed");
		winddeg=i.getStringExtra("winddeg");
		clouds=i.getStringExtra("clouds");
		rain=i.getStringExtra("rain");
		snow=i.getStringExtra("snow");
		dayinweek=i.getStringExtra("dayinweek");
		icon=i.getStringExtra("icon");
		drawIcon(icon);
	}
	


	private void drawIcon(String icon) {
		int imageResource = 0;
		if(iconDrawn.equals("01d")){
			imageResource = R.drawable.clear;		    
			Drawable image = getResources().getDrawable(imageResource);
			ivIcon.setImageDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("01n")){
			imageResource = R.drawable.clear_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			ivIcon.setImageDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("02d")){
			imageResource = R.drawable.few_clouds;		    
			Drawable image = getResources().getDrawable(imageResource);
			ivIcon.setImageDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("02n")){
			imageResource = R.drawable.few_clouds_n;		    
			Drawable image = getResources().getDrawable(imageResource);
			ivIcon.setImageDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("03d")){
			imageResource = R.drawable.scattered_clouds;			    
			Drawable image = getResources().getDrawable(imageResource);
			ivIcon.setImageDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("03n")){
			imageResource = R.drawable.scattered_clouds_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			ivIcon.setImageDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("04d")){
			imageResource = R.drawable.broken_clouds;			    
			Drawable image = getResources().getDrawable(imageResource);
			ivIcon.setImageDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("04n")){
			imageResource = R.drawable.broken_clouds_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			ivIcon.setImageDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("09d")){
			imageResource = R.drawable.shower_rain;			    
			Drawable image = getResources().getDrawable(imageResource);
			ivIcon.setImageDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("09n")){
			imageResource = R.drawable.shower_rain_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			ivIcon.setImageDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("10d")){
			imageResource = R.drawable.rain;			    
			Drawable image = getResources().getDrawable(imageResource);
			ivIcon.setImageDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("10n")){
			imageResource = R.drawable.rain;			    
			Drawable image = getResources().getDrawable(imageResource);
			ivIcon.setImageDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("11d")){
			imageResource = R.drawable.thunderstorm;		    
			Drawable image = getResources().getDrawable(imageResource);
			ivIcon.setImageDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("11n")){
			imageResource = R.drawable.thunderstorm_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			ivIcon.setImageDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("13d")){
			imageResource = R.drawable.snow;			    
			Drawable image = getResources().getDrawable(imageResource);
			ivIcon.setImageDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("13n")){
			imageResource = R.drawable.snow_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			ivIcon.setImageDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("50d")){
			imageResource = R.drawable.mist;			    
			Drawable image = getResources().getDrawable(imageResource);
			ivIcon.setImageDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("50n")){
			imageResource = R.drawable.mist_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			ivIcon.setImageDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
	}
	

}

