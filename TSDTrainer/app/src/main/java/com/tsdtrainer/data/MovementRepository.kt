package com.tsdtrainer.app.data

import com.tsdtrainer.app.models.*

object MovementRepository {

    private val movements = listOf(
        // White Belt - Regular Side (1-5)
        Movement(Belt.WHITE, MovementCategory.HANDS, MovementSide.REGULAR, 1),
        Movement(Belt.WHITE, MovementCategory.HANDS, MovementSide.REGULAR, 2),
        Movement(Belt.WHITE, MovementCategory.HANDS, MovementSide.REGULAR, 3),
        Movement(Belt.WHITE, MovementCategory.HANDS, MovementSide.REGULAR, 4),
        Movement(Belt.WHITE, MovementCategory.HANDS, MovementSide.REGULAR, 5),

        Movement(Belt.WHITE, MovementCategory.FEET, MovementSide.REGULAR, 1),
        Movement(Belt.WHITE, MovementCategory.FEET, MovementSide.REGULAR, 2),
        Movement(Belt.WHITE, MovementCategory.FEET, MovementSide.REGULAR, 3),
        Movement(Belt.WHITE, MovementCategory.FEET, MovementSide.REGULAR, 4),
        Movement(Belt.WHITE, MovementCategory.FEET, MovementSide.REGULAR, 5),

        Movement(Belt.WHITE, MovementCategory.DEFENSE, MovementSide.REGULAR, 1),
        Movement(Belt.WHITE, MovementCategory.DEFENSE, MovementSide.REGULAR, 2),
        Movement(Belt.WHITE, MovementCategory.DEFENSE, MovementSide.REGULAR, 3),
        Movement(Belt.WHITE, MovementCategory.DEFENSE, MovementSide.REGULAR, 4),
        Movement(Belt.WHITE, MovementCategory.DEFENSE, MovementSide.REGULAR, 5),

        Movement(Belt.WHITE, MovementCategory.FORMS, MovementSide.NONE, movementNumber = 1, formName = "Kee Cho Hyung Il Bu"),

        // Senior White Belt - Opposite Side (1-5)
        Movement(Belt.SENIOR_WHITE, MovementCategory.HANDS, MovementSide.OPPOSITE, 1),
        Movement(Belt.SENIOR_WHITE, MovementCategory.HANDS, MovementSide.OPPOSITE, 2),
        Movement(Belt.SENIOR_WHITE, MovementCategory.HANDS, MovementSide.OPPOSITE, 3),
        Movement(Belt.SENIOR_WHITE, MovementCategory.HANDS, MovementSide.OPPOSITE, 4),
        Movement(Belt.SENIOR_WHITE, MovementCategory.HANDS, MovementSide.OPPOSITE, 5),

        Movement(Belt.SENIOR_WHITE, MovementCategory.FEET, MovementSide.OPPOSITE, 1),
        Movement(Belt.SENIOR_WHITE, MovementCategory.FEET, MovementSide.OPPOSITE, 2),
        Movement(Belt.SENIOR_WHITE, MovementCategory.FEET, MovementSide.OPPOSITE, 3),
        Movement(Belt.SENIOR_WHITE, MovementCategory.FEET, MovementSide.OPPOSITE, 4),
        Movement(Belt.SENIOR_WHITE, MovementCategory.FEET, MovementSide.OPPOSITE, 5),

        Movement(Belt.SENIOR_WHITE, MovementCategory.DEFENSE, MovementSide.OPPOSITE, 1),
        Movement(Belt.SENIOR_WHITE, MovementCategory.DEFENSE, MovementSide.OPPOSITE, 2),
        Movement(Belt.SENIOR_WHITE, MovementCategory.DEFENSE, MovementSide.OPPOSITE, 3),
        Movement(Belt.SENIOR_WHITE, MovementCategory.DEFENSE, MovementSide.OPPOSITE, 4),
        Movement(Belt.SENIOR_WHITE, MovementCategory.DEFENSE, MovementSide.OPPOSITE, 5),

        Movement(Belt.SENIOR_WHITE, MovementCategory.FORMS, MovementSide.NONE, movementNumber = 2, formName = "Kee Cho Hyung E Bu"),

        // Orange Belt - Regular Side (6-10)
        Movement(Belt.ORANGE, MovementCategory.HANDS, MovementSide.REGULAR, 6),
        Movement(Belt.ORANGE, MovementCategory.HANDS, MovementSide.REGULAR, 7),
        Movement(Belt.ORANGE, MovementCategory.HANDS, MovementSide.REGULAR, 8),
        Movement(Belt.ORANGE, MovementCategory.HANDS, MovementSide.REGULAR, 9),
        Movement(Belt.ORANGE, MovementCategory.HANDS, MovementSide.REGULAR, 10),

        Movement(Belt.ORANGE, MovementCategory.FEET, MovementSide.REGULAR, 6),
        Movement(Belt.ORANGE, MovementCategory.FEET, MovementSide.REGULAR, 7),
        Movement(Belt.ORANGE, MovementCategory.FEET, MovementSide.REGULAR, 8),
        Movement(Belt.ORANGE, MovementCategory.FEET, MovementSide.REGULAR, 9),
        Movement(Belt.ORANGE, MovementCategory.FEET, MovementSide.REGULAR, 10),

        Movement(Belt.ORANGE, MovementCategory.DEFENSE, MovementSide.REGULAR, 6),
        Movement(Belt.ORANGE, MovementCategory.DEFENSE, MovementSide.REGULAR, 7),
        Movement(Belt.ORANGE, MovementCategory.DEFENSE, MovementSide.REGULAR, 8),
        Movement(Belt.ORANGE, MovementCategory.DEFENSE, MovementSide.REGULAR, 9),
        Movement(Belt.ORANGE, MovementCategory.DEFENSE, MovementSide.REGULAR, 10),

        Movement(Belt.ORANGE, MovementCategory.FORMS, MovementSide.NONE, movementNumber = 3, formName = "Sae Kye Hyung Sam Bu"),

        // Senior Orange Belt - Opposite Side (6-10)
        Movement(Belt.SENIOR_ORANGE, MovementCategory.HANDS, MovementSide.OPPOSITE, 6),
        Movement(Belt.SENIOR_ORANGE, MovementCategory.HANDS, MovementSide.OPPOSITE, 7),
        Movement(Belt.SENIOR_ORANGE, MovementCategory.HANDS, MovementSide.OPPOSITE, 8),
        Movement(Belt.SENIOR_ORANGE, MovementCategory.HANDS, MovementSide.OPPOSITE, 9),
        Movement(Belt.SENIOR_ORANGE, MovementCategory.HANDS, MovementSide.OPPOSITE, 10),

        Movement(Belt.SENIOR_ORANGE, MovementCategory.FEET, MovementSide.OPPOSITE, 6),
        Movement(Belt.SENIOR_ORANGE, MovementCategory.FEET, MovementSide.OPPOSITE, 7),
        Movement(Belt.SENIOR_ORANGE, MovementCategory.FEET, MovementSide.OPPOSITE, 8),
        Movement(Belt.SENIOR_ORANGE, MovementCategory.FEET, MovementSide.OPPOSITE, 9),
        Movement(Belt.SENIOR_ORANGE, MovementCategory.FEET, MovementSide.OPPOSITE, 10),

        Movement(Belt.SENIOR_ORANGE, MovementCategory.DEFENSE, MovementSide.OPPOSITE, 6),
        Movement(Belt.SENIOR_ORANGE, MovementCategory.DEFENSE, MovementSide.OPPOSITE, 7),
        Movement(Belt.SENIOR_ORANGE, MovementCategory.DEFENSE, MovementSide.OPPOSITE, 8),
        Movement(Belt.SENIOR_ORANGE, MovementCategory.DEFENSE, MovementSide.OPPOSITE, 9),
        Movement(Belt.SENIOR_ORANGE, MovementCategory.DEFENSE, MovementSide.OPPOSITE, 10),

        Movement(Belt.SENIOR_ORANGE, MovementCategory.FORMS, MovementSide.NONE, movementNumber = 4, formName = "Pyung Ahn Cho Dan"),

        // Green Belt - Regular Side (11-15)
        Movement(Belt.GREEN, MovementCategory.HANDS, MovementSide.REGULAR, 11),
        Movement(Belt.GREEN, MovementCategory.HANDS, MovementSide.REGULAR, 12),
        Movement(Belt.GREEN, MovementCategory.HANDS, MovementSide.REGULAR, 13),
        Movement(Belt.GREEN, MovementCategory.HANDS, MovementSide.REGULAR, 14),
        Movement(Belt.GREEN, MovementCategory.HANDS, MovementSide.REGULAR, 15),

        Movement(Belt.GREEN, MovementCategory.FEET, MovementSide.REGULAR, 11),
        Movement(Belt.GREEN, MovementCategory.FEET, MovementSide.REGULAR, 12),
        Movement(Belt.GREEN, MovementCategory.FEET, MovementSide.REGULAR, 13),
        Movement(Belt.GREEN, MovementCategory.FEET, MovementSide.REGULAR, 14),
        Movement(Belt.GREEN, MovementCategory.FEET, MovementSide.REGULAR, 15),

        Movement(Belt.GREEN, MovementCategory.DEFENSE, MovementSide.REGULAR, 11),
        Movement(Belt.GREEN, MovementCategory.DEFENSE, MovementSide.REGULAR, 12),
        Movement(Belt.GREEN, MovementCategory.DEFENSE, MovementSide.REGULAR, 13),
        Movement(Belt.GREEN, MovementCategory.DEFENSE, MovementSide.REGULAR, 14),
        Movement(Belt.GREEN, MovementCategory.DEFENSE, MovementSide.REGULAR, 15),

        Movement(Belt.GREEN, MovementCategory.FORMS, MovementSide.NONE, movementNumber = 5, formName = "Pyung Ahn E Dan"),

        // Senior Green Belt - Opposite Side (11-15)
        Movement(Belt.SENIOR_GREEN, MovementCategory.HANDS, MovementSide.OPPOSITE, 11),
        Movement(Belt.SENIOR_GREEN, MovementCategory.HANDS, MovementSide.OPPOSITE, 12),
        Movement(Belt.SENIOR_GREEN, MovementCategory.HANDS, MovementSide.OPPOSITE, 13),
        Movement(Belt.SENIOR_GREEN, MovementCategory.HANDS, MovementSide.OPPOSITE, 14),
        Movement(Belt.SENIOR_GREEN, MovementCategory.HANDS, MovementSide.OPPOSITE, 15),

        Movement(Belt.SENIOR_GREEN, MovementCategory.FEET, MovementSide.OPPOSITE, 11),
        Movement(Belt.SENIOR_GREEN, MovementCategory.FEET, MovementSide.OPPOSITE, 12),
        Movement(Belt.SENIOR_GREEN, MovementCategory.FEET, MovementSide.OPPOSITE, 13),
        Movement(Belt.SENIOR_GREEN, MovementCategory.FEET, MovementSide.OPPOSITE, 14),
        Movement(Belt.SENIOR_GREEN, MovementCategory.FEET, MovementSide.OPPOSITE, 15),

        Movement(Belt.SENIOR_GREEN, MovementCategory.DEFENSE, MovementSide.OPPOSITE, 11),
        Movement(Belt.SENIOR_GREEN, MovementCategory.DEFENSE, MovementSide.OPPOSITE, 12),
        Movement(Belt.SENIOR_GREEN, MovementCategory.DEFENSE, MovementSide.OPPOSITE, 13),
        Movement(Belt.SENIOR_GREEN, MovementCategory.DEFENSE, MovementSide.OPPOSITE, 14),
        Movement(Belt.SENIOR_GREEN, MovementCategory.DEFENSE, MovementSide.OPPOSITE, 15),

        Movement(Belt.SENIOR_GREEN, MovementCategory.FORMS, MovementSide.NONE, movementNumber = 6, formName = "Pyung Ahn Sam Dan"),

        // Brown Belt - Regular Side (16-20)
        Movement(Belt.BROWN, MovementCategory.HANDS, MovementSide.REGULAR, 16),
        Movement(Belt.BROWN, MovementCategory.HANDS, MovementSide.REGULAR, 17),
        Movement(Belt.BROWN, MovementCategory.HANDS, MovementSide.REGULAR, 18),
        Movement(Belt.BROWN, MovementCategory.HANDS, MovementSide.REGULAR, 19),
        Movement(Belt.BROWN, MovementCategory.HANDS, MovementSide.REGULAR, 20),

        Movement(Belt.BROWN, MovementCategory.FEET, MovementSide.REGULAR, 16),
        Movement(Belt.BROWN, MovementCategory.FEET, MovementSide.REGULAR, 17),
        Movement(Belt.BROWN, MovementCategory.FEET, MovementSide.REGULAR, 18),
        Movement(Belt.BROWN, MovementCategory.FEET, MovementSide.REGULAR, 19),
        Movement(Belt.BROWN, MovementCategory.FEET, MovementSide.REGULAR, 20),

        Movement(Belt.BROWN, MovementCategory.DEFENSE, MovementSide.REGULAR, 16),
        Movement(Belt.BROWN, MovementCategory.DEFENSE, MovementSide.REGULAR, 17),
        Movement(Belt.BROWN, MovementCategory.DEFENSE, MovementSide.REGULAR, 18),
        Movement(Belt.BROWN, MovementCategory.DEFENSE, MovementSide.REGULAR, 19),
        Movement(Belt.BROWN, MovementCategory.DEFENSE, MovementSide.REGULAR, 20),

        Movement(Belt.BROWN, MovementCategory.FORMS, MovementSide.NONE, movementNumber = 7, formName = "Pyung Ahn Sah Dan"),
        Movement(Belt.BROWN, MovementCategory.FORMS, MovementSide.NONE, movementNumber = 1, formName = "Bong Hyung Il Bu", isWeaponsForm = true),

        // Senior Brown Belt - Opposite Side (16-20)
        Movement(Belt.SENIOR_BROWN, MovementCategory.HANDS, MovementSide.OPPOSITE, 16),
        Movement(Belt.SENIOR_BROWN, MovementCategory.HANDS, MovementSide.OPPOSITE, 17),
        Movement(Belt.SENIOR_BROWN, MovementCategory.HANDS, MovementSide.OPPOSITE, 18),
        Movement(Belt.SENIOR_BROWN, MovementCategory.HANDS, MovementSide.OPPOSITE, 19),
        Movement(Belt.SENIOR_BROWN, MovementCategory.HANDS, MovementSide.OPPOSITE, 20),

        Movement(Belt.SENIOR_BROWN, MovementCategory.FEET, MovementSide.OPPOSITE, 16),
        Movement(Belt.SENIOR_BROWN, MovementCategory.FEET, MovementSide.OPPOSITE, 17),
        Movement(Belt.SENIOR_BROWN, MovementCategory.FEET, MovementSide.OPPOSITE, 18),
        Movement(Belt.SENIOR_BROWN, MovementCategory.FEET, MovementSide.OPPOSITE, 19),

        Movement(Belt.SENIOR_BROWN, MovementCategory.FEET, MovementSide.OPPOSITE, 20),

        Movement(Belt.SENIOR_BROWN, MovementCategory.DEFENSE, MovementSide.OPPOSITE, 16),
        Movement(Belt.SENIOR_BROWN, MovementCategory.DEFENSE, MovementSide.OPPOSITE, 17),
        Movement(Belt.SENIOR_BROWN, MovementCategory.DEFENSE, MovementSide.OPPOSITE, 18),
        Movement(Belt.SENIOR_BROWN, MovementCategory.DEFENSE, MovementSide.OPPOSITE, 19),
        Movement(Belt.SENIOR_BROWN, MovementCategory.DEFENSE, MovementSide.OPPOSITE, 20),

        Movement(Belt.SENIOR_BROWN, MovementCategory.FORMS, MovementSide.NONE, movementNumber = 8, formName = "Pyung Ahn Oh Dan"),

        // Red Belt
        Movement(Belt.RED, MovementCategory.FORMS, MovementSide.NONE, movementNumber = 9, formName = "Bassai"),

        // Senior Red Belt
        Movement(Belt.SENIOR_RED, MovementCategory.FORMS, MovementSide.NONE, movementNumber = 10, formName = "Naihanchi Cho Dan"),
        Movement(Belt.SENIOR_RED, MovementCategory.FORMS, MovementSide.NONE, movementNumber = 2, formName = "Bong Hyung E Bu", isWeaponsForm = true),

        // Blue Belt
        Movement(Belt.BLUE, MovementCategory.FORMS, MovementSide.NONE, movementNumber = 11, formName = "Sip Soo")
    )

