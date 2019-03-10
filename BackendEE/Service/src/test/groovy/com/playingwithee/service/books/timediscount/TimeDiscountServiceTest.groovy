package com.playingwithee.service.books.timediscount

import com.playingwithee.dal.book.api.dto.BookOverallData
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class TimeDiscountServiceTest extends Specification {

    def "should get empty list without drawing discounts"() {
        given:
            TimeDiscountService timeDiscountService = new TimeDiscountService()
        when:
            Set<TimeDiscount> actualPromotions = timeDiscountService.getActualPromotions()
        then:
            actualPromotions.isEmpty()
    }

    def "should get three discounted books after drawing promotions"() {
        given:
            TimeDiscountService timeDiscountService = new TimeDiscountService()
            Set<BookOverallData> listOfBooks = getSampleListOfBooks()
            timeDiscountService.drawPromotion(listOfBooks)
        when:
            Set<TimeDiscount> actualPromotions = timeDiscountService.getActualPromotions()
        then:
            !actualPromotions.isEmpty()
            actualPromotions.size() == 3
    }

    private Set<BookOverallData> getSampleListOfBooks() {
        return Arrays.asList(new BookOverallData(1, "1984", "George Orwell", null,25.4, 0),
                new BookOverallData(2, "Sentimental Education", "Gustave Flaubert", null,27.4, 0),
                new BookOverallData(3, "Anna Karenina", "Leo Tolstoy", null,31.8, 0),
                new BookOverallData(4, "The Divine Comedy", "Dante Alighieri", null,9.4, 0),
                new BookOverallData(5, "Faust", "Johann Wolfgang von Goethe", null,11.4, 0))
    }
}
