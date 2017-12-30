package model

class Clazzs(val name:String) { // 伴生类
  var students:List[Students] = Nil
  def getStudents = DbRep.queryStudentsByClass(this)
  def this(name: String,students: List[Students]){
    this(name)
    this.students = getStudents
  }
}

object Clazzs{ // 伴生对象
  def apply(name: String): Clazzs = new Clazzs(name)
  def apply(name: String,students: List[Students]):Clazzs = new Clazzs(name,students)
}
