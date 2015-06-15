package com.example.vjezbaa6_1.activities;

import java.io.File;
import java.util.ArrayList;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.vjezbaa6_1.R;
import com.example.vjezbaa6_1.fragments.CurrentForecastFragment;
import com.example.vjezbaa6_1.fragments.DailyForecastFragment;
import com.example.vjezbaa6_1.fragments.HourlyForecastFragment;

public class MainActivity extends Activity implements TabListener, OnItemSelectedListener {
	ActionBar action;
	FrameLayout flContainer;
	ListView lvCityList;
	public String city="";
	public String address;
	SearchView searchCity;
	SharedPreferences myPreferences;
	Spinner spinner;
	int selectedTab=0, size=-1;
  	ArrayList<String> cities = new ArrayList<String>();
	File citylist=new File("D:\\citylist.txt");


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// tvWeather = (TextView) findViewById(R.id.tvWeather);
		// tvCheck = (TextView) findViewById(R.id.tvCheck);
		//forecastList = new ArrayList<Forecast>();
		myPreferences = this.getSharedPreferences("prefs", Context.MODE_PRIVATE);
		spinner=(Spinner) findViewById(R.id.spinner);
	  	ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cities /*android.R.id.text1*/);
  	  	size = myPreferences.getInt("Size", -1);
	  	spinner.setAdapter(spinnerAdapter);
	  	for(int ijk=0;ijk<size;ijk++){
			cities.add(myPreferences.getString("City_"+ijk, null));
			Log.d("Add city in OnCreate", ""+ijk);
		}
		spinnerAdapter.notifyDataSetChanged();
		if(spinner.getSelectedItem()!=null)
		city = correctHtmlCode((String) spinner.getSelectedItem());
		else city="";
		//saveCityList(city);
		Log.d("oncreate", city);
		flContainer = (FrameLayout) findViewById(R.id.flFragmentContainer);
		/*action = getActionBar();
		action.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);		
		list = populateList();
		myadapter = new com.example.vjezbaa6_1.adapters.MenuAdapter(this, list);		
		action.setListNavigationCallbacks(myadapter, this);*/
		
		action = getActionBar();
		action.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		Tab t =	action.newTab(); 
		t.setText("Current weather");
		t.setTag("currentForecast");
		t.setTabListener(this);
		action.addTab(t);
		t =	action.newTab(); 
		t.setText("3 hour forecast");
		t.setTag("hourlyForecast");
		t.setTabListener(this);
		action.addTab(t);		
		t = action.newTab();
		t.setText("Daily forecast");
		t.setTag("dailyForecast");
		t.setTabListener(this);
		action.addTab(t);

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
  	  	  	size = myPreferences.getInt("Size", -1);
  	  	  	/*spinner.setAdapter(spinnerAdapter);
  	  	  	for(int ind=0;ind<size;ind++){
				cities.add(myPreferences.getString("City_"+ind, null));
				Log.d("Add city in ACTION_SEARCH", ""+ind);
			}
  	  	  	int ji=0;
  	  	  	for(String s:cities){
  	  	  		ji++;
  	  	  		Log.d(""+ji, s);
  	  	  	}
  	  	  	ji=0;*/
          city = intent.getStringExtra(SearchManager.QUERY);
          Boolean b=false;
          for(String s:cities){
        	  Log.d(s,city);
        	  if(s.equals(city)) {
        		  b=true;
        	  	  break;
        	  }
        	  else b=false;
          }
          if(b==false)cities.add(city);else b=false;
  		  spinnerAdapter.notifyDataSetChanged();
  	  	  //Toast.makeText(getApplicationContext(), city, Toast.LENGTH_SHORT).show();
  		  spinner.setSelection(size-1);
	  	  for(int ind=0;ind<size;ind++){
	  		  if(myPreferences.getString("City_"+ind, null).equals(city)){
	  			  b=true;
	  			  break;
	  		  }else b=false;
	  	  }
	  	  if(b==false)saveCity();else b=false;
    	  
  	  	  /*try {
			loadCityList(citylist);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
  	  	  //SpinnerAdapter snprAdapter = new CityAdapter(this,cities);
  
			
  	  	  /*for(String s:cities){
  	  	  	  spinnerAdapter.add(s);
  	  	  }*/
        
  	  	  //spinnerAdapter.add(city);
  	  	  spinner.setOnItemSelectedListener(this);

        /*}else{
        try {
			loadCityList(citylist);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.city, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);*/
		//adapter.add(city);
        }
		spinner.setOnItemSelectedListener(this);

	}

	private void saveCity() {
		//SharedPreferences prefs = this.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        Editor editor = myPreferences.edit();
        Log.d("Cities", ""+cities.size());
        editor.putInt("Size", cities.size());
        editor.putString("City_"+(cities.size()-1), city);
        //editor.apply();
        editor.commit();
	}
	
	/*public String[] loadCityList(final File citylist) throws IOException{
		final ArrayList cities = new ArrayList();
		IOException anioe = null;
		FileReader fr=null;
		BufferedReader br=null;
		Log.e("Èita listu gradova", "123456");

		try{
			fr = new FileReader(citylist);
			br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				Log.d("read line", line);
		  	  	cities.add(line);
			}
			br.close();
			br=null;
		}catch(final IOException e){
			anioe=e;
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
			} catch (IOException e) {
				anioe=e;
				e.printStackTrace();
			}
		}
		if(anioe!=null)
		{
			throw anioe;
		}
	}
		final String[] myStrings=new String[cities.size()];
		System.arraycopy(cities.toArray(), 0, myStrings, 0, cities.size());
		return myStrings;
	}
	
	public void saveCityList(String city){
		FileWriter fw=null;
		BufferedWriter bw=null;
		FileReader fr=null;
		BufferedReader br=null;
		Log.e("Snima listu gradova", "7890");
		if (!citylist.exists()) {
			try {
				citylist.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try{
			String line=null;
			fw=new FileWriter(citylist);
			bw=new BufferedWriter(fw);
			fr=new FileReader(citylist);
			br=new BufferedReader(fr);
			while ((line = br.readLine()) != null) {
				Log.d("saved line", line);
				bw.append(line);
				bw.newLine();
			}
			bw.append(city);
			bw.flush();
			
		}catch (IOException e){
			e.printStackTrace();
		}finally{
			if(bw!=null){
				try{
					bw.close();
					br.close();

				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}*/
	
	
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		Fragment f = null;
		if (tab.getTag() == "dailyForecast"){
			Log.d("city on tabselect", city);
			f = new DailyForecastFragment(city);
			selectedTab=3;
		}
		
		if (tab.getTag() == "hourlyForecast"){
			Log.d("city on tabselect", city);
			f = new HourlyForecastFragment(city);
			selectedTab=2;
		}
		if (tab.getTag() == "currentForecast"){
			Log.d("city on tabselect", city);
			f = new CurrentForecastFragment(city);
			selectedTab=1;
		}
			
		ft = getFragmentManager().beginTransaction();
		ft.replace(R.id.flFragmentContainer, f);
		ft.commit();	}


	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		this.searchCity = (SearchView) findViewById(R.id.menu_search);

		SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
		searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
		searchView.setIconifiedByDefault(true);
		searchView.setSubmitButtonEnabled(true);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.menu_search:
			return true;
		case R.id.menu_addCity:
			makeToast("Add City");
			return true;
		case R.id.menu_deleteCity:
			makeToast("Delete City");
			return true;
		case R.id.menu_save:
			makeToast("Save City");
			return true;
		default:
			return super.onOptionsItemSelected(item);			
		}
	}
	
	/*@Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }
 
    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            city = intent.getStringExtra(SearchManager.QUERY);
        	ArrayList<String> citylist = null;

            SpinnerAdapter cityadapter=new CityAdapter(this, citylist);
            spinner.setAdapter(cityadapter);
            ((Menu) cityadapter).add(city);
            ((BaseAdapter) cityadapter).notifyDataSetChanged();
            spinner.setAdapter(cityadapter);  
            Toast.makeText(this, "Grad: "+city, Toast.LENGTH_SHORT).show();
            
            
    		Fragment f = null;
			f = new CurrentForecastFragment(city);
			FragmentTransaction ft=null;
			ft = getFragmentManager().beginTransaction();
			ft.replace(R.id.flFragmentContainer, f);
			ft.commit();
 
        }
 
    }*/
	
	public void makeToast(String msg){
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
	}
	
	
	private String correctHtmlCode(String cityForecast){
		String replace=cityForecast;
		replace=replace.replaceAll("š", "%C5%A1");
		replace=replace.replaceAll("è", "%C4%8D");
		replace=replace.replaceAll("æ", "%C4%87");
		replace=replace.replaceAll("ð", "%C4%91");
		replace=replace.replaceAll("ž", "%C5%BE");
		replace=replace.replaceAll("Š", "%C5%A0");
		replace=replace.replaceAll("È", "%C4%8C");
		replace=replace.replaceAll("Æ", "%C4%86");
		replace=replace.replaceAll("Ð", "%C4%90");
		replace=replace.replaceAll("Ž", "%C5%BD");
		cityForecast=replace;
		Log.e("replaced", cityForecast);
		return cityForecast; 
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		FragmentTransaction ft=null;
		Fragment f=null;
		spinner = (Spinner) findViewById(R.id.spinner);
		city = correctHtmlCode((String) spinner.getSelectedItem());
		Log.d("city",city);
		switch (selectedTab) {
		case 1: f=new CurrentForecastFragment();
		ft=getFragmentManager().beginTransaction();
		ft.replace(R.id.flFragmentContainer, f);
		ft.commit();
		break;
		case 2: f=new HourlyForecastFragment();
		ft=getFragmentManager().beginTransaction();
		ft.replace(R.id.flFragmentContainer, f);
		ft.commit();
		break;
		case 3: f=new DailyForecastFragment();
		ft=getFragmentManager().beginTransaction();
		ft.replace(R.id.flFragmentContainer, f);
		ft.commit();
		break;

		default:
			break;
		}
	}
	
	public String getCity(){
		//Log.d("getCity", city);
		return city;
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}


}