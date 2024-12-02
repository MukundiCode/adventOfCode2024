fun main(args: Array<String>) {

    day1Part2()
}

private fun day1Part1() {
    val inputStream = {}.javaClass.classLoader.getResourceAsStream("day1input.txt")
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()
    val lines = inputStream?.bufferedReader()?.use {
        it.lines().map { line -> line.split("   ") }.forEach { splitted ->
            run {
                list1.add(splitted[0].toInt())
                list2.add(splitted[1].toInt())
            }
        }
    }

    list1.sort()
    list2.sort()

    var ans = 0;
    for (i in 0 until list1.size) {
        ans += Math.abs(list1[i] - list2[i])
    }

    println(ans)
}

private fun day1Part2(){
    val inputStream = {}.javaClass.classLoader.getResourceAsStream("day1input.txt")
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()
    val lines = inputStream?.bufferedReader()?.use {
        it.lines().map { line -> line.split("   ") }.forEach { splitted ->
            run {
                list1.add(splitted[0].toInt())
                list2.add(splitted[1].toInt())
            }
        }
    }

    list2.sort()

    val store = mutableMapOf<Int, Int>()
    var index = 0
    while (index < list2.size){
        var current = list2[index]
        var count = 1
        while (true) {
            index++
            if (index < list2.size && current == list2[index]){
                count++
            } else {
                break
            }
        }
        store.put(current, count)
    }

    println(store)

    var ans = 0

    for (i in list1) {
        ans += i * store.getOrDefault(i, 0)
    }

    println(ans)
}