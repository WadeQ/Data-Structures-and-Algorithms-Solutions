object Main {

//    You are building a small part of this Android application that prints out log items.
//    The Kotlin function LogDumpGetUnique has a small set of log items stored in a string.
//    Each log item is separated by a semicolon. Your goal is to return a new string with the following requirements:1.
//    Remove log items that are duplicates based on username.2. From each log item, remove the id=NUM property and value.
//    For items that are duplicated based on the username, keep the first one that appears in the list and
//    remove the subsequent items.
//    The Android device on the right side takes in your output and presents it on screen in a formatted way so you can
//    easily visualize the log items.Example Inputname=Dan B, username=db, email=db@gmail.com, id=123; name=Hannah,
//    username=hsmith, id=333, email=hsm@test.com; name=Dan Brick, username=db, email=db@gmail.com, id=663;Example
//    Outputname=Dan B, username=db, email=db@gmail.com; name=Hannah, username=hsmith, email=hsm@test.com;
//
//    fun LogDumpGetUnique(): String {
//        var log_dump : String = "name=John Trust, username=john3, email=john3@gmail.com, id=434453; name=Hannah Smith, username=hsmith, email=hsm@test.com, id=23312; name=Hannah Smith, username=hsmith, id=3223423, email=hsm@test.com; name=Robert M, username=rm44, id=222342, email=rm@me.com; name=Robert M, username=rm4411, id=5535, email=rm@me.com; name=Susan Vee, username=sv55, id=443432, email=susanv123@me.com; name=Robert Nick, username=rnick33, id=23432, email=rnick@gmail.com; name=Robert Nick II, username=rnickTemp34, id=23432, email=rnick@gmail.com; name=Susan Vee, username=sv55, id=443432, email=susanv123@me.com;"
//        // code goes here
//    // return log_dump;
//
//    }
//
//    fun main() {
//        println(LogDumpGetUnique())
//    }

    private fun LogDumpGetUnique(): String {
        val cleanedLog = StringBuilder()
        val log_dump = "name=John Trust, username=john3, email=john3@gmail.com, id=434453; " +
                "name=Hannah Smith, username=hsmith, email=hsm@test.com, id=23312; " +
                "name=Hannah Smith, username=hsmith, id=3223423, email=hsm@test.com; " +
                "name=Robert M, username=rm44, id=222342, email=rm@me.com; " +
                "name=Robert M, username=rm4411, id=5535, email=rm@me.com; " +
                "name=Susan Vee, username=sv55, id=443432, email=susanv123@me.com; " +
                "name=Robert Nick, username=rnick33, id=23432, email=rnick@gmail.com; " +
                "name=Robert Nick II, username=rnickTemp34, id=23432, email=rnick@gmail.com; " +
                "name=Susan Vee, username=sv55, id=443432, email=susanv123@me.com;"
        val logItems = log_dump
                .split("; ".toRegex())
                .dropLastWhile { it.isEmpty() }.toTypedArray()
        val addedUsernames: MutableList<String> = ArrayList()
        for (logItem in logItems) {
            var addedValues = false
            var userName = ""
            val keyValues = logItem.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            for (keyValue in keyValues) {
                if (keyValue.contains("username")) userName = keyValue
                        .split("=".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
            }
            if (!addedUsernames.contains(userName)) {
                addedUsernames.add(userName)
                for (keyValue in keyValues) {
                    if (!keyValue.contains("id")) {
                        cleanedLog.append(keyValue).append(", ")
                        addedValues = true
                    }
                }
            }

            cleanedLog.deleteCharAt(cleanedLog.length - 2)
            if (addedValues) cleanedLog.append("; ")
        }
        return cleanedLog.toString()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(LogDumpGetUnique())
    }
}