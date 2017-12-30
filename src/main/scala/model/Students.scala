package model

case class Students (
                 name:String,
                 sex:String,
                 chinese:Lesson,
                 math:Lesson,
                 english:Lesson
               ) {
  // 样例类默认实现toString方法
  override def toString: String = {
    "Student:[ name: "+name + " sex: "+sex+" chinese: "+chinese+" math: "+math+" english: "+english + " ]"
  }

  // 总分
  def totailPoints(): Int = {
    chinese.point + math.point + english.point
  }

  // 单科成绩
  def chinesePoints:Int = chinese.point

  def mathPoints:Int = math.point

  def englishPoints:Int = english.point
}

// 适合数据库返回的数据
case  class StudentWrapper (name:String,sex:String,chinese:Int,math:Int,english:Int)