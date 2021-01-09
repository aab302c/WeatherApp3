package com.example.weather3.presentation.weather;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.weather3.BuildConfig;
import com.example.weather3.R;
import com.example.weather3.app.App;
import com.example.weather3.domain.WeatherDisplay;
import com.example.weather3.presentation.ImageLoader;
import com.example.weather3.presentation.ToothpickFactory;
import com.example.weather3.presentation.cities.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;

public class WeatherActivity extends AppCompatActivity {

    private WeatherViewModel viewModel;
    private CompositeDisposable disposable = new CompositeDisposable();

    @BindView(R.id.city_tv)
    TextView cityTv;
    @BindView(R.id.weather_image)
    ImageView weatherIcon;
    @BindView(R.id.temperature)
    TextView tempTv;
    @BindView(R.id.humidity)
    TextView humidityTv;
    @BindView(R.id.sunrise)
    TextView sunriseTv;
    @BindView(R.id.sunset)
    TextView sunsetTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);
        String cityName = getIntent().getStringExtra(MainActivity.CITY_KEY);

        viewModel = ViewModelProviders
                .of(this, new ToothpickFactory(App.getScope()))
                .get(WeatherViewModel.class);

        disposable.add(
                viewModel.getWeather(cityName)
                        .subscribe(this::displayWeather)
        );
    }


    private void displayWeather(WeatherDisplay weather) {
        tempTv.setText(weather.getTemp() + BuildConfig.CELSIUS);
        humidityTv.setText(weather.getHumidity() + BuildConfig.PERCENT);
        setTitle(weather.getName() + ", " + weather.getCountry());
        ImageLoader.load(weatherIcon, BuildConfig.WEATHER_ICON_PREFIX
                                                        + weather.getImageUrl()
                                                        + BuildConfig.WEATHER_ICON_SCALE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}
