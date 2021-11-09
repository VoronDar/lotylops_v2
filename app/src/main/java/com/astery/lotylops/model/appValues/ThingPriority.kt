package com.astery.lotylops.model.appValues


/**
 * values for vocabulary and phraseology cards that can be shown with a different Priority
 * */
enum class PriorityThing{
    ImagePriority,
    TranslatePriority,
    MeaningPriority;

    val default = Priority.PriorityNeverTest
}

/**
 * priority values for PriorityThing
 * */
enum class Priority{
    /** never - never card\never test (still be presented if there are no others elements) */
    PriorityNever,
    /** always card\never test  (still be presented if there are no others elements) */
    PriorityNeverTest,
    /** always card\in test only if there is no max priority. */
    PriorityTryAlways,
    /** always card\always test */
    PriorityMax;

}
