import scala.util.control.Breaks.{break, breakable}

object DayTwoPartTwo {
  def run(): Unit = {
    val source = scala.io.Source.fromFile("src/input/input_dayTwo.txt")
    val lines = try source.mkString.split("\n") finally source.close()
    val num_regex_red = raw" [0-9]+ red".r
    val num_regex_green = raw" [0-9]+ green".r
    val num_regex_blue = raw" [0-9]+ blue".r
    var sum_ans = 0
    var total = 0
    for (line <- lines) {
      var id = line.split(":").head.replace("Game","").trim().toInt
      breakable {
        var temp_red = List[Int]()
        num_regex_red.findAllIn(line).toList.foreach(i => temp_red = temp_red :+ i.replace("red", "").trim().toInt)
        var temp_green = List[Int]()
        num_regex_green.findAllIn(line).toList.foreach(i => temp_green = temp_green :+ i.replace("green", "").trim().toInt)
        var temp_blue = List[Int]()
        num_regex_blue.findAllIn(line).toList.foreach(i => temp_blue = temp_blue :+ i.replace("blue", "").trim().toInt)
        sum_ans += temp_red.max * temp_green.max * temp_blue.max

      }
    }
    println(s"result = $sum_ans")
  }


}