    fun getForBeltAndBelow(belt: Belt): List<Movement> {
        return movements.filter { it.belt.isAtOrBelow(belt) }
    }

    /**
     * Generate movement combinations for line practice
     * Always generates from current belt and below (not current belt only)
     * Number of moves per combination based on belt level:
     * - White/Senior White: 1 move
     * - Orange/Senior Orange: 2 moves (first = defense or hands)
     * - Green/Senior Green: 3 moves (first = defense, last = feet)
     * - Brown and higher: 4 moves (first = defense, last = feet)
     */
    fun getMoveCombinations(belt: Belt): List<MoveCombination> {
        // Always use current belt and below (per user requirement)
        val availableMovements = getForBeltAndBelow(belt)
            .filter { it.category != MovementCategory.FORMS }

        val combinations = mutableListOf<MoveCombination>()

        // Determine number of moves based on belt level
        val comboSize = when (belt) {
            Belt.WHITE, Belt.SENIOR_WHITE -> 1
            Belt.ORANGE, Belt.SENIOR_ORANGE -> 2
            Belt.GREEN, Belt.SENIOR_GREEN -> 3
            else -> 4 // BROWN, SENIOR_BROWN, RED, SENIOR_RED, BLUE, BLACK
        }

        // Generate 25 random combinations for variety
        repeat(25) {
            val moves = mutableListOf<String>()

            when (comboSize) {
                1 -> {
                    // Single random movement
                    availableMovements.randomOrNull()?.name?.let { moves.add(it) }
                }
                2 -> {
                    // First move: DEFENSE or HANDS (per user requirement)
                    val firstMove = availableMovements
                        .filter { it.category == MovementCategory.DEFENSE || it.category == MovementCategory.HANDS }
                        .randomOrNull()?.name

                    if (firstMove != null) {
                        moves.add(firstMove)
                        // Second move: any movement
                        availableMovements.randomOrNull()?.name?.let { moves.add(it) }
                    }
                }
                3 -> {
                    // First move: DEFENSE (per user requirement)
                    val firstMove = availableMovements
                        .filter { it.category == MovementCategory.DEFENSE }
                        .randomOrNull()?.name

                    if (firstMove != null) {
                        moves.add(firstMove)
                        // Middle move: any movement
                        availableMovements.randomOrNull()?.name?.let { moves.add(it) }
                        // Last move: FEET (per user requirement)
                        val lastMove = availableMovements
                            .filter { it.category == MovementCategory.FEET }
                            .randomOrNull()?.name
                        if (lastMove != null) {
                            moves.add(lastMove)
                        }
                    }
                }
                4 -> {
                    // First move: DEFENSE (per user requirement)
                    val firstMove = availableMovements
                        .filter { it.category == MovementCategory.DEFENSE }
                        .randomOrNull()?.name

                    if (firstMove != null) {
                        moves.add(firstMove)
                        // Middle two moves: any movements
                        availableMovements.randomOrNull()?.name?.let { moves.add(it) }
                        availableMovements.randomOrNull()?.name?.let { moves.add(it) }
                        // Last move: FEET (per user requirement)
                        val lastMove = availableMovements
                            .filter { it.category == MovementCategory.FEET }
                            .randomOrNull()?.name
                        if (lastMove != null) {
                            moves.add(lastMove)
                        }
                    }
                }
            }

            // Only add if we successfully created a full combination
            if (moves.size == comboSize) {
                // Determine category based on moves
                val category = when {
                    moves.all { it.startsWith("HANDS") } -> "Hands"
                    moves.all { it.startsWith("FEET") } -> "Feet"
                    moves.all { it.startsWith("DEFENSE") } -> "Defense"
                    else -> "Mixed"
                }

                combinations.add(MoveCombination(belt, moves, category))
            }
        }

        return combinations
    }
}