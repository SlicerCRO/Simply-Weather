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
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.ListFragment;
import android.graphics.drawable.Drawable;
import android.media.ImageReader;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.vjezbaa6_1.R;
import com.example.vjezbaa6_1.activities.MainActivity;
import com.example.vjezbaa6_1.adapters.ForecastAdapter;
import com.example.vjezbaa6_1.appclasses.Forecast;

@SuppressLint("ValidFragment")
public class HourlyForecastFragment extends ListFragment {
	TextView tvWeather, tvCheck;
	ListView lvWeeklyForecast;
	ForecastAdapter myAdapter;
	ArrayList<Forecast> forecastList;
	String city, country, icon, cityForecast;
	Drawable drawable;
	int i,j;
	ImageView ivIcon;
	GetJSONTask gjt = new GetJSONTask();

	
	public HourlyForecastFragment() {
	}



	public HourlyForecastFragment(String city) {
		super();
		cityForecast=city;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
	}
	
	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		cityForecast=((MainActivity) getActivity()).getCity();
		
		/*View vs=getView();
		Spinner spinner=(Spinner) vs.findViewById(R.id.spinner);
		
		
		cityForecast = (String) spinner.getSelectedItem();*/
		Log.d("cityForecast", cityForecast);
		refreshData(lvWeeklyForecast);

		View v = inflater.inflate(R.layout.fragment_dailyforecast, null);
		
