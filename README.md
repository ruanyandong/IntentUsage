# IntentUsage
Android的Intent使用方式简介

* 显示启动方式一
```java
     startActivity(new Intent(MainActivity.this,SecondActivity.class));
```java

* 显示启动第二种方式
```java
                Intent intent = new Intent();
                ComponentName componentName = new ComponentName(MainActivity.this,SecondActivity.class);
                intent.setComponent(componentName);
                startActivity(intent);
```java

* 打开系统浏览器
```java
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("https://ruanyandong.github.io");
                intent.setData(uri);
                startActivity(intent);
```java

* 打开系统相册 
```java
               Intent intent = new Intent();
               intent.setAction(Intent.ACTION_GET_CONTENT);
               intent.setType("image/*");
               startActivity(intent);                
```java  

* 发送系统短信
```java
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"hello world");
                startActivity(intent);
```java                
                 
* 拨打系统电话  
```java
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("tel:123456");
                intent.setData(uri);
                startActivity(intent);
```java                
