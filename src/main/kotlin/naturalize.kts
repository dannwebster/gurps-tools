import kotlin.io.println

val archetypes = listOf(
    "Architect",
    "Autocrat",
    "Bon Vivant",
    "Bravo",
    "Capitalist",
    "Caregiver",
    "Celebrant",
    "Chameleon",
    "Child",
    "Competitor",
    "Conformist",
    "Conniver",
    "Creep Show",
    "Curmudgeon",
    "Dabbler",
    "Deviant",
    "Director",
    "Enigma",
    "Eye of the Storm",
    "Fanatic",
    "Gallant",
    "Guru",
    "Idealist",
    "Judge",
    "Loner",
    "Martyr",
    "Masochist",
    "Monster",
    "Pedagogue",
    "Penitent",
    "Perfectionist",
    "Rebel",
    "Rogue",
    "Sadist",
    "Scientist",
    "Sociopath",
    "Soldier",
    "Survivor",
    "Thrill-Seeker",
    "Traditionalist",
    "Trickster",
    "Visionary"
)

fun List<String>.random() = this[(Math.random() * this.size).toInt()]

val nature = archetypes.random()
val demeanor = archetypes.random()

println("Nature: ${nature}")
println("Demeanor: ${demeanor}")
