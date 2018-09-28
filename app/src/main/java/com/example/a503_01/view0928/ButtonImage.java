package com.example.a503_01.view0928;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class ButtonImage extends AppCompatActivity {
    //스레드를 anonymous class를 이용해서 만들것이다. *anonymous class는 지역변수 사용불가
    ImageView imageView;
    Bitmap bitmap;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_image);

        imageView=(ImageView)findViewById(R.id.imgview);
        //리소스에 포함된 이미지 가져오기
        //imgView.setImageResource(R.drawable.tigers);

        //웹의 이미지 출력하기
        url = "http://i.imgur.com/Pqg1S.jpg";
        //이미지를 다운로드 받기위한 스레드 생성
        Thread th = new Thread( ) {
            public void run( ) {
                try{
                    //웹에서 데이터를 가져올 수 있는 스트림생성
                    InputStream is = new URL(url).openStream();
                    //스트림의 데이터를 이미지로 변경
                    //이미지 파일은 bitmap으로만 읽을 수 있다.
                    bitmap = BitmapFactory.decodeStream(is);
                }catch (Exception e){ }
            }
        };
        //스레드시작
        th.start();

        //스레드의 수행이 종료되면 이미지를 설정하는 코드
        try{
            //스레드의 수행이 종료될 때까지 대기
            th.join();
            imageView.setImageBitmap(bitmap);
        }catch(Exception e){

        }
    }
}
