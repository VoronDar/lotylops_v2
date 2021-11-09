package com.astery.lotylops.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.astery.lotylops.model.appValues.*
import com.astery.lotylops.repository.localDataStorage.cardStorage.CardStorage
import com.astery.lotylops.repository.preferences.Prefs
import com.astery.lotylops.ruler.AppTime
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class BaseViewModel @Inject constructor(@ApplicationContext val context:Context): ViewModel() {
    fun prepare(){
        Timber.i("HELLO?")
        //startApp(context)
        //setNewDay(context)
    }

    /**
     * check if this application was opened before
     * prepare for using app
     * */
    private fun startApp(context: Context){
        viewModelScope.launch {
            if (Prefs.get(context, AppValue.AppStarted) == 0) {
                Prefs.set(context, AppValue.AppStarted, 1)
                Prefs.set(context, AppValue.StartDay, AppTime.absoluteDay())
            }
        }

    }

    /**
     * check if the day is new and prepare for learning
     * this function must be called in onCreate of the main activity
     * */
    private fun setNewDay(context: Context) {
        viewModelScope.launch {
            //StatisticManager.setThisWeekInfo(context)
            if (AppTime.appDay(context) > Prefs.get(context, AppValue.LastDayComing)) {
                //StatisticManager.addNew(context)
                //FirebaseDatabase.checkForMessagesForMe(context)


                Prefs.set(context, TodayValue.DayPlanState, DayPlanState.NotStarted.ordinal)
                Prefs.set(context, TodayValue.IsDayCompleted, 0)
                //Shop.Thing.addPlan.reload(context)
                //Shop.Thing.practice.reload(context)

                var sumOfCardsToday = 0
                for (i in Branch.values()) {
                    val dao = CardStorage.getCardStorage(i)

                    sumOfCardsToday += 0 // TODO()
                    Prefs.set(context, TodayBranchValue.LeftToRepeat, i, TODO())
                    Prefs.set(context, TodayBranchValue.LeftToStudy, i, TODO())
                }

                Prefs.set(
                    context,
                    TodayValue.IsNothingForToday,
                    (if (sumOfCardsToday == 0) 1 else 0)
                )

                Prefs.set(context, AppValue.LastDayComing, AppTime.appDay(context))
                //TeacherManager.checkPaceEffectiveness(context, VOCABULARY_INDEX);
                //TeacherManager.checkForCritical(context);
            }
        }
    }
}

