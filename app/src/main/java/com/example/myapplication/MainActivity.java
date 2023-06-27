package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Call<data_model> call;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.txt_view);

        call=retrofit_client.getApiService().test_api_get("5");

        //비동기 통신, 통신 완료 이벤트 처리를 위해 콜백 리스너도 등록
        call.enqueue(new Callback<data_model>() {
            @Override
            public void onResponse(Call<data_model> call, Response<data_model> response) {
                data_model result = response.body();
                String str;
                str = result.getUserId() +"\n"
                        +result.getID()+"\n"
                        +result.getTitle()+"\n"
                        +result.getBody();
                textView.setText(str);
            }

            @Override
            public void onFailure(Call<data_model> call, Throwable t) {

            }
        });

    }
}