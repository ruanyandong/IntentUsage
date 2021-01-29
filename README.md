# IntentUsage
Android的Intent使用方式简介

// 显示启动方式一
     startActivity(new Intent(MainActivity.this,SecondActivity.class));


 // 显示启动第二种方式
                Intent intent = new Intent();
                ComponentName componentName = new ComponentName(MainActivity.this,SecondActivity.class);
                intent.setComponent(componentName);
                startActivity(intent);

// 打开系统浏览器
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("https://ruanyandong.github.io");
                intent.setData(uri);
                startActivity(intent);
                
//打开系统相册                 
               Intent intent = new Intent();
               intent.setAction(Intent.ACTION_GET_CONTENT);
               intent.setType("image/*");
               startActivity(intent);                
                  
// 发送系统短信
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"hello world");
                startActivity(intent);
                 
// 拨打系统电话  
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("tel:123456");
                intent.setData(uri);
                startActivity(intent);
