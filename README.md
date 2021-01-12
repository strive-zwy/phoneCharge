# phoneCharge

java 小组课程设计 - 话费充值系统<br>

#### Phone
 * 带参数构造方法
 * set、get 方法
 * toString 方法
 * showInfo()打印信息方法

#### PhoneUtils
 * 对数据处理的工具类，增删改查
 * 方法都是静态的
 * private List&lt;Phone&gt; list = new ArrayList&lt;Phone&gt;();
 
#### DataInit
 * 数据初始化
 * 将数据读取/存储到TXT文档中，Java对象的序列化
 * 给出初始化数据，即 new Phone()对象

#### PhoneSystem
 * 先进行数据初始化
 * 登录系统
    + 超级管理员登录
        1. 查看系统所有用户信息
        2. 查看指定用户详细信息
        3. 在线选号
        4. 修改用户信息(根据字段 phoneNum 修改)
        5. 话费充值
        6. 用户注销（根据字段 phoneNum 删除）
        7. 导出数据（TXT）
        8. 退出系统
    + 普通管理员登录
        1. 查看系统所有用户信息
        2. 查看指定用户详细信息
        3. 话费充值
        4. 退出系统              
 * 话费充值
 * 退出系统

#### 代码运行
第一次执行时，先把 DataInit.Java 注释的代码解掉注释，并运行里面的 main 方法，进行系统测试数据的写入，运行时候会新生成新的 data.txt 文件
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210112193651900.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0MjM3NzE5,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210112193729646.PNG?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0MjM3NzE5,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210112193735236.png)
运行之后可以把代码重新注释，不注释也没事，然后运行 PhoneSystem.java中的 main 方法即可。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210112194119592.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0MjM3NzE5,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210112194123589.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0MjM3NzE5,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210112194130398.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0MjM3NzE5,size_16,color_FFFFFF,t_70)
普通管理员账号密码是 www、222；超级管理员密码是 zzz 、111，用户名和密码是代码写好的，想要修改的话修改 PhoneSystem.java 以下代码就可以啦。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210112194528417.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0MjM3NzE5,size_16,color_FFFFFF,t_70)
