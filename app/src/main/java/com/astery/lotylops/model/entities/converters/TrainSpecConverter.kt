package com.astery.lotylops.model.entities.converters

import androidx.room.TypeConverter
import com.astery.lotylops.model.entities.TrainSpec

/** {@see Sentence.Train }*/
class TrainSpecConverter {

    @TypeConverter
    fun toTrainSpec(spec:Int): TrainSpec {
        for (e in TrainSpec.values()) {
        if (e.ordinal == spec)
            return e;
    }
        throw  RuntimeException("TrainSpecConverter got invalid enum ordinal = $spec");
    }

    @TypeConverter
    fun fromTrainSpec(spec: TrainSpec):Int {
        return spec.ordinal
    }
}