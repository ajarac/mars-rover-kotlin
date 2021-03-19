package com.wallapop.application

interface ApplicationService<C> {

    fun execute(command: C)
}
