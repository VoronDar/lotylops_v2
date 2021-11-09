package com.astery.lotylops.model.appValues


/**
 * values for learning that change every day
 * */
enum class TodayValue{
    DayPlanState{
        override val default: Int = 0
    },
    IsDayCompleted{
        override val default: Int = 0
    },
    IsNothingForToday{
        override val default: Int = 0
    };
    abstract val default:Int
}

/** *
 * possible values for DayPlanState
 */
enum class DayPlanState{
    NotStarted,
    Started,
    Completed
}


/**
 * values for branches. Change every day
 * */
enum class TodayBranchValue{
    /** number of cards need to repeat today left */
    LeftToRepeat{
        override val default: Int = 0
    },
    /** number of cards need to study today left */
    LeftToStudy{
        override val default: Int = 0
    };

    abstract val default:Int
}
