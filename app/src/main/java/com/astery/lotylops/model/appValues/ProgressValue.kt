package com.astery.lotylops.model.appValues


enum class ProgressValue{
    Level{
        override val default: Int = 0
    },
    Money{
        override val default: Int = 0
    },
    /** number of all completed days */
    DaysCompleted{
        override val default: Int = 0
    };
    abstract val default:Int
}

