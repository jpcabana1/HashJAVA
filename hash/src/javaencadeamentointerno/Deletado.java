package javaencadeamentointerno;

public class Deletado extends NoHash {
    
    private static Deletado NO = null;
    
      private Deletado() {

            super(-1, -1);

      }
      
      public static Deletado getDeletado() {

            if (NO == null)

                  NO = new Deletado();

            return NO;

      }
      
}
