# 第11周 《手机移动开发》实践报告
### 实践目的
1. 理解服务的意义和应用场景
1. 理解服务的生命周期，开发自定义的服务
1. 能够将服务用于实际的应用场景中
### 实践内容1：调用服务
#### 模块名
MyService
#### 完成的主要功能
1. 创建服务，通过日志观察服务的生命周期
#### 完成过程中遇到的问题及解决办法
1. couldn't log to binary event log: overflow，解决：启动service页面时误以为还是startActivity（），最后改成startService()即可。
#### 完成该实践项目的收获及感想
1. 可以启动多次service服务，但是关闭只需要一次即可
1. 知道了服务的生命周期
### 实践内容2：绑定服务
#### 模块名
MyService
#### 完成的主要功能
1. 实现Service和Activity之间传递数据
#### 完成过程中遇到的问题及解决办法
1. 
#### 完成该实践项目的收获及感想
1. 通过观察日志窗口，理解Service绑定的工作过程
### 实践内容3：执行耗时服务
#### 模块名
MyNewThreadService,MyIntentService
#### 完成的主要功能
1. 在Service中新开线程
#### 完成过程中遇到的问题及解决办法
1. MyIntentService创建是继承的Service，报错，改成IntentService后加上onHandleIntent()即可。
没有使用PendingIntent.getActivity（），而使用的PendingIntent.getActivities()，报错
#### 完成该实践项目的收获及感想
1. 
### 实践内容4：系统服务
#### 模块名
MainActivity
#### 完成的主要功能
1. 通知服务
#### 完成过程中遇到的问题及解决办法
1. 
#### 完成该实践项目的收获及感想
1. 
### 实践内容5：服务的应用
#### 模块名
InteractActivity
#### 完成的主要功能
1. 后台音乐
1. 随机选号
#### 完成过程中遇到的问题及解决办法
1. java.lang.NullPointerException，空指针错误。只需要把实例化和监听事件分开写，再加上对应的变量声明即可。但是有些地方就不报错，还不清楚原因。
#### 完成该实践项目的收获及感想
1. 