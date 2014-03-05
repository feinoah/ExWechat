/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ericxu131.exwechat.model.message;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author eric
 */
public class NewsMessageNGTest {

    public NewsMessageNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test
    public void testSomeMethod() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(NewsMessage.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader("<xml>\n"
                + "<ToUserName><![CDATA[toUser]]></ToUserName>\n"
                + "<FromUserName><![CDATA[fromUser]]></FromUserName>\n"
                + "<CreateTime>12345678</CreateTime>\n"
                + "<MsgType><![CDATA[news]]></MsgType>\n"
                + "<ArticleCount>2</ArticleCount>\n"
                + "<Articles>\n"
                + "<item>\n"
                + "<Title><![CDATA[title1]]></Title> \n"
                + "<Description><![CDATA[description1]]></Description>\n"
                + "<PicUrl><![CDATA[picurl]]></PicUrl>\n"
                + "<Url><![CDATA[url]]></Url>\n"
                + "</item>\n"
                + "<item>\n"
                + "<Title><![CDATA[title]]></Title>\n"
                + "<Description><![CDATA[description]]></Description>\n"
                + "<PicUrl><![CDATA[picurl]]></PicUrl>\n"
                + "<Url><![CDATA[url]]></Url>\n"
                + "</item>\n"
                + "</Articles>\n"
                + "</xml> ");
        NewsMessage message = (NewsMessage) unmarshaller.unmarshal(reader);
        assertEquals(MessageType.NEWS, message.getMsgType());
        assertSame(2, message.getArticleCount());
        assertSame(2, message.getItems().size());

        final NewsMessageItem item1 = message.getItems().get(0);
        assertEquals("description1", item1.getDescription());
        assertEquals("title1", item1.getTitle());
        assertNotEquals("title", item1.getTitle());
        assertEquals("picurl", item1.getPicUrl());

    }

}
