# IntentUsage
Android的Intent使用方式简介
* // 显示启动方式一
```java
       startActivity(new Intent(MainActivity.this,SecondActivity.class));
```java
* // 显示启动第二种方式
                Intent intent = new Intent();
                ComponentName componentName = new ComponentName(MainActivity.this,SecondActivity.class);
                intent.setComponent(componentName);
                startActivity(intent);

