package com.astery.lotylops.ruler

import android.content.Context
import com.astery.lotylops.model.appValues.AppValue
import com.astery.lotylops.repository.preferences.Prefs
import java.util.*


object AppTime{
    /** get app day (absolute+extra) */
    fun appDay(context: Context):Int{
        return absoluteDay() + Prefs.get(context, AppValue.ExtraDayCount)
    }

    /** get actual calendar day */
    fun absoluteDay(): Int{
        val calendar = Calendar.getInstance(TimeZone.getDefault())
        return calendar[Calendar.DAY_OF_YEAR] + calendar[Calendar.YEAR] * 365
    }

}