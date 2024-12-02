fun main(args: Array<String>) {

    val inputStream = {}.javaClass.classLoader.getResourceAsStream("day2input.txt")

    val lines = inputStream?.bufferedReader()?.use {
        it.lines().map { line -> line.split(" ").map { num -> num.toInt() } }.toList()
    }

    part1(lines)
    part2(lines)
}

private fun part1(lines: MutableList<List<Int>>?) {
    var answer = 0;
    if (lines != null) {
        for (line in lines) {
            val isSafe = getIsSafe(line)
            if (isSafe) {
                answer++
            }
        }
    }

    println(answer)
}

private fun part2(lines: MutableList<List<Int>>?) {
    var answer = 0;
    if (lines != null) {
        for (line in lines) {
            val isSafe = getIsSafe(line)
            if (isSafe) {
                answer++
            } else {
                //try removing one
                for (x in line.indices) {
                    var tempLine: MutableList<Int> = line.toMutableList()
                    tempLine.removeAt(x);
//                    println("newLine: " + tempLine)
                    if (getIsSafe(tempLine)) {
                        answer++
                        break
                    }
                }
            }
        }
    }

    println(answer)
}

private fun getIsSafe(
    line: List<Int>
): Boolean {
    var isIncreasing: Boolean? = null;
    var isSafe = true
    for (i in 0..line.size - 2) {
        val diff = line[i] - line[i + 1]
        if (isIncreasing == null) {
            isIncreasing = diff < 0
//                    println("incr set: " + isIncreasing)
        }
        if (isIncreasing != diff < 0) {
            isSafe = false
            break
        }
        if (Math.abs(diff) > 3 || Math.abs(diff) < 1) {
            isSafe = false
            break
        }
    }
    return isSafe
}