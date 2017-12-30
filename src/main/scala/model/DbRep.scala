package model

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource
import wangzx.scala_commons.sql._

object DbRep {
  val dataSource = {

    val ds = new MysqlDataSource
    ds.setURL(s"jdbc:mysql://127.0.0.1/scala_grade?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull")
    ds.setUser("root")
    ds.setPassword("123456")
    ds
  }

  // 所有学生
  def queryStudents():List[Students] = {
    val rows = dataSource.rows[StudentWrapper]("""SELECT * FROM scala_student""")

    val res = rows.map( x => Students(x.name,x.sex,Lesson("语文",x.chinese),Lesson("数学",x.math),Lesson("英语",x.english)))
    res
  }

  // 所有年纪及班级
  def queryGrades():List[Grades] = {
    val rows = dataSource.rows[Row]("""SELECT sg.`name` as g_name, sc.`name` as c_name FROM `scala_clazz` as sc LEFT JOIN scala_grade as sg on sc.g_id = sg.id""")

    val res = rows.groupBy(_.cells(0).value)
    val res1 = res.map(x => Grades(x._1.toString,x._2.map(x => Clazzs(x.cell(2).value.toString,Nil))))
    res1.toList
  }

  // 根据年级名称获取所属年级的学生
  def queryStudentsByGrade(grades: Grades):List[Students] = {
    val rows = dataSource.rows[StudentWrapper](s"""SELECT ss.* FROM `scala_student` as ss LEFT JOIN scala_clazz as sc ON ss.c_id =sc.id LEFT JOIN scala_grade as sg on sg.id = sc.g_id WHERE sg.name = '${grades.name}'""")
    val res = rows.map( x => Students(x.name,x.sex,Lesson("语文",x.chinese),Lesson("数学",x.math),Lesson("英语",x.english)))
    res
  }

  // 根据班级信息查出班级的所以学生
  def queryStudentsByClass(clazzs: Clazzs):List[Students] = {
    val rows = dataSource.rows[StudentWrapper](s"""SELECT * FROM scala_student ss LEFT JOIN scala_clazz sc on ss.c_id = sc.id WHERE sc.name = '${clazzs.name}'""")

    val res = rows.map(x => Students(x.name,x.sex,Lesson("语文",x.chinese),Lesson("数学",x.math),Lesson("英语",x.english)))
    res
  }

}
