import java.io.File

// first argument is a file name
val input_file_name: String = args[0]

println("Input file: " + input_file_name)

var curr_location: Int = 0

var curr_index: Int = 0

var continue_search = true

val input_lines: List<String> = File(input_file_name).readLines()

var visited_table: HashMap<Int, Boolean> = hashMapOf()

while (continue_search) {
    val curr_input: String = input_lines[curr_index]
    val direction = curr_input.substring(0,1)
    val magnitude = curr_input.substring(1).toInt()

    // determine direction of movement and travel the given magnitude
    if (direction == "+") {
        curr_location += magnitude
    }
    else {
        curr_location -= magnitude
    }

    when(visited_table[curr_location]) {
        true -> continue_search = false
        false -> println("This shouldn't happen ever.")
        null -> visited_table[curr_location] = true
    }

    curr_index = (curr_index + 1) % input_lines.size
}

println("Location repeated: " + curr_location)