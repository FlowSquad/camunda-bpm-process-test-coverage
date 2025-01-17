package org.camunda.bpm.extension.process_test_coverage.junit5

import org.camunda.bpm.engine.test.Deployment
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension

class ClassCoverageTest {

    companion object {
        @JvmField
        @RegisterExtension
        var extension: ProcessEngineCoverageExtension = ProcessEngineCoverageExtension.builder().assertClassCoverageAtLeast(1.0).build()
    }

    @Test
    @Deployment(resources = [CoverageTestProcessConstants.BPMN_PATH])
    fun testPathA() {
        val variables: MutableMap<String, Any> = HashMap()
        variables["path"] = "A"
        extension.processEngine.runtimeService.startProcessInstanceByKey(CoverageTestProcessConstants.PROCESS_DEFINITION_KEY, variables)
    }

    @Test
    @Deployment(resources = [CoverageTestProcessConstants.BPMN_PATH])
    fun testPathB() {
        val variables: MutableMap<String, Any> = HashMap()
        variables["path"] = "B"
        extension.processEngine.runtimeService.startProcessInstanceByKey(CoverageTestProcessConstants.PROCESS_DEFINITION_KEY, variables)
    }

}