package com.astery.lotylops.model.appValues

/**
 * variables for vocabulary and phraseology card that can be shown with a different language priority
 * */
enum class LanguageThing{
    MeaningLanguage,
    ExamplesLanguage;
    val default = LanguagePriority.Both
}


/**
 * values of LanguageThing.
 * */
enum class LanguagePriority{
    Foreign,
    Native,
    Both,
}
