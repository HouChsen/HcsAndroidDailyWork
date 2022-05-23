# 第12周 《手机移动开发》实践报告
### 实践目的
1. 了解基于TCP协议的网络通信协议，能够用Socket组件完成移动客户端与服务器的通信
1. 能够熟练使用URLConnection和HttpURLConnection进行网络通信
1. 能够使用WebView组件浏览网页
1. 能够使用AsynTsak类实施异步任务
1. 能够连接MySQL实现企业级云端数据库的操作
1. 会使用Android Studio中提供的调试功能
### 实践内容1：Socket连接
#### 模块名
Server，SocketClientActivity
#### 完成的主要功能
1. 实现客户机与服务器通信
#### 完成该实践项目的收获及感想
1. 学习了socket的使用
1. 客户机和服务器要在两个IDE或两台设备运行
### 实践内容2：URL连接
#### 模块名
GetPostUtil,URLConnectionActivity
#### 完成的主要功能
1. 用GET方法和POST方法读取WEB网页
1. 利用webView呈现网页
#### 完成过程中遇到的问题及解决办法
1. activity_urlconnection.xml中WebView组件报错，原因是这个组件的线性布局LinearLayout中layout_height="wrap_content"，改成match_parent即可
1. URL中点击源文件形式，网页形式，get方法，post方法，不跳转。
#### 完成该实践项目的收获及感想
1. 可以在网页访问自定义的jsp文件
### 实践内容3：Http连接
#### 模块名
HttpURLConnectionActivity
#### 完成的主要功能
1. 通过给出的URL，在应用中获得页面代码和图片
#### 完成该实践项目的收获及感想
1. 能够通过给出的URL，在应用中获得页面代码和图片
### 实践内容4：MySQL数据库连接
#### 模块名
MySQLConnectionActivity，Reader，DBUtils
#### 完成的主要功能
1. 在MySQL中建立数据库，完成查询功能已经增删改查的操作。
1. 对于查询，还可以实现模糊查找
#### 完成该实践项目的收获及感想
1. 进一步熟悉了数据库的建立过程已经如何对其进行基本操作。