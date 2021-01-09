package com.example.weather3.presentation.cities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather3.R;
import com.example.weather3.domain.CityDisplay;

import java.util.ArrayList;
import java.util.List;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.CityViewHolder> implements CityItemTouchHelperCallback.ItemTouchHelperAdapter {

    @Override
    public void onItemDismiss(int position) {
        notifyItemRemoved(position);
        cities.remove(position);
    }

    public interface OnCityClickListener {
        void onCityClick(CityDisplay city);
    }

    @NonNull
    private final List<CityDisplay> cities = new ArrayList<>();
    private  OnCityClickListener onCityClickListener;

    public CitiesAdapter(OnCityClickListener onCityClickListener) {
        this.onCityClickListener = onCityClickListener;
    }

    public String findCityNameByPos(int pos) {
        return cities.get(pos).getName();
    }

    public void setItems(List<CityDisplay> cities) {
        this.cities.addAll(cities);
        notifyDataSetChanged();
    }

    public void clearItems() {
        cities.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_item, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CitiesAdapter.CityViewHolder holder, int position) {
        holder.bind(cities.get(position));
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }


    class CityViewHolder extends RecyclerView.ViewHolder{
        private final TextView cityItemView;
        private final TextView countryItemView;

        private CityViewHolder(View itemView) {
            super(itemView);
            cityItemView = itemView.findViewById(R.id.tv_city_name);
            countryItemView = itemView.findViewById(R.id.tv_country);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CityDisplay cityDisplay = cities.get(getLayoutPosition());
                    onCityClickListener.onCityClick(cityDisplay);
                }
            });
        }

        public void bind(CityDisplay city) {
            cityItemView.setText(city.getName());
            countryItemView.setText(city.getCountry());
        }
    }
}
