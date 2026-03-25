package com.tsdtrainer.app.data

import com.tsdtrainer.app.models.*

object KoreanTermRepository {

    private val terms = listOf(
        // White Belt - Numbers
        KoreanTerm(Belt.WHITE, "Numbers", "One", "Hana"),
        KoreanTerm(Belt.WHITE, "Numbers", "Two", "Tul"),
        KoreanTerm(Belt.WHITE, "Numbers", "Three", "Set"),
        KoreanTerm(Belt.WHITE, "Numbers", "Four", "Net"),
        KoreanTerm(Belt.WHITE, "Numbers", "Five", "Tasot"),
        KoreanTerm(Belt.WHITE, "Numbers", "Six", "Tosot"),
        KoreanTerm(Belt.WHITE, "Numbers", "Seven", "Ilgop"),
        KoreanTerm(Belt.WHITE, "Numbers", "Eight", "Yodol"),
        KoreanTerm(Belt.WHITE, "Numbers", "Nine", "Ahop"),
        KoreanTerm(Belt.WHITE, "Numbers", "Ten", "Yol"),

        // White Belt - Kicks
        KoreanTerm(Belt.WHITE, "Kicks", "Front Kick", "Ahp Cha Ki"),
        KoreanTerm(Belt.WHITE, "Kicks", "Side Kick", "Yup Cha Ki"),
        KoreanTerm(Belt.WHITE, "Kicks", "Round Kick", "Tollyo Cha Ki"),
        KoreanTerm(Belt.WHITE, "Kicks", "Spinning Back Kick", "Dwi Tollyo Cha Ki"),
        KoreanTerm(Belt.WHITE, "Kicks", "Jump Front Kick", "E Dan Ahp Cha Ki"),
        KoreanTerm(Belt.WHITE, "Kicks", "Jump Round Kick", "E Dan Tollyo Cha Ki"),

        // White Belt - Stances
        KoreanTerm(Belt.WHITE, "Stances", "Stance", "Ja Seh"),
        KoreanTerm(Belt.WHITE, "Stances", "Ready Stance", "Choon Be Ja Seh"),
        KoreanTerm(Belt.WHITE, "Stances", "Front Stance", "Chun Kul Ja Seh"),
        KoreanTerm(Belt.WHITE, "Stances", "Fighter Stance", "Hu Kul Ja Seh"),
        KoreanTerm(Belt.WHITE, "Stances", "Horse Stance", "Kee Ma Ja Seh"),

        // White Belt - Blocks
        KoreanTerm(Belt.WHITE, "Blocks", "High Block", "Sang Dan Mahk Ki"),
        KoreanTerm(Belt.WHITE, "Blocks", "Low Block", "Ha Dan Mahk Ki"),
        KoreanTerm(Belt.WHITE, "Blocks", "Inside Outside Block", "Ahneso Pahkuro Mahk Ki"),
        KoreanTerm(Belt.WHITE, "Blocks", "Outside Inside Block", "Pahkeso Ahnuro Mahk Ki"),

        // White Belt - Punches
        KoreanTerm(Belt.WHITE, "Punches", "Center Punch", "Choong Dan Kong Kyuck"),

        // White Belt - General Terms
        KoreanTerm(Belt.WHITE, "General", "Tang Soo Do", "The art we study"),
        KoreanTerm(Belt.WHITE, "General", "Grand Master", "Kwan Chang Nim"),
        KoreanTerm(Belt.WHITE, "General", "Instructor or Teacher", "Sah Bum Nim"),
        KoreanTerm(Belt.WHITE, "General", "Attention", "Cha Ryut"),
        KoreanTerm(Belt.WHITE, "General", "Bow", "E Kyung Yet"),
        KoreanTerm(Belt.WHITE, "General", "Loud Shout or Yell", "Kihap"),
        KoreanTerm(Belt.WHITE, "General", "Thank You", "Ko Map Sum Ni Da"),

        // Orange Belt - Kicks
        KoreanTerm(Belt.ORANGE, "Kicks", "Hook Kick", "Yup Hu Ryo Cha Ki"),

        // Green Belt - Stances
        KoreanTerm(Belt.GREEN, "Stances", "Ready for Kick Stance", "Bahl Cha Ki Choon Be"),

        // Green Belt - Techniques
        KoreanTerm(Belt.GREEN, "Techniques", "Spear Hand Attack", "Kwan Soo Kong Kyuck"),
        KoreanTerm(Belt.GREEN, "Techniques", "Two Hand Block in Front Stance", "Chun Kul Ssang Soo"),
        KoreanTerm(Belt.GREEN, "Techniques", "Uppercut", "Tuck Chik Ki"),
        KoreanTerm(Belt.GREEN, "Techniques", "Center Chop", "Choong Dan Soo Do Mahk Ki"),

        // Green Belt - Kicks
        KoreanTerm(Belt.GREEN, "Kicks", "Wheel Kick", "Dwi Hu Ryo Cha Ki"),
        KoreanTerm(Belt.GREEN, "Kicks", "Knee Strike", "Mo Roope Cha Ki"),

        // Green Belt - Commands
        KoreanTerm(Belt.GREEN, "Commands", "Begin", "Shi Jak"),
        KoreanTerm(Belt.GREEN, "Commands", "Command", "Ku Ryung"),
        KoreanTerm(Belt.GREEN, "Commands", "By the Command", "Ku Ryung E Matcho So"),
        KoreanTerm(Belt.GREEN, "Commands", "Without Command", "Ku Ryung Up Shi"),
        KoreanTerm(Belt.GREEN, "Commands", "Relax", "Shio"),

        // Green Belt - Ranks
        KoreanTerm(Belt.GREEN, "Ranks", "Colored Belt", "Gup"),
        KoreanTerm(Belt.GREEN, "Ranks", "Black Belt", "Dan"),
        KoreanTerm(Belt.GREEN, "Ranks", "Belt", "Dee"),
        KoreanTerm(Belt.GREEN, "Ranks", "Junior Member", "Hu Bae"),
        KoreanTerm(Belt.GREEN, "Ranks", "Senior Member", "Sun Bae"),

        // Green Belt - Philosophy
        KoreanTerm(Belt.GREEN, "Philosophy", "The Way (Do in Tang Soo Do)", "The Way"),

        // Brown Belt - Commands
        KoreanTerm(Belt.BROWN, "Commands", "Attention", "Cha Ryut"),
        KoreanTerm(Belt.BROWN, "Commands", "Salute the Flag", "Kukgi Bae Rye"),
        KoreanTerm(Belt.BROWN, "Commands", "Return", "Ba Ro"),
        KoreanTerm(Belt.BROWN, "Commands", "Meditation", "Muk Yum"),
        KoreanTerm(Belt.BROWN, "Commands", "Bow to Grandmaster", "Kwan Chang Nim E Kyung Yet"),
        KoreanTerm(Belt.BROWN, "Commands", "Bow to Instructor", "Sah Bum Nim E Kyung Yet"),

        // Brown Belt - Techniques
        KoreanTerm(Belt.BROWN, "Techniques", "Attack", "Kong Kyuck"),
        KoreanTerm(Belt.BROWN, "Techniques", "Elbow Strike", "Pahl Koop Chik Ki"),

        // Brown Belt - Kicks
        KoreanTerm(Belt.BROWN, "Kicks", "Stomp Kick", "Chit Pahl Ki"),
        KoreanTerm(Belt.BROWN, "Kicks", "Single Action Jump Front Kick", "Deah Ahp Cha Ki"),
        KoreanTerm(Belt.BROWN, "Kicks", "Axe Kick", "Cchik Ki"),

        // Brown Belt - Body Parts
        KoreanTerm(Belt.BROWN, "Body Parts", "Arm", "Pahl"),
        KoreanTerm(Belt.BROWN, "Body Parts", "Foot", "Bahl"),
        KoreanTerm(Belt.BROWN, "Body Parts", "Fist", "Chu Mok"),
        KoreanTerm(Belt.BROWN, "Body Parts", "Neck", "Mok"),
        KoreanTerm(Belt.BROWN, "Body Parts", "Waist", "Hu Ri"),
        KoreanTerm(Belt.BROWN, "Body Parts", "Leg", "Da Ri"),
        KoreanTerm(Belt.BROWN, "Body Parts", "Hand", "Soo or Sahn"),
        KoreanTerm(Belt.BROWN, "Body Parts", "Elbow", "Pahl Koop"),
        KoreanTerm(Belt.BROWN, "Body Parts", "Knee", "Mo Roop"),
        KoreanTerm(Belt.BROWN, "Body Parts", "Eye", "Noon"),
        KoreanTerm(Belt.BROWN, "Body Parts", "Forehead", "I Ma"),
        KoreanTerm(Belt.BROWN, "Body Parts", "Chin", "Tuck"),
        KoreanTerm(Belt.BROWN, "Body Parts", "Solar Plexus", "Myung Chi"),
        KoreanTerm(Belt.BROWN, "Body Parts", "Philtrum", "In Choong"),
        KoreanTerm(Belt.BROWN, "Body Parts", "Low Abdomen", "Dan Jun"),
        KoreanTerm(Belt.BROWN, "Body Parts", "Groin", "Ko Hwan"),

        // Brown Belt - General
        KoreanTerm(Belt.BROWN, "General", "Uniform", "Do Bohk"),

        // Red Belt - Techniques
        KoreanTerm(Belt.RED, "Techniques", "Hand Technique", "Soo Ki"),
        KoreanTerm(Belt.RED, "Techniques", "Foot Technique", "Jok Ki"),
        KoreanTerm(Belt.RED, "Techniques", "Sparring", "Ryun"),
        KoreanTerm(Belt.RED, "Techniques", "Free Sparring", "Dae Ryun"),
        KoreanTerm(Belt.RED, "Techniques", "One-Step Sparring", "Ill Soo Sik Dae Ryun"),
        KoreanTerm(Belt.RED, "Techniques", "Breaking", "Kyuck Pa"),
        KoreanTerm(Belt.RED, "Techniques", "Spear Hand Attack", "Kwan Soo Kong Kyunck"),
        KoreanTerm(Belt.RED, "Techniques", "Double X Block", "Ssang Soo Mahk Ki"),

        // Red Belt - Ranks
        KoreanTerm(Belt.RED, "Ranks", "Senior Dan Holder", "K0 Dan Ja"),
        KoreanTerm(Belt.RED, "Ranks", "Gup Belt Holder", "Yu Gup Ja"),
        KoreanTerm(Belt.RED, "Ranks", "Black Belt Holder", "Yu Dan Ja"),
        KoreanTerm(Belt.RED, "Ranks", "Beginner", "Cho Bo Ja"),

        // Red Belt - Philosophy
        KoreanTerm(Belt.RED, "Philosophy", "External Power", "Weh Kong"),
        KoreanTerm(Belt.RED, "Philosophy", "Internal Power", "Nae Kong"),
        KoreanTerm(Belt.RED, "Philosophy", "Spiritual Power", "Shim Kong"),
        KoreanTerm(Belt.RED, "Philosophy", "Empty Mind", "Moo Shim"),
        KoreanTerm(Belt.RED, "Philosophy", "Concentration", "Chung Shin Tong Il"),
        KoreanTerm(Belt.RED, "Philosophy", "Humility", "Kyum Son"),
        KoreanTerm(Belt.RED, "Philosophy", "Respect", "Chong Kyung"),
        KoreanTerm(Belt.RED, "Philosophy", "Training", "Soo Ryun"),

        // Blue Belt - Kicks
        KoreanTerm(Belt.BLUE, "Kicks", "Diagonal Kick", "Bit Cha Ki"),
        KoreanTerm(Belt.BLUE, "Kicks", "Sweep Kick", "Bahl Mok Cha Ki"),
        KoreanTerm(Belt.BLUE, "Kicks", "Jumping Spinning Back Kick", "Deah Dwi Tollyo Cha Ki"),
        KoreanTerm(Belt.BLUE, "Kicks", "Axe Kick (Blue Belt)", "Cchik Ki"),

        // Blue Belt - Stances
        KoreanTerm(Belt.BLUE, "Stances", "Lowest Front Stance", "Choi Ha Dan Chun Kul Ja Seh"),

        // Blue Belt - Blocks
        KoreanTerm(Belt.BLUE, "Blocks", "Two Hand Palm Block", "Ssang Soo Jang Kwon Mahk Ki"),

        // Blue Belt - Ranks
        KoreanTerm(Belt.BLUE, "Ranks", "Blue Belt Candidate", "Cho Dan Bo"),

        // Blue Belt - Forms
        KoreanTerm(Belt.BLUE, "Forms", "Ten Hands", "Sip Soo")
    )

    fun getForBeltAndBelow(belt: Belt): List<KoreanTerm> {
        return terms.filter { it.belt.isAtOrBelow(belt) }
    }
}