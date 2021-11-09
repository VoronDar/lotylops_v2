package com.astery.lotylops.roomCourseHelpers

import com.astery.lotylops.model.appValues.Branch
import com.astery.lotylops.model.entities.Course

object CourseHelper {
    fun getCourse(id:String, branch: Branch): Course {
        return Course(id, "name", 12, 12,
            accessibility = true,
            hasAccess = true,
            isEnabled = true,
            branch = branch
        )
    }
    fun getCourse2(id:String, branch: Branch): Course {
        return Course(id, "name2", 1, 3,
            accessibility = false,
            hasAccess = false,
            isEnabled = false,
            branch = branch
        )
    }
}