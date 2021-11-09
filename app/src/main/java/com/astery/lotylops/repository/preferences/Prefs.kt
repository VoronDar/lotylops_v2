package com.astery.lotylops.repository.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.astery.lotylops.BranchSettings
import com.astery.lotylops.model.appValues.*

object Prefs {


    private const val PREF = "prefs"

    /*
    move to the models later
    private const val APPROACH = "approach"
    private const val REMEMBERED_CARDS_COUNT = "rememberedCount"
    private const val STUDIED_CARDS_COUNT = "studiedCount"
    private const val FORGOTTEN_CARDS_COUNT = "forgottenCount"
    private const val FREQUENCY = "frequency"
    private const val HELP_STUDY = "helpStudy"
    private const val IS_SALES = "sales"
    private const val PLAYER_HEALTH = "playerHealth"
    private const val PLAYER_SCORE = "playerScore"
    private const val WIN_HOLDER = "winHolder"
    private const val WIN_ROUNDS_COUNT = "winRounds"
    private const val TURN_PLAYER = "turnPlayer"
    private const val TURN_TYPE = "turnType"
    private const val GAME_SCORES = "gameScores"
    private const val GAME_PLAYED = "gamePlayed"
    private const val PLAYER_NAME = "playerName"
    private const val USER_ID = "userID"
    private const val PRACTICE_PAID = "practicePaid"
    private const val NOW_LANGUAGE = "nowLanguage"
    private const val IS_GAME_ALLOWED = "gameAllowed"
    private const val IS_PRACTICE_ALLOWED = "practiceAllowed"
    private const val DAYS_WORKED_COUNT = "daysWorked"

     */


    private fun getPref(context: Context): SharedPreferences {
        return context.getSharedPreferences("prefs", 0)
    }

    fun get(ctx: Context, language: LanguageThing): LanguagePriority {
        return LanguagePriority.values()[(getPref(ctx).getInt(
            language.name,
            language.default.ordinal
        ))]
    }

    fun set(ctx: Context, priority: LanguageThing, value: LanguagePriority) {
        getPref(ctx).edit { putInt(priority.name, value.ordinal) }
    }

    fun get(ctx: Context, variable: PriorityThing): Priority {
        return Priority.values()[(getPref(ctx).getInt(
            variable.name,
            variable.default.ordinal
        ))]
    }

    fun set(ctx: Context, variable: PriorityThing, value: Priority) {
        getPref(ctx).edit { putInt(variable.name, value.ordinal) }
    }

    fun get(ctx: Context, variable: BranchSettings, branch: Branch): Int {
        return getPref(ctx).getInt(variable.name + branch.name, variable.default)
    }

    fun set(ctx: Context, variable: BranchSettings, branch: Branch, value: Int) {
        getPref(ctx).edit { putInt(variable.name + branch.name, value) }
    }


    fun get(ctx: Context, variable: TodayBranchValue, branch: Branch): Int {
        return getPref(ctx).getInt(variable.name + branch.name, variable.default)
    }

    fun set(ctx: Context, variable: TodayBranchValue, branch: Branch, value: Int) {
        getPref(ctx).edit { putInt(variable.name + branch.name, value) }
    }

    fun isTurnedOn(ctx: Context, turnable: TurnableThing): Boolean {
        return (getPref(ctx).getBoolean(turnable.name, true))
    }

    fun setTurnedOn(ctx: Context, turnable: TurnableThing, value: Boolean) {
        getPref(ctx).edit { putBoolean(turnable.name, value) }

    }

    fun get(ctx: Context, variable: AppValue): Int {
        return getPref(ctx).getInt(variable.name, variable.default)
    }

    fun set(ctx: Context, variable: AppValue, value: Int) {
        getPref(ctx).edit { putInt(variable.name, value) }
    }

    fun get(ctx: Context, variable: TodayValue): Int {
        return getPref(ctx).getInt(variable.name, variable.default)
    }

    fun set(ctx: Context, variable: TodayValue, value: Int) {
        getPref(ctx).edit { putInt(variable.name, value) }
    }

    fun get(ctx: Context, variable: ProgressValue): Int {
        return getPref(ctx).getInt(variable.name, variable.default)
    }

    fun set(ctx: Context, variable: ProgressValue, value: Int) {
        getPref(ctx).edit { putInt(variable.name, value) }
    }
}
