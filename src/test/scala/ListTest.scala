
object ListTest {
  def main(args: Array[String]): Unit = {
    val arr = 1 to 10
    val list = List("1","2","3","4","5")
    val list1 = List("a","b","c","d","e")

    // 循环
    for( a <- arr){
     // println( "Value of arr: " + a )
    }

    // 多个范围
    for (s <- list ; a <- arr){
      println( "Value of list: " +s)
      println( "Value of arr: " + a )
    }

    // 简易
   for (s <- list)println( "Value of list: " +s)

    // 过滤
    for(
      s <- list
      if s != "3"
    )print(s)

    // yield
    val res = for {
      s <- list
     /* s1 = s.toUpperCase() // 循环内定义 临时变量接收变量操作后的值*/
      s1 = s match {
      case "1" => "one"
      case "2" => "two"
      case "3" => "three"
      case _ => s
    }
    } yield s1
    println(res)

    // list添加成员
    val list2 = "6"::list
    for (s <- list2)println(s)

    // 连接两个list
    val list3 = list:::list1
    println()
    for (s <- list3)print(s)

    // 返回第一个
    println(list.head)

    // 返回第一个之外的
    println(list.tail)

    // 判断 是否为空
    println(list.isEmpty)


    // 不推荐的做法，循环变换值直接用map方法
    val list4 = for {
      x <- list
      s2 = x.toInt
    } yield s2
    // 过滤满足条件的元素
    val list5 = list.map(x => x.toInt).filter(x => x%2 == 1)
    val list55 = list.map(x => x.toInt).filter(x => x%2 == 0)
    println(list5)
    println(list55)

    // 计算一段字符串中的某个字符出现的次数,不分大小写
    val str = "sdfsdjkfhsdjfsdjfsduiweiyhuwehushfsfbsdjfsdbjfsdbskjlfhsdfsjwehweusmvsnlassn"
    println(charCount(str,'s'))

    // List包裹list
    val list7 = List(list,list1)

    // flatten扁平化list,将嵌套的结构展开.
    val list8 = list7.flatten
    println(list8)
    // 等价,flatMap结合了map和flatten的功能。接收一个可以处理嵌套列表的函数，然后把返回结果连接起来。
    //val list9 = list7.flatMap(_)
    println(list8)

    //把列表合并成单一元素
    // 等价
    println(list5.reduce((a,b) => a+b))
    println(list5.reduce(_+_))
    println(list5.reduceLeft(_+_))
    println(list5.reduceRight(_+_))
    println(list5.sum)

    // 排序
    val list9 = List(4,5,6,8,2,3,1)
    val list10 = List(4,2,3,5,6,8)
    val user = List(("struy",20),("struy1",18),("struy2",25),("struy3",17),("struy4",30))
    // sortBy 按照应用函数产生的元素排序
    val user1 = user.sortBy{case(user,age) => age}
    println(user1)
    //sorted 根据元素自身进行排序
    println(list9.sorted)
    // sorted 根据自定义函数排序,传入集合中两个元素
    println(list9.sortWith{(x,y) => x>y})
    // 取两集合的差集
    println(list9 diff list10)
    println(list9.diff(list10))
    // 将两个列表链接
    println(list9 union list10)
    println(list9.union(list10))
    println(list9 ++ list10)
    // 取交集
    println(list9 intersect list10)
    println(list9.intersect(list10))
    // distinct去重
    println((list9 ++ list10).distinct)
    val user3 = List(("struy",20),("struy",18),("struy2",25),("struy2",17),("struy2",30))
    val user4 = List(("struy",20,"男"),("struy",18,"女"),("struy2",25,"男"),("struy2",17,"女"),("struy2",30,"男"))
    // 分组按照_n元素分组
    println(user3.groupBy(_._1))
    // 按照指定的单个或者多个字段排序
    println(user4.groupBy{case (name,age,sex) => name})
    println(user4.groupBy{case (name,age,sex) => (name,sex)})
    // 按照固定的大小进行排序
    println(user4.grouped(2).toList)
    //从一个初始值开始,默认从左向右进行op操作
    println(list9.scan(10)((x,y) => x+y))
    println(list9.scan(10)(_+_))
    //scanLeft，scanRight

  }

  def charCount(str:String,char: Char): Int ={
    str.toUpperCase.toList.count(s => s==char.toUpper)
  }


}
