package com.giant_monkey.dev.screenshot;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    RelativeLayout view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    view = (RelativeLayout) findViewById(R.id.activity_main);

                    View v1 = view.getRootView();
                    v1.setDrawingCacheEnabled(true);
                    v1.getRootView().buildDrawingCache();
                    Bitmap scrimg = v1.getRootView().getDrawingCache();
                    FileOutputStream out = new FileOutputStream("/sdcard/DCIM/screen.png");
                    scrimg.compress(Bitmap.CompressFormat.PNG, 100, out);
                    System.out.println("완료");
                } catch (FileNotFoundException e) {
                    Log.d("FileNotfountException",e.getMessage());
                }
            }
        });
    }

//    private void screenshot(Bitmap bm) {
//
//        try {
//            File path = new File(Environment.getExternalStorageDirectory()+"/DCIM");
//            if(! path.isDirectory()) {
//                path.mkdir();
//            }
//
//            String temp = Environment.getExternalStorageDirectory()+ "/DCIM/";
//            temp = temp + "screen";
//            temp = temp + ".jpg";
//
//            FileOutputStream out = new FileOutputStream(temp);
//            bm.compress(Bitmap.CompressFormat.JPEG, 100, out);
//
//            sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://"+ Environment.getExternalStorageDirectory())));
//
//
//        } catch (FileNotFoundException e) {
//            Log.d("FileNotFoundException:", e.getMessage());
//        }
//    }
}
