import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;


import static org.junit.Assert.assertEquals;


public class BrennanRonanTestTask2 {

    ArrayList<Period> normalPeriods;
    ArrayList<Period> discountPeriods;
    ArrayList<Period> calculateNormalPeriod;
    ArrayList<Period> calculateDiscountPeriod;



    /* Rate Constructor Tests*/

    @Before
    public void addPeriodsForTests() {

        normalPeriods = new ArrayList<Period>() {{ //for Rate Tests
            add(new Period(12, 16));
            add(new Period(17, 18));
        }};

        discountPeriods = new ArrayList<Period>() {{ //for Rate Tests
            add(new Period(16, 17));
        }};

        calculateNormalPeriod = new ArrayList<Period>() {{ //for Calculate Tests
            add(new Period(0, 2));
            add(new Period(14, 18));
            add(new Period(22, 24));
        }};


        calculateDiscountPeriod = new ArrayList<Period>() {{ //for Calculate Tests
            add(new Period(0, 3));
            add(new Period(12, 16));
            add(new Period(23, 24));
        }};


    }

    /* Test 1: Constructor is working with Kind(Management)*/

    @Test
    public void checkManagement() {
        Rate RT = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(6), new BigDecimal(4), normalPeriods, discountPeriods);
    }

    /* Test 2: Constructor is working with Kind(Staff) */

    @Test
    public void checkStaff() {
        Rate RT = new Rate(CarParkKind.STAFF, new BigDecimal(7), new BigDecimal(3), normalPeriods, discountPeriods);
    }

    /* Test 3: Constructor is working with Kind(Student) */

    @Test
    public void checkStudent() {
        Rate RT = new Rate(CarParkKind.STUDENT, new BigDecimal(3), new BigDecimal(1), normalPeriods, discountPeriods);
    }

    /* Test 4: Constructor is working with Kind(Visitor) */

    @Test
    public void checkVisitor() {
        Rate RT = new Rate(CarParkKind.VISITOR, new BigDecimal(10), new BigDecimal(8), normalPeriods, discountPeriods);
    }

    /* Test 5: normalRate is lowest positive(0) return Illegal Argument Exception as discount is larger than normal*/
    @Test
            (expected = IllegalArgumentException.class)
    public void normalRateIsZero() {
        Rate RT = new Rate(CarParkKind.STAFF, new BigDecimal(0), new BigDecimal(5), normalPeriods, discountPeriods);
    }

    /* Test 6: discountRate is lowest positive(0) less than normalRate therefore fine*/
    @Test
    public void discountRateis0() {
        Rate r = new Rate(CarParkKind.STUDENT, new BigDecimal(8), new BigDecimal(0), normalPeriods, discountPeriods);
    }

    /* Test 7: normalRate is greater than zero(Positive Integer)*/

    @Test
    public void normalRateGreaterThanZero() {
        Rate RT = new Rate(CarParkKind.VISITOR, new BigDecimal(20), new BigDecimal(12), normalPeriods, discountPeriods);
    }

    /* Test 8: discountRate is greater than zero(Positive Integer). Illegal Argument raised as discountRate is Larger than normalRate*/

    @Test
            (expected = IllegalArgumentException.class)
    public void discountRateGreaterThanZero() {
        Rate RT = new Rate(CarParkKind.VISITOR, new BigDecimal(12), new BigDecimal(14), normalPeriods, discountPeriods);
    }

    /*  Test 9: discountRate is greater than zero(Positive Integer) but is less than normalRate */

    @Test
    public void discountRateGreaterThanZeroLessThanNormalRate() {
        Rate RT = new Rate(CarParkKind.VISITOR, new BigDecimal(16), new BigDecimal(14), normalPeriods, discountPeriods);
    }

    /*  Test 10: normalRate is a negative integer */

    @Test
            (expected = IllegalArgumentException.class)
    public void normalRateNegative() {
        Rate RT = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(-8), new BigDecimal(4), normalPeriods, discountPeriods);
    }

    /*  Test 11: discountRate is a negative integer */

    @Test
            (expected = IllegalArgumentException.class)
    public void discountRateNegative() {
        Rate RT = new Rate(CarParkKind.STAFF, new BigDecimal(4), new BigDecimal(-3), normalPeriods, discountPeriods);
    }

    /*  Test 12: discountRate and normalRate are negative integers */

    @Test
            (expected = IllegalArgumentException.class)
    public void normalRateAndDiscountRateNegative() {
        Rate RT = new Rate(CarParkKind.VISITOR, new BigDecimal(-1), new BigDecimal(-3), normalPeriods, discountPeriods);
    }

    /* Test 13: normalRate &  discountRate same value*/

    @Test
            (expected = IllegalArgumentException.class)
    public void normalRateAndDiscountRateSame() {
        Rate RT = new Rate(CarParkKind.VISITOR, new BigDecimal(4), new BigDecimal(4), discountPeriods, normalPeriods);
    }

    /*  Test 14: normalRate max Value*/

    @Test
    public void maxValueNormalRate() {
        int maxLength = 1000000000;
        Rate RT = new Rate(CarParkKind.VISITOR, new BigDecimal(maxLength), new BigDecimal(10), normalPeriods, discountPeriods);
    }

    /* Test 15: discountRate Max Value greater than normalRate*/

    @Test
            (expected = IllegalArgumentException.class)
    public void maxValueDiscountRateGreaterThanNormal() {
        int maxLength = 1000000000;
        Rate RT = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(8), new BigDecimal(maxLength), normalPeriods, discountPeriods);
    }

    /* Test 16: discountRate Max Value less than normalRate*/
    @Test
    public void discountRateMaxValue() {
        int maxLength = 1000000000;
        Rate RT = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(maxLength), new BigDecimal(maxLength - 1), normalPeriods, discountPeriods);
    }

    /*Test 17: normalRate is null*/

    @Test
            (expected = NullPointerException.class)
    public void normalRateIsNull() {
        BigDecimal BD = null;
        Rate RT = new Rate(CarParkKind.VISITOR, BD, new BigDecimal(20), normalPeriods, discountPeriods);
    }

    /*Test 18: discountRate is null*/
    @Test
            (expected = NullPointerException.class)
    public void discountRateIsNull() {
        BigDecimal BD = null;
        Rate RT = new Rate(CarParkKind.VISITOR, new BigDecimal(12), BD, normalPeriods, discountPeriods);
    }

    /*Test 19: normalRate and discountRate is null*/

    @Test
            (expected = IllegalArgumentException.class)
    public void normalRateAndDiscountRateIsNull() {
        BigDecimal BD = null;
        Rate RT = new Rate(CarParkKind.VISITOR, BD, BD, normalPeriods, discountPeriods);
    }

    /* Test 20 : Character entry for normalRate

    @Test
            (expected = IllegalArgumentException.class)
    public void normalRateIsChar(){
        Rate RT = new Rate(CarParkKind.STAFF, new BigDecimal('R'),new BigDecimal(10),normalPeriods,discountPeriods);
    }*/

    /* Test 21: Character entry for discountRate */
    @Test
            (expected = IllegalArgumentException.class)
    public void discountRateIsChar() {
        Rate RT = new Rate(CarParkKind.STAFF, new BigDecimal(12), new BigDecimal('C'), normalPeriods, discountPeriods);
    }

    /* Test 22: Character entry for both discountRate and normalRate
    @Test
            (expected = IllegalArgumentException.class)
    public void normalRateAndDiscountRateIsChar(){
        Rate RT = new Rate(CarParkKind.STAFF, new BigDecimal('R'),new BigDecimal('C'),normalPeriods,discountPeriods);
    }*/

    /* Test 23: String entry for normalRate */

    @Test
            (expected = IllegalArgumentException.class)
    public void normalRateIsString() {
        Rate RT = new Rate(CarParkKind.VISITOR, new BigDecimal("Foot"), new BigDecimal(4), normalPeriods, discountPeriods);
    }

    /* Test 24: String entry for discountRate */
    @Test
            (expected = IllegalArgumentException.class)
    public void discountRateIsString() {
        Rate RT = new Rate(CarParkKind.VISITOR, new BigDecimal(8), new BigDecimal("Ball"), normalPeriods, discountPeriods);
    }

    /* Test 25: String entry for both discountRate and normalRate Should fail but doesn't when string */
    @Test
            (expected = IllegalArgumentException.class)
    public void normalRateAndDiscountRateIsString() {
        Rate RT = new Rate(CarParkKind.VISITOR, new BigDecimal("Foot"), new BigDecimal("Ball"), normalPeriods, discountPeriods);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /* Test 26: Max Length of normalPeriod less than or equal 24 */

    @Test
    public void maxLengthNormalPeriodLessThanEqualTo24() {
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> discountPeriods = new ArrayList<Period>();
        int h = 0;
        while (h < 24) {
            normalPeriods.add(new Period(h, h + 1));
            h++;
        }
        Rate RT = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(3), new BigDecimal(1), normalPeriods, discountPeriods);
    }



    /* Test 27: Max Length of discount period less than or equal 24 */

    @Test
    public void maxLengthDiscountPeriodLessThanEqualTo24() {
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> discountPeriods = new ArrayList<Period>();
        int h = 0;
        while (h < 24) {
            discountPeriods.add(new Period(h, h + 1));
            h++;
        }
        Rate RT = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(8), new BigDecimal(4), normalPeriods, discountPeriods);
    }

    /*Test 28: Max Length normalPeriod is greater than 24*/

    @Test
            (expected = IllegalArgumentException.class)
    public void normalPeriodGreaterThan24() {
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> discountPeriods = new ArrayList<Period>();

        int i = 0;
        while (i < 28) {
            normalPeriods.add(new Period(i, i + 1));
            i++;
        }
        Rate RT = new Rate(CarParkKind.STAFF, new BigDecimal(12), new BigDecimal(2), normalPeriods, discountPeriods);
    }


    /* Test 29:  Max Length discountPeriod is greater than 24 */

    @Test
            (expected = IllegalArgumentException.class)
    public void discountPeriodGreaterThan24() {
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> discountPeriods = new ArrayList<Period>();
        int h = 0;
        while (h < 28) {
            discountPeriods.add(new Period(h, h + 1));
            h++;
        }
        Rate RT = new Rate(CarParkKind.STAFF, new BigDecimal(9), new BigDecimal(4), normalPeriods, discountPeriods);
    }

    /*Test 30: No normal period Array values (Empty) Covered somewhat in previous four tests but not addressed*/

    @Test
    public void normalPeriodNoValues() {
        ArrayList<Period> normalPeriods = new ArrayList<Period>();
        ArrayList<Period> discountPeriods = new ArrayList<Period>() {{
            add(new Period(9, 10));
            add(new Period(10, 11));

        }};
        Rate RT = new Rate(CarParkKind.STUDENT, new BigDecimal(7), new BigDecimal(3), normalPeriods, discountPeriods);
    }

    /*Test 31: No discount period Array values (Empty) Covered somewhat in previous four tests but not addressed*/

    @Test
    public void discountPeriodNoValues() {
        ArrayList<Period> normalPeriods = new ArrayList<Period>() {{
            add(new Period(10, 11));
            add(new Period(11, 12));

        }};
        ArrayList<Period> discountPeriods = new ArrayList<Period>();

        Rate RT = new Rate(CarParkKind.STUDENT, new BigDecimal(3), new BigDecimal(2), normalPeriods, discountPeriods);
    }

    /* Test 32: NormalPeriod does not overlap*/
    @Test
    public void noOverlapNormalPeriod() {
        ArrayList<Period> normalPeriods = new ArrayList<Period>() {{
            add(new Period(10, 11));
            add(new Period(12, 13));
        }};
        ArrayList<Period> discountPeriods = new ArrayList<Period>() {{
            add(new Period(11, 12));
        }};

        Rate RT = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(14), new BigDecimal(8), normalPeriods, discountPeriods);
    }

    /* Test 33: discountPeriod does not overlap */

    @Test
    public void noOverlapDiscountPeriod() {
        ArrayList<Period> normalPeriods = new ArrayList<Period>() {{
            add(new Period(10, 11));
            add(new Period(13, 14));
        }};
        ArrayList<Period> discountPeriods = new ArrayList<Period>() {{
            add(new Period(11, 12));
            add(new Period(12, 13));
        }};

        Rate RT = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(15), new BigDecimal(6), normalPeriods, discountPeriods);
    }

    /* Test 34: normalPeriod and discountPeriod do not overlap | Similar to test 32 and 33 but not addressed */
    @Test
    public void noOverlapNormalPeriodAndDiscountPeriod() {
        ArrayList<Period> normalPeriods = new ArrayList<Period>() {{
            add(new Period(10, 11));
            add(new Period(13, 14));
        }};
        ArrayList<Period> discountPeriods = new ArrayList<Period>() {{
            add(new Period(11, 12));
            add(new Period(12, 13));
        }};

        Rate r = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(15), new BigDecimal(6), normalPeriods, discountPeriods);
    }

    /* Test 35: normalPeriod does overlap */

    @Test
            (expected = IllegalArgumentException.class)
    public void normalPeriodDoesOverlap() {
        ArrayList<Period> normalPeriods = new ArrayList<Period>() {{
            add(new Period(12, 15));
            add(new Period(13, 14));
        }};
        ArrayList<Period> discountPeriods = new ArrayList<Period>() {{
            add(new Period(6, 7));
            add(new Period(7, 8));

        }};

        Rate RT = new Rate(CarParkKind.VISITOR, new BigDecimal(10), new BigDecimal(4), normalPeriods, discountPeriods);
    }

    /* Test 36: discountPeriod does overlap */

    @Test
            (expected = IllegalArgumentException.class)
    public void discountPeriodDoesOverlap() {
        ArrayList<Period> normalPeriods = new ArrayList<Period>() {{
            add(new Period(12, 13));
            add(new Period(13, 14));
        }};
        ArrayList<Period> discountPeriods = new ArrayList<Period>() {{
            add(new Period(6, 12));
            add(new Period(7, 8));

        }};

        Rate RT = new Rate(CarParkKind.VISITOR, new BigDecimal(11), new BigDecimal(3), normalPeriods, discountPeriods);
    }

    /* Test 37: normalPeriod and discountPeriod do overlap*/

    @Test
            (expected = IllegalArgumentException.class)
    public void normalPeriodAndDiscountPeriodDoOverlap() {
        ArrayList<Period> normalPeriods = new ArrayList<Period>() {{
            add(new Period(10, 23));
        }};
        ArrayList<Period> discountPeriods = new ArrayList<Period>() {{
            add(new Period(12, 15));
        }};

        Rate RT = new Rate(CarParkKind.VISITOR, new BigDecimal(9), new BigDecimal(6), normalPeriods, discountPeriods);
    }

    /* Test 38: Both normalPeriod and discountPeriod overlap themselves and each other*/

    @Test
            (expected = IllegalArgumentException.class)
    public void normalPeriodAndDiscountPeriodDoOverlap2() {
        ArrayList<Period> normalPeriods = new ArrayList<Period>() {{
            add(new Period(4, 8));
            add(new Period(5, 10));
        }};
        ArrayList<Period> discountPeriods = new ArrayList<Period>() {{
            add(new Period(9, 15));
            add(new Period(12, 16));
        }};

        Rate RT = new Rate(CarParkKind.VISITOR, new BigDecimal(14), new BigDecimal(12), normalPeriods, discountPeriods);
    }

    /* Test 39: normalPeriod is null

    @Test
            (expected = IllegalArgumentException.class)
    public void nullNormalPeriod() {
        Period PD = null;
        ArrayList<Period> normalPeriods = new ArrayList<Period>() {{
            add(PD);
        }};
        ArrayList<Period> discountPeriods = new ArrayList<Period>() {{
            add(new Period(1, 2));
        }};

        Rate RT = new Rate(CarParkKind.STUDENT, new BigDecimal(3), new BigDecimal(1), normalPeriods, discountPeriods);
    }

    @Test (expected = NullPointerException.class)
    public void nullDiscountPeriod(){
        Period PD = null;
        ArrayList<Period> discountPeriods = new ArrayList<Period>(){{
            add(PD);
        }};
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{
       add(new Period(10,12));
        }};
        Rate r = new Rate(CarParkKind.VISITOR, new BigDecimal(10),new BigDecimal(7),discountPeriods,normalPeriods);
    }


    /*                                          Calculate                                                               */

    /* Test 41: normalPeriod Check for morning Period(include first hour) */
    @Test
    public void calculateNormalPeriodMorningCheck() {
        Rate RT = new Rate(CarParkKind.STUDENT, new BigDecimal(6), new BigDecimal(4),
                calculateNormalPeriod, calculateDiscountPeriod);
        Period PD = new Period(0, 2);
        assertEquals(BigDecimal.valueOf(12), RT.calculate(PD));
    }

    /* Test 42: normalPeriod Check for during the Day/Evening Period */
    @Test
    public void calculateNormalPeriodDayEveningCheck() {
        Rate RT = new Rate(CarParkKind.STAFF, new BigDecimal(7), new BigDecimal(3),
                calculateNormalPeriod, calculateDiscountPeriod);
        Period PD = new Period(14, 18);
        assertEquals(BigDecimal.valueOf(28), RT.calculate(PD));
    }

    /* Test 43: normalPeriod Check for night Period(include last hour) */

    @Test
    public void calculateNormalPeriodLastHourCheck() {
        Rate RT = new Rate(CarParkKind.VISITOR, new BigDecimal(8), new BigDecimal(2),
                calculateNormalPeriod, calculateDiscountPeriod);
        Period PD = new Period(22, 24);
        assertEquals(BigDecimal.valueOf(16), RT.calculate(PD));
    }

    /* Test 44: discountPeriod Check for morning Period(include first hour) */
    @Test
    public void calculateDiscountPeriodFirstHourCheck() {
        Rate RT = new Rate(CarParkKind.VISITOR, new BigDecimal(6), new BigDecimal(4),
                calculateNormalPeriod, calculateDiscountPeriod);
        Period PD = new Period(0, 3);
        assertEquals(BigDecimal.valueOf(12), RT.calculate(PD));
    }

    /* Test 45: discountPeriod Check for during the Day/Evening Period */
    @Test
    public void calculateDiscountPeriodAnytimeCheck() {
        Rate RT = new Rate(CarParkKind.MANAGEMENT, new BigDecimal(7), new BigDecimal(3),
                calculateNormalPeriod, calculateDiscountPeriod);
        Period p = new Period(12, 16);
        assertEquals(BigDecimal.valueOf(12), RT.calculate(p));
    }

    /* Test 46: discountPeriod Check for night Period(include last hour) */

    @Test
    public void calculateDiscountPeriodLastHourCheck() {
        Rate RT = new Rate(CarParkKind.STUDENT, new BigDecimal(8), new BigDecimal(2),
                calculateNormalPeriod, calculateDiscountPeriod);
        Period PD = new Period(23, 24);
        assertEquals(BigDecimal.valueOf(2), RT.calculate(PD));
    }



