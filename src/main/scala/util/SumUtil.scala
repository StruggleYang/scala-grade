package util

import model.{Lesson,Students}

/**
  * 工具类
  */
object SumUtil {

  /**
    * 计算总分前几名
    */
  def beforeRank(students:List[Students],n:Int):List[Students] = {

    students.sortWith((s,t) =>s.totailPoints() > t.totailPoints()).take(n)
  }

  /**
    * 计算单科前N名
    * @param students
    * @return
    */
  def beforeSingle(students:List[Students], less:Lesson, n:Int): List[Students] = {
    singleRank(students,less).take(n)
  }

  /**
    * 计算单科排名
    */
  def singleRank(students: List[Students],lesson: Lesson) = {
    val res = lesson.name match {
      case "语文" => students.sortWith((s,t) => s.chinesePoints > t.chinesePoints)
      case "数学" => students.sortWith((s,t) => s.mathPoints > t.mathPoints)
      case "英语" => students.sortWith((s,t) => s.englishPoints > t.englishPoints)
    }
    res
  }

  /**
    * 计算单科男女状元
    */
  def singleSexRank(students: List[Students],lesson: Lesson) = {
    // 男状元
    val res:Students = lesson.name match {
      case "语文" => students.filter(_.sex == "男").sortWith((s,t) => s.chinesePoints > t.chinesePoints).head
      case "数学" => students.filter(_.sex == "男").sortWith((s,t) => s.mathPoints > t.mathPoints).head
      case "英语" => students.filter(_.sex == "男").sortWith((s,t) => s.englishPoints > t.englishPoints).head
    }
    // 女状元
    val res1:Students = lesson.name match {
      case "语文" => students.filter(_.sex == "女").sortWith((s,t) => s.chinesePoints > t.chinesePoints).head
      case "数学" => students.filter(_.sex == "女").sortWith((s,t) => s.mathPoints > t.mathPoints).head
      case "英语" => students.filter(_.sex == "女").sortWith((s,t) => s.englishPoints > t.englishPoints).head
    }
    Map("男状元" -> res.name,"女状元" -> res1.name)
  }

  /**
    * 计算单科平均分
    */
  def SingleAvg(students: List[Students],lesson: Lesson):Double = {
    // for 循环中的 yield 会把当前的元素记下来，保存在集合中，循环结束后将返回该集合。Scala 中 for 循环是有返回值的。
    // 如果被循环的是 Map，返回的就是  Map，被循环的是 List，返回的就是 List，以此类推。

    val res:List[Int] = lesson.name match {
      case "语文" => for( s <- students) yield  s.chinesePoints
      case "数学" => for( s <- students) yield  s.mathPoints
      case "英语" => for( s <- students) yield  s.englishPoints
    }
    val total:Double = res.length
    val sum:Double = res.sum
    // 保留小数
     (sum/total).formatted("%.2f").toDouble
  }

  /**
    *计算等级比例
    */
  def LvScale(students: List[Students],lesson: Lesson) = {
    val res:List[Lesson] = lesson.name match {
      case "语文" => for( s <- students) yield  new Lesson(lesson.name,s.chinesePoints)
      case "数学" => for( s <- students) yield  new Lesson(lesson.name,s.mathPoints)
      case "英语" => for( s <- students) yield  new Lesson(lesson.name,s.englishPoints)
    }

    val sA = res.count(_.rank == "优")
    val sB = res.count(_.rank == "良")
    val sC = res.count(_.rank == "及格")
    val sD = res.count(_.rank == "不及格")

    val perA = BigDecimal(sA*100/res.size).setScale(2,BigDecimal.RoundingMode.HALF_UP)
    val perB = BigDecimal(sB*100/res.size).setScale(2,BigDecimal.RoundingMode.HALF_UP)
    val perC = BigDecimal(sC*100/res.size).setScale(2,BigDecimal.RoundingMode.HALF_UP)
    val perD = BigDecimal(sD*100/res.size).setScale(2,BigDecimal.RoundingMode.HALF_UP)

    Map("优" -> (perA+"%"),"良" -> (perB+"%"),"及格" -> (perC+"%"),"不及格" ->(perD+"%"))
  }


}
