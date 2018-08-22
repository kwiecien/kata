package codewars.scramblies

import junit.framework.Assert.assertEquals
import org.junit.Test

class ScrambliesTest {

    private fun testing(actual: Boolean, expected: Boolean) {
        assertEquals(expected, actual)
    }

    @Test
    fun test() {
        System.out.println("Fixed Tests scramble")
        testing(Scramblies.scramble("rkqodlw", "world"), true)
        testing(Scramblies.scramble("cedewaraaossoqqyt", "codewars"), true)
        testing(Scramblies.scramble("katas", "steak"), false)
        testing(Scramblies.scramble("scriptjavx", "javascript"), false)
        testing(Scramblies.scramble("scriptingjava", "javascript"), true)
        testing(Scramblies.scramble("scriptsjava", "javascripts"), true)
        testing(Scramblies.scramble("javscripts", "javascript"), false)
        testing(Scramblies.scramble("aabbcamaomsccdd", "commas"), true)
        testing(Scramblies.scramble("commas", "commas"), true)
        testing(Scramblies.scramble("sammoc", "commas"), true)
    }

}