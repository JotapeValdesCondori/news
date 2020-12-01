/*
 * Copyright 2020 Juan Valdes Condori, juan.valdes@alumnos.ucn.cl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dsm.jvaldes.news.model;

import net.openhft.hashing.LongHashFunction;

import java.time.ZonedDateTime;

import cl.ucn.disc.dsm.jvaldes.news.utils.Validation;

/**
 * The Domain model: News.
 *
 * @author Juan Valdes.
 */

public class News {

    /**
     * Unique id.
     */
    private final Long id;
    /**
     * The title.
     * Restrictions: not null, size >2
     */
    private final String title;

    /**
     * The Source
     */
    private final String source;

    /**
     * The Author
     */
    private final String author;

    /**
     * The URL
     */
    private final String url;

    /**
     * The URL of Image
     */
    private final String urlImage;

    /**
     * The Description
     */
    private final String desciption;

    /**
     * The Content
     */
    private final String content;

    /**
     * The Date of publish
     */
    private final ZonedDateTime publishedAt;

    /**
     * The Constructor.
     *
     * @param title
     * @param source
     * @param author
     * @param url
     * @param urlImage
     * @param desciption
     * @param content
     * @param publishedAt
     */
    public News(String title, String source, String author, String url, String urlImage, String desciption, String content, ZonedDateTime publishedAt) {

        // Validacion de titulo
        Validation.minSize(title, 2, "title");

        this.title = title;

        // Validacion de fuente
        Validation.minSize(title, 2, "source");

        this.source = source;

        // Validacion de autor
        Validation.minSize(title, 2, "author");

        this.author = author;

        this.id = LongHashFunction.xx().hashChars(title + "|" + source + "|" + author);

        // Validacion de url
        Validation.notNull(url,"url");

        this.url = url;

        // Validacion urlImage
        Validation.notNull(urlImage, "urlImage");

        this.urlImage = urlImage;

        // Validacion de descripcion
        Validation.minSize(desciption, 10, "description");

        this.desciption = desciption;

        // Validacion de Contenido
        Validation.notNull(content, "content");

        this.content = content;

        // Validacion de fecha de publicacion
        Validation.notNull(publishedAt, "publishedAt");

        this.publishedAt = publishedAt;
    }

    /**
     * @return the id.
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the source.
     */
    public String getSource() {
        return source;
    }

    /**
     * @return the author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return the url.
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the urlImage.
     */
    public String getUrlImage() {
        return urlImage;
    }

    /**
     * @return the description.
     */
    public String getDesciption() {
        return desciption;
    }

    /**
     * @return the content.
     */
    public String getContent() {
        return content;
    }

    /**
     * @return the publishedAt.
     */
    public ZonedDateTime getPublishedAt() {
        return publishedAt;
    }
}
