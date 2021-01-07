package example

import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.findAnnotation

annotation class ImPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet
@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

@ImPlant class Plant {
    @get:OnGet
    val isGrowing: Boolean = true

    @set:OnSet
    var needsFood: Boolean = false

    fun trim() {}
    fun fertilize() {}
}

fun testAnnotations() {
    val classObj = Plant::class
    for (a in classObj.annotations) {
        println(a.annotationClass.simpleName)
    }
}

fun testAnnotations2() {
    val plantObject = Plant::class
    val myAnnotationObject = plantObject.findAnnotation<ImPlant>()
    println(myAnnotationObject)
}

fun labels() {
    outerLoop@ for (i in 1..100) {
        print("$i ")
        for (j in 1..100) {
            if (i > 10) break@outerLoop
        }
    }
}
fun main() {
    testAnnotations()
    testAnnotations2()
    labels()
}