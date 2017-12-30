// 快学scala第二章，流程控制和函数
import java.net.URL

import scala.math._
import scala.io._
import scala.sys._
object TestSheet2{

  // 2.1 if表达式
  // scala的if语句/表达式有返回值
  val flag:Boolean = true

  val res = if (flag) "ok" else "no"

  // 可以返回任何类型
  val re1 = if (flag) 1 else "hello"

  // 如果缺失了else,不会出现任何问题
  // 如果无法匹配则返回Unit类(类似于java的void),字面量是"()"
  val re2 = if (!flag) 2
  // 等价
  val re3 = if (!flag) 2 else ()

  // 2.2 语句终止
  // scala 可以省略行尾分号，但是在一行有多个语句需要分号
  var tt = 2
  var jj = 0.0
  if (flag) {jj = jj-1;tt+1} else pow(2,3)

  // 2.3 块表达式和赋值
  // 块表达式用{},返回最后一个表达式
  val re4 = {val res41 = 41;res41}
  // 赋值返回值为Unit
  val re5 = {val res42 = 42}

  // 2.4 输入和输出
  val name = "StruggleYang"
  print("hello scala\n")
  println("hello scala")
  printf("Hello ,%s,%s %n","scala",name)
  println(s"Hello ,${name*2},$name") // 插值表达式

  // 从控制2读取值
  //StdIn.readLine("your name is :")

  // 2.5 循环

  // while 与java相同
  var n = 3
  var r = 2
  while (n > 0){
    r = r * n
    n -= 1
    println(r)
  }

  // for循环,x 遍历右边表达式的所有值
  for(x <- 1 to 3){
    println(x)
  }

  // 遍历字符串
  for(x <- "hello scala"){
    println(x)
  }

  // 高级for循环
  // 多个变量<-表达式
  for(x <- 1 to 3;y <- 1 to 3){
    println(x*y)
  }

  // 写法变换
  for{
    x <- 1 to 3
    y <- 1 to 3
  }println(x*y)

  // for推导式,构造出一个集合，没次循环都对应集合的一个值
  for(i <- 1 to 4) yield pow(i,2)

  // 写法变换
  for{
    i <- 1 to 4
  }yield pow(i,2)


  //2.7函数
  // def 定义函数,不需要写return，参数类型不能省略
  def fac(n:Int) = {
    for{
      i <- 1 to 4
    }yield n*i
  }

  fac(2)

  // 递归函数必须声明返回值类型
  def fac1(n:Int):Int = {
    if (n < 100){
      n*fac1(n*2)
    } else n
  }

  fac1(2)

  // 2.8 默认参数和带名参数

  // 如果不确定给某些参数，可以使用默认参数
  def fac2(st1:String,boolean: Boolean = true ) = {
    if (boolean) st1 else st1*2
  }

  fac2("hello scala ")
  fac2("hello scala ",false)
  fac2("hello def ",boolean = false) // 带名参数

  // 变长参数
  def fac3(n:Int*) = {
    var res = 0
    for(x <- n){
      res = x*2
    }
    res
  }

  fac3(1,2)
  // 2.10过程
  // 如果函数执行没有返回值则是过程，可以省略 =
  def fac4(str:String){
    println(str)
  }
  // 推荐的写法
  def fac5(str:String):Unit = {
    println(str)
  }


  // 2.11懒值
  // 当val 声明为lazy时，其初始化将被推迟到首次使用这个值得时候
  // 这个在程序或者REPL中尝试最佳，因为sheet总是会去使用这个,可以将文件名写错来验证加载
  // 懒值对开销大的十分有用
  lazy val file2 = Source.fromFile("D:\\test.txt","UTF-8").mkString
  val file1 = Source.fromFile("D:\\test.txt","UTF-8").mkString

  // 2.12 异常
  // 不需要声明异常的具体类型
  // 异常的语法采用模式匹配
  try {
    100/0
  }catch {
    case _:ArithmeticException => println("除了0")
    case ex:Exception => ex.printStackTrace()
  }

  // 练习
  for(x <- (1 to 10).sortWith((x,y)=>x>y)){
    println(x)
  }
  var ress = 1
  for(x <- "Hello"){
    if ("Hello"(1)==x){
      ress = x.toInt
    }else{
      ress *= x.toInt
    }
    println(x+"--"+ress)
  }
  println(ress.toLong)

  def fac6(x:Int,n:Int):Double = {
    if (n%2==0){
      fac6(x,n/2)
    } else {
      sqrt(pow(x,n))
    }
  }

  fac6(3,4)

}