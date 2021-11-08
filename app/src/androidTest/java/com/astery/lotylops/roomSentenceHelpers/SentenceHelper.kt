package com.astery.lotylops.roomSentenceHelpers

import com.astery.lotylops.model.entities.SelectTrain
import com.astery.lotylops.model.entities.Sentence
import com.astery.lotylops.model.entities.TrainSpec

/**
 * get test objects.
 * */
object SentenceHelper {
    fun getExample(id:Long, linkedId:String): Sentence.Example {
        return Sentence.Example(id, "sentence", "translate", linkedId)
    }
    fun getTrain(id:Long, linkedId:String, spec: TrainSpec = TrainSpec.WRITE_TRAIN): Sentence.Train {
        return Sentence.Train(id, "sentence", "translate", linkedId, spec)
    }
    fun getSelectTrain(id:Long, linkedId:String): SelectTrain {
        return SelectTrain(id, "sentence", "translate", "asdas", null, null, linkedId)
    }
}