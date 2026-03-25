package com.tsdtrainer.app.data

import com.tsdtrainer.app.models.*

object LinePracticeRepository {

    private val moves = listOf(
        // White Belt - Blocks
        LineMovement(Belt.WHITE, "Low Block", LineMovementType.BLOCK),
        LineMovement(Belt.WHITE, "High Block", LineMovementType.BLOCK),
        LineMovement(Belt.WHITE, "Inside Outside Block", LineMovementType.BLOCK),
        LineMovement(Belt.WHITE, "Outside Inside Block", LineMovementType.BLOCK),

        // White Belt - Punches
        LineMovement(Belt.WHITE, "Center Punch", LineMovementType.PUNCH),
        LineMovement(Belt.WHITE, "High Punch", LineMovementType.PUNCH),

        // White Belt - Kicks
        LineMovement(Belt.WHITE, "Front Kick", LineMovementType.KICK),
        LineMovement(Belt.WHITE, "Side Kick", LineMovementType.KICK),
        LineMovement(Belt.WHITE, "Round Kick", LineMovementType.KICK),
        LineMovement(Belt.WHITE, "Spinning Back Kick", LineMovementType.KICK),
        LineMovement(Belt.WHITE, "Jump Front Kick", LineMovementType.KICK),
        LineMovement(Belt.WHITE, "Stepping Side Kick", LineMovementType.KICK),

        // Orange Belt - Blocks
        LineMovement(Belt.ORANGE, "Side Block", LineMovementType.BLOCK),
        LineMovement(Belt.ORANGE, "Low Chop Block", LineMovementType.BLOCK),

        // Orange Belt - Punches
        LineMovement(Belt.ORANGE, "Side Center Punch (Horse Stance)", LineMovementType.PUNCH),
        LineMovement(Belt.ORANGE, "Ridge Hand Punch", LineMovementType.PUNCH),

        // Orange Belt - Kicks
        LineMovement(Belt.ORANGE, "Hook Kick", LineMovementType.KICK),
        LineMovement(Belt.ORANGE, "Jumping Round Kick", LineMovementType.KICK),

        // Green Belt - Blocks
        LineMovement(Belt.GREEN, "Reinforced Block", LineMovementType.BLOCK),
        LineMovement(Belt.GREEN, "Center Chop Block", LineMovementType.BLOCK),

        // Green Belt - Punches
        LineMovement(Belt.GREEN, "Spear Hand Attack Punch", LineMovementType.PUNCH),
        LineMovement(Belt.GREEN, "Upper Cut Punch", LineMovementType.PUNCH),

        // Green Belt - Kicks
        LineMovement(Belt.GREEN, "Wheel Kick", LineMovementType.KICK),
        LineMovement(Belt.GREEN, "Knee Strike Kick", LineMovementType.KICK),

        // Brown Belt - Punches
        LineMovement(Belt.BROWN, "Elbow Strike Punch", LineMovementType.PUNCH),

        // Brown Belt - Kicks
        LineMovement(Belt.BROWN, "Stomp Kick", LineMovementType.KICK),
        LineMovement(Belt.BROWN, "Axe Kick", LineMovementType.KICK),
        LineMovement(Belt.BROWN, "Single-Action Jump Front Kick", LineMovementType.KICK),
        LineMovement(Belt.BROWN, "Spinning Hook Kick", LineMovementType.KICK),

        // Red Belt - Blocks
        LineMovement(Belt.RED, "Low Double X Block", LineMovementType.BLOCK),
        LineMovement(Belt.RED, "Medium Double X Block", LineMovementType.BLOCK),
        LineMovement(Belt.RED, "High Double X Block", LineMovementType.BLOCK),

        // Red Belt - Punches
        LineMovement(Belt.RED, "Spear Hand Punch", LineMovementType.PUNCH),

        // Blue Belt - Blocks
        LineMovement(Belt.BLUE, "Double Hand Palm Block", LineMovementType.BLOCK),

        // Blue Belt - Kicks
        LineMovement(Belt.BLUE, "Diagonal Kick", LineMovementType.KICK),
        LineMovement(Belt.BLUE, "Sweep Kick", LineMovementType.KICK),
        LineMovement(Belt.BLUE, "Jump Spinning Back Kick", LineMovementType.KICK),
        LineMovement(Belt.BLUE, "Blue Belt Axe Kick", LineMovementType.KICK)
    )

    fun getForBeltAndBelow(belt: Belt): List<LineMovement> {
        return moves.filter { it.belt.isAtOrBelow(belt) }
    }
}