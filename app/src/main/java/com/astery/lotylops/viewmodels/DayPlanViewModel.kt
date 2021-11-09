package com.astery.lotylops.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.astery.lotylops.model.appValues.Branch
import com.astery.lotylops.model.appValues.TodayBranchValue
import com.astery.lotylops.repository.preferences.Prefs

class DayPlanViewModel: ViewModel() {

    /** return true if there are no more cards
     * */
    fun isDailyPlanCompleted(context: Context): Boolean {
        for (i in Branch.values()) {
            if (Prefs.get(context, TodayBranchValue.LeftToRepeat, i) > 0) return false
            if (Prefs.get(context, TodayBranchValue.LeftToStudy, i) > 0) return false
        }
        return true
    }
}
