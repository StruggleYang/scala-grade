package model

case class Lesson(name:String,point:Int = 0) {

  // case成绩等级
  def caseRank(point:Int) = point match {
    case i if i >= 90  => "优"
    case i if i >= 75 && i < 90  => "良"
    case i if i >= 60 && i < 75  => "及格"
    case _   => "不及格"
  }

  // 赋值到属性
  var rank = caseRank(point)

  override def toString: String = "Lesson:[ name: "+name + " point: "+point+" rank: "+rank+ " ]"
}
