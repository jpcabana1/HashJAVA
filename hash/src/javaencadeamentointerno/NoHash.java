package javaencadeamentointerno;

public class NoHash {
  
      private int Chave;
      private int Valor;

      NoHash(int chave, int valor) {
            this.Chave = chave;
            this.Valor = valor;
      }

      public int getValor() {
            return Valor;
      }

      public void setValor(int value) {
            this.Valor = value;
      }

      public int getChave() {
            return Chave;
      }


}
