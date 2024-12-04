package edu.grinnell.csc207.util;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.junit.jupiter.api.Test;


/**
 * Some simple tests of our BitTree class.
 *
 * @author Samuel A. Rebelsky
 */
public class TestBitTree {
  // +---------------+-----------------------------------------------
  // | Static fields |
  // +---------------+

  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  // +-------+-------------------------------------------------------
  // | Setup |
  // +-------+

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+
  @Test
  public void testGet() { 
    BitTree bt = new BitTree(6);
    InputStream inputStream = new ByteArrayInputStream(BrailleAsciiTables.getA2BTable().getBytes(StandardCharsets.UTF_8));
    bt.load(inputStream);

    Scanner scan = new Scanner(inputStream);
    while(scan.hasNextLine()) { 
      String[] keyValuePair = scan.nextLine().strip().split(",");
      String key = keyValuePair[0];
      String value = keyValuePair[1];

      assertEquals(bt.get(key), value);
    }

    scan.close();
  }

} // class TestBitTree
