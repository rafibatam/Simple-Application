package id.muhammadrafi.dicodingsubmission.listcar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import id.muhammadrafi.dicodingsubmission.R;
import id.muhammadrafi.dicodingsubmission.display.AboutMe;
import id.muhammadrafi.dicodingsubmission.display.CarDetail;

public class CarData extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    List<Car> carList;

    private static String[] carName = new String[] {
            "BMW 3 Series Sedan (2019)",
            "BMW 3 Series Sedan",
            "BMW 4 Series Coupe",
            "BMW 4 Series Convertible",
            "BMW 5 Series Sedan",
            "BMW 6 Series Gran Turismo",
            "BMW 7 Series Sedan",
            "BMW 8 Series Coupe",
            "BMW X7",
            "BMW i8 Roadster"
    };

    private static String[] carDescribe = new String[] {
            "Barely on the road and the all-new BMW 3 Series Sedan is already leaving everything behind it, including conventions and expectations. Once again the icon displays how to reinvent itself. After all, with the pioneering design language, it stands for the dawning of a new era. Propelling the ultimate sports sedan are even more powerful and efficient engines. And a new force – simply say \"Hey BMW\" and the all-new BMW 3 Series recognises your voice and heeds your every word.",
            "The original since 1975: The new BMW 3 Series is the embodiment of a sporty sedan. In its sixth generation, this irresistible combination of dynamic design, unrivalled agility and excellent everyday practicality is as impressive as ever. Optimum weight distribution, classic rear-wheel drive and powerful, high-efficiency petrol engine with BMW EfficientDynamics technology guarantee outstanding dynamics and low fuel consumption. And with the BMW 340i M Sport Individual, you can adapt your BMW 3 Series Sedan in line with your own personal needs and wants.",
            "A sporty performer built to impress on the road. The result is impressive. More dynamic, agile and comfortable. Uncompromisingly ready for action by offering a design, presence and handling that have all been meticulously optimised. In short: a breathtaking sports coupé that infuses driving pleasure with new meaning and satisfies even the most discerning customer.",
            "The BMW 4 Series Convertible: Catch the sun, feel the wind and savour those special driving moments. With sporty agility and stirring dynamics – accompanied by an impressive, aerodynamic design and stylish equipment with plenty of innovative functionalities. The ultimate contemporary defines freedom on four wheels.",
            "Its mission statement: setting new standards. The BMW 5 Series is the embodiment of the modern business saloon. Thanks to its dynamic and simultaneously elegant appearance, it convincingly meets the expectations that are placed today on a vehicle of its class: aesthetic athleticism and driving pleasure with state-of-the-art technology.",
            "With its clear contours, the modern design of the BMW 6 Series Gran Turismo is a true eye-catcher. Concealed behind the flowing design language is comfort concept that is both luxurious and functional. Built to meet the highest aspirations, it is an ideal travelling companion that combines elegance with sporting flair.",
            "The BMW Group has a long tradition of creating the automotive future. We believe the best way to predict the future is to create it. With the BMW 7 Series we are creating tomorrow’s luxury today. Thanks to game-changing innovations, benchmarking comfort and contemporary design as well as dynamics that are both impressive and highly efficient.",
            "Impressive down to the last thread. While outstanding paint finishes bring out the appearance of the BMW 8 Series Coupé, luxurious materials with stylish contrast stitchings and classy decorative elements enhance the sporty interior – imbuing it with a particularly high-quality look. This is especially emphasized in the positioned perforations and special quilting of the optional multi-functional seats. Combining top performance with the highest quality and creating an extremely sporty and elegant ambience in the interior.",
            "A statement of the luxury class: the new BMW X7 is the elegant fusion of presence and personality. Despite its majestic appearance, it gives an impression of lightness and agility thanks to the puristic design and athletic styling. At the same time, the considerable spaciousness of the interior offers a pioneering interplay of exclusivity, functionality and freedom – incomparable comfort all the way to the third row of seats. Charm is its essence. Elegance its character.",
            "The future is taking shape – in the form of the first ever BMW i8 Roadster. Enthusiastic, fascinating and ready to reinterpret freedom. For unconditional driving pleasure, as far as the road goes. From the first glimpse of the iconic design adrenaline levels rise. The tachometer shoots up just as fast: the innovative plug-in hybrid engine generates 374 hp and 570 Nm and accelerates the BMW i8 Roadster from 0 to 100 km/ h in just 4.6 seconds. The fastest route to experience a new form of freedom."
    };

    private static int[] carPhoto = {
            R.drawable.bmw_three_series_new,
            R.drawable.bmw_three_series_sedan,
            R.drawable.bmw_four_series_coupe,
            R.drawable.bmw_four_series_convertible,
            R.drawable.bmw_five_series_sedan,
            R.drawable.bmw_six_series_gran_turismo,
            R.drawable.bmw_seven_series_sedan,
            R.drawable.bmw_eight_series_coupe,
            R.drawable.bmw_x_seven,
            R.drawable.bmw_i_eight_roadster
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_display);

        carList = new ArrayList<>();

        for(int i = 0; i < carName.length; i++) {
            Car item = new Car(carPhoto[i], carName[i], carDescribe[i]);
            carList.add(item);
        }

        listView = findViewById(R.id.listMode);
        CustomListAdapter customListAdapter = new CustomListAdapter(this, R.layout.item_row_car, carList);
        listView.setAdapter(customListAdapter);
        listView.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getApplicationContext(), CarDetail.class);
        intent.putExtra("photo", carList.get(position).getPhoto());
        intent.putExtra("name", carList.get(position).getName());
        intent.putExtra("describe", carList.get(position).getDescribe());
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.aboutme, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.aboutMe) {
            Intent moveAboutMe = new Intent(CarData.this, AboutMe.class);
            startActivity(moveAboutMe);
            finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
