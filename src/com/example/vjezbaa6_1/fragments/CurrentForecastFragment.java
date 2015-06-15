package com.example.vjezbaa6_1.fragments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Timestamp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.vjezbaa6_1.R;
import com.example.vjezbaa6_1.activities.MainActivity;
import com.example.vjezbaa6_1.appclasses.Forecast;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class CurrentForecastFragment extends Fragment {
	TextView tvMain, tvDescription, tvDayTemperature, tvMax, tvMin, tvDateTime, tvSunrise, tvSunset, tvPressure, tvHumidity, tvWindSpeed, tvWindDeg, tvClouds, tvRain, tvSnow;
	ImageView ivIcon;
	String city, iconUrl, cityForecast, iconDrawn;
	Drawable drawable;
	Forecast forecast;
	GetJSONTask gjt = new GetJSONTask();


	public CurrentForecastFragment() {
	}

	public CurrentForecastFragment(String city) {
		super();
		Log.d(cityForecast, "city");
		cityForecast=city;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		cityForecast=((MainActivity) getActivity()).getCity();
		/*View vs = inflater.inflate(R.layout.activity_main, null);

		Spinner spinner=(Spinner) vs.findViewById(R.id.spinner);
		cityForecast = (String) spinner.getSelectedItem();*/
		
		//Log.d("prije", cityForecast);
		//refreshData();
		//Log.d("forecast.getDay()", "poslije");

		View v = inflater.inflate(R.layout.fragment_currentforecast, null);
		
		tvMain = (TextView) v.findViewById(R.id.tvMain);
		tvDescription = (TextView) v.findViewById(R.id.tvDescription);
		tvDayTemperature = (TextView) v
				.findViewById(R.id.tvDayTemperature);
		tvMax = (TextView) v.findViewById(R.id.tvMax);
		//tvMin= (TextView) v.findViewById(R.id.tvMin);
		tvSunrise = (TextView) v.findViewById(R.id.tvSunrise);
		tvSunset = (TextView) v.findViewById(R.id.tvSunset);
		tvPressure = (TextView) v.findViewById(R.id.tvPressure);
		tvHumidity = (TextView) v.findViewById(R.id.tvHumidity);
		tvWindSpeed = (TextView) v.findViewById(R.id.tvWindSpeed);
		tvWindDeg = (TextView) v.findViewById(R.id.tvWindDeg);
		tvClouds = (TextView) v.findViewById(R.id.tvClouds);
		tvRain = (TextView) v.findViewById(R.id.tvRain);
		tvSnow = (TextView) v.findViewById(R.id.tvSnow);
		tvDateTime = (TextView) v.findViewById(R.id.tvDateTime);
		ivIcon = (ImageView) v.findViewById(R.id.ivIcon);
		
		refreshData();
		

		//Drawable drawable = ImageOperations(context, iconUrl, "icon.png");
		//GetImageTask git = new GetImageTask();
		//git.execute();
		// imageUrl=forecast.getImageurl();
		//ivIcon.setImageResource(R.drawable.ic_launcher);
		//ivIcon.setImageDrawable(forecast.getDrawable());
		//iconUrl = forecast.getIcon();
	
		return v;
	}
	
	
	public void refreshData() {
		Log.d("refreshData", "prije");

		gjt.execute("http://api.openweathermap.org/data/2.5/weather?q="+cityForecast+"&units=metric");

	}


	private void drawIcon(Forecast f, String icon) {
		int imageResource = 0;
		if(iconDrawn.equals("01d")){
			imageResource = R.drawable.clear;		    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("01n")){
			imageResource = R.drawable.clear_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("02d")){
			imageResource = R.drawable.few_clouds;		    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("02n")){
			imageResource = R.drawable.few_clouds_n;		    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("03d")){
			imageResource = R.drawable.scattered_clouds;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("03n")){
			imageResource = R.drawable.scattered_clouds_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("04d")){
			imageResource = R.drawable.broken_clouds;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("04n")){
			imageResource = R.drawable.broken_clouds_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("09d")){
			imageResource = R.drawable.shower_rain;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("09n")){
			imageResource = R.drawable.shower_rain_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("10d")){
			imageResource = R.drawable.rain;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("10n")){
			imageResource = R.drawable.rain;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("11d")){
			imageResource = R.drawable.thunderstorm;		    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("11n")){
			imageResource = R.drawable.thunderstorm_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("13d")){
			imageResource = R.drawable.snow;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("13n")){
			imageResource = R.drawable.snow_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("50d")){
			imageResource = R.drawable.mist;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		if(iconDrawn.equals("50n")){
			imageResource = R.drawable.mist_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(iconDrawn, imageResource+"");
		}
		ivIcon.setImageDrawable(f.getDrawable());
	}
	
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(gjt!=null) gjt.cancel(true);
        gjt = null;
    }

	private class GetJSONTask extends AsyncTask<String, Integer, String> {
		Runnable runnable;
		Handler handler;
		
		@Override
		protected String doInBackground(String... params) {
			// ArrayList<Forecast> list =
			// parseJsonString("http://api.openweathermap.org/data/2.5/forecast/daily?q=Osijek&units=metric&cnt=7");
			Log.d("doInBack", "prije");

			URL data = null;
			BufferedReader myBR = null;
			StringBuilder mySB = null;

			try {
				data = new URL(params[0]);
				HttpURLConnection connection = (HttpURLConnection) data
						.openConnection();
				connection.setRequestMethod("GET");
				connection.setConnectTimeout(15000);
				connection.setReadTimeout(10000);
				connection.connect();

				InputStream in = connection.getInputStream();

				mySB = new StringBuilder();
				myBR = new BufferedReader(new InputStreamReader(in));
				String line;
				while ((line = myBR.readLine()) != null) {
					mySB.append(line);
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (ProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return mySB.toString();
		}

		@Override
		public void onPostExecute(String result) {

			// Toast.makeText(getApplicationContext(), result,
			// Toast.LENGTH_LONG).show();
			Log.d("onPostEx", result);

			forecast = parseJsonString(result);

			/*this.handler = new Handler();
			runnable = new Runnable() {
				@Override
				public void	run() {
				handler.postDelayed(runnable, 10000);
				}
			};
			handler.postDelayed(runnable,10000);*/
			//Log.d("f.getDay", f.getDay());

			/*ImageView ivIcon = (ImageView) lvWeeklyForecast.findViewById(R.id.ivIcon);
			
			int size=forecastList.size();
			Log.d("size", Integer.toString(size));
			/*Forecast forecast=new Forecast();
			forecast = forecastList.get(0);
			ivIcon.setImageDrawable(forecast.getDrawable());*/
			
			super.onPostExecute(result);
		}

		public Forecast parseJsonString(String result) {
			Forecast f = new Forecast();
			Log.d("parseJSON", "prije");

			try {
				// Kreiramo objekt na temelju stringa:
				JSONObject frcst = new JSONObject(result);

				// Dohvaæamo objekt unutar postojeæeg JSON objekta:
				JSONObject location = frcst.getJSONObject("coord");
				String lon = location.getString("lon");
				String lat = location.getString("lat");
				long dt, sunrise, sunset;
				String dts, temp, min, max, night, eve, morn, pressure, humidity, main, description, icon, speed, deg, clouds, rain, snow;
				JSONObject sys = frcst.getJSONObject("sys");
				sunrise=sys.getLong("sunrise")*1000;
				Timestamp srs=new Timestamp(sunrise);
				f.setSunrise(srs);
				tvSunrise.setText("Sunrise: "+f.getSunrise());
				sunset=sys.getLong("sunset")*1000;
				Timestamp sss=new Timestamp(sunset);
				f.setSunset(sss);
				tvSunset.setText("Sunset: "+f.getSunset());
				JSONArray weather = frcst.getJSONArray("weather");
				JSONObject m = weather.getJSONObject(0);
				main=m.getString("main");
				f.setMain(main);
				tvMain.setText("Currently: " + f.getMain());
				description=m.getString("description");
				f.setDescription(description);
				tvDescription.setText("Description: " + f.getDescription());
				icon=m.getString("icon");
				iconDrawn=icon;
				f.setIcon(icon);
				drawIcon(f, iconDrawn);

				iconUrl=f.getIcon();
				JSONObject mn = frcst.getJSONObject("main");
				temp=mn.getString("temp");
				f.setDay(temp);
				tvDayTemperature.setText(f.getDay() + " °C");
				pressure=mn.getString("pressure");
				f.setPressure(pressure);
				tvPressure.setText("Pressure: "+f.getPressure() + " hPa");
				humidity=mn.getString("humidity");
				f.setHumidity(humidity);
				tvHumidity.setText("Humidity: "+f.getHumidity() + " %");
				min=mn.getString("temp_min");
				f.setMin(min);
				//tvMin.setText("Min: " + f.getMin() + " °C");
				max=mn.getString("temp_max");
				f.setMax(max);
				//tvMax.setText("Max: " + f.getMax() + " °C");
				JSONObject wind = frcst.getJSONObject("wind");
				if(wind.has("speed"))
					speed=wind.getString("speed");
					
				else speed = "NA";
				f.setSpeed(speed);
				if(wind.has("deg"))
					deg=wind.getString("deg");
				else deg = "NA";
				f.setDeg(deg);
				tvWindSpeed.setText("Wind: "+f.getSpeed()+" m/s, ");
				tvWindDeg.setText(f.getDeg());
				if(frcst.has("clouds")){
					JSONObject clds = frcst.getJSONObject("clouds");
					clouds=clds.getString("all");
				}
				else clouds = "NA";
				f.setClouds(clouds);
				//tvClouds.setText("Clouds: "+f.getClouds());
				if(frcst.has("rain")){
					JSONObject rn = frcst.getJSONObject("rain");
					rain=rn.getString("3h");
				}
				else rain = "NA";
				f.setRain(rain);
				/*if(f.getRain()!="NA")
					tvRain.setText("Rain: "+f.getRain());
				else tvRain.setVisibility(View.GONE);*/
				if(frcst.has("snow")){
					JSONObject snw = frcst.getJSONObject("snow");
					snow=snw.getString("3h");
				}
				else snow = "NA";
				f.setSnow(snow);
				/*if(f.getSnow()!="NA")
					tvSnow.setText("Snow: "+f.getSnow());
				else tvSnow.setVisibility(View.GONE);*/
				dt = frcst.getLong("dt")*1000;
			    Timestamp ts=new Timestamp(dt);
				f.setDayInWeek(ts);
				f.setDt(ts);
				tvDateTime.setText(f.getDayInWeek()+", "+f.getDtc());

				Log.d(f.getDayInWeek(), temp);
				Log.d(f.getDt(), temp);
				
				
				//GetImageTask git = new GetImageTask();
				//git.execute();
				//f.setDrawable(drawable);
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return forecast;
		}

		/*public Bitmap returnBitmap(String imageUrl) {
			try {
				bitmap = BitmapFactory.decodeStream((InputStream) new URL(imageUrl).getContent());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return bitmap;
		}*/

		
		public class GetImageTask extends AsyncTask<Void, Integer, Drawable> {

			@Override
			protected Drawable doInBackground(Void... params) {
				try {
					// URL imageUrl = new URL(iconURL);
					// InputStream is = (InputStream) imageUrl.getContent();
					// Drawable d = Drawable.createFromStream(is, "src");
					//Log.d("icon+url", iconUrl + forecast.getIcon());

					Drawable b = Drawable.createFromStream((InputStream)new URL(iconUrl).getContent(), iconUrl);
					return b;
				} catch (MalformedURLException e) {
					e.printStackTrace();
					return null;
				} catch (IOException e) {
					e.printStackTrace();
					return null;
				}
			}

			@Override
			protected void onPreExecute() {
				super.onPreExecute();
			}

			@Override
			protected void onPostExecute(Drawable b) {
				//Log.e("0", forecast.getIcon());
				if (b != null) {
					drawable=b;
					ivIcon.setImageDrawable(drawable);

				} 
				super.onPostExecute(b);
			}

		}
		/*
		 * public Drawable returnDrawable(String imageUrl) { try { drawable =
		 * Drawable.createFromStream((InputStream) new
		 * URL(imageUrl).getContent(), "src name"); } catch
		 * (MalformedURLException e) { e.printStackTrace(); } catch (IOException
		 * e) { e.printStackTrace(); } System.out.println("Ovo je bitmap: " +
		 * imageUrl); return drawable; }
		 */
	}

}
