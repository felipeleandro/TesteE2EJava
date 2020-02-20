package com.cit.howtojunite2etest.tests;

import com.cit.howtojunite2etest.suporte.Navegador;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.lang.model.element.Element;
import javax.swing.*;
import java.awt.*;

public class MouseOver {
    private WebDriver navegador;

    @Before
    public void before () {
        this.navegador = Navegador.criarNavegador();
    }

    /* url da página de teste: http://automacaocombatista.herokuapp.com/iteracoes/mousehover */
    @Test
    public void validarMouseOver () {

        /* implementar e teste automatizado para a validação abaixo */

        // navega ate a pagina informada
        this.navegador.get("http://automacaocombatista.herokuapp.com/iteracoes/mousehover");

        WebElement element = this.navegador.findElement(By.className("activator"));

        Actions mouseMove = new Actions(navegador);

        mouseMove.moveToElement(element).build().perform();

        String result = this.navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div[3]/p")).getText();
        Assert.assertEquals("Você usou o mouse hover!", result);
    }

    @After
    public void after () {
        this.navegador.quit();
    }
}
