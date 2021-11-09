package com.astery.lotylops.model.entities.converters

import androidx.room.TypeConverter
import com.astery.lotylops.model.appValues.Branch
import com.astery.lotylops.model.entities.TrainSpec

/** {@see Course }*/
class BranchConverter {

    @TypeConverter
    fun toBranch(spec:Int): Branch {
        for (e in Branch.values()) {
        if (e.ordinal == spec)
            return e;
    }
        throw  RuntimeException("BranchConverter got invalid enum ordinal = $spec");
    }

    @TypeConverter
    fun fromBranch(spec: Branch):Int {
        return spec.ordinal
    }
}