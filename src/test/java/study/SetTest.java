package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set 자료구조는 중복된 데이터를 제거하고, size()는 Collection 의 크기를 반환한다")
    @Test
    void sizeTest() throws Exception {
        assertThat(numbers).hasSize(3);
    }

    @DisplayName("contains() 은 Collection 에 저장된 element 여부를 확인할 수 있다")
    @Test
    void containsTest() throws Exception {
        assertThat(numbers).contains(1, 2, 3);
    }

    @ParameterizedTest(name = "contains() 은 Collection 에 저장된 element 여부를 확인할 수 있다")
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsTrueOrFalseTest(int element, boolean hasElement) throws Exception {
        assertThat(numbers.contains(element)).isEqualTo(hasElement);
    }
}