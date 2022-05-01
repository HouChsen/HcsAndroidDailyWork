# 第9周 《手机移动开发》实践报告
### 实践目的
1. 能够运用 Spinner 和 ListView 构造应用程序
### 实践内容1：下拉列表 Spinner
#### 模块名
SpinnerActivity
#### 完成的主要功能
1. 体验使用 Spinner 实现简单下拉列表和列表对话框
#### 完成过程中遇到的问题及解决办法
1. 下拉模式的列表框没有内容：添加数组进array.xml文件并在布局文件通过entries引用
#### 完成该实践项目的收获及感想
1. 从代码的角度重新认识了列表框的实现
### 实践内容2：列表视图 ListView
#### 模块名
ListView1_Activity,ListView2_Activity,ListView3_Activity,ListView4_Activity,TextImageAdapter
#### 完成的主要功能
1. 通过继承 ListView 类来使用列表视图
1. 在 Activity 中自定义ListView
1. 自定义实现一个图片和文字混合的列表
#### 完成过程中遇到的问题及解决办法
1. 添加选项后点击，程序闪退：只需要在列表的监听事件中把数组访问改成通过动态数组的get（）即可。
1. 
#### 完成该实践项目的收获及感想
1. 可以考虑删除指定列
### 实践内容3：ListView 应用
#### 模块名
FileBrowseActivity,StudentAddActivity,StudentDBHelper,StudentQueryActivity
#### 完成的主要功能
1. 实现手机端的文件浏览器，可以显示文件/文件夹列表
1. 建立学生数据库，能够添加、删除、显示学生清单
1. 
#### 完成过程中遇到的问题及解决办法
1. 点击文件浏览器按钮就闪退：通过log.d()调试发现currentFiles为空指针而导致程序闪退：未授权访问外存以及“未对手机不支持打开子文件夹作出措施”
1. setAdapter(android.widget.ListAdapter)' on a null object reference ：没有实例化，少了findViewById代码
#### 完成该实践项目的收获及感想
1. 最开始出现一大堆的错误信息，无从下手，但通过输出语句调试最终把所有问题都解决了，这对我以后解决错误提供了思路。
1. 查询界面能够实现自主删除某几项信息，感觉很高级，对工程师的那个项目有帮助。