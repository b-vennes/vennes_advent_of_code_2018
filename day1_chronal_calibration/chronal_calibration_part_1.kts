import java.io.File

// first argument is a file name
val input_file_name: String = args[0]

println("Input file: " + input_file_name)

var curr_location: Int = 0

File(input_file_name).forEachLine {
    val input_value: String = it
    val direction = input_value.substring(0,1)
    val magnitude = input_value.substring(1).toInt()

    // determine direction of movement and travel the given magnitude
    if (direction == "+") {
        curr_location += magnitude
    }
    else {
        curr_location -= magnitude
    }
}

println(curr_location)