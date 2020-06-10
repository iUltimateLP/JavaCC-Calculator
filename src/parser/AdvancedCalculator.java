/* Generated By:JavaCC: Do not edit this line. AdvancedCalculator.java */
package parser;
import ast.*;
import ast.functions.*;
import java.util.*;
import java.math.BigDecimal;

// The Java class implementation
public class AdvancedCalculator implements AdvancedCalculatorConstants {
        // This acts as a simple register for variables, associating decimals with a string variable name
        public static Hashtable<String, BigDecimal> memory = new Hashtable<String, BigDecimal>() {{
                // We can pre-fill the memory with a few constants here
                put("pi", new BigDecimal(Math.PI));
                put("euler", new BigDecimal(2.71828182845904523536));
        }};

// A "line" in the program
  final public Expression Line() throws ParseException {
        // A single expression will be needed
        Expression e;
    // Create a new expression, any line is terminated with a semicolon
            e = Expression();
    jj_consume_token(6);
                {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

// An expression, which can be any term or a binary operation
  final public Expression Expression() throws ParseException {
        // A left and a right expression will be needed
        Expression left, right;
    // Create the left term which will always exist, then a right term if any +/- operation was given
            // Then, the left term will get the correct expression assigned
            left = Term();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 7:
      case 8:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 7:
        jj_consume_token(7);
        right = Term();
                                     left = new AddExpression(left, right);
        break;
      case 8:
        jj_consume_token(8);
        right = Term();
                                     left = new SubtractExpression(left, right);
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
                {if (true) return left;}
    throw new Error("Missing return statement in function");
  }

// A term can be a primary operation or a multiplication/division followed by a primary operation
  final public Expression Term() throws ParseException {
         // A left and a right expression will be needed
        Expression left, right;
    // Punkt-vor-Strich, thats why multiplication, division and modulo operations are primary operations
            // Concept same as above
            left = Primary();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 9:
      case 10:
      case 11:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 9:
        jj_consume_token(9);
        right = Primary();
                                        left = new MultiplicationExpression(left, right);
        break;
      case 10:
        jj_consume_token(10);
        right = Primary();
                                        left = new DivisionExpression(left, right);
        break;
      case 11:
        jj_consume_token(11);
        right = Primary();
                                        left = new ModuloExpression(left, right);
        break;
      default:
        jj_la1[3] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
                {if (true) return left;}
    throw new Error("Missing return statement in function");
  }

// A primary operation is either a expression in braces, a primary expression with a minus (unary op.), or just a number
  final public Expression Primary() throws ParseException {
        // A primary might consist out of multiple parts, so forward-declare a few variables we might need
        Expression e;
        Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 12:
      jj_consume_token(12);
      e = Expression();
      jj_consume_token(13);
                                   {if (true) return e;}
      break;
    case 8:
      jj_consume_token(8);
      e = Primary();
                            {if (true) return new UnaryMinusExpression(e);}
      break;
    case Number:
      // A simple number expression
              t = jj_consume_token(Number);
                         {if (true) return new NumberExpression(t.image);}
      break;
    default:
      jj_la1[4] = jj_gen;
      if (jj_2_1(2)) {
        // Variable assignment, using the variable name stored in the Token t, and the expression stored in e after the "=" sign
                t = jj_consume_token(Variable);
        jj_consume_token(14);
        e = Expression();
                                                {if (true) return new VariableAssignExpression(t.image, e, memory);}
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case Variable:
          // Variable read, under the hood it just returns a NumberExpression getting the value from the memory
                  t = jj_consume_token(Variable);
                           {if (true) return new NumberExpression(memory.get(t.image));}
          break;
        case 15:
        case 16:
        case 17:
        case 18:
        case 19:
        case 21:
          // Mathematical functions
                  e = Function();
                         {if (true) return e;}
          break;
        default:
          jj_la1[5] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
    throw new Error("Missing return statement in function");
  }

  final public Expression Function() throws ParseException {
        // Gets assigned with the expression for the function evaluated below
        Expression e1, e2;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 15:
      jj_consume_token(15);
      e1 = Expression();
      jj_consume_token(13);
                                       {if (true) return new SineFunctionExpression(e1);}
      break;
    case 16:
      jj_consume_token(16);
      e1 = Expression();
      jj_consume_token(13);
                                       {if (true) return new CosFunctionExpression(e1);}
      break;
    case 17:
      jj_consume_token(17);
      e1 = Expression();
      jj_consume_token(13);
                                       {if (true) return new TanFunctionExpression(e1);}
      break;
    case 18:
      jj_consume_token(18);
      e1 = Expression();
      jj_consume_token(13);
                                        {if (true) return new SqrtFunctionExpression(e1);}
      break;
    case 19:
      jj_consume_token(19);
      e1 = Expression();
      jj_consume_token(20);
      e2 = Expression();
      jj_consume_token(13);
                                                             {if (true) return new PowFunctionExpression(e1, e2);}
      break;
    case 21:
      jj_consume_token(21);
                          {if (true) return new PrintMemoryExpression(memory);}
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_3_1() {
    if (jj_scan_token(Variable)) return true;
    if (jj_scan_token(14)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public AdvancedCalculatorTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[7];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x180,0x180,0xe00,0xe00,0x401100,0xaf8000,0x2f8000,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[1];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public AdvancedCalculator(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public AdvancedCalculator(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new AdvancedCalculatorTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public AdvancedCalculator(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AdvancedCalculatorTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public AdvancedCalculator(AdvancedCalculatorTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(AdvancedCalculatorTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[24];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 7; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 24; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
