/**
 */

import java.io.File

var name = ""
var notes = ""

val header = """<?xml version="1.0" encoding="US-ASCII" ?>
<advantage_list id="f6ba476b-99f4-422b-886e-7106f6f76d8f" version="1">
"""

val footer = """</advantage_list>
"""

fun template(archetype: String, name: String, description: String, notes: String) = """<advantage version="1">
    <name>${archetype}: ${name} - ${description}</name>
    <type>Mental</type>
    <notes>${notes}</notes>
    <categories>
        <category>${archetype}</category>
    </categories>
</advantage>
"""


fun extractNameToNotes(): Map<String, String> {
    val archetypesDir = File("/Users/dwebster/Documents/RPGs/Campaigns/Harmony of the Spheres/gurps-hots.wiki/characters/archetypes/")
    val nameToNotes = java.util.LinkedHashMap<String, String>()
    archetypesDir.listFiles().forEach { archetype ->
        var name = ""
        var notes = ""
        var notesOn = false
        archetype.forEachLine {
            if (it.startsWith("##")) name = it.replace("##", "").trim()
            if (it.startsWith("*")) notesOn = true
            if (notesOn) notes += " " + it.replace("*", "").trim()
        }
        notes = notes.replace("Vampire", "person")
        notes = notes.replace("vampire", "human")
        notes = notes.replace("Kindred", "person")
        notes = notes.replace("Final Death", "death")
        nameToNotes[name] = notes.trim()
    }
    return nameToNotes
}

fun addDescription(nameToNotes: Map<String, String>): Map<String, Pair<String, String>> {
    val archetypesList = File("/Users/dwebster/Documents/RPGs/Campaigns/Harmony of the Spheres/gurps-hots.wiki/characters/Archetypes.md")
    val nameToPair = java.util.LinkedHashMap<String, Pair<String, String>>()
    val regex = Regex("""\* \[([\w\s]+)\]\(.+\): (.+)""")
    archetypesList.forEachLine { line ->
        val match = regex.find(line)
        if (match != null) {
            val name = match.groupValues[1]
            val desc = match.groupValues[2]
            val notes = nameToNotes[name] ?: "FAIL"

            nameToPair[name] = Pair(desc, notes)
        }

    }
    return nameToPair
}

fun extractValues(): Map<String, Pair<String, String>> {
    val nameToNotes = extractNameToNotes()
    val nameToPair = addDescription(nameToNotes)
    return nameToPair
}

val values = extractValues()

val out = File("/tmp/Archetypes.adq")

out.delete()
out.createNewFile()

println("writing to ${out.absoluteFile}")

out.writer().use { writer ->
    writer.write(header)
    values.forEach { name, pair ->
        writer.write(template("Nature", name, pair.first, pair.second))
        writer.write(template("Demeanor", name, pair.first, pair.second))
    }
    writer.write(footer)
}
