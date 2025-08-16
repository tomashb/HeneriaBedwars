package gg.heneria.bedwars.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColorsTest {

  @Test
  void translate_ampersand_to_section() {
    assertEquals("§aHello", Colors.translate("&aHello"));
  }

  @Test
  void translate_hex() {
    assertEquals("§x§f§f§0§0§0§0Bonjour", Colors.translate("&#ff0000Bonjour"));
  }
}

