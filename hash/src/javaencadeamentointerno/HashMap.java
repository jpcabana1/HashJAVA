package javaencadeamentointerno;

public class HashMap {

      private final static int TAM = 5;
      NoHash[] tabela;

      HashMap() {
            tabela = new NoHash[TAM];
            for (int i = 0; i < TAM; i++)
                  tabela[i] = null;
      }

      public int Pesquisa(int chave) {
            int hash = (chave % TAM);
            int HashInicial = -1;
            while (hash != HashInicial && (tabela[hash] == Deletado.getDeletado() || tabela[hash] != null && tabela[hash].getChave() != chave)) {
                  if (HashInicial == -1)
                        HashInicial = hash;
                  hash = (hash + 1) % TAM;//Tentativa Linear
            }

            if (tabela[hash] == null || hash == HashInicial)
                  return -1;
            else
                  return tabela[hash].getValor();
      }

      public void Inserir(int chave, int valor) {
            
            int hash = (chave % TAM);
            int HashInicial = -1;
            int IndiceDeletado = -1;

            while (hash != HashInicial && (tabela[hash] == Deletado.getDeletado() || tabela[hash] != null && tabela[hash].getChave() != chave)) {
                  
                  if (HashInicial == -1)
                        HashInicial = hash;

                  if (tabela[hash] == Deletado.getDeletado())
                        IndiceDeletado = hash;

                  hash = tentativaLinear(hash);// tentativa linear
            }

            if ((tabela[hash] == null || hash == HashInicial) && IndiceDeletado != -1)
                  tabela[IndiceDeletado] = new NoHash(chave, valor);

            else if (HashInicial != hash)
                  if (tabela[hash] != Deletado.getDeletado() && tabela[hash] != null && tabela[hash].getChave() == chave)
                        tabela[hash].setValor(valor);
                  else
                        tabela[hash] = new NoHash(chave, valor);
      }

      public void Remover(int chave) {

            int hash = (chave % TAM);
            int HashInicial = -1;
            while (hash != HashInicial && (tabela[hash] == Deletado.getDeletado() || tabela[hash] != null && tabela[hash].getChave() != chave)) {

                  if (HashInicial == -1)
                        HashInicial = hash;
                  hash = (hash + 1) % TAM;
            }

            if (hash != HashInicial && tabela[hash] != null)
                  tabela[hash] = Deletado.getDeletado();
      }
           
      public int tentativaLinear(int hash){    
          return (hash + 1) % TAM;
      }
               
      public void ExibeHashMap(){
          for(int i = 0; i < TAM; i++){
              System.out.print("Chave: " + tabela[i].getChave() + " Valor: " + tabela[i].getValor());
              System.out.println();
          }
      }

}