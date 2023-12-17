import scala.util.control.Breaks.{break, breakable}

object DayTwo {

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
      total += id
      breakable {
        var temp_red = List[Int]()
        num_regex_red.findAllIn(line).toList.foreach(i => temp_red = temp_red :+ i.replace("red", "").trim().toInt)
        //println(s"temp_red = $temp_red")
        if (temp_red.exists(_ > 12)) {
          //println(s"Found extra in RED for $line")
          sum_ans += id
          break
        }

        var temp_green = List[Int]()
        num_regex_green.findAllIn(line).toList.foreach(i => temp_green = temp_green :+ i.replace("green", "").trim().toInt)
        //println(s"temp_green = $temp_green")
        if (temp_green.exists(_ > 13)) {
          //println(s"Found extra in GREEN for $line")
          sum_ans += id
          break
        }
        var temp_blue = List[Int]()
        num_regex_blue.findAllIn(line).toList.foreach(i => temp_blue = temp_blue :+ i.replace("blue", "").trim().toInt)
        //println(s"temp_blue = $temp_blue")
        if (temp_blue.exists(_ > 14)) {
          //println(s"Found extra in BLUE for $line")
          sum_ans += id
          break
        }
      }
    }
    sum_ans = total - sum_ans
    println(s"result = $sum_ans")
  }
}
