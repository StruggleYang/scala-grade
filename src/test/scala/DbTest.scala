import com.mysql.jdbc.jdbc2.optional.MysqlDataSource

object DbTest {
  val dataSource = {

    val ds = new MysqlDataSource
    ds.setURL(s"jdbc:mysql://127.0.0.1/scala_grade?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull")
    ds.setUser("root")
    ds.setPassword("123456")
    ds
  }

  def main(args: Array[String]): Unit = {
    println(dataSource)
  }
}
