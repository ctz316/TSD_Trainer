package com.tsdtrainer.app.data

import com.tsdtrainer.app.models.*

object KnowledgeRepository {

    private val items = listOf(

        // ══════════════════════════════════════════════════════════════
        // WHITE BELT  (10th & 9th Gup)
        // ══════════════════════════════════════════════════════════════

        // --- What is Tang Soo Do ---
        KnowledgeItem(Belt.WHITE, "What style of martial arts is taught at Destiny Martial Arts Academy?", "Tang Soo Do"),
        KnowledgeItem(Belt.WHITE, "How old is Tang Soo Do as a martial art?", "Approximately two thousand years old"),
        KnowledgeItem(Belt.WHITE, "Where did Tang Soo Do originate?", "Korea"),
        KnowledgeItem(Belt.WHITE, "What organization do we belong to?", "World Tang Soo Do Association (WTSDA)"),
        KnowledgeItem(Belt.WHITE, "How many continents is the WTSDA spread over?", "6 continents"),
        KnowledgeItem(Belt.WHITE, "Approximately how many members does the WTSDA have worldwide?", "Over 200,000 members"),
        KnowledgeItem(Belt.WHITE, "Who founded the World Tang Soo Do Association (WTSDA)?", "Grandmaster Shin"),
        KnowledgeItem(Belt.WHITE, "Who is the current Grandmaster of the WTSDA?", "Grandmaster Bill Strong"),

        // --- Basic Information ---
        KnowledgeItem(Belt.WHITE, "What is the name of our martial arts school?", "Destiny Martial Arts Academy"),
        KnowledgeItem(Belt.WHITE, "Who is the Master Instructor at Destiny Martial Arts Academy?", "Master Brooke Aderhold"),
        KnowledgeItem(Belt.WHITE, "What degree is the Master Instructor at Destiny Martial Arts Academy?", "4th Degree Master"),
        KnowledgeItem(Belt.WHITE, "Who is the Chief Instructor at Destiny Martial Arts Academy?", "Mr. Lucas Aderhold"),
        KnowledgeItem(Belt.WHITE, "What degree is the Chief Instructor at Destiny Martial Arts Academy?", "3rd Degree Black Belt"),

        // --- General Rules ---
        KnowledgeItem(Belt.WHITE, "How many minutes early should you arrive to class?", "At least fifteen minutes"),
        KnowledgeItem(Belt.WHITE, "What should you do when entering and leaving the training floor?", "Salute the flags and bow"),
        KnowledgeItem(Belt.WHITE, "Are students allowed to chew gum or smoke in the Dojang?", "No"),
        KnowledgeItem(Belt.WHITE, "What kind of uniform must students wear?", "A clean white uniform with no markings except those permitted by the WTSDA"),
        KnowledgeItem(Belt.WHITE, "What language should students and instructors use at all times?", "Tang Soo Do terminology (Korean)"),
        KnowledgeItem(Belt.WHITE, "What must students do if they need to miss a class?", "Notify their instructor in advance"),
        KnowledgeItem(Belt.WHITE, "What must all students help maintain in the Dojang?", "A high degree of cleanliness"),

        // --- Philosophy ---
        KnowledgeItem(Belt.WHITE, "What does White Belt represent in the cycle of seasons?", "A primitive stage of achievement; the seed as it lies dormant beneath the snows of winter"),

        // --- Terminology: Numbers ---
        KnowledgeItem(Belt.WHITE, "What is 'One' in Korean?", "Hana"),
        KnowledgeItem(Belt.WHITE, "What is 'Two' in Korean?", "Tul"),
        KnowledgeItem(Belt.WHITE, "What is 'Three' in Korean?", "Set"),
        KnowledgeItem(Belt.WHITE, "What is 'Four' in Korean?", "Net"),
        KnowledgeItem(Belt.WHITE, "What is 'Five' in Korean?", "Tasot"),
        KnowledgeItem(Belt.WHITE, "What is 'Six' in Korean?", "Yosot"),
        KnowledgeItem(Belt.WHITE, "What is 'Seven' in Korean?", "Ilgop"),
        KnowledgeItem(Belt.WHITE, "What is 'Eight' in Korean?", "Yodol"),
        KnowledgeItem(Belt.WHITE, "What is 'Nine' in Korean?", "Ahop"),
        KnowledgeItem(Belt.WHITE, "What is 'Ten' in Korean?", "Yol"),

        // --- Terminology: Kicks ---
        KnowledgeItem(Belt.WHITE, "What is 'front kick' in Korean?", "Ahp Cha Ki"),
        KnowledgeItem(Belt.WHITE, "What is 'side kick' in Korean?", "Yup Cha Ki"),
        KnowledgeItem(Belt.WHITE, "What is 'round kick' in Korean?", "Tollyo Cha Ki"),
        KnowledgeItem(Belt.WHITE, "What is 'spinning back kick' in Korean?", "Dwi Tollyo Cha Ki"),
        KnowledgeItem(Belt.WHITE, "What is 'jump front kick' in Korean?", "E Dan Ahp Cha Ki"),
        KnowledgeItem(Belt.WHITE, "What is 'jump round kick' in Korean?", "E Dan Tollyo Cha Ki"),

        // --- Terminology: Stances ---
        KnowledgeItem(Belt.WHITE, "What is 'stance' in Korean?", "Ja Seh"),
        KnowledgeItem(Belt.WHITE, "What is 'ready stance' in Korean?", "Choon Be Ja Seh"),
        KnowledgeItem(Belt.WHITE, "What is 'front stance' in Korean?", "Chun Kul Ja Seh"),
        KnowledgeItem(Belt.WHITE, "What is 'fighter stance' in Korean?", "Hu Kul Ja Seh"),
        KnowledgeItem(Belt.WHITE, "What is 'horse stance' in Korean?", "Kee Ma Ja Seh"),

        // --- Terminology: Blocks & Strikes ---
        KnowledgeItem(Belt.WHITE, "What is 'high block' in Korean?", "Sang Dan Mahk Ki"),
        KnowledgeItem(Belt.WHITE, "What is 'low block' in Korean?", "Ha Dan Mahk Ki"),
        KnowledgeItem(Belt.WHITE, "What is 'inside outside block' in Korean?", "Ahneso Pahkuro Mahk Ki"),
        KnowledgeItem(Belt.WHITE, "What is 'outside inside block' in Korean?", "Pahkeso Ahnuro Mahk Ki"),
        KnowledgeItem(Belt.WHITE, "What is 'center punch' in Korean?", "Choong Dan Kong Kyuck"),

        // --- Terminology: General ---
        KnowledgeItem(Belt.WHITE, "What is 'Tang Soo Do' in Korean?", "The art we are studying"),
        KnowledgeItem(Belt.WHITE, "What is 'grand master' in Korean?", "Kwan Chang Nim"),
        KnowledgeItem(Belt.WHITE, "What is 'instructor or teacher' in Korean?", "Sah Bum Nim"),
        KnowledgeItem(Belt.WHITE, "What is 'attention' in Korean?", "Cha Ryut"),
        KnowledgeItem(Belt.WHITE, "What is 'bow' in Korean?", "E Kyung Yet"),
        KnowledgeItem(Belt.WHITE, "What is the loud shout or yell in Korean?", "Kihap"),
        KnowledgeItem(Belt.WHITE, "How do you say 'Thank you' in Korean?", "Ko Map Sum Ni Da"),

        // --- 5 Codes & 7 Tenets ---
        KnowledgeItem(Belt.WHITE, "What are the 5 Codes of Tang Soo Do?", "1) Loyalty to Country\n2) Obedience to Parents\n3) Honor Friendship\n4) No Retreat in Battle\n5) In Fighting Choose with Sense and Honor"),
        KnowledgeItem(Belt.WHITE, "What are the 7 Tenets of Tang Soo Do?", "1) Integrity\n2) Concentration\n3) Perseverance\n4) Respect & Obedience\n5) Self-Control\n6) Humility\n7) Indomitable Spirit"),
        KnowledgeItem(Belt.WHITE, "What is the 1st Code of Tang Soo Do?", "Loyalty to Country"),
        KnowledgeItem(Belt.WHITE, "What is the 2nd Code of Tang Soo Do?", "Obedience to Parents"),
        KnowledgeItem(Belt.WHITE, "What is the 3rd Code of Tang Soo Do?", "Honor Friendship"),
        KnowledgeItem(Belt.WHITE, "What is the 4th Code of Tang Soo Do?", "No Retreat in Battle"),
        KnowledgeItem(Belt.WHITE, "What is the 5th Code of Tang Soo Do?", "In Fighting Choose with Sense and Honor"),
        KnowledgeItem(Belt.WHITE, "What is the 1st Tenet of Tang Soo Do?", "Integrity"),
        KnowledgeItem(Belt.WHITE, "What is the 4th Tenet of Tang Soo Do?", "Respect and Obedience"),
        KnowledgeItem(Belt.WHITE, "What is the 7th Tenet of Tang Soo Do?", "Indomitable Spirit"),

        // ══════════════════════════════════════════════════════════════
        // ORANGE BELT  (8th & 7th Gup)
        // ══════════════════════════════════════════════════════════════

        // --- Basic Information ---
        KnowledgeItem(Belt.ORANGE, "Why do we bow in Tang Soo Do?", "The bow is a sign of mutual respect"),
        KnowledgeItem(Belt.ORANGE, "To whom should students bow?", "The instructor, senior members, and to partners and opponents"),
        KnowledgeItem(Belt.ORANGE, "Tang Soo Do can be traced back how many years?", "Over 2,000 years"),
        KnowledgeItem(Belt.ORANGE, "What other country influenced Tang Soo Do?", "China"),

        // --- Philosophy: Orange Belt ---
        KnowledgeItem(Belt.ORANGE, "What does Orange Belt represent in the cycle of seasons?", "New growth which appears in spring; our Tang Soo Do knowledge begins to reveal itself"),

        // --- Philosophy: Korean Flag ---
        KnowledgeItem(Belt.ORANGE, "What is the name of the Korean flag?", "Tae Keuk Ki"),
        KnowledgeItem(Belt.ORANGE, "What is the name of the symbol in the center of the Korean flag?", "Tae Keuk"),
        KnowledgeItem(Belt.ORANGE, "What does the Tae Keuk on the Korean flag represent?", "The absolute or essential unity of all being"),
        KnowledgeItem(Belt.ORANGE, "What is the upper red section of the Tae Keuk called?", "Yang"),
        KnowledgeItem(Belt.ORANGE, "What is the lower blue section of the Tae Keuk called?", "Um"),
        KnowledgeItem(Belt.ORANGE, "What do the three unbroken lines on the Korean flag represent?", "Heaven"),
        KnowledgeItem(Belt.ORANGE, "What do the three broken bars on the Korean flag represent?", "Earth"),
        KnowledgeItem(Belt.ORANGE, "Two solid bars on the outside with a broken bar in the middle represent what?", "Fire"),
        KnowledgeItem(Belt.ORANGE, "Two broken bars on the outside with a solid bar in the middle represent what?", "Water"),

        // --- Philosophy: Association Flag ---
        KnowledgeItem(Belt.ORANGE, "What do the six stars on the WTSDA flag represent?", "The six inhabited continents — Tang Soo Do spans the globe"),
        KnowledgeItem(Belt.ORANGE, "What does the flying side kick on the WTSDA flag represent?", "The special and unique character of Tang Soo Do and the whole person concept"),
        KnowledgeItem(Belt.ORANGE, "What does the red circle on the WTSDA flag represent?", "Unity and brotherhood/sisterhood"),
        KnowledgeItem(Belt.ORANGE, "What does the globe on the WTSDA flag represent?", "That our organization covers the world"),
        KnowledgeItem(Belt.ORANGE, "What does the bottom belt on the WTSDA flag represent?", "The Master's Belt — the ultimate goal of all Tang Soo Do students"),
        KnowledgeItem(Belt.ORANGE, "What are the colors of the WTSDA flag?", "Red, blue, and black"),

        // --- Terminology ---
        KnowledgeItem(Belt.ORANGE, "What is 'side block' in Korean?", "Yup Mahk Ki"),
        KnowledgeItem(Belt.ORANGE, "What is 'side center punch in horse stance' in Korean?", "Choong Dan Hang Jin"),
        KnowledgeItem(Belt.ORANGE, "What is 'low chop' in Korean?", "Ha Dan Soo Do Mahk Ki"),
        KnowledgeItem(Belt.ORANGE, "What is 'hook kick' in Korean?", "Yup Huryo Cha Ki"),
        KnowledgeItem(Belt.ORANGE, "What is 'ridge hand' in Korean?", "Yuk Soo Do"),
        KnowledgeItem(Belt.ORANGE, "What is 'low part' in Korean?", "Ha Dan"),
        KnowledgeItem(Belt.ORANGE, "What is 'middle part' in Korean?", "Choong Dan"),
        KnowledgeItem(Belt.ORANGE, "What is 'high part' in Korean?", "Sang Dan"),

        // --- History ---
        KnowledgeItem(Belt.ORANGE, "Who founded the Moo Duk Kwan?", "Grandmaster Hwang Kee"),
        KnowledgeItem(Belt.ORANGE, "Who is Grandmaster Hwang Kee in relation to Grandmaster Shin?", "Grandmaster Shin's instructor"),
        KnowledgeItem(Belt.ORANGE, "What were Grandmaster Shin's full dates (birth and death)?", "1936–2012"),
        KnowledgeItem(Belt.ORANGE, "When did Grandmaster Shin come to the USA and begin teaching?", "1968"),
        KnowledgeItem(Belt.ORANGE, "In what year was the WTSDA formed?", "1982"),
        KnowledgeItem(Belt.ORANGE, "Where was the WTSDA Charter Convention held?", "Philadelphia, Pennsylvania"),

        // ══════════════════════════════════════════════════════════════
        // GREEN BELT  (6th & 5th Gup)
        // ══════════════════════════════════════════════════════════════

        // --- What is Tang Soo Do (Literal Meaning) ---
        KnowledgeItem(Belt.GREEN, "What does 'Tang' in Tang Soo Do refer to?", "The T'ang Dynasty of China (AD 618-907) — reflects the shared cultural background between China and Korea"),
        KnowledgeItem(Belt.GREEN, "What does 'Soo' in Tang Soo Do mean?", "Hand — but implies fist, punch, strike, or defense"),
        KnowledgeItem(Belt.GREEN, "What does 'Do' in Tang Soo Do mean?", "The Way — implies the Korean classical martial art influenced by the T'ang method"),

        // --- Basic Information: Purpose & Slogans ---
        KnowledgeItem(Belt.GREEN, "What are the 3 purposes of Tang Soo Do training?", "1) Self Defense\n2) Health\n3) Better Person"),
        KnowledgeItem(Belt.GREEN, "What is the 1st purpose of Tang Soo Do training?", "Self Defense — protect our lives and possessions from injustice and danger"),
        KnowledgeItem(Belt.GREEN, "What is the 2nd purpose of Tang Soo Do training?", "Health — promote physical and spiritual health through rigorous training"),
        KnowledgeItem(Belt.GREEN, "What is the 3rd purpose of Tang Soo Do training?", "Better Person — strive to be of better character through endurance and hard work"),
        KnowledgeItem(Belt.GREEN, "What are the 3 slogans of Tang Soo Do?", "Traditionalism, Professionalism, Brotherhood"),
        KnowledgeItem(Belt.GREEN, "What are the potentially lethal striking points on the body?", "Philtrum (space between nose and mouth), solar plexus, and temple"),

        // --- Philosophy ---
        KnowledgeItem(Belt.GREEN, "What does Green Belt represent in the cycle of seasons?", "The speedy development of youth as summer arrives"),
        KnowledgeItem(Belt.GREEN, "What does 'Pyung Ahn' mean?", "Calm and Peace of Mind; represents a Turtle"),

        // --- Terminology: Techniques ---
        KnowledgeItem(Belt.GREEN, "What is 'ready for kick' in Korean?", "Bahl Cha Ki Choon Be"),
        KnowledgeItem(Belt.GREEN, "What is 'spear hand attack' in Korean?", "Kwan Soo Kong Kyuck"),
        KnowledgeItem(Belt.GREEN, "What is 'two hand block, front stance' in Korean?", "Chun Kul Ssang Soo"),
        KnowledgeItem(Belt.GREEN, "What is 'upper cut' in Korean?", "Tuck Chik Ki"),
        KnowledgeItem(Belt.GREEN, "What is 'center chop' in Korean?", "Choong Dan Soo Do Mahk Ki"),
        KnowledgeItem(Belt.GREEN, "What is 'wheel kick' in Korean?", "Hu Ryo Cha Ki"),
        KnowledgeItem(Belt.GREEN, "What is 'knee strike' in Korean?", "Mo Roope Cha Ki"),

        // --- Terminology: Commands ---
        KnowledgeItem(Belt.GREEN, "What is 'begin' in Korean?", "Shi Jak"),
        KnowledgeItem(Belt.GREEN, "What is 'command' in Korean?", "Ku Ryung"),
        KnowledgeItem(Belt.GREEN, "What is 'by the command' in Korean?", "Ku Ryung E Matcho So"),
        KnowledgeItem(Belt.GREEN, "What is 'without command' in Korean?", "Ku Ryung Up Shi"),
        KnowledgeItem(Belt.GREEN, "What is 'relax' in Korean?", "Shio"),

        // --- Terminology: Other ---
        KnowledgeItem(Belt.GREEN, "What is 'colored belt' in Korean?", "Gup"),
        KnowledgeItem(Belt.GREEN, "What is 'black belt' in Korean?", "Dan"),
        KnowledgeItem(Belt.GREEN, "What is 'belt' in Korean?", "Dee"),
        KnowledgeItem(Belt.GREEN, "What is 'junior member' in Korean?", "Hu Bae"),
        KnowledgeItem(Belt.GREEN, "What is 'senior member' in Korean?", "Sun Bae"),
        KnowledgeItem(Belt.GREEN, "What is 'form' or 'forms' in Korean?", "Hyung"),
        KnowledgeItem(Belt.GREEN, "What is 'meditation' in Korean?", "Muk Yum"),
        KnowledgeItem(Belt.GREEN, "What is 'training hall' in Korean?", "Dojang"),
        KnowledgeItem(Belt.GREEN, "What is 'hand' in Korean?", "Soo"),
        KnowledgeItem(Belt.GREEN, "What is 'fist' in Korean?", "Chu Mok"),
        KnowledgeItem(Belt.GREEN, "What is 'foot' in Korean?", "Bahl"),
        KnowledgeItem(Belt.GREEN, "What is 'elbow' in Korean?", "Pahl Koop"),
        KnowledgeItem(Belt.GREEN, "What is 'knee' in Korean?", "Moo Roop"),
        KnowledgeItem(Belt.GREEN, "What is 'return' in Korean?", "Ba Ro"),
        KnowledgeItem(Belt.GREEN, "What is 'ready' in Korean?", "Choon Be"),
        KnowledgeItem(Belt.GREEN, "What is 'count' in Korean?", "Ku Ryun"),
        KnowledgeItem(Belt.GREEN, "What is 'sit' in Korean?", "An Jo"),

        // --- History ---
        KnowledgeItem(Belt.GREEN, "During what years was the practice of martial arts restricted in Korea?", "During the Japanese occupation of Korea, 1910-1945"),
        KnowledgeItem(Belt.GREEN, "During what years was the Korean War?", "1950-1953"),
        KnowledgeItem(Belt.GREEN, "What were the martial arts training schools established after WWII called?", "Kwans"),
        KnowledgeItem(Belt.GREEN, "In what year was Grandmaster Shin inducted into the Korean Air Force?", "1958"),
        KnowledgeItem(Belt.GREEN, "Who is one well-known American martial artist who trained under Grandmaster Shin?", "Chuck Norris"),
        KnowledgeItem(Belt.GREEN, "What degree did Grandmaster Shin receive from Korea University?", "Master's degree in Political Science"),
        KnowledgeItem(Belt.GREEN, "In what city did Grandmaster Shin open his first school in the United States?", "Burlington, New Jersey"),
        KnowledgeItem(Belt.GREEN, "What federation did Grandmaster Shin establish when he immigrated to the US?", "U.S. Tang Soo Do Federation"),
        KnowledgeItem(Belt.GREEN, "What book recognized Grandmaster Shin's presence in the United States?", "20th Century Warriors (Black Belt Magazine)"),

        // ══════════════════════════════════════════════════════════════
        // BROWN BELT  (4th & 3rd Gup)
        // ══════════════════════════════════════════════════════════════

        // --- Philosophy ---
        KnowledgeItem(Belt.BROWN, "What does Brown Belt represent in the cycle of seasons?", "Late Summer — stabilization stage, both mentally and physically; analogous to plants which curtail their growth and prepare to flower"),
        KnowledgeItem(Belt.BROWN, "What are the character traits of the Brown Belt?", "1) Power\n2) Stability\n3) Agility\n4) Weight\n5) Wisdom"),

        // --- Class Commands ---
        KnowledgeItem(Belt.BROWN, "What are the starting class commands in order?", "1) Cha Ryut (Attention)\n2) Kukgi Bae Rye (Salute The Flag)\n3) Muk Yum (Meditation)\n4) Ba Ro (Return)\n5) Kwan Chang Nim E Kyung Yet (Bow to Grandmaster)\n6) Sah Bum Nim E Kyung Yet (Bow to Instructor)"),
        KnowledgeItem(Belt.BROWN, "What is 'salute the flag' in Korean?", "Kukgi Bae Rye"),

        // --- Class Protocol ---
        KnowledgeItem(Belt.BROWN, "If you are late to class, what must you do?", "Wait to be recognized by the instructor, approach, bow, and ask permission to join"),
        KnowledgeItem(Belt.BROWN, "If you need to leave class early, what must you do?", "Receive permission from the instructor first"),
        KnowledgeItem(Belt.BROWN, "What should you do if you need to fix your uniform during class?", "Turn away from the instructor and adjust your uniform"),
        KnowledgeItem(Belt.BROWN, "How should you sit properly in the Dojang?", "Hands on knees, back straight, legs crossed with feet tucked beneath the thighs"),
        KnowledgeItem(Belt.BROWN, "What is the uniform called in Korean?", "Do Bohk"),
        KnowledgeItem(Belt.BROWN, "How should students maintain their Do Bohk?", "Keep it clean and pressed"),

        // --- 14 Attitude Requirements ---
        KnowledgeItem(Belt.BROWN, "What are the 14 Attitude Requirements to Master Tang Soo Do?", "1) Enhancement of mental and physical betterment\n2) Serious approach\n3) All-out effort\n4) Regular and constant practice\n5) Practice basic techniques all the time\n6) Regularly spaced practice\n7) Always listen to and follow directions of instructors or seniors\n8) Do not be overly ambitious\n9) Frequently inspect your own achievements\n10) Always follow a routine training schedule\n11) Repeatedly practice all techniques already learned\n12) When you learn new techniques, learn thoroughly the theory and philosophy as well\n13) When you begin to feel idle, try to overcome this\n14) Cleanliness is required after training. Keep yourself and your surroundings clean"),
        KnowledgeItem(Belt.BROWN, "What is attitude requirement #8?", "Do not be overly ambitious"),
        KnowledgeItem(Belt.BROWN, "What is attitude requirement #13?", "When you begin to feel idle, try to overcome this"),
        KnowledgeItem(Belt.BROWN, "What is attitude requirement #14?", "Cleanliness is required after training. Keep yourself and your surroundings clean"),

        // --- Terminology: Anatomy ---
        KnowledgeItem(Belt.BROWN, "What is 'arm' in Korean?", "Pahl"),
        KnowledgeItem(Belt.BROWN, "What is 'neck' in Korean?", "Mok"),
        KnowledgeItem(Belt.BROWN, "What is 'waist' in Korean?", "Hu Ri"),
        KnowledgeItem(Belt.BROWN, "What is 'leg' in Korean?", "Da Ri"),
        KnowledgeItem(Belt.BROWN, "What is 'hand' in Korean (anatomy)?", "Soo or Sohn"),
        KnowledgeItem(Belt.BROWN, "What is 'eye' in Korean?", "Noon"),
        KnowledgeItem(Belt.BROWN, "What is 'forehead' in Korean?", "I Ma"),
        KnowledgeItem(Belt.BROWN, "What is 'chin' in Korean?", "Tuck"),
        KnowledgeItem(Belt.BROWN, "What is 'solar plexus' in Korean?", "Myung Chi"),
        KnowledgeItem(Belt.BROWN, "What is 'philtrum' in Korean?", "In Choong"),
        KnowledgeItem(Belt.BROWN, "What is 'low abdomen' in Korean?", "Dan Jun"),
        KnowledgeItem(Belt.BROWN, "What is 'groin' in Korean?", "Ko Hwan"),
        KnowledgeItem(Belt.BROWN, "What is 'bridge of nose' in Korean?", "Koh"),

        // --- Terminology: Techniques ---
        KnowledgeItem(Belt.BROWN, "What is 'attack' in Korean?", "Kong Kyuck"),
        KnowledgeItem(Belt.BROWN, "What is 'stomp kick' in Korean?", "Chit Pahl Ki"),
        KnowledgeItem(Belt.BROWN, "What is 'single-action jump front kick' in Korean?", "Deah Ahp Cha Ki"),
        KnowledgeItem(Belt.BROWN, "What is 'elbow strike' in Korean?", "Pahl Koop Chik Ki"),
        KnowledgeItem(Belt.BROWN, "What is 'axe kick' in Korean?", "Cchik Ki"),

        // --- History ---
        KnowledgeItem(Belt.BROWN, "What were the young aristocrats called that helped unify Korea?", "Hwarang Dan"),
        KnowledgeItem(Belt.BROWN, "The Silla Dynasty lasted during what years?", "AD 668-935"),
        KnowledgeItem(Belt.BROWN, "What was the Hwarang Dan instrumental in doing?", "Uniting the peninsula as the unified Silla Dynasty"),
        KnowledgeItem(Belt.BROWN, "Name one martial art whose name reflects the heritage of the Hwarang Dan.", "Hwa Rang Do or Hwa Soo Do"),
        KnowledgeItem(Belt.BROWN, "The Five Codes of Tang Soo Do were originated by which monk?", "Won Kwang"),
        KnowledgeItem(Belt.BROWN, "What is the name of the first known martial arts book?", "Muye Dobo Tongji"),
        KnowledgeItem(Belt.BROWN, "When was the Muye Dobo Tongji commissioned?", "1790"),
        KnowledgeItem(Belt.BROWN, "What is the formal name of Tang Soo Do?", "Soo Bahk Ki"),
        KnowledgeItem(Belt.BROWN, "What does the Muye Dobo Tongji substantiate through its illustrations?", "That Soo Bahk Ki had developed into a sophisticated art of combat techniques"),
        KnowledgeItem(Belt.BROWN, "In what year was Grandmaster Shin born?", "1936"),
        KnowledgeItem(Belt.BROWN, "Who inspired Grandmaster Shin to study Tang Soo Do?", "An unknown monk"),
        KnowledgeItem(Belt.BROWN, "How old was Grandmaster Shin when he began studying Tang Soo Do?", "12 years old"),
        KnowledgeItem(Belt.BROWN, "Under whose tutelage did Grandmaster Shin earn his Black Belt?", "Grandmaster Hwang Kee"),
        KnowledgeItem(Belt.BROWN, "What is Grandmaster Hwang Kee's title in relation to the Korean Moo Duk Kwan?", "Founder"),
        KnowledgeItem(Belt.BROWN, "At what gym did Grandmaster Shin train under Grandmaster Hwang Kee?", "The Seoul Moo Duk Kwan central gym"),
        KnowledgeItem(Belt.BROWN, "Name two areas of expertise Grandmaster Shin developed over the years.", "Any two of: self-defense, forms, breaking, weapons, health care, meditation"),

        // ══════════════════════════════════════════════════════════════
        // RED BELT  (2nd & 1st Gup)
        // ══════════════════════════════════════════════════════════════

        // --- Philosophy ---
        KnowledgeItem(Belt.RED, "What does Red Belt represent in the cycle of seasons?", "Red represents blood, life, energy, attention, and control. The student's power and techniques begin to bloom and ripen"),
        KnowledgeItem(Belt.RED, "What five things does Red Belt symbolize?", "Blood, life, energy, attention, and control"),

        // --- Terminology ---
        KnowledgeItem(Belt.RED, "What is 'hand technique' in Korean?", "Soo Ki"),
        KnowledgeItem(Belt.RED, "What is 'foot technique' in Korean?", "Jok Ki"),
        KnowledgeItem(Belt.RED, "What is 'sparring' in Korean?", "Dae Ryun"),
        KnowledgeItem(Belt.RED, "What is 'free sparring' in Korean?", "Ja Yu Dae Ryun"),
        KnowledgeItem(Belt.RED, "What is 'one-step sparring' in Korean?", "Ill Soo Sik Dae Ryun"),
        KnowledgeItem(Belt.RED, "What is 'self defense' in Korean?", "Ho Sin Sul"),
        KnowledgeItem(Belt.RED, "What is 'breaking' in Korean?", "Kyuck Pa"),
        KnowledgeItem(Belt.RED, "What is the Korean term for a senior Dan holder?", "Ko Dan Ja"),
        KnowledgeItem(Belt.RED, "What is the Korean term for a Dan (Black Belt) holder?", "Yu Dan Ja"),
        KnowledgeItem(Belt.RED, "What is the Korean term for a Gup (Colored Belt) holder?", "Yu Gup Ja"),
        KnowledgeItem(Belt.RED, "What is the Korean term for 'beginner'?", "Cho Bo Ja"),
        KnowledgeItem(Belt.RED, "What is 'internal power' in Korean?", "Nae Kong"),
        KnowledgeItem(Belt.RED, "What is 'external power' in Korean?", "Weh Kong"),
        KnowledgeItem(Belt.RED, "What is 'spiritual power' in Korean?", "Shim Kong"),
        KnowledgeItem(Belt.RED, "What is 'spear hand attack' in Korean?", "Kwan Soo Kong Kyuck"),
        KnowledgeItem(Belt.RED, "What is 'double X block' in Korean?", "Ssang Soo Mahk Ki"),
        KnowledgeItem(Belt.RED, "What is 'concentration' in Korean?", "Chung Shin Tong Il"),
        KnowledgeItem(Belt.RED, "What is 'endurance' in Korean?", "In Neh"),
        KnowledgeItem(Belt.RED, "What is 'humility' in Korean?", "Kyum Son"),
        KnowledgeItem(Belt.RED, "What is 'respect' in Korean?", "Chong Kyung"),
        KnowledgeItem(Belt.RED, "What is 'empty mind' in Korean?", "Moo Shim"),
        KnowledgeItem(Belt.RED, "What is 'training' in Korean?", "Soo Ryun"),

        // --- History: Three Kingdoms ---
        KnowledgeItem(Belt.RED, "When was the Silla kingdom founded?", "57 BC — in the southeast of the peninsula"),
        KnowledgeItem(Belt.RED, "When was Koguryo founded?", "37 BC — in northern Korea"),
        KnowledgeItem(Belt.RED, "When was Paekche founded?", "18 BC — in the southwest"),
        KnowledgeItem(Belt.RED, "What were the three original kingdoms of Korea?", "Silla, Koguryo, and Paekche"),
        KnowledgeItem(Belt.RED, "During what years did the unified Silla Dynasty rule?", "AD 668-935"),
        KnowledgeItem(Belt.RED, "What evidence shows that martial arts existed in the Silla period?", "Mural paintings, ruins, and tombs depicting early forms of Tang Soo Do"),

        // --- History: Koryo Dynasty ---
        KnowledgeItem(Belt.RED, "Who overthrew the unified Silla and formed the Koryo Dynasty?", "The military leader Wang Kon"),
        KnowledgeItem(Belt.RED, "When did Wang Kon come to power?", "AD 918"),
        KnowledgeItem(Belt.RED, "During what years did the Koryo Dynasty rule?", "AD 935-1392"),
        KnowledgeItem(Belt.RED, "What is the modern word 'Korea' derived from?", "The name 'Koryo'"),
        KnowledgeItem(Belt.RED, "What name was Wang Kon known by when he became king?", "King Taejo"),

        // --- History: Choson Dynasty ---
        KnowledgeItem(Belt.RED, "What dynasty succeeded the Koryo Dynasty?", "The Choson Dynasty"),
        KnowledgeItem(Belt.RED, "During what years did the Choson Dynasty rule?", "AD 1392-1910"),
        KnowledgeItem(Belt.RED, "What philosophy did the Choson Dynasty adopt?", "Confucianism"),
        KnowledgeItem(Belt.RED, "Approximately how many years did the Choson Dynasty last?", "About 500 years"),
        KnowledgeItem(Belt.RED, "Which family ruled under the Choson Dynasty?", "The Yi ruling family"),
        KnowledgeItem(Belt.RED, "Together, Koryo and Choson cover approximately how many years?", "Almost a thousand years of Korean history"),

        // ══════════════════════════════════════════════════════════════
        // BLUE BELT  (Cho Dan Bo)
        // ══════════════════════════════════════════════════════════════

        // --- Philosophy ---
        KnowledgeItem(Belt.BLUE, "What does Blue Belt represent in the cycle of seasons?", "Dark blue represents maturity, respect, and honor"),
        KnowledgeItem(Belt.BLUE, "What three things does Blue Belt symbolize?", "Maturity, respect, and honor"),
        KnowledgeItem(Belt.BLUE, "What is the Korean term for a Blue Belt (Black Belt Candidate)?", "Cho Dan Bo"),
        KnowledgeItem(Belt.BLUE, "What must a Blue Belt Candidate prepare for?", "Mind and body for the final step needed to attain black belt"),

        // --- Terminology ---
        KnowledgeItem(Belt.BLUE, "What is 'diagonal kick' in Korean?", "Bit Cha Ki"),
        KnowledgeItem(Belt.BLUE, "What is 'sweep kick' in Korean?", "Bahl Mok Cha Ki"),
        KnowledgeItem(Belt.BLUE, "What is 'jump spinning back kick' in Korean?", "Deah Dwi Tollyo Cha Ki"),
        KnowledgeItem(Belt.BLUE, "What is 'axe kick' in Korean (Blue Belt)?", "Cchik Ki"),
        KnowledgeItem(Belt.BLUE, "What is 'lowest front stance' in Korean?", "Choi Ha Dan Chun Kul Ja Seh"),
        KnowledgeItem(Belt.BLUE, "What is 'two hand palm block' in Korean?", "Ssang Soo Jang Kwon Mahk Ki"),
        KnowledgeItem(Belt.BLUE, "What is 'ten hands' in Korean (Blue Belt form)?", "Sip Soo"),

        // --- Testing Requirements ---
        KnowledgeItem(Belt.BLUE, "What is the Blue Belt test?", "The last in-studio test before Black Belt testing at regional level"),
        KnowledgeItem(Belt.BLUE, "How many questions are on the Blue Belt written test?", "50 questions — covering all information from White Belt to Blue Belt"),
        KnowledgeItem(Belt.BLUE, "What is the minimum time you must hold Blue Belt before testing for Black Belt?", "A minimum of 6 months, normally a full year"),
        KnowledgeItem(Belt.BLUE, "How many attempts do you get at the Black Belt written test?", "2 attempts — fail both and you do not test"),
        KnowledgeItem(Belt.BLUE, "How many words must the Black Belt essay be?", "1,000 words"),
        KnowledgeItem(Belt.BLUE, "How many weeks before testing is the Black Belt essay due?", "8 weeks prior to your testing date"),
        KnowledgeItem(Belt.BLUE, "What minimum percentage of WTSDA sanctioned events must you attend?", "A minimum of 50%"),
        KnowledgeItem(Belt.BLUE, "After how many months of holding Blue Belt may you be invited into the instructor program?", "3 months — with regular attendance")
    )

    /**
     * Knowledge Quiz and Korean Terms: returns all items for the given belt AND all belts below it.
     */
    fun getForBeltAndBelow(belt: Belt): List<KnowledgeItem> {
        return items.filter { it.belt.rank <= belt.rank }
    }

    /**
     * Knowledge Practice: returns items for the current belt group only.
     * Senior belts fall back to their base belt so study material is always available.
     */
    fun getForCurrentBeltGroup(belt: Belt): List<KnowledgeItem> {
        val targetBelt = when (belt) {
            Belt.SENIOR_WHITE  -> Belt.WHITE
            Belt.SENIOR_ORANGE -> Belt.ORANGE
            Belt.SENIOR_GREEN  -> Belt.GREEN
            Belt.SENIOR_BROWN  -> Belt.BROWN
            Belt.SENIOR_RED    -> Belt.RED
            else               -> belt
        }
        return items.filter { it.belt == targetBelt }
    }

    fun getForCurrentBeltOnly(belt: Belt): List<KnowledgeItem> = getForCurrentBeltGroup(belt)
}
