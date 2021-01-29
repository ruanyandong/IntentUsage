package com.example.ai.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// adb shell dumpsys activity 查看activity信息
public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    private Button button1,button2,button3,button4,button5,button6;

    // 播放位置
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.start1);
        button2 = findViewById(R.id.start2);
        button3 = findViewById(R.id.start3);
        button4 = findViewById(R.id.start4);
        button5 = findViewById(R.id.start5);
        button6 = findViewById(R.id.start6);

        mediaPlayer = MediaPlayer.create(this,R.raw.jianchidaodi);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 显示启动方式一
                startActivity(new Intent(MainActivity.this,SecondActivity.class));

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 显示启动第二种方式
                Intent intent = new Intent();
                ComponentName componentName = new ComponentName(MainActivity.this,SecondActivity.class);
                intent.setComponent(componentName);
                startActivity(intent);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 打开系统浏览器
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("https://ruanyandong.github.io");
                intent.setData(uri);
                startActivity(intent);

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 打开系统相册
                 */
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivity(intent);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 发送系统短信
                 */
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"hello world");
                startActivity(intent);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * 拨打系统电话
                 */
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("tel:123456");
                intent.setData(uri);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        // 恢复播放
        if (position!=0){
            mediaPlayer.seekTo(position);
            mediaPlayer.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // 存储播放位置
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            position = mediaPlayer.getCurrentPosition();

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
