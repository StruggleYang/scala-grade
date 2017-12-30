// 快学scala第一章，基础知识
object TestSeet1 {

  // 1.1，1.2，1.3
  val a = 8
  //a = 7 //无法改变一个常量
  var a1 = 7
  a1 = 777 // 改变一个变量值
  // 建议使用val
  val b = a + 3
  b * 10
  "hello scala".toUpperCase

  val xmax,ymax:Int = 100 // 声明多个值
  val str1,str2:String = "hello"
  // TODO 这里报错,var声明多个变量显然出现了问题
  //var str3,str4:String = "hello"

  // scala底层字符串用java.lang.String来表示，
  // 但是在此基础上通过StringOps对字符串加了上百中操作
  "hello".intersect("el") // 得到两个字符串中相同的部分
  "hello".intersect("world")


  //1.4算术运算符

  // scala没有++和--
  var num = 2
  num += 1 // 使num递增
  num
  num -= 2 // 递减，并且可以是任意值
  num
  // val定义的值是不可变的，所以递增递减都不可行
  val num1 = 2
  // num1 += 1 // val不可这样运算

  // 1.5方法调用
  // 没有参数的方法，不需要括号,无参数并且不修改对象
  666.toString

  import scala.math._ // 导入包
  import scala.util._

  // 在scala中 _ 是通配符类似java的*
  sqrt(2) // 开平方根
  pow(2,3) // x的n次方
  min(3,Pi) // 取小值

  // 如果不导入包，则包的全路径
  scala.math.max(3.2,4.5)

  Random.nextInt()
  // 生成指定位数的随机质数
  BigInt.probablePrime(100,Random)


  // 1.6 apply方法
  val s = "hello"
  s(3)
  // 等价于
  s.apply(3)
  // 坑，有时候需要显示的调用apply方法而不能直接()
  // "hello".sorted(3)
  "hello".sorted.apply(3)

  // 用于创建一个新对象
  BigInt.apply("122344455")

  // 练习
  // 平方根后再求平方误差
  var st = sqrt(3)
  3.0-pow(st,2)

  // 字符串乘以数字
  "hello" * 2 //产生两个相同的字符串

  /// 以下三个分别为表达式，函数,函数,三者等价
  10 min 2
  min(10,2)
  10.min(2)

  // 用BigInt计算2的平方
  BigInt(2).pow(1024)

  // 创建一个随机文件的方式是生成一个随机的BigInt，然后转换成36进制
  BigInt.apply(50,Random)

 "hello".take(3)

  "hello".drop(2)

}