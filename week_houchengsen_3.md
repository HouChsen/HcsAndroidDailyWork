# 第3周 《手机移动开发》实践报告
### 实践目的
1. 能够在XML布局文件中设置布局和组件基本属性对界面进行管理
1. 能够在java文件中通过调用与设置属性相关的方法实现对界面的动态管理 
1. 能够用线性布局、表格布局、相对布局，为应用程序构造对用户友好的界面。
### 实践内容1：布局及组件的常用属性
#### 模块名
weekthree
#### 完成的主要功能
1. 通过改变属性的值从而改变页面布局
1. 
1. 
#### 完成过程中遇到的问题及解决办法
1. EditText中的代码“android:layout_gravity="bottom"”并没有让文本沉底，而是靠左。解决方法：bottm只有在布局是：horizontal才会沉底
1. 不显示分割线。解决方法：将组件的宽度由wrap_content改为match_parent
1. 
#### 完成该实践项目的收获及感想
1. 引用id时“@+id/....”，但引用字符串就少了个“+”,格式是“@string/.....”；另外，对id的创建比string复杂的多。
1. 在对文本中字体设置颜色但不知道某个颜色的代码时，可以先写一个自己已知的代码，然后在左侧框上点击出现的正方形，就可以选择特定颜色。
1. 
### 实践内容2：动态改变属性
#### 模块名
weekthree2

### 实践内容3：常用布局
#### 模块名
weekthree3
#### 完成的主要功能
1. 把页面上的组件分到表格里，实现对一个页面的多样操作
1. 
#### 完成过程中遇到的问题及解决办法
1. 添加图片时，图片过大。后来把图片组件嵌套进文本组件时，又导致图片过小显示不出，最后通过特殊符号代替图片完成。
1. 
#### 完成该实践项目的收获及感想
1. 为了以后对页面进行分块提供了思路
1. 
### 实践内容4：综合实践
#### 模块名
weekthree4
#### 完成的主要功能
1. 输入正确的学号和密码跳转，错误就报错。
1. 
#### 完成过程中遇到的问题及解决办法
1. 跳转后的页面显示语句不能都放到setText中（textView.setText(R.string.hy+intent.getStringExtra("msg")+R.string.tx);），而是先连接成一个字符串在输出
1. 
#### 完成该实践项目的收获及感想
1. 感觉可以结合文件系统，记录所有注册过的学生信息。
1. 