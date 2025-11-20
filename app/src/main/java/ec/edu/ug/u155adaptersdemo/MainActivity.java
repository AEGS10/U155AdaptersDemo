package ec.edu.ug.u155adaptersdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    Spinner spCities;
    ListView lvCountries;
    GridView gvColors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spCities = findViewById(R.id.spCities);
        lvCountries = findViewById(R.id.lvCountries);
        gvColors = findViewById(R.id.gvColors);
        //----- Spinner básico----
        String[] cities = {"Guayaquil", "Quito", "Manta", "Cuenca"};
        ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cities);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCities.setAdapter(cityAdapter);
        spCities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String city = cities[position];
                Toast.makeText(MainActivity.this, "Ciudad seleccionada: " + city, Toast.LENGTH_SHORT).show();
            }
            @Override public void onNothingSelected(AdapterView<?> parent) {}
        });
        //----- ListView básico----
        String[] countries = {"Ecuador", "Perú", "Colombia", "Chile", "Argentina", "México"};
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);
        lvCountries.setAdapter(countryAdapter);
        lvCountries.setOnItemClickListener((parent, view, position, id)-> {
            String country = countries[position];
            Toast.makeText(this, "País: " + country, Toast.LENGTH_SHORT).show();
        });
        //----- GridView con Adapter personalizado----
        String[] colorNames = {"Rojo", "Verde", "Azul", "Amarillo", "Cyan", "Magenta"};
        int[] colorValues = {0xFFFF4444, 0xFF99CC00, 0xFF33B5E5, 0xFFFFEB3B, 0xFF00BCD4, 0xFFE040FB};
        MyAdapter gridAdapter = new MyAdapter(this, colorNames, colorValues);
        gvColors.setAdapter(gridAdapter);
        gvColors.setOnItemClickListener((parent, view, position, id)-> {
            String color = colorNames[position];
            Toast.makeText(this, "Color: " + color, Toast.LENGTH_SHORT).show();
        });
    }
}