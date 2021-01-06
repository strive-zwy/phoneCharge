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
 * 退出系统
