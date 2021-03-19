package shared

import com.github.javafaker.Faker

class FakerSingleton {
    companion object {
        val faker: Faker = Faker()

        fun randomInt(min: Int, max: Int): Int {
            return faker.random().nextInt(min, max)
        }

        fun randomInt(values: Int): Int {
            return faker.random().nextInt(values)
        }
    }
}

