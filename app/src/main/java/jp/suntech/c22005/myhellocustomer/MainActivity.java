package jp.suntech.c22005.myhellocustomer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタン・オブジェクトの用意
        Button btClick = findViewById(R.id.btClick);
        Button btClear1 = findViewById(R.id.btClear1);
        Button btClear2 = findViewById(R.id.btClear2);

        //リスナ・オブジェクトの用意
        HelloListener listener = new HelloListener();

        //ボタンにリスナを設定
        btClick.setOnClickListener(listener);
        btClear1.setOnClickListener(listener);
        btClear2.setOnClickListener(listener);
    }

    //ボタンをクリックしたときのリスナクラス
    private class HelloListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText input1 = findViewById(R.id.etName);
            EditText input2 = findViewById(R.id.etAddress);

            int id = view.getId();

            if (id == R.id.btClick) {
                String inputStr1 = input1.getText().toString();
                String inputStr2 = input2.getText().toString();
                String message = inputStr2 + "にお住いの" + inputStr1 + "さん、こんにちは！";

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            } else if (id == R.id.btClear1) {
                input1.setText("");

            } else if (id == R.id.btClear2) {
                input2.setText("");
            }
        }
    }
}
