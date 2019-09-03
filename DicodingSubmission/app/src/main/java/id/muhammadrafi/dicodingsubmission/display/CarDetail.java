package id.muhammadrafi.dicodingsubmission.display;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import id.muhammadrafi.dicodingsubmission.R;

public class CarDetail extends AppCompatActivity {
    private TextView carName, carDescribe;
    private ImageView carPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);

        carName = findViewById(R.id.carName);
        carDescribe = findViewById(R.id.carDescribe);
        carPhoto = findViewById(R.id.carPhoto);

        carName.setText(getIntent().getStringExtra("name"));
        carDescribe.setText(getIntent().getStringExtra("describe"));
        carPhoto.setImageResource(getIntent().getIntExtra("photo", 0));
    }
}
