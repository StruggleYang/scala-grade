import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting._

// 第三章 数组
object TestSeet3{

  // 3.1 定长数组
  // scala 定长数组就是java的定长数组
  val arr1 = new Array[Int](10)
  // 用（）访问元素
  arr1(0) = 1
  val arr2 = Array("hello","world")
  arr2(0)

  // 3.2变长数组:数组缓冲
  val arrbuf1 = ArrayBuffer[Int]()
  val arrbuf2 = new ArrayBuffer[Int]
  // 类似的，如java中的ArrayList
  //追加元素
  arrbuf1 +=1
  arrbuf1 +=(1,2,3,4)
  arrbuf1 ++= Array(5,6,7,8) // 追加任何集合
  arrbuf1.trimEnd(3) // 去除最后的n个
  // 在缓冲区的末尾添加或者移除是的

  // 但是插入是低效的，因为在那之后的元素都会被平移
  arrbuf1.insert(2,9) // 在下标为2的位置插入元素
  arrbuf1.insert(2,9,0,12) // 可以插入多个会依次排开

  // 移除
  arrbuf1.remove(2) // 移除下标的对应元素
  arrbuf1.remove(2,3) // 移除下标之后的n个元素

  // 转换
  arrbuf1.toArray // 缓冲转为数组
  arr1.toBuffer // 数组转为缓冲

  // 3.3 遍历数组和缓冲
  val arr3 = Array(3,4,5,6,7,8)
  // 如果需要用到数组下标
  for (i <- 0 until arr3.length){
    println(s"$i： ${arr3(i)}")
  }
  // until方法类似于to，只不过排除了最后一个元素，常说包含头不包含尾

  // 确定步长遍历
  for (i <- 0 until arr3.length by 2){
    println(s"$i： ${arr3(i)}")
  }
  // 尾端遍历(貌似并没有生效)
  for(i <- 0 until arr3.length by -1){
    println(s"$i： ${arr3(i)}")
  }
  // indices会生产数组的角标范围
  for(i <- arr3.indices){
    println(s"$i： ${arr3(i)}")
  }
  // 反转尾端遍历
  for(i <- arr3.indices.reverse){
    println(s"$i： ${arr3(i)}")
  }

  // 如果不需要用到角标
  for(i <- arr3){
    println(i)
  }

  // 3.4数组转换
  // yield推导式

  val arr3_1 = for(i <- arr3) yield 2+i

  // for/yield 创建一个类型与原集合相同的集合，并且集合不受影响

  // 移除一个集合，数组中的负数，思路不再是遍历这个集合然后该集合中移除，
  // 因为你在移除的同时你还要遍历它，你将它的元素移除了会影响到 原本的长度不是嘛
  // 而是将满足条件的用yield推导到一个新的集合
  val arr4 = Array(-1,-2,-4,3,-5,6,7)
  val arr4_1 = for{
    i <- arr4
    if (i>=0)
  } yield i

  // 还有更方便的方法就是filter
  val arr4_2 = arr4.filter(i => i>0)

  // 3.5 常用算法（对于缓冲区适用）
  val arr5 = Array(1,2,3,4,6,9)
  arr5.sum // 元素类型必6为数值
  arr5.max
  arr5.min
  arr5.sorted // 排序并返回新的数组或者缓冲区
  arr5.sortWith((x,y) => x>y) // 自定义比较函数排序
  arr5.sortWith(_>_) // 简写同上
  val arrbuf3 = ArrayBuffer[Int](2,6,3,1,8)
  arrbuf3.sortWith(_<_)
  // 快速排序只能是数组，缓冲不能
  quickSort(arr5)
  arr5
  //quickSort(arrbuf3) //错误

  // 显示数组或者缓冲内容
  arr5.mkString
  arr5.mkString(",") // 自定义分隔
  arr5.mkString("<",",",">") // 自定义开始结束
  // 嗯，比java的toString好用
  arr5.toString

  // 3.6 一些Api解读

  // def count(p:(A) => Boolean):Int
  // 接受一个前提作为参数，获得满足其中的boolean表达式的元素的个数
  val arr6 = Array(-1,-2,-4,3,-5,6,7)
  arr6.count(p => p >0)
  arr6.count(_>0) // 等价上
  // 3.7 多维数组

  val arr_arr = Array.ofDim[Double] (3,4) // 三行四列
  arr_arr(0)(0) = 1

  // 与java互操作



}