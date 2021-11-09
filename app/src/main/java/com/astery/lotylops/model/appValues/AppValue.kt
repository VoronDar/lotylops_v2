package com.astery.lotylops.model.appValues


/** values that required to decide what day is it, is it app started, maybe etc */
enum class AppValue{
    /** 0 if application just opened the first time*/
    AppStarted{
        override val default: Int = 0 // = false
    },
    /** absolute (real) time of first day */
    StartDay{
        override val default: Int = 0
    },
    /** number of skipped days (may be deprecated???) */
    ExtraDayCount{
        override val default: Int = 0
    },
    /** the last day (absolute+extra) the application was opened */
    LastDayComing{
        override val default: Int = 0
    };
    abstract val default:Int
}

