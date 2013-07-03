# Android Image Map 

一个类似HTML map标签功能的Android组件。可以实现HTML里图片热点映射。

An android view like html map tag.

# 项目地址

  * 项目主页 <https://github.com/chenyoca/android-image-map>
  * 源码打包 <https://github.com/chenyoca/android-image-map/archive/master.zip>


## 截图

![ScreenShot](https://raw.github.com/chenyoca/android-image-map/master/screenshot.png)

## 特点

	 * 支持图像缩放和拖动。图中色块覆盖的区域为图片热点。图像缩放和拖动时，这些热点区域也会跟着缩放和移动。

	 * 支持 Circle,Rect,Poly 三种形状。对应的类为 CircleShape, RectShape, PolyShape。向ImageMap对象中添加即可。

	 * 支持纯生HTML map数据，可以直接把HTML Map生成的coords数据直接设置到Shape中。

	 * 支持Bitmap对象，res目录下的drawable文件等数据来源。

	 * 在代码中创建或者XML中布局。

 ## 使用

   **README文档可能会过时**，详细代码见sample项目。项目为Android可运行项目，直接运行即可。

 ```java
   
	//取得在XML中布局的ImageMap对象，并设置图片

   // set image
   ImageMap map = (ImageMap) findViewById(R.id.imagemap);
   Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.imm_01, new BitmapFactory.Options());
   map.setMapBitmap(bitmap);

   View bubble = getLayoutInflater().inflate(R.layout.popup,null);

   map.setBubbleView(bubble,new Bubble.BubbleDisplayer() {
       @Override
       public void onDisplay(Shape shape, View bubbleView) {
           ImageView logo = (ImageView) bubbleView.findViewById(R.id.logo);
           TextView name = (TextView) bubbleView.findViewById(R.id.name);

           name.setText(shape.tag.toString());
           logo.setImageResource(R.drawable.kfc_logo);
       }
   });

   // 设置一个形状
   // circle
   CircleShape black = new CircleShape("KFC Fastfood", Color.BLUE);
   black.setValues("292.35898,133.64102,15");


 ```
 
 ## 捐助

	开源是一种态度，不是义务。
	
	如果您觉得本开源项目对你有帮助，您可以对作者捐助 1 元以示支持。
	
支付宝捐助地址： [桥下一粒砂](https://me.alipay.com/yoojiachen)
