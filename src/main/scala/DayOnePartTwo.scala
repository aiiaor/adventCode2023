import scala.language.postfixOps

object DayOnePartTwo {
  def run(): Unit = {
    val three_text_num = Map(
      "one" -> 1,
      "two" -> 2,
      "six" -> 6)
    val four_text_num = Map(
      "four" -> 4,
      "five" -> 5,
      "nine" -> 9)
    val five_text_num = Map(
      "three" -> 3,
      "seven" -> 7,
      "eight" -> 8)
    val source = scala.io.Source.fromFile("src/input/input_dayOne_partTwo.txt")
    val lines = try source.mkString.split("\n") finally source.close()
    var i = 0
    var sum_ans = 0
    val num_regex = raw"[0-9]".r
    for (line <- lines){
      i = 0
      var text_to_num = ""
      while (i < line.length) {
        if(num_regex.matches(line.substring(i,i+1))){
          text_to_num += line.substring(i,i+1)
        }else {
          if(i < line.length-2) {
            if (three_text_num.contains(line.substring(i, i + 3))) {
              text_to_num += three_text_num.get(line.substring(i, i + 3)).mkString
            }
          }
          if (i < line.length-3) {
            if( four_text_num.contains(line.substring(i,i+4))) {
              text_to_num += four_text_num.get(line.substring(i,i+4)).mkString
            }
          }
          if (i < line.length-4) {
            if( five_text_num.contains(line.substring(i,i+5))) {
              text_to_num += five_text_num.get(line.substring(i,i+5)).mkString
            }
          }
        }
        i+=1
      }
      println(s"value = ${num_regex.findFirstIn(text_to_num).get.toInt * 10 + num_regex.findAllIn(text_to_num).toList.last.toInt}")
      sum_ans += num_regex.findFirstIn(text_to_num).get.toInt * 10 + num_regex.findAllIn(text_to_num).toList.last.toInt
    }

    println(sum_ans)

  }
}
