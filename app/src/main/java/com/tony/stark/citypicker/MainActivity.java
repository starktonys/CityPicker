package com.tony.stark.citypicker;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tony.stark.citypickerview.widget.CityPickerView;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button button = (Button) findViewById(R.id.button);
    final TextView tvResult = (TextView) findViewById(R.id.tv_result);
    button.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        CityPickerView cityPickerView = new CityPickerView(MainActivity.this);
        cityPickerView.setTextColor(Color.BLUE);
        cityPickerView.setTextSize(20);
        cityPickerView.setVisibleItems(5);
        cityPickerView.setIsCyclic(true);
        cityPickerView.show();
        cityPickerView.setOnCityItemClickListener(new CityPickerView.OnCityItemClickListener() {
          @Override public void onSelected(String... citySelected) {
            tvResult.setText("选择结果：\n省："
                + citySelected[0]
                + "\n市："
                + citySelected[1]
                + "\n区："
                + citySelected[2]
                + "\n邮编："
                + citySelected[3]);
          }
        });
      }
    });
  }
}
