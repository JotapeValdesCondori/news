/*
 * Copyright 2020 Juan Valdes Condori, juan.valdes@alumnos.ucn.cl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dsm.jvaldes.news.service;

import com.github.javafaker.Faker;

import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import cl.ucn.disc.dsm.jvaldes.news.model.News;

/**
 * @author Juan Valdes.
 */

public class TestContractsImpl {

    private static final Logger log = LoggerFactory.getLogger(TestContractsImpl.class);

    @Test
    public void testRetrieveNews (){
        log.debug("Testing...");

        //The concrete implementation
        Contracts contracts = new ContractsImpl();

        // Call the method..
        List <News> news = contracts.retriveNews(5);

        // The list can´t be null
        Assertions.assertNotNull(news, "list was null :(");

        // The list can´t be empty
        Assertions.assertTrue(news.size() != 0, "Empty list? :(");

        // The size (list == 5)
        Assertions.assertTrue(news.size() == 5, "List Size != 5");

        // debug to log
        for (News n : news) {
            log.debug("News: {}", ToStringBuilder.reflectionToString(n, ToStringStyle.MULTI_LINE_STYLE));
        }

        //size = 0
        Assertions.assertEquals(0, contracts.retriveNews(0).size(),"List != 0");

        //size = 3
        Assertions.assertEquals(3, contracts.retriveNews(3).size(), "List != 3");

        //size = 10
        Assertions.assertTrue(contracts.retriveNews(10).size() <= 10, "List !=10");

        log.debug("Done.");




    }


    /**
     * The Test of save news.
     */
    @Test
    public void testSaveNews(){
        log.debug("Testing..");

        // The concrete implemetnation
        Contracts contracts = new ContractsImpl():

        // Nullity
        Assertions.assertThrows(IllegalAccessException.class, () -> contracts.saveNews(null));

        int size = contracts.retriveNews(1000).size();
        log.debug("Size: {}.", size);

        // Saving ok?
        News news = new News(
                "The Title",
                "The Source",
                "The Author",
                null,
                null,
                "The Description",
                "The Content",
                ZonedDateTime.now(ZoneId.of("-3")));
        contracts.saveNews(news);

        // One more time!
        int newSize = contracts.retriveNews(1000).size();
        Assertions.assertEquals(size + 1, newSize, "Wrong size!");

        // Save duplicated
        Assertions.assertThrows(IllegalAccessException.class, () -> contracts.saveNews(news));

        log.debug(".. Done.");


    }

    /**
     * show the faker
     */

    @Test
    public void testFaker(){

        //Build the faker
        Faker faker = Faker.instance();

        for (int i = 0; i<5; i++){
            log.debug("Name: {}", faker.name().fullName());
            // FIXME: Remover
            System.out.println("name: " + faker.name().fullName());

        }

    }
}
