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

import com.example.vjezbaa6_1.R;
import com.example.vjezbaa6_1.activities.DetailedForecast;
import com.example.vjezbaa6_1.activities.MainActivity;
import com.example.vjezbaa6_1.adapters.ForecastAdapter;
import com.example.vjezbaa6_1.appclasses.Forecast;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class DailyForecastFragment extends ListFragment implements OnItemClickListener{
	TextView tvWeather, tvCheck;
	ListView lvWeeklyForecast;
	ForecastAdapter myAdapter;
	ArrayList<Forecast> forecastList;
	String city, country, icon, cityForecast;
	Drawable drawable;
	int i,j;
	ImageView ivIcon;
	GetJSONTask gjt = new GetJSONTask();

	
	
	public DailyForecastFragment() {
	}

	public DailyForecastFragment(String city) {
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

		//cityForecast="Osijek";
		
		/*View vs=getView();
		Spinner spinner=(Spinner) vs.findViewById(R.id.spinner);
		
		
		cityForecast = (String) spinner.getSelectedItem();*/
		cityForecast=((MainActivity) getActivity()).getCity();
		Log.d("cityForecast", cityForecast);
		refreshData(lvWeeklyForecast);
		View v = inflater.inflate(R.layout.fragment_dailyforecast, null);
		return v;
	}
	
	public void refreshData(View v) {
		//this.getActivity().getCity();
		gjt.execute("http://api.openweathermap.org/data/2.5/forecast/daily?q="+cityForecast+"&units=metric&cnt=17");
	}

	public void detailedForecast(View v){
		Fragment f = new CurrentForecastFragment(city);
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.replace(R.id.flFragmentContainer, f);
		ft.commit();
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,	long id) {
		Forecast forecast = (Forecast) lvWeeklyForecast.getItemAtPosition(position);
		//detailedForecast(parent);
		Intent i = new Intent();
        i.setClass(getActivity(), DetailedForecast.class);
        i.putExtra("main", forecast.getMain());
        i.putExtra("description", forecast.getDescription());
        i.putExtra("temperature", forecast.getDay());
        i.putExtra("max", forecast.getMax());
        i.putExtra("min", forecast.getMin());
        i.putExtra("datetime", forecast.getDtc());
        i.putExtra("sunrise", forecast.getSunrise());
        i.putExtra("sunset", forecast.getSunset());
        i.putExtra("pressure", forecast.getPressure());
        i.putExtra("humidity", forecast.getHumidity());
        i.putExtra("windspeed", forecast.getSpeed());
        i.putExtra("winddeg", forecast.getDeg());
        i.putExtra("clouds", forecast.getClouds());
        i.putExtra("rain", forecast.getRain());
        i.putExtra("snow", forecast.getSnow());
        i.putExtra("dayinweek", forecast.getDayInWeek());
        i.putExtra("icon", forecast.getIcon());
		startActivity(i);
	}
	
	private void drawIcon(Forecast f, String icon) {
		int imageResource = 0;
		if(icon.equals("01d")){
			imageResource = R.drawable.clear;		    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(i+"", j+"");
		}
		if(icon.equals("01n")){
			imageResource = R.drawable.clear_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(i+"", j+"");
		}
		if(icon.equals("02d")){
			imageResource = R.drawable.few_clouds;		    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(i+"", j+"");
		}
		if(icon.equals("02n")){
			imageResource = R.drawable.few_clouds_n;		    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(i+"", j+"");
		}
		if(icon.equals("03d")){
			imageResource = R.drawable.scattered_clouds;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(i+"", j+"");
		}
		if(icon.equals("03n")){
			imageResource = R.drawable.scattered_clouds_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(i+"", j+"");
		}
		if(icon.equals("04d")){
			imageResource = R.drawable.broken_clouds;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(i+"", j+"");
		}
		if(icon.equals("04n")){
			imageResource = R.drawable.broken_clouds_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(i+"", j+"");
		}
		if(icon.equals("09d")){
			imageResource = R.drawable.shower_rain;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(i+"", j+"");
		}
		if(icon.equals("09n")){
			imageResource = R.drawable.shower_rain_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(i+"", j+"");
		}
		if(icon.equals("10d")){
			imageResource = R.drawable.rain;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(i+"", j+"");
		}
		if(icon.equals("10n")){
			imageResource = R.drawable.rain;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(i+"", j+"");
		}
		if(icon.equals("11d")){
			imageResource = R.drawable.thunderstorm;		    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(i+"", j+"");
		}
		if(icon.equals("11n")){
			imageResource = R.drawable.thunderstorm_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(i+"", j+"");
		}
		if(icon.equals("13d")){
			imageResource = R.drawable.snow;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(i+"", j+"");
		}
		if(icon.equals("13n")){
			imageResource = R.drawable.snow_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(i+"", j+"");
		}
		if(icon.equals("50d")){
			imageResource = R.drawable.mist;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(i+"", j+"");
		}
		if(icon.equals("50n")){
			imageResource = R.drawable.mist_n;			    
			Drawable image = getResources().getDrawable(imageResource);
			f.setDrawable(image);
			Log.e(i+"", j+"");
		}
		Log.e(i+" i", icon);

	}
	
	private void displayWeeklyForecast() {
		myAdapter = new ForecastAdapter(getActivity(), forecastList);
		lvWeeklyForecast.setAdapter(myAdapter);
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
				j=0;
				/*for(j=0;j<6;j++){
					GetImageTask git = new GetImageTask();
					git.execute();
				}*/
				
				/*GetImageTask0 git0 = new GetImageTask0();
				git0.execute();
				GetImageTask1 git1 = new GetImageTask1();
				git1.execute();
				GetImageTask2 git2 = new GetImageTask2();
				git2.execute();
				GetImageTask3 git3 = new GetImageTask3();
				git3.execute();
				GetImageTask4 git4 = new GetImageTask4();
				git4.execute();
				GetImageTask5 git5 = new GetImageTask5();
				git5.execute();
				GetImageTask6 git6 = new GetImageTask6();
				git6.execute();
				GetImageTask7 git7 = new GetImageTask7();
				git7.execute();
				GetImageTask8 git8 = new GetImageTask8();
				git8.execute();
				GetImageTask9 git9 = new GetImageTask9();
				git9.execute();
				GetImageTask10 git10 = new GetImageTask10();
				git10.execute();
				GetImageTask11 git11 = new GetImageTask11();
				git11.execute();
				GetImageTask12 git12 = new GetImageTask12();
				git12.execute();
				GetImageTask13 git13 = new GetImageTask13();
				git13.execute();
				GetImageTask14 git14 = new GetImageTask14();
				git14.execute();
				GetImageTask15 git15 = new GetImageTask15();
				git15.execute();*/
				

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
			String dts, day, min, max, night, eve, morn, pressure, humidity, main, description, icon, speed, deg, clouds, rain, snow;
			
			JSONArray listarray = weather.getJSONArray("list");
			JSONObject list = listarray.getJSONObject(i);
			dt = list.getLong("dt")*1000;
		    Log.d("dt",""+dt);
		    Timestamp tdy=new Timestamp(System.currentTimeMillis());
			//Log.d("tdy",tdy.toString());
			Timestamp ts=new Timestamp(dt);
			//Log.d("ts",ts.toString());
			f.setDayInWeek(ts);

			f.setDt(ts);
			JSONObject temp = list.getJSONObject("temp");
			day = temp.getString("day");
			f.setDay(day);
			min = temp.getString("min");
			f.setMin(min);
			max = temp.getString("max");
			f.setMax(max);
			night = temp.getString("night");
			f.setNight(night);
			eve = temp.getString("eve");
			f.setEve(eve);
			morn = temp.getString("morn");
			f.setMorn(morn);
			//text += "Dnevna: " + day + "°C, Min: " + min + ", Max: " + max + "\nNoæna: " + night + "\nVeèernja: " + eve	+ "\nJutarnja: " + morn + "\n";
			// tvWeather.setText(text);

			pressure = list.getString("pressure");
			f.setPressure(pressure);
			humidity = list.getString("humidity");
			f.setHumidity(humidity);
			//text += "Tlak zraka: " + pressure + "\nVlažnost zraka: " + humidity	+ "\n";
			// tvWeather.setText(text);

			// Dohvaæanje polja objekata unutar objekta:
			JSONArray weatherarray = list.getJSONArray("weather");
			JSONObject weatherobject = weatherarray.getJSONObject(0);
			main = weatherobject.getString("main");
			f.setMain(main);
			description = weatherobject.getString("description");
			f.setDescription(description);
			icon = weatherobject.getString("icon").substring(0, 3);
			f.setIcon(icon);
			Log.e(i+" f", j+"");
 
			drawIcon(f, icon);

			//Log.d("git", "i: " + i);

			// f.setDrawable(returnBitmap(f.getIcon()));

			//text += "Vrijeme: " + main + "\nOpis vremena: " + description + "\nIcon: " + icon;
			// tvWeather.setText(text);

			if (list.has("speed"))
				speed = list.getString("speed");
			else speed = "NA";
			f.setSpeed(speed);
			if (list.has("deg"))
				deg = list.getString("deg");
			else deg = "NA";
			f.setDeg(deg);
			if (list.has("clouds"))
				clouds = list.getString("clouds");
			else
				clouds = "0";
			f.setClouds(clouds);
			if (list.has("rain"))
				rain = list.getString("rain");
			else
				rain = "0";
			f.setRain(rain);
			if (list.has("snow"))
				snow = list.getString("snow");
			else
				snow = "0";
			f.setSnow(snow);
			//text += "Brzina vjetra: " + speed + ", Pravac: " + deg + "\nOblaci: " + clouds + "\nKiša: " + rain + "\nSnijeg: " + snow;
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

		/*public class GetImageTask0 extends AsyncTask<Void, Integer, Drawable> {

			@Override
			protected Drawable doInBackground(Void... params) {
				//Log.d("doinback", "j: " + j);
				Forecast item = forecastList.get(0);
				try {
					// URL imageUrl = new URL(iconURL);
					// InputStream is = (InputStream) imageUrl.getContent();
					// Drawable d = Drawable.createFromStream(is, "src");
					Log.d("icon+url", icon + item.getIcon());

					Drawable b = Drawable.createFromStream((InputStream)new URL(item.getIcon()).getContent(), item.getIcon());
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
				Forecast item = forecastList.get(0);
				Log.e("0", item.getIcon());
				if (b != null) {
					item.setDrawable(b);
					Log.d("drawable", 0 + " ima");
					myAdapter.notifyDataSetChanged();
				} else {
					Log.d("drawable", 0 + " nema");
				}
				super.onPostExecute(b);
			}

		}		public class GetImageTask1 extends AsyncTask<Void, Integer, Drawable> {

			@Override
			protected Drawable doInBackground(Void... params) {
				//Log.d("doinback", "j: " + j);
				Forecast item = forecastList.get(1);
				try {
					// URL imageUrl = new URL(iconURL);
					// InputStream is = (InputStream) imageUrl.getContent();
					// Drawable d = Drawable.createFromStream(is, "src");
					Log.d("icon+url", icon + item.getIcon());

					Drawable b = Drawable.createFromStream((InputStream)new URL(item.getIcon()).getContent(), item.getIcon());
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
				Forecast item = forecastList.get(1);
				Log.e("1", item.getIcon());
				if (b != null) {
					item.setDrawable(b);
					Log.d("drawable", 1 + " ima");
					myAdapter.notifyDataSetChanged();
				} else {
					Log.d("drawable", 1 + " nema");
				}
				super.onPostExecute(b);
			}

		}		public class GetImageTask2 extends AsyncTask<Void, Integer, Drawable> {

			@Override
			protected Drawable doInBackground(Void... params) {
				//Log.d("doinback", "j: " + j);
				Forecast item = forecastList.get(2);
				try {
					// URL imageUrl = new URL(iconURL);
					// InputStream is = (InputStream) imageUrl.getContent();
					// Drawable d = Drawable.createFromStream(is, "src");
					Log.d("icon+url", icon + item.getIcon());

					Drawable b = Drawable.createFromStream((InputStream)new URL(item.getIcon()).getContent(), item.getIcon());
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
				Forecast item = forecastList.get(2);
				Log.e("2", item.getIcon());
				if (b != null) {
					item.setDrawable(b);
					Log.d("drawable", 2 + " ima");
					myAdapter.notifyDataSetChanged();
				} else {
					Log.d("drawable", 2 + " nema");
				}
				super.onPostExecute(b);
			}

		}		public class GetImageTask3 extends AsyncTask<Void, Integer, Drawable> {

			@Override
			protected Drawable doInBackground(Void... params) {
				//Log.d("doinback", "j: " + j);
				Forecast item = forecastList.get(3);
				try {
					// URL imageUrl = new URL(iconURL);
					// InputStream is = (InputStream) imageUrl.getContent();
					// Drawable d = Drawable.createFromStream(is, "src");
					Log.d("icon+url", icon + item.getIcon());

					Drawable b = Drawable.createFromStream((InputStream)new URL(item.getIcon()).getContent(), item.getIcon());
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
				Forecast item = forecastList.get(3);
				Log.e("3", item.getIcon());
				if (b != null) {
					item.setDrawable(b);
					Log.d("drawable", 3 + " ima");
					myAdapter.notifyDataSetChanged();
				} else {
					Log.d("drawable", 3 + " nema");
				}
				super.onPostExecute(b);
			}

		}		public class GetImageTask4 extends AsyncTask<Void, Integer, Drawable> {

			@Override
			protected Drawable doInBackground(Void... params) {
				//Log.d("doinback", "j: " + j);
				Forecast item = forecastList.get(4);
				try {
					// URL imageUrl = new URL(iconURL);
					// InputStream is = (InputStream) imageUrl.getContent();
					// Drawable d = Drawable.createFromStream(is, "src");
					Log.d("icon+url", icon + item.getIcon());

					Drawable b = Drawable.createFromStream((InputStream)new URL(item.getIcon()).getContent(), item.getIcon());
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
				Forecast item = forecastList.get(4);
				Log.e("4", item.getIcon());
				if (b != null) {
					item.setDrawable(b);
					Log.d("drawable", 4 + " ima");
					myAdapter.notifyDataSetChanged();
				} else {
					Log.d("drawable", 4 + " nema");
				}
				super.onPostExecute(b);
			}

		}		public class GetImageTask5 extends AsyncTask<Void, Integer, Drawable> {

			@Override
			protected Drawable doInBackground(Void... params) {
				//Log.d("doinback", "j: " + j);
				Forecast item = forecastList.get(5);
				try {
					// URL imageUrl = new URL(iconURL);
					// InputStream is = (InputStream) imageUrl.getContent();
					// Drawable d = Drawable.createFromStream(is, "src");
					Log.d("icon+url", icon + item.getIcon());

					Drawable b = Drawable.createFromStream((InputStream)new URL(item.getIcon()).getContent(), item.getIcon());
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
				Forecast item = forecastList.get(5);
				Log.e("5", item.getIcon());
				if (b != null) {
					item.setDrawable(b);
					Log.d("drawable", 5 + " ima");
					myAdapter.notifyDataSetChanged();
				} else {
					Log.d("drawable", 5 + " nema");
				}
				super.onPostExecute(b);
			}

		}
		public class GetImageTask6 extends AsyncTask<Void, Integer, Drawable> {

			@Override
			protected Drawable doInBackground(Void... params) {
				//Log.d("doinback", "j: " + j);
				Forecast item = forecastList.get(6);
				try {
					// URL imageUrl = new URL(iconURL);
					// InputStream is = (InputStream) imageUrl.getContent();
					// Drawable d = Drawable.createFromStream(is, "src");
					Log.d("icon+url", icon + item.getIcon());

					Drawable b = Drawable.createFromStream((InputStream)new URL(item.getIcon()).getContent(), item.getIcon());
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
				Forecast item = forecastList.get(6);
				Log.e("6", item.getIcon());
				if (b != null) {
					item.setDrawable(b);
					Log.d("drawable", 6 + " ima");
					myAdapter.notifyDataSetChanged();
				} else {
					Log.d("drawable", 6 + " nema");
				}
				super.onPostExecute(b);
			}

		}		
		public class GetImageTask7 extends AsyncTask<Void, Integer, Drawable> {

			@Override
			protected Drawable doInBackground(Void... params) {
				//Log.d("doinback", "j: " + j);
				Forecast item = forecastList.get(7);
				try {
					// URL imageUrl = new URL(iconURL);
					// InputStream is = (InputStream) imageUrl.getContent();
					// Drawable d = Drawable.createFromStream(is, "src");
					Log.d("icon+url", icon + item.getIcon());

					Drawable b = Drawable.createFromStream((InputStream)new URL(item.getIcon()).getContent(), item.getIcon());
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
				Forecast item = forecastList.get(7);
				Log.e("7", item.getIcon());
				if (b != null) {
					item.setDrawable(b);
					Log.d("drawable", 7 + " ima");
					myAdapter.notifyDataSetChanged();
				} else {
					Log.d("drawable", 7 + " nema");
				}
				super.onPostExecute(b);
			}

		}		
		public class GetImageTask8 extends AsyncTask<Void, Integer, Drawable> {

			@Override
			protected Drawable doInBackground(Void... params) {
				//Log.d("doinback", "j: " + j);
				Forecast item = forecastList.get(8);
				try {
					// URL imageUrl = new URL(iconURL);
					// InputStream is = (InputStream) imageUrl.getContent();
					// Drawable d = Drawable.createFromStream(is, "src");
					Log.d("icon+url", icon + item.getIcon());

					Drawable b = Drawable.createFromStream((InputStream)new URL(item.getIcon()).getContent(), item.getIcon());
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
				Forecast item = forecastList.get(8);
				Log.e("8", item.getIcon());
				if (b != null) {
					item.setDrawable(b);
					Log.d("drawable", 8 + " ima");
					myAdapter.notifyDataSetChanged();
				} else {
					Log.d("drawable", 8 + " nema");
				}
				super.onPostExecute(b);
			}

		}		
		public class GetImageTask9 extends AsyncTask<Void, Integer, Drawable> {

			@Override
			protected Drawable doInBackground(Void... params) {
				//Log.d("doinback", "j: " + j);
				Forecast item = forecastList.get(9);
				try {
					// URL imageUrl = new URL(iconURL);
					// InputStream is = (InputStream) imageUrl.getContent();
					// Drawable d = Drawable.createFromStream(is, "src");
					Log.d("icon+url", icon + item.getIcon());

					Drawable b = Drawable.createFromStream((InputStream)new URL(item.getIcon()).getContent(), item.getIcon());
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
				Forecast item = forecastList.get(9);
				Log.e("9", item.getIcon());
				if (b != null) {
					item.setDrawable(b);
					Log.d("drawable", 9 + " ima");
					myAdapter.notifyDataSetChanged();
				} else {
					Log.d("drawable", 9 + " nema");
				}
				super.onPostExecute(b);
			}

		}		
		public class GetImageTask10 extends AsyncTask<Void, Integer, Drawable> {

			@Override
			protected Drawable doInBackground(Void... params) {
				//Log.d("doinback", "j: " + j);
				Forecast item = forecastList.get(10);
				try {
					// URL imageUrl = new URL(iconURL);
					// InputStream is = (InputStream) imageUrl.getContent();
					// Drawable d = Drawable.createFromStream(is, "src");
					Log.d("icon+url", icon + item.getIcon());

					Drawable b = Drawable.createFromStream((InputStream)new URL(item.getIcon()).getContent(), item.getIcon());
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
				Forecast item = forecastList.get(10);
				Log.e("10", item.getIcon());
				if (b != null) {
					item.setDrawable(b);
					Log.d("drawable", 10 + " ima");
					myAdapter.notifyDataSetChanged();
				} else {
					Log.d("drawable", 10 + " nema");
				}
				super.onPostExecute(b);
			}

		}		
		public class GetImageTask11 extends AsyncTask<Void, Integer, Drawable> {

			@Override
			protected Drawable doInBackground(Void... params) {
				//Log.d("doinback", "j: " + j);
				Forecast item = forecastList.get(11);
				try {
					// URL imageUrl = new URL(iconURL);
					// InputStream is = (InputStream) imageUrl.getContent();
					// Drawable d = Drawable.createFromStream(is, "src");
					Log.d("icon+url", icon + item.getIcon());

					Drawable b = Drawable.createFromStream((InputStream)new URL(item.getIcon()).getContent(), item.getIcon());
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
				Forecast item = forecastList.get(11);
				Log.e("11", item.getIcon());
				if (b != null) {
					item.setDrawable(b);
					Log.d("drawable", 11 + " ima");
					myAdapter.notifyDataSetChanged();
				} else {
					Log.d("drawable", 11 + " nema");
				}
				super.onPostExecute(b);
			}

		}		
		public class GetImageTask12 extends AsyncTask<Void, Integer, Drawable> {

			@Override
			protected Drawable doInBackground(Void... params) {
				//Log.d("doinback", "j: " + j);
				Forecast item = forecastList.get(12);
				try {
					// URL imageUrl = new URL(iconURL);
					// InputStream is = (InputStream) imageUrl.getContent();
					// Drawable d = Drawable.createFromStream(is, "src");
					Log.d("icon+url", icon + item.getIcon());

					Drawable b = Drawable.createFromStream((InputStream)new URL(item.getIcon()).getContent(), item.getIcon());
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
				Forecast item = forecastList.get(12);
				Log.e("12", item.getIcon());
				if (b != null) {
					item.setDrawable(b);
					Log.d("drawable", 12 + " ima");
					myAdapter.notifyDataSetChanged();
				} else {
					Log.d("drawable", 12 + " nema");
				}
				super.onPostExecute(b);
			}

		}		
		public class GetImageTask13 extends AsyncTask<Void, Integer, Drawable> {

			@Override
			protected Drawable doInBackground(Void... params) {
				//Log.d("doinback", "j: " + j);
				Forecast item = forecastList.get(13);
				try {
					// URL imageUrl = new URL(iconURL);
					// InputStream is = (InputStream) imageUrl.getContent();
					// Drawable d = Drawable.createFromStream(is, "src");
					Log.d("icon+url", icon + item.getIcon());

					Drawable b = Drawable.createFromStream((InputStream)new URL(item.getIcon()).getContent(), item.getIcon());
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
				Forecast item = forecastList.get(13);
				Log.e("13", item.getIcon());
				if (b != null) {
					item.setDrawable(b);
					Log.d("drawable", 13 + " ima");
					myAdapter.notifyDataSetChanged();
				} else {
					Log.d("drawable", 13 + " nema");
				}
				super.onPostExecute(b);
			}

		}		
		public class GetImageTask14 extends AsyncTask<Void, Integer, Drawable> {

			@Override
			protected Drawable doInBackground(Void... params) {
				//Log.d("doinback", "j: " + j);
				Forecast item = forecastList.get(14);
				try {
					// URL imageUrl = new URL(iconURL);
					// InputStream is = (InputStream) imageUrl.getContent();
					// Drawable d = Drawable.createFromStream(is, "src");
					Log.d("icon+url", icon + item.getIcon());

					Drawable b = Drawable.createFromStream((InputStream)new URL(item.getIcon()).getContent(), item.getIcon());
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
				Forecast item = forecastList.get(14);
				Log.e("14", item.getIcon());
				if (b != null) {
					item.setDrawable(b);
					Log.d("drawable", 14 + " ima");
					myAdapter.notifyDataSetChanged();
				} else {
					Log.d("drawable", 14 + " nema");
				}
				super.onPostExecute(b);
			}

		}		
		public class GetImageTask15 extends AsyncTask<Void, Integer, Drawable> {

			@Override
			protected Drawable doInBackground(Void... params) {
				//Log.d("doinback", "j: " + j);
				Forecast item = forecastList.get(15);
				try {
					// URL imageUrl = new URL(iconURL);
					// InputStream is = (InputStream) imageUrl.getContent();
					// Drawable d = Drawable.createFromStream(is, "src");
					Log.d("icon+url", icon + item.getIcon());

					Drawable b = Drawable.createFromStream((InputStream)new URL(item.getIcon()).getContent(), item.getIcon());
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
				Forecast item = forecastList.get(15);
				Log.e("15", item.getIcon());
				if (b != null) {
					item.setDrawable(b);
					Log.d("drawable", 15 + " ima");
					myAdapter.notifyDataSetChanged();
				} else {
					Log.d("drawable", 15 + " nema");
				}
				super.onPostExecute(b);
			}

		}*/
		
		/*public class GetImageTask extends AsyncTask<Void, Integer, Drawable> {

			@Override
			protected Drawable doInBackground(Void... params) {
				Forecast item = forecastList.get(j);
				try {
					// URL imageUrl = new URL(iconURL);
					// InputStream is = (InputStream) imageUrl.getContent();
					// Drawable d = Drawable.createFromStream(is, "src");
					Log.d("icon+url", icon + item.getIcon());

					Drawable b = Drawable.createFromStream((InputStream)new URL(item.getIcon()).getContent(), item.getIcon());
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
				Log.d("doinback", "j: " + j);
				super.onPreExecute();
			}

			@Override
			protected void onPostExecute(Drawable b) {
				Forecast item = forecastList.get(j);
				Log.e("j", item.getIcon());
				if (b != null) {
					item.setDrawable(b);
					Log.d("drawable", j + " ima");
					myAdapter.notifyDataSetChanged();
				} else {
					Log.d("drawable", j + " nema");
				}
				super.onPostExecute(b);
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
