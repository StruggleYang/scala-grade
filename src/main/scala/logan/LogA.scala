package logan

import java.text.SimpleDateFormat

import io.Source
import scala.annotation.tailrec

/**
  * 日志分析
  * 统计每个服务的调用次数，平均时长，并统计top95、top99的平均时长
  * 根据业务线程池的线程号来分析单次的服务调用
  *
  */
object LogA {

  type TIME = String
  type  THREAD =String
  type  SERVICE = String
  type  WAYS = String
  type  METHOD = String
  val sdf = new SimpleDateFormat("MM-dd hh:mm:ss SSS")
  val regex =  """(\d{2}-\d{2} \d{2}:\d{2}:\d{2} \d{3}) ([^\s]+) DEBUG ([^\s]+) ([^\s]+) ([^\s]+) ([^\s]+) (.+)""".r

  def main(args: Array[String]): Unit = {
    println("-------------------------------服务调用次数---------------------------")
    AnyServerUseCount

    println("-------------------------------单次服务的调用平均---------------------------")
    singleServerUseTime
  }

  //每一个服务调用次数
  def AnyServerUseCount() = {
    val source = Source.fromFile("E:\\detail-productdb.log", "UTF-8")

    val lists:List[(TIME,THREAD,SERVICE,METHOD,WAYS)] = source.getLines().collect{
      case regex(timestamp, thread,c,service,version,method,requests) => (timestamp,thread,service,method,requests)
    }.toList

    val requests:List[(String,String,String)] =lists.filter(_._5.contains("request")).map(line => {
      (line._1,line._2,line._3+"."+line._4)
    } )

    val countByServiceName:Map[String,Int] = requests.map((_,1)).groupBy(_._1._3).map(t => (t._1,t._2.size))

    countByServiceName.foreach {
      case (s, c) => println(s"${s}  count is : ${c}")
    }

    source.close()
  }

  // response - request 得到 服务调用时长
  def singleServerUseTime() = {
    val source = Source.fromFile("E:\\detail-productdb.log", "UTF-8")

    val lists:List[(TIME,THREAD,SERVICE,METHOD,WAYS)] =  source.getLines().collect{
      case regex(timestamp, thread,c,service,version,method,requests) => (timestamp,thread,service,method,requests)
    }.toList

    val request:List[(TIME,THREAD,SERVICE,WAYS)] = lists.filter(_._5.contains("reuest")).map(line =>{
      (line._1,line._2,line._3+"."+line._4,"request")
    } )
    val response:List[(TIME,THREAD,SERVICE,WAYS)] = lists.filter(_._5.contains("response")).map(line =>{
      (line._1,line._2,line._3+"."+line._4,"response")
    } )

    val totalServices =  (request ++ response).sortWith((x,y)=> x._1 > y._1).take(10)

    processByTailRec(totalServices,Map[(THREAD,SERVICE),TIME]())
    source.close()
  }

  @tailrec
  def processByTailRec(array:List[(TIME,THREAD,SERVICE,WAYS)],pendings:Map[(THREAD,SERVICE),TIME]):Unit = {
    array match {
      case (time,thread,service,"response")::tail =>
        pendings.get(thread,service) match {
          case Some(time0) =>
            val msg = s"Thrad:${thread}  Service:${service} average-time:  ${BigDecimal(sdf.parse(time).getTime - sdf.parse(time0).getTime)} ms"
            println(msg)
            processByTailRec(tail,pendings - ((thread,service)))
          case None =>
            processByTailRec(tail,pendings)
        }

      case (time,thread,service,"request") ::tail =>
        processByTailRec(tail,pendings+((thread,service)->time))
      case Nil =>None
    }
  }
}
