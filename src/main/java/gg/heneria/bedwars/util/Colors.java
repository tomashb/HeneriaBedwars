package gg.heneria.bedwars.util;

public final class Colors {
  private Colors() {}

  public static String translate(String s) {
    if (s == null) return "";
    // Basique: & -> § ; support léger des hex &#RRGGBB -> §x§R§R§G§G§B§B
    String out = s.replace('&', '§');
    int idx;
    while ((idx = out.indexOf("§#")) != -1 && idx + 8 <= out.length()) {
      String hex = out.substring(idx + 2, idx + 8);
      if (hex.matches("(?i)[0-9a-f]{6}")) {
        StringBuilder sb = new StringBuilder("§x");
        for (char c : hex.toCharArray()) sb.append('§').append(c);
        out = out.substring(0, idx) + sb + out.substring(idx + 8);
      } else break;
    }
    return out;
  }
}

