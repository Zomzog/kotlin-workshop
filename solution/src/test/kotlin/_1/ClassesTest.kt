package _1

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class ClassesTest {

    @Test
    fun `workshop toString`() {
        val workshop = Workshop("Kotlin", 29)

        assertThat(workshop.toString()).isEqualTo("Workshop(name=Kotlin, attendeesCount=29)")
    }

    @Test
    fun `workshop equals`() {
        val workshop = Workshop("Kotlin", 29)

        val expected = Workshop("Kotlin", 29)
        assertThat(workshop).isEqualTo(expected)
    }

    @Test
    fun `workshop hashcode`() {
        val workshop = Workshop("Kotlin", 29)

        assertThat(workshop.hashCode()).isEqualTo(1131585308)
    }

    @Test
    fun `workshop var`() {
        val workshop = Workshop("Kotlin", 31)

        workshop.attendeesCount = 29

        val expected = Workshop("Kotlin", 29)
        assertThat(workshop).isEqualTo(expected)
    }

    @Test
    fun `workshop access`() {
        val workshop = Workshop("KOTLIN", 31)

        assertThat(workshop.name).isEqualTo("KOTLIN")
        assertThat(workshop.attendeesCount).isEqualTo(31)
    }

    @Test
    fun `hello workshop`() {
        val workshop = Workshop("kotlin", 42)

        assertThat(helloWorkshop(workshop)).isEqualTo("Hello to 42 attendees of kotlin workshop")
    }
}