package com.example.vjezbaa6_1.adapters;

import java.util.ArrayList;

import android.app.Service;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.vjezbaa6_1.R;
import com.example.vjezbaa6_1.appclasses.Forecast;
import com.example.vjezbaa6_1.fragments.DailyForecastFragment;

public class ForecastAdapter extends BaseAdapter {
	DailyForecastFragment dailyForecastFragment;
	Context context;
	ArrayList<Forecast> forecastList;
	String iconUrl;
	Drawable drawable = null;
	ImageView ivImage;
	View view;

	public ForecastAdapter(Context context, ArrayList<Forecast> forecastList) {
		super();
		this.context = context;
		this.forecastList = forecastList;
	}

	@Override
	public int getCount() {
		return forecastList.size();
		// return 7;
	}

	@Override
	public Object getItem(int position) {
		return forecastList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		view=v;

		if (v == null) {
			LayoutInflater li = (LayoutInflater) context.getSystemService(Service.LAYOUT_INFLATER_SERVICE);
			v = li.inflate(com.example.vjezbaa6_1.R.layout.listitem_forecast,
					null);
		}
		TextView tvMain = (TextView) v.findViewById(R.id.tvMain);
		TextView tvDescription = (TextView) v.findViewById(R.id.tvDescription);
		TextView tvDayTemperature = (TextView) v
				.findViewById(R.id.tvDayTemperature);
		TextView tvMax = (TextView) v.findViewById(R.id.tvMax);
		//TextView tvMin = (TextView) v.findViewById(R.id.tvMin);
		TextView tvDateTime = (TextView) v.findViewById(R.id.tvDateTime);
		ImageView ivIcon = (ImageView) v.findViewById(R.id.ivIcon);

		Forecast item = forecastList.get(position);

		tvDescription.setText("Forecast: " + item.getDescription());
		tvDayTemperature.setText("    "+item.getDay() + " °C");
		tvMax.setText(item.getMin() + " °C - "+item.getMax() + " °C");
		//tvMin.setText("Min: " + item.getMin() + " °C");
		if(forecastList.size()>20){
			tvMain.setText(item.getHourInDay() + ": " + item.getMain());
			tvDateTime.setText(item.getDayInWeek()+", "+item.getDt());
		}
		else {
			tvMain.setText(item.getDayInWeek() + ": " + item.getMain());
			tvDateTime.setText(item.getDt());
		}

			

		

		// Drawable drawable = ImageOperations(context, iconUrl, "icon.png");
		//GetImageTask git = new GetImageTask();
		//git.execute();
		// imageUrl=item.getImageurl();
		ivIcon.setImageResource(R.drawable.ic_launcher);
		ivIcon.setImageDrawable(item.getDrawable());
		iconUrl = item.getIcon();
		return v;
	}

	/*public class GetImageTask extends AsyncTask<Void, Integer, Drawable> {

		@Override
		protected Drawable doInBackground(Void... params) {

			try {
				URL imageUrl = new URL(iconUrl);
				InputStream is = (InputStream) imageUrl.getContent();
				Drawable d = Drawable.createFromStream(is, "src");
				return d;
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
		protected void onPostExecute(Drawable drawable) {
			Forecast item = forecastList.get(0);
			Log.d("ivIcon", item.getIcon());

			Log.d("ivIcon", item.getIcon());

			if (drawable != null) {
			
				Log.d("drawable", "ima");
			} else {
			
				Log.d("drawable", "nema");
			}
			super.onPostExecute(drawable);
		}
	}*/
	/*
	 * private Drawable ImageOperations(Context ctx, String url, String
	 * saveFilename) { try { URL imageUrl = new URL(url); InputStream is =
	 * (InputStream) imageUrl.getContent(); Drawable d =
	 * Drawable.createFromStream(is, "src"); return d; } catch
	 * (MalformedURLException e) { e.printStackTrace(); return null; } catch
	 * (IOException e) { e.printStackTrace(); return null; } }
	 */
	/*
	 * private Drawable LoadImageFromWebOperations(String url) {
	 * 
	 * InputStream is; try { is = (InputStream) new URL(url).getContent();
	 * Drawable d = Drawable.createFromStream(is, "src name"); return d;
	 * 
	 * } catch (MalformedURLException e) { e.printStackTrace();
	 * Log.d("MalformedURLE", "" + e);
	 * 
	 * return null;
	 * 
	 * } catch (IOException e) { e.printStackTrace(); Log.d("IOE", "" + e);
	 * 
	 * return null;
	 * 
	 * } catch (Exception e) { Log.d("E", "" + e); return null; }
	 */

}
