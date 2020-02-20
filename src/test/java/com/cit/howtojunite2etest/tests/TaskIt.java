package com.cit.howtojunite2etest.tests;

import com.cit.howtojunite2etest.suporte.Navegador;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TaskIt {
    private WebDriver navegador;

    @Before
    public void before () {
        this.navegador = Navegador.criarNavegador();
    }

    /* url da página de teste: http://www.juliodelima.com.br/taskit */
    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario () throws Exception {
        //navega
        this.navegador.get("http://www.juliodelima.com.br/taskit");

        // Clicar no link "Sign in"'
        this.navegador.findElement(By.xpath("/html/body/nav/div/div/ul[1]/li/a")).click();
        // Mudar o foco para a modal de Login
        WebElement modal = this.navegador.findElement(By.id("signinbox"));
        // Digitar no campo "login" (dentro do formulário) o texto "julio0001"
        modal.findElement(By.name("login")).sendKeys("julio0001");
        // Digitar no campo "password" (dentro do formulário) o texto "123456"
        modal.findElement(By.name("password")).sendKeys("123456");
        // Clicar no link "SIGN IN"
        Thread.sleep(500);
        modal.findElement(By.xpath("/html/body/div[4]/div[2]/a")).click();


        // Clicar no no link "me"
        Thread.sleep(500);
        this.navegador.findElement(By.xpath("/html/body/nav/div/div/ul[1]/li[1]/a")).click();
        // Clicar no link  "MORE DATA ABOUT YOU"
        this.navegador.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
        // Clicar no botão "+ ADD MORE DATA"
        this.navegador.findElement(By.xpath("//*[@id=\"moredata\"]/div[2]/button")).click();


        // Mudar o foco para a modal de formulário para adicionar mais dados
        WebElement form = this.navegador.findElement(By.id("addmoredata"));
        // Escolher a opção Phone no combobox de type
        form.findElement(By.name("type")).sendKeys("Phone");
        // No campo de "contact" digitar "+5511999999999"
        form.findElement(By.name("contact")).sendKeys("5511999999999");
        // Clicar no link "SAVE" que está na popup
        form.findElement(By.xpath("/html/body/div[2]/div[2]/a")).click();


        // Na mensagem validar que o texto é "Your contact has been added!"
        String result = this.navegador.findElement(By.xpath("//*[@id=\"toast-container\"]/div")).getText();
        Assert.assertEquals("Your contact has been added!", result);
    }

    @After
    public void after () {
        this.navegador.quit();
    }
}
