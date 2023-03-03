package Aplicação;

import Classes.Produto;
import Classes.Merceeiro;
import Classes.Agropecuario;
import Classes.MenuIn;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ProjetoPOO {

static ArrayList<Merceeiro> merceeiros = new ArrayList<Merceeiro>();
static ArrayList<Agropecuario> agropecuarios = new ArrayList<Agropecuario>();
static ArrayList<Produto> produtos = new ArrayList<Produto>();

        
    public static void main(String[] args) {
        String teclado,lE="",lS;
        int opçao,opL;
        Scanner j = new Scanner(System.in);
        Scanner tecla = new Scanner (System.in);//aq
        
        
        new MenuIn().setVisible(true);

        loop:do
        {
           System.out.println("1- Login\n2- Criar uma conta\n8- Mostrar merceeiros"
                   + "\n9- Mostrar APs\n91- Produtos disp\n-1 Desligar programa");
           //opçao = Integer.parseInt(teclado);
                           

           opçao = tecla.nextInt();
        /*
        loop: do
        {
            teclado = JOptionPane.showInputDialog("1- Login\n2- Criar uma conta\n8- Mostrar merceeiros"
                   + "\n9- Mostrar APs\n91- Produtos disp\n-1 Desligar programa");
           opçao = Integer.parseInt(teclado);*/
           
            switch(opçao)
            {
                case 1:
                    
                    do
                    {
                        teclado = JOptionPane.showInputDialog("Você está tentando fazer login como:\n1- Merceeiro\n2- Agropecuário");
                        opL = Integer.parseInt(teclado);
                        
                    }while(opL!=1 && opL!=2);
                        
                    switch(opL)
                    {
                        case 1:
                            int rs=-1,rss=0,op,v=0,s;
                            
                            do
                            {
                                lE = JOptionPane.showInputDialog("Email:");
                                Merceeiro m = pesquisarM(lE); // email inexistente retorna null 
                                if(m==null)
                                {
                                    System.out.println("Email inexistente");
                                    rs=0;
                                    v++;
                                    if(v==3)
                                    {
                                        v=0;
                                        do
                                        {
                                            teclado = JOptionPane.showInputDialog("Foi percebido várias tentativas de realizar login."
                                                    + "Deseja retornar a tela principal?"
                                                + "\n1- Sim\n2- Não");
                                            s = Integer.parseInt(teclado);
                                            switch(s)
                                            {
                                                case 1:
                                                    rs = 1;
                                                    break;
                                                case 2:
                                                    rs=0;
                                                    break;
                                                default:
                                                    System.out.println("Opção inválida");
                                                    break;
                                                            
                                            }
                                        }while(s<1 || s>2);
                                    }
                                }
                                else
                                {
                                    int lp=-1;
                                    do
                                    {
                                        if(rss==3)
                                        {
                                            rss=0;
                                            teclado = JOptionPane.showInputDialog("Senha digitada várias vezes. Deseja recuperar a senha?"
                                                    + "\n1- Sim\n2- Não");
                                            op = Integer.parseInt(teclado);
                                            System.out.println("email= "+lE);
                                    
                                            if(op==1)
                                            {
                                                RecuperarSenhaM(lE);
                                            }
                                            rss=0;
                                        }
                                        lS = JOptionPane.showInputDialog("Senha:");
                                        if(m.getSenha().equals(lS))
                                        {
                                            TelaLoginM(lE);
                                            rs=1;
                                            lp=1;
                                        }
                                        else
                                        {
                                            System.out.println("Senha digitada está errada!!!");
                                            lp=0;
                                            rss++;
                                        }
                                    }while(lp==0);
                                }
                            }while(rs==0);
                            break;
                            
                        case 2:
                            int RS=-1,RSS=0,OP,V=0,S;
                            
                            do
                            {
                                
                                lE = JOptionPane.showInputDialog("Email:");
                                Agropecuario ap = pesquisarAP(lE);
                                
                                if(ap == null)
                                {
                                    System.out.println("Email inexistente");
                                    RS=0;
                                    V++;
                                    if(V==3)
                                    {
                                        V=0;
                                        do
                                        {
                                            teclado = JOptionPane.showInputDialog("Foi percebido várias tentativas de realizar o login."
                                                    + "Deseja retornar a tela principal?"
                                                + "\n1- Sim\n2- Não");
                                            S = Integer.parseInt(teclado);
                                            switch(S)
                                            {
                                                case 1:
                                                    RS = 1;
                                                    break;
                                                case 2:
                                                    RS = 0;
                                                    break;
                                                default:
                                                    System.out.println("Opção inválida");
                                            }
                                        }while(S<1 || S>2);
                                    }
                                }
                                else
                                {
                                    int LP=-1;
                                    do
                                    {
                                        if(RSS==3)
                                        {
                                            RSS=0;
                                            teclado = JOptionPane.showInputDialog("Senha digitada errada várias vezes. Deseja recuperar a senha?"
                                                    + "\n1- Sim\n2- Não");
                                            OP = Integer.parseInt(teclado);
                                            System.out.println("email= "+lE);
                                            
                                            if(OP==1)
                                            {
                                                RecuperarSenhaAP(lE);
                                            }
                                            LP=0;
                                        }
                                        lS = JOptionPane.showInputDialog("Senha:");
                                        
                                        if(ap.getSenha().equals(lS))
                                        {
                                            TelaLoginAP(lE);
                                            RS=1;
                                            LP=1;
                                        }
                                        else
                                        {
                                            System.out.println("Senha digitada está errada!!!");
                                            LP=0;
                                            RSS++;
                                        }
                                         
                                    }
                                    while(LP==0);
                                    
                                }
                            }while(RS==0);
                            break;
                    }
                    break;
                
                case 2:
                    newC();
                    break;
                
                case 8:
                    System.out.println("Contas de merceeiros criadas: ");
                    for(Merceeiro M: merceeiros)
                    {
                        System.out.println(M.Status());
                    }
                    break;
                    
                case 9:
                    System.out.println("Contas de agropecuários criadas: ");
                    for(Agropecuario a: agropecuarios)
                    {
                        System.out.println(a.Status());
                    }
                    break;
                    
                    case 91:
                    System.out.println("Produtos disponiveis: ");
                    for(Produto M: produtos)
                    {
                        System.out.println(M.Status());
                    }
                    break;
                    
                case -1:
                    System.out.println("Finalizando programa...");
                    break loop;
                
                default:
                    System.out.println("Opção Inválida!!!");
            }
            
        }while(true);
    }
    
    public static void RecuperarSenhaM(String email)
    {
        for(Merceeiro senha: merceeiros)
        {
            if(senha.getEmail().equals(email))
            {
                System.out.println("Senha informada no momento do cadastro: "+senha.getSenha());
            }
        }
            
        return;
    }
    
    public static void RecuperarSenhaAP(String email)
    {
        for(Agropecuario senha: agropecuarios)
        {
            if(senha.getEmail().equals(email))
            {
                System.out.println("Senha informada no momento do cadastro: "+senha.getSenha());
            }
        }
            
        return;
    }
    
    public static void newC() // Criar nova conta
    {
        int p;
        long v;
        String teclado;
        Merceeiro MC;
        Agropecuario AP;
        
        do
        {
            teclado = JOptionPane.showInputDialog("Você é:\n1- Merceeiro\n2- Agropecuário");
            p = Integer.parseInt(teclado);
            
            switch(p)
            {
                case 1:
                    MC = new Merceeiro();
                    System.out.println("Informe por gentileza as informações solicitadas:");
                    
                    /*do
                    {
                        teclado = JOptionPane.showInputDialog("Informe seu CPF:");
                        MC.setCNPJ(teclado);
                        v = VerificarDiCNPJ(teclado);
                    
                    }while(v==0);*///desativadot
                    
                    /*teclado = JOptionPane.showInputDialog("Informe sua Razão Social");
                    MC.setRazao_Socialteclado);*///desativadot
                    teclado = JOptionPane.showInputDialog("Informe seu nome");
                    MC.setNomeM(teclado);
                    /*
                    teclado = JOptionPane.showInputDialog("Informe o endereço da sua mercearia");
                    MC.setEndereço(teclado);
                    teclado = JOptionPane.showInputDialog("Informe o número do seu telefone");
                    MC.setTelefone(teclado);*///desativadot
                    teclado = JOptionPane.showInputDialog("Informe seu e-mail");
                    MC.setEmail(teclado);
                    teclado = JOptionPane.showInputDialog("Crie uma senha");
                    MC.setSenha(teclado);
                    
                    MC.setSaldo(0);
                    
                    merceeiros.add(MC);
                    
                    System.out.println("Sua conta foi criada com sucesso!!!");
                    
                    break;
                    
                case 2:
                    AP = new Agropecuario();
                    System.out.println("Informe por gentileza as informações solicitadas:");
                    
                    /*do
                    {
                        teclado = JOptionPane.showInputDialog("Informe seu CNPJ:");
                        AP.setCNPJ(teclado);
                        v = VerificarDiCNPJ(teclado);
                        
                    }while(v==0);*///desativadot
                    
                    teclado = JOptionPane.showInputDialog("Informe sua Atividade:");
                    AP.setAtividade(teclado);
                    teclado = JOptionPane.showInputDialog("Informe sua Razão Social");
                    AP.setRazao_Social(teclado);
                    /*
                    teclado = JOptionPane.showInputDialog("Informe seu nome");
                    AP.setNomeAP(teclado);
                    teclado = JOptionPane.showInputDialog("Informe o endereço da sua mercearia");
                    AP.setEndereço(teclado);
                    teclado = JOptionPane.showInputDialog("Informe o número do seu telefone");
                    AP.setTelefone(teclado);*///desativadot
                    teclado = JOptionPane.showInputDialog("Informe seu e-mail");
                    AP.setEmail(teclado);
                    teclado = JOptionPane.showInputDialog("Crie uma senha");
                    AP.setSenha(teclado);
                    
                    AP.setSaldo(0);
                    
                    agropecuarios.add(AP);
                    
                    System.out.println("Sua conta foi criada com sucesso!!!");
                    
                    break;
                    
                default:
                    System.out.println("Opcão Inválida!!!");
            }
            
        }while(p!=1 && p!=2);
        
    }
    
    public static long VerificarDiCNPJ(String teclado)
    {
        int contCNPJ=0,v;
        int i;
        
        for(i=0;i<teclado.length();i++)
        {
            contCNPJ++;     
        }
        
        if(contCNPJ==14)
        {
            v=1;
        }
        else
        {
            System.out.println("Digite novamente! Isso não é CNPJ!");
            v=0;
        }
        
        return v;
    }
    
    public static void TelaLoginM(String email)
    {
        int op=0,esc=0,qt;
        double s,c,result;
        String teclado;
        Scanner j = new Scanner(System.in);
        Merceeiro g = pesquisarM(email);
        Produto PDd;
        
        do
        {
            //System.out.println(g.Login());
            teclado = JOptionPane.showInputDialog("O que deseja fazer?\n1- Comprar produtos\n2- Editar informações"
                    + "\n3- Apagar conta\n4- Adicionar saldo na conta\n5- Sair da conta");
            op = Integer.parseInt(teclado);
            switch(op)
            {
            case 1: //  03/03 OBS: Quando for ver a parte da compra do produto colocar a condição de o saldo n ser numero negativo
                teclado = JOptionPane.showInputDialog("Visualizar por:\n1. Nome\n2. Categoria"
                        + "\n3. Fornecedor\n4. Listar todos disponiveis");
                esc = Integer.parseInt(teclado);
                switch(esc){
                    case 1:
                        teclado = JOptionPane.showInputDialog("\nInforme nome a pesquisar:");
                        PDd = pesquisarPD(teclado);
                        if (PDd != null) 
                        {
                            for(Produto p: produtos)
                            {
                                if(p.getNomePD().equals(teclado))
                                {
                                    System.out.println(p.Resumo());
                                }
                            }
                            System.out.println("De que fornecedor você irá querer o produto:");
                            teclado = j.next();
                            for(Produto t: produtos)
                            {
                                if(t.getNomeAP().equals(teclado))
                                {
                                    System.out.println("\n\n" + t.Resumo());
                                }
                            }
                            Agropecuario y = pesquisarAP(teclado);
                            Produto r = pesquisarAPtPD(y.getNomeAP());
                            System.out.println("\nQuantas quantidades você irá querer do produto:");
                            teclado = j.next();
                            qt = Integer.parseInt(teclado);
                            c = r.getValor()*Integer.parseInt(teclado);
                            if(c>g.getSaldo())
                            {
                                System.out.println("Saldo insuficiente!!!");
                                System.out.println("\nO total deu: "+c);
                                System.out.println("\nVocê tem no seu saldo: "+g.getSaldo());
                            }
                            if(c<=g.getSaldo())
                            {
                                System.out.println("O total deu: "+c);
                                System.out.println("\nVocê irá comprar?");
                                teclado = j.next();
                                if(teclado=="Sim" || teclado=="sim")
                                {
                                    r.setQuant(r.getQuant() - qt);
                                    y.setSaldo(c);
                                    g.setSaldo(g.getSaldo() - c);
                                    System.out.println("\nCompra bem sucedida");
                                }
                            }
                        } else {
                            System.out.println("\nProduto nao encontrado");
                        }
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        System.out.println("\nProdutos disponiveis: ");
                        for(Produto M: produtos)
                        {
                            System.out.println(M.Resumo());
                        }
                        break;
                    default:
                        break;
                    }
                break;
            case 2:
                EditarM(email);
                break;
            case 3:
                ApagarM(email);
                break;
            case 4:
                if(g.getSaldo()==0)
                {
                    System.out.println("Deseja adicionar quantos ao seu saldo:");
                    teclado = j.next();
                    g.setSaldo(Double.parseDouble(teclado));
                }
                else
                {
                    System.out.println("Deseja adicionar quantos ao seu saldo:");
                    teclado = j.next();
                    s = g.getSaldo() + Double.parseDouble(teclado);
                    g.setSaldo(s);
                }
                break;
            case 5:
                System.out.println("\nSaindo da conta!!!");
                break;
            default:
                System.out.println("\nOpção inválida!!!");
            }
        }while(op<3 || op >4);
    }
    
    public static void TelaLoginAP(String email)
    {
        int op=0;
        String teclado;
        Agropecuario h = pesquisarAP(email);
        Produto pd = new Produto();
        
        do
        {
            //System.out.println(h.Login());
            teclado = JOptionPane.showInputDialog("O que deseja fazer?\n1- Vender produtos\n2- Editar informações"
                    + "\n3- Apagar conta\n4- Sair da conta");
            op = Integer.parseInt(teclado);
            switch(op)
            {
            case 1:
                //2502
                pd = VendaProduto(h.getNomeAP());
                break;
            case 2:
                EditarAP(email);
                System.out.println("Informação atualizada com sucesso!!!");
                break;
            case 3:
                ApagarAP(email,pd);
                System.out.println("Conta apagada!!!");
                break;
            case 4:
                System.out.println("Saindo da conta!!!");
                break;
            default:
                System.out.println("Opção inválida!!!");
            }
        }while(op<3 || op >4);
    }
    
    public static Produto VendaProduto(String nomeAP)
    {
        String teclado;
        Produto pd = new Produto();
        Produto p = new Produto();
        Scanner j = new Scanner(System.in);
        int op;
        
        do
        {
            pd = pesquisarAPtPD(nomeAP);
            if(pd != null)
            {
                p = pd;
            }
            
            System.out.println("Deseja: \n1- Adicionar produto\n2- Acrescentar quantidade do produto\n3- Apagar produto"
                + "\n4- Mostrar Status do produto\n5- Voltar tela de login");
            teclado = j.next();
            op = Integer.parseInt(teclado);
            
            switch(op)
            {
                case 1:
                    if(pd == null)
                    {
                        p = AdicionarProduto(nomeAP);
                    }
                    else
                    {
                        System.out.println("Você já tem um produto cadastrado na sua conta");
                    }
                    break;
                case 2:
                    if(pd==null)
                    {
                        System.out.println("Não tem produto para editar informações. Adicione produto no catálogo");
                    }
                    else
                    {
                        AumentarQuant(p);
                    }
                    break;
                case 3:
                    if(pd==null)
                    {
                        System.out.println("Não tem produto para ser apagado. Adicione produto no catálogo");
                    }
                    else
                    {
                        ApagarPD(p);
                    }
                    break;
                case 4:
                    if(pd==null)
                    {
                        System.out.println("Não tem produto para mostrar seus status atuais. Adicione produto no catálogo");
                    }
                    else
                    {
                        System.out.println(p.Resumo());
                    }
                    break;
                case 5:
                    System.out.println("Retornando a tela principal");
                    break;
                default:
                    System.out.println("Opção inválida!!!");
            }
            
        }while(op < 4 || op > 4);
        
        return pd;
    }
    
    public static Produto AdicionarProduto(String nomeAP)
    {
        String teclado;
        Produto PD = new Produto();
        Scanner j = new Scanner(System.in);
        
        System.out.println("Informe por gentileza as informações solicitadas:");
        
        PD.setNomeAP(nomeAP);
        
        System.out.println("\nInforme o nome do produto:");
        teclado = j.next();
        PD.setNomePD(teclado);    
        
        System.out.println("\nInforme a categoria:\n1. Perecivel"
                  + "\n2. Nao perecivel");
        teclado = j.next();
        PD.setCategoria(teclado);   
        
        System.out.println("\nInforme o valor:");
        teclado = j.next();
        PD.setValor(Float.parseFloat(teclado)); 
        
        System.out.println("\nInforme a quantidade disponivel:");
        teclado = j.next();
        PD.setQuant(Integer.parseInt(teclado));
        
        produtos.add(PD);
        System.out.println("\nSeu produto foi cadastrado com sucesso!!!");
        
        return PD;
    }
    
    public static void EditarM(String email)
    {
        Merceeiro m = pesquisarM(email);
        String teclado;
        int op;
        int indice = merceeiros.indexOf(m);
        if(m != null)
        {
            do
            {
                teclado = JOptionPane.showInputDialog("O que deseja editar?\n1- Razão Social\n2- Nome\n3- Endereço"
                + "\n4- Telefone\n5- Email\n6- Senha");
            op = Integer.parseInt(teclado);
            switch(op)
            {
                case 1:
                    teclado = JOptionPane.showInputDialog("Informe a nova razão social:");
                    m.setRazao_Social(teclado);
                    merceeiros.set(indice, m);
                    break;
                case 2:
                    teclado = JOptionPane.showInputDialog("Informe o novo nome:");
                    m.setNomeM(teclado);
                    merceeiros.set(indice, m);
                    break;
                case 3:
                    teclado = JOptionPane.showInputDialog("Informe o novo endereço:");
                    m.setEndereço(teclado);
                    merceeiros.set(indice, m);
                    break;
                case 4:
                    teclado = JOptionPane.showInputDialog("Informe o novo telefone:");
                    m.setTelefone(teclado);
                    merceeiros.set(indice, m);
                    break;
                case 5:
                    teclado = JOptionPane.showInputDialog("Informe o novo email:");
                    m.setEmail(teclado);
                    merceeiros.set(indice, m);
                    break;
                case 6:
                    teclado = JOptionPane.showInputDialog("Informe a nova senha:");
                    m.setSenha(teclado);
                    merceeiros.set(indice, m);
                    break;
                default:
                    System.out.println("Opção inválida!!!");
            }
            }while(op<1 && op>6);
        }
        else
        {
            System.out.println("Conta inexistente!");
        }
        return;
    }
      
    public static void EditarAP(String email)
    {
        Agropecuario ap = pesquisarAP(email);
        String teclado;
        int op;
        int indice = agropecuarios.indexOf(ap);
        if(ap != null)
        {
            do
            {
                teclado = JOptionPane.showInputDialog("O que deseja editar?\n1- Razão Social\n2- Nome\n3- Endereço"
                + "\n4- Telefone\n5- Email\n6- Senha\n7- Atividade");
            op = Integer.parseInt(teclado);
            switch(op)
            {
                case 1:
                    teclado = JOptionPane.showInputDialog("Informe a nova razão social:");
                    ap.setRazao_Social(teclado);
                    agropecuarios.set(indice, ap);
                    break;
                case 2:
                    teclado = JOptionPane.showInputDialog("Informe o novo nome:");
                    ap.setNomeAP(teclado);
                    agropecuarios.set(indice, ap);
                    break;
                case 3:
                    teclado = JOptionPane.showInputDialog("Informe o novo endereço:");
                    ap.setEndereço(teclado);
                    agropecuarios.set(indice, ap);
                    break;
                case 4:
                    teclado = JOptionPane.showInputDialog("Informe o novo telefone:");
                    ap.setTelefone(teclado);
                    agropecuarios.set(indice, ap);
                    break;
                case 5:
                    teclado = JOptionPane.showInputDialog("Informe o novo email:");
                    ap.setEmail(teclado);
                    agropecuarios.set(indice, ap);
                    break;
                case 6:
                    teclado = JOptionPane.showInputDialog("Informe a nova senha:");
                    ap.setSenha(teclado);
                    agropecuarios.set(indice, ap);
                    break;
                case 7:
                    teclado = JOptionPane.showInputDialog("Informe a nova atividade:");
                    ap.setAtividade(teclado);
                    agropecuarios.set(indice, ap);
                default:
                    System.out.println("Opção inválida!!!");
            }
            }while(op<0 && op>7);
            
        }
        else
        {
            System.out.println("Conta inexistente!");
        }
        return;
    }
    
    public static void AumentarQuant(Produto PD)
    {
        String teclado;
        Scanner j = new Scanner(System.in);
        int aq;
        
        if(PD != null)
        {
            System.out.println("Deseja acrescentar quantos:");
            teclado = j.next();
            aq = PD.getQuant() + Integer.parseInt(teclado);
            PD.setQuant(aq);
        }
        else
        {
            System.out.println("Produto inexistente");
        }
            
    }
    
    public static void ApagarM(String email)
    {
        Merceeiro m = pesquisarM(email);
        if(m!=null)
        {
            merceeiros.remove(m);
        }
        else
        {
            System.out.println("Conta inexistente!!!");
        }
        return;
    }
    
    public static void ApagarAP(String email,Produto PD)
    {
        Agropecuario ap = pesquisarAP(email);
        for(Produto c: produtos)
        {
            if(PD.equals(c))
            {
                produtos.remove(PD);
            }
            else
            {
                System.out.println("Produto inexistente");
            }
        }
        
        if(ap!=null)
        {
            agropecuarios.remove(ap);
        }
        else
        {
            System.out.println("Conta inexistente!!!");
        }
        return;
    }
    
    public static void ApagarPD(Produto PD)
    {
        for(Produto c: produtos)
        {
            if(PD.equals(c))
            {
                produtos.remove(PD);
            }
            else
            {
                System.out.println("Produto inexistente");
            }
        }
        return;
    }
    
    public static Merceeiro pesquisarM(String email)
    {
        Merceeiro m = null;
        
        for(Merceeiro c: merceeiros)
        {
            if(c.getEmail().equals(email))
            {
                m = c;
            }
        }
        
        return m;
    }
        
    public static Agropecuario pesquisarAP(String email)
    {
        Agropecuario m = null;
        
        for(Agropecuario c: agropecuarios)
        {
            if(c.getEmail().equals(email))
            {
                m = c;
            }
        }
        
        return m;
    }
    
    public static Produto pesquisarPD(String nome) {
        Produto produto = null;

        for (Produto c : produtos) 
        {
            if (c.getNomePD().equals(nome)) 
            {
                produto = c;
            }
        }
        
        return produto;
    }
    
    public static Produto pesquisarAPtPD(String nomeAP) // pesquisar se agropecuario tem produto
    {
       Produto pd = null;
       
       for(Produto p: produtos)
       {
           if(p.getNomeAP().equals(nomeAP))
           {
               pd = p;
           }
       }
       
       return pd;
    }
}