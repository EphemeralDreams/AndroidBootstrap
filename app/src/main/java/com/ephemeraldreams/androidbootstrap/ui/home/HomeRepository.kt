package com.ephemeraldreams.androidbootstrap.ui.home

import com.ephemeraldreams.androidbootstrap.annotations.ApplicationId
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepository @Inject constructor(@ApplicationId val applicationId : String)
