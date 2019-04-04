package com.pulse.innovation

import com.pulse.innovation.data.model.Content
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Rule

/**
 * Created by Vlad Sabau on 04.04.19.
 */
open class BaseTest {

    @Rule
    @JvmField
    var testSchedulerRule = RxImmediateSchedulerRule()

    @After
    fun afterTests() {
        unmockkAll()
    }

    fun getMockContentList() : List<Content> {
        val contentList: ArrayList<Content> = ArrayList()

        val content1 = Content()
        content1.id = 1

        val content2 = Content()
        content2.id = 2

        val content3 = Content()
        content3.id = 3

        contentList.add(content1)
        contentList.add(content2)
        contentList.add(content3)

        return contentList
    }
}