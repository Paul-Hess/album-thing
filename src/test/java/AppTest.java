import org.fluentlenium.adapter.FluentTest;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Enter the name");
  }

  @Test
  public void organizerCreateTest() {
    goTo("http://localhost:4567/");
    fill("#title").with("red medicine");
    fill("#artist").with("fugazi");
    submit(".btn");
    click("a", withText("go to your album list"));
    assertThat(pageSource()).contains("red medicine");
  }

  @Test
  public void organizerCreateTestTwoRecords() {
    goTo("http://localhost:4567/");
    fill("#title").with("red medicine");
    fill("#artist").with("fugazi");
    submit(".btn");
    fill("#title").with("untitled");
    fill("#artist").with("egghunt");
    submit(".btn");
    click("a", withText("go to your album list"));
    assertThat(pageSource()).contains("red medicine");
    assertThat(pageSource()).contains("egghunt");
  }

  @Test
  public void organizerDisplaySearchResultsTitle() {
    goTo("http://localhost:4567/");
    fill("#title").with("red medicine");
    fill("#artist").with("fugazi");
    submit(".btn");
    fill("#title").with("untitled");
    fill("#artist").with("egghunt");
    submit(".btn");
    click("a", withText("go to your album list"));
    fill("#title-search").with("fugazi");
    submit(".titleBtn");
    assertThat(pageSource()).contains("red medicine");
  }
}