		return v;
	}
	
	
	public void refreshData(View v) {
		//cityForecast=correctHtmlCode(cityForecast);
		gjt.execute("http://api.openweathermap.org/data/2.5/forecast?q="+cityForecast+"&units=metric");

	}
	
	private void displayWeeklyForecast() {
		myAdapter = new ForecastAdapter(getActivity(), forecastList);
		lvWeeklyForecast.setAdapter(myAdapter);
	}

	private void drawIcon(Forecast f, String icon) {
		int imageResource = 0;
		if(icon.equals("01d")){
			imageResource = R.drawable.clear;		    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(icon, imageResource+"");
		}
		if(icon.equals("01n")){
			imageResource = R.drawable.clear_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(icon, imageResource+"");
		}
		if(icon.equals("02d")){
			imageResource = R.drawable.few_clouds;		    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(icon, imageResource+"");
		}
		if(icon.equals("02n")){
			imageResource = R.drawable.few_clouds_n;		    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(icon, imageResource+"");
		}
		if(icon.equals("03d")){
			imageResource = R.drawable.scattered_clouds;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(icon, imageResource+"");
		}
		if(icon.equals("03n")){
			imageResource = R.drawable.scattered_clouds_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(icon, imageResource+"");
		}
		if(icon.equals("04d")){
			imageResource = R.drawable.broken_clouds;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(icon, imageResource+"");
		}
		if(icon.equals("04n")){
			imageResource = R.drawable.broken_clouds_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(icon, imageResource+"");
		}
		if(icon.equals("09d")){
			imageResource = R.drawable.shower_rain;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(icon, imageResource+"");
		}
		if(icon.equals("09n")){
			imageResource = R.drawable.shower_rain_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(icon, imageResource+"");
		}
		if(icon.equals("10d")){
			imageResource = R.drawable.rain;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(icon, imageResource+"");
		}
		if(icon.equals("10n")){
			imageResource = R.drawable.rain_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(icon, imageResource+"");
		}
		if(icon.equals("11d")){
			imageResource = R.drawable.thunderstorm;		    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(icon, imageResource+"");
		}
		if(icon.equals("11n")){
			imageResource = R.drawable.thunderstorm_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(icon, imageResource+"");
		}
		if(icon.equals("13d")){
			imageResource = R.drawable.snow;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(icon, imageResource+"");
		}
		if(icon.equals("13n")){
			imageResource = R.drawable.snow_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(icon, imageResource+"");
		}
		if(icon.equals("50d")){
			imageResource = R.drawable.mist;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(icon, imageResource+"");
		}
		if(icon.equals("50n")){
			imageResource = R.drawable.mist_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(icon, imageResource+"");
		}
	}
	

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(gjt!=null) gjt.cancel(true);
        gjt = null;
    }

	private class GetJSONTask extends AsyncTask<String, Integer, String> {

		@Override
		protected String doInBackground(String... params) {
			// ArrayList<Forecast> list =
			// parseJsonString("http://api.openweathermap.org/data/2.5/forecast/daily?q=Osijek&units=metric&cnt=7");

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

			forecastList = parseJsonString(result);
			lvWeeklyForecast = getListView();
			
			/*ImageView ivIcon = (ImageView) lvWeeklyForecast.findViewById(R.id.ivIcon);
			
			int size=forecastList.size();
			Log.d("size", Integer.toString(size));
			/*Forecast item=new Forecast();
			item = forecastList.get(0);
			ivIcon.setImageDrawable(item.getDrawable());*/
			
			displayWeeklyForecast();
			super.onPostExecute(result);
		}

		public ArrayList<Forecast> parseJsonString(String result) {
			forecastList = new ArrayList<Forecast>();

			try {
				String text = "";
				// Kreiramo objekt na temelju stringa:
				JSONObject weather = new JSONObject(result);
				String message=weather.getString("message");
				// Dohvaæanje atributa iz objekta:
				JSONObject city = weather.getJSONObject("city");

				String name = city.getString("name");
				String country = city.getString("country");

				text += "Grad: " + name + "\nDržava: " + country + "\n";

				// Dohvaæamo objekt unutar postojeæeg JSON objekta:
				JSONObject location = city.getJSONObject("coord");

				String lon = location.getString("lon");
				String lat = location.getString("lat");
				text += "Lon: " + lon + ", Lat: " + lat + "\n";
				// tvCheck.setText("radim");
				Forecast f = new Forecast();
				j=40;
				JSONArray listarray = weather.getJSONArray("list");
				j=listarray.length();
				Log.e("listarray", "j="+j);

				for (i = 0; i < j; i++) {

					// text = readForecast(text, weather, i);
					f = readForecast(text, weather, i);

					/*f.setDayInWeek(i);
					Log.d("dayInWeek", f.getDayInWeek());*/

					forecastList.add(f);
					// this.myAdapter.notifyDataSetChanged();
					
						
				}
				// tvWeather.setText(text);
				//j=0;
				/*for(j=0;j<6;j++){
					GetImageTask git = new GetImageTask();
					git.execute();
				}*/
				
				//GetImageTask git = new GetImageTask();
				//git.execute();


			} catch (JSONException e) {
				e.printStackTrace();
			}
			return forecastList;
		}

		public Forecast readForecast(String text, JSONObject weather, int i)
				throws JSONException {
			// Log.println(i, name, "pišem");
			// tvCheck.setText("pišem");
			Forecast f = new Forecast();
			long dt;
			String dts, temp, min, max, sea, grnd, kf, pressure, humidity, main, description, icon, speed, deg, clouds, rain, snow;
			
			JSONArray listarray = weather.getJSONArray("list");
			JSONObject list = listarray.getJSONObject(i);
			dt = list.getLong("dt")*1000;
		    Log.d("dt",""+dt);
		    Timestamp tdy=new Timestamp(System.currentTimeMillis());
			//Log.d("tdy",tdy.toString());
			Timestamp ts=new Timestamp(dt);
			//Log.d("ts",ts.toString());
			f.setDayInWeek(ts);
			f.setHourInDay(ts);
			f.setDt(ts);
			JSONObject mn = list.getJSONObject("main");
			temp = mn.getString("temp");
			f.setDay(temp);
			min = mn.getString("temp_min");
			f.setMin(min);
			max = mn.getString("temp_max");
			f.setMax(max);
			// tvWeather.setText(text);
			pressure = mn.getString("pressure");
			f.setPressure(pressure);
			sea = mn.getString("sea_level");
			grnd = mn.getString("grnd_level");
			if (mn.has("temp_kf"))
				kf = mn.getString("temp_kf");
			else kf = "NA";
			humidity = mn.getString("humidity");
			f.setHumidity(humidity);
			// tvWeather.setText(text);

			// Dohvaæanje polja objekata unutar objekta:
			JSONArray weatherarray = list.getJSONArray("weather");
			JSONObject weatherobject = weatherarray.getJSONObject(0);
			main = weatherobject.getString("main");
			f.setMain(main);
			description = weatherobject.getString("description");
			f.setDescription(description);
			icon = weatherobject.getString("icon");
			f.setIcon(icon);
			drawIcon(f, icon);
			
			//Log.d("git", "i: " + i);

			// f.setDrawable(returnBitmap(f.getIcon()));

			// tvWeather.setText(text);
			JSONObject wind = list.getJSONObject("wind");
			if (wind.has("speed"))
				speed = wind.getString("speed");
			else speed = "NA";
			f.setSpeed(speed);
			if (wind.has("deg"))
				deg = wind.getString("deg");
			else deg = "NA";
			f.setDeg(deg);
			if (list.has("clouds")){
				JSONObject clds = list.getJSONObject("clouds");
				clouds = clds.getString("all");
			}
			else
				clouds = "0";
			f.setClouds(clouds);
			if (list.has("rain")){
				JSONObject rn = list.getJSONObject("rain");
				rain = rn.getString("3h");
			}
			else
				rain = "0";
			f.setRain(rain);
			if (list.has("snow")){
				JSONObject snw = list.getJSONObject("snw");
				snow = snw.getString("snow");
			}
			else
				snow = "0";
			f.setSnow(snow);
			// tvWeather.setText(text);

			return f;
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
		
		/*public class GetImageTask extends AsyncTask<Void, Integer, ArrayList<Drawable>> {

			@Override
			protected ArrayList<Drawable> doInBackground(Void... params) {
				ArrayList<Drawable> resultingList = new ArrayList<Drawable>();
				
				for(int i=0;i<j;i++){
					Forecast item = forecastList.get(i);
					try {
						// URL imageUrl = new URL(iconURL);
						// InputStream is = (InputStream) imageUrl.getContent();
						// Drawable d = Drawable.createFromStream(is, "src");
						Log.d("icon+url", icon + item.getIcon());

						Drawable b = Drawable.createFromStream((InputStream)new URL(item.getIcon()).getContent(), item.getIcon());
						item.setDrawable(b);
						//myAdapter.notifyDataSetChanged();

						
					} catch (MalformedURLException e) {
						e.printStackTrace();
						return null;
					} catch (IOException e) {
						e.printStackTrace();
						return null;
					}

				}
				return resultingList;
			}

			@Override
			protected void onPreExecute() {
				Log.d("doinback", "j: " + j);
				super.onPreExecute();
			}

			@Override
			protected void onPostExecute(ArrayList<Drawable> list) {
				myAdapter.notifyDataSetChanged();
				super.onPostExecute(list);
			}

		}*/
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