/*                          Additions for 100% Branch Coverage                                                          */

    /* Test 40: normalPeriod is null. Had been implemented but not correctly in Task 1*/
    @Test
            (expected =NullPointerException.class)
    public void nullNormalPeriod(){
        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{
            add(new Period(2,4));
        }};

        ArrayList<Period> discountPeriods = new ArrayList<Period>(){{
            add(new Period(2,4));
        }};

        Rate r = new Rate(CarParkKind.STUDENT, new BigDecimal(10),new BigDecimal(13),discountPeriods,null);
    }

    /* Test 40: discountPeriod is null. Had been implemented but not correctly in Task 1*/
    @Test
            (expected =NullPointerException.class)
    public void nullDiscountPeriod(){

        ArrayList<Period> normalPeriods = new ArrayList<Period>(){{
            add(new Period(1,2));
        }};
        ArrayList<Period> discountPeriods = new ArrayList<Period>(){{
            add(new Period(2,4));
        }};
        Rate r = new Rate(CarParkKind.STUDENT, new BigDecimal(8),new BigDecimal(5),null,normalPeriods);
    }


    /* Calculate Discount Period */

    @Test
    public void calculatePeriodStay() {
        ArrayList<Period> calculateNormalPeriod = new ArrayList<Period>(){{
            add(new Period(5,6));
        }};
        ArrayList<Period> calculateDiscountPeriod = new ArrayList<Period>(){{
            add(new Period(6,8));
        }};
        Period PD = new Period(5,8);
        Rate RT = new Rate(CarParkKind.STUDENT, new BigDecimal(8), new BigDecimal(2),
                calculateNormalPeriod, calculateDiscountPeriod);
        assertEquals(BigDecimal.valueOf(16).add(BigDecimal.valueOf(2)), RT.calculate(PD));
    }


}








