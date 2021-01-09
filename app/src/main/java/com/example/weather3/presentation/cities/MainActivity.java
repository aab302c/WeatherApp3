package com.example.weather3.presentation.cities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather3.R;
import com.example.weather3.app.App;
import com.example.weather3.domain.CityDisplay;
import com.example.weather3.presentation.ToothpickFactory;
import com.example.weather3.presentation.weather.WeatherActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity {

    public static final String CITY_KEY = "city_key";
    private MainViewModel viewModel;
    private CompositeDisposable disposable = new CompositeDisposable();
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.city_edit)
    EditText editTextCity;
    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    private CitiesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CitiesAdapter.OnCityClickListener onCityClickListener = new CitiesAdapter.OnCityClickListener() {
            @Override
            public void onCityClick(CityDisplay city) {
                Intent intent = new Intent(getApplicationContext(), WeatherActivity.class);
                intent.putExtra(CITY_KEY, city.getName());
                startActivity(intent);
            }
        };

        adapter = new CitiesAdapter(onCityClickListener);
        recyclerView.setAdapter(adapter);
        ItemTouchHelper.Callback callback = new CityItemTouchHelperCallback(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeRemoved(int positionStart, int itemCount) {
                super.onItemRangeRemoved(positionStart, itemCount);
                viewModel.deleteCity(adapter.findCityNameByPos(positionStart));
            }
        });


        button.setOnClickListener(v -> {
            String city = editTextCity.getText().toString();
            if(city.isEmpty()) {
                Toast.makeText(this, R.string.empty_city_field, Toast.LENGTH_LONG).show();
                return;
            }
                Intent intent = new Intent(this, WeatherActivity.class);
                intent.putExtra(CITY_KEY, city);
                startActivity(intent);
        });
        viewModel = ViewModelProviders.of(this, new ToothpickFactory(App.getScope()))
                .get(MainViewModel.class);
        disposable.add(
                viewModel.getCities()
                .subscribe(this::displayCities)
        );
    }

    private void displayCities(List<CityDisplay> list) {
        adapter.clearItems();
        if(!list.isEmpty()) {
            adapter.setItems(list);
        }
    }
}