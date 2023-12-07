object DayOne {
  def run(): Unit = {
    val source = scala.io.Source.fromFile("src/input/input_dayOne.txt")
    val lines = try source.mkString.split("\n") finally source.close()
    val num_regex = raw"[0-9]".r
    var sum_ans = 0
    lines.foreach(i => sum_ans += num_regex.findFirstIn(i).get.toInt * 10 + num_regex.findAllIn(i).toList.last.toInt)
    println(sum_ans)
  }
}