
import model._
import util.SumUtil

/**
  * test
  */
object Test {
  def main(args: Array[String]): Unit = {
    // 首次测试
    /* val c:Clazzs = Clazzs("高一1班")
    val l :List[Students] = DbRep.queryStudentsByClass(c)
    println(l)*/

   DbRep.queryGrades().foreach(getGradeAndClass(_)):Unit

    //获取所有年纪和班级
    def getGradeAndClass(grade:Grades):Unit ={
      val clazz = grade.calzz.foreach(x =>{
        analyzeClazzData(x)
      })

      // 年级数据
      analyzeGradeData(grade)
    }

    def analyzeGradeData(grades: Grades):Unit = {
      val students:List[Students] = DbRep.queryStudentsByGrade(grades)
      /*年纪*/
      println("\r\n---分析年级数据，年级名字："+grades.name+ "\r\n")
      //年纪总分前五名
      println("-----------------------年级总分前10名------------------------------------------")
      val st1:List[Students] = SumUtil.beforeRank(students,10)
      for (s <- st1){
        println( "姓名：" + s.name+" , 总分数： "+s.totailPoints())
      }
      println("-----------------------年级单科状元------------------------------------------")
      val st2= SumUtil.singleSexRank(students,new Lesson("语文"))
      val st3= SumUtil.singleSexRank(students,new Lesson("数学"))
      val st4 = SumUtil.singleSexRank(students,new Lesson("英语"))
      println("-----------------------语文单科状元------------------------------------------")
      println(st2)
      println("-----------------------数学单科状元------------------------------------------")
      println(st3)
      println("-----------------------英语单科状元------------------------------------------")
      println(st4)

    }

    // 班级分析
    def analyzeClazzData(clazz:Clazzs):Unit = {
      println("\r\n--开始分析班级，班级名字："+clazz.name+ "\r\n")
      val students:List[Students] = SumUtil.beforeRank(clazz.students,5)
      //总分前五名
      println("-----------------------总分前五名------------------------------------------")
      for(s <- students){
        println("姓名：" + s.name+" , 总分数： "+s.totailPoints())
      }
      val resChinese:List[Students] = SumUtil.beforeSingle(clazz.students,new Lesson("语文"),5)
      val resMath:List[Students] = SumUtil.beforeSingle(clazz.students,new Lesson("数学"),5)
      val resEnglish:List[Students] = SumUtil.beforeSingle(clazz.students,new Lesson("英语"),5)
      //单科前五
      println("-----------------------单科语文前五名------------------------------------------")
      for(s <- resChinese){
        println("姓名：" + s.name+" , 语文分数： "+s.chinesePoints)
      }

      println("-----------------------单科数学前五名------------------------------------------")
      for(s <- resMath){
        println("姓名：" + s.name+" , 数学分数： "+s.mathPoints)
      }

      println("-----------------------单科英语前五名------------------------------------------")
      for(s <- resEnglish){
        println("姓名：" + s.name+" , 英语分数： "+s.englishPoints)
      }

      println("-----------------------单科平均分-----------------------------------------")
      val resAvgChinese = SumUtil.SingleAvg(clazz.students,new Lesson("语文"))
      println(clazz.name+"-语文平均分-"+resAvgChinese)

      val resAvgMath = SumUtil.SingleAvg(clazz.students,new Lesson("数学"))
      println(clazz.name+"-数学平均分-"+resAvgMath)

      val resAvgEnglish = SumUtil.SingleAvg(clazz.students,new Lesson("英语"))
      println(clazz.name+"-英语平均分-"+resAvgEnglish)

      println("-----------------------单科等级比例-----------------------------------------")
      val chineseScale = SumUtil.LvScale(clazz.students,new Lesson("语文"))
      println("语文等级比例"+chineseScale)

      val mathScale = SumUtil.LvScale(clazz.students,new Lesson("数学"))
      println("数字等级比例"+mathScale)

      val englishScale = SumUtil.LvScale(clazz.students,new Lesson("英语"))
      println("英语等级比例"+englishScale)
    }

  }
}
