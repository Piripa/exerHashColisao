package hashColisao;

public class EstruturaHashTable implements EstruturaDeDados {
    private Integer tabela[];
    // TODO adicionar elementos necessários para implementar o porão

    public EstruturaHashTable() {
        // esse número pode ser alterado
        tabela = new Integer[1100];
    }

    @Override
    public boolean insert(int chave) {
        int valor = chave % 1000;
        if (tabela[valor] != null) { // Verifico se tem algum valor dentro
            int recalcular = (chave % 100) + 1000; // Recalcular para encaixar no porão
            if (tabela[recalcular] != null) { // Verifica se a posição está ocupada ou não
                int i = 0;
                while (i < 1000 && tabela[1000 - i] != null) { // Pecorrer nosso array até completar ou até o inídice um
                                                               // que seja null
                    i++;
                }
                if (i == 1000) { // se chegar aqui é pq percorreu todo o array
                    return false;
                } else {
                    tabela[1000 - i] = chave; // inseriu após a colisão. mais proximo do final
                    return true;
                }
            }
            tabela[recalcular] = chave;
            return true;

        }
        tabela[valor] = chave; // Se não tiver insere já nele
        return true;

    }

    @Override
    public boolean delete(int chave) {
        int valor = chave % 1000;
        int recalcular = (chave % 100) + 1000;
        if (tabela[valor] != null) {
            if (tabela[valor] == chave) {
                tabela[valor] = null;
                return true;
            } 
                if (tabela[recalcular] != null) {
                    if (tabela[recalcular] == chave) {
                        tabela[recalcular] = null;
                        return true;
                    } 
                        int i = 0;
                        while (i < 1000 && tabela[1000 - i] != null){
                            i++;
                            }
                        if(i >= 1000){
                            return false;
                        }
                        else{
                            tabela[1000-1] = null;
                            return true;
                        }       
                    }
                }

        else {
            if(tabela[recalcular]!= null){
                if(tabela[recalcular]== chave){
                    tabela[recalcular] = null;
                    return true;
                }

            int i = 0;
            while (i < 1000 && tabela[1000 - i] != null) {
                i++;
        
                }
            if(i >= 1000){
                return false;
            }
            else{
                tabela[1000-i] = null;
                return true;
                }
            }
            else{

                return false;
            }

        }
        return false;

    }

    @Override
    public int search(int chave) {
        int valor = chave %1000; 

        if(tabela[valor] != null){
            if(tabela[valor] == chave){
                return chave;
            }
            else{
                int recalcular = (chave%100) + 1000;

                if(tabela[recalcular] != null){
                    if(tabela[recalcular] == chave){
                        return chave;
                    }
                    else{
                        int i = 0;
                        while(i < 1000 && tabela[1000 - i] != null){ // procurando o proximo indice da tabela que esteja nulo de trá pra frente.
                            if(tabela[1000 - i] == chave){
                                return chave;}
                            i++;
                        }
                        
                        return -1;
                    }
                }
                return -1;
            }
        }
        else{
            int recalcular = (chave%100) + 1000;
            

                if(tabela[recalcular] != null){
                    if(tabela[recalcular] == chave){
                        return chave;
                    }
                    else{
                        int i = 0;
                        while(i < 1000 && tabela[1000 - i] != null){ // procurando o proximo indice da tabela que esteja nulo de trá pra frente.
                            if(tabela[1000 - i] == chave){
                                return chave;}
                            i++;
                        }
                        
                        return -1;
                    }
                }
                else{
                    int i = 0;
                        while(i < 1000 && tabela[1000 - i] != null){ // procurando o proximo indice da tabela que esteja nulo de trá pra frente.
                            if(tabela[1000 - i] == chave){
                                return chave;}
                            i++;
                        }

                        return -1;
                }
        }
    }


    // TODO se o elemento estiver presente retorna a sua posição. Caso contrário,
    // retorna -1.

    public static void main(String[] args) {
        EstruturaHashTable Lista = new EstruturaHashTable();
        System.out.println(Lista.insert(10));
        System.out.println(Lista.insert(1010));
        System.out.println(Lista.tabela[10]);
        System.out.println(Lista.tabela[1010]);
        // System.out.println(Lista.search(11));
        // System.out.println(Lista.delete(10));
        // System.out.println(Lista.delete(3030));
        System.out.println(Lista.search(1010)!=-1);
        // System.out.println(Lista.search(1010));
        System.out.println(Lista.tabela[1010]);

    }

}
