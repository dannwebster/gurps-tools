import kotlin.io.println

val archetypes = mapOf(
        "Architect" to "You build something of lasting value",
        "Autocrat" to "You need control",
        "BonVivant" to "Life is for pleasure",
        "Bravo" to "Might makes right",
        "Capitalist" to "Why give it away for free when you can sell it?",
        "Caregiver" to "Everyone needs nurturing",
        "Celebrant" to "Your cause brings you joy",
        "Chameleon" to "You manage to blend into any situation",
        "Child" to "Won’t somebody be there for you?",
        "Competitor" to "You must be the best",
        "Conformist" to "You follow and assist",
        "Conniver" to "Others exist for your benefit",
        "CreepShow" to "Disgusting the straights makes you smile",
        "Curmudgeon" to "Everything has its flaws",
        "Dabbler" to "It’s always about the next big thing",
        "Deviant" to "The status quo is for sheep",
        "Director" to "You oversee what must be done",
        "Enigma" to "Just when people think they’ve figured you out, you change the game",
        "EyeOfTheStorm" to "Chaos and havoc follow you, but it never gets to you",
        "Fanatic" to "The cause is all that matters",
        "Gallant" to "You’re not the showstopper: you’re the show!",
        "Guru" to "People find you spiritually compelling",
        "Idealist" to "You believe in something greater",
        "Judge" to "Your judgment will improve things",
        "Loner" to "You make your own way",
        "Martyr" to "You suffer for the greater good",
        "Masochist" to "Pain reminds you that you still exist",
        "Monster" to "You’re Damned, so act like it!",
        "Pedagogue" to "You save others through knowledge",
        "Penitent" to "Life is a curse, and you must atone for it",
        "Perfectionist" to "You strive for an unattainable goal",
        "Rebel" to "You follow no one’s rules",
        "Rogue" to "It’s all about you",
        "Sadist" to "You live to cause pain",
        "Scientist" to "Everything is a puzzle to solve",
        "Sociopath" to "The inferior must be destroyed",
        "Soldier" to "You follow orders, but in your own way",
        "Survivor" to "Nothing can keep you down",
        "Thrill-Seeker" to "The rush is all that matters",
        "Traditionalist" to "As it has always been, so it must be",
        "Trickster" to "Laughter dims the pain",
        "Visionary" to "Something exists beyond all this"
)

val names = archetypes.keys.toList()

fun List<String>.random() = this[(Math.random() * this.size).toInt()]

val list = args.elementAtOrNull(0) == "-l"

if (!list) {
    val nature = names.random()
    val demeanor = names.random()

    println("Nature: ${nature} - ${archetypes[nature]}")
    println("Demeanor: ${demeanor} - ${archetypes[demeanor]}")
} else {
    archetypes.forEach { name, desc -> println("${name} - ${desc}") }
}
